// Task Scheduler using Circular Linked List

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    // Constructor
    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head;
    private Task tail;
    private Task currentTask;

    // Add a task at the beginning
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head; // Circular connection
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    // Add a task at the end
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    // Add a task at a specific position
    public void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        newTask.next = temp.next;
        temp.next = newTask;
        if (temp == tail) {
            tail = newTask;
        }
    }

    // Remove a task by Task ID
    public void removeTask(int taskId) {
        if (head == null) {
            System.out.println("No tasks available!");
            return;
        }
        Task temp = head, prev = null;
        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    prev.next = head;
                    tail = prev;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Task not found!");
    }

    // View the current task and move to the next
    public void viewNextTask() {
        if (currentTask == null) {
            currentTask = head;
        }
        System.out.println("Current Task: " + currentTask.taskName + " (Priority: " + currentTask.priority + ") Due: " + currentTask.dueDate);
        currentTask = currentTask.next;
    }

    // Display all tasks
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + " | Name: " + temp.taskName + " | Priority: " + temp.priority + " | Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for tasks by priority
    public void searchByPriority(int priority) {
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task: " + temp.taskName + " (Due: " + temp.dueDate + ")");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No tasks found with priority " + priority);
    }
}

public class Q3_Task_Schedular {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        
        // Adding tasks
        scheduler.addAtBeginning(1, "Complete report", 2, "2024-02-15");
        scheduler.addAtEnd(2, "Prepare slides", 1, "2024-02-20");
        scheduler.addAtPosition(3, "Review code", 3, "2024-02-18", 2);
        
        // Displaying tasks
        System.out.println("All tasks:");
        scheduler.displayTasks();
        
        // Viewing and cycling through tasks
        scheduler.viewNextTask();
        scheduler.viewNextTask();
        
        // Searching for tasks by priority
        scheduler.searchByPriority(2);
        
        // Removing a task
        scheduler.removeTask(3);
        
        // Display updated tasks
        System.out.println("Updated tasks:");
        scheduler.displayTasks();
    }
}
