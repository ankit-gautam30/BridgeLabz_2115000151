import java.util.*;

public class HospitalTriageSystem {
    public static void main(String[] args) {
        PriorityQueue<Patient> queue = new PriorityQueue<>(Comparator.comparingInt(Patient::getSeverity).reversed());
        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));
        
        while (!queue.isEmpty()) {
            System.out.println(queue.poll().getName());
        }
    }
}

class Patient {
    private String name;
    private int severity;
    
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
    
    public String getName() {
        return name;
    }
    
    public int getSeverity() {
        return severity;
    }
}
