import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Course {
    private String courseName;
    private String material_link;
    private int courseId;
    private double courseRating;
    private List<Trainee> trainees;
    private static ArrayList<Course>allCourses=new ArrayList<Course>();
    private List<MCQ> mcqs;
    public Course(String courseName,String material_link) {
        this.courseName = courseName;
        this.material_link =material_link;
        this.trainees = new ArrayList<>();
        this.mcqs = new ArrayList<>();
        allCourses.add(this);
        this.courseId=allCourses.indexOf(this)+1;
    }

    public String getCourseName() {
        return courseName;
    }
    public String getmaterial() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public double getCourseRating() {
        return courseRating;
    }

    public void setCourseRating(double courseRating) {
        this.courseRating = courseRating;
    }
    public void setmaterial(String material) {
        this.material_link = material;
    }
    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(List<Trainee> trainees) {
        this.trainees = trainees;
    }

    public void addTrainee(Trainee trainee) {
        this.trainees.add(trainee);
        trainee.getCourses().add(this);
    }

    public void removeTrainee(Trainee trainee) {
        this.trainees.remove(trainee);
        trainee.getCourses().remove(this);
    }
    public static void printAllCourses() {
        System.out.println("List of all courses:");
        for (Course course : allCourses) {
            course.displayDetails();
        }
    }
    public void displayDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Rating: " + courseRating);
        System.out.println("Trainees enrolled: ");
        for (Trainee trainee : trainees) {
            System.out.println(trainee.getUsername());
        }
    }
    public static Course searchByName(String name) {
        for (Course course : allCourses) {
            if (course.getCourseName().equalsIgnoreCase(name)) {
                return course;
            }
        }
        return null; // not found
    }
    
    public static Course searchByID(double courseId2) {
        for (Course course : allCourses) {
            if (course.getCourseId() == courseId2) {
                return course;
            }
        }
        return null; // not found
    }
    public static List<Course> searchByRating(double minRating, double maxRating) {
        List<Course> matchingCourses = new ArrayList<>();
        for (Course course : allCourses) {
            double courseRating = course.getCourseRating();
            if (courseRating >= minRating && courseRating <= maxRating) {
                matchingCourses.add(course);
            }
        }
        return matchingCourses;
    }
    public void addMCQtoCourse(MCQ mcq) {
        this.mcqs.add(mcq);
    }
    public static void addMCQ(double courseId) {
        Course course = (Course) Course.searchByID(courseId);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the MCQ: ");
        String name = scanner.nextLine();
        MCQ mcq = new MCQ(name);
        boolean done = false;
        while (!done) {
            System.out.println("Add a question (Y/N)?");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                System.out.print("Enter the question: ");
                String question = scanner.nextLine();
                List<String> choices = new ArrayList<>();
                for (int i = 1; i <= 4; i++) {
                    System.out.print("Enter choice " + i + ": ");
                    String choiceStr = scanner.nextLine();
                    choices.add(choiceStr);
                }
                System.out.print("Enter the correct answer (1-4): ");
                int correctAnswer = scanner.nextInt();
                scanner.nextLine(); // consume the newline character
                Question q = new Question(question, choices, correctAnswer);
                mcq.addQuestion(q);
            } else if (choice.equalsIgnoreCase("N")) {
                done = true;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        course.addMCQtoCourse(mcq);
    }
    
    
    public static void addNewCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter materials link: ");
        String materials = scanner.nextLine();
        Course newCourse = new Course(courseName, materials);
        allCourses.add(newCourse);
        System.out.println("Course added successfully!");
    }

    public static void searchCourses() {
    }

 
}
