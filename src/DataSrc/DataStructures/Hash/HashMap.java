package DataSrc.DataStructures.Hash;

import DataSrc.DataStructures.LinkedList;



public class HashMap<K,V> implements Map<K,V> {

    protected Entry<K,V> AVAILABLE = new HashEntry<>(null, null);
    protected int numberOfEntries;
    protected int capacity; //capacity = bucket.length
    public Entry<K,V>[] bucket; //La tabla hash
    protected int scale, shift, prime; // factores para la compresión


    public HashMap(int prime, int capacity){ //Constructor general
        this.capacity = capacity;
        bucket = (Entry<K,V>[] ) new Entry[capacity];
        numberOfEntries = 0;
        java.util.Random rand = new java.util.Random();
        this.prime = prime;
        scale = rand.nextInt(capacity-1)+1;
        shift = rand.nextInt(capacity);
    }

    public HashMap( int capacity ){ //Si no hay un primo predefinido
        this(109345121, capacity);
    }

    public HashMap(){ //default constructor
        this(109345121, 1000);
    }

    public void checkKey(K k)  {
        if(k==null){
            return;
        }
    }

    public int hashValue(K key){ // ((a*x + b ) mod p) mod cap -> distribución uniforme de los valores
        return Math.abs(  (key.hashCode()*scale + shift) % prime ) % capacity;
    }

    //Numero de entradas en la tabla
    public int size(){
        return this.numberOfEntries;
    }

    //¿Está vacía la tabla?
    public boolean isEmpty(){
        return (this.numberOfEntries == 0);
    }
    
    public boolean containsKey(K key){
        for(K k:keySet()){
            if(k.equals(key)){
                return true;
            }                
        }
        return false;
    }
    


    public Iterable<K> keySet(){
        LinkedList<K> list = new LinkedList<>();
        for(int i=0; i<bucket.length; i++){
            Entry<K,V> e;
            e = bucket[i];
            if( (e!=null) &&(e!=AVAILABLE)){
                list.pushBack( e.getKey());
            }
        }
        return list;
    }

    public Iterable<V> valueSet(){
        LinkedList<V> list = new LinkedList<>();
        for(int i=0; i<bucket.length; i++){
            Entry<K,V> e;
            e = bucket[i];
            if( (e!=null) &&(e!=AVAILABLE)){
                list.pushBack( e.getValue());
            }
        }
        return list;
    }

    public Iterable<Entry<K,V>> entrySet(){
        LinkedList<Entry<K,V>> list = new LinkedList<>();
        for(int i=0; i<bucket.length; i++){
            Entry<K,V> e;
            e = bucket[i];
            if( (e!=null) &&(e!=AVAILABLE)){
                list.pushBack( e );
            }
        }
        return list;
    }

    protected int findEntry(K key){
        int available = -1;
        checkKey(key);
        int i = hashValue(key); //Indice donde inicia la busqueda
        int j = i;              //Detectar si se pasó por este indice previamente
        do{
            Entry<K,V> e = bucket[i];
            if( e==null ){
                if(available < 0){
                    available = i; //La llave no está en la tabla
                    break;
                }
            }
            if( key.equals(e.getKey()) ){ //Se encontró la llave
                return i; //Ubicación donde se encontró la llave
            }
            if(e == AVAILABLE){ //el bucket está desactivado
                if(available < 0){
                    available = i; //Recordar que el contenedor está disponible
                }
            }
            i = (i+1) % capacity; //Continuar la busqueda

        } while ( i!=j );
        return -(available + 1);
    }

    //Retorna el valor asociado con una llave
    public V get(K key){
        int i = findEntry(key); //Encontrar la llave
        if( i < 0){
            return null;
        }
        return bucket[i].getValue();
    }

    //Ubicar el par llave-valor en el mapa, reemplazar el previo si existe
    public V put(K key, V value){
        int i = findEntry(key);
        if ( i >=0 ){ //La llave tiene un valor previo
            return bucket[i].setValue(value);
        }
        if( numberOfEntries >= capacity/2 ){ //Si llega aquí, la llave no existe, pero el factor de carga ya es >= 0.5
            rehash();
            i = findEntry(key);
        }
        bucket[ -i-1 ] = new HashEntry<>(key,value); //Obtener el indice apropiado e insertar
        numberOfEntries++;
        return null; //No había un valor previo
    }

    protected void rehash(){
        this.capacity = this.capacity * 2;
        Entry<K,V>[] oldBucket = bucket;
        bucket = (Entry<K,V>[]) new Entry[capacity]; //Nuevo bucket con el doble de capacidad
        java.util.Random rand = new java.util.Random();
        scale = rand.nextInt(capacity-1)+1;
        shift = rand.nextInt(capacity);
        for(int i=0; i<oldBucket.length; i++){
            Entry<K,V> e = oldBucket[i];
            if( (e!=null) && (e != AVAILABLE) ){ //Si es una entrada valida
                int j = - 1 - findEntry( e.getKey() );
                bucket[j] = e;
            }
        }
    }

    //Remueve el par llave-valor que contiene la llave especificada
    public V remove(K key){
        int i = findEntry(key);
        if( i < 0 ){ //No hay nada que remover en el mapa
            return null;
        }
        V v = bucket[i].getValue();
        bucket[i] = AVAILABLE;
        numberOfEntries--;
        return v;
    }



    public static class HashEntry<K,V> implements Entry<K,V>{
        protected K key;
        protected V value;

        public HashEntry(K k, V v){
            this.key = k;
            this.value = v;
        }

        public V getValue(){
            return this.value;
        }

        public K getKey(){
            return this.key;
        }

        public V setValue(V newValue){
            V oldValue = this.value;
            this.value = newValue;
            return oldValue;
        }

        public boolean equals(Object o){
            if( o.getClass() != this.getClass() ){
                return false;
            }
            HashEntry entry;
            try{
                entry = (HashEntry) o; //Probar si es un objeto de tipo HashEntry
            } catch (ClassCastException ex){
                return false;
            }
            return (entry.getKey() == this.key) && (entry.getValue() == this.value);
        }

        public String toString(){
            return "(" + this.key + "," + this.value + ")";
        }

    }

}
