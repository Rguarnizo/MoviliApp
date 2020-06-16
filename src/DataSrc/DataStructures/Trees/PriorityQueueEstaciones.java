/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSrc.DataStructures.Trees;

import DataSrc.Estacion;
import java.util.Arrays;



/**
 *
 * @author Rubén Darío Martínez
 */
public class PriorityQueueEstaciones{
    private Estacion[] Heap; 
    private int size; 
    private int maxsize; 
  
 
    public PriorityQueueEstaciones(int maxsize) 
    { 
        this.maxsize = maxsize; 
        this.size = 0; 
        Heap = new Estacion[this.maxsize + 1]; 
        Heap[0] = new Estacion(Integer.MAX_VALUE); 
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
        Estacion tmp; 
        tmp = Heap[fpos]; 
        Heap[fpos] = Heap[spos]; 
        Heap[spos] = tmp; 
    } 
  

    private void maxHeapify(int pos) 
    { 
        if (isLeaf(pos)) 
            return; 
  
        if (Heap[pos].getNUsuarios() < Heap[leftChild(pos)].getNUsuarios() ||  
            Heap[pos].getNUsuarios() < Heap[rightChild(pos)].getNUsuarios()) { 
  
            if (Heap[leftChild(pos)].getNUsuarios() > Heap[rightChild(pos)].getNUsuarios()) { 
                swap(pos, leftChild(pos)); 
                maxHeapify(leftChild(pos)); 
            } 
            else { 
                swap(pos, rightChild(pos)); 
                maxHeapify(rightChild(pos)); 
            } 
        } 
    } 
  

    public void insert(Estacion element) 
    { 
        
        if(this.maxsize == size){
            duplicateSize();
        }
        Heap[++size] = element; 
 
        int current = size; 
        while (Heap[current].getNUsuarios() > Heap[parent(current)].getNUsuarios()) { 
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
  
    public Estacion extractMax() 
    { 
        Estacion popped = Heap[1]; 
        Heap[1] = Heap[size--]; 
        maxHeapify(1); 
        return popped; 
    } 
    
    public Estacion consultMax(){
        return Heap[1];        
    }
    
    public void changePriority(Estacion Estacion){
        
        int index = 0;
        while(index != maxsize){
            if(Heap[index] == Estacion){
                Heap[index].aumentarPrioridad();
                break;
            }
                        
            index++;
        }
        
        int current = index; 
        while (Heap[current].getNUsuarios() > Heap[parent(current)].getNUsuarios()) { 
            swap(current, parent(current)); 
            current = parent(current); 
        } 
                
         maxHeapify(parent(index));        
    }

    private void duplicateSize() {
        this.Heap = Arrays.copyOf(Heap,maxsize*2);
        this.maxsize = maxsize*2;
    }
}
