package com.nam;

import com.nam.parser.Parser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World 42!" );

        Parser parser = new Parser(1202, 1);

        parser.parse(10, 0);
        parser.parse(10, 1);
        parser.parse(10, 2);

    }
}
