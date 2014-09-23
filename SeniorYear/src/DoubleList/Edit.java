

package DoubleList;

import senioryear.*;
import java.util.Scanner;
import java.util.*;

public class Edit {
    static int debugcount = 1; // DELETE THIS LATER
    static Random rand = new Random();
    static int pla = rand.nextInt((10 - 3) + 1) + 3;//between 3 and 10
    public Edit() {
        
    }    
    public static Info createNewPlanet() {
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
    private static Info createNewPlanet(String name, int i) {
        Info newPlanet = new Info();
        newPlanet.setName(name);
        newPlanet.setPlace(i);
        newPlanet.setSize((int)Math.pow(i, 2));
        newPlanet.setLife(false);
        return newPlanet;
    }
    private static Info nodeOrNah() {
        Info newPlanet = new Info();
            if(debugcount == 1) {
                newPlanet = createNewPlanet("first", pla);
                debugcount = 2;
                return newPlanet;
            } else if(debugcount == 2) {
                newPlanet = createNewPlanet("second", pla + 2);
                debugcount = 3;
                return newPlanet;
            } else if(debugcount == 3) {
                newPlanet = createNewPlanet("third", pla + 1);
                debugcount = 100;
                return newPlanet;
            } else {
                newPlanet = createNewPlanet();
                return newPlanet;
            }
        
    }
    public static Node insertAtEnd(Node p) {
        Node newNode = new Node();
        Info newPlanet = nodeOrNah();
        //newPlanet = createNewPlanet();
        newNode.setPlanet(newPlanet); //placed into node
        


        if(p == null) {
            p = newNode;
            
        } else {
            Node q = p;
            //traversing (or advancing) the pointer
            while( q.getNext() != null) { //loop until the last node points to nothing
                q = q.getNext(); //advances a pointer
                
            }
            q.setNext(newNode);
            newNode.setPrevious(q);
        }
        
        return p;
    } 
    public static Node insertAnywhere(Node p) {
        if(p == null) {
            return insertAtEnd(p);
        } else {
        Node newNode = new Node();
        Node q = new Node();
        
        Info newPlanet = createNewPlanet();
        
        newNode.setPlanet(newPlanet);
        
        

        Scanner s = new Scanner(System.in);
        System.out.println("Insert This new Planet after which planet? (1 for first): ");
        String search = s.next();
        
        q = p;
        
        if(search.charAt(0) == '1'){
            newNode.setNext(p);
            p = newNode;
            return p;
        }
        
        //test to see if it exists:
        boolean loop = true;
        Node j = p;
        while(loop) {
            if(j.getPlanet().getName().equalsIgnoreCase(search)) {
                loop = false;
            } else {
                if(j.getNext() == null){ 
                System.out.println("Error 404: Planet not found"); 
                return p;
                }
                j = j.getNext(); 
            }
        }
        
        if(!(q.getPlanet().getName().equalsIgnoreCase(search))){ //if the first item does not equal the search
            
        //q = q.getNext();
            
        while( !(q.getNext().getPlanet().getName().equalsIgnoreCase(search))) {
            q = q.getNext();
        }
        
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
    public static Node delete(Node p) {    
        int index = 1;
        System.out.println("Search for Planet or for Planet Location?");
        System.out.println("P for Planet, L for index location:");
        Scanner t = new Scanner(System.in);
        String testprime = t.next().toLowerCase();
        char test = testprime.charAt(0);
        Scanner s = new Scanner(System.in);
        int counter = 0;
        if(test == 'p'){
            System.out.println("Insert a planet name to delete: ");
            String PlanetSearch = s.next();
            Node i = p;
            boolean loop = true;
            
            while(loop) {
                counter++; //starts on 1
               //System.out.println(i.getPlanet().getName() + "<--->" + PlanetSearch);
                if(i.getPlanet().getName().equalsIgnoreCase(PlanetSearch)){
                    index = counter;
                    loop = false;
                } else {
                    if(i.getNext() == null){ 
                    System.out.println("Error 404: Planet not found"); 
                    return p;
                    }
                    i = i.getNext(); 
                }
            }
        } else if(test == 'l') {
            System.out.println("Insert the place of the planet (number): ");
            index = s.nextInt();
            Node i = p;
            while(i.getNext() != null) {
                if(i.getPlanet().getPlace() == index){
                    index = i.getPlanet().getPlace();
                    //it exists!
                } else {
                    if(i.getNext() == null) {System.out.println("Error 404: Planet not found 2"); return p;}
                }
                i = i.getNext();
            }            
        } else {
            System.out.println("Error 43: Not Understood"); return p;
        }
        
        //index = 1;//get rid of this for any of the above to be revelent
        //System.out.println(index);
        //node stuffs//
        counter = 1;
        if(index == 1) {
           p = p.getNext(); 
        } else {
            
            Node j = p, q = p;
            q = q.getNext(); //making it the leader
            counter++; //equals 2
            //loop until q finds the index
            while(counter != index) {
                q = q.getNext();
                j = j.getNext();
                counter++;
            }
            j.setNext(q.getNext());
        }
        // AS MR.BALCAR ABOUT THIS!!!!
        //advance p 
        //advance p again
        //loop {
        // advance p AND q
        //when p hits the thing you want, stap loop
        //}
        //q.setNext(p.getNext())
        return p;
    }

    public static void print(Node p){
        while(p != null) {
            System.out.println(p.getPlanet().toString());
            p = p.getNext();
        }
    }
    public static void print(Node p, String s) {
        Node q = p;
        
        if(q == null) {
            System.out.print("[Null]");
            return;
        }
        
        
        boolean flag = true;
        System.out.print(s + "--> [null]");
        while(flag) {
            if(q.getPrevious() != null) {
                if(q.getNext() != null) {
                    System.out.print("<--["+ q.getPlanet().getName() + "|" + q.getPlanet().getPlace() + "]-->" );
                } else if(q.getNext() == null) {
                    System.out.println("[Null]");
                    flag = false; 
                    break;
                }                
            } else {
                if(q.getNext() != null){
                System.out.print("["+ q.getPlanet().getName() + "|" + q.getPlanet().getPlace() + "]-->" );
                } else if(q.getNext() == null) {
                    System.out.println("[Null]");
                    flag = false; 
                    break;
                }
                
            }
            q = q.getNext();
        }
        
    }
    
}
