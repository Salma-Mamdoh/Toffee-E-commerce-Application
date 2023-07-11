/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toffee.EnterUser;

/**
 *
 * @author smmdw
 * override to interface function to validate name
 */
public class NameValidation implements ValidationStrategy {
    @Override
    public boolean validate(String input) {
        if(input.matches(("[a-zA-z-_ ]*"))){
            return true;
        }
        else{
            System.out.println("Name must have characters only no symbols and no numbers ");
            return false;
        }
    }
}
