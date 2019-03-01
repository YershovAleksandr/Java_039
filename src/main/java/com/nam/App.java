package com.nam;


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

        //final String PATH = "https://api.hh.ru/areas/countries";
        final String PATH = "https://api.hh.ru/vacancies?area=1202&specialization=1&per_page=100&page=0";

        URL url = null;

        try {
            url = new URL(PATH);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

        try(InputStream is = url.openStream(); JsonReader rdr = Json.createReader(is)){
            JsonObject obj = rdr.readObject();
            JsonArray results = obj.getJsonArray("items");

            int i = 0;
            for (JsonObject result : results.getValuesAs(JsonObject.class)){
                System.out.println();
                System.out.print(++i + " " +  result.getString("name"));
                if (!result.isNull("salary")) {
                    if (!result.getJsonObject("salary").isNull("from")) {
                        System.out.print(" " + result.getJsonObject("salary").getInt("from"));
                    }

                    if (!result.getJsonObject("salary").isNull("to")){
                        System.out.print(" " + result.getJsonObject("salary").getInt("to"));
                    }

                    if (!result.getJsonObject("salary").isNull("currency")) {
                        System.out.print(" " + result.getJsonObject("salary").getString("currency"));
                    }

                    if (!result.getJsonObject("salary").isNull("gross")) {
                        System.out.print(" " + result.getJsonObject("salary").getBoolean("gross"));
                    }

                    System.out.print(" " + result.getString("published_at"));

                    System.out.print(" " + result.getJsonObject("employer").getString("name"));
                }


            }
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println();

        /*try (InputStream is = url.openStream(); JsonParser parser = Json.createParser(is)){
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
        }*/
    }
}
