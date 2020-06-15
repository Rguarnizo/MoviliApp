package DataSrc.DataStructures;

import java.io.Serializable;

public class Node2B2 <T> implements Serializable{

    Node2B2 <T> previous;
    Node2B2 <T> next;
    T value;

    public Node2B2(T value) {
       this.value = value;
    }

    public Node2B2<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node2B2<T> previous) {
        this.previous = previous;
    }

    public Node2B2<T> getNext() {
        return next;
    }

    public void setNext(Node2B2<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    
    
}
