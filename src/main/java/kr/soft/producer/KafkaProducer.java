package kr.soft.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate, KafkaTemplate<String, UserDTO> kafkaUserTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaUserTemplate = kafkaUserTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send("my-topic", message);
    }

    private final KafkaTemplate<String, UserDTO> kafkaUserTemplate;

    public void sendMessage() {
        UserDTO user = new UserDTO();
        user.setUsername("super");
        user.setUserMessage("하늘을 날다");
        kafkaUserTemplate.send("user-topic", user);
    }
}
