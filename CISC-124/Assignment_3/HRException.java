package Assignment_3;

/*
 * Student Name: Radmehr Vafadar
 * SID: 20421691
 * Date: 2024/08/07
 * Description: This class extens the Exception class and creates a custom error handler called HRException that forwards the error message.
 */

public class HRException extends Exception {
    public HRException(String message) {
        super(message);
    }
}
