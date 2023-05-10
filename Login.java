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
 * this class designed to implement the login function.
 * @author Jana Rafat
 */
public class Login {
    private String Email;
    private String Password;
    
    /**
     * this method returns the email of specific user . 
     * @return string 
     */
    public String getEmail(){
        return this.Email;
    }
    /**
     * this method is used to enter the user data (Ex: email , password) . 
     */
    public void EnterData(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Your Email : ");
        Email=sc.nextLine();
        System.out.print("Enter Your Password : ");
        Password=sc.nextLine();
    }
    /**
     * this method checks for the correctness of the data entered by the user to login to the program . 
     * @return Boolean 
     */
    public boolean Check(){
        String path="SaveData.txt";
        File file =new File(path);
        
        PrintWriter out = null;
        try{
            Scanner inputBuffer=new Scanner (file);
            while(inputBuffer.hasNext()){
                String line=inputBuffer.nextLine();
                //System.out.print(line);
                String[] values=line.split("\t\t");
                if(values[0].equals(Email)&& values[1].equals(Password)){
                   return true; 
                }
            }
        } catch(IOException e) {
        System.err.println(e);
    } finally {
        if (out != null) {
            out.close();
        }
        }
        return false;
    }
   
}
