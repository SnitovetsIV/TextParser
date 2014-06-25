package by.snitovets.textparser.logic;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Илья on 25.06.2014.
 */
public enum ResourceManager {
    INSTANCE;
    public static final String REGEX_WORD = "prop.regex.word";
    public static final String REGEX_CODE = "prop.regex.code";
    public static final String REGEX_SENTENCE = "prop.regex.sentence";
    public static final String REGEX_PUNCTUATION = "prop.regex.punctuation";
    private static final String resourceName = "resources.prop";
    private ResourceBundle resourceBundle;

    private ResourceManager() {
        resourceBundle = ResourceBundle.getBundle(resourceName);
    }

    public void changeLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }

    public String getString(String key) {
        return resourceBundle.getString(key);
    }

}
