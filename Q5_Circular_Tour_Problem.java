import java.util.*;

class PetrolPump {
    int petrol, distance;
    public PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

class CircularTour {
    public int findStartingPoint(PetrolPump[] pumps) {
        int start = 0, deficit = 0, surplus = 0;
        for (int i = 0; i < pumps.length; i++) {
            surplus += pumps[i].petrol - pumps[i].distance;
            if (surplus < 0) {
                start = i + 1;
                deficit += surplus;
                surplus = 0;
            }
        }
        return (surplus + deficit >= 0) ? start : -1;
    }
}

public class Q5_Circular_Tour_Problem {
    public static void main(String[] args) {
        PetrolPump[] pumps = { new PetrolPump(4, 6), new PetrolPump(6, 5), new PetrolPump(7, 3), new PetrolPump(4, 5) };
        CircularTour ct = new CircularTour();
        int start = ct.findStartingPoint(pumps);
        System.out.println(start);
    }
}
