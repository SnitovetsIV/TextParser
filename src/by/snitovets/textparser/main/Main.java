package by.snitovets.textparser.main;

import by.snitovets.textparser.entity.Composite;
import by.snitovets.textparser.exception.LogicException;
import by.snitovets.textparser.exception.TechnicalException;
import by.snitovets.textparser.logic.FileWorker;
import by.snitovets.textparser.logic.action.Action;
import by.snitovets.textparser.logic.parser.BookParser;
import by.snitovets.textparser.logic.parser.ParagraphParser;
import by.snitovets.textparser.logic.parser.SentenceParser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.File;

/**
 * Created by Илья on 24.06.2014.
 */
public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class);

    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }

    public static void main(String[] argv) {
        try {
            String allText = FileWorker.getTextFromFile("texts" + File.separator + "inText.txt");
            BookParser bookParser = new BookParser();
            ParagraphParser paragraphParser = new ParagraphParser();
            SentenceParser sentenceParser = new SentenceParser();
            bookParser.setNextParser(paragraphParser);
            paragraphParser.setNextParser(sentenceParser);
            Composite text = new Composite();
            text.addAll(bookParser.parse(allText));
            FileWorker.putTextToFile(text.toString(), "texts" + File.separator + "outText.txt");
            FileWorker.putTextToFile(Action.sortWordsByProportionOfVowels(text), "texts" + File.separator + "action.txt");
        } catch (TechnicalException | LogicException e) {
            LOG.error(e);
        }
    }

}
