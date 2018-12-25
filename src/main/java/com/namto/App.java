package com.namto;

public class App {
    public static void main(String[] args){

        System.out.println("Hello World!");

        double res = 0.;

        try {
            res = Stuff.run(0);
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("Res = " + res);
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        return false;
    }
}
