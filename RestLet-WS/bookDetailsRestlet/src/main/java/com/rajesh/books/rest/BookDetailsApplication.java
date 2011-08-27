package com.rajesh.books.rest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.rajesh.books.service.BookDetailsResource;
import com.rajesh.books.service.PrintBookDetailsResource;

public class BookDetailsApplication extends Application{
	private final Log log = LogFactory.getLog(getClass());

	public  BookDetailsApplication(){
		 	System.out.println("--Creating BookDetailsApplication--");
	        log.info("Creating " + getContext());
	}
	 @Override
	 public Restlet createRoot() {
			// getContext().getAttributes().put("LOADERS", bulkLoaders);
			// getContext().getAttributes().put("CACHE_FACTORY", cacheFactory);
	        Router router = new Router(getContext());
	        System.out.println("--Creating router with context--");
	        log.info("Creating router with context " + getContext());
	        router.attach("/books/{name}", BookDetailsResource.class);
	        router.attach("/books", PrintBookDetailsResource.class);
	        return router;
	    }
}
