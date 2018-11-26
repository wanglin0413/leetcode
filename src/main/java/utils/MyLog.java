package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLog {
    private static final Logger logger = LogManager.getLogger("logger");

    public static Logger getLogger(){
        return logger;
    }
}
