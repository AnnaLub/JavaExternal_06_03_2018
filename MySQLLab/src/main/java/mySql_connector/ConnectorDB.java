package mySql_connector;

import org.apache.log4j.Logger;

import java.util.*;
import java.sql.*;


public class ConnectorDB {
    /**
     * @author Anna Lubska
     * Class {@code ConnectorDB} creates connection to the DB through file {@link "DataBase.properties"} and use {@code ResourseBundle}
     * static method getConnection invoked by static metod {@code DriverManager};
     * @return Connection reference if DriverManager class reloaded and connection succeeded
     * @exception ClassNotFoundException if the DriverManager class doesn't reloaded
     * @exception InstantiationException throws when specified class object cannot be instantiated(the class object
     * represents an abstract class, an interface, an array class, a primitive type, or void, the class has no nullary constructor)
     * @exception IllegalAccessException throws when the currently executing method does not have access to the definition of
     * the specified class, field, method or constructor
     * @exception SQLException if connection doesn't succeeded
     **/

    private final static Logger dbclogger = Logger.getLogger("db.logger");

    public static Connection getConnection() throws SQLException, ConnectionNotOpenedException {
        Connection connection;
        ResourceBundle resourse = ResourceBundle.getBundle("DataBase");
        String driver = resourse.getString("db.driver");
        String url = resourse.getString("db.url");
        String user = resourse.getString("db.user");
        String password = resourse.getString("db.password");
        try
        {
        Class.forName(driver).newInstance();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
            dbclogger.error(e);
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
            dbclogger.error(e);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            dbclogger.error(e);
        }
        connection = DriverManager.getConnection(url,user,password);

        if(!connection.isClosed()){
            System.out.println("Connection with DB is ESTABLISHED");
        }
        else{
            //нужно спросить как логировать самописные ошибки
            throw new ConnectionNotOpenedException("EXCEPTION IN DB OPEN");
        }
        dbclogger.info("Connection with DB is established");
        return connection;
    }
    /**
     * static method opens connection;
     * @return Connection reference if DriverManager class reloaded and connection succeeded
     * @exception ConnectionNotClosedException if connection doesn't succeeded
     * @exception SQLException any SQLExceptions thrown higher
     * */

    public static void closeConnection(Connection connection) throws SQLException, ConnectionNotClosedException {
        connection.close();
        dbclogger.info("Connection with DB is closed");

        if(connection.isClosed()){
            System.out.println("Connection with DB is CLOSED");
        }
        else{
            throw new ConnectionNotClosedException("EXCEPTION IN DB CLOSE");
        }
    }
}






