package by.snitovets.textparser.logic.parser;

import by.snitovets.textparser.entity.Component;
import by.snitovets.textparser.entity.Lexeme;
import by.snitovets.textparser.entity.LexemeType;
import by.snitovets.textparser.logic.ResourceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Илья on 27.06.2014.
 */
public class SentenceParser extends AbstractParser {

    @Override
    public List<? extends Component> parse(String text) {
        ArrayList<Component> result = new ArrayList<>();
        Pattern patternWord = Pattern.compile(ResourceManager.getInstance().getString(ResourceManager.REGEX_WORD));
        Pattern patternPunctuation = Pattern.compile(ResourceManager.getInstance().getString(ResourceManager.REGEX_PUNCTUATION));
        Pattern patWorAndPunct = Pattern.compile(ResourceManager.getInstance().getString(ResourceManager.REGEX_WORD_AND_PUNCTUATION));
        String[] all = text.split("(?= )");
        for (String candidate : all) {
            Matcher mat = patWorAndPunct.matcher(candidate);
            Lexeme newPart;
            Matcher testUnknown = patWorAndPunct.matcher(candidate.trim());
            if (((testUnknown.find()) && (testUnknown.start() == 0))) {
                while (mat.find()) {
                    newPart = new Lexeme();
                    newPart.setTextOfComponent(mat.group());
                    if (mat.group().matches(patternWord.pattern())) {
                        newPart.setType(LexemeType.WORD);
                    } else {
                        newPart.setType(LexemeType.PUNCTUATION);
                    }
                    result.add(newPart);
                }

            } else {
                newPart = new Lexeme(LexemeType.UNKNOWN);
                newPart.setTextOfComponent(candidate);
                result.add(newPart);
            }
        }
        return result;
    }
}
