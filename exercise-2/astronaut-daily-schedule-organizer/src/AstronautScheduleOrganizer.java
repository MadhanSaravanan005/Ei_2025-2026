import exception.InvalidTimeFormatException;
import exception.TaskConflictException;
import exception.TaskNotFoundException;
import exception.DuplicateTaskException;
import factory.TaskFactory;
import model.Task;
import observer.TaskConflictObserver;
import service.ScheduleManager;
import logger.ApplicationLogger;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

enum ApplicationState {
    INITIALIZING,
    RUNNING,
    SHUTTING_DOWN,
    STOPPED
}

public class AstronautScheduleOrganizer {
    private static final ScheduleManager scheduleManager = ScheduleManager.getInstance();
    private static final Scanner scanner = new Scanner(System.in);
    private static ApplicationState currentState = ApplicationState.INITIALIZING;
    private static final ApplicationLogger logger = ApplicationLogger.getInstance();

    public static void main(String[] args) {
        initializeApplication();
        runApplication();
        shutdownApplication();
    }
    
    private static void initializeApplication() {
        currentState = ApplicationState.INITIALIZING;
        logger.info("Initializing Astronaut Daily Schedule Organizer...");
        
        TaskConflictObserver observer = new TaskConflictObserver();
        scheduleManager.addObserver(observer);
        System.out.println("=== Astronaut Daily Schedule Organizer ===");
        
        currentState = ApplicationState.RUNNING;
        logger.info("Application initialized successfully and ready for use.");
    }
    
    private static void runApplication() {
        while (isApplicationRunning()) {
            try {
                showMenu();
                int choice = getUserChoice();
                handleUserChoice(choice);
                
                if (currentState == ApplicationState.SHUTTING_DOWN) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] Invalid input type: " + e.getMessage());
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
    
    private static void shutdownApplication() {
        if (currentState != ApplicationState.SHUTTING_DOWN) {
            currentState = ApplicationState.SHUTTING_DOWN;
        }
        
        logger.info("Shutting down application...");
        scanner.close();
        System.out.println("Thank you for using Astronaut Schedule Organizer!");
        
        currentState = ApplicationState.STOPPED;
        logger.info("Application stopped successfully.");
        logger.close();
    }
    
    private static boolean isApplicationRunning() {
        return currentState == ApplicationState.RUNNING;
    }
    
    private static void requestApplicationShutdown() {
        logger.info("Shutdown requested by user.");
        currentState = ApplicationState.SHUTTING_DOWN;
    }

    private static void showMenu() {
        System.out.println("\nAstronaut Daily Schedule Organizer");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. View All Tasks (sorted by priority)");
        System.out.println("4. Edit Task");
        System.out.println("5. Mark Task as Completed");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    private static int getUserChoice() {
        return scanner.nextInt();
    }

    private static void handleUserChoice(int choice) {
        scanner.nextLine();
        switch (choice) {
            case 1:
                addTask();
                break;
            case 2:
                removeTask();
                break;
            case 3:
                viewTasks();
                break;
            case 4:
                editTask();
                break;
            case 5:
                markTaskAsCompleted();
                break;
            case 6:
                System.out.println("[INFO] Exiting application.");
                requestApplicationShutdown();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    private static void addTask() {
        String description = "";
        try {
            description = getUserInput("Enter description: ");
            String startTime = getUserInput("Enter start time (HHMM): ");
            String endTime = getUserInput("Enter end time (HHMM): ");
            String priority = getUserInput("Enter priority (HIGH/MEDIUM/LOW): ");

            if (!isValidPriority(priority)) {
                System.out.println("[ERROR] Invalid priority. Please use HIGH, MEDIUM, or LOW.");
                logger.warn("Invalid priority entered: " + priority);
                return;
            }

            if (isValidTime(startTime, endTime)) {
                Task task = TaskFactory.createTask(description, startTime, endTime, priority.toUpperCase());
                scheduleManager.addTask(task);
                System.out.println("Task added successfully. No conflicts.");
                logger.info("Task added successfully: " + task.getDescription() + " [" + task.getPriorityString() + "] " + 
                           task.getStartTime() + "-" + task.getEndTime());
            }
        } catch (InvalidTimeFormatException | TaskConflictException | DuplicateTaskException | IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            logger.error("Failed to add task: " + description, e);
        }
    }

    private static void editTask() {
        String oldDescription = "";
        try {
            oldDescription = getUserInput("Enter description of task to edit: ");
            
            if (!scheduleManager.taskExists(oldDescription)) {
                System.out.println("[ERROR] Task not found: " + oldDescription);
                logger.warn("Attempted to edit non-existent task: " + oldDescription);
                return;
            }
            
            System.out.println("Enter new task details:");
            String newDescription = getUserInput("Enter new description: ");
            String newStartTime = getUserInput("Enter new start time (HHMM): ");
            String newEndTime = getUserInput("Enter new end time (HHMM): ");
            String newPriority = getUserInput("Enter new priority (HIGH/MEDIUM/LOW): ");

            if (!isValidPriority(newPriority)) {
                System.out.println("[ERROR] Invalid priority. Please use HIGH, MEDIUM, or LOW.");
                logger.warn("Invalid priority entered during edit: " + newPriority);
                return;
            }

            if (isValidTime(newStartTime, newEndTime)) {
                scheduleManager.editTask(oldDescription, newDescription, newStartTime, newEndTime, newPriority.toUpperCase());
                System.out.println("Task edited successfully.");
                logger.info("Task edited successfully: " + oldDescription + " -> " + newDescription);
            }
        } catch (InvalidTimeFormatException | TaskConflictException | TaskNotFoundException | DuplicateTaskException | IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            logger.error("Failed to edit task: " + oldDescription, e);
        }
    }

    private static void removeTask() {
        try {
            String description = getUserInput("Enter description of task to remove: ");
            scheduleManager.removeTask(description);
            System.out.println("Task removed successfully.");
        } catch (TaskNotFoundException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private static void viewTasks() {
        List<String> tasks = scheduleManager.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            System.out.println("\nScheduled Tasks (sorted by priority, then by time):");
            System.out.println("====================================================");
            tasks.forEach(System.out::println);
        }
    }

    private static void markTaskAsCompleted() {
        try {
            String description = getUserInput("Enter description of task: ");
            scheduleManager.markTaskAsCompleted(description);
            System.out.println("Task marked as completed.");
        } catch (TaskNotFoundException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private static String getUserInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        
        if (input == null || input.trim().isEmpty()) {
            System.out.println("[WARNING] Input cannot be empty. Please try again.");
            return getUserInput(prompt);
        }
        
        return input.trim();
    }

    private static boolean isValidTime(String startTime, String endTime) throws InvalidTimeFormatException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
        try {
            LocalTime.parse(startTime, formatter);
            LocalTime.parse(endTime, formatter);
            return true;
        } catch (DateTimeParseException e) {
            throw new InvalidTimeFormatException("Invalid Time Format. Please use HHMM format.");
        }
    }

    private static boolean isValidPriority(String priority) {
        if (priority == null || priority.trim().isEmpty()) return false;
        try {
            model.Priority.valueOf(priority.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}