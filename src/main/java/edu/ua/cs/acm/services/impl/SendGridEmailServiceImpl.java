package edu.ua.cs.acm.services.impl;

import com.sendgrid.*;
import edu.ua.cs.acm.email.DirectEmailMessage;
import edu.ua.cs.acm.services.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.stereotype.Service;

/**
 * Created by jzarobsky on 9/5/17.
 */
@Service
@ConditionalOnExpression("'${sendgrid.api-key}'!=''")
public class SendGridEmailServiceImpl implements EmailService {

    private static final Logger LOG = LoggerFactory.getLogger(SendGridEmailServiceImpl.class);

    private final String sendgridApiKey;
    private final SendGrid sendGrid;
    private final String fromAddress;
    private final String fromAlias;

    public SendGridEmailServiceImpl(@Value("${sendgrid.api-key}") String sendgridApiKey,
                                    @Value("${email.from-address}") String fromAddress,
                                    @Value("${email.from-alias}") String fromAlias) {
        this.sendgridApiKey = sendgridApiKey;
        this.sendGrid = new SendGrid(sendgridApiKey);
        this.fromAddress = fromAddress;
        this.fromAlias = fromAlias;
    }

    @Override
    public void sendMessage(DirectEmailMessage message) {
        LOG.info("begin send message");
        Email fromEmail = new Email(fromAddress, fromAlias);
        for(String email: message.getToEmails()) {
            Email toEmail = new Email(email);
            Content content = new Content(message.isHtml() ? "text/html" : "text/plain", message.getBody());
            Mail mail = new Mail(fromEmail, message.getSubject(), toEmail, content);

            Request request = new Request();

            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");

            try {
                request.setBody(mail.build());
                this.sendGrid.api(request);
            } catch (Exception ex) {
                LOG.error(ex.getMessage());
            }
        }
    }
}
