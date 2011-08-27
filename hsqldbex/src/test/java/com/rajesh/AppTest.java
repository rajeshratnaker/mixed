package com.rajesh;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
 
public class AppTest extends TestCase {
    public AppTest(String testName) {
        super(testName);
    }
 
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }
 
    public void testApp() throws Exception {
        Class.forName("org.hsqldb.jdbcDriver");
        String url = "jdbc:hsqldb:file:src/main/resources/db/mydbname";
        String username = "sa";
        String password = "";
 
        Connection connection = DriverManager.getConnection(url, username,
                password);
 
        Statement statement = connection.createStatement();
        try {
            statement.executeQuery("select * from sec_edgar_filer;");
        } catch (SQLException ex) { // if no table then create one.
            statement
                    .execute("CREATE TABLE sec_edgar_filer ( cik VARCHAR(22) NOT NULL);");
        }
 
        try {
            statement.execute("insert into sec_edgar_filer values ( 'Hello World! "
                    + System.currentTimeMillis() + "' );");
            ResultSet resultset = statement
                    .executeQuery("select * from sec_edgar_filer;");
 
            int count = 0;
            while (resultset.next()) {
                System.out.println(resultset.getString(1));
                count++;
            }
            System.out.println("total rows returned: " + count);
 
        } finally {
            try {statement.execute("SHUTDOWN;");} catch (Exception ex) {}
            try {connection.close();} catch (Exception ex) {}
        }
    }
}