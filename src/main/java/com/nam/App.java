package com.nam;


import com.nam.parser.Parser;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.stream.JsonParser;
import static javax.json.stream.JsonParser.Event;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


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
