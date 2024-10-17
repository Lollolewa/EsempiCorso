package org.generation.italy.esempiCorso.generics;

public class MaxMin<T> {

    private T max,min;

    public MaxMin(T max, T min) {
        this.max = max;
        this.min = min;
    }

    public T getMax() {
        return max;
    }

    public T getMin() {
        return min;
    }
}
