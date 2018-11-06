package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

@Service
public class AmazonSNSPublisherService implements PublisherService {

    private AmazonSNS amazonSNS;
    private String snsTopicInterviewStatusARNLocal;

//    @Autowired BasicSessionCredentials sessionCredentials;
//    @Autowired String snsTopicInterviewStatusARN;

    @Autowired
    public AmazonSNSPublisherService(BasicSessionCredentials sessionCredentials, String snsTopicInterviewStatusARN) {
        this.amazonSNS = AmazonSNSClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(sessionCredentials)).build();
        this.snsTopicInterviewStatusARNLocal = snsTopicInterviewStatusARN;
    }

    @Override
    public void publish(String message, String topic) throws Exception {
        //
        // Get Appropriate Topic ARN
        //
        String snsTopic = getTopicARN(topic);
        //
        // Create Publish Message Request with TopicARN and Message
        //
        PublishRequest publishRequest = new PublishRequest(snsTopic, message);
        //
        // Publish the message
        //
        PublishResult publishResult = this.amazonSNS.publish(publishRequest);
        //
        // Evaluate the result: Print MessageId of message published to SNS topic
        //
        System.out.println("MessageId - " + publishResult.getMessageId());

    }

    private String getTopicARN(String topic) throws Exception {
        switch(topic) {
            case TOPICNAME:
                return this.snsTopicInterviewStatusARNLocal;
            default:
                throw new Exception("No matching topic supported!");
        }
    }
}