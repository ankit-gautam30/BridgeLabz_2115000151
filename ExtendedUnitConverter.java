public class ExtendedUnitConverter {

    // Method to convert yards to feet
    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }

    // Method to convert feet to yards
    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    // Method to convert meters to inches
    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    // Method to convert inches to meters
    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    // Method to convert inches to centimeters
    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

    public static void main(String[] args) {
        // Testing the ExtendedUnitConverter methods
        double yards = 5.0;
        double feet = 15.0;
        double meters = 2.0;
        double inches = 12.0;

        System.out.println(yards + " yards is " + convertYardsToFeet(yards) + " feet.");
        System.out.println(feet + " feet is " + convertFeetToYards(feet) + " yards.");
        System.out.println(meters + " meters is " + convertMetersToInches(meters) + " inches.");
        System.out.println(inches + " inches is " + convertInchesToMeters(inches) + " meters.");
        System.out.println(inches + " inches is " + convertInchesToCentimeters(inches) + " centimeters.");
    }
}
