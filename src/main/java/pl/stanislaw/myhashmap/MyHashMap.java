package pl.stanislaw.myhashmap;

import org.w3c.dom.Node;
import pl.stanislaw.MyList;
import pl.stanislaw.MyMap;
import pl.stanislaw.myarraylist.MyArrayList;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private int capacity = 5;
    private Node<K, V>[] table = new Node[capacity];
    private int size = 0;

    @Override
    public V put(K key, V value) {
        int index = index(key);
        System.out.println(index);
        Node<K, V> node = new Node<>(key, value);
        Node<K, V> node1 = table[index];

        if (node1 == null) {
            table[index] = node;
        } else {
            while (node1 != null) {
                if (node1.next == null) {
                    node1.next = node;
                    break;
                }
                node1 = node1.next;
            }
        }
        size++;
        return value;
    }

    @Override
    public V get(K key) {
        Node<K, V> node = table[index(key)];
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        Node<K, V> node = table[index(key)];
        Node<K, V> previousNode = null;
        while (node != null) {
            if (node.getKey().equals(key)) {
                previousNode.next = node.next;
                size--;
                return node.getValue();

            } else {
                previousNode = node;
                node = node.next;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        Node<K, V> node = table[index(key)];
        while (node != null) {
            if (node.getKey().equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < capacity; i++) {
            Node<K, V> node = table[i];
            while (node != null) {
                if (node.getValue().equals(value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        int empty = 0;
        for (int i = 0; i < capacity; i++) {
            if (table[i] == null) {
                empty++;
            }
        }
        return empty == 5;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
        size = 0;
    }

    public MyList<K> keySet(){
        MyList<K> myList = new MyArrayList<>();
        for(int i = 0; i < capacity; i++){
            Node<K, V> node = table[i];
            while(node != null){
                myList.add(node.getKey());
                node = node.next;
            }
        }
        return myList;
    }

    public MyList<V> values(){
        MyList<V> myList = new MyArrayList<>();
        for(int i = 0; i < capacity; i++){
            Node<K, V> node = table[i];
            while(node != null){
                if(!myList.contains(node.getValue())) {
                    myList.add(node.getValue());
                }
                node = node.next;
            }
        }
        return myList;
    }

    private int index(K key) {
        int hash = key.hashCode();
        return Math.abs(hash % capacity);
    }

    private class Node<K, V> implements MyMap.Entry<K, V> {
        private final K key;
        private V value;
        Node<K, V> next;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            value = newValue;
            return value;
        }
    }

}
