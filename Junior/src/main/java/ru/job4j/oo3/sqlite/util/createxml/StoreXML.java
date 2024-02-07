package ru.job4j.oo3.sqlite.util.createxml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

/**
 * class StoreXML
 * генерирует файл XML из коллекции с перемещенными даанными базы entry.
 */
public class StoreXML {
    private File target;

    public StoreXML(File target) {
        this.target = target;
    }

    public void save(List<Entry> list) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(new Entries(list), target);
            //тут можно просто лист поставить:
//            jaxbMarshaller.marshal(list, new File("persons.xml"));


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
