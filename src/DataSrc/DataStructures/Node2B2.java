package DataSrc.DataStructures;

import java.io.Serializable;

public class Node2B2 <T> implements Serializable{

    Node2B2 <T> previous;
    Node2B2 <T> next;
    T value;

    public Node2B2(T value) {
       this.value = value;
    }
    
}
