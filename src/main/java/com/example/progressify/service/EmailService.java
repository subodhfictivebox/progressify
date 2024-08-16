package com.example.progressify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.io.UnsupportedEncodingException;

@Service
public class EmailService {

    @Autowired
    public JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("$(spring.mail.username)")
    private String fromMailId;


    public void sendEmail(String to, String subject) {
        try {
            // Process the template with the provided variables
//            String emailContent = templateEngine.process(template, variables);

            // Prepare the MIME message
//            MimeMessage mimeMessage = mailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
//            helper.setTo(to);
//            helper.setSubject(subject);
//            helper.setText(emailContent, true); // true indicates HTML content

            // Send the email
//            mailSender.send(mimeMessage);

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom("fromMailId", "Progressfy Teams!");
            helper.setTo(to);

            helper.setSubject(subject);
//            helper.setText(content, true);

            mailSender.send(message);

            // Log success
            System.out.println("Email sent successfully to " + to);

        } catch (MessagingException e) {
            // Log error and rethrow
            System.err.println("Failed to send email to " + to + ": " + e.getMessage());
            throw new RuntimeException("Failed to send email: " + e.getMessage());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
