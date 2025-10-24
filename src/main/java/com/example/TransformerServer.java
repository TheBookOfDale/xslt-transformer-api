package com.example;

import static spark.Spark.*;

import com.google.gson.Gson;
import java.util.Map;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

public class TransformerServer {

    public static void main(String[] args) {
        port(4567); // default Spark port

        // Enable CORS for localhost:4000
        before((req, res) -> {
            res.header("Access-Control-Allow-Origin", "http://localhost:4000");
            res.header("Access-Control-Allow-Methods", "POST, OPTIONS");
            res.header("Access-Control-Allow-Headers", "Content-Type");
        });

        Transformer transformer = new Transformer();
        Gson gson = new Gson();

        post("/transform", (req, res) -> {
            res.type("application/xml");

            // Parse JSON input
            Type type = new TypeToken<Map<String, String>>() {}.getType();
            Map<String, String> payload = gson.fromJson(req.body(), type);
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
        
        options("/*", (req, res) -> {
            return "OK";
        });
    }
}