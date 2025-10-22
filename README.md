# XSLT Transformer API

A lightweight Java-based API for transforming XML using XSLT 2.0, powered by Saxon-HE. This service accepts XML and XSLT input via HTTP POST and returns the transformed output. Designed for integration with static frontends (e.g., GitHub Pages) and educational tooling that highlights XSLT 3.0 constructs with graceful fallback support.

---

## 🚀 Features

- Accepts raw XML and XSLT input via JSON payload
- Executes transformations using Saxon-HE (XSLT 2.0)
- Returns clean XML output or error messages
- Designed for frontend integration and interactive learning
- Future support for XSLT 3.0 construct detection and fallback toggling

---

## 📦 Requirements

- Java 11+
- Saxon-HE 11.4 (`saxon-he-11.4.jar`)
- Optional: Spark Java or Spring Boot for HTTP routing

---

## 🛠️ Usage

### 🔧 POST `/transform`

**Request Body (JSON):**
```json
{
  "xml": "<greeting><name>Christopher</name></greeting>",
  "xslt": "<xsl:stylesheet version=\"2.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">...</xsl:stylesheet>"
}
