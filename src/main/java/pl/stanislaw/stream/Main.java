package pl.stanislaw.stream;

import pl.stanislaw.MyList;
import pl.stanislaw.myarraylist.MyArrayList;

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
        //task17();
        //matchAll();
        //anyMatch();
        //noneMatch();
        //reduce();
        //task2_6();
        //min();
        //max();
        //task2_9();
        //peek();
        //flatMap();
        //task2_12();
        //join();
        //task2_14_1();
        //task2_14_2();
        //task2_14_3();
        //task2_14_4();
        task2_14_5();
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

    static void task15() {
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

    static void task16() {
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

    static void task17() {
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

    static void matchAll() {
        MyList<Integer> numbers = new MyArrayList<>();
        numbers.add(4);
        numbers.add(2);
        numbers.add(6);
        numbers.add(4);
        numbers.add(8);

        System.out.println(numbers.stream()
                .allMatch(integer -> integer % 2 == 0));
    }

    static void anyMatch() {
        MyList<Integer> numbers = new MyArrayList<>();
        numbers.add(2);
        numbers.add(2);
        numbers.add(4);
        numbers.add(4);
        numbers.add(8);

        System.out.println(numbers.stream()
                .anyMatch(integer -> integer % 2 != 0));
    }

    static void noneMatch() {
        MyList<Integer> numbers = new MyArrayList<>();
        numbers.add(2);
        numbers.add(2);
        numbers.add(4);
        numbers.add(2);
        numbers.add(8);

        System.out.println(numbers.stream()
                .noneMatch(integer -> integer % 2 != 0));
    }

    static void reduce() {
        MyList<Integer> numbers = new MyArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        System.out.println(numbers.stream()
                .reduce(0, (integer, integer2) -> integer - integer2));

    }

    static void task2_6() {
        MyList<Integer> numbers = new MyArrayList<>();
        numbers.add(12);
        numbers.add(15);
        numbers.add(8);
        numbers.add(22);

        System.out.println(numbers.stream()
                .filter(integer -> integer > 10)
                .reduce(0, Integer::sum));

        System.out.println(numbers.stream()
                .noneMatch(integer -> integer < 5));
    }

    static void min() {
        MyList<Integer> numbers = new MyArrayList<>();
        numbers.add(12);
        numbers.add(15);
        numbers.add(8);
        numbers.add(22);

        System.out.println(numbers.stream()
                .min(Integer::compareTo)
                .get());
    }

    static void max() {
        MyList<Integer> numbers = new MyArrayList<>();
        numbers.add(12);
        numbers.add(15);
        numbers.add(22);
        numbers.add(8);


        System.out.println(numbers.stream()
                .max(Integer::compareTo)
                .get());
    }

    static void task2_9() {
        MyList<Integer> numbers = new MyArrayList<>();
        numbers.add(3);
        numbers.add(7);
        numbers.add(2);
        numbers.add(9);
        numbers.add(1);

        System.out.println(numbers.stream()
                .min(Integer::compareTo));

        System.out.println(numbers.stream()
                .max(Integer::compareTo));

        System.out.println(numbers.stream()
                .reduce(0, Integer::sum));

    }

    static void peek() {
        MyList<String> names = new MyArrayList<>();
        names.add("Anna");
        names.add("Bartek");
        names.add("Cecylia");
        names.add("Dan");

        names.stream()
                .peek(System.out::println)
                .toList();
    }

    static void flatMap() {
        MyList<MyList<Integer>> numbers = new MyArrayList<>();
        MyArrayList<Integer> integers1 = new MyArrayList<>();
        integers1.add(1);
        integers1.add(2);
        MyArrayList<Integer> integers2 = new MyArrayList<>();
        integers2.add(3);
        integers2.add(4);
        numbers.add(integers1);
        numbers.add(integers2);

        numbers.stream()
                .flatMap(integers -> new MyStream<>(integers))
                .forEach(System.out::println);
    }

    static void task2_12() {
        MyList<MyList<Integer>> numbers = new MyArrayList<>();
        MyArrayList<Integer> integers1 = new MyArrayList<>();
        integers1.add(1);
        integers1.add(2);
        numbers.add(integers1);

        MyArrayList<Integer> integers2 = new MyArrayList<>();
        integers2.add(3);
        integers2.add(4);
        numbers.add(integers2);

        MyArrayList<Integer> integers3 = new MyArrayList<>();
        integers3.add(5);
        integers3.add(6);
        numbers.add(integers3);

        numbers.stream()
                .flatMap(integers -> new MyStream<>(integers))
                .peek(System.out::println);

    }

    static void join() {
        MyList<String> names = new MyArrayList<>();
        names.add("Anna");
        names.add("Bartek");
        names.add("Cecylia");

        System.out.println(names.stream()
                .join(", "));
    }

    static void task2_14_1() {
        MyList<Integer> numbers = new MyArrayList<>();
        numbers.add(12);
        numbers.add(50);
        numbers.add(70);
        numbers.add(33);

        System.out.println(numbers.stream()
                .allMatch(integer -> integer >= 0));
        System.out.println(numbers.stream()
                .noneMatch(integer -> integer > 100));
    }

    static void task2_14_2() {
        MyList<String> names = new MyArrayList<>();
        names.add("Anna");
        names.add("Agnieszka");
        names.add("Bartek");
        names.add("Cecylia");
        names.add("Adam");

        System.out.println(names.stream()
                .filter(s -> s.charAt(0) == 'A')
                .map(String::toUpperCase)
                .join(", "));
    }

    static void task2_14_3() {
        MyList<Integer> numbers = new MyArrayList<>();
        numbers.add(10);
        numbers.add(15);
        numbers.add(20);

        System.out.println(numbers.stream()
                .reduce(0, Integer::sum));
    }

    static void task2_14_4() {
        MyList<Integer> numbers = new MyArrayList<>();
        numbers.add(3);
        numbers.add(7);
        numbers.add(9);
        numbers.add(2);
        numbers.add(8);

        System.out.println(numbers.stream()
                .min(Integer::compareTo).get());
        System.out.println(numbers.stream()
                .max(Integer::compareTo).get());
    }

    static void task2_14_5() {
        MyList<MyList<Integer>> numbers = new MyArrayList<>();
        MyList<Integer> integers1 = new MyArrayList<>();
        integers1.add(1);
        integers1.add(2);
        numbers.add(integers1);

        MyList<Integer> integers2 = new MyArrayList<>();
        integers2.add(3);
        integers2.add(4);
        numbers.add(integers2);

        MyList<Integer> integers3 = new MyArrayList<>();
        integers3.add(5);
        integers3.add(6);
        numbers.add(integers3);

        System.out.println(numbers.stream()
                .flatMap(integers -> new MyStream<>(integers))
                .peek(System.out::println)
                .reduce(0, Integer::sum));
    }
}


