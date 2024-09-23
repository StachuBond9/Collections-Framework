package pl.stanislaw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.stanislaw.myarraylist.MyArrayList;

class MyArrayListTest {


    @Test
    void addElementTest() {
        //given
        MyArrayList<Integer> list = new MyArrayList<>();

        Integer element = 1;

        //when
        list.add(element);

        //then
        boolean isContain = list.contains(element);
        Assertions.assertTrue(isContain);
    }

    @Test
    void addMultipleElementsTest() {
        //given
        MyArrayList<Integer> list = new MyArrayList<>();
        Integer element = 1;

        //when
        list.add(12);
        list.add(2);
        list.add(173);
        list.add(element);
        list.add(152);
        list.add(1232);


        //then
        boolean isContain = list.contains(element);
        Assertions.assertTrue(isContain);
    }

    @Test
    void addMultipleElementsShouldIncreaseCapacityTest() {
        MyArrayList<Integer> list = new MyArrayList<>(3);

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);


        Assertions.assertEquals(5, list.size());
    }

    @Test
    void getElementByIndexTest() {
        // given
        MyArrayList<Integer> list = new MyArrayList<>(3);
        int element = 15;
        list.add(1);
        list.add(15);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);

        //when
        int real = list.get(1);

        Assertions.assertEquals(element, real);
    }


    @Test
    void removeElementByIndexTest() {

        //given
        MyArrayList<Integer> list = new MyArrayList<>(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        //when
        list.remove(3);

        int size = list.size();

        //then
        Assertions.assertEquals(4, size);
        Assertions.assertTrue( list.contains(1));
        Assertions.assertTrue( list.contains(2));
        Assertions.assertFalse( list.contains(4));
        Assertions.assertTrue( list.contains(3));
        Assertions.assertTrue( list.contains(5));
    }

    @Test
    void removeElementByValueTest() {

        //given
        MyArrayList<Integer> list = new MyArrayList<>(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        //when
        list.remove((Integer) 3);

        int size = list.size();

        //then
        Assertions.assertEquals(4, size);
        Assertions.assertTrue( list.contains(1));
        Assertions.assertTrue( list.contains(2));
        Assertions.assertTrue( list.contains(4));
        Assertions.assertFalse( list.contains(3));
        Assertions.assertTrue( list.contains(5));
    }

    @Test
    void elementsShouldBeInOrderTest() {
        //given
        MyArrayList<Integer> list = new MyArrayList<>();

        //when
        list.add(12);
        list.add(2);
        list.add(173);
        list.add(1);
        list.add(152);
        list.add(1232);


        //then
        Assertions.assertEquals(12, list.get(0));
        Assertions.assertEquals(2, list.get(1));
        Assertions.assertEquals(173, list.get(2));
        Assertions.assertEquals(1, list.get(3));
        Assertions.assertEquals(152, list.get(4));
        Assertions.assertEquals(1232, list.get(5));
    }

}