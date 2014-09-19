package DoubleList;

public class Node {
    Node next;
    Node previous;
    Info planet;
    
    public Node getNext() {
        return next;
    }
    public void setNext(Node p) {
        next = p;
    }
    public Node getPrevious() {
        return previous;
    }
    public void setPrevious(Node p) {
        previous = p;
    }
    public Info getPlanet() {
        return planet;
    }
    
    public void setPlanet(Info plan) {
        planet = plan;
    }
}

