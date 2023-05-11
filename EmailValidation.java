/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toffee.EnterUser;

/**
 *
 * @author smmdw
 * override validate function to validate email
 */
public class EmailValidation implements ValidationStrategy{
    @Override
    public boolean validate(String input) {
        if(input.matches("[A-Za-z0-9_#!%$‘&+*–/=?^`.{|}~-]*(.)[A-za-z0-9_#!%$‘&+*–/=?^`.{|}~-]*@[A-za-z0-9-+/]*.(com)")){
            return true;
        }
        else{
            System.out.println("Email must end with .com");
            System.out.println("Email must have chars and numbers and can have symbols ");
            System.out.println("Email must have @");
            return false;
        }
    }
}
