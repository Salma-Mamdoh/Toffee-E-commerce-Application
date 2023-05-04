/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toffee;
import com.mycompany.toffee.EnterUser.Login;
import com.mycompany.toffee.EnterUser.SignUp;
import com.mycompany.toffee.products.CatalogOfItems;
import com.mycompany.toffee.Cart.UserCart;
import java.util.*;
/**
 *
 * @author smmdw
 */
public class ToffeeApp {
    public void signup(){
        SignUp x=new SignUp();
            x.EnterUserData();
            if(x.OTPValidation()){
                System.out.println("Successful Registration");
                x.AddUserToDB();
            }
    }
    public String Login(){
         Login y=new Login();
            y.EnterData();
            
            while(!y.Check()){
                System.out.print("Login Faild\n");
                y.EnterData();
            }
            System.out.println("Successful Login ");
            System.out.println("Now You are in Our Toffee Store ");
            String Email=y.getEmail();
            return Email;
    }
    public boolean Catalog(){
        CatalogOfItems c=new CatalogOfItems();
        Scanner s=new Scanner (System.in);
        System.out.println("For all Catalog                 ---------> Enter 1");
        System.out.println("For products of specific Category -------> Enter 2");
        int z=s.nextInt();
        if(z==1){
            c.Showallproducts();
        }
        else{
        c.displayCategoryMenu();
        c.getCategoryType();
        c.ShowCategoryProducts();
        }
        System.out.println("If you want to show Another Calegory Products -------->  Enter 1");
        System.out.println("if you want to deal with Cart options       ----------> Enter 2");
        System.out.println("if you want to end the Program                --------> Enter 3");
        int ch=s.nextInt();
        if(ch==1){
            Catalog();
        }
        else if(ch==2){
            return true;
        }
        else if(ch==3){
            System.exit(0);
        }
        else{
            System.out.println("invalid input");
        }
        return false;
    }
    public void Cart(String Email){
        //System.out.print(Email);
        UserCart c1=new UserCart();
        c1.setEmail(Email);
        c1.DisplayMenu();
        Scanner input=new Scanner(System.in);
        int chofmenu=input.nextInt();
        if(chofmenu==1){
            c1.Additem();
        }
        else if(chofmenu==2){
            c1.Removeitem();
        } 
        else if(chofmenu==3){
            c1.ShowCartitems(Email);
        }
        else if(chofmenu==4){
            c1.increaseQuanofItem();
        }
        else if(chofmenu==5){
            c1.decreaseQuanofItem();
        }
        else if(chofmenu==6){
            Catalog();
        }
        else {
            System.out.print("invalid input \n");
            System.exit(0);
        }
    }
    public void run(){
        System.out.print("Welcome in Toffee Store Application\n");
        System.out.print("Choose one option from the following Menu:\n");
        System.out.print("Signup ----------> Enter 1\n");
        System.out.print("Signin ----------> Enter 2\n");
        System.out.print("Show Products----> Enter 3\n"); 
        Scanner sc= new Scanner(System.in); 
        int a=sc.nextInt();
        //System.out.print(a);
         String uemail="";
        if(a==1){
                signup();
                System.out.print("if you want to continue enter 1 else enter 0: ");
                int ch=sc.nextInt();
                if(ch==0)System.exit(0);
                else {
                   Login();  
                }
        }
        else if(a==2){
            uemail=Login();
            System.out.print("if you want to continue enter 1 else enter 0: ");
                int ch=sc.nextInt();
                if(ch==0)System.exit(0);
                else {
                    if(Catalog()){
                        Cart(uemail);
                    }
                   
                }  
        }
        else if(a==3){
            if(Catalog() && !uemail.isEmpty()){
                Cart(uemail);
            }
            else{
                System.out.println("You must login before dealing with Cart ");
                uemail=Login();
                System.out.print("if you want to continue enter 1 else enter 0: ");
                int ch=sc.nextInt();
                if(ch==0)System.exit(0);
                else {
                    Cart(uemail);
                }  
            }
           
        }
        else{
            System.out.print("invalid input\n");
            System.exit(0);
        }
        
        
    }
}
