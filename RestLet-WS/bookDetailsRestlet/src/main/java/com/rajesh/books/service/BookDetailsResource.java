package com.rajesh.books.service;

import java.util.concurrent.Executors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class BookDetailsResource extends ServerResource {
	Log log=LogFactory.getLog(getClass());
	
	public BookDetailsResource(){
		System.out.println("BookDetailsService:Hello World");
		log.info("Hello");
	}
	
	@Get("text")
	 @SuppressWarnings("unchecked")
	 public Representation printBookDetail() {
			System.out.println("---printBookDetail---");
	        log.debug(getRequest().getRootRef() + ", " + getRequest().getResourceRef());
	       // final Set<BulkLoader> loaders = (Set<BulkLoader>) getContext().getAttributes().get("LOADERS");
	       // Validate.notNull(loaders, "Expected to find loaders");

	        /*String cacheName = (String) getRequest().getAttributes().get("cacheName");
	        String what = (String) getRequest().getAttributes().get("what");
	        Integer max = Integer.valueOf((String)getRequest().getAttributes().get("max"));*/
	        
	        Executors.newSingleThreadExecutor().execute(new Runnable() {
	            public void run() {
	                for (int i=0;i<2;i++) {
	                    log.info("Book Count " + i);
	                    System.out.println("Book Count " + i);
	                }
	            }
	        });

	        return new StringRepresentation("You have invoked rest service for a specific book detail.");
	    }
}
