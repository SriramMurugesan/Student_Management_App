/**
 * GraduateStudent class extending Student
 * Demonstrates: Multi-level Inheritance, Polymorphism
 */
public class GraduateStudent extends Student {
    // Private field - Encapsulation
    private String researchArea;

    // Constructor
    public GraduateStudent(int id, String name, int age, String course, String researchArea)
            throws InvalidStudentDataException {
        super(id, name, age, course); // Inheritance - calling parent constructor
        validateResearchArea(researchArea);
        this.researchArea = researchArea;
    }

    // Validation method
    private void validateResearchArea(String researchArea) throws InvalidStudentDataException {
        if (researchArea == null || researchArea.trim().isEmpty()) {
            throw new InvalidStudentDataException("Research area cannot be empty.");
        }
    }

    // Getter - Encapsulation
    public String getResearchArea() {
        return researchArea;
    }

    // Setter with validation - Encapsulation
    public void setResearchArea(String researchArea) throws InvalidStudentDataException {
        validateResearchArea(researchArea);
        this.researchArea = researchArea;
    }

    // Polymorphism - Overriding display method with specialized behavior
    @Override
    public void display() {
        System.out.println("\n--- Graduate Student Information ---");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Course: " + getCourse());
        System.out.println("Research Area: " + researchArea);
        System.out.println("Type: " + getType());
    }

    // Polymorphism - Overriding getType method
    @Override
    public String getType() {
        return "Graduate Student";
    }
}
