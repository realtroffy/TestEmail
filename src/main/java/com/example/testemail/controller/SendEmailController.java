package com.example.testemail.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendEmailController {

    private final JavaMailSender sender;

    public SendEmailController(JavaMailSender sender) {
        this.sender = sender;
    }

    @GetMapping("/emails")
    public ResponseEntity<String> sendEmail(@RequestParam("email") String email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("artasiptsou@gmail.com");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("Test");
        simpleMailMessage.setText("Hello World");
        sender.send(simpleMailMessage);
        return ResponseEntity.ok("Email sent");
    }
}
