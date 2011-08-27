package com.rajesh.books.service;


public class BookDetailsService{
	public String bookDetails(String str){
		System.out.println("Call to bookDetails,StartDate:"+str+"; From Business Layer");
		return "Book Details request for "+str+" and Response";
		
	}

}
