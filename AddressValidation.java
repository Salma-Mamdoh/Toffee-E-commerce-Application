/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toffee.EnterUser;

/**
 *
 * @author smmdw
 * override validate function to validate address 
 */
public class AddressValidation implements ValidationStrategy{
    @Override
    public boolean validate(String input) {
        if(input.matches("^\\d+\\s[A-z]+\\s[A-z]+$")){
            return true;
        }
        else{
            System.out.println("Address should be in this format street number & street namr & city name");
            return false;
        }
    }
}
