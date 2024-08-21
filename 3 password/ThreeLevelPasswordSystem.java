import java.util.Scanner;

public class ThreeLevelPasswordSystem {

    // Sample credentials for demonstration
    private static final String USERNAME = "ramcharan";
    private static final String PASSWORD = "sarely@123";
    private static final String PIN = "1234";
    private static final String SECURITY_QUESTION = "Who is your favourite actor?";
    private static final String SECURITY_ANSWER = "Ranbir kapoor";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Level 1: Username and Password
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authenticateUsernamePassword(username, password)) {
            System.out.println("Level 1 authentication successful.");

            // Level 2: PIN Code
            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();

            if (authenticatePin(pin)) {
                System.out.println("Level 2 authentication successful.");

                // Level 3: Security Question
                System.out.println(SECURITY_QUESTION);
                System.out.print("Your answer: ");
                String answer = scanner.nextLine();

                if (authenticateSecurityQuestion(answer)) {
                    System.out.println("Level 3 authentication successful. Access Granted!");
                } else {
                    System.out.println("Security question answer incorrect. Access Denied.");
                }
            } else {
                System.out.println("PIN incorrect. Access Denied.");
            }
        } else {
            System.out.println("Username or password incorrect. Access Denied.");
        }

        scanner.close();
    }

    private static boolean authenticateUsernamePassword(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }

    private static boolean authenticatePin(String pin) {
        return PIN.equals(pin);
    }

    private static boolean authenticateSecurityQuestion(String answer) {
        return SECURITY_ANSWER.equalsIgnoreCase(answer);
    }
}

