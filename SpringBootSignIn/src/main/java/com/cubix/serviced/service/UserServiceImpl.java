package com.cubix.serviced.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cubix.serviced.model.Role;
import com.cubix.serviced.model.User;
import com.cubix.serviced.repository.RoleRespository;
import com.cubix.serviced.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service("userService")
public class UserServiceImpl implements UserService {
 
 @Autowired
 private UserRepository userRepository;
 
 @Autowired
 private RoleRespository roleRespository;
 
 @Autowired
 private BCryptPasswordEncoder bCryptPasswordEncoder;

 @Override
 public User findUserByEmail(String email) {
  return userRepository.findByEmail(email);
 }

 @Override
 public void saveUser(User user) {
  user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
  user.setActive(1);
  Role userRole = roleRespository.findByRole("ADMIN");
  user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
  userRepository.save(user);
  final String username = "vishkamdi1@gmail.com";
  final String password = "dnlh aghy rxqf ukps";

  Properties prop = new Properties();
  prop.put("mail.smtp.host", "smtp.gmail.com");
  prop.put("mail.smtp.port", "587");
  prop.put("mail.smtp.auth", "true");
  prop.put("mail.smtp.starttls.enable", "true"); //TLS
  
  Session session = Session.getInstance(prop,
          new javax.mail.Authenticator() {
              protected PasswordAuthentication getPasswordAuthentication() {
                  return new PasswordAuthentication(username, password);
              }
          });

  try {

      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(username));
      message.setRecipients(
              Message.RecipientType.TO,
              InternetAddress.parse(user.getEmail())
      );
      message.setSubject("Nature'S Vish");
      message.setText("Welcome to Nature'S Vish,"
              + "\n\n Please do not spam my email!");

      Transport.send(message);

      System.out.println("Done");

  } catch (MessagingException e) {
      e.printStackTrace();
  }
}


 }

