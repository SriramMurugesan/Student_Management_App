/**
 * Custom exception for invalid student data
 * Demonstrates: Exception Handling
 */
public class InvalidStudentDataException extends Exception {

    public InvalidStudentDataException(String message) {
        super(message);
    }

    public InvalidStudentDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
