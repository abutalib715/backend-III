/*
Background: A document processing tool converts documents between various formats (e.g., PDF, Word, HTML).
As user demands increase, the tool needs to support additional formats, such as XML, JSON, or even audio formats.
These new conversions must be added without modifying the existing code that handles current formats.

Question: How would you design the document conversion tool to allow new format conversions to be added
without altering the existing conversion logic?
*/


interface DocumentConverter {
    public Document convertDocument(Order order);
}

class PdfConverter implements DocumentConverter {
    public Document convertDocument(Order order) {
        // convertion logic
    }
}

class HtmlConverter implements DocumentConverter {
    public Document convertDocument(Order order) {
        // convertion logic
    }
}

class WordConverter implements DocumentConverter {
    public Document convertDocument(Order order) {
        // convertion logic
    }
}

class DocumentConverterFactory {
    public static DocumentConverter getDocConverter(String documentType) {
        switch (documentType) {
            case "pdf":
                return new PdfConverter();
            case "word":
                return new WordConverter();
            case "html":
                return new HtmlConverter();
            default:
                throw new IllegalArgumentException("Unknown type: " + documentType);
        }
    }
}

class DocConvertionService {
    public void convertDoc(Document document) {
        DocumentConverter documentConverter = new DocumentConverterFactory.getDocConverter(document.type);
        Document convertedDoc = documentConverter.convertDocument(document);
    }
}