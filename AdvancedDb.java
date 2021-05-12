/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advanced.db;

import java.util.ArrayList;
import java.util.Scanner;

public class AdvancedDb {

    static Scanner in = new Scanner(System.in);
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<String> age = new ArrayList<>();
    static ArrayList<String> address = new ArrayList<>();
    static ArrayList<String> salary = new ArrayList<>();
    static private int pin=0;
    
    public static void delayer(){
        in.nextLine();
    System.out.println("press any key to get back to the main menu");
    String delayer= in.nextLine();
    System.out.print("\033[H\033[2J");  
    System.out.flush(); 
}
    private static void pass_create() throws InterruptedException{
        
        boolean cond= true;
        System.out.println("please enter new pin");
        pin = in.nextInt();
        while (cond){
        
        System.out.println("please confirm new pin");
        if(in.nextInt()==pin){
            System.out.println("PIN saved");
            cond= false;
        }
        else {System.out.println("incorrect confirmation please try again");}
    }
    System.out.println("you will be redirected to the main screen now");  
    Thread.sleep(2000);
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
    }
    private static int pass_verf(int input){
       
        if(input == pin ){
            System.out.println("\nPIN verified");
        return 1 ;}
        else{return 0;}
    }
    public static void add() throws InterruptedException {
        
        System.out.println("please enter the");
        System.out.print("name :");
        names.add(in.nextLine());       
        System.out.print("age  :"); 
        age.add(in.nextLine());         
        System.out.print("address :");
        address.add(in.nextLine());   
        System.out.print("salary  :");    
        salary.add(in.nextLine());   
        delayer();
    }
    public static void view() throws InterruptedException {
        for (int x = 0; x < names.size() && x < age.size() && x < address.size(); x++) {

            System.out.println("Name :"+names.get(x));
            System.out.println("Age  :"+age.get(x));
            System.out.println("Address :"+address.get(x) + "\t");
            System.out.println("salary  :" +salary.get(x) + "\n\t");

        }
        if (names.isEmpty() && age.isEmpty() && address.isEmpty()) {
            System.out.println("list is empty");
        }
            delayer();
    }
    public static void delete() throws InterruptedException {
        int ver;
        System.out.println("please enter your pin");
        ver=pass_verf(in.nextInt());
        if(ver==1){
        in.nextLine();
        System.out.println("please enter the name you want to be deleted");
        String input;

        input = in.nextLine();
        for (int x = 0; x < names.size() && x < age.size() && x < address.size(); x++) {
            if (input.equals(names.get(x))) {
                System.out.println("info of the name (" + input + ")\n is deleted");
                names.remove(x);
                age.remove(x);
                address.remove(x);
            }
        }
    }
    else{System.out.println("Access not allowed");}
    System.out.println("press any key to get back to the main menu");  
    delayer();
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
    }
    public static void search() throws InterruptedException {
        System.out.println("enter the name you're searching for  ");
        String input;

        input = in.nextLine();
        for (int x = 0; x < names.size(); x++) {
            if (input.equals(names.get(x))) {
                System.out.println("INFO regarding " + input + "is found");
                System.out.println("name :" + names.get(x));
                System.out.println("age  :" + age.get(x));
                System.out.println("address :" + address.get(x));
                System.out.println("salary  :" + salary.get(x));
            } else {
                System.out.println("nothing is found regarding the input");
            }
        }
            if (names.isEmpty() && age.isEmpty() && address.isEmpty()) {
            System.out.println("list is empty");
            }
                delayer();  
    }
    public static void edit() throws InterruptedException{
        int ver;
        System.out.println("please enter your pin");
        ver=pass_verf(in.nextInt());
        if(ver==1){
        in.nextLine();
        System.out.println("enter the name you're searching for  ");
        String input;

        input = in.nextLine();
        for (int x = 0; x < names.size() ; x++) {
            if (input.equals(names.get(x))) {
                System.out.println("!! INFO !! ");
                System.out.println("Name :" + names.get(x));
                System.out.println("Age  :" + age.get(x));
                System.out.println("Address :" + address.get(x));
                System.out.println("Salary :" + salary.get(x)+"\n");
                System.out.println("editing window");
                System.out.println("if u dont want to change something leave it empty and press enter");
                System.out.print("New name :");
                input = in.nextLine();
                if(!input.isEmpty()){names.set(x,input);}               
                System.out.print("New age :");
                input = in.nextLine();
                if(!input.isEmpty()){age.set(x,input);}
                System.out.print("New address :");
                input = in.nextLine();
                if(!input.isEmpty()){address.set(x,input);}
                System.out.print("New salary :");
                input = in.nextLine();
                if(!input.isEmpty()){salary.set(x,input);}
            }
            else {
                System.out.println("nothing is found regarding the input");
            }
            } 
        
        }
        else{System.out.println("Access not allowed");}
        System.out.println("press any key to get back to the main menu");  
        in.nextLine();
        delayer();
    }
    public static void annual_increase() throws InterruptedException{
        System.out.println("enter the name for annual increment  ");
        String input;

        input = in.nextLine();
        double increment=0;
        double bef=0;
        double total=0;
        String converter;
        for (int x = 0; x < names.size(); x++) {
            if (input.equals(names.get(x))) {
                System.out.println("!!INFO!! ");
                System.out.println("name :" + names.get(x));
                System.out.println("salary  :" + salary.get(x));
                System.out.print("enter the increment percentage :"+" %");
                total=Double.parseDouble(salary.get(x));
                increment = in.nextDouble();
                bef = total*(increment/100);
                total += bef ;
                System.out.println("salary updated");
                System.out.println("Old salary : " + salary.get(x)+" + " +increment+ "%");
                System.out.println("New salary : " + total);
                converter=Double.toString(total);
                salary.set(x,converter);

            }
            else {System.out.println("name not found");}
        }
            delayer();
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        int x = 0;
        
        System.out.println("welcome\n\n");
        pass_create();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        
        while (x == 0) {
        System.out.println("what do you want to do ");
        System.out.println("1-Employee database editing ");
        System.out.println("2-Database managment");
        System.out.println("3-Annual increase ");
        System.out.println("5-exit \n");
            System.out.print("choice :");
                
                
            switch (in.nextInt()) {
                case 1:
                System.out.print("\033[H\033[2J");  
                System.out.flush();               
                System.out.println("1-Add a new employee");  
                System.out.println("2-Edit employee list");
                System.out.println("3-delete an employe");
                System.out.print("choice :");
                    
                    
                    switch (in.nextInt()){
                        case 1:
                        in.nextLine();
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();  
                        add();
                        break;
                        case 2:
                        in.nextLine();
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();  
                        edit();
                        break;
                        case 3:
                        in.nextLine();
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();  
                        delete();
                    }
                    break;
                case 2:
                System.out.print("\033[H\033[2J");  
                System.out.flush();  
                    System.out.println("1-view entire database ");   
                    System.out.println("2-search ");                    
                    switch(in.nextInt()){
                        case 1:
                        
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();  
                        in.nextLine();
                        view();
                        break;
                        case 2:
                        
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();  
                        in.nextLine();
                        search();
                        default:
                        break;
                    }                   
                    break;
                case 3:
                System.out.print("\033[H\033[2J");  
                System.out.flush();  

                in.nextLine();
                annual_increase();                  
                    break;
                case 4:
                    x = 1;
                    System.out.println("exiting now");
                    break;

                default:

                    System.out.println("incorrect input try again");

                    break;
            }
        }

    }

}
}