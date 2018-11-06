package hello;

public interface PublisherService {
    //
    // Name of the topic
    //
    public static final String TOPICNAME = "tshah_test1";
    //
    // Publish Message API
    //
    void publish(String message, String topic) throws Exception;
}