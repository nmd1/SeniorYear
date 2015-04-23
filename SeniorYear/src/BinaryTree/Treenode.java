/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree;

public class Treenode {
    Treenode left;
    Treenode right;
    String o;
    
    public Treenode getLeft() {
        return left;
    }
    public Treenode getRight() {
        return right;
    }
    public String getString() {
        return o;     
    }

    public void setLeft(Treenode l) {
        left = l;
    }
    public void setRight(Treenode r) {
        right = r;
    }
    public void setString(String or){
        o = or;
    }
}
