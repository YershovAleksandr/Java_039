package com.nam.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Math.min;

public class Parser {
    private static Logger log = LoggerFactory.getLogger(Parser.class);

    final private String URL_PATH_FORMAT = "https://api.hh.ru/vacancies?area=%d&specialization=%d&per_page=%d&page=%d";
    final private String KEY_FOUND = "found";
    final private String KEY_ITEMS = "items";
    final private String KEY_NAME = "name";
    final private String KEY_SALARY = "salary";
    final private String KEY_FROM = "from";
    final private String KEY_TO = "to";
    final private String KEY_CURRENCY = "currency";
    final private String KEY_GROSS = "gross";
    final private String KEY_PUBLISHED_AT = "published_at";
    final private String KEY_EMPLOYER = "employer";

    final private int PER_PAGE = 20;

    //api restrictions
    final private int MAX_PER_PAGE = 100;
    //final private int MAX_ITEMS = 2000;
    final private int MAX_ITEMS = 200;

    private ParseReader parseReader;

    private int area;
    private int specialization;
    private int found;

    public Parser(ParseReader parseReader, int area, int specialization){
        this.parseReader = parseReader;
        this.area = area;
        this.specialization = specialization;
    }

    public int getFound(){
        return found;
    }

    public void parse(){
        int perPage = min(PER_PAGE, MAX_PER_PAGE);

        parse(perPage, 0);

        int times = min(getFound() / PER_PAGE, MAX_ITEMS / PER_PAGE);

        log.info("Times = {}", times);

        for (int i = 1; i < times; i++){
            parse(perPage, i);

            log.info("I = {}", i);
        }
    }

    private void parse(int per_page, int page){
        URL url;

        try {
            url = new URL(String.format(URL_PATH_FORMAT, area, specialization, per_page, page));
        }catch (MalformedURLException e){
            log.error("Error", e);

            return;
        }

        try(InputStream is = url.openStream(); JsonReader rdr = Json.createReader(is)){
            JsonObject obj = rdr.readObject();

            found = obj.getInt(KEY_FOUND);

            JsonArray results = obj.getJsonArray(KEY_ITEMS);

            for (JsonObject result : results.getValuesAs(JsonObject.class)){
                parseReader.setName(result.getString(KEY_NAME));
                parseReader.setPublishedAt(result.getString(KEY_PUBLISHED_AT));
                parseReader.setEmployerName(result.getJsonObject(KEY_EMPLOYER).getString(KEY_NAME));

                if (!result.isNull(KEY_SALARY)) {
                    if (!result.getJsonObject(KEY_SALARY).isNull(KEY_FROM)) {
                        parseReader.setSalaryFrom(result.getJsonObject(KEY_SALARY).getInt(KEY_FROM));
                    }

                    if (!result.getJsonObject(KEY_SALARY).isNull(KEY_TO)){
                        parseReader.setSalaryTo(result.getJsonObject(KEY_SALARY).getInt(KEY_TO));
                    }

                    if (!result.getJsonObject(KEY_SALARY).isNull(KEY_CURRENCY)) {
                        parseReader.setSalaryCurrency(result.getJsonObject(KEY_SALARY).getString(KEY_CURRENCY));
                    }

                    if (!result.getJsonObject(KEY_SALARY).isNull(KEY_GROSS)) {
                        parseReader.setSalaryGross(result.getJsonObject(KEY_SALARY).getBoolean(KEY_GROSS));
                    }
                }

                parseReader.process();
            }
        }catch (Exception e){
            log.error("Error", e);
        }
    }
}