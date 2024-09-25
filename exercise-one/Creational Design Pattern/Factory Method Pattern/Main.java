// Product Interface
interface Document {
    void open();
}

// Concrete Product: Word Document
class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document...");
    }
}

// Concrete Product: PDF Document
class PDFDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document...");
    }
}

// Concrete Product: Spreadsheet Document
class SpreadsheetDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Spreadsheet document...");
    }
}

// Creator Class: Document Factory
class DocumentFactory {
    public static Document createDocument(String type) {
        if (type.equalsIgnoreCase("word")) {
            return new WordDocument();
        } else if (type.equalsIgnoreCase("pdf")) {
            return new PDFDocument();
        } else if (type.equalsIgnoreCase("spreadsheet")) {
            return new SpreadsheetDocument();
        } else {
            throw new IllegalArgumentException("Unknown document type");
        }
    }
}

// Main class to test the Factory Method
public class Main {
    public static void main(String[] args) {
        // Create different types of documents using the factory
        Document wordDoc = DocumentFactory.createDocument("word");
        Document pdfDoc = DocumentFactory.createDocument("pdf");
        Document spreadsheetDoc = DocumentFactory.createDocument("spreadsheet");

        // Open the documents
        wordDoc.open();
        pdfDoc.open();
        spreadsheetDoc.open();
    }
}
