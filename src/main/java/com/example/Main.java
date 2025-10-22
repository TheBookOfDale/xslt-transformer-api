package com.example;

public class Main {
    public static void main(String[] args) {
        String xml = "<greeting><name>Christopher</name></greeting>";
        String xslt =
            "<xsl:stylesheet version=\"2.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">" +
            "<xsl:output method=\"xml\" indent=\"yes\"/>" +
            "<xsl:template match=\"/\">" +
            "<message>Hello, <xsl:value-of select=\"greeting/name\"/>!</message>" +
            "</xsl:template>" +
            "</xsl:stylesheet>";

        Transformer transformer = new Transformer();
        String result = transformer.transform(xml, xslt);
        System.out.println(result);
    }
}