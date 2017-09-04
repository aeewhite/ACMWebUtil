package edu.ua.cs.acm.services;

import edu.ua.cs.acm.email.DirectEmailMessage;

/**
 * Created by jzarobsky on 9/4/17.
 */
public interface EmailService {
    void sendMessage(DirectEmailMessage message);
}
