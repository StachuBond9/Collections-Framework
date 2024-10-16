package pl.stanislaw.myhashmap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.stanislaw.MyList;
import pl.stanislaw.myarraylist.MyArrayList;


class MyHashMapTest {

    @Test
    void shouldPutElement() {
        //given
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        String key = "ala";
        String value = "kot";
        //when
        myHashMap.put(key, value);
        //then
        Assertions.assertEquals(myHashMap.size(), 1);
        Assertions.assertTrue(myHashMap.containsKey(key));
        Assertions.assertTrue(myHashMap.containsValue(value));
        Assertions.assertEquals(value, myHashMap.get(key));
    }

    @Test
    void shouldPutMultipleElement() {
        //given
        MyHashMap<String, String> myHashMap = multipleElementsMap();
        String key = "ala";
        String value = "kot";
        //when
        myHashMap.put(key, value);
        //then
        Assertions.assertEquals(myHashMap.size(), 5);
        Assertions.assertTrue(myHashMap.containsKey(key));
        Assertions.assertTrue(myHashMap.containsValue(value));
        Assertions.assertEquals(value, myHashMap.get(key));
        Assertions.assertEquals("babcia", myHashMap.get("112225"));
        Assertions.assertEquals("pinokio", myHashMap.get("56767"));
        Assertions.assertEquals("bajki", myHashMap.get("990903"));
        Assertions.assertEquals("kaptur", myHashMap.get("99566733"));


    }

    @Test
    void shouldRemoveElement() {
        //given
        MyHashMap<String, String> myHashMap = multipleElementsMap();
        String key = "ala";
        String value = "kot";
        //when
        myHashMap.remove("56767");

        //then
        Assertions.assertEquals(3, myHashMap.size());
        Assertions.assertFalse(myHashMap.containsKey("56767"));
        Assertions.assertTrue(myHashMap.containsKey("112225"));
        Assertions.assertTrue(myHashMap.containsKey("990903"));
        Assertions.assertTrue(myHashMap.containsKey("99566733"));
    }

    @Test
    void shouldNotRemoveElement() {
        //given
        MyHashMap<String, String> myHashMap = multipleElementsMap();
        String key = "ala";
        String value = "kot";
        //when
        myHashMap.remove("567337");

        //then
        Assertions.assertEquals(4, myHashMap.size());
        Assertions.assertTrue(myHashMap.containsKey("56767"));
        Assertions.assertTrue(myHashMap.containsKey("112225"));
        Assertions.assertTrue(myHashMap.containsKey("990903"));
        Assertions.assertTrue(myHashMap.containsKey("99566733"));
    }

    @Test
    void isMapNotEmpty() {
        //given
        MyHashMap<String, String> myHashMap = multipleElementsMap();

        //when then
        Assertions.assertFalse(myHashMap.isEmpty());
    }

    @Test
    void isMapEmpty() {
        //given
        MyHashMap<String, String> myHashMap = new MyHashMap<>();

        //when then
        Assertions.assertTrue(myHashMap.isEmpty());
    }

    @Test
    void isMapCleared() {
        //given
        MyHashMap<String, String> myHashMap = multipleElementsMap();

        //when
        myHashMap.clear();

        // then
        Assertions.assertTrue(myHashMap.isEmpty());
    }


    @Test
    void isKeyContains() {
        //given
        MyHashMap<String, String> myHashMap = multipleElementsMap();

        //when then
        Assertions.assertTrue(myHashMap.containsKey("56767"));
        Assertions.assertTrue(myHashMap.containsKey("112225"));
        Assertions.assertTrue(myHashMap.containsKey("990903"));
        Assertions.assertTrue(myHashMap.containsKey("99566733"));

    }

    @Test
    void isKeyNotContains() {
        //given
        MyHashMap<String, String> myHashMap = new MyHashMap<>();

        //when then
        Assertions.assertFalse(myHashMap.containsKey("333009"));
    }


    @Test
    void isValueContains() {
        //given
        MyHashMap<String, String> myHashMap = multipleElementsMap();

        //when then
        Assertions.assertTrue(myHashMap.containsValue("babcia"));
        Assertions.assertTrue(myHashMap.containsValue("kaptur"));
        Assertions.assertTrue(myHashMap.containsValue("bajki"));
        Assertions.assertTrue(myHashMap.containsValue("pinokio"));

    }

    @Test
    void isValueNotContains() {
        //given
        MyHashMap<String, String> myHashMap = new MyHashMap<>();

        //when then
        Assertions.assertFalse(myHashMap.containsValue("333009"));
    }

    @Test
    void areKeysInMap(){
        //given
        MyHashMap<String, String> myHashMap =  multipleElementsMap();

        MyList<String> list = myHashMap.keySet();
        Assertions.assertTrue(list.contains("112225"));
        Assertions.assertTrue(list.contains("56767"));
        Assertions.assertTrue(list.contains("990903"));
        Assertions.assertTrue(list.contains("99566733"));
    }

    @Test
    void aresNoKeysInMap(){
        //given
        MyHashMap<String, String> myHashMap =  new MyHashMap<>();

        MyList<String> list = myHashMap.keySet();
        Assertions.assertFalse(list.contains("112225"));
        Assertions.assertFalse(list.contains("56767"));
        Assertions.assertFalse(list.contains("990903"));
        Assertions.assertFalse(list.contains("99566733"));
    }

    @Test
    void areValuesInMap(){
        //given
        MyHashMap<String, String> myHashMap =  multipleElementsMap();

        MyList<String> list = myHashMap.values();
        Assertions.assertTrue(list.contains("babcia"));
        Assertions.assertTrue(list.contains("pinokio"));
        Assertions.assertTrue(list.contains("bajki"));
        Assertions.assertTrue(list.contains("kaptur"));
    }

    @Test
    void arNoeValuesInMap(){
        //given
        MyHashMap<String, String> myHashMap =  new MyHashMap<>();

        MyList<String> list = myHashMap.keySet();
        Assertions.assertFalse(list.contains("babcia"));
        Assertions.assertFalse(list.contains("pinokio"));
        Assertions.assertFalse(list.contains("bajki"));
        Assertions.assertFalse(list.contains("kaptur"));
    }

    private MyHashMap<String, String> multipleElementsMap() {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put("112225", "babcia");
        myHashMap.put("56767", "pinokio");
        myHashMap.put("990903", "bajki");
        myHashMap.put("99566733", "kaptur");
        return myHashMap;
    }

}