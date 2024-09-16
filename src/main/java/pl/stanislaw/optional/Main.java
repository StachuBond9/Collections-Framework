package pl.stanislaw.optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> opString1 = Optional.empty();
        System.out.println(opString1);
        System.out.println(opString1.isPresent());

        Optional<String> opString2 = Optional.ofNullable("122ijjdjkdkk2");
        System.out.println(opString2);


        MyOptional<String> opString3 = MyOptional.empty();
        System.out.println(opString3);
        System.out.println(opString3.isPresent());


        MyOptional<String> opString4 = MyOptional.ofNullable("hhshsh233");
        System.out.println(opString4);
        System.out.println(opString4.isPresent());



        MyOptional<String> opString5 = MyOptional.ofNullable("12334kl");
        String value = opString5.get();
        System.out.println(value);


        MyOptional<String> opString6 = MyOptional.ofNullable("12kl");
        String value1 = opString6.orElse("nullowe");
        System.out.println(value1);
    }
}
