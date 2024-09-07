package pl.stanislaw;

import java.util.Arrays;

public class MyArrayList implements MyList {
    private int capacity;
    private Integer[] array;
    private int size = 0;

    public MyArrayList() {
        capacity = 10;
        array = new Integer[capacity];
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        array = new Integer[capacity];
    }

    @Override
    public void add(Integer element) {
        if (isArrayFull()) {
            array = Arrays.copyOf(array, capacity*2);
            capacity *=2;
        }
        array[size++] = element;

    }

    @Override
    public void add(int index, Integer element) {

    }

    @Override
    public Integer get(int index) {
        return array[index];
    }

    @Override
    public void remove(int index) {
        array[index] = 0;
        for(int i = index; i < size; i++){
            array[i] = array[i+1];
        }
        size--;
    }

    @Override
    public void remove(Integer element) {

    }

    @Override
    public void set(int index, Integer element) {

    }

    @Override
    public int indexOf(Integer element) {
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Integer element) {
        if (element == null) {
            return false;
        }
        for (Integer i : array) {
            if (element.equals(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isArrayFull() {
        return size == array.length;
    }

}
