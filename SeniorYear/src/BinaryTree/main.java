/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        p("The Binary Program");
        p("1- Insert");
        p("2- PreOrder Transversal"); //print
        p("3- Inorder Transversal");  //print
        p("4- PostOrder Transversal");//print
        p("5- Search");
        p("6- Count");//traversal
        p("7- Edit");
        p("8- Delete");
        p("0- Exit");
        Scanner c = new Scanner(System.in);
        
        p("Input your numb here: ");
        int j = c.nextInt();
        
        switch(j) {
            case 1:
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
                break;
        }
    }
    
    
    public static void p(String a) {
        System.out.println(a);
    }
}
