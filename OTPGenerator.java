import java.util.HashSet;

public class OTPGenerator {

    // Method to generate a 6-digit OTP using Math.random()
    public static int generateOTP() {
        return 100000 + (int)(Math.random() * 900000); // Generates a random number between 100000 and 999999
    }

    // Method to ensure OTPs are unique
    public static boolean areOTPsUnique(int[] otps) {
        HashSet<Integer> uniqueSet = new HashSet<>();
        for (int otp : otps) {
            if (!uniqueSet.add(otp)) {
                return false; // Duplicate found
            }
        }
        return true; // All OTPs are unique
    }

    public static void main(String[] args) {
        int[] otpArray = new int[10];

        // Generate 10 OTPs
        for (int i = 0; i < 10; i++) {
            otpArray[i] = generateOTP();
        }

        // Display generated OTPs
        System.out.println("Generated OTPs: ");
        for (int otp : otpArray) {
            System.out.println(otp);
        }

        // Validate uniqueness
        boolean isUnique = areOTPsUnique(otpArray);

        if (isUnique) {
            System.out.println("All OTPs are unique!");
        } else {
            System.out.println("Duplicate OTPs found!");
        }
    }
}
