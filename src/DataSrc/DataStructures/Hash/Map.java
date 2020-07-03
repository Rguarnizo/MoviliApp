package DataSrc.DataStructures.Hash;

import java.security.InvalidKeyException;

public interface Map<K,V> {

    int size();

    boolean isEmpty();

    V put(K key, V value) throws InvalidKeyException;

    V get(K key) throws InvalidKeyException;

    V remove(K key) throws InvalidKeyException;

    Iterable<K> keySet();

    Iterable<V> valueSet();

    Iterable<Entry<K,V>> entrySet();

}