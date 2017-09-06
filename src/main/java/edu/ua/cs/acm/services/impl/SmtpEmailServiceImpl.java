package edu.ua.cs.acm.services.impl;

import edu.ua.cs.acm.email.DirectEmailMessage;
import edu.ua.cs.acm.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

/**
 * Created by jzarobsky on 9/4/17.
 */
@Service
@ConditionalOnExpression("'${sendgrid.api-key}'==''")
public class SmtpEmailServiceImpl implements EmailService {

    private JavaMailSender mailSender;
    private final String fromAddress;
    private final String fromAlias;


    @Autowired
    public SmtpEmailServiceImpl(JavaMailSender mailSender, @Value("${email.from-address}") String fromAddress,
                                @Value("${email.from-alias}") String fromAlias) {
        this.mailSender = mailSender;
        this.fromAddress = fromAddress;
        this.fromAlias = fromAlias;
    }

    @Override
    public void sendMessage(DirectEmailMessage message) {
        MimeMessagePreparator preparer = mimeMessage -> {
            MimeMessageHelper helper = new MimeMessageHelper((mimeMessage));
            helper.setTo(message.getToEmails());
            helper.setFrom(this.fromAddress, this.fromAlias);
            helper.setSubject(message.getSubject());
            helper.setText(message.getBody(), message.isHtml());
        };

        mailSender.send(preparer);
    }
}
