package edu.ua.cs.acm.email;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmccoy on 9/26/17.
 */
public class SubscribeEmailMessage extends DirectEmailMessage {


    private final String firstName;
    private final String lastName;
    private final String email;
    private static final String TEMPLATE_NAME = "subscribe.html";

    public SubscribeEmailMessage(String firstName, String lastName, String email) {
        super("listserv@bama.ua.edu", "subscribe", 5);
        setHtml(true);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email
    }

    @Override
    public String getBody() {
        Map<String, Object> model = new HashMap<>();

        model.put("firstName", getFirstName());
        model.put("lastName", getLastName());
        model.put("email", getToEmails()[0].split("@")[0]);

        return renderTemplate("subscribe.html", model);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
