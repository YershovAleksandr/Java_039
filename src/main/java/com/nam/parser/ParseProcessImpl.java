package com.nam.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParseProcessImpl implements ParseProcess {
    private static Logger log = LoggerFactory.getLogger(ParseProcessImpl.class);

    private static int i;

    @Override
    public void process(ParseReader parseReader){
        //System.out.println(++i + " " + toString());
        log.info("{} {}", ++i, parseReader.toString());
    }
}