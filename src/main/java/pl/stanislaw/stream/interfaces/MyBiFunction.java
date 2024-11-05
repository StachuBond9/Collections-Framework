package pl.stanislaw.stream.interfaces;

public interface MyBiFunction<T, U, R> {
    R apply( T t, U u);

}

