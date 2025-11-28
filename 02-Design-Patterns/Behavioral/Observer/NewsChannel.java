/**
 * Concrete Observer - News Channel that displays news
 */

public class NewsChannel implements Observer {
    private String channelName;
    
    public NewsChannel(String channelName) {
        this.channelName = channelName;
    }
    
    @Override
    public void update(String message) {
        System.out.println(channelName + " received news: " + message);
    }
    
    public String getChannelName() {
        return channelName;
    }
}
