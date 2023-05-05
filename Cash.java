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
 *
 * @author smmdw
 */
public class Cash extends payments {
    ConfirmOrder c1=new ConfirmOrder();
    SignUp su=new SignUp();
    OTP o1=new OTP();
    Scanner ss=new Scanner(System.in);
    public boolean CheckCashConstraints(String Email){
        // the cash order constraints should defined by admin and this not a part in this assignmnet 
        if(c1.CalculatetotalPrice(Email)>1000){
            System.out.println("You can not pay Cash for this order ");
            // if the programm completed we will display menu of anothrt payments methods and make user choose another payment method
            return false;
        }
       return true;
    }
    public boolean otpValidation(String Email){
       String line= su.getline(Email);
       String[] values=line.split("\t\t");
       o1.GenerateOTP();
       o1.SendOTPUsingPhonenum(values[3]);
       System.out.println("Enter the Otp that has been sent to your mobile number ");
       String input=ss.nextLine();
        return o1.CkeckOTP(input);
    }
}
