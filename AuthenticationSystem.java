import java.util.HashMap;
import java.util.Scanner;

class User {
    String username;
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

public class AuthenticationSystem {
    private HashMap<String, User> users = new HashMap<>();
    private User loggedInUser = null;

    public void registerUser(String username, String password) {
        if (!users.containsKey(username)) {
            users.put(username, new User(username, password));
            System.out.println("Registration successful!");
        } else {
            System.out.println("Username already exists. Please choose a different username.");
        }
    }

    public void login(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            if (user.password.equals(password)) {
                loggedInUser = user;
                System.out.println("Login successful!");
            } else {
                System.out.println("Incorrect password. Please try again.");
            }
        } else {
            System.out.println("Username not found. Please register first.");
        }
    }

    public void accessSecuredPage() {
        if (loggedInUser != null) {
            System.out.println("Welcome to the secured page, " + loggedInUser.username + "!");
        } else {
            System.out.println("You must log in first.");
        }
    }

    public static void main(String[] args) {
        AuthenticationSystem authSystem = new AuthenticationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Access Secured Page");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String regUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String regPassword = scanner.nextLine();
                    authSystem.registerUser(regUsername, regPassword);
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    authSystem.login(loginUsername, loginPassword);
                    break;
                case 3:
                    authSystem.accessSecuredPage();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
