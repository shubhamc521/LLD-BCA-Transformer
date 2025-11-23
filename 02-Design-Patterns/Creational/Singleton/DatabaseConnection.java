/**
 * Singleton Pattern Example: Database Connection
 * This is a thread-safe implementation using Bill Pugh Singleton Design
 */

public class DatabaseConnection {
    
    // Private constructor prevents instantiation from other classes
    private DatabaseConnection() {
        // Simulate database connection initialization
        System.out.println("Database connection initialized!");
    }
    
    // Static inner helper class - responsible for holding Singleton instance
    private static class SingletonHelper {
        // This instance is created only when SingletonHelper class is loaded
        private static final DatabaseConnection INSTANCE = new DatabaseConnection();
    }
    
    // Global access point to get the instance
    public static DatabaseConnection getInstance() {
        return SingletonHelper.INSTANCE;
    }
    
    // Example database operation
    public void executeQuery(String query) {
        System.out.println("Executing query: " + query);
    }
    
    // Prevent cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of this singleton instance is not allowed");
    }
    
    // Example: Connect to database
    public void connect() {
        System.out.println("Connected to database");
    }
    
    // Example: Disconnect from database
    public void disconnect() {
        System.out.println("Disconnected from database");
    }
}
