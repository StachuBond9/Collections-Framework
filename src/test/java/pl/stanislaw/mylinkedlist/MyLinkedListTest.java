package pl.stanislaw.mylinkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.stanislaw.MyList;
import pl.stanislaw.myarraylist.MyArrayList;

import java.util.Iterator;

class MyLinkedListTest {


    @Test
    void addElementTest() {
        //given
        MyList<String> list = new MyLinkedList<>();

        String element = "raz2";

        //when
        list.add(element);

        //then
        boolean isContain = list.contains(element);
        Assertions.assertTrue(isContain);
    }


    @Test
    void addMultipleElementsByIndexTest() {
        //given
        MyLinkedList<String> list = linkedListWIthElements();
        String element = "123sddd";

        //when
        list.add(4, element);
        list.add("ytuyuh");
        list.add("jkkkk23");


        //then
        boolean isContain = list.contains(element);
        Assertions.assertTrue(isContain);
    }

    @Test
    void setElementOnIndex() {
        //given
        MyLinkedList<String> list = linkedListWIthElements();
        String element = "perez";
        //when
        list.set(3, element);
        Assertions.assertTrue(list.contains(element));
        Assertions.assertEquals(3, list.indexOf(element));
    }

    @Test
    void getElementByIndexTest() {
        //given
        MyLinkedList<String> list = linkedListWIthElements();
        //when then
        Assertions.assertEquals("Norris", list.get(1));
    }

    @Test
    void getElementIndexTest() {
        //given
        MyLinkedList<String> list = linkedListWIthElements();

        //when then
        Assertions.assertEquals(2, list.indexOf("Leclerc"));
    }

    @Test
    void removeElementByIndexTest() {
        //given
        MyLinkedList<String> list = linkedListWIthElements();

        list.remove(3);
        //when then
        Assertions.assertEquals("Lewis", list.get(3));
    }

    @Test
    void removeElementByIElementTest() {
        //given
        MyLinkedList<String> list = linkedListWIthElements();

        list.remove("MAX");
        //when then
        Assertions.assertFalse(list.contains("MAX"));
    }
    @Test
    void iteratorWork(){
        //given
        MyLinkedList<String> list = linkedListWIthElements();
        Iterator<String> iterator = list.iterator();

        //when then
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("MAX", iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Norris", iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Leclerc", iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Piastrii", iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Lewis", iterator.next());
        Assertions.assertFalse(iterator.hasNext());


    }

    private MyLinkedList<String> linkedListWIthElements() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("MAX");
        list.add("Norris");
        list.add("Leclerc");
        list.add("Piastrii");
        list.add("Lewis");

        return list;
    }


}