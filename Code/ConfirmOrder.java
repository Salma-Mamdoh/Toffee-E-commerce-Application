/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toffee.Order;
import com.mycompany.toffee.Cart.UserCart;
import com.mycompany.toffee.EnterUser.SignUp;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
/**
 * this class provide the functionality of confirm the order.
 * @author Jana Rafat
 */
public class ConfirmOrder {
    Scanner sc=new Scanner(System.in);
    //make an object of the cart of the user.
    UserCart uc=new UserCart();
    //make an object of SignUp class.
    SignUp us=new SignUp();
    /**
     * this method displays the menu which the user choose from to do all functionalities of order . 
     */
    public void displayMenu(){
        System.out.println("If you want to display the items that you will order          ----->Enter 1");
        System.out.println("if you want to update your personal information like address - >Enter 2");
        System.out.println("if you want to update Orde ritems                                ------>Enter 3");
        System.out.println("if you want to know the total price of items                   ------>Enter 4");
        System.out.println("if you want to know the shipping cost                           ------>Enter 5");
        System.out.println("if you want to know the total price of order                   ------>Enter 6");
        System.out.println("if you want to display all order information                    ------>Enter 7");
        System.out.println("if you want to confirm order                                        ------>Enter 8");
    }
    /**
     * this method displays the order Info . 
     * @param Email 
     */
    public void displayOrderinfo(String Email){
        uc.ShowCartitems(Email);
    }
    /**
     * this method updates user Info (if needed) . 
     * @param Email
     */
    public void UpdatePersonalinfo(String Email){
        // user allow to update address or phonenumber only 
        System.out.println("if you want to Update Address ------->Enter 1");
        System.out.println("if you want to update Phonenumber --->Enter 2");
        int zz=sc.nextInt();
        if(zz==1){
            us.updateAddress(Email);
        }
        else if(zz==2){
            us.updatePhonenumber(Email);
        }
        else{
            System.out.println("invlid input ");
        }
    }
    /**
     * this method updates order Items (if needed) . 
     * @param Emial 
     */
    public void UpdateOrderitems(String Emial){
        System.out.println("if you want to add item to the Cart             --------->Enter 1");
        System.out.println("if you want to remove item from the Cart        --------->Enter 2");
         System.out.println("if you want to increase the Quantity of sepcific item--->Enter 3");
        System.out.println("if you want to decrease the Quantity of sepcific item --->Enter 4");
        int xx=sc.nextInt();
        uc.setEmail(Emial);
        if(xx==1){
            uc.Additem();
        }
        else if(xx==2){
            uc.Removeitem();
        }
        else if(xx==3){
            uc.increaseQuanofItem();
        }
        else if(xx==4){
            uc.decreaseQuanofItem();
        }
        else{
            System.out.println("invalid input");
        }
    }

    /**
     *
     * @param Email
     * @return
     */
    public double CalculateitemPrice(String Email){
        return uc.gettotalprice(Email);
    }

    /**
     *
     * @return
     */
    public double getShippingprice(){
        // this is no implementation of this part in the assignement
        // as admin who should put schema about shipping cost
        return 50.0;
    }

    /**
     *
     * @param Email
     * @return
     */
    public double CalculatetotalPrice(String Email){
        return CalculateitemPrice(Email)+getShippingprice();
    }

    /**
     *
     * @param Email
     * @return
     */
    public boolean Payment(String Email){
        Cash c1=new Cash();
        if(c1.CheckCashConstraints(Email) && c1.otpValidation(Email)){
            System.out.print("valid to pay Cash");
            System.out.println("the totla price of the order is "+CalculatetotalPrice(Email));
            return true;
        }
        else{
            System.out.println("This order is not valid to paid Cash");
        }
        return false;
    }
    /**
     * this method show all order Info. 
     * @param Email 
     */
    public void ShowAllorderinfo(String Email){
        uc.ShowCartitems(Email);
        us.displaypersonalinfo(Email);
        System.out.println("the total price of items in your cart is "+CalculateitemPrice(Email));
        System.out.println("the  price of Shipping is "+getShippingprice());
        System.out.println("the totla price of the order is "+CalculatetotalPrice(Email));
    }
    /**
     * this method confirm order. 
     * @param Email
     */    
    public void ConfirmOrder(String Email){
        System.out.println("if you want to Confirm order -------->Enter 1");
        int x=sc.nextInt();
        if(x==1){
            if(Payment(Email)){
            System.out.println("order confirmed");
            System.out.print("Thanks For using Toffee Store");
            AddtoDB(Email);
            }
            else{
                System.out.println("order not confirmed");
            }
        }
        else{
            System.out.println("order not confirmed");
        }
    }
    /**
     * this method addLoyaltyPoints. 
     */     
    public void AddLoyaltyPoints(){
        // this no implementation for profile in this assignment 
        // the responsability of this function is to Add points that customet get because confirm order 
        System.out.println("loyalty points is added ");
    }
    /**
     * this method updateProfile. 
     */  
    public void updateProfile(){
        // this no implementation for profilr in this  assigment;
        // this function to update profile to increase the loyalty points after confirmation of the order and 
        // the points apperead in the profile so this function responsability is to update points in profile
        System.out.println("Profile has updated");
        
    }
    /**
     * this method updateCustomerOrders. 
     */  
    public void UpdateCustomeroldorders(){
        // there are no implementation for old orders in this assignmnt 
        // this function to update the old orders part in the profile of the user to enable him to do reorder to any other previous orders
        System.out.println("old orders are updated ");
    }
    /**
     * this method add the order to database. 
     * @param Email
     */  
    public void AddtoDB(String Email){
           PrintWriter out = null;
    try {
        out = new PrintWriter(new BufferedWriter(new FileWriter("Orders.txt", true)));
        out.println(us.getline(Email));
        Vector<String>vec2=uc.ShowCartitems(Email);
        for(int i=0 ; i<vec2.size() ; i++){
            out.println(vec2.get(i));
        }
        
    } catch (IOException e) {
        System.err.println(e);
    } finally {
        if (out != null) {
            out.close();
        }
      }
   }
}

