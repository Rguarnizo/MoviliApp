/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSrc.DataStructures.Trees;

import DataSrc.Ruta;
import java.util.Arrays;

/**
 *
 * @author Rubén Darío Martínez
 */
public class RutasPriorityQueue {
    
    private Ruta[] Heap; 
    private int size; 
    private int maxsize; 
  
 
    public RutasPriorityQueue(int maxsize) 
    { 
        this.maxsize = maxsize; 
        this.size = 0; 
        Heap = new Ruta[this.maxsize + 1]; 
        Heap[0] = new Ruta(Integer.MAX_VALUE); 
    } 
  

    private int parent(int pos) 
    { 
        return pos / 2; 
    } 
  
    
    private int leftChild(int pos) 
    { 
        return (2 * pos); 
    } 
    private int rightChild(int pos) 
    { 
        return (2 * pos) + 1; 
    } 
  
    // Returns true of given node is leaf 
    private boolean isLeaf(int pos) 
    { 
        if (pos >= (size / 2) && pos <= size) { 
            return true; 
        } 
        return false; 
    } 
  
    private void swap(int fpos, int spos) 
    { 
        Ruta tmp; 
        tmp = Heap[fpos]; 
        Heap[fpos] = Heap[spos]; 
        Heap[spos] = tmp; 
    } 
  

    private void maxHeapify(int pos) 
    { 
        if (isLeaf(pos)) 
            return; 
  
        if (Heap[pos].getNumUserWaiting() < Heap[leftChild(pos)].getNumUserWaiting() ||  
            Heap[pos].getNumUserWaiting() < Heap[rightChild(pos)].getNumUserWaiting()) { 
  
            if (Heap[leftChild(pos)].getNumUserWaiting() > Heap[rightChild(pos)].getNumUserWaiting()) { 
                swap(pos, leftChild(pos)); 
                maxHeapify(leftChild(pos)); 
            } 
            else { 
                swap(pos, rightChild(pos)); 
                maxHeapify(rightChild(pos)); 
            } 
        } 
    } 
  

    public void insert(Ruta element) 
    { 
        if(this.maxsize == size){
            this.maxsize*=2;
            Ruta[] tempArray = new Ruta[this.maxsize+1];
            tempArray[0] = new Ruta(Integer.MAX_VALUE);
            for(int i=1;i <= this.size;i++){
                tempArray[i] = this.Heap[i];
            }
            this.Heap = tempArray;
        }
        Heap[++size] = element; 
 
        int current = size; 
        while (Heap[current].getNumUserWaiting() > Heap[parent(current)].getNumUserWaiting()) { 
            swap(current, parent(current)); 
            current = parent(current); 
        } 
    } 
  
    public void print() 
    { 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + 
                      Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]); 
            System.out.println(); 
        } 
    } 
  
    public Ruta extractMax() 
    { 
        Ruta popped = Heap[1]; 
        Heap[1] = Heap[size--]; 
        maxHeapify(1); 
        return popped; 
    } 
    
    public void changePriority(Ruta ruta){
        
        int index = 0;
        while(index != maxsize){
            if(Heap[index] == ruta){
                Heap[index].aumentarPrioridad();
                break;
            }
            index++;
        }
        int current = index; 
        while (Heap[current].getNumUserWaiting() > Heap[parent(current)].getNumUserWaiting()) { 
            swap(current, parent(current)); 
            current = parent(current); 
        } 
         maxHeapify(index);
        
    }
    
    private void duplicateSize() {
        
        this.Heap = Arrays.copyOf(Heap,maxsize*2);
        this.maxsize = maxsize*2;
    }
}
