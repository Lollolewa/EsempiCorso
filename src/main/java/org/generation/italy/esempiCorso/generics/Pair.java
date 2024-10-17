package org.generation.italy.esempiCorso.generics;

public class Pair<K, V> {
    private K firstValue;
    private V secondValue;

    public Pair(K firstValue, V secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public K getFirstValue() {
        return firstValue;
    }
    public V getSecondValue() {
        return secondValue;
    }

    @Override
    public String toString() {
        return String.format("Pair:%nFirst: %s%nSecond: %s%n", firstValue, secondValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null && this.getClass() != o.getClass()) {
            return false;
        }
        Pair<K, V> other = (Pair<K, V>) o;
        return firstValue.equals(other.firstValue) && secondValue.equals(other.secondValue) || secondValue.equals(other.secondValue) && firstValue.equals(other.firstValue);
    }

    @Override
    public int hashCode(){
        return firstValue.hashCode() + secondValue.hashCode();
    }
}
