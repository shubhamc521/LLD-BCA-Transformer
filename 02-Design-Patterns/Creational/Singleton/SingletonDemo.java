/**
 * Demo class to demonstrate Singleton Pattern
 */

public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern Demo ===\n");
        
        // Get the singleton instance - first call
        System.out.println("Getting first instance...");
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        db1.connect();
        db1.executeQuery("SELECT * FROM users");
        
        System.out.println();
        
        // Get the singleton instance - second call
        System.out.println("Getting second instance...");
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        db2.executeQuery("SELECT * FROM products");
        
        System.out.println();
        
        // Verify both references point to the same instance
        System.out.println("Are both instances the same? " + (db1 == db2));
        System.out.println("db1 hashCode: " + db1.hashCode());
        System.out.println("db2 hashCode: " + db2.hashCode());
        
        db1.disconnect();
    }
}
