package by.snitovets.textparser.logic;

import org.apache.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Илья on 25.06.2014.
 */
public class ResourceManager {

    public static final String REGEX_WORD = "prop.regex.word";
    public static final String REGEX_CODE = "prop.regex.code";
    public static final String REGEX_SENTENCE = "prop.regex.sentence";
    public static final String REGEX_PUNCTUATION = "prop.regex.punctuation";
    public static final String REGEX_WORD_AND_PUNCTUATION = "prop.regex.wordpunctuation";

    private static final Logger LOG = Logger.getLogger(ResourceManager.class);
    private static final String resourceName = "resources.prop";
    private ResourceBundle resourceBundle;
    private Lock lock = new ReentrantLock();

    private ResourceManager() {
        resourceBundle = ResourceBundle.getBundle(resourceName);
    }

    public static ResourceManager getInstance() {
        return LazyResourceManagerHolder.singletonInstance;
    }

    public void changeLocale(Locale locale) {
        if (locale != null) {
            lock.lock();
            resourceBundle = ResourceBundle.getBundle(resourceName, locale);
            lock.unlock();
        } else {
            LOG.warn("Locale can not be null. Value has not been assigned.");
        }

    }

    public String getString(String key) {
        return resourceBundle.getString(key);
    }

    private static class LazyResourceManagerHolder {
        public static ResourceManager singletonInstance = new ResourceManager();
    }

}
