package factory;

import exception.InvalidTimeFormatException;
import model.Task;

public class TaskFactory {
    public static Task createTask(String description, String startTime, String endTime, String priority) 
            throws InvalidTimeFormatException {
        return new Task(description, startTime, endTime, priority);
    }
}
