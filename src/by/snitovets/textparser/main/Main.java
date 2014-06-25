package by.snitovets.textparser.main;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by Илья on 24.06.2014.
 */
public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class);

    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }

    public static void main(String[] argv) {

    }

}
