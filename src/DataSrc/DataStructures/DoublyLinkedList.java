package DataSrc.DataStructures;



import java.io.Serializable;

public class DoublyLinkedList <T> extends  LinkedList<T> implements Serializable {

    Node2B2 <T> head;
    Node2B2 <T> tail;
    int size;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
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
        } else{
            Node2B2 pushItem = new Node2B2(value);
            this.head.previous = pushItem;
            pushItem.next = this.head;
            this.head = pushItem;
        }
    }
    
    public void PushBack(T value){
        if(size == 0){
           Node2B2 pushItem = new Node2B2(value);
           this.head = pushItem;
           this.tail = pushItem;          
        } else{
            Node2B2 pushItem = new Node2B2(value);
            pushItem.previous = this.tail;
            
            this.tail.next = pushItem;
            this.tail = pushItem;
        }
    }

    public void Search(T value){
        
    }


}
