package edu.ua.cs.acm.email;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

/**
 * Created by jzarobsky on 9/4/17.
 */
public abstract class DirectEmailMessage {

    private boolean isHtml;
    private String[] toEmails;
    private String subject;
    private int priority;

    public int getPriority() {
        return priority;
    }

    protected void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isHtml() {
        return isHtml;
    }

    protected void setHtml(boolean html) {
        isHtml = html;
    }

    public String[] getToEmails() {
        return toEmails;
    }

    public void setToEmails(String[] toEmails) {
        this.toEmails = toEmails;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public abstract String getBody();

    public DirectEmailMessage(String[] toEmails, String subject, int priority) {
        this.toEmails = toEmails;
        this.subject = subject;
        this.priority = priority;
    }

    public DirectEmailMessage(String toEmail, String subject, int priority) {
        this.toEmails = new String[] { toEmail };
        this.subject = subject;
        this.priority = priority;
    }

    private static VelocityEngine velocityEngine;

    static {
        Properties props = new Properties();
        props.setProperty("resource.loader", "class");
        props.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        velocityEngine = new VelocityEngine(props);
    }

    protected String renderTemplate(String templateName, Map<String, Object> context) {
        VelocityContext model = new VelocityContext();

        for (Map.Entry<String, Object> kvp : context.entrySet()) {
            model.put(kvp.getKey(), kvp.getValue());
        }

        StringWriter writer = new StringWriter();
        velocityEngine.mergeTemplate("templates/" + templateName, "UTF-8", model, writer);
        return writer.toString();
    }
}
