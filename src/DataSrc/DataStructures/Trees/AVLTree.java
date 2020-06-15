/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSrc.DataStructures.Trees;

import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author Rubén Darío Martínez
 */
public class AVLTree<T> {
    
    private AVLNode<T> root;
    private int numberNodes;
    

    private static class AVLNode<T> {

        private T t;
        private int height;
        private AVLNode<T> left;
        private AVLNode<T> right;

        private AVLNode(T t) {
            this.t = t;
            height = 1;
        }
        
        public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
        if(right!=null) {
            right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(t.toString()).append("\n");
        if(left!=null) {
            left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }
        return sb;
}

        @Override
        public String toString() {
            StringBuilder string = this.toString(new StringBuilder(), true, new StringBuilder());
            return string.toString();
        }
    }
        
        
 
    

    public void insert(T value) {
        root = insert(root, value);
    }

    private AVLNode<T> insert(AVLNode<T> n, T v) {
        if (n == null) {
            n = new AVLNode<T>(v);
            this.numberNodes++;
            return n;
        } else {
            int k = ((Comparable) n.t).compareTo(v);
            if(k == 0){
                System.out.println("Valor Repetido");
            }else if (k > 0) {
                n.left = insert(n.left, v);
            } else {
                n.right = insert(n.right, v);
            }
            n.height = Math.max(height(n.left), height(n.right)) + 1;
            int heightDiff = heightDiff(n);
            if (heightDiff < -1) {
                if (heightDiff(n.right) > 0) {
                    n.right = rightRotate(n.right);
                    return leftRotate(n);
                } else {
                    return leftRotate(n);
                }
            } else if (heightDiff > 1) {
                if (heightDiff(n.left) < 0) {
                    n.left = leftRotate(n.left);
                    return rightRotate(n);
                } else {
                    return rightRotate(n);
                }
            } else;

        }
        return n;
    }

    private AVLNode<T> leftRotate(AVLNode<T> n) {
        AVLNode<T> r = n.right;
        n.right = r.left;
        r.left = n;
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        r.height = Math.max(height(r.left), height(r.right)) + 1;
        return r;
    }

    private AVLNode<T> rightRotate(AVLNode<T> n) {
        AVLNode<T> r = n.left;
        n.left = r.right;
        r.right = n;
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        r.height = Math.max(height(r.left), height(r.right)) + 1;
        return r;
    }

    private int heightDiff(AVLNode<T> a) {
        if (a == null) {
            return 0;
        }
        return height(a.left) - height(a.right);
    }

    private int height(AVLNode<T> a) {
        if (a == null) {
            return 0;
        }
        return a.height;
    }
    public AVLNode<T> findMax(){
            if(root == null){
                return null;
            }else return findMax(root);
        }

        private AVLNode<T> findMax (AVLNode<T> actualNode) {
            if(actualNode.right == null){
                return actualNode;
            }else return findMax (actualNode.right);
        }

        public AVLNode<T> findMin(){
            if(root == null){
                return null;
            }else return findMin (root);
        }

        private AVLNode<T> findMin (AVLNode<T> actualNode) {
            if(actualNode.left == null){
                return actualNode;
            }else return findMin (actualNode.left);
        }
        
        public T find(T value){
            if(root == null){
                return null;
            }else return find (value,root);
        }
        

        public  T find(T value, AVLNode<T> actualNode){

            if(actualNode == null){
                return null;
            }
            int lessOrGreater = ((Comparable)actualNode.t).compareTo(value);
            

            if(lessOrGreater == 0){
                return actualNode.t;
            }else if(lessOrGreater > 0){
                return find (value,actualNode.left);
            }else if (lessOrGreater < 0){
                return find (value,actualNode.right);
            }else return null;
        }

    @Override
    public String toString() {
        return root.toString();
    }
        
  
}
