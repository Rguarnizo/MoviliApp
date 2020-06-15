package DataSrc.DataStructures;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList <T> implements Iterable<T>, Serializable {


	/*
	28/04/2020
	Se agrego el operador diamante a los atributos head y tail (Node>T>)


	Se agregaron los siguientes metodos
		*isEmpty()
		*checkIndex()
		*get()
		*indexOf()
		*remove()
		*add()
		*toString()

	Se agregó un iterador para usar en caso de ser necesario

	*/

    Node<T> head; //Se agregó el operador diamante
    Node<T> tail;

    protected int size;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public T getHead() {
        return head.value;
    }

    public T getTail() {
        return tail.value;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void checkIndex(int index){
        if (index<0 || index >= size){
            throw new IndexOutOfBoundsException("index = " + index + " size = " + size);
        }
    }

    public T get(int index){
        checkIndex(index);

        Node<T> currentNode = head;
        for(int i=0; i<index; i++){
            currentNode = currentNode.next;
        }
        return currentNode.value;
    }

    public int indexOf(T value){
        Node<T>  currentNode = head;
        int index = 0;
        while( currentNode != null && !currentNode.value.equals(value) ){
            currentNode = currentNode.next;
            index++;
        }

        if( currentNode == null ){
            return -1;
        } else {
            return index;
        }
    }
    
   

    public T remove( int index ){
        checkIndex(index);

        T removedKey;
        if ( index == 0 ){
            removedKey = head.value;
            head = head.next;
        } else {
            Node<T> aux = head;
            for( int i=0; i<index - 1; i++){
                aux = aux.next;
            }
            removedKey = aux.next.value;
            aux.next = aux.next.next;
        }
        size--;
        return removedKey;
    }

    public void add( int index, T value){
        checkIndex(index);

        if(index == 0){
            head = new Node<T>(value, head);
        } else {
            Node<T> aux = head;
            for( int i = 0; i < index - 1; i++  ){
                aux = aux.next;
            }
            aux.next = new Node<T>(value, aux.next);
        }
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("[");

        for(T x : this){
            s.append(Objects.toString (x)).append(", ");
        }

        if( size > 0 ){
            s.setLength( s.length() - 2 );
        }
        s.append("]");
        return new String(s);
    }

    private class LinkedListIterator implements Iterator<T> {

        private Node<T> nextNode;

        public LinkedListIterator(){
            nextNode = head;
        }

        public boolean hasNext(){
            return nextNode != null;
        }

        @Override
        public T next(){
            if( nextNode != null ){
                T valueToReturn = nextNode.value;
                nextNode = nextNode.next;
                return valueToReturn;
            } else {
                throw new NoSuchElementException("No next element.");
            }
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException("remove not supported.");
        }

    }

    @Override
    public Iterator<T> iterator(){
        return new LinkedListIterator();
    }


    public void pushFront(T key){
        Node<T> pushItem = new Node(key);
        if(this.size == 0){
            this.head = pushItem;
            this.tail = pushItem;
            size++;
        } else{
            pushItem.next = this.head;
            this.head = pushItem;
            size++;
        }
    }

    public long  pushBack(T key){

        long initPush = System.nanoTime ();
        Node<T> pushItem = new Node(key);
        if(this.size == 0){
            this.head = pushItem;
            this.tail = pushItem;
            size++;
        } else{
            this.tail.next = pushItem;
            this.tail = pushItem;
            size++;
        }
        long finishPush = System.nanoTime ();
        return initPush-finishPush;
    }

    public T popFront(){
        if( isEmpty() ){
            //LinkedList Empty
            return null;
        } else if(this.size == 1){
            T popItem = (T) this.head.value;
            this.head = null;
            this.tail = null;
            size--;
            return popItem;
        } else{
            T popItem = (T) this.head.value;
            this.head = this.head.next;
            size--;

            return popItem;
        }
    }

    public void makeEmpty(){
        this.head = null;
    }

}