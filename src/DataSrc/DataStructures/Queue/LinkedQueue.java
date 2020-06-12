package DataSrc.DataStructures.Queue;




import DataSrc.DataStructures.Node;

import java.io.Serializable;

public class LinkedQueue <T> implements Serializable {

    Node<T> head;
    Node<T> tail;

    int size;

    public LinkedQueue(){
        this.head = null;
        this.tail = null;
    }

    public T getTail() {
        return tail.value;
    }

    public T getHead() {
        return head.value;
    }

    public int getSize() {
        return size;
    }

    public void enqueue(T key){
        if(this.size == 0){
            Node<T> itemEnqueue = new Node<T>(key);
            this.head = itemEnqueue;
            this.tail = itemEnqueue;
            size++;
        } else {
            Node<T> itemEnqueue = new Node(key);
            this.tail.next = itemEnqueue;
            this.tail = itemEnqueue;
            size++;
        }
    }

    public T dequeue(){
        if(this.size == 0){
            //Queue vacia.
            return  null;
        } else if(this.size == 1){
            T dequeueItem = (T) this.head.value;
            this.head = null;
            this.tail = null;
            size--;

            return dequeueItem;
        }T dequeueItem = (T) this.head.value;
        this.head = this.head.next;
        size--;

        return dequeueItem;
    }
}

