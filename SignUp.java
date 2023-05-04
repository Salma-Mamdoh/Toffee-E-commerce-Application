/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toffee.EnterUser;
import java.io.BufferedWriter;
import java.io.File;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author smmdw
 */
public class SignUp {
    private String name ;
    private String address;
    private String phonenum;
    private String Pass;
    private String Email;
    public boolean CheckInputValidation(int inputnum){
        if(inputnum==1){
            if(Email.matches("[A-Za-z0-9_#!%$‘&+*–/=?^`.{|}~-]*(.)[A-za-z0-9_#!%$‘&+*–/=?^`.{|}~-]*@[A-za-z0-9-+/]*.(com)")){
                return true;
            }
            else{
                System.out.println("Email must end with .com");
                System.out.println("Email must have chars and numbers and can have symbols ");
                System.out.println("Email must have @");
                return false;
            }
        }
        else if(inputnum==2){
            if(name.matches(("[a-zA-z-_ ]*"))){
                return true;
            }
            else{
                System.out.println("Name must have characters only no symbols and no numbers ");
                return false;
            }
        }
        else if(inputnum==3){
            if(address.matches("^\\d+\\s[A-z]+\\s[A-z]+$")){
                return true;
            }
            else{
                System.out.println("Address should be in this format street number & street namr & city name");
                return false;
            }
        }
        else if(inputnum==4){
            if(phonenum.matches("01[0-9]{9}")){
                return true;
            }
            else{
                System.out.println("Phone number must be 11 digit and must start by 01 ");
                return false;
            }
        }
        else{
            return false;
        }
    }
    public boolean CheckPassRules(){
            if(Pass.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d@$!%*?&]{8}$")){
                return true;
            }
            else{
                System.out.println("Please Create A strong Password that follows this Rules: ");
                System.out.println("1-Your Password must have exactly 8 characters ");
                System.out.println("2-Your Password must have at least 1 UpperCase & 1 lowerCase");
                System.out.println("3-Yout Password must have at least 1 number ");
                System.out.println("3-Yout Password must have at least 1 Symbol ");

                return false;
            }
    }
    public boolean OTPValidation(){
        OTP obj=new OTP();
        obj.GenerateOTP();
        obj.SendOTPUsingEmail(Email);
        Scanner sc= new Scanner(System.in); 
        String inputcode=sc.nextLine();
        while(!obj.CkeckOTP(inputcode)){
            System.out.print("this invalid OTP code WE will send another Otp to you");
            obj.GenerateOTP();
            obj.SendOTPUsingEmail(Email);
            inputcode=sc.nextLine();
        }
        return true;
    }
    public void EnterUserData(){
        Scanner sc= new Scanner(System.in); 
        System.out.print("Please Enter Your Email: ");
        Email=sc.nextLine();
        while(!CheckInputValidation(1)){
            System.out.println("This Invalid Email Please Enter a valid Email");
            Email=sc.nextLine();
        }
        //System.out.print(Email);
        System.out.print("Please Enter Your name: ");
        name=sc.nextLine();
        while(!CheckInputValidation(2)){
            System.out.println("This Invalid name Please Enter a valid name");
            name=sc.nextLine();
        }
        //System.out.print(name);
        System.out.print("Please Enter Your Address: ");
        address=sc.nextLine();
        while(!CheckInputValidation(3)){
            System.out.println("This Invalid Address Please Enter a valid Address");
            address=sc.nextLine();
        }
        //System.out.print(address);
        System.out.print("Please Enter Your PhoneNumber: ");
        phonenum=sc.nextLine();
        while(!CheckInputValidation(4)){
            System.out.println("This Invalid PhoneNumber Please Enter a valid PhoneNumber");
            phonenum=sc.nextLine();
        }
        //System.out.print(phonenum);
        System.out.println("Please Create A strong Password that follows this Rules: ");
        System.out.println("1-Your Password must have exactly 8 characters ");
        System.out.println("2-Your Password must have at least 1 UpperCase & 1 lowerCase");
        System.out.println("3-Yout Password must have at least 1 number ");
        System.out.println("3-Yout Password must have at least 1 Symbol ");

        Pass=sc.nextLine();
         while(!CheckPassRules()){
            System.out.println("This Invalid Password Please Enter a valid Password");
            Pass=sc.nextLine();
        }
        //System.out.print(Pass);
    }
    public void AddUserToDB(){
       
        PrintWriter out = null;
    try {
        out = new PrintWriter(new BufferedWriter(new FileWriter("SaveData.txt", true)));
        out.println(Email+"\t\t"+Pass+"\t\t"+name+"\t\t"+phonenum+"\t\t"+address);
    } catch (IOException e) {
        System.err.println(e);
    } finally {
        if (out != null) {
            out.close();
        }
}

}
}