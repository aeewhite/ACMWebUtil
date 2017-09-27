package edu.ua.cs.acm.controllers;

import edu.ua.cs.acm.email.JoinEmailMessage;
import edu.ua.cs.acm.email.SubscribeEmailMessage;
import edu.ua.cs.acm.messages.JoinMessage;
import edu.ua.cs.acm.messages.SubscribeMessage;
import edu.ua.cs.acm.services.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jzarobsky on 9/4/17.
 */
@RestController
@RequestMapping("/join")
public class JoinController {

    private static final Logger LOG = LoggerFactory.getLogger(JoinController.class);
    private final EmailService emailService;

    public JoinController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping()
    public ResponseEntity joinAcm(@RequestBody JoinMessage message) {

        try {
            emailService.sendMessage(new JoinEmailMessage(message.getFirstName(), message.getLastName(),
                    message.getEmail(), message.wantsSlackToJoinSlack()));
            emailService.sendMessage(new SubscribeEmailMessage(message.getFirstName(), message.getLastName(),
                    message.getEmail()));
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok().build();
    }
}
