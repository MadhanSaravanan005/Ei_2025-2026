package observer;

import model.Task;

public class TaskConflictObserver implements Observer {
    @Override
    public void update(Task newTask, Task existingTask) {
        System.out.println("Conflict detected: " + newTask.getDescription() + " conflicts with " + existingTask.getDescription());
    }
}