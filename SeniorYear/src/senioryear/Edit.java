

package senioryear;

import java.util.Scanner;

public class Edit {
    
    public Edit() {
        
    }
    
    private static Info createNewPlanet() {
        Info newPlanet = new Info();
        Scanner s = new Scanner(System.in);
        System.out.println("Name of Planet: ");
        newPlanet.setName(s.nextLine());
        System.out.println("Number from sun: ");
        newPlanet.setPlace(s.nextInt());
        System.out.println("Size of planet (in Kg): ");
        newPlanet.setSize(s.nextInt());
        System.out.println("Is there Life? (True/False): ");
        newPlanet.setLife(s.nextBoolean());
        return newPlanet;
    }
    public static Node insertAtEnd(Node p) { //p represents the entire list
        //if empty assign p to node else assign p at end of list
        Node newNode = new Node();
        Info newPlanet = createNewPlanet();
        
        
        //add two more fields
        
        newNode.setPlanet(newPlanet); //placed into node
        
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
    public static Node insertAnywhere(Node p) {
        Node newNode = new Node();
        Node q = new Node();
        Info newPlanet = createNewPlanet();
        
        newNode.setPlanet(newPlanet);
        
        if(p == null) {
            return insertAtEnd(p);
        } else {
            
        
        Scanner s = new Scanner(System.in);
        System.out.println("Insert This new Planet after which planet?: ");
        String search = s.next();
        
        if(!(q.getPlanet().getName().equalsIgnoreCase(search))) //if the first item does not equal the search
            
        do {
            q = q.getNext();    
        } while( !(q.getNext().getPlanet().getName().equalsIgnoreCase(search))); {
            //if the next node is not earth
            
        }
        //q ends up referencing earth.
        
        //now q equals the node whose planet name is the one we're looking for
        if(q.getNext().getPlanet().getName().equalsIgnoreCase(search)) {
            q = q.getNext();
            //if the next planet name equals the search name
            newNode.setNext(q.getNext());
            q.setNext(newNode);
            //node connection set up.
        } else {
            System.out.println("ERROR 404: Not Found");
            return p;
        }
    
        /*leave p where it is
        //create dummy q
        //advance q until we find what we looking for
        //if you hit null, print an error or not found
        //once q gets to the place where it needs to be, put new node there
        //make the new node point to the next thing
        //new node.setNext(q.getnext)
        //then move the list to point to new node
        q.setNext(newNode)*/
        return p;
        }
    }
    
    public void delete() {
        
    }
    
    public void edit() {
        
    }
    
    public static void print(Node p){
        while(p != null) {
            System.out.println(p.getPlanet().toString());
            p = p.getNext();
        }
    }
}
