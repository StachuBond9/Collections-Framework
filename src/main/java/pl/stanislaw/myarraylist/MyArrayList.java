package pl.stanislaw.myarraylist;

import pl.stanislaw.MyList;
import pl.stanislaw.stream.MyStream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyArrayList<T> implements MyList<T> , Iterable<T> {
    private int capacity;
    private Object[] array;
    private int size = 0;


    public MyArrayList() {
        capacity = 10;
        array = new Object[capacity];
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    @Override
    public void add(T element) {
        if (isArrayFull()) {
            array = Arrays.copyOf(array, capacity * 2);
            capacity *= 2;
        }
        array[size++] = element;

    }

    @Override
    public void add(int index, T element) {
        if (index > size) {
            return;
        }
        array[index] = 0;
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        size++;
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public void remove(int index) {
        if (index >= size) {
            return;
        }
        array[index] = 0;
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    @Override
    public void remove(T element) {
        for(int i = 0; i < size; i++){
            if(array[i].equals(element)){
                remove(i);
            }
        }
    }

    @Override
    public void set(int index, T element) {
        array[index] = element;
    }

    @Override
    public int indexOf(T element) {
         for(int i =0; i < size; i++){
             if(array[i].equals(element)){
                 return i;
             }
         }
         return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T element) {
        if (element == null) {
            return false;
        }
        for (Object i : array) {
            if (element.equals((T) i)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public MyStream<T> stream() {
        return new MyStream<>(this);
    }

    private boolean isArrayFull() {
        return size == array.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }


    private class MyIterator implements Iterator<T>{

        private int index;
        @Override
        public boolean hasNext() {
          return index < size();
        }

        @Override
        public T next() {
            return get(index++);
        }

    }

    @Override
    public String toString() {
        return "array= " + Arrays.toString(array);
    }
}
