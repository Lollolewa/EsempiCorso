package org.generation.italy.esempiCorso.generic;

public class Generics<K, V> {
    private K first;
    private V second;

    public Generics(K first, V second) {
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
    public String toString() {
        return String.format("Generics: first = %s, second = %s", first, second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Generics<K, V> generics = (Generics<K, V>) o;
        return (first.equals(generics.first) && second.equals(generics.second)) ||
                (first.equals(generics.second) && second.equals(generics.first));
    }

    @Override
    public int hashCode() {
        return first.hashCode() + second.hashCode();
    }
}

