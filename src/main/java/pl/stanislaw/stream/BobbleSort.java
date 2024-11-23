package pl.stanislaw.stream;

import pl.stanislaw.stream.interfaces.MyComparator;

import java.util.List;

public class BobbleSort<T> {
    MyComparator<T> comparator;
    List<T> elements;

    public BobbleSort(MyComparator<T> comparator, List<T> elements) {
        this.comparator = comparator;
        this.elements = elements;
    }

    private List<T> sort(){
        for (int i = 0; i < elements.size(); i++) {
            for (int j = 1; j < elements.size() - i; j++) {
                if (comparator.compare(elements.get(j - 1), elements.get(j)) > 0) {
                    T element = elements.get(j - 1);
                    elements.set(j - 1, elements.get(j));
                    elements.set(j, element);
                }
            }
        }
        return this.elements;
    }

}
