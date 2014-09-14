

package senioryear;

import java.util.Scanner;
import java.util.*;

public class Edit {
    
    public Edit() {
        
    }
    //DELETE THIS LATER
    public static String generateString(Random rng, String characters, int length)
    {
    char[] text = new char[length];
    for (int i = 0; i < length; i++)
    {
        text[i] = characters.charAt(rng.nextInt(characters.length()));
    }
    return new String(text);
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
    private static Info nodeOrNah(boolean b) {
        Info newPlanet = new Info();
        if(b == false) {
            newPlanet = createNewPlanet();
        } else {
            Random rand = new Random();
            int pla = rand.nextInt(11);//between 0 and 10
            newPlanet = createNewPlanet(generateString(rand, "abcdefghijk", 4), pla);
        }
        return newPlanet;
    }
    public static Node insertAtEnd(Node p) { //p represents the entire list
        Node newNode = new Node();
        Info newPlanet = new Info();
        newPlanet = nodeOrNah(Main.planetDebug);
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
        if(test == 'p'){
            System.out.println("Insert a planet name to delete: ");
            String PlanetSearch = s.next();
            Node i = p;
            boolean loop = true;
            while(loop) {
               //System.out.println(i.getPlanet().getName() + "<--->" + PlanetSearch);
                if(i.getPlanet().getName().equalsIgnoreCase(PlanetSearch)){
                    index = i.getPlanet().getPlace();
                    loop = false;
                } else {
                    if(i.getNext() == null){ System.out.println("Error 404: Planet not found 1"); return p;}
                }
                
                i = i.getNext(); 
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
        if(index == 1) {
           p = p.getNext(); 
        } else {
            Node r = p, q = p;
            q = q.getNext(); //making it the leader
            //loop until q finds the index
            while(q.getPlanet().getPlace() != index) {
                q = q.getNext();
                r = r.getNext();
            }
            q.setNext(r.getNext());
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
        return p;
    }
    public static Node count(Node p) {
        return p;
    }
    public static Node sort(Node p) {
        //bubble sort the methods
        return p;
    }
    public static Node edit(Node p) {
        if(p == null) {
            System.out.println("Nothing to edit");
            return p;
        }
        Node newNode = new Node();
        Scanner s = new Scanner(System.in);
        System.out.println("Which Planet do you want to edit?:");
        String search = s.next();
        Info newPlanet = createNewPlanet();
        newNode.setPlanet(newPlanet);
        
        Node q = p;
        if(!(q.getPlanet().getName().equalsIgnoreCase(search))){ //if it isn't the first one
           while( !(q.getNext().getPlanet().getName().equalsIgnoreCase(search))) {
            q = q.getNext();
        } 
        }
        

        q.getPlanet().setLife(newPlanet.getLife());
        q.getPlanet().setName(newPlanet.getName());
        q.getPlanet().setPlace(newPlanet.getPlace());
        q.getPlanet().setSize(newPlanet.getSize());
        
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

        boolean flag = true;
        System.out.print(s + "-->");
        while(flag) {
            System.out.print("[ "+ q.getPlanet().getName() + "|" + q.getPlanet().getPlace() + "]-->" );
                
            if(q.getNext() == null) {
                System.out.println("[Null]");
                break;
            }
            q = q.getNext();
        }
    }
    
}
