

package senioryear;

import java.util.Scanner;

public class Edit {
    
    public Edit() {
        
    }
    
    public static Node insertAtEnd(Node p) { //p represents the entire list
        //if empty assign p to node else assign p at end of list
        Node newNode = new Node();
        
        Scanner s = new Scanner(System.in);
        Info newPlanet = new Info();
        
        System.out.println("Name of Planet: ");
        newPlanet.setName(s.nextLine());
        System.out.println("Number from sun: ");
        newPlanet.setPlace(s.nextInt());
        
        newNode.setPlanet(newPlanet);
        
        if(p == null) {
            p = newNode;
            //the new node is passed into the first node
            //so the first node points to the new node
            
            /*how does the first statement lead to the second though....*/
        } else {
            Node q = p;
            //traversing (or advancing) the pointer
            while( q.getNext() != null) { //loop until the last node points to nothing
                q = q.getNext(); //advances a pointer
                
            }
            q.setNext(newNode);
        }
        
        return p;
    }
    
    public Node insertAnywhere(Node p) {
        return null;
    }
    
    public void delete() {
        
    }
    
    public void edit() {
        
    }
    
    public void print(Node p){
        while(p != null) {
            p = p.getNext();
            System.out.println(p.getPlanet().toString());
        }
    }
}
