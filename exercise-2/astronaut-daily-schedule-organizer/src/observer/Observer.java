package observer;

import model.Task;

public interface Observer {
    void update(Task newTask, Task existingTask);
}