abstract class Vehicle {
	private int vehicleNumber;
	private String type;
	private double rentalRate;

	public Vehicle (int vehicleNumber, String type, double rentalRate) {
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.rentalRate = rentalRate;
	}
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public String getType() {
		return type;
	}
	public double getRentalRate() {
		return rentalRate;
	}
	public abstract double calculateRentalCost(int days);
}
interface Insurable {
	double calculateInsurance();
	String getInsuranceDetails();
}
class Car extends Vehicle implements Insurable {
	public Car(int vehicleNumber,String type, double rentalRate) {
		super(vehicleNumber,type,rentalRate);
	}
	@Override
	public double calculateRentalCost(int days) {
		return getRentalRate() * days;
	}
	@Override
	public double calculateInsurance() {
		return getRentalRate() * 0.05;
	}
	@Override
	public String getInsuranceDetails() {
		return "Car Insurance: 5% of rental rate";
	}
}
class Bike extends Vehicle implements Insurable {
        public Bike(int vehicleNumber,String type, double rentalRate) {
                super(vehicleNumber,type,rentalRate);
        }
        @Override
        public double calculateRentalCost(int days) {
                return getRentalRate() * days;
        }
        @Override
        public double calculateInsurance() {
                return getRentalRate() * 0.03;
        }
        @Override
        public String getInsuranceDetails() {
                return "Bike Insurance: 3% of rental rate";
        }
}
class Truck extends Vehicle implements Insurable {
        public Truck(int vehicleNumber,String type, double rentalRate) {
                super(vehicleNumber,type,rentalRate);
        }
        @Override
        public double calculateRentalCost(int days) {
                return getRentalRate() * days * 1.2;
        }
        @Override
        public double calculateInsurance() {
                return getRentalRate() * 0.10;
        }
        @Override
        public String getInsuranceDetails() {
                return "Truck Insurance: 10% of rental rate";
        }
}
public class Q3_Vehicle_Rental_System {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car(1456,"4 wheeler" ,50);
        vehicles[1] = new Bike(2456,"2 wheeler" ,20);
        vehicles[2] = new Truck(1789,"6 wheeler", 100);

        for (Vehicle vehicle : vehicles) {
            int rentalDays = 5;
            double finalCost = vehicle.calculateRentalCost(rentalDays);
            System.out.println("Vehicle: " + vehicle.getType() + " (" + vehicle.getVehicleNumber() + "), Final Rental Cost for " + rentalDays + " days: " + finalCost);
            if (vehicle instanceof Insurable) {
                System.out.println(((Insurable) vehicle).getInsuranceDetails());
            }
            System.out.println("---------------------------");
        }
    }
}


