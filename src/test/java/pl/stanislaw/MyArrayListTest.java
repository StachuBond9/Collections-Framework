package pl.stanislaw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.stanislaw.myarraylist.MyArrayList;

import java.util.ArrayList;
import java.util.Arrays;

class MyArrayListTest {


    @Test
    void addElementTest() {
        //given
        MyArrayList<Integer> list = new MyArrayList();

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
        MyArrayList<Integer> list = new MyArrayList();
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
        MyArrayList<Integer> list = new MyArrayList(3);

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
        MyArrayList<Integer> list = new MyArrayList(3);
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
        MyArrayList<Integer> list = new MyArrayList(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        ArrayList<Integer> expectedElements = new ArrayList<>();
        expectedElements.add(1);
        expectedElements.add(2);
        expectedElements.add(3);
        expectedElements.add(4);

        //when
        list.remove(4);
        int size = list.size();

        ArrayList<Integer> objects = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            objects.add(list.get(i));
        }


        //then
        Assertions.assertEquals(4, size);
        Assertions.assertEquals(expectedElements,objects);
    }

}