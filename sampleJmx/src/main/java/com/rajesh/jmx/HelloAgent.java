package com.rajesh.jmx;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

import com.rajesh.HelloWorld;
import com.sun.jdmk.comm.HtmlAdaptorServer;

public class HelloAgent {
	
	private MBeanServer mbs = null;
	
	public HelloAgent() {
		mbs = MBeanServerFactory.createMBeanServer("HelloWorld");
		HtmlAdaptorServer adapter = new HtmlAdaptorServer();
		HelloWorld helloWorld = new HelloWorld();
		ObjectName adapterName = null;
		ObjectName helloWorldName = null;
		
		try{
			helloWorldName = new ObjectName("HelloWorld:name=helloWorld1");
			mbs.registerMBean(helloWorld, helloWorldName);
			adapterName = new ObjectName("HelloAgent:name=htmlAdapter,port=9092");
			adapter.setPort(9092);
			mbs.registerMBean(adapter, adapterName);
			adapter.start();
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Starting..");
		new HelloAgent();
		/**
		 * How to run.
		 */
		
		// try http://localhost:9092/ once you get this going
	}

}
