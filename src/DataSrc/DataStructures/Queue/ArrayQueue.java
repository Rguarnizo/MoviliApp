package DataSrc.DataStructures.Queue;

import java.io.Serializable;

public class ArrayQueue <T> implements Queue <T>, Serializable {

    private T[] queueArray;
    private int size, start, end, count;

    public ArrayQueue() {
        this.size = 2; //Size of queueArray
        this.count = 0; // Numbers of elements
        this.start = -1;
        this.start = -1;

        this.queueArray = (T[]) new Object[this.size];
    }

    public void enqueue(T key) {
        if (isFull()) {
            resizeStructure();
        } else {
            this.queueArray[++this.end] = key; //++this.end Prefijo porque tiene que asignar end primero antes de poner key.
            this.count++;
        }
    }

    private boolean isFull() {
        return this.count >= size;
    }

    public int getCount() {
        return count;
    }

    public int getEnd() {
        return end;
    }

    public int getSize() {
        return size;
    }

    public int getStart() {
        return start;
    }

    private void resizeStructure() {
        if (this.count == this.size) {
            this.size *= 2;
            T[] newQueueArray = (T[]) new Object[this.size];

            for (int i = 0; i <= this.end; i++) {
                newQueueArray[i] = this.queueArray[i];
            }
            this.queueArray = newQueueArray;
        } else {
            //Queue is not full
        }
    }

}
