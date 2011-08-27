package com.rajesh.books.service;

import java.util.concurrent.Executors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class PrintBookDetailsResource extends ServerResource {
	Log log=LogFactory.getLog(getClass());
	
	public PrintBookDetailsResource(){
		System.out.println("PrintBookDetailsService:Hello World");
		log.info("Hello");
	}

	
	 @Get("text")
	 @SuppressWarnings("unchecked")
	 public Representation printBookDetails() {
		 System.out.println("---printBookDetails---");
	        log.debug(getRequest().getRootRef() + ", " + getRequest().getResourceRef());
	       // final Set<BulkLoader> loaders = (Set<BulkLoader>) getContext().getAttributes().get("LOADERS");
	       // Validate.notNull(loaders, "Expected to find loaders");

	        Executors.newSingleThreadExecutor().execute(new Runnable() {
	            public void run() {
	                for (int i=0;i<2;i++) {
	                    log.info("Count " + i);
	                    System.out.println("Count " + i);
	                }
	            }
	        });

	        return new StringRepresentation("You have invoked rest service for book details.");
	    }
}
