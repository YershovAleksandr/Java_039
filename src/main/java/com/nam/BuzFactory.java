package com.nam;

public class BuzFactory {
    public AbstractBuz getBuz() throws Exception{
        AbstractBuz buz = null;

        buz = new ConcreteBuz();

        return buz;
    }
}
