package DoubleList;

import java.util.Scanner;
import senioryear.Edit;
import senioryear.Node;
import senioryear.Utilities;

public class Main {
    public static void main(String[] args) {
        
        mainProgram();
        
    }
    public static void mainProgram() {
        boolean looper = true;
        Node BananaPeel = null;
        //preset List for debugging
        BananaPeel = Edit.insertAtEnd(BananaPeel);
        BananaPeel = Edit.insertAtEnd(BananaPeel);
        BananaPeel = Edit.insertAtEnd(BananaPeel);
        //end preset list for debugging
        while(looper) {
        
            
            print("1- Insert at end");//kj
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
                    break;
                case 2:
                    BananaPeel = Edit.insertAnywhere(BananaPeel);
                    break;
                case 3:
                  //Edit.print(BananaPeel);
                    Edit.print(BananaPeel); //for visual
                    //Edit.print(BananaPeel);//for paragraph
                    break;
                case 4:
                    Utilities.count(BananaPeel);
                    break;
                case 5:
                    Utilities.search(BananaPeel);
                    break;
                case 6:
                    BananaPeel = Edit.delete(BananaPeel);
                    break;
                case 7:
                    BananaPeel = Utilities.sort(BananaPeel);
                    break;
                case 8:
                    BananaPeel = Utilities.edit(BananaPeel);
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
            Edit.print(BananaPeel, "BananaPeel"); //Show node visually at end of loop
            print("");
        } //looper ends
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
