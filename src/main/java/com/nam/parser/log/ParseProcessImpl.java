package com.nam.parser.log;

import com.nam.parser.ParseProcess;
import com.nam.parser.ParseReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParseProcessImpl implements ParseProcess {
    private static Logger log = LoggerFactory.getLogger(ParseProcessImpl.class);

    private static int i;

    @Override
    public void process(ParseReader parseReader){
        log.info("{} {}", ++i, parseReader.toString());
    }
}