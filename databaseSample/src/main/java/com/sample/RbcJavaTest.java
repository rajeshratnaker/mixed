package com.sample;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.Validate;

import com.google.common.collect.ImmutableList;


public class RbcJavaTest {
	
	private final String HELLO = "Hello";
	private final String WORLD = "World";
	private final String FAIR = "Fair";
	
	private String transformStringForNumbers(Integer number){
		Validate.notNull(number, "Invalid Argument Exception");
		if((number % 3 ==0) && (number % 5== 0)){
			return HELLO+" "+ FAIR + " " + WORLD;
		}else if (number % 3 ==0){
			return HELLO;
		}else if(number % 5 ==0 ){
			return WORLD;
		}else{
			return number.toString();
		}
	}
	
	public String transformList(List<String> arguments) throws NumberFormatException{
		Validate.isTrue(arguments != null, "Called with null list");
		Validate.isTrue(!arguments.isEmpty(), "Called with empty list");
		Collection<String> transformedList = com.google.common.collect.Collections2.transform(arguments, new com.google.common.base.Function<String, String>() {

			public String apply(String number) {
					try{
					    return transformStringForNumbers(Integer.valueOf(number));
				}catch (NumberFormatException e) {
					throw e;
				}
				catch (IllegalArgumentException e) {
					throw e;
				}
			}
		});
		
		StringBuffer stringBuffer = new StringBuffer("");
		for(String str : transformedList){
			if(!"".equals(stringBuffer.toString())){
				stringBuffer.append(" ");
			}
			stringBuffer.append(str);
		}
		return stringBuffer.toString();
	}
	
	public String transformList(String[] arguments) throws NumberFormatException{
		return transformList(ImmutableList.of(arguments));
	}
	
	public static void main(String[] args) {
		RbcJavaTest transformer = new RbcJavaTest();
		System.out.println(transformer.transformList(ImmutableList.of(args)));
	}

}
