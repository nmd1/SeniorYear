/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree;

import java.util.Scanner;


public class main {

    public static void main(String[] args) {
        boolean looper = true;
        pl("The Binary Program");
        pl("1- Insert");//done
        pl("2- PreOrder Transversal"); //done
        pl("3- Inorder Transversal");  //done
        pl("4- PostOrder Transversal");//done
        pl("5- Search"); //return "the string is in" or "the string isn't in" //done
        pl("6- Count");//traversal //done
        pl("7- Edit"); //not done
        pl("8- Delete");//DO THIS //EXTRA CREDIT
        pl("9- Print");//can't really do unfortuately.
        pl("0- Exit");
        Treenode root = new Treenode();
        while(looper) {
            Scanner c = new Scanner(System.in);


            
            p("Input your numb here: ");



            /*TEST ZONE
            String first = "OOH";
            String second = "OOH";
            //if first is 1st -1
            //if second is 1st 1
            System.out.println(first.compareToIgnoreCase(second) == 0 ? "First is bigger than second true" : "First is bigger than second false");
            System.exit(0);

            *///END OF THE TEST ZONE
            int j = c.nextInt();

            switch(j) {
                case 1:
                    Treenode newNode = makeNode("What do you want to add to the tree?");
                    //Insert

                    //create a node and put something into it (newNode
                    if(root.getString() == null) {
                        root = newNode;
                    } else {
                        pl(root.getString());
                        root = insert(root, newNode);
                    }
                    //Treenode root insert(Treenode object)
                    //root = insert(newNode);
                    //is null?
                    //Null --> 
                    //  root = tempNode
                    //Not null-->
                    //  
                    //left is bigger, right is smaller
                    break;
                case 2:
                    preOrder(root);
                    pl();
                    break;
                case 3:
                    inOrder(root);
                    pl();
                    break;
                case 4:
                    postOrder(root);
                    pl();
                    break;
                case 5:
                    Treenode searchNode = makeNode("Input String to search");
                    search(root, searchNode);
                    break;
                case 6:
                    if(root == null) {
                        pl("0");
                    } else {
                        int a = count(root, 0);
                        pl((a - 1) + "");
                    }
                    break; 
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    //print
                    //recursion with stopping state being null.
                default:
                    looper = false;
                    break;
            }
        }
    }
    
    
    public static void p(String a) {
        System.out.print(a);
    }
    public static void pl(String a) {
        System.out.println(a);
    }
    public static void pl() {
        System.out.println();
    }
    
    public static Treenode makeNode(String s) {
        pl(s);
        Scanner c = new Scanner(System.in);
        String message = c.nextLine();
        Treenode newNode = new Treenode();
        newNode.setString(message);
        return newNode;
    }
    
    public static Treenode insert(Treenode root, Treenode p) {
        //if first is 1st -1
        //if second is 1st 1
        
        //or
        
        //The value you input is bigger if positive
        //The value you input is smaller if negative
        String top = root.getString();
        String test = p.getString();
        
        int value = top.compareToIgnoreCase(test); 
        
        if(value < 0) {
            //test = W
            //top = A
            //So, test needs to go to the left
            
            if(root.getLeft() == null) {
                root.setLeft(p);
                pl("Setting this to the left of " + root.getString());
                return root;
            } else {
                pl("Recursive left!");
                insert(root.getLeft(), p);  
            }
            
        } else if (value > 0) {
            //test = A
            //top = W
            //so, test needs to go to the right
            
            if(root.getRight() == null) {
                root.setRight(p);
                pl("Setting this to the right of " + root.getString());
                return root;
            } else {
                pl("Recursive right!");
                insert(root.getRight(), p);  
            }
        } else if (value == 0) {
            pl("Value already in Tree");
            return root;
        }
        return root;
    }
    
    public static Treenode search(Treenode root, Treenode search) {
        String top = root.getString();
        String test = search.getString();
        
        int value = top.compareToIgnoreCase(test); 
        
        if(value < 0) {
            //test = W
            //top = A
            //So, test needs to go to the left
            
            if(root.getLeft() == null) {
                return root;
            } else if(root.getLeft().getString().equalsIgnoreCase(test)) {
                pl("It is found");
                return root;
            } else {
                pl("Recursive left!");
                search(root.getLeft(), search); 
            }
            
        } else if (value > 0) {
            //test = A
            //top = W
            //so, test needs to go to the right
            
            if(root.getRight() == null) {
                return root;
            } else if(root.getRight().getString().equalsIgnoreCase(test)) {
                pl("It is found");
                return root;
            } else {
                pl("Recursive left!");
                search(root.getRight(), search); 
            }
        } else if (value == 0) {
            pl("Value is found! first");
            return root;
        }
        pl("Does not exist in tree.");
        return root;
    }
    
    public static Treenode postOrder(Treenode root) {
        if(root == null) {
            return root;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        p(" " + root.getString() + " ");
        
        return root;
    }
    
    public static int count(Treenode root, int c) {
        
        if(root == null) {
            c++;
            return c;
        }
        c = c + count(root.getLeft(), 0);
        c = c + count(root.getRight(), 0);
        
        return c;
    }
    
    public static Treenode inOrder(Treenode root) {
        if(root == null) {
            return root;
        }
        inOrder(root.getRight());
        p(" " + root.getString() + " ");
        inOrder(root.getLeft());
        
        return root;
    }
    
    public static Treenode preOrder(Treenode root) {
        if(root == null) {
            return root;
        }
        
        p(" " + root.getString() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
        return root;
    }
    
    public static void printTree(Treenode root) {
        
        pl("\t\t" + root.getString());
    }
}
//yams  salad  kettles  lemons  limes  jam  jelly  grapes  cherries  clams  banana  oranges  apples