/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toffee.Cart;
//import com.mycompany.toffee.Order.ConfirmOrder;
import com.mycompany.toffee.products.CatalogOfItems;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author smmdw
 */
public class UserCart {
    Scanner ss=new Scanner(System.in);
    CatalogOfItems ct=new CatalogOfItems();
    private String useremail;
    public void DisplayMenu(){
        System.out.println("if you want to add item to the Cart             --------->Enter 1");
        System.out.println("if you want to remove item from the Cart        --------->Enter 2");
        System.out.println("if you want to Display all items of your Cart   --------->Enter 3");
        System.out.println("if you want to increase the Quantity of sepcific item ----->Enter 4");
        System.out.println("if you want to decrease the Quantity of sepcific item ----->Enter 5");
        System.out.println("if you want to return to Categories                   ----->Enter 6");
        System.out.println("if you want to make order                             ------>Enter 7");
        System.out.println("if you want to close programm                         ------>Enter 8");

    }
    public void setEmail(String Email){
        useremail=Email;
    }
    public void Additem(){
        PrintWriter myWriter = null;
        try {
            myWriter = new PrintWriter(new BufferedWriter(new FileWriter("cart.txt", true)));
      System.out.println("Start adding item to Cart and if you want to stop adding to Cart enter 0");
           String str="";
           String str2="";
       while(!str2.equals("0")){
           System.out.println("Enter the id of items that you want to add to cart");
           str2=ss.nextLine();
           String line=ct.getline(str2);
           String[] values=line.split("\t\t");
           if(str2.equals("0"))break;
           System.out.println("Enter the quantity that you want from this item ");
           str=ss.nextLine();
           String addtofile=useremail+"\t\t"+str2+"\t\t"+str+"\t\t"+values[1]+"\t\t"+values[2];
           myWriter.print(addtofile+"\n");
       }
      myWriter.close();
      //System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
  }
    public String Remove(String item){
        String path="cart.txt";
        File file =new File(path);
        File templete=new File("Templete.txt");
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
                if(values[1].equals(item) &&values[0].equals(useremail)){
                        linetoremove=line;
                        //exist=true;
                        returnStr=values[2];
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
                System.out.println("This item is not exist in your Cart");
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
    public void Removeitem(){
        System.out.println("Enter the ID of item you want to remove ");
        String item=ss.nextLine();
        Remove(item);
    }
    public void increaseQuanofItem(){
         PrintWriter myWriter = null;
        System.out.println("Enter the ID of item that you want to increase its quantity ");
        String itemname=ss.nextLine();
        String OldQua=Remove(itemname);
        System.out.println("Enter the amount that you want to increase to this item ");
        int  increaseQua=ss.nextInt();
        try {
            myWriter = new PrintWriter(new BufferedWriter(new FileWriter("cart.txt", true)));
            int z=increaseQua+Integer.parseInt(OldQua);
            String line=ct.getline(itemname);
            String[] values=line.split("\t\t");
            String addtofile=useremail+"\t\t"+itemname+"\t\t"+z+"\t\t"+values[1]+"\t\t"+values[2];
           myWriter.print(addtofile+"\n");
           myWriter.close();
      //System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }    
  }
    public void decreaseQuanofItem(){
        PrintWriter myWriter = null;
        System.out.println("Enter the ID of item that you want to decrease its quantity ");
        String itemname=ss.nextLine();
        String OldQua=Remove(itemname);
        System.out.println("Enter the amount that you want to decrease to this item ");
        int  decreaseQua=ss.nextInt();
        try {
            myWriter = new PrintWriter(new BufferedWriter(new FileWriter("cart.txt", true)));
            if(Integer.parseInt(OldQua)<decreaseQua){
                System.out.println("This decrese quantity is greater than the quantity of this item which exist in the Cart");
                System.out.println("item will be removed from the cart");
            }
            else{
                //System.out.print("here");
            int z=Integer.parseInt(OldQua)-decreaseQua;
            String line=ct.getline(itemname);
            String[] values=line.split("\t\t");
            String addtofile=useremail+"\t\t"+itemname+"\t\t"+z+"\t\t"+values[1]+"\t\t"+values[2];
            myWriter.print(addtofile+"\n");
            myWriter.close();
            }
      //System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }    
 }
    public static Vector<String> ShowCartitems(String Email){
        String path="cart.txt";
        File file =new File(path);
        Vector<String>vec=new Vector<String>();
        PrintWriter out = null;
        try{
            System.out.println("Email        "+"\t\t\t"+"ProductID"+"\t"+"ProductQuantity"+"\t"+"ProductName"+"\t\t"+"Productprice"+"\t\t");
            Scanner inputBuffer=new Scanner (file);
            while(inputBuffer.hasNext()){
                String line=inputBuffer.nextLine();
                String[] values=line.split("\t\t");
                if(values[0].equals(Email)){
                   System.out.println(line); 
                   vec.add(line);
                }
               
            }
        } catch(IOException e) {
        System.err.println(e);
    } finally {
        if (out != null) {
            out.close();
        }
        }
        //for(int i=0 ; i<vec.size(); i++)System.out.println(vec.get(i));
        return vec;
    }
    public double gettotalprice(String Email){
        String path="cart.txt";
        File file =new File(path);
        double price=0.0;
        PrintWriter out = null;
        try{
            Scanner inputBuffer=new Scanner (file);
            while(inputBuffer.hasNext()){
                String line=inputBuffer.nextLine();
                String[] values=line.split("\t\t");
                if(values[0].equals(Email)){
                   price+=(Double.valueOf(values[4])*Double.valueOf(values[2])); 
                }
            }
        } catch(IOException e) {
        System.err.println(e);
    } finally {
        if (out != null) {
            out.close();
        }
        }
        return price;
        
    }
    public void Makeorder(){
        // will call control function in toffee App;
    }
}
