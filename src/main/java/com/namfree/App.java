package com.namfree;

//import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class App {

    /*public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2){
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }*/

    public static void main(String[] args){
        System.out.println("Hello World Motherfucka!!!");

        List list = new ArrayList();
        list.add("Hello");
        String s = (String)list.get(0);
        System.out.println("S = " + s);

        List<String> listS = new ArrayList<>();
        listS.add("World");
        String ss = listS.get(0);
        System.out.println("SS = " + ss);

        Foo<String> stringFoo = new Foo<>();
        stringFoo.setValue("Foo");
        System.out.println("SFoo = " + stringFoo.getValue());
        stringFoo.run(42.f);

        /*Pair<Integer, String> p1 = new Pair<>(1, "Apple");
        Pair<Integer, String> p2 = new Pair<>(2, "Pear");

        boolean same = compare(p1, p2);
        System.out.println("Same = " + same);*/
    }
}
