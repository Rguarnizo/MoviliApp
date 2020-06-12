package DataSrc.DataStructures.Stack;


import java.io.Serializable;


public class ArrayStack<T> implements  Serializable {

    T top;
    T[] arrayStack;
    int size = 0;
    int length;

    public ArrayStack(){
        this.arrayStack = (T[]) new Object[5];
        this.length = 5;
    }

    public ArrayStack(int length){
        this.arrayStack = (T[]) new Object[length];
        this.length = length;
    }




    public int size() {
        return size;
    }


    public boolean isEmpty() {
        if(this.size == 0){
            return true;
        } else return false;
    }


    public void push(T key) {

        if(this.size == this.length) {
            //ArrayStack Full;
        }else {
            this.arrayStack[size] = key;
            this.top = this.arrayStack[size];
            this.size++;
        }
    }

    public T pop() {
        if(isEmpty()){
            //ArrayStack Empty

            return  null;
        }else if(this.size == 1){
            T temp = this.top;
            this.top = null;
            this.size = 0;

            return  temp;
        }else{
            T temp = this.top;
            this.top = this.arrayStack[this.size-1];
            this.size--;

            return temp;
        }
    }


    public T top() {
        return this.top;
    }
}
