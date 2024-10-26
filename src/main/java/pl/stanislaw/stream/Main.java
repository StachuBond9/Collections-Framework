package pl.stanislaw.stream;

import pl.stanislaw.MyList;
import pl.stanislaw.myarraylist.MyArrayList;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        //filter();
        //mapper();
        //forEach();
        //task4();
        //count();
        //distinct();
        //limit();
        //task8();
        //skip();
        // sorted();
        //task11();
        //findFirst();
        //task13();
        //task14();
        //task15();
        //task16();
        task17();
    }

    static void filter() {
        MyList<Integer> numbers = new MyArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        final var integerMyList = numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .toList();
        System.out.println(integerMyList);
    }

    static void mapper() {
        MyList<String> names = new MyArrayList<>();
        names.add("Anna");
        names.add("Bartek");
        names.add("Cecylia");
        final var namesMyList = names.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(namesMyList);
    }

    static void forEach() {
        MyList<String> names = new MyArrayList<>();
        names.add("Anna");
        names.add("Bartek");
        names.add("Cecylia");
        names.stream().forEach(System.out::println);
    }

    static void task4() {
        MyList<String> names = new MyArrayList<>();
        names.add("Anna");
        names.add("Bartek");
        names.add("Cecylia");
        names.add("Dan");

        names.stream()
                .filter(s -> s.length() > 4)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    static void count() {
        MyList<Integer> numbers = new MyArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        System.out.println(numbers.stream().count());
    }

    static void distinct() {
        MyList<Integer> numbers = new MyArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(4);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.stream()
                .distinct()
                .forEach(System.out::println);
    }

    static void limit() {
        MyList<String> names = new MyArrayList<>();
        names.add("Anna");
        names.add("Bartek");
        names.add("Cecylia");
        names.add("Dan");
        names.stream()
                .limit(2)
                .forEach(System.out::println);
    }

    static void task8() {
        MyList<Integer> numbers = new MyArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(3);
        numbers.add(3);
        numbers.add(4);
        System.out.println(numbers.stream()
                .distinct()
                .limit(3)
                .count());
    }

    static void skip() {
        MyList<String> names = new MyArrayList<>();
        names.add("Anna");
        names.add("Bartek");
        names.add("Cecylia");
        names.add("Dan");
        names.stream()
                .skip(2)
                .toList()
                .forEach(System.out::println);
    }

    static void sorted() {
        MyList<String> names = new MyArrayList<>();
        names.add("Anna");
        names.add("Bartek");
        names.add("Cecylia");
        names.add("Dan");
        names.stream()
                .sorted(String::compareTo)
                .toList()
                .forEach(System.out::println);
    }

    static void task11() {
        MyList<String> names = new MyArrayList<>();
        names.add("Anna");
        names.add("Bartek");
        names.add("Cecylia");
        names.add("Daniel");
        names.stream()
                .sorted(String::compareTo)
                .skip(2)
                .toList()
                .forEach(System.out::println);
    }

    static void findFirst() {
        MyList<Integer> numbers = new MyArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        System.out.println(numbers.stream()
                .findFirst()
                .get());

    }

    static void task13() {
        MyList<Integer> list = new MyArrayList<>();
        list.add(5);
        list.add(8);
        list.add(12);
        list.add(15);
        list.add(22);

        System.out.println(list.stream()
                .filter(integer -> integer > 10)
                .map(integer -> integer + 5)
                .findFirst()
                .get());
    }

    static void task14() {
        MyList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(6);
        list.add(9);
        list.add(10);
        System.out.println(list.stream()
                .filter(integer -> integer > 5)
                .distinct()
                .limit(3)
                .count()
        );
    }

    static void task15(){
        MyList<String> names = new MyArrayList<>();
        names.add("Daniel");
        names.add("Anna");
        names.add("Bartek");
        names.add("Cecylia");
        names.add("Ela");

        System.out.println(names.stream()
                .sorted(String::compareTo)
                .skip(3)
                .findFirst()
                .get());

    }

    static void task16(){
        MyList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(30);
        list.add(40);
        list.add(60);
        list.add(80);

        System.out.println(list.stream()
                .map(integer -> integer + 20)
                .filter(integer -> integer > 50)
                .count());
    }

    static void task17(){
        MyList<String> list = new MyArrayList<>();
        list.add("Anna");
        list.add("Agnieszka");
        list.add("Bartek");
        list.add("Cecylia");
        list.add("Adam");

        System.out.println(list.stream()
                .filter(s -> s.charAt(0) == 'A')
                .map(String::toUpperCase)
                .count());
    }
}
