package DoubleList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        mainProgram();
        
    }
    public static void mainProgram() {
        boolean looper = true;
        Node pointer = null;
        //preset List for debugging
        pointer = Edit.insertAtEnd(pointer);
        pointer = Edit.insertAtEnd(pointer);
        pointer = Edit.insertAtEnd(pointer);
        //end preset list for debugging
        
        while(looper) {
        
            
            print("1- Insert at end");
            print("2- Insert Anywhere");
            print("3- Print");
            print("4- Count");
            print("5- Search");
            print("6- Delete");
            print("7- Sort");
            print("8- Edit");
            print("9- Print all");
            

            Scanner s = new Scanner(System.in);
            int choice = 50;
            choice = tryCatch(choice, s);

            switch(choice) {
                case 1:
                    pointer = Edit.insertAtEnd(pointer);
                    break;
                case 2:
                    pointer = Edit.insertAnywhere(pointer);
                    break;
                case 3:
                  //Edit.print(BananaPeel);
                    Edit.print(pointer); //for visual
                    //Edit.print(BananaPeel);//for paragraph
                    break;
                case 4:
                    Utilities.count(pointer);
                    break;
                case 5:
                    Utilities.search(pointer);
                    break;
                case 6:
                    pointer = Edit.delete(pointer);
                    break;
                case 7:
                    pointer = Utilities.sort(pointer);
                    break;
                case 8:
                    pointer = Utilities.edit(pointer);
                    break;
                case 9:
                    Edit.print2(pointer);
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
            Edit.print(pointer, "BananaPeel"); //Show node visually at end of loop
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
