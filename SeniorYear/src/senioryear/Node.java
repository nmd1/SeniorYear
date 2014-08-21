package senioryear;

public class Node {
    Info planet;
    Node next;
        
    public Node() {
        
    }
    
    public void setNode(Info pl) {
        planet = pl;
    }
    
    public Node getNode() {
        return next;
    }
    
    public Info getPlanet() {
        return planet;
    }
    
    public void setPlanet(Info p) {
        planet = p;
    }
}
