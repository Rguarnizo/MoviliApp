package DataSrc.DataStructures;



import java.io.Serializable;

public class DoublyLinkedList <T> implements Serializable {

    Node2B2 <T> head;
    Node2B2 <T> tail;
    int size;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Node2B2<T> getHead() {
        return head;
    }

    public void setHead(Node2B2<T> head) {
        this.head = head;
    }

    public Node2B2<T> getTail() {
        return tail;
    }

    public void setTail(Node2B2<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public T popBack(){
        if(this.size == 0){
            //DoublyLinkedList empty
            return null;
        }else if(this.size == 1){
            T itemPop = this.tail.value;
            this.head = null;
            this.tail = null;
            size--;

            return itemPop;

        }else{
            T itemPop = tail.value;
            this.tail = this.tail.previous;
            size--;
            
            return itemPop;
        }
    }
    
    public T popFront(){
        
        if(size ==0){
            return null;           
        }else if(this.size == 1){
            T itemPop = this.head.value;
            this.head = null;
            this.tail = null;
            size--;
            
            return itemPop;
        }else{
            T itemPop = this.head.value;
            this.head = head.next;
            size--;
            
            return itemPop;
        }
    }
    
    public void pushFront(T value){
        if(size == 0){
            Node2B2 pushItem = new Node2B2(value);
            this.head = pushItem;
            this.tail = pushItem;
            size++;
        } else{
            Node2B2 pushItem = new Node2B2(value);
            this.head.previous = pushItem;
            pushItem.next = this.head;
            this.head = pushItem;
            size++;
        }
    }
    
    public void PushBack(T value){
        if(size == 0){
           Node2B2 pushItem = new Node2B2(value);
           this.head = pushItem;
           this.tail = pushItem; 
           this.size++;
        } else{
            Node2B2 pushItem = new Node2B2(value);
            pushItem.previous = this.tail;
            
            this.tail.next = pushItem;
            this.tail = pushItem;
            size++;
        }
    }
    
    public void PushBack(Node2B2 nodoInsert){
        if(size == 0){
           
           this.head = nodoInsert;
           this.tail = nodoInsert; 
           this.size++;
        } else{
            
            nodoInsert.previous = this.tail;
            
            this.tail.next = nodoInsert;
            this.tail = nodoInsert;
            size++;
        }
    }

    public void Search(T value){
        
    }


}
