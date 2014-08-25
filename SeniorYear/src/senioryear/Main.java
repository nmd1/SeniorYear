package senioryear;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        mainProgram();
    }
    public static void mainProgram() {
        Node BananaPeel = null;
        Info earth = null;
        
        
        
        
        print("1- Insert at end");
        print("2- Insert Anywhere");
        print("3- Print");
        print("4- Count");
        print("5- Search");
        print("6- Delete");
        print("7- Sort");
        print("8- Edit");
        
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        
        switch(choice) {
            case 1:
                BananaPeel = Edit.insertAtEnd(BananaPeel);
                print(BananaPeel.getPlanet() + "");
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            default:
                print("ERROR 1: Did not understand input");
                break;
                
        }
    }
    
    public static void print(String s) {
        System.out.println(s);
    }



} 


//1. Create Node (and create Info Object)
//2. Put it in the list at the end