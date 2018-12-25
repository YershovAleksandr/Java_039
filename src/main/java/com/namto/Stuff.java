package com.namto;

public class Stuff {
    public static double run(int param) throws IsZeroException{
        System.out.println("Stuff:run(" + param + ")");

        if (0 == param){
            throw new IsZeroException();
        }

        return (double) 42 / param;
    }
}
