/**
 * Abstract base class representing a Person
 * Demonstrates: Abstraction and Encapsulation
 */
public abstract class Person {
    // Private fields - Encapsulation
    private int id;
    private String name;
    private int age;

    // Constructor
    public Person(int id, String name, int age) throws InvalidStudentDataException {
        validateData(id, name, age);
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Data validation method
    private void validateData(int id, String name, int age) throws InvalidStudentDataException {
        if (id <= 0) {
            throw new InvalidStudentDataException("ID must be a positive number.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidStudentDataException("Name cannot be empty.");
        }
        if (age < 0 || age > 150) {
            throw new InvalidStudentDataException("Age must be between 0 and 150.");
        }
    }

    // Getters - Encapsulation
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setters with validation - Encapsulation
    public void setId(int id) throws InvalidStudentDataException {
        if (id <= 0) {
            throw new InvalidStudentDataException("ID must be a positive number.");
        }
        this.id = id;
    }

    public void setName(String name) throws InvalidStudentDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidStudentDataException("Name cannot be empty.");
        }
        this.name = name;
    }

    public void setAge(int age) throws InvalidStudentDataException {
        if (age < 0 || age > 150) {
            throw new InvalidStudentDataException("Age must be between 0 and 150.");
        }
        this.age = age;
    }

    // Abstract methods - Abstraction
    public abstract void display();

    public abstract String getType();
}
