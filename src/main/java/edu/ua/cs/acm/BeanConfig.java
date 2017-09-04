package edu.ua.cs.acm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * Created by jzarobsky on 9/4/17.
 */
@Configuration
public class BeanConfig {

    @Bean
    public JavaMailSender mailSender() {
        return new JavaMailSenderImpl();
    }
}
