package org.example.emailservice.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.emailservice.dtos.SendEmailMessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SendEmailConsumer {
    private ObjectMapper objectMapper;
    Logger logger = LoggerFactory.getLogger(SendEmailConsumer.class);

    public SendEmailConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "sendEmail", groupId = "emailService")
    public void handleSendEmail(String message){
        logger.trace("trace : new message received : "+message);
        logger.debug("debug : new message received : "+message);
        logger.info("info : new message received : "+message);
        logger.warn("warn : new message received : "+message);
        logger.error("error : new message received : "+message);

        System.out.println("sending email");
        try {
            SendEmailMessageDTO sendEmailMessageDTO = objectMapper.readValue(message, SendEmailMessageDTO.class);
            System.out.println(sendEmailMessageDTO.toString());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
