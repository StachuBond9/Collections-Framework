package pl.stanislaw.stream;

import pl.stanislaw.MyList;
import pl.stanislaw.optional.MyOptional;
import pl.stanislaw.stream.interfaces.*;
import pl.stanislaw.myarraylist.MyArrayList;

import java.util.Optional;

public class MyStream<T> {

    private final MyList<T> elements;

    public MyStream(MyList<T> elements) {
        this.elements = elements;
    }

    public MyList<T> toList() {
        return elements;
    }

    public MyStream<T> filter(MyPredicate<T> predicate) {
        MyList<T> list = new MyArrayList<>();
        for (T elemnt : elements) {
            if (predicate.test(elemnt)) {
                list.add(elemnt);
            }
        }
        return new MyStream<>(list);
    }

    public <R> MyStream<R> map(MyFunction<T, R> mapper) {
        MyList<R> list = new MyArrayList<>();
        for (T element : elements) {
            list.add(mapper.apply(element));
        }
        return new MyStream<>(list);
    }

    public void forEach(MyConsumer<T> action) {
        for (T element : elements) {
            action.accept(element);
        }
    }

    public long count() {
        return elements.size();
    }

    public MyStream<T> distinct() {
        MyList<T> list = new MyArrayList<>();
        for (T mainElement : elements) {
            int i = 0;
            for (T element : list) {
                if (!element.equals(mainElement)) {
                    i++;
                }
            }
            if (i == list.size()) {
                list.add(mainElement);
            }
        }
        return new MyStream<T>(list);
    }

    public MyStream<T> limit(int maxSize) {
        MyList<T> list = new MyArrayList<>();
        for (int i = 0; i < maxSize; i++) {
            list.add(elements.get(i));
        }
        return new MyStream<>(list);
    }

    public MyStream<T> skip(int n) {
        MyList<T> list = new MyArrayList<>();
        for (int i = n; i < elements.size(); i++) {
            list.add(elements.get(i));
        }
        return new MyStream<>(list);
    }

    public MyStream<T> sorted(MyComparator<T> comparator) {
        MyList<T> list = elements;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.size() - i; j++) {//pętla wewnętrzna
                if (comparator.compare(list.get(j - 1), list.get(j)) > 0) {
                    T element = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, element);
                }
            }
        }
        return new MyStream<>(list);
    }

    public MyOptional<T> findFirst() {
        if (elements.size() == 0) {
            return MyOptional.empty();
        }

        return MyOptional.ofNullable(elements.get(0));

    }

}