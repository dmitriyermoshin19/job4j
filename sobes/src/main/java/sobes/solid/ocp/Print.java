package ru.job4j.sobes.solid.ocp;

import java.util.List;

public class Print { //открыт для наследования и закрыт для изменения
    //т.е. можно добавлять другие реализации, но метод getAllDocument(List<IPrint> list, String document)
    //не будет меняться - будет закрыт для изменения

    void getAllDocument(List<IPrint> list, String document) {
        for (IPrint iPrint : list) {
            iPrint.getDocument(document);
        }
    }
}

interface IPrint {
    void getDocument(String document);
}
class XMLDocument implements IPrint {
    @Override
    public void getDocument(String document) {
    }
}
class PDFDocument implements IPrint {
    @Override
    public void getDocument(String document) {
    }
}