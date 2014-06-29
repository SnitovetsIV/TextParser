package by.snitovets.textparser.exception;

/**
 * @author Илья
 */
public class LogicException extends Exception {

    private static final long serialVersionUID = 1541273901588191403L;

    public LogicException() {
    }

    public LogicException(String string) {
        super(string);
    }

    public LogicException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

}
