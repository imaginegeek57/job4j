package ru.job4j.sqlLite;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxParser {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        File file = new File("C:\\projects\\job4j\\chapter_005\\src\\main\\resources\\sqlLog.xml");

        if (file.exists())
            parser.parse(file, new Handler());

    }
}
