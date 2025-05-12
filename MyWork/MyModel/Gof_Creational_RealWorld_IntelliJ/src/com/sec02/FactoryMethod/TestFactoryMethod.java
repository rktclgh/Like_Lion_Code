package com.sec02.FactoryMethod;

//팩토리 패턴 : java.lang.NumberFormat, java.text.DateFormat
// java.nio.Paths -> get()
public class TestFactoryMethod {
    public static void main(String[] args) {
        Document doc = DocumentFactory.createDocument("pdf");
        doc.open();
    }
}
