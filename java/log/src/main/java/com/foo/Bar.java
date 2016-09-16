package com.foo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bar {
    static final Logger logger = LoggerFactory.getLogger(Bar.class.getName());

    public boolean doIt() {
        logger.error("Did it again!");
        return false;
    }
}