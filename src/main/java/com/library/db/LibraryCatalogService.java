package com.library.db;

import com.library.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

/**
 * Created by dmitry on 16.09.16.
 */
@Component
public class LibraryCatalogService {

    private final static Logger logger = LoggerFactory.getLogger(LibraryCatalogService.class);

    public void save(Book book) {
        LibraryCatalog catalog = loadCatalog();
        catalog.getCatalog().add(book);
        saveCatalog(catalog);
    }

    public void update(Book book) {
        LibraryCatalog catalog = loadCatalog();

        catalog.getCatalog().stream().filter(book1 -> book1.getId().equals(book.getId())).forEach(book1 -> {
            catalog.getCatalog().remove(book1);
            catalog.getCatalog().add(book);
        });
        saveCatalog(catalog);
    }

    public Book getById(String id) {

        LibraryCatalog catalog = loadCatalog();
        Book book = null;

        for (Book book1 : catalog.getCatalog()) {
            if (book1.getId().equals(id)) {
                book = book1;
            }
        }
        return book;
    }

    public List<Book> getAll() {
        return loadCatalog().getCatalog();
    }


    /**
     * Parse Object catalog to XML file.
     *
     * @param catalog catalog.
     */
    public void saveCatalog(LibraryCatalog catalog) {

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("catalog");
            doc.appendChild(rootElement);

            Element book = doc.createElement("book");
            rootElement.appendChild(book);

            for (Book book1 : catalog.getCatalog()) {

                book.setAttribute("id", book1.getId());

                Element author = doc.createElement("author");
                author.appendChild(doc.createTextNode(book1.getAuthor()));
                book.appendChild(author);

                Element title = doc.createElement("title");
                title.appendChild(doc.createTextNode(book1.getTitle()));
                book.appendChild(title);

                Element genre = doc.createElement("genre");
                genre.appendChild(doc.createTextNode(book1.getGenre()));
                book.appendChild(genre);

                Element price = doc.createElement("price");
                price.appendChild(doc.createTextNode(book1.getPrice()));
                book.appendChild(price);

                Element publish_date = doc.createElement("price");
                publish_date.appendChild(doc.createTextNode(book1.getPublish_date()));
                book.appendChild(publish_date);

                Element description = doc.createElement("description");
                description.appendChild(doc.createTextNode(book1.getDescription()));
                book.appendChild(description);
            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("/catalog.xml"));

            transformer.transform(source, result);

            logger.info("Catalog file saved!");

        } catch (ParserConfigurationException pce) {
            logger.error("ParserConfigurationException", pce);
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            logger.error("TransformerException", tfe);
            tfe.printStackTrace();
        }
    }

    /**
     * Parse XML file to Object catalog.
     *
     * @return {@link LibraryCatalog} catalog.
     */
    public LibraryCatalog loadCatalog() {

        LibraryCatalog catalog = new LibraryCatalog();

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File fXmlFile = new File(classLoader.getResource("catalog.xml").getFile());

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("catalog");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    Book book = new Book();

                    book.setId(eElement.getAttribute("id"));
                    book.setAuthor(eElement.getElementsByTagName("author").item(0).getTextContent());
                    book.setTitle(eElement.getElementsByTagName("title").item(0).getTextContent());
                    book.setGenre(eElement.getElementsByTagName("genre").item(0).getTextContent());
                    book.setPrice(eElement.getElementsByTagName("price").item(0).getTextContent());
                    book.setPublish_date(eElement.getElementsByTagName("publish_date").item(0).getTextContent());
                    book.setDescription(eElement.getElementsByTagName("description").item(0).getTextContent());

                    catalog.getCatalog().add(book);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("XML parser error", e);
        }

        logger.info("Catalog file was read!");
        return catalog;
    }

}
