package ch03.ex23;

import java.util.function.Function;

public class Pair<T> {
    private T first;
    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public <R> Pair<R> map(Function<? super T,? extends R> mapper) {
        return new Pair<>(mapper.apply(first), mapper.apply(second));
    }
}