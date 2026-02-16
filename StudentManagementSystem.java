import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Student Management System
 * Demonstrates: All OOP Principles and Exception Handling
 * - Encapsulation: Private fields with getters/setters
 * - Inheritance: Person -> Student -> GraduateStudent/UndergraduateStudent
 * - Polymorphism: Overridden display() and getType() methods
 * - Abstraction: Abstract Person class
 * - Exception Handling: Try-catch blocks and custom exceptions
 */
public class StudentManagementSystem {

    static ArrayList<Person> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\n===== Student Management System =====");
                System.out.println("1. Add Regular Student");
                System.out.println("2. Add Graduate Student");
                System.out.println("3. Add Undergraduate Student");
                System.out.println("4. View All Students");
                System.out.println("5. Update Student");
                System.out.println("6. Delete Student");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addRegularStudent();
                        break;
                    case 2:
                        addGraduateStudent();
                        break;
                    case 3:
                        addUndergraduateStudent();
                        break;
                    case 4:
                        viewStudents();
                        break;
                    case 5:
                        updateStudent();
                        break;
                    case 6:
                        deleteStudent();
                        break;
                    case 7:
                        System.out.println("Exiting... Thank you for using the Student Management System.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a valid number.");
                sc.nextLine(); // Clear the invalid input
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // Add Regular Student
    public static void addRegularStudent() {
        try {
            System.out.println("\n--- Add Regular Student ---");
            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter student age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter student course: ");
            String course = sc.nextLine();

            // Create Student object - may throw InvalidStudentDataException
            Student student = new Student(id, name, age, course);
            studentList.add(student);
            System.out.println("✓ Regular student added successfully.");

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input type. Please enter valid data.");
            sc.nextLine(); // Clear invalid input
        } catch (InvalidStudentDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Add Graduate Student
    public static void addGraduateStudent() {
        try {
            System.out.println("\n--- Add Graduate Student ---");
            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter student age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter student course: ");
            String course = sc.nextLine();

            System.out.print("Enter research area: ");
            String researchArea = sc.nextLine();

            // Create GraduateStudent object - may throw InvalidStudentDataException
            GraduateStudent student = new GraduateStudent(id, name, age, course, researchArea);
            studentList.add(student);
            System.out.println("✓ Graduate student added successfully.");

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input type. Please enter valid data.");
            sc.nextLine(); // Clear invalid input
        } catch (InvalidStudentDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Add Undergraduate Student
    public static void addUndergraduateStudent() {
        try {
            System.out.println("\n--- Add Undergraduate Student ---");
            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter student age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter student course: ");
            String course = sc.nextLine();

            System.out.print("Enter year (Freshman/Sophomore/Junior/Senior): ");
            String year = sc.nextLine();

            // Create UndergraduateStudent object - may throw InvalidStudentDataException
            UndergraduateStudent student = new UndergraduateStudent(id, name, age, course, year);
            studentList.add(student);
            System.out.println("✓ Undergraduate student added successfully.");

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input type. Please enter valid data.");
            sc.nextLine(); // Clear invalid input
        } catch (InvalidStudentDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // View All Students - Demonstrates Polymorphism
    public static void viewStudents() {
        try {
            if (studentList.isEmpty()) {
                System.out.println("\nNo students found.");
                return;
            }

            System.out.println("\n===== All Students =====");
            // Polymorphism in action: display() method behaves differently for each type
            for (Person student : studentList) {
                student.display(); // Calls the appropriate display method based on object type
            }

        } catch (Exception e) {
            System.out.println("Error viewing students: " + e.getMessage());
        }
    }

    // Update Student
    public static void updateStudent() {
        try {
            System.out.print("\nEnter student ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();

            Person foundStudent = null;
            for (Person student : studentList) {
                if (student.getId() == id) {
                    foundStudent = student;
                    break;
                }
            }

            if (foundStudent == null) {
                throw new StudentNotFoundException(id);
            }

            System.out.println("\nCurrent student information:");
            foundStudent.display();

            System.out.print("\nEnter new name (or press Enter to keep current): ");
            String name = sc.nextLine();
            if (!name.trim().isEmpty()) {
                foundStudent.setName(name);
            }

            System.out.print("Enter new age (or -1 to keep current): ");
            int age = sc.nextInt();
            sc.nextLine();
            if (age != -1) {
                foundStudent.setAge(age);
            }

            // Update course if it's a Student type
            if (foundStudent instanceof Student) {
                Student studentObj = (Student) foundStudent;
                System.out.print("Enter new course (or press Enter to keep current): ");
                String course = sc.nextLine();
                if (!course.trim().isEmpty()) {
                    studentObj.setCourse(course);
                }

                // Update specific fields for GraduateStudent
                if (foundStudent instanceof GraduateStudent) {
                    GraduateStudent gradStudent = (GraduateStudent) foundStudent;
                    System.out.print("Enter new research area (or press Enter to keep current): ");
                    String researchArea = sc.nextLine();
                    if (!researchArea.trim().isEmpty()) {
                        gradStudent.setResearchArea(researchArea);
                    }
                }

                // Update specific fields for UndergraduateStudent
                if (foundStudent instanceof UndergraduateStudent) {
                    UndergraduateStudent undergradStudent = (UndergraduateStudent) foundStudent;
                    System.out.print("Enter new year (or press Enter to keep current): ");
                    String year = sc.nextLine();
                    if (!year.trim().isEmpty()) {
                        undergradStudent.setYear(year);
                    }
                }
            }

            System.out.println("✓ Student updated successfully.");
            foundStudent.display();

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input type. Please enter valid data.");
            sc.nextLine(); // Clear invalid input
        } catch (StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidStudentDataException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    // Delete Student
    public static void deleteStudent() {
        try {
            System.out.print("\nEnter student ID to delete: ");
            int id = sc.nextInt();
            sc.nextLine();

            Person foundStudent = null;
            for (Person student : studentList) {
                if (student.getId() == id) {
                    foundStudent = student;
                    break;
                }
            }

            if (foundStudent == null) {
                throw new StudentNotFoundException(id);
            }

            System.out.println("\nStudent to be deleted:");
            foundStudent.display();

            System.out.print("\nAre you sure you want to delete this student? (yes/no): ");
            String confirmation = sc.nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {
                studentList.remove(foundStudent);
                System.out.println("✓ Student deleted successfully.");
            } else {
                System.out.println("Deletion cancelled.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input type. Please enter valid data.");
            sc.nextLine(); // Clear invalid input
        } catch (StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}