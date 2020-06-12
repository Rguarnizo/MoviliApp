package DataSrc.DataStructures.Stack;




import DataSrc.DataStructures.Node;

import java.io.Serializable;

public class LinkedStack <T> implements Serializable {

        Node<T> top;
        Node<T> tail;

        int size;

        public LinkedStack(){
            this.top = null;
            this.tail= null;
            this.size= 0;
        }

        public int size() {
            return this.size;
        }


        public boolean isEmpty() {
            if(size == 0){
                return true;
            }else return false;
        }


        public void push(T key) {
            Node<T> pushItem = new Node<T>(key);

            if(isEmpty()){
                this.top = pushItem;
                this.tail = pushItem;
            } else{
                pushItem.next = this.top;
                this.top = pushItem;
            }
            this.size++;
        }


        public T pop() {
            Node <T> popNode;
            if(isEmpty()){
                //ArrayStack is empty

                return null;
            } else if(this.size() == 1){
                popNode = this.top;

                this.top = null;
                this.tail = null;
                size--;

                return popNode.value;
            } else{
                popNode = this.top;
                this.top = this.top.next;
                size--;

                return popNode.value;
            }
        }


        public T top() {
            return this.top.value;
        }
    }

