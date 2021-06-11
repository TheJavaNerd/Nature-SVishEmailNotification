/*
 * package com.cubix.serviced.emailNotification; import javax.mail.*; import
 * javax.mail.internet.InternetAddress; import javax.mail.internet.MimeMessage;
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * 
 * import com.cubix.serviced.service.UserService;
 * 
 * import java.util.Properties;
 * 
 * public class SendEmailTLS {
 * 
 * @Autowired private UserService userService;
 * 
 * public static void main(String[] args) {
 * 
 * final String username = "vish4414@gmail.com"; final String password =
 * "17N@rayan";
 * 
 * Properties prop = new Properties(); prop.put("mail.smtp.host",
 * "smtp.gmail.com"); prop.put("mail.smtp.port", "587");
 * prop.put("mail.smtp.auth", "true"); prop.put("mail.smtp.starttls.enable",
 * "true"); //TLS
 * 
 * Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
 * protected PasswordAuthentication getPasswordAuthentication() { return new
 * PasswordAuthentication(username, password); } });
 * 
 * try {
 * 
 * Message message = new MimeMessage(session); message.setFrom(new
 * InternetAddress(userser)); message.setRecipients( Message.RecipientType.TO,
 * InternetAddress.parse("to_username_a@gmail.com, to_username_b@yahoo.com") );
 * message.setSubject("Testing Gmail TLS"); message.setText("Dear Mail Crawler,"
 * + "\n\n Please do not spam my email!");
 * 
 * Transport.send(message);
 * 
 * System.out.println("Done");
 * 
 * } catch (MessagingException e) { e.printStackTrace(); } }
 * 
 * }
 */