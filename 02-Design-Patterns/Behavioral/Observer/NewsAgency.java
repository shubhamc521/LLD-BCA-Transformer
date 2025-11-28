/**
 * Concrete Subject - News Agency that publishes news
 */

import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements Subject {
    private List<Observer> observers;
    private String news;
    
    public NewsAgency() {
        this.observers = new ArrayList<>();
    }
    
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
        System.out.println("Observer attached. Total observers: " + observers.size());
    }
    
    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
        System.out.println("Observer detached. Total observers: " + observers.size());
    }
    
    @Override
    public void notifyObservers() {
        System.out.println("\n--- Notifying all observers ---");
        for (Observer observer : observers) {
            observer.update(news);
        }
    }
    
    // Set news and notify all observers
    public void setNews(String news) {
        System.out.println("\n*** Breaking News: " + news + " ***");
        this.news = news;
        notifyObservers();
    }
    
    public String getNews() {
        return news;
    }
}
