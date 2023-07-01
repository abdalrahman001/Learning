import java.util.ArrayList;
import java.util.Scanner;

public class Trainee {
    private String email;
    private int ID;
    private String password;
    private String username;
    private String phoneNumber;
    private ArrayList<Course> courses;
    public static ArrayList<Trainee> allTrainees = new ArrayList<Trainee>();

    public Trainee(String email, String password, String username, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.courses = new ArrayList<Course>();
        allTrainees.add(this);
        this.ID = allTrainees.indexOf(this) + 1;
    }
    public static void printAllTrainees() {
        if (allTrainees.size() == 0) {
            System.out.println("No trainees registered yet.");
        } else {
            System.out.println("Registered Trainees:");
            for (Trainee trainee : allTrainees) {
                System.out.println("ID: " + trainee.getID() + ", Name: " + trainee.getUsername() + ", Email: " + trainee.getEmail() + ", Phone Number: " + trainee.getPhoneNumber());
            }
        }
    }
    // Getters and setters
    public void setID(int iD) {
        ID = iD;
    }

    public int getID() {
        return ID;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public static ArrayList<Trainee> getAllTrainees() {
        return allTrainees;
    }
    public void viewProfile() {
        System.out.println("ID: " + this.getID());
        System.out.println("Name: " + this.getUsername());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Phone number: " + this.getPhoneNumber());
        System.out.println("Courses:");
        if (this.courses.isEmpty()) {
            System.out.println("  None");
        } else {
            for (Course course : this.courses) {
                System.out.println("  " + course.getCourseName());
            }
        }
    }
    public void manageProfile() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("What do you want to edit?");
        System.out.println("1. Name");
        System.out.println("2. Email");
        System.out.println("3. Password");
        System.out.println("4. Phone Number");
        System.out.println("5. Cancel");
    
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline character
    
        switch (choice) {
            case 1:
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                this.setUsername(name);
                System.out.println("Name updated successfully.");
                break;
            case 2:
                System.out.print("Enter new email: ");
                String email = scanner.nextLine();
                if (Trainee.isEmailTaken(email)) {
                    System.out.println("Email already taken, update failed.");
                } else {
                    this.setEmail(email);
                    System.out.println("Email updated successfully.");
                }
                break;
            case 3:
                System.out.print("Enter new password: ");
                String password = scanner.nextLine();
                this.setPassword(password);
                System.out.println("Password updated successfully.");
                break;
            case 4:
                System.out.print("Enter new phone number: ");
                String phoneNumber = scanner.nextLine();
                this.setPhoneNumber(phoneNumber);
                System.out.println("Phone number updated successfully.");
                break;
            case 5:
                System.out.println("Profile update cancelled.");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
    // Enroll in a course
    public void enrollInCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addTrainee(this);
        }
    }

    // Withdraw from a course
    public void withdrawFromCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
            course.removeTrainee(this);
        }
    }
    public static Trainee login(String email, String password) {
        for (Trainee trainee : allTrainees) {
            if (trainee.getEmail().equals(email) && trainee.getPassword().equals(password)) {
                return trainee;
            }else{System.out.print("Wrong Username or password ");}
        }
        return null; // no match found
    }
    public static boolean isEmailTaken(String email) {
        for (Trainee trainee : allTrainees) {
            if (trainee.getEmail().equals(email)) {
                return true;
            }
        }
        return false; // no match found
    } 
    
}
