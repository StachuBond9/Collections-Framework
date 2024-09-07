package pl.stanislaw;

public interface MyList {
    void add(Integer element);

    void add(int index, Integer element);

    Integer get(int index);

    void remove(int index);

    void remove(Integer element);

    void set(int index, Integer element);

    int indexOf(Integer element);

    int size();

    boolean contains(Integer element);
}
