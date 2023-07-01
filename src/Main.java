import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Select an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Login as Admin");
            System.out.println("4. Register as Admin");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    registerTrainee();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    Admin.login();
                    break;
                case 4:
                Admin.registerAdministrator();
                    break;
                case 5:
                    System.out.println("4 program...");
                    break;
                case 6:
                    Course.printAllCourses();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 5);
    }

    private static void registerTrainee() {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter trainee name: ");
      String name = scanner.nextLine();
      System.out.print("Enter trainee email: ");
      String email = scanner.nextLine();
      System.out.print("Enter trainee password: ");
      String password = scanner.nextLine();
      System.out.print("Enter trainee phone number: ");
      String phoneNumber = scanner.nextLine();
  
      Trainee trainee = new Trainee(email, password, name, phoneNumber);
  
      if (!Trainee.isEmailTaken(email)) {
          System.out.println("Email already taken, registration failed.");
      } else {
          System.out.println("Trainee registered successfully. ID: " + trainee.getID());
      }
  }
  private static void login() {
   Scanner scanner = new Scanner(System.in);
   System.out.print("Enter trainee email: ");
   String email = scanner.nextLine();
   System.out.print("Enter trainee password: ");
   String password = scanner.nextLine();
   Trainee trainee = Trainee.login(email, password);
   if (trainee == null) {
       System.out.println("Wrong email or password.");
   } else {
       System.out.println("Welcome, " + trainee.getUsername() + "!");
       traineeMenu(trainee);
   }
}

private static void traineeMenu(Trainee trainee) {
   Scanner scanner = new Scanner(System.in);
   while (true) {
       System.out.println("Select an option:");
       System.out.println("1. Manage profile");
       System.out.println("2. View profile");
       System.out.println("3. Search courses");
       System.out.println("4. Logout");
       int choice = scanner.nextInt();
       scanner.nextLine(); // consume the newline character
       switch (choice) {
           case 1:
               trainee.manageProfile();
               break;
           case 2:
               trainee.viewProfile();
               break;
           case 3:
            Course.searchCourses();
               break;
           case 4:
               System.out.println("Logged out.");
               return;
            
           default:
               System.out.println("Invalid choice. Try again.");
       }
   }
}

}
