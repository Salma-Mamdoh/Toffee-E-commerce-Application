/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toffee.EnterUser;

/**
 *
 * @author smmdw
 * override validate function to validate password
 */
public class PasswordValidation implements ValidationStrategy{
    @Override
    public boolean validate(String input){
    if(input.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d@$!%*?&]{8}$")){
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
}
