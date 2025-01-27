public class SpringSeason {

    public static void main(String[] args) {
        // Parse the month and day from the command line arguments
        if (args.length < 2) {
            System.out.println("Please provide both month and day as command line arguments.");
            return;
        }

        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        // Check if it's a Spring Season
        boolean isSpring = isSpringSeason(month, day);

        // Print the result
        if (isSpring) {
            System.out.println("It's a Spring Season.");
        } else {
            System.out.println("Not a Spring Season.");
        }
    }

    // Method to check if the given month and day fall within Spring Season
    public static boolean isSpringSeason(int month, int day) {
        if (month == 3 && day >= 20 && day <= 31) { // March 20 to March 31
            return true;
        } else if (month == 4 && day >= 1 && day <= 30) { // April
            return true;
        } else if (month == 5 && day >= 1 && day <= 31) { // May
            return true;
        } else if (month == 6 && day >= 1 && day <= 20) { // June 1 to June 20
            return true;
        } else {
            return false;
        }
    }
}
