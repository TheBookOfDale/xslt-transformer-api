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
```
**Response:**
```xml
    <message>Hello, Christopher!</message>
```
---

## 🧪 Local Development

1. Clone the repo:
```bash
        git clone https://github.com/your-username/xslt-transformer-api.git
        cd xslt-transformer-api
```
2. Add Saxon-HE to your classpath:
```bash
        java -cp saxon-he-11.4.jar:. Transformer input.xml transform.xslt output.xml
```
3. Run the web server (Spark or Spring Boot):
```bash
        ./gradlew run
```
---

## 🌐 Deployment

This API is designed to be hosted on platforms like:

- [Render](https://render.com/)  
- Netlify Functions  
- Azure App Service  
- Vercel Functions  

Once deployed, connect your GitHub Pages frontend to the endpoint using `fetch()`.

---

## 🧠 Educational Extensions (Coming Soon)

- Highlight XSLT 3.0 constructs (e.g., `xsl:iterate`, `xsl:merge`, `map`, `array`)  
- Toggle to comment out unsupported features for XSLT 2.0 fallback  
- Inline annotations and tooltips for learning  

---

## 📄 License

MIT — free to use, modify, and integrate.

---

## ✍️ Author

Built by [Christopher](https://your-portfolio-link.com), Manager of Data Analytics & Operational Systems. Passionate about integration, clarity, and empowering users through interactive tooling.
