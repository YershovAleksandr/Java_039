package com.nam;

import com.nam.parser.ParseReader;
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

        ParseReader parseReader = new ParseReader();

        Parser parser = new Parser(parseReader,1202, 1);

        parser.parse(10, 0);
        System.out.println("Found " + parser.getFound());

        parser.parse(10, 1);
        System.out.println("Found " + parser.getFound());

        parser.parse(10, 2);
        System.out.println("Found " + parser.getFound());

    }
}
