package DataSrc.DataStructures.Hash;

public interface Entry<K,V> {

    K getKey();

    V getValue();

    V setValue(V value);
}
