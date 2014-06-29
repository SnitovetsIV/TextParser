package by.snitovets.textparser.logic.parser;

import by.snitovets.textparser.entity.Component;
import by.snitovets.textparser.entity.Composite;
import by.snitovets.textparser.entity.Lexeme;
import by.snitovets.textparser.entity.LexemeType;
import by.snitovets.textparser.logic.ResourceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Илья on 25.06.2014.
 */
public class BookParser extends AbstractParser {

    @Override
    public List<? extends Component> parse(String text) {
        ArrayList<Component> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder(text);
        Pattern pattern = Pattern.compile(ResourceManager.getInstance().getString(ResourceManager.REGEX_CODE));
        Matcher mat = pattern.matcher(sb.toString());
        while (mat.find()) {
            if (getNextParser() != null) {
                Composite paragraph = new Composite();
                String stringParagraph = sb.substring(0, mat.start());
                paragraph.addAll(getNextParser().parse(stringParagraph));
                result.add(paragraph);
            } else {
                Lexeme unknownLexeme = new Lexeme();
                String stringParagraph = sb.substring(0, mat.start());
                unknownLexeme.setTextOfComponent(stringParagraph);
                result.add(unknownLexeme);
            }
            Lexeme code = new Lexeme(LexemeType.CODE);
            code.setTextOfComponent(mat.group());
            result.add(code);

            sb.delete(0, mat.end());
            mat = pattern.matcher(sb.toString());
        }
        Composite paragraph = new Composite();
        String stringParagraph = sb.toString();
        paragraph.addAll(getNextParser().parse(stringParagraph));
        result.add(paragraph);
        return result;
    }
}
