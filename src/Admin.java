import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {
    private String username;
    private String password;
    private static List<Admin> allAdmins = new ArrayList<>();

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        allAdmins.add(this);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String mail = scanner.nextLine();
        System.out.print("Enter password: ");
        String pass = scanner.nextLine();
        for (Admin admin : allAdmins) {
            if (admin.getUsername().equals(mail) && admin.getPassword().equals(pass)) {
                System.out.println("Login successful!");
                int choice = 0;
                while (choice != 3) {
                    System.out.println("Please select an option:");
                    System.out.println("1. Add new course");
                    System.out.println("2. Add quiz");
                    System.out.println("3. Logout");
    
                    choice = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
    
                    switch (choice) {
                        case 1:
                           Course.addNewCourse();
                            break;
                        case 2:
                          
                            break;
                     
                        case 3:
                        System.out.println("Logout successful!");
                        break;
                        default:
                            System.out.println("Invalid choice, please try again.");
                            break;
                    }
                }
                return;
            }
        }
        System.out.println("Username or password invalid.");
    }
    public static void printAllAdmins() {
        System.out.println("Registered administrators:");
        for (Admin admin : allAdmins) {
            System.out.println("Username: " + admin.getUsername() + ", Password: " + admin.getPassword());
        }
    }
    
    public static void registerAdministrator() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter administrator username: ");
        String username = scanner.nextLine();
        System.out.print("Enter administrator password: ");
        String password = scanner.nextLine();
    
        Admin admin = new Admin(username, password);
    
        if (isUsernameTaken(username)) {
            System.out.println("Username already taken, registration failed.");
        } else {
            allAdmins.add(admin);
            System.out.println("Administrator registered successfully.");
        }
    }
    
    private static boolean isUsernameTaken(String username) {
        for (Admin admin : allAdmins) {
            if (admin.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
    
    