package pl.stanislaw;

public interface MyMap<K, V> {
    interface Entry<K, V>{
        K getKey();
        V getValue();
        V setValue(V newValue);
        boolean equals(Object o);
        int hashCode();
    }
    V put(K key, V value);
    V get(K key);
    V remove(K key);
    boolean containsKey(K key);
    boolean containsValue(V value);
    int size();
    boolean isEmpty();
    void clear();
}
