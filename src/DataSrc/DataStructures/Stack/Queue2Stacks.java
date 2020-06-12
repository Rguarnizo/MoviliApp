package DataSrc.DataStructures.Stack;


import java.io.Serializable;

public class Queue2Stacks <T> implements Serializable {

    LinkedStack<T> input; //enqueueStack
    LinkedStack<T> output; //dequeueStack

    public Queue2Stacks(){

        this.input = new LinkedStack<T>();
        this.output = new LinkedStack<T>();

    }


    public void enqueue(T key){
        this.input.push(key);
    }

    public T dequeue(){
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }


    public T front() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.top();
    }
}
