/**
 * Demo class to demonstrate Observer Pattern
 */

public class ObserverDemo {
    public static void main(String[] args) {
        System.out.println("=== Observer Pattern Demo: News Agency ===\n");
        
        // Create the subject (news agency)
        NewsAgency newsAgency = new NewsAgency();
        
        // Create observers (news channels)
        NewsChannel cnn = new NewsChannel("CNN");
        NewsChannel bbc = new NewsChannel("BBC");
        NewsChannel fox = new NewsChannel("Fox News");
        
        // Attach observers to the subject
        System.out.println("--- Subscribing News Channels ---");
        newsAgency.attach(cnn);
        newsAgency.attach(bbc);
        newsAgency.attach(fox);
        
        // Publish first news - all observers get notified
        newsAgency.setNews("Stock market reaches all-time high!");
        
        // Detach one observer
        System.out.println("\n--- Unsubscribing Fox News ---");
        newsAgency.detach(fox);
        
        // Publish second news - only remaining observers get notified
        newsAgency.setNews("New technology breakthrough announced!");
        
        // Add a new observer
        System.out.println("\n--- Adding new channel ---");
        NewsChannel alJazeera = new NewsChannel("Al Jazeera");
        newsAgency.attach(alJazeera);
        
        // Publish third news
        newsAgency.setNews("Climate conference concludes with major agreements!");
        
        System.out.println("\n=== Demo Complete ===");
    }
}
