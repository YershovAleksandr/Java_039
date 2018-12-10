package com.nam;

public class Bar {
    private int i;

    public Bar(){
        System.out.println("Bar()");
        this.i = 42;
    }


    public Bar(int i){
        System.out.println("Bar(" + i + ")");
        this.i = i;
    }

    public int getBar(){
        return i;
    }

    public String toString(){
        return String.format("Bar.toString() = %s", i);
    }
}
