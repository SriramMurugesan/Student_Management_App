/**
 * Custom exception for student not found operations
 * Demonstrates: Exception Handling
 */
public class StudentNotFoundException extends Exception {

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(int studentId) {
        super("Student with ID " + studentId + " not found.");
    }
}
