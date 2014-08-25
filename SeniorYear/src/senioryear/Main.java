package senioryear;
public class Main {
    public static void main(String[] args) {
        Node first = null;
        Info earth = null;
        
        
        
        
        print("1- Insert at end");
        print("2- Insert Anywhere");
        print("3- Print");
        print("4- Count");
        print("5- Search");
        print("6- Delete");
        print("7- Sort");
        print("8- Edit");
        
        //one
        first = Edit.insertAtEnd(first);
        print(first.getPlanet() + "");
        
    }

    public static void print(String s) {
        System.out.println(s);
    }
} 


//1. Create Node (and create Info Object)
//2. Put it in the list at the end