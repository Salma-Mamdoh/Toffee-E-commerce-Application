/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toffee.EnterUser;
import java.util.*;

/**
 *
 * @author smmdw
 */
public class OTP {
    private String userEmail;
    private String UserPhonenumber;
    private String OTPcode;
    public void GenerateOTP(){
         int randomPin   =(int) (Math.random()*9000)+1000;
          OTPcode  = String.valueOf(randomPin);
         System.out.print(OTPcode);
    }
    
    public void SendOTPUsingEmail(String userEmail){
        
        
    }
     public void SendOTPUsingPhonenum(String Userphnum){
         
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
