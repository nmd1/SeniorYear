

package senioryear;

import java.util.Scanner;
import java.util.*;

public class Edit {
    static int debugcount = 1; // DELETE THIS LATER
    static Random rand = new Random();
    static int pla = rand.nextInt((10 - 3) + 1) + 3;//between 3 and 10
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
    public static Info createNewPlanet(String name, int i) {
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
    public static Node insertAtEnd(Node p) { //p represents the entire list
        Node newNode = new Node();
        Info newPlanet = nodeOrNah();
        //newPlanet = createNewPlanet();
        newNode.setPlanet(newPlanet); //placed into node
        

        //if empty assign p to node else assign p at end of list
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
    public static Node search(Node p) {
        Scanner s = new Scanner(System.in);
        System.out.println("Insert a planet name to search: ");
        String PlanetSearch = s.next();
        Node q = p;
        boolean loop = true;
        int counter = 0;
        while(loop) {
            counter++; //start off with 1
            if(q.getPlanet().getName().equalsIgnoreCase(PlanetSearch)) {
                System.out.println(PlanetSearch + " is " + q.getPlanet().getPlace() 
                        + " spots away from the sun and" +
                        " has an index of " + counter);
                loop = false;
            } else {
                if(q.getNext() == null){ 
                System.out.println("Error 404: Planet not found"); 
                return p;
                }
                q = q.getNext(); 
            }
        }
        return p;
    }
    public static Node count(Node p) {
        Node q = p;
        boolean loop = true;
        int counter = 0;
        
        if(q == null) {
            System.out.println("There are no Planets on this list");
            return p;
        }
        while(loop) {
            counter++; //start off with 1
            if(q.getNext() == null) {
                if(counter == 1) System.out.println("There is 1 planet on this List.");
                else System.out.println("There are " + counter + " planets on this List.");
                loop = false;
            } else {
                q = q.getNext(); 
            }
        }
        return p;
    }
    public static Node sort(Node p) {
        //SEEING IF THE LIST IS EMPTY
        if(p == null) {
            System.out.println("No Sort Could be completed");
            return p;
        }
        
        System.out.println("Sorting...");
        long start = System.nanoTime();
        
        //SORT (insertion)
        Node head = p;
        if (head == null || head.next == null)
            return head;
 
        Node newHead = p;

        Node pointer = head.next;

        // loop through each element in the list
        while (pointer != null) { //second still normal
                // insert this element to the new list
            Node innerPointer = newHead;
            Node next = pointer.next;
            if (pointer.getPlanet().getPlace() <= newHead.getPlanet().getPlace()) {
                Node oldHead = newHead;
                newHead = pointer;
                newHead.next = oldHead;
            } else {
                while (innerPointer.next != null) { //in here
                    if (pointer.getPlanet().getPlace() > innerPointer.getPlanet().getPlace() && pointer.getPlanet().getPlace() <= innerPointer.next.getPlanet().getPlace()) {
                        Node oldNext = innerPointer.next;
                        innerPointer.next = pointer;
                        pointer.next = oldNext.next; //pointer.next = oldNext;
                    } //within this loop

                    innerPointer = innerPointer.next;
                }

                if (innerPointer.next == null && pointer.getPlanet().getPlace() > innerPointer.getPlanet().getPlace()) {
                    innerPointer.next = pointer;
                    pointer.next = null;
                }
            }

            pointer = next;
        }
 
		
        //END SORT
        
        
        long end = System.nanoTime();
        long templong = ((end - start) / 1000000000);
        System.out.println("Sort Completed in " + (end - start) + " Nanoseconds \n(" + templong + " seconds)");
        
        return newHead;
    }
    
    public static Node edit(Node p) {
        if(p == null) {
            System.out.println("Nothing to edit");
            return p;
        }
        
        Scanner s = new Scanner(System.in);
        System.out.println("Which Planet do you want to edit?:");
        String PlanetSearch = s.next();
        
        Node q = p;
        
        //search for it
        boolean loop = true;
        while(loop) {
            if(q.getPlanet().getName().equalsIgnoreCase(PlanetSearch)) {
                loop = false;
            } else {
                if(q.getNext() == null){ 
                System.out.println("Error 404: Planet not found"); 
                return p;
                }
                q = q.getNext(); 
            }
        }
        
        //now q equals the planet you were searching for
        boolean edit = true;
        
        while(edit) {
            System.out.println("Name: " + q.getPlanet().getName());
            System.out.println("Place: "+ q.getPlanet().getPlace());
            System.out.println("Size: "+ q.getPlanet().getSize());
            System.out.println("Has Life: " + q.getPlanet().getLife() + "\n");

            System.out.println("1- Edit Entire Node");
            System.out.println("2- Edit Planet Name");
            System.out.println("3- Edit Planet Position");
            System.out.println("4- Edit Planet Size");
            System.out.println("5- Edit State of Life");
            System.out.println("6- I made a mistake, get me out of here");

            s = new Scanner(System.in);
            int choice = 0;
            try{
                choice = s.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("I didn't understand your input");
                System.out.println(e.getMessage());
                choice = 7;
            }

            Scanner c = new Scanner(System.in);
            edit = false;
            switch(choice) {
                case 1:
                    Info newPlanet = createNewPlanet();
                    q.setPlanet(newPlanet);
                    break;
                case 2:
                    System.out.print("New Name: ");
                    String name = c.next();
                    q.getPlanet().setName(name);
                    break;
                case 3:
                    System.out.print("New Position: ");
                    int pos = c.nextInt();
                    q.getPlanet().setPlace(pos);
                    break;
                case 4:
                    System.out.print("New Size: ");
                    int size = c.nextInt();
                    q.getPlanet().setSize(size);
                    break;
                case 5:
                    System.out.print("True or False- Does the Planet Harbor Life?: ");
                    boolean life = c.nextBoolean();
                    q.getPlanet().setLife(life);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("I did not understand you.");
                    edit = true;
                    break;
            }
        }
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
            System.out.print("[Null]" );
            return;
        }
        boolean flag = true;
        System.out.print(s + "-->");
        while(flag) {
            System.out.print("["+ q.getPlanet().getName() + "|" + q.getPlanet().getPlace() + "]-->" );
                
            if(q.getNext() == null) {
                System.out.println("[Null]");
                break;
            }
            q = q.getNext();
        }
    }
    
}
