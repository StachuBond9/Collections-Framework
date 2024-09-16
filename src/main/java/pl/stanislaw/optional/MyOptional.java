package pl.stanislaw.optional;

public class MyOptional<T> {

    private T value;

    private MyOptional(T value) {
        this.value = value;
    }

    public static <T> MyOptional<T> empty() {
        return new MyOptional<>(null);
    }

    public static<T> MyOptional<T> ofNullable(T value){
        return new MyOptional<>(value);
    }

    public boolean isPresent() {
        return value != null;
    }

    public T get(){
        return value;
    }
    public T orElse(T a){
        if(value == null){
            return a;
        }
        return value;
    }

}
