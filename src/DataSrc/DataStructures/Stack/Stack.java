package DataSrc.DataStructures.Stack;


import java.io.Serializable;

public interface Stack <T> extends Serializable {

     int size();
     boolean isEmpty();
     void push(T key);
     T pop();
     T top();

}