/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toffee.EnterUser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * this class designed to implement the SignUp function.
 * @author Jana Rafat
 */
public class SignUp {
    Scanner sc= new Scanner(System.in); 
    private String name ;
    private String address;
    private String phonenum;
    private String Pass;
    private String Email;
    /**
     * this method checks the user info if it is validated or not. 
     * @param inputnum which is the number chosen to do the sub functions of the method.
     * @return Boolean 
     */
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
                System.out.println("Address should be in this format street number & street name & city name");
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
    /**
     * this method checks the user password as it has the static roles of the password or not. 
     * @return Boolean 
     */
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
     /**
     * this method provides OTP validation. 
     * @return Boolean 
     */
    public boolean OTPValidation(){
        OTP gEmailSender = new OTP();
        String otp =gEmailSender.GenerateOTPCode();
        gEmailSender.OTPcode=otp;
        String verifyOtp="";
        String to = Email;
        String from = "janaraafat002@gmail.com";
        String subject = "Welcome to toffe Store !"
                + "This is your way to confirm your email address";
        String text = "Dear jana,"
                + "we are here to help you with your registeration progress ♥ ... to confirm your account , please use the following OTP to verify your account : "+otp+"\n"
                + "Thank you for your time we wish you a good tour in our store ,having your favouite chocolate pieces yummmi! 😋"+"\n"+"regards,"+"\n"
                + "Toffee Store Team";
        boolean b = gEmailSender.sendEmail(to, from, subject, text);
        if (b) {  
            System.out.println("Email is sent successfully");
            System.out.println("Please , put the code sent to you : ");
            verifyOtp =sc.nextLine();
            if(gEmailSender.CkeckOTP(verifyOtp))
            return true; 
            else{
                while(!gEmailSender.CkeckOTP(verifyOtp)){
                                 b = gEmailSender.sendEmail(to, from, subject, text);
                                 if (b) {  
                                            System.out.println("Email is sent successfully");
                                            System.out.println("Please , put the code sent to you : ");
                                            verifyOtp =sc.nextLine();
                                 }else {
                                 System.out.println("There is problem in sending email");}
                }
                }

        } else {
            System.out.println("There is problem in sending email");
        }
            return false;
    }
    /**
     * this method is used to permits the user to enter his/her data. 
     */
    public void EnterUserData(){
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
        System.out.print("Please Enter Your Address as 25 haram giza: ");
        address=sc.nextLine();
        while(!CheckInputValidation(3)){
            System.out.println("This Invalid Address Please Enter a valid Address street number & street name & city name");
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
    /**
     * this method is used to add the user to the database. 
     */
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
    /**
     * this method is used to remove this user at all. 
     * @param Email takes the email as it is the key to search about in the database.
     * @return string 
     */
     public String Remove(String Email){
        String path="SaveData.txt";
        File file =new File(path);
        File templete=new File("Templete2.txt");
        PrintWriter out = null;
        boolean exist=false;
        String returnStr="";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(templete));
            Scanner inputBuffer=new Scanner (file);
            String linetoremove="";
            String currentLine;
            while(inputBuffer.hasNext()){
                String line=inputBuffer.nextLine();
                String[] values=line.split("\t\t");
                if(values[0].equals(Email)){
                        linetoremove=line;
                        //exist=true;
                        returnStr=line;
                        break;
                }
            }
            if(!linetoremove.isEmpty()){
            while((currentLine = reader.readLine()) != null) {
   
                String trimmedLine = currentLine.trim();
                if(trimmedLine.equals(linetoremove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close(); 
            reader.close(); 
             FileInputStream in = new FileInputStream(templete);
             FileOutputStream output = new FileOutputStream(file);
             int n;
            while ((n = in.read()) != -1) {
                output.write(n);
            }
            }
            else{
                System.out.println("This no person has this Email");
            }
            
        } catch(IOException e) {
        System.err.println(e);
    } finally {
        if (out != null) {
            out.close();
        }
        }
        return returnStr;
    }
     /**
     * this method used to update the address in the database. 
     * @param Email takes the email as it is the key to search about in the database. 
     */
    public void updateAddress(String Email){
        System.out.println("Enter the new address");
        String newAdd=sc.nextLine();
        address=newAdd;
        PrintWriter out = null;
        String Data=Remove(Email);
        String[] val=Data.split("\t\t");
    try {
        out = new PrintWriter(new BufferedWriter(new FileWriter("SaveData.txt", true)));
        out.println(val[0]+"\t\t"+val[1]+"\t\t"+val[2]+"\t\t"+val[3]+"\t\t"+newAdd);
    } catch (IOException e) {
        System.err.println(e);
    } finally {
        if (out != null) {
            out.close();
        }
    }
    }
     /**
     * this method used to update the phone number in the database. 
     * @param Email takes the email as it is the key to search about in the database. 
     */
    public void updatePhonenumber(String Email){
        System.out.println("Enter the new phonenumber");
        String newphonenum=sc.nextLine();
        phonenum=newphonenum;
        PrintWriter out = null;
        String Data=Remove(Email);
        String[] val=Data.split("\t\t");
    try {
        out = new PrintWriter(new BufferedWriter(new FileWriter("SaveData.txt", true)));
        out.println(val[0]+"\t\t"+val[1]+"\t\t"+val[2]+"\t\t"+newphonenum+"\t\t"+val[4]);
    } catch (IOException e) {
        System.err.println(e);
    } finally {
        if (out != null) {
            out.close();
        }
    }
    }
     /**
     * this method used to get a complete line in the data base. 
     * @param Email takes the email as it is the key to search about in the database.
     * @return string 
     */
    public String getline(String Email){
         String path="SaveData.txt";
        File file =new File(path);
        String toreturn="";
        PrintWriter out = null;
        try{
            Scanner inputBuffer=new Scanner (file);
            while(inputBuffer.hasNext()){
                String line=inputBuffer.nextLine();
                String[] values=line.split("\t\t");
                if(values[0].equals(Email)){
                    toreturn=line;
                    break;
                }
            }
        } catch(IOException e) {
        System.err.println(e);
    } finally {
        if (out != null) {
            out.close();
        }
        }
        if(toreturn.isEmpty()){
            System.out.println("this no item by this id ");
            return "";
        }
        else return toreturn;
}
    /**
     * this method display person info. 
     * @param Email takes the email as it is the key to search about in the database. 
     */
    public void displaypersonalinfo(String Email){
        String line=getline(Email);
        String[] values=line.split("\t\t");
        System.out.println("this the personal information");
        System.out.print("Email: "+values[0]+"\n"+"Phonnum: "+values[3]+"\n" + "Name: "+values[2]+"\n" +"Address: "+values[4]+"\n");
    }
}
