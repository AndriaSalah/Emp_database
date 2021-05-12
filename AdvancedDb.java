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
    static ArrayList<String> st_name = new ArrayList<>();
    static ArrayList<String> age = new ArrayList<>();
    static ArrayList<String> address = new ArrayList<>();

public static void add_info(){

    System.out.print("enter Name :");
    st_name.add(in.nextLine());

    System.out.print("enter age :");
    age.add(in.nextLine());
    
    System.out.print("enter address :");
    address.add(in.nextLine());
     
    System.out.print("\n\n\n");
    }

    public static void view() {
        for (int x = 0; x < st_name.size() && x < age.size() && x < address.size(); x++) {

            System.out.println(st_name.get(x));
            System.out.println(age.get(x));
            System.out.println(address.get(x) + "\t");
            System.out.print("\n\n\n");

        }
        if (st_name.isEmpty() && age.isEmpty() && address.isEmpty()) {
            System.out.println("list is empty");
        }
    }

    public static void delete() {
        System.out.println("please enter the name you want to be deleted");
        String input;

        input = in.nextLine();
        for (int x = 0; x < st_name.size() && x < age.size() && x < address.size(); x++) {
            if (input.equals(st_name.get(x))) {
                System.out.println("info of the name (" + input + ")\n is deleted");
                st_name.remove(x);
                age.remove(x);
                address.remove(x);
            }
        }
        System.out.print("\n\n\n");
    }

    public static void search() {
        System.out.println("enter the name or age you're searching for  ");
        String input;
        int chkr=0;
        input = in.nextLine();
        for (int x = 0; x < st_name.size() && x < age.size() && x < address.size(); x++) {
            if (input.equals(st_name.get(x))) {
                System.out.println("INFO regarding (" + input + ") is found");
                System.out.println("name :" + st_name.get(x));
                System.out.println("age  :" + age.get(x));
                System.out.println("address :" + address.get(x));
                chkr++;
            } else if (input.equals(age.get(x))) {
                System.out.println("students with the age (" + input + ")");
                System.out.println("name :" + st_name.get(x));
                System.out.println("age  :" + age.get(x));
                System.out.println("address :" + address.get(x) + "\t");
                chkr++;
            } 
            if(chkr==0){
                System.out.println("nothing is found regarding the input");
            }
        }
            if (st_name.isEmpty() && age.isEmpty() && address.isEmpty()) {
            System.out.println("list is empty");
            }

    }

    public static void main(String[] args) {

        int x = 0;
        int w_a=0;
        System.out.println("welcome\n\n");
        System.out.println("what do you want to do ");
        System.out.println("1-view the lsit of students ");
        System.out.println("2-add a new student");
        System.out.println("3-delete a student ");
        System.out.println("4-search for student ");
        System.out.println("5-exit \n");
        while (x == 0) {
            System.out.print("choice :");
                w_a=in.nextInt();
                in.nextLine();
             switch (w_a) {
                case 1:
                    view();
                    break;
                case 2:
                System.out.print("\033[H\033[2J");  
                System.out.flush();  
                    add_info();
                  
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    search();
                    break;
                case 5:
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

