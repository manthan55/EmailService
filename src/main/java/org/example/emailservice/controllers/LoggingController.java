package org.example.emailservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LoggingController {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);
    
    @GetMapping("/{data}")
    public void LogData(@PathVariable String data){
        logger.trace("trace : "+data);
        logger.debug("debug : "+data);
        logger.info("info : "+data);
        logger.warn("warn : "+data);
        logger.error("error : "+data);
    }
}
