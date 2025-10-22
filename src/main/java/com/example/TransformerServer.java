package com.example;

import static spark.Spark.*;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class TransformerServer {

    public static void main(String[] args) {
        port(4567); // default Spark port

        Transformer transformer = new Transformer();
        Gson gson = new Gson();

        post("/transform", (req, res) -> {
            res.type("application/xml");

            // Parse JSON input
            Map<String, String> payload = gson.fromJson(req.body(), Map.class);
            String xml = payload.get("xml");
            String xslt = payload.get("xslt");

            if (xml == null || xslt == null) {
                res.status(400);
                return "<error>Missing 'xml' or 'xslt' in request body</error>";
            }

            // Transform and return result
            String result = transformer.transform(xml, xslt);
            return result;
        });
    }
}