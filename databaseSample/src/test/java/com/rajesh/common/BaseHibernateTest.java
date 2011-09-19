/*
 * Copyright 2011 Deutsche Bank. All rights reserved.
 * 
 * This software is the confidential and proprietary information of Deutsche Bank. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement you entered
 * into with Deutsche Bank.
 */

package com.rajesh.common;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.After;
import org.junit.Before;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;


public abstract class BaseHibernateTest extends BaseTest {

    private static Log LOG = LogFactory.getLog(BaseHibernateTest.class);

    private Transaction tx;

    @Before
    public void before() {

        SessionFactory sessionFactory = getSessionFactory();

        Session session = sessionFactory.openSession();
        TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(session));

        tx = session.beginTransaction();
        LOG.debug("Opened HBN Session: " + session.getClass().getSimpleName());

    }

    @After
    public void after() {

        tx.commit();
        SessionHolder sessionHolder = (SessionHolder) TransactionSynchronizationManager.unbindResource(getSessionFactory());

        sessionHolder.getSession().close();

        LOG.debug("Closed HBN Session");
    }

    protected SessionFactory getSessionFactory() {
        try {
            return getBean("sessionFactory", SessionFactory.class);
        } catch (Exception ex) {
            // Make sure you log the exception, as it might be swallowed
            ex.printStackTrace(System.err);
            throw new ExceptionInInitializerError(ex);
        }
    }

}
