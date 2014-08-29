package senioryear;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        mainProgram();
        
    }
    public static void mainProgram() {
        boolean looper = true;
        Node BananaPeel = null;
        while(looper) {
           
        print("1- Insert at end");
        print("2- Insert Anywhere");
        print("3- Print");
        print("4- Count");
        print("5- Search");
        print("6- Delete");
        print("7- Sort");
        print("8- Edit");
        
        Scanner s = new Scanner(System.in);
        int choice = 50;
        choice = tryCatch(choice, s);
        
        switch(choice) {
            case 1:
                BananaPeel = Edit.insertAtEnd(BananaPeel);
                print(BananaPeel.getPlanet() + "");
                break;
            case 2:
                break;
            case 3:
                Edit.print(BananaPeel);
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
        
        
        s = null;
        print("Go back?");
        Scanner n = new Scanner(System.in);
        
        String nextq = "";
        nextq = tryCatch(nextq, n);
        
        char nq = nextq.toLowerCase().charAt(0);
        switch(nq) {
            case 'y':
                print("-----\n\nAGAIN!\n\n----\n");
                break;
            case 'n':
                looper = false;
                break;
            default:
                print("I don't understand what you said, so loop again!\n ------");
                break;
        }        
        } // looper ends
    }
    public static void print(String s) {
        System.out.println(s);
    }
    public static int tryCatch(int i, Scanner s) {
        try{
            return s.nextInt();
        } catch(java.util.InputMismatchException e) {
            return 23;
        }
    }
    public static String tryCatch(String i, Scanner s) {
        try{
            return s.next();
        } catch(java.util.InputMismatchException e) {
            return "ERROR";
        }
    }
    
} 


//1. Create Node (and create Info Object)
//2. Put it in the list at the end