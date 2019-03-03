package com.nam.parser;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Parser {

    //final private String URL_PATH = "https://api.hh.ru/vacancies?area=1202&specialization=1&per_page=100&page=0";
    private String URL_PATH_FORMAT = "https://api.hh.ru/vacancies?area=%d&specialization=%d&per_page=%d&page=%d";

    private int area;
    private int specialization;

    public Parser(int area, int specialization){
        this.area = area;
        this.specialization = specialization;
    }

    public void parse(int per_page, int page){
        URL url = null;

        try {
            url = new URL(String.format(URL_PATH_FORMAT, area, specialization, per_page, page));
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

        try(InputStream is = url.openStream(); JsonReader rdr = Json.createReader(is)){
            JsonObject obj = rdr.readObject();

            System.out.println("found " + obj.getInt("found"));
            System.out.println("per_page " + obj.getInt("per_page"));
            System.out.println("page " + obj.getInt("page"));

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
    }
}