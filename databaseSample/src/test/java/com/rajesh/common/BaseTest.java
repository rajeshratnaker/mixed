/*
 * Copyright 2011 Deutsche Bank. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Deutsche Bank. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement you entered
 * into with Deutsche Bank.
 */

package com.rajesh.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Rajesh Kumar
 *
 */
public abstract class BaseTest {

    private static ApplicationContext APP_CONTEXT = new ClassPathXmlApplicationContext(
                    new String[] { "test-application-context-dao.xml" });

    public <T> T getBean(String beanName, Class<T> clazz) {
        return APP_CONTEXT.getBean(beanName, clazz);
    }

}
