/**
 * UndergraduateStudent class extending Student
 * Demonstrates: Multi-level Inheritance, Polymorphism
 */
public class UndergraduateStudent extends Student {
    // Private field - Encapsulation
    private String year; // Freshman, Sophomore, Junior, Senior

    // Constructor
    public UndergraduateStudent(int id, String name, int age, String course, String year)
            throws InvalidStudentDataException {
        super(id, name, age, course); // Inheritance - calling parent constructor
        validateYear(year);
        this.year = year;
    }

    // Validation method
    private void validateYear(String year) throws InvalidStudentDataException {
        if (year == null || year.trim().isEmpty()) {
            throw new InvalidStudentDataException("Year cannot be empty.");
        }
        String yearLower = year.toLowerCase();
        if (!yearLower.equals("freshman") && !yearLower.equals("sophomore") &&
                !yearLower.equals("junior") && !yearLower.equals("senior")) {
            throw new InvalidStudentDataException(
                    "Year must be Freshman, Sophomore, Junior, or Senior.");
        }
    }

    // Getter - Encapsulation
    public String getYear() {
        return year;
    }

    // Setter with validation - Encapsulation
    public void setYear(String year) throws InvalidStudentDataException {
        validateYear(year);
        this.year = year;
    }

    // Polymorphism - Overriding display method with specialized behavior
    @Override
    public void display() {
        System.out.println("\n--- Undergraduate Student Information ---");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Course: " + getCourse());
        System.out.println("Year: " + year);
        System.out.println("Type: " + getType());
    }

    // Polymorphism - Overriding getType method
    @Override
    public String getType() {
        return "Undergraduate Student";
    }
}
