package edu.ua.cs.acm.email;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jzarobsky on 9/4/17.
 */
public class JoinEmailMessage extends DirectEmailMessage {


    private final String firstName;
    private final String lastName;
    private static final String TEMPLATE_NAME = "join.html";

    public JoinEmailMessage(String firstName, String lastName, String email) {
        super(email, "[UA ACM] Welcome to ACM!", 5);
        setHtml(true);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getBody() {
        Map<String, Object> model = new HashMap<>();

        model.put("firstName", getFirstName());
        model.put("lastName", getLastName());

        return renderTemplate("join.html", model);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
