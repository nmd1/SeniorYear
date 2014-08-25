package senioryear;

public class Node {
    Info planet;
    Node next;
        
    public Node() {
        
    }
    
    public void setNext(Node p) {
        next = p;
    }
    
    public Node getNext() {
        return next;
    }
    
    public Info getPlanet() {
        return planet;
    }
    
    public void setPlanet(Info plan) {
        planet = plan;
    }
}
