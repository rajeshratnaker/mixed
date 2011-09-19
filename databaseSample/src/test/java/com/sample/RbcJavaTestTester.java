package com.sample;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class RbcJavaTestTester {
	private final RbcJavaTest transformer = new RbcJavaTest();
	
	@Test
	public void testForRightParams(){
		String input = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18";
		String output = "1 2 Hello 4 World Hello 7 8 Hello World 11 Hello 13 14 Hello Fair World 16 17 Hello";
		String[] inputArray = input.split(" ");
		Assert.assertEquals(output, transformer.transformList(inputArray));
	}
	
	@Test
	public void testFailure(){
		String input = "1 2 3 a 5 6 7 ui 9 10 11 12 13 14 15 16 17 18";
		String[] inputArray = input.split(" ");
		
		String output = null;
		Exception exception = null;
		try{
			output = transformer.transformList(inputArray);
		}catch (Exception e) {
			exception = e;
		}
		Assert.assertTrue(exception instanceof NumberFormatException);
		Assert.assertNull(output);
	}
	
	@Test
	public void testEmpty(){
		List inputArray = new ArrayList();
		String output = null;
		Exception exception = null;
		try{
			output = transformer.transformList(inputArray);
		}catch (Exception e) {
			exception = e;
		}
		Assert.assertTrue(exception instanceof IllegalArgumentException);
		Assert.assertNull(output);
	}
	
	@Test
	public void testNull(){
		List<String> inputArray = null;
		String output = null;
		Exception exception = null;
		try{
			output = transformer.transformList(inputArray);
		}catch (Exception e) {
			exception = e;
		}
		Assert.assertTrue(exception instanceof IllegalArgumentException);
		Assert.assertNull(output);
	}
	
}
