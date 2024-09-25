// Singleton Logger class
class Logger {
    // Private static variable for the single instance
    private static Logger instance;

    // Private constructor to prevent instantiation from outside
    private Logger() {
        System.out.println("Logger initialized.");
    }

    // Public method to provide access to the single instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

// Main class to test the Singleton
public class Main {
    public static void main(String[] args) {
        // Get the single instance of Logger and log messages
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        // Check if both logger1 and logger2 are the same instance
        System.out.println("Are logger1 and logger2 the same instance? " + (logger1 == logger2));
    }
}
