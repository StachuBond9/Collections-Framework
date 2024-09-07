package pl.stanislaw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    MyArrayList list = new MyArrayList();

    @Test
    void addElementTest() {
        //given

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
        MyArrayList myArrayList = new MyArrayList(3);

            myArrayList.add(1);
            myArrayList.add(2);
            myArrayList.add(3);
            myArrayList.add(4);
            myArrayList.add(1);


        Assertions.assertEquals(5, myArrayList.size() );
    }

    @Test
    void getElementByIndexTest() {
        // given
        MyArrayList myArrayList = new MyArrayList(3);
        int element = 15;
        myArrayList.add(1);
        myArrayList.add(15);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(1);

        //when
        int real = myArrayList.get(1);

        Assertions.assertEquals(element, real );
    }

    @Test
    void removeElementByIndexTest() {

        //given
        MyArrayList myArrayList = new MyArrayList(3);
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(1);

        //when
        myArrayList.remove(3);

        //then

        Assertions.assertEquals(4, myArrayList.size());
        Assertions.assertEquals(1, myArrayList.get(0));
        Assertions.assertEquals(2, myArrayList.get(1));
        Assertions.assertEquals(3, myArrayList.get(2));
        Assertions.assertEquals(1, myArrayList.get(3));
    }

}