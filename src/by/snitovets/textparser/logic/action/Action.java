package by.snitovets.textparser.logic.action;

import by.snitovets.textparser.entity.Component;
import by.snitovets.textparser.entity.Composite;
import by.snitovets.textparser.entity.Lexeme;
import by.snitovets.textparser.entity.LexemeType;
import by.snitovets.textparser.exception.LogicException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by Илья on 27.06.2014.
 */
public class Action {

    private static final Logger LOG = Logger.getLogger(Action.class);

    private static final String VOWELS = "aeiouyAEIOUY";

    public static ArrayList<String> sortWordsByProportionOfVowels(Composite text) throws LogicException {
        if (text == null) {
            throw new LogicException("Text can not be null.");
        }
        ArrayList<String> words = getWordsFromComposite(text);
        Comparator<String> comparator = (String s1, String s2) -> Double.compare(propVowels(s1), propVowels(s2));
        Collections.sort(words, comparator);
        return words;
    }

    private static double propVowels(String word) {
        int countOfVowels = 0;
        for (int i = 0; i < word.length(); i++) {
            if (VOWELS.indexOf(word.charAt(i)) != -1) {
                countOfVowels++;
            }
        }
        return (double) countOfVowels / word.length();
    }

    private static ArrayList<String> getWordsFromComposite(Composite composite) {
        ArrayList<String> allWords = new ArrayList<>();
        Iterator<Component> itBook = composite.iterator();
        while (itBook.hasNext()) {
            // абзацы + код
            Component compBook = itBook.next();
            if (compBook.getClass() == Composite.class) {
                Iterator<Component> itPar = ((Composite) compBook).iterator();
                while (itPar.hasNext()) {
                    //предложения
                    Component compSentence = itPar.next();
                    if (compSentence.getClass() == Composite.class) {
                        Iterator<Component> itSent = ((Composite) compSentence).iterator();
                        while (itSent.hasNext()) {
                            //лексемы
                            Component compLexeme = itSent.next();
                            if ((compLexeme.getClass() == Lexeme.class) && (((Lexeme) compLexeme).getType() == LexemeType.WORD)) {
                                allWords.add(((Lexeme) compLexeme).getTextOfComponent());
                            }
                        }
                    }
                }
            }
        }
        return allWords;
    }

}
