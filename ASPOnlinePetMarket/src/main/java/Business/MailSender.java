package Business;

import com.healthmarketscience.jackcess.util.DebugErrorHandler;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class MailSender {
    public static void sendEmail(String recipientEmail, String subject, String messageBody) {
        
        // SMTP server details
        String host = "smtp.gmail.com";
        String port = "465";
        String username = "jasonwrodriguez@gmail.com"; // Replace with your email
        String password = "gmeg pfwl fuld ffcv"; // Replace with your email password
        
        // Set mail properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.trust", "*"); // Trust all certificates

        // Create a session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a new email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setText(messageBody);

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String recipient = "jasonwrodriguez@gmail.com";
        String subject = "Test Email";
        String message = "This is a simple test email.";

        MailSender.sendEmail(recipient, subject, message);
    }
}
