package DataSrc.DataStructures.Array;




import java.io.Serializable;


public class DynamicArray <T> implements Array<T>, Serializable{

    T[] array;
    int size ;
    int length;

    public DynamicArray(int length){

        this.array =(T[]) new Object[length];
        this.length = length;
        this.size = 0;

    }
    public void checkIndex(int index){
        if( index < 0 || index >= array.length ){
            throw new IndexOutOfBoundsException( "index = "+ index + " length = " + array.length);
        }
    }

    public T get( int index ){
        checkIndex(index);
        return array[index];
    }

    public void set( int index, T value ){
        checkIndex(index);
        array[index] = value;
    }



    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public long push(T key) {
        long initPush = System.nanoTime ();
        if(this.size == this.length){

            this.length*=2;
            T[] tempArray =(T[]) new Object[this.length];
            for(int i=0;i<this.size;i++){
                tempArray[i] = this.array[i];
            }
            this.array = tempArray;
        }
            this.array[size] = key;
            size++;
            long finishPush = System.nanoTime ();
            return finishPush - initPush;
    }

    public void remove( int index ){
        checkIndex(index);
        for(int j=index; j<array.length-2; j++){
            this.array[j] = this.array[j+1];
        }
        size -= 1;
    }


    public int indexOf(T value){
        int index = 0;
        while( array[index] != null && !array[index].equals(value) ){
            index++;
        }
        if( array[index] == null ){
            return -1;
        } else {
            return index;
        }

    }

    public T searchElement( T key ){ // Para buscar por índice basta con usar get(index)
        return get( indexOf( key ) );
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for( int i=0; i < this.size ; i++ ){
            sb.append(this.array[i]).append(", ");
        }
        if(size > 0){
            sb.setLength( sb.length() - 2);
        }
        sb.append("]");
        return new String(sb);
        //return this.array.toString();
    }

    public void makeEmpty(){

        for(int i = 0; i < this.size; i++){
            this.array[i] = null;
        }
    }
}
