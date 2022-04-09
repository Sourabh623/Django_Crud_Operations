package com.api.demo.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;

@RestController
public class EmailController {
   @RequestMapping(value = "/send-email")
   public String sendmail() throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sourabhfulmali623@gmail.com", "sobhu623@");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("sourabhfulmali623@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("sourabhfulmali08@gmail.com"));
        msg.setSubject("What is your name");
        msg.setContent("my name is sourabh", "text/html");
        msg.setSentDate(new Date());

        Transport.send(msg);
        return "mail send successfully done.";
    }
}
