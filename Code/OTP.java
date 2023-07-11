/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toffee.EnterUser;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;
/**
 *
 * @author Jana Rafat
 */
public class OTP  {
    protected String userEmail;
    private String UserPhonenumber;
    protected String OTPcode;
    //generate a random otp
     public String GenerateOTPCode(){
                int randomPin   =(int) (Math.random()*9000)+1000;
                String otp  = String.valueOf(randomPin);
                return otp; //returning value of otp
    }
     
     public boolean sendEmail(String to, String from, String subject, String text) {
        boolean flag = false;

        //logic
        //smtp properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //sender’s email and password
        String username = "janaraafat002@gmail.com"; // your gmail address;
        String password = "tkowtqnltudvwpis";


        //session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return flag;
    }

    public boolean CkeckOTP(String input){
        if(input.length()==OTPcode.length()){
            for(int i=0 ; i<input.length() ; i++){
                if(input.charAt(i)== OTPcode.charAt(i)){
                    continue;
                }
                else{
                    return false;
                }
            }
            System.out.print("here");
            return true;
        }
        else {
            return false;
        }
    }
}

