package DataSrc.DataStructures;


import java.io.Serializable;

public class Node<T> implements Serializable {

    public T value;
    public Node<T> next;

    public Node(T value){
        this.value = value;
    }

    public Node(T value, Node<T> next){
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }


}
