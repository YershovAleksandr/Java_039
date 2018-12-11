package com.nam;

public class Bar implements Cloneable {
    private int i;

    public Bar(){
        System.out.println("Bar()");
        this.i = 42;
    }


    public Bar(int i){
        System.out.println("Bar(" + i + ")");
        this.i = i;
    }

    public Bar(Bar bar){
        i = bar.getBar();
    }

    public int getBar(){
        return i;
    }

    public void setBar(int i){
        this.i = i;
    }

    public String toString(){
        return String.format("Bar.toString() = %s", i);
    }

    @Override
    public Bar clone(){
        return new Bar(this.getBar());
    }
}
