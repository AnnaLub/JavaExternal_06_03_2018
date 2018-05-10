package mySql_connection_pool;

import mySql_connector.ConnectionNotClosedException;
import mySql_connector.ConnectionNotOpenedException;
import mySql_connector.ConnectorDB;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectorDBWrapper {
    private Connection connection;
    private int index;

    private final static Logger dbclogger = Logger.getLogger("db.logger");

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public Connection getConnection() {
        return connection;
    }

    public ConnectorDBWrapper(int index) {
        try {
           connection = ConnectorDB.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            dbclogger.error(e);
        } catch (ConnectionNotOpenedException e) {
            e.printStackTrace();
            dbclogger.error(e);
        }
        setIndex(index);
    }

    public static void closeConnection(ConnectorDBWrapper conWrapper) throws SQLException, ConnectionNotClosedException {
       Connection con = conWrapper.getConnection();
       ConnectorDB.closeConnection(con);
    }

    @Override
    public String toString() {
        return "ConnectorDBWrapper{"
                + index +
                '}';
    }
}
