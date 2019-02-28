package com.nam;


import javax.json.Json;
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

        final String PATH = "https://api.hh.ru/areas/countries";

        URL url = null;

        try {
            url = new URL(PATH);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

        try (InputStream is = url.openStream(); JsonParser parser = Json.createParser(is)){
            while(parser.hasNext()){
                Event e = parser.next();

                if (e == Event.KEY_NAME) {
                    switch (parser.getString()) {
                        case "id":
                            parser.next();
                            System.out.println(parser.getString());
                            break;
                        case "name":
                            parser.next();
                            System.out.println(parser.getString());
                            break;
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
