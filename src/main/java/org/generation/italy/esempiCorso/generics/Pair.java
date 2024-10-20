package org.generation.italy.esempiCorso.generics;

import java.util.Objects;

public class Pair<K, V> {
    private K first;
    private V second;
    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
    public K getFirst() {
        return first;
    }
    public V getSecond() {
        return second;
    }
    @Override
    public String toString(){
        return String.format("(%s, %s)", first, second);
    }
     @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Pair<K, V> other = (Pair<K, V>) o;
        return (first.equals(other.first) && second.equals(other.second)) || (first.equals(other.first) && second.equals(other.second));
    }
    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}