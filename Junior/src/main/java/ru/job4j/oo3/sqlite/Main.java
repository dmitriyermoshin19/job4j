package ru.job4j.oo3.sqlite;

import ru.job4j.oo3.sqlite.config.Config;
import ru.job4j.oo3.sqlite.util.createxml.StoreXML;
import ru.job4j.oo3.sqlite.util.createxml.Entry;
import ru.job4j.oo3.sqlite.util.createxslt.ConvertXSLT;
import ru.job4j.oo3.sqlite.util.parsandsum.ParserSAX;
import ru.job4j.oo3.sqlite.repozitory.StoreSQL;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Config config = new Config();
        StoreSQL storeSQL = new StoreSQL(new Config());
        //можно клиента как трекере сделать с биз.лог. в ооп стиле
        storeSQL.generate(Integer.parseInt("10"));//упрощенный клиент вставляет 10
        List<Entry> entryList = storeSQL.load();//упрощенный клиент скачивает лист

        File fileXML = new File("./Junior/src/main/java/ru/job4j/oo3/sqlite/target.xml");//красный
        new StoreXML(fileXML).save(entryList);//упрощенный клиент просит преобразовать в хмл

        File scheme = new File("./Junior/src/main/resources/scheme.xsl");
        File fileXSLT = new File("./Junior/src/main/java/ru/job4j/oo3/sqlite/target.xslt");//красный
        new ConvertXSLT(scheme).convert(fileXML, fileXSLT);//процедурн.стиль-данные хранит в аргументах

        int sum = new ParserSAX().parseXSLTFile(fileXSLT);
        System.out.print(sum);
    }
}
