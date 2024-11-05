package pl.stanislaw.optional;

import java.util.function.Supplier;

public class MyOptional<T> {

    private final T value;

    private MyOptional(T value) {
        this.value = value;
    }

    public static <T> MyOptional<T> empty() {
        return new MyOptional<>(null);
    }

    public static <T> MyOptional<T> ofNullable(T value) {
        return new MyOptional<>(value);
    }

    public boolean isPresent() {
        return value != null;
    }

    public T get() {
        return value;
    }

    public T orElse(T a) {
        if (value == null) {
            return a;
        }
        return value;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public static <T> MyOptional<T> of(T value) {
        if (value == null) {
            throw new NullPointerException("value cannot be null");
        }
        return new MyOptional<>(value);
    }

    public T orElseGet(Supplier<? extends T> other) {
        if (value == null) {
            return other.get();
        }
        return value;
    }

    public T orElseThrow(Supplier<? extends Throwable> exceptionSupplier) throws Throwable {
        if (value == null) {
            throw exceptionSupplier.get();
        }
        return value;
    }

    @Override
    public String toString() {
        return "MyOptional{" +
                "value=" + value +
                '}';
    }
}
