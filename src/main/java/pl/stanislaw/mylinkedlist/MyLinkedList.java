package pl.stanislaw.mylinkedlist;

import pl.stanislaw.MyList;


public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    private static class Node<T> {
        Node<T> previous;
        Node<T> next;
        T element;

    }

    @Override
    public void add(T element) {

        Node<T> addNode = new Node<>();

        addNode.element = element;

        if (head == null) {
            head = addNode;
            tail = addNode;
            head.next = tail;
            tail.previous = head;
        } else {
            addNode.previous = tail;
            tail.next = addNode;
            addNode.next = null;
            tail = addNode;
        }

        size++;

    }

    @Override
    public void add(int index, T element) {
        Node<T> addNode = new Node<>();

        addNode.element = element;

        if (head == null) {
            head = addNode;
            tail = addNode;
            head.next = tail;
            tail.previous = head;
        }
        else if (index == size) {
            addNode.previous = tail;
            tail.next = addNode;
            addNode.next = null;
            tail = addNode;
        } else if (index == 0) {
            addNode.next = head;
            addNode.previous = null;
            head = addNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i <= index; i++) {
                current = current.next;
                if (i == index-1) {
                    addNode.next = current;
                    current.previous.next = addNode;
                    addNode.previous = current.previous;
                    current.previous = addNode;
                }
            }
        }
        size++;
    }

    @Override
    public T get(int index) {
        T element = null;
        Node<T> current = head;
        if (index < size) {
            for (int i = 0; i <= index; i++) {
                element = current.element;
                current = current.next;
            }
        }

        return element;
    }

    @Override
    public void remove(int index) {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                if (current == tail) {
                    tail = current.previous;
                    current.previous.next = tail;

                } else if (current == head) {
                    head = current.next;
                    head.previous = null;

                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
                size--;
                return;
            }
            current = current.next;
        }

    }

    @Override
    public void remove(T object) {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element == object) {
                if (current == tail) {
                    tail = current.previous;
                    current.previous.next = tail;

                } else if (current == head) {
                    head = current.next;
                    head.previous = null;

                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
                size--;
                return;
            }
            current = current.next;
        }

    }

    @Override
    public void set(int index, T object) {
        Node<T> current = head;
        if (index < size) {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }
        current.element = object;

    }

    @Override
    public int indexOf(T element) {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            T currentElement = current.element;
            if (currentElement == element) {
                return i;
            }
            current = current.next;
        }

        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T element) {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(element)) {
                return true;
            }
            if (current.next == null) {
                return false;
            }
            current = current.next;
        }
        return false;
    }
}

