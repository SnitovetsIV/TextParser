package by.snitovets.textparser.entity;

import org.apache.log4j.Logger;

public class Lexeme implements Component {

    private static final Logger LOG = Logger.getLogger(Lexeme.class);

    private LexemeType type = LexemeType.UNKNOWN;
    private String textOfComponent;

    public Lexeme() {
    }

    public Lexeme(LexemeType type) {
        if (type != null) {
            this.type = type;
        } else {
            LOG.warn("LexemeType can not be null. Value has not been assigned.");
        }
    }

    public String getTextOfComponent() {
        return (textOfComponent != null) ? textOfComponent.trim() : "";
    }

    public void setTextOfComponent(String textOfComponent) {
        if (textOfComponent != null) {
            this.textOfComponent = textOfComponent;
        } else {
            LOG.warn("Text of component can not be null. Value has not been assigned.");
        }
    }

    public LexemeType getType() {
        return type;
    }

    public void setType(LexemeType type) {
        if (type != null) {
            this.type = type;
        } else {
            LOG.warn("LexemeType can not be null. Value has not been assigned.");
        }
    }

    public String toString() {
        return (textOfComponent != null) ? textOfComponent : "";
    }


}
