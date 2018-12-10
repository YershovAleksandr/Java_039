package com.nam;

import java.util.ArrayList;
import java.util.List;

public class Foo {
    private Bar bar = new Bar(1);
    private List<Bar> barList = new ArrayList<>();

    public Foo(){
        System.out.println("Foo()");

        bar = new Bar(2);

        barList = new ArrayList<>();

        //barList.add(new Bar(3));

    }

    public void run(){
        System.out.println("Foo run");

        Bar bar1 = new Bar(11);
        System.out.println(bar1.toString());

        Bar bar2 = new Bar(2);
        System.out.println(bar2.toString());

        Bar bar3 = new Bar();
        System.out.println(bar3.toString());

        Bar bar4 = foo2(bar1, bar2, bar3);
        System.out.println(bar4.toString());
        System.out.println(bar3.toString());
    }

    public Bar foo2(Bar bar, Bar bar2, Bar bar3){
        System.out.println("Foo2");

        Bar br = new Bar(bar.getBar() * bar2.getBar());


        bar3 = br;

        return br;
    }
}
