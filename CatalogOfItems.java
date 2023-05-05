/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toffee.products;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author smmdw
 */
public class CatalogOfItems {
    private int ch;
    public void Showallproducts(){
        String path="products.txt";
        File file =new File(path);
        
        PrintWriter out = null;
        try{
            Scanner inputBuffer=new Scanner (file);
            while(inputBuffer.hasNext()){
                String line=inputBuffer.nextLine();
                System.out.print(line);
                System.out.print("\n");
            }
        } catch(IOException e) {
        System.err.println(e);
    } finally {
        if (out != null) {
            out.close();
        }
        }
    }
    public void displayCategoryMenu(){
        System.out.println("Enter the number of the Catergory you want: ");
        System.out.println("For Choclate ---------> Enter 1: ");
        System.out.println("For Toffee   ---------> Enter 2: ");
        System.out.println("For Cady     ---------> Enter 3: ");
    }
    public void getCategoryType(){
        Scanner sc= new Scanner(System.in);
         ch=sc.nextInt();
    }
    public void ShowCategoryProducts(){
        if(ch==1){
             String path="products.txt";
        File file =new File(path);
        
        PrintWriter out = null;
        
        try{
            Scanner inputBuffer=new Scanner (file);
            while(inputBuffer.hasNext()){
                boolean flg=false;
                String line=inputBuffer.nextLine();
                String[] values=line.split("\t\t");
                if(values[0].matches("^CH[1-9]$")){
                   flg=true; 
                }
                if(flg){
                    System.out.println(line);
                }
            }
        } catch(IOException e) {
        System.err.println(e);
    } finally {
        if (out != null) {
            out.close();
        }
        }
         }
         else if(ch==2){
             String path="products.txt";
        File file =new File(path);
        
        PrintWriter out = null;
        
        try{
            Scanner inputBuffer=new Scanner (file);
            while(inputBuffer.hasNext()){
                boolean flg=false;
                String line=inputBuffer.nextLine();
                String[] values=line.split("\t\t");
                if(values[0].matches("^TO[1-7]$")){
                   flg=true; 
                }
                if(flg){
                    System.out.println(line);
                }
            }
        } catch(IOException e) {
        System.err.println(e);
    } finally {
        if (out != null) {
            out.close();
        }
        }
             
         }
         else if(ch==3){
             String path="products.txt";
        File file =new File(path);
        
        PrintWriter out = null;
        
        try{
            Scanner inputBuffer=new Scanner (file);
            while(inputBuffer.hasNext()){
                boolean flg=false;
                String line=inputBuffer.nextLine();
                String[] values=line.split("\t\t");
                if(values[0].matches("^CA[1-5]$")){
                   flg=true; 
                }
                if(flg){
                    System.out.println(line);
                }
            }
        } catch(IOException e) {
        System.err.println(e);
    } finally {
        if (out != null) {
            out.close();
        }
        }
         }
         else{
             System.out.print("Invalid input\n");
         }
    }
    public String getline(String id){
         String path="products.txt";
        File file =new File(path);
        String toreturn="";
        PrintWriter out = null;
        try{
            Scanner inputBuffer=new Scanner (file);
            while(inputBuffer.hasNext()){
                String line=inputBuffer.nextLine();
                String[] values=line.split("\t\t");
                if(values[0].equals(id)){
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
}
