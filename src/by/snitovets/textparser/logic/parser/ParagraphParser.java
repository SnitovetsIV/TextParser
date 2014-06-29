package by.snitovets.textparser.logic.parser;

import by.snitovets.textparser.entity.Component;
import by.snitovets.textparser.entity.Composite;
import by.snitovets.textparser.entity.Lexeme;
import by.snitovets.textparser.logic.ResourceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Илья on 27.06.2014.
 */
public class ParagraphParser extends AbstractParser {

    @Override
    public List<? extends Component> parse(String text) {
        ArrayList<Component> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(ResourceManager.getInstance().getString(ResourceManager.REGEX_SENTENCE));
        Matcher mat = pattern.matcher(text);
        while (mat.find()) {
            if (getNextParser() != null) {
                Composite sentence = new Composite();
                sentence.addAll(getNextParser().parse(mat.group()));
                result.add(sentence);
            } else {
                Lexeme unknownLexeme = new Lexeme();
                unknownLexeme.setTextOfComponent(mat.group());
                result.add(unknownLexeme);
            }
        }
        return result;
    }
}
