package by.snitovets.textparser.exception;

/**
 * @author Илья
 */
public class TechnicalException extends Exception {

    private static final long serialVersionUID = 8213638502732520446L;

    public TechnicalException() {
    }

    public TechnicalException(String string) {
        super(string);
    }

    public TechnicalException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

}
