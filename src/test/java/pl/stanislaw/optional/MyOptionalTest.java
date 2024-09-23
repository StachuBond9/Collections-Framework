package pl.stanislaw.optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

class MyOptionalTest {

    @Test
    public void isObjectNullTest() {
        //given
        MyOptional<String> optional = MyOptional.empty();

        //when
        String object1 = optional.get();

        //then
        Assertions.assertEquals(null, object1);

    }

    @Test
    public void isObjectEqualTest() {
        //given
        String object1 = "raz2";
        MyOptional<String> optional = MyOptional.ofNullable(object1);

        //when

        String object2 = optional.get();

        //then
        Assertions.assertEquals(object1, object2);
    }

    @Test
    public void isObjectPresentTest() {
        //given
        String object1 = "raz2";
        MyOptional<String> optional = MyOptional.ofNullable(object1);

        //when

        boolean isPresent = optional.isPresent();

        //then
        Assertions.assertTrue(isPresent);
    }

    @Test
    public void getObjectOrElseTest() {
        //given
        String object1 = "raz2";
        String elseObject = "dwa3";
        MyOptional<String> optional = MyOptional.ofNullable(object1);

        //when

        String object2 = optional.orElse(elseObject);

        //then
        Assertions.assertEquals(object1, object2);
    }

    @Test
    public void getObjectOrElseDefaultTest() {
        //given
        String object1 = "raz2";
        String elseObject = "dwa3";
        MyOptional<String> optional = MyOptional.empty();

        //when

        String object2 = optional.orElse(elseObject);

        //then
        Assertions.assertEquals(elseObject, object2);
    }

    @Test
    public void isObjectEmpty() {
        //given
        String object1 = null;
        MyOptional<String> optional = MyOptional.ofNullable(object1);

        //when

        boolean isEmpty = optional.isEmpty();

        //then

        Assertions.assertTrue(isEmpty);
    }

    @Test
    public void ofCreateObject() {
        //given
        String object1 = "st7o";

        //when

        MyOptional<String> optional = MyOptional.of(object1);

        //then
        String object2 = optional.get();

        Assertions.assertEquals(object1, object2);

    }

    @Test
    public void orElseGet() {
        //given
        String object1 = "mad max";
        String stringSupplier = "wor123";
        MyOptional<String> optional = MyOptional.empty();

        Supplier<String> supplier = () -> stringSupplier;
        //when
        String object2 = optional.orElseGet(supplier);

        //then
        Assertions.assertEquals(stringSupplier, object2);
    }

    @Test
    public void orElseThrow() throws Throwable {
        //given
        String object1 = "pop";
        MyOptional<String> optional = MyOptional.of(object1);

        //when
        String object2 = optional.orElseThrow(() -> new IllegalArgumentException("Object is empty"));

        //then
        Assertions.assertEquals(object1, object2);
    }

    @Test
    public void orElseThrow_throwsException() {
        //given

        MyOptional<String> optional = MyOptional.empty();

        //when then
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> optional.orElseThrow(() -> new IllegalArgumentException("Object is empty")));

        Assertions.assertEquals("Object is empty", exception.getMessage());
    }

}