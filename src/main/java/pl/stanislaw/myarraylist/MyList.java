package pl.stanislaw.myarraylist;

public interface MyList<T> {
    void add(T element);

    void add(int index, T element);

    T get(int index);

    void remove(int index);

    void remove(T element);

    void set(int index, T element);

    int indexOf(T element);

    int size();

    boolean contains(T element);
}
