package com.mps.kafka.producer.sample.controller;

import com.mps.kafka.producer.sample.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka/publish")
public class ProducerController {

    @Autowired
    private ProducerService service;

    @GetMapping("{message}")
    public void publish(@PathVariable String message) {
        service.sendMessage(message);
    }
}
