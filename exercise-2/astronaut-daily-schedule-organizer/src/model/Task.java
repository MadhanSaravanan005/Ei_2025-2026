package model;

import exception.InvalidTimeFormatException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Task {
    private String description;        
    private LocalTime startTime;       
    private LocalTime endTime;         
    private Priority priority;         
    private boolean isCompleted;

    private static final DateTimeFormatter MILITARY_TIME_FORMATTER = DateTimeFormatter.ofPattern("HHmm");

    public Task(String description, String startTime, String endTime, String priority) throws InvalidTimeFormatException {
      
        if (description == null || description.trim().isEmpty()) {
            throw new InvalidTimeFormatException("Task description cannot be null or empty");
        }
        
        
        if (startTime == null || endTime == null || priority == null) {
            throw new InvalidTimeFormatException("Time values and priority cannot be null");
        }
        
        try {
            this.description = description.trim();
            this.startTime = LocalTime.parse(startTime, MILITARY_TIME_FORMATTER);
            this.endTime = LocalTime.parse(endTime, MILITARY_TIME_FORMATTER);
            
            
            if (!this.endTime.isAfter(this.startTime)) {
                throw new InvalidTimeFormatException("End time must be after start time");
            }
            
            
            try {
                this.priority = Priority.valueOf(priority.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new InvalidTimeFormatException("Invalid priority. Must be HIGH, MEDIUM, or LOW");
            }
            
            this.isCompleted = false;
        } catch (DateTimeParseException e) {
            throw new InvalidTimeFormatException("Time should be in HHmm format (e.g., 0900, 1430)");
        }
    }

    public String getDescription() { return description; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public Priority getPriority() { return priority; }  
    public String getPriorityString() { return priority.toString(); }  
    public int getPriorityLevel() { return priority.getLevel(); }  
    public String getPriorityDescription() { return priority.getDescription(); }  
    public boolean isCompleted() { return isCompleted; }
    
   
    public void setDescription(String description) { this.description = description; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }
    public void setPriority(Priority priority) { this.priority = priority; }
    public void setCompleted(boolean completed) { isCompleted = completed; }

    @Override
    public String toString() {
        return startTime + " - " + endTime + ": " + description + " [" + priority.toString() + "]" +
               (isCompleted ? " [COMPLETED]" : "");
    }
}
