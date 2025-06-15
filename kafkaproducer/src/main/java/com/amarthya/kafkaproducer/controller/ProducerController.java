package com.amarthya.kafkaproducer.controller;

import com.amarthya.kafkaproducer.model.Customer;
import com.amarthya.kafkaproducer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProducerController {

@Autowired
private ProducerService producerService;

    @PostMapping("/send")
    public void sendMessage (@RequestBody String message){
    producerService.sendMessage(message);
    }

    @PostMapping("/raw")
    public String sendRawEvent(@RequestBody Customer customer)  {
        producerService.publishRawMessage(customer);
        return "Custom object published !";
    }

}