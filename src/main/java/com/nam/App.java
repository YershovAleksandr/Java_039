package com.nam;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );

        Foo foo = new Foo();

        foo.run();

        BuzFactory bf = new BuzFactory();

        //AbstractBuz buz = bf.getBuz();
        AbstractBuz buz = bf.getBuz();

        System.out.println("2ch = " + buz.read2ch());

        /*public String toString(){
        return this.getClass().getField("representation").get(this);
        }*/

        //int i = buz.getClass().getMethod("read2ch").invoke(this);

    }
}
