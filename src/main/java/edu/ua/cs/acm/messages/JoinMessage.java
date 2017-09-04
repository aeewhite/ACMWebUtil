package edu.ua.cs.acm.messages;

/**
 * Created by jzarobsky on 9/4/17.
 */
public class JoinMessage {
    private String firstName;
    private String lastName;
    private String email;
    private String slack;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSlack() {
        return slack;
    }

    public void setSlack(String slack) {
        this.slack = slack;
    }

    private boolean wantsSlackToJoinSlack() {
        return slack.toLowerCase().equals("Yes");
    }
}
