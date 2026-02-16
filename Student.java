/**
 * Student class extending Person
 * Demonstrates: Inheritance, Encapsulation, Polymorphism
 */
public class Student extends Person {
    // Private field - Encapsulation
    private String course;

    // Constructor
    public Student(int id, String name, int age, String course) throws InvalidStudentDataException {
        super(id, name, age); // Inheritance - calling parent constructor
        validateCourse(course);
        this.course = course;
    }

    // Validation method
    private void validateCourse(String course) throws InvalidStudentDataException {
        if (course == null || course.trim().isEmpty()) {
            throw new InvalidStudentDataException("Course cannot be empty.");
        }
    }

    // Getter - Encapsulation
    public String getCourse() {
        return course;
    }

    // Setter with validation - Encapsulation
    public void setCourse(String course) throws InvalidStudentDataException {
        validateCourse(course);
        this.course = course;
    }

    // Polymorphism - Overriding abstract method from Person
    @Override
    public void display() {
        System.out.println("\n--- Student Information ---");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Course: " + course);
        System.out.println("Type: " + getType());
    }

    // Polymorphism - Overriding abstract method from Person
    @Override
    public String getType() {
        return "Regular Student";
    }
}
