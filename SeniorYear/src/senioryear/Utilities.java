
import java.util.Scanner;
import senioryear.Info;
import senioryear.Node;


public class Utilities {
    
    
    public Utilities() {
        
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
        
        System.out.println("Sort Completed in " + (end - start) + " Nanoseconds");
        
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
                    Info newPlanet = Edit.createNewPlanet();
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
}
