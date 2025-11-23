/**
 * Subject interface - defines methods for managing observers
 */

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}
