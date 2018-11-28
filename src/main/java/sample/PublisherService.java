package sample;

public interface PublisherService {
    //
    // Name of the topic
    //
    String TOPICNAME = "tshah_test1";
    /** This method publishes the message to given SNS Topic */
    void publish(String message, String topic) throws Exception;    
}