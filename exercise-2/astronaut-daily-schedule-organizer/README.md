# Astronaut Daily Schedule Organizer

## Project Description

The Astronaut Daily Schedule Organizer is a console-based application designed to help astronauts manage their daily tasks efficiently. It allows users to add, remove, view, and manage tasks while ensuring no scheduling conflicts.

## Features

- **Add a New Task**: Add tasks with a description, start time, end time, and priority level.
- **Remove a Task**: Remove an existing task by its description.
- **View All Tasks**: Display all tasks sorted by priority and then by start time.
- **Validate Tasks**: Ensure new tasks do not overlap with existing ones.
- **Edit a Task**: Modify the details of an existing task.
- **Mark Task as Completed**: Mark tasks as done.

## Additional Features

- **Logging**: Generates a timestamped log file on each run for debugging and audit purposes. Log messages are written to file only, keeping the console clean for user interaction.

- **Pure Java**: Implemented without external dependencies to keep the setup simple.

## Design Patterns Used

- **Singleton Pattern**: Ensures a single instance of the ScheduleManager class that manages all tasks.
- **Factory Pattern**: TaskFactory class to create task objects.
- **Observer Pattern**: ObserverManager alerts users of task conflicts.

## Setup Instructions

### Prerequisites

Ensure you have the following installed on your machine:

- Java 8+
- Git

### Clone the Repository
```bash
git clone https://github.com/MadhanSaravanan005/Ei_2025-2026.git
```
### Navigate to the  current   project directory
```bash
cd exercise-2/astronaut-daily-schedule-organizer/src
```

### Execute the Application

Compile and run the program:

```bash
javac -cp . AstronautScheduleOrganizer.java
java -cp . AstronautScheduleOrganizer
```

## Sample Input and Output

### Application Menu
```
Astronaut Daily Schedule Organizer
1. Add Task
2. Remove Task
3. View All Tasks (sorted by priority)
4. Edit Task
5. Mark Task as Completed
6. Exit
Choose an option: 
```

### Sample Session
```
Choose an option: 1
Enter description: Mission briefing
Enter start time (HHMM): 0800
Enter end time (HHMM): 0900
Enter priority (HIGH/MEDIUM/LOW): HIGH
Task added successfully. No conflicts.

Choose an option: 1
Enter description: Equipment maintenance
Enter start time (HHMM): 1000
Enter end time (HHMM): 1100
Enter priority (HIGH/MEDIUM/LOW): MEDIUM
Task added successfully. No conflicts.


Choose an option: 3
Scheduled Tasks (sorted by priority, then by time):
====================================================
08:00 - 09:00: Mission briefing [HIGH]
10:00 - 11:00: Equipment maintenance [MEDIUM]
19:00 - 20:00: Personal time [LOW]

Choose an option: 5
Enter description of task: Equipment maintenance
Task marked as completed.

Choose an option: 3
Scheduled Tasks (sorted by priority, then by time):
====================================================
08:00 - 09:00: Mission briefing [HIGH]
10:00 - 11:00: Equipment maintenance [MEDIUM] [COMPLETED]
19:00 - 20:00: Personal time [LOW]

Choose an option: 1
Enter description: Overlapping task
Enter start time (HHMM): 0830
Enter end time (HHMM): 0930
Enter priority (HIGH/MEDIUM/LOW): HIGH
[ERROR] Error: Task conflicts with existing task Mission briefing

Choose an option: 6
[INFO] Exiting application.
Thank you for using Astronaut Schedule Organizer!
```
