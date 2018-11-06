package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    @Autowired
    PublisherService publisherService;

    @RequestMapping("/")
    public String index(@RequestParam String name) {
        try {
            this.publisherService.publish(name + " is the best.", PublisherService.TOPICNAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Greetings from Spring Boot!";

    }
    
}
