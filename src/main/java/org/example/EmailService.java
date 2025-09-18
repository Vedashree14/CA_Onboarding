package org.example;

import java.util.Properties;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailService {
    public static void sendWelcomeEmail(String toEmail, String caName, String utmLink) {
        Dotenv dotenv = Dotenv.load();
        String fromEmail = dotenv.get("EMAIL_USER");
        String password = dotenv.get("EMAIL_PASS").trim();

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            msg.setSubject("Welcome to Industry Academia Community, " + caName + " 🎉");

            String emailContent = "Hi " + caName + ",\n\n"
                    + "Welcome aboard as a Community Ambassador for Industry Academia Community (IAC)!\n\n"
                    + "Here is your unique UTM link for this month:\n"
                    + utmLink + "\n\n"
                    + "Please share this link while promoting IAC — it helps us recognize and "
                    + "track your valuable efforts.\n\n"
                    + "🌍 Mission: Impact 10 million students by 2028.\n"
                    + "🤝 Your role: Be the face of IAC in your network.\n\n"
                    + "We are excited to see the impact you will create!\n\n"
                    + "Best Regards,\n"
                    + "Team IAC";

            msg.setText(emailContent);

            Transport.send(msg);
            System.out.println("✅ Welcome email sent successfully to " + toEmail);

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("❌ Failed to send email to " + toEmail);
        }
    }
}
