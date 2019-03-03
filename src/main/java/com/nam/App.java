package com.nam;

import com.nam.parser.ParseProcess;
import com.nam.parser.ParseProcessImpl;
import com.nam.parser.ParseReader;
import com.nam.parser.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Logger log = LoggerFactory.getLogger(App.class);

    public static void main( String[] args )
    {
        log.info("Hello World 42!");

        ParseProcess parseProcess = new ParseProcessImpl();
        ParseReader parseReader = new ParseReader(parseProcess);
        Parser parser = new Parser(parseReader,1202, 1);

        parser.parse(2, 0);
        log.info("Found {}", parser.getFound());
    }
}