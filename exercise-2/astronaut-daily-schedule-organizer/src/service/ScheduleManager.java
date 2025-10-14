package service;

import exception.InvalidTimeFormatException;
import exception.TaskConflictException;
import exception.TaskNotFoundException;
import exception.DuplicateTaskException;
import model.Task;
import factory.TaskFactory;
import observer.Observer;
import observer.ObserverManager;

import java.util.*;
import java.util.stream.Collectors;

public class ScheduleManager {
    private static ScheduleManager instance;
    private final List<Task> taskList;
    private final Map<String, Task> taskMap;
    private final ObserverManager observerManager;
    
    private ScheduleManager() {
        taskList = new ArrayList<>();
        taskMap = new HashMap<>();
        observerManager = new ObserverManager();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            synchronized (ScheduleManager.class) {
                if (instance == null) {
                    instance = new ScheduleManager();
                }
            }
        }
        return instance;
    }

    public void addTask(Task task) throws TaskConflictException, InvalidTimeFormatException, DuplicateTaskException {
        // Check for duplicate description
        if (taskMap.containsKey(task.getDescription())) {
            throw new DuplicateTaskException("Error: Task with description '" + task.getDescription() + "' already exists. Please use a different description.");
        }
        
        if (task.getStartTime().isAfter(task.getEndTime())) {
            throw new InvalidTimeFormatException("Error: Invalid time format");
        }
        
        for (Task existingTask : taskList) {
            if (isTimeConflict(existingTask, task)) {
                observerManager.notifyObservers(existingTask, task);
                throw new TaskConflictException("Error: Task conflicts with existing task " + existingTask.getDescription());
            }
        }
        
        taskList.add(task);
        taskMap.put(task.getDescription(), task);
    }

    public void removeTask(String description) throws TaskNotFoundException {
        Task taskToRemove = taskMap.get(description);
        
        if (taskToRemove == null) {
            throw new TaskNotFoundException("Task not found");
        }
        
        taskList.remove(taskToRemove);
        taskMap.remove(description);
    }

    public void markTaskAsCompleted(String description) throws TaskNotFoundException {
        Task task = taskMap.get(description);
        
        if (task == null) {
            throw new TaskNotFoundException("Task not found");
        }
        
        task.setCompleted(true);
    }

    public List<String> getTasks() {
        taskList.sort(Comparator.comparing((Task task) -> task.getPriority().getLevel()).reversed()
                     .thenComparing(Task::getStartTime));
        
        return taskList.stream()
                .map(task -> {
                    StringBuilder taskInfo = new StringBuilder();
                    taskInfo.append(task.getStartTime())
                           .append(" - ")
                           .append(task.getEndTime())
                           .append(": ")
                           .append(task.getDescription())
                           .append(" [")
                           .append(task.getPriorityString())
                           .append("]");
                    if (task.isCompleted()) {
                        taskInfo.append(" [COMPLETED]");
                    }
                    return taskInfo.toString();
                })
                .collect(Collectors.toList());
    }

    public void addObserver(Observer observer) {
        observerManager.addObserver(observer);
    }

    public List<String> getTasksSortedByPriority() {
        List<Task> sortedTasks = new ArrayList<>(taskList);
        sortedTasks.sort(Comparator.comparing((Task task) -> task.getPriority().getLevel()).reversed());
        
        return sortedTasks.stream()
                .map(task -> {
                    StringBuilder taskInfo = new StringBuilder();
                    taskInfo.append("[").append(task.getPriorityString()).append("] ")
                           .append(task.getStartTime())
                           .append(" - ")
                           .append(task.getEndTime())
                           .append(": ")
                           .append(task.getDescription());
                    if (task.isCompleted()) {
                        taskInfo.append(" [COMPLETED]");
                    }
                    return taskInfo.toString();
                })
                .collect(Collectors.toList());
    }

    public boolean taskExists(String description) {
        return taskMap.containsKey(description);
    }
    
    public void editTask(String oldDescription, String newDescription, String newStartTime, String newEndTime, String newPriority) 
            throws TaskNotFoundException, TaskConflictException, InvalidTimeFormatException, DuplicateTaskException {
        
        Task existingTask = taskMap.get(oldDescription);
        if (existingTask == null) {
            throw new TaskNotFoundException("Task not found");
        }
        
        // Check for duplicate new description
        if (!oldDescription.equals(newDescription) && taskMap.containsKey(newDescription)) {
            throw new DuplicateTaskException("Error: Task with description '" + newDescription + "' already exists. Please use a different description.");
        }
        
        Task tempTask = TaskFactory.createTask(newDescription, newStartTime, newEndTime, newPriority);
        
        taskList.remove(existingTask);
        taskMap.remove(oldDescription);
        
        for (Task task : taskList) {
            if (isTimeConflict(task, tempTask)) {
                taskList.add(existingTask);
                taskMap.put(oldDescription, existingTask);
                observerManager.notifyObservers(tempTask, task);
                throw new TaskConflictException("Error: Task conflicts with existing task " + task.getDescription());
            }
        }
        
        existingTask.setDescription(newDescription);
        existingTask.setStartTime(tempTask.getStartTime());
        existingTask.setEndTime(tempTask.getEndTime());
        existingTask.setPriority(tempTask.getPriority());
        
        taskList.add(existingTask);
        taskMap.put(newDescription, existingTask);
    }

    private boolean isTimeConflict(Task existingTask, Task newTask) {
        return existingTask.getStartTime().isBefore(newTask.getEndTime()) &&
                newTask.getStartTime().isBefore(existingTask.getEndTime());
    }
}