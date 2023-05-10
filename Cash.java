/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toffee.Order;
import com.mycompany.toffee.EnterUser.OTP;
import com.mycompany.toffee.EnterUser.SignUp;
import com.mycompany.toffee.Order.ConfirmOrder;
import java.util.Scanner;

/**
 * this class inherits from class payments as it is a way to pay for the order.
 * @author Jana Rafat
 */
public class Cash extends payments {
    ConfirmOrder c1=new ConfirmOrder();
    SignUp su=new SignUp();
    OTP o1=new OTP();
    Scanner ss=new Scanner(System.in);
    /**
     * this method is used to check cash constraints. 
     * @param Email takes the email as it is the key to search about in the database.
     * @return Boolean 
     */
    public boolean CheckCashConstraints(String Email){
        // the cash order constraints should defined by admin and this not a part in this assignmnet 
        if(c1.CalculatetotalPrice(Email)>1000){
            System.out.println("You can not pay Cash for this order ");
            // if the programm completed we will display menu of anothrt payments methods and make user choose another payment method
            return false;
        }
       return true;
    }
    /**
     * this method is used to make OTP validation . 
     * @param Email takes the email as it is the key to send the otp Code.
     * @return Boolean 
     */
    public boolean otpValidation(String Email){
        String line= su.getline(Email);
        String[] values=line.split("\t\t");
        o1.GenerateOTPCode();
        String verifyOtp="";
        String to = Email;
        String from = "janaraafat002@gmail.com";
        String subject = "Welcome to toffe Store !"
                + "This is your way to confirm your Order";
        String text = "Dear jana,"
                + "we are here to help you with your Order progress ♥ ... to confirm your Order , please use the following OTP to verify your Order : "+o1.GenerateOTPCode()+"\n"
                + "Thank you for your time we wish you a good tour in our store ,having your favouite chocolate pieces yummmi! 😋"+"\n"+"regards,"+"\n"
                + "Toffee Store Team";
        boolean b=o1.sendEmail(to,from,subject,text);
       if (b) {  
            System.out.println("Email is sent successfully");
            System.out.println("Please , put the code sent to you : ");
            verifyOtp =ss.nextLine();
            if(o1.CkeckOTP(verifyOtp))
            return true; 
            else{
                while(!o1.CkeckOTP(verifyOtp)){
                                 b = o1.sendEmail(to, from, subject, text);
                                 if (b) {  
                                            System.out.println("Email is sent successfully");
                                            System.out.println("Please , put the code sent to you : ");
                                            verifyOtp =ss.nextLine();
                                 }else {
                                 System.out.println("There is problem in sending email");}
                }
                }

        } else {
            System.out.println("There is problem in sending email");
        }
            return false;
    }
}
