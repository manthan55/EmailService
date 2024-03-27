package org.example.emailservice.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.emailservice.dtos.SendEmailMessageDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SendEmailConsumer {
    private ObjectMapper objectMapper;

    public SendEmailConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "sendEmail", groupId = "emailService")
    public void handleSendEmail(String message){
        System.out.println("sending email");
        try {
            SendEmailMessageDTO sendEmailMessageDTO = objectMapper.readValue(message, SendEmailMessageDTO.class);
            System.out.println(sendEmailMessageDTO.toString());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
