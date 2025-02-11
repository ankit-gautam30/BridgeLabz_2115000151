class Process {
    int processID, burstTime, priority;
    Process next;

    public Process(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head, tail;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
        this.head = this.tail = null;
    }

    public void addProcess(int processID, int burstTime, int priority) {
        Process newProcess = new Process(processID, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
    }

    public void executeProcesses() {
        if (head == null) return;
        Process current = head;
        int totalTime = 0, totalWaitingTime = 0, totalTurnAroundTime = 0, count = 0;
        while (true) {
            if (current.burstTime > 0) {
                int executedTime = Math.min(timeQuantum, current.burstTime);
                totalTime += executedTime;
                current.burstTime -= executedTime;
                if (current.burstTime == 0) {
                    totalTurnAroundTime += totalTime;
                    totalWaitingTime += totalTime - executedTime;
                    removeProcess(current.processID);
                }
            }
            current = current.next;
            if (current == head) count++;
            if (head == null || count > 100) break;
        }
        System.out.println("Average Waiting Time: " + (totalWaitingTime / (double) count));
        System.out.println("Average Turnaround Time: " + (totalTurnAroundTime / (double) count));
    }

    private void removeProcess(int processID) {
        if (head == null) return;
        Process current = head, prev = null;
        while (current.processID != processID) {
            prev = current;
            current = current.next;
            if (current == head) return;
        }
        if (current == head) {
            head = head.next;
            tail.next = head;
        } else if (current == tail) {
            tail = prev;
            tail.next = head;
        } else {
            prev.next = current.next;
        }
    }

    public void displayProcesses() {
        if (head == null) return;
        Process temp = head;
        do {
            System.out.println(temp.processID + " | " + temp.burstTime + " | " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

public class Q6_Round_Robin_Scheduling {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4);
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        scheduler.executeProcesses();
    }
}
