public class LineAndDistance {

    // Method to calculate the Euclidean distance between two points
    public static double findEuclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Method to find the equation of the line (slope and y-intercept) given two points
    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double slope, yIntercept;

        // Check if the line is vertical (to avoid division by zero)
        if (x2 == x1) {
            throw new IllegalArgumentException("The line is vertical, slope is undefined!");
        }

        // Compute the slope
        slope = (y2 - y1) / (x2 - x1);

        // Compute the y-intercept
        yIntercept = y1 - slope * x1;

        // Return the slope and y-intercept as an array
        return new double[] { slope, yIntercept };
    }

    public static void main(String[] args) {
        // Example input points
        double x1 = 2, y1 = 3;
        double x2 = 6, y2 = 7;

        // Calculate Euclidean distance
        double distance = findEuclideanDistance(x1, y1, x2, y2);
        System.out.printf("Euclidean Distance: %.2f\n", distance);

        try {
            // Calculate slope and y-intercept
            double[] lineEquation = findLineEquation(x1, y1, x2, y2);
            System.out.printf("Equation of the Line: y = %.2f*x + %.2f\n", lineEquation[0], lineEquation[1]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
