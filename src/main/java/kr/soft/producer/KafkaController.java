package kr.soft.producer;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    private final KafkaProducer producer;

    public KafkaController(KafkaProducer producer) {
        this.producer = producer;
    }

    //http://localhost:8081/api/kafka/send?message=hello
    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        producer.sendMessage(message);
        return "Sent: " + message;
    }

    //http://localhost:8081/api/kafka/user
    @GetMapping("/user")
    public String sendMessage() {
        producer.sendMessage();
        return "Sent";
    }
}