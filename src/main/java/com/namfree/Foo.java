package com.namfree;

public class Foo<T> {
    private T value;

    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public <S extends Number> void run(S u){
        System.out.println("S = " + u.getClass().getName());
        System.out.println("S = " + u.getClass().getSimpleName());
        System.out.println("S = " + u.getClass().getCanonicalName());
    }

    /*public <S extends Float & Double> void run2(S u){
        System.out.println("S = " + u.getClass().getName());
        System.out.println("S = " + u.getClass().getSimpleName());
        System.out.println("S = " + u.getClass().getCanonicalName());
    }*/

}
