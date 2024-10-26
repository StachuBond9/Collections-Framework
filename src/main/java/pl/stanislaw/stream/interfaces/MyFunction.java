package pl.stanislaw.stream.interfaces;

public interface MyFunction<T, R> {
    R apply(T t);
}
