package com.daweda.services.email;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EmailUtils
{
    private static final String fromEmail = "robot@n-cube.co.uk";
    private static final String fromPassword = "r199t";

    private static final String registrationEmailTemplate = "registrationEmail.template";
    private static final String passwordTemplate = "passwordEmail.template";


    public static boolean sendEmailConfirmationMessage(String toEmail, String linkToFollow, String userpwd){
        boolean success = true;
        try {

            Message message = createMessage(toEmail, "Mutopia registration");
            TemplateExtractor template = new TemplateExtractor();
            message.setContent(String.format(template.getTemplate(registrationEmailTemplate), userpwd), "text/html");
            Transport.send(message);

            System.out.println("An email notification is sent!");

        } catch (MessagingException e) {
            System.out.println(e.getStackTrace());
        }

        return success;
    }

    public static boolean sendNewPassword(String toEmail, String userpwd){
        boolean success = true;
        try {

            Message message = createMessage(toEmail, "Your new password for the \"Mutopia\" platform!");
            TemplateExtractor template = new TemplateExtractor();
            message.setContent(String.format(template.getTemplate(passwordTemplate), userpwd), "text/html");
            Transport.send(message);

            System.out.println("An email notification is sent!");

        } catch (MessagingException e) {
            System.out.println(e.getStackTrace());;
        }

        return success;
    }

    public static boolean sendEmailForgotPasswordMessage(String toEmail, String linkToFollow){

        boolean success = true;
        try {
            Message message = createMessage(toEmail, "Mutopia registration");
            message.setText("Please, reset your password by following a link below\n\n" +
                    linkToFollow +
                    "\n\nBest regards,\n" +
                    "NCube team");

            Transport.send(message);

            System.out.println("An email forget password notification is sent!");

        } catch (MessagingException e) {
            System.out.println(e.getStackTrace());;
        }
        return success;
    }

    private static Properties getProperties() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new EmailUtils().getClass().getClassLoader().getResourceAsStream("email.properties");

            prop.load(input);

            Preconditions.checkArgument(StringUtils.isNotBlank(prop.getProperty("mail.smtp.host")));
            Preconditions.checkArgument(StringUtils.isNotBlank(prop.getProperty("mail.smtp.socketFactory.port")));
            Preconditions.checkArgument(StringUtils.isNotBlank(prop.getProperty("mail.smtp.socketFactory.class")));
            Preconditions.checkArgument(StringUtils.isNotBlank(prop.getProperty("mail.smtp.auth")));
            Preconditions.checkArgument(StringUtils.isNotBlank(prop.getProperty("mail.smtp.port")));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;
    }

    private static Message createMessage(String toEmail, String subject) throws MessagingException
    {
        Session session = Session.getDefaultInstance(getProperties(), new javax.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, fromPassword);
            }
        });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        message.setSubject(subject);

        return message;
    }
}
