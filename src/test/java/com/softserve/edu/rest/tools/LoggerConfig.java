package com.softserve.edu.rest.tools;


import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LoggerConfig {
    private String loggerName;

    LoggerConfig(String name) {
        this.loggerName = name;
    }

//    public Logger loggerConfig() throws IOException {
//        log.addAppender(new FileAppender(new PatternLayout("%m%n"),
//                "D:\\framework\\rest\\lv426\\logs\\" + loggerName + ".log"));
//        return log;
//    }
}
