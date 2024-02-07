package ru.job4j.oo3.sqlite.util.createxslt;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * class ConvertXSLT
 * конвертирует XML файл, полученный из StoreXML в файл другого XML формата XSLT.
 */
public class ConvertXSLT {
    File scheme;

    public ConvertXSLT(File scheme) {
        this.scheme = scheme;
    }

    /**
     * метод конвертирует входящий файл XML в соответствии схемы XSLT .
     *
     * @param source - входящий файл XML.
     * @param dest   - файл после конвертации.
     * @param scheme - схема конвертации.
     */
    public void convert(File source, File dest) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(scheme));
            transformer.transform(new StreamSource(source), new StreamResult(dest));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
