package pl.stanislaw.optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyOptionalTest {

    @Test
    public void isObjectNullTest(){
        //given
        MyOptional<String> optional = MyOptional.empty();

        //when
        String object1 = optional.get();

        //then
        Assertions.assertEquals(null, object1);

    }

    @Test
    public void isObjectEqualTest(){
        //given
        String object1 = "raz2";
        MyOptional<String> optional = MyOptional.ofNullable(object1);

        //when

        String object2 = optional.get();

        //then
        Assertions.assertEquals(object1, object2);
    }

    @Test
    public void isObjectPresentTest(){
        //given
        String object1 = "raz2";
        MyOptional<String> optional = MyOptional.ofNullable(object1);

        //when

        boolean isPresent = optional.isPresent();

        //then
        Assertions.assertTrue(isPresent);
    }

    @Test
    public void getObjectTest(){
        //given
        String object1 = "raz2";
        MyOptional<String> optional = MyOptional.ofNullable(object1);

        //when

        String object2 = optional.get();

        //then
        Assertions.assertEquals(object1, object2);
    }

    @Test
    public void getObjectorElseTest(){
        //given
        String object1 = "raz2";
        String elseObject = "dwa3";
        MyOptional<String> optional = MyOptional.ofNullable(object1);

        //when

        String object2 = optional.orElse(elseObject);

        //then
        Assertions.assertEquals(object1, object2);
    }

}