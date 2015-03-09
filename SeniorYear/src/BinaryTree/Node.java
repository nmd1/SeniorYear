/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree;

public class Node {
    Node left;
    Node right;
    Object o;
    
    public Node getLeft() {
        return left;
    }
    public Node getRight() {
        return right;
    }
    public Object getObject() {
        return o();     
    }

    private Object o() {
        return right;
    }
    
    public void setLeft(Node l) {
        left = l;
    }
    public void setRight(Node r) {
        right = r;
    }
    public void setObject(Object or){
        o = or;
    }
}
