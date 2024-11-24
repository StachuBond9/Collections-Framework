package pl.stanislaw.stream;

import pl.stanislaw.stream.interfaces.MyComparator;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T> {
    private final MyComparator<T> comparator;
    private final List<T> elements;

    public MergeSort(MyComparator<T> comparator, List<T> elements) {
        this.comparator = comparator;
        this.elements = elements;
    }

    public List<T> sort() {
        return mergeSort(elements);
    }

    private List<T> mergeSort(List<T> list) {
        if (list.size() < 2) {
            return list;
        }
        int size = list.size() / 2;
        List<T> left = new ArrayList<>();
        List<T> right = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            left.add(list.get(i));
        }
        for (int i = size; i < list.size(); i++) {
            right.add(list.get(i));
        }
        return merge(mergeSort(left), mergeSort(right));
    }

    private List<T> merge(List<T> lst1, List<T> lst2) {
        List<T> result = new ArrayList<>();
        int size = lst1.size() + lst2.size();
        int i = 0;
        int j = 0;
        while (result.size() <= size) {
            if (j >= lst2.size()) {
                for (int k = i; k < lst1.size(); k++) {
                    result.add(lst1.get(k));
                }
                return result;
            } else if (i >= lst1.size()) {
                for (int k = j; k < lst2.size(); k++) {
                    result.add(lst2.get(k));
                }
                return result;
            }

            if (comparator.compare(lst1.get(i), lst2.get(j)) > 0) {
                result.add(lst2.get(j));
                j++;

            } else {
                result.add(lst1.get(i));
                i++;
            }
        }
        return result;
    }


}