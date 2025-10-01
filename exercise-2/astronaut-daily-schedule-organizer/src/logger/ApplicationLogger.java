package logger;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ApplicationLogger {
    private static ApplicationLogger instance;
    private static final String LOG_FILE = "astronaut_schedule.log";
    private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public enum LogLevel {
        INFO("INFO"),
        WARN("WARN"),
        ERROR("ERROR"),
        DEBUG("DEBUG");
        
        private final String level;
        
        LogLevel(String level) {
            this.level = level;
        }
        
        @Override
        public String toString() {
            return level;
        }
    }
    
    private ApplicationLogger() {
       
        try {
            writeToFile("=== Astronaut Schedule Organizer Started ===");
        } catch (IOException e) {
            System.err.println("Warning: Could not initialize log file: " + e.getMessage());
        }
    }
    
    public static ApplicationLogger getInstance() {
        if (instance == null) {
            synchronized (ApplicationLogger.class) {
                if (instance == null) {
                    instance = new ApplicationLogger();
                }
            }
        }
        return instance;
    }
    
    public void log(LogLevel level, String message) {
        String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
        String logEntry = String.format("[%s] %s: %s", timestamp, level, message);
       
        try {
            writeToFile(logEntry);
        } catch (IOException e) {
            System.err.println("Warning: Could not write to log file: " + e.getMessage());
        }
    }
    
    public void info(String message) {
        log(LogLevel.INFO, message);
    }
    
    public void warn(String message) {
        log(LogLevel.WARN, message);
    }
    
    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
    
    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }
    
    public void error(String message, Exception e) {
        String errorMessage = message + " - Exception: " + e.getMessage();
        log(LogLevel.ERROR, errorMessage);
    }
    
    private void writeToFile(String message) throws IOException {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(message + System.lineSeparator());
        }
    }
    
    public void close() {
        try {
            writeToFile("=== Astronaut Schedule Organizer Ended ===");
        } catch (IOException e) {
            System.err.println("Warning: Could not write final log entry: " + e.getMessage());
        }
    }
}