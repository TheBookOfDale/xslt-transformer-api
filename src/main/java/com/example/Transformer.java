package com.example;

import net.sf.saxon.s9api.*;
import javax.xml.transform.stream.StreamSource;

import java.io.StringReader;
import java.io.StringWriter;

public class Transformer {

    private final Processor processor;

    public Transformer() {
        this.processor = new Processor(false); // false = no schema awareness
    }

    public String transform(String xmlInput, String xsltInput) {
        try {
            // Prepare sources
            StringReader xmlReader = new StringReader(xmlInput);
            StringReader xsltReader = new StringReader(xsltInput);

            // Compile XSLT
            XsltCompiler compiler = processor.newXsltCompiler();
            XsltExecutable executable = compiler.compile(new StreamSource(xsltReader));

            // Set up transformer
            XsltTransformer transformer = executable.load();
            transformer.setSource(new StreamSource(xmlReader));

            // Capture output
            StringWriter outputWriter = new StringWriter();
            Serializer serializer = processor.newSerializer(outputWriter);
            serializer.setOutputProperty(Serializer.Property.METHOD, "xml");
            serializer.setOutputProperty(Serializer.Property.INDENT, "yes");

            transformer.setDestination(serializer);
            transformer.transform();

            return outputWriter.toString();

        } catch (SaxonApiException e) {
            return "Transformation error: " + e.getMessage();
        }
    }
}