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
 *
 * @author smmdw
 */
public class SignUp {
    Scanner sc= new Scanner(System.in); 
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
            //System.out.print(linetoremove);
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
    public void displaypersonalinfo(String Email){
        String line=getline(Email);
        String[] values=line.split("\t\t");
        System.out.println("this the personal information");
        System.out.print("Email: "+values[0]+"\n"+"Phonnum: "+values[3]+"\n" + "Name: "+values[2]+"\n" +"Address: "+values[4]+"\n");
    }
}
