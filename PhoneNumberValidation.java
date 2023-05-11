/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toffee.EnterUser;

/**
 *
 * @author smmdw
 * override validate function to validate phonenumber 
 */
public class PhoneNumberValidation implements ValidationStrategy {
    @Override
    public boolean validate(String input) {
        if(input.matches("01[0-9]{9}")){
            return true;
        }
        else{
            System.out.println("Phone number must be 11 digit and must start by 01 ");
            return false;
        }
    }
}
