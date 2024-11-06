package org.generation.italy.esempiCorso.generics;

public class Pair <K,V>{
    private K first;
    private V second;
    public Pair(K first, V second){
        this.first=first;
        this.second=second;
    }
    public K getFirst(){
        return first;
    }

    public V getSecond() {
        return second;
    }
    @Override
    public String toString(){
        return String.format("Pair: first = %s, second = %s", first,second);
    }
    @Override
    public boolean equals(Object o){
        if(this==o){ //se le due reference puntano allo stesso oggetto, sono lo stesso oggetto
            return true;
        }
        if (o==null || this.getClass() != o.getClass()){
        //paragona le classi dei due oggetti, se hanno classi diverse i due oggetti non sono uguali
            return false;
        }
        Pair<K,V> other =  (Pair<K,V>) o;
        return (first.equals(other.first) && second.equals(other.second)) || (first.equals(other.second) && second.equals(other.first));
    }
    @Override
    public int hashCode(){
        return first.hashCode() + second.hashCode();
    }
}
