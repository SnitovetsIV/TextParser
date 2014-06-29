package by.snitovets.textparser.logic.parser;

import by.snitovets.textparser.entity.Component;

import java.util.List;

/**
 * Created by Илья on 25.06.2014.
 */
public abstract class AbstractParser {

    private AbstractParser nextParser;

    public abstract List<? extends Component> parse(String text);

    public AbstractParser getNextParser() {
        return nextParser;
    }

    public void setNextParser(AbstractParser nextParser) {
        this.nextParser = nextParser;
    }

}
