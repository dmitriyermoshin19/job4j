package ru.job4j.oo3.sqlite;

import java.io.File;
import java.util.List;

public class Main {

        public static void main(String[] args) {
            Config config = new Config();
            StoreSQL storeSQL = new StoreSQL(config);
            storeSQL.generate(Integer.parseInt("10"));
            List<Entry> entryList = storeSQL.load();

            File scheme = new File("./Junior/src/main/resources/scheme.xsl");
            File fileXML = new File("./Junior/src/main/java/ru/job4j/oo3/sqlite/target.xml");
            new StoreXML(fileXML).save(entryList);

            File fileXSLT = new File("./Junior/src/main/java/ru/job4j/oo3/sqlite/target.xslt");
            new ConvertXSLT().convert(fileXML, fileXSLT, scheme);

            int sum = new ParserSAX().parseFile(fileXSLT);
            System.out.print(sum);
        }
}
