package org.example.emailservice.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SendEmailMessageDTO {
    private String to;
    private String from;
    private String subject;
    private String body;
}
