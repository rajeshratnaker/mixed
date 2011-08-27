package com.rajesh.books.ws;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.xpath.XPath;
import org.springframework.ws.server.endpoint.AbstractJDomPayloadEndpoint;

import com.rajesh.books.service.BookDetailsService;

public class BooksEndpoint extends AbstractJDomPayloadEndpoint {

    private XPath bookNameExpression;

    private final BookDetailsService bookDetailsService;
    Namespace namespace = Namespace.getNamespace("books", "http://rajesh.com/books/schemas");

    public BooksEndpoint(BookDetailsService bookDetailsService) throws JDOMException {
        this.bookDetailsService = bookDetailsService;
        System.out.println("-----Book Details Endpoint------");
        bookNameExpression = XPath.newInstance("//books:book");
        bookNameExpression.addNamespace(namespace);
    }

    protected Element invokeInternal(Element bookName) throws Exception {  
    	System.out.println("----InvokeInternal------");
        String name = bookNameExpression.valueOf(bookName);
        String details=bookDetailsService.bookDetails(name);
        Element nodeElement = new Element("Result", namespace);
        nodeElement.addContent(details);
        return nodeElement;
    }
}