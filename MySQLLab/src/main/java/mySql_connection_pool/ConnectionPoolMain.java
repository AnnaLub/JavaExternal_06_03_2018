package mySql_connection_pool;

import mySql_connector.ConnectionNotClosedException;
import mySql_connector.ConnectionNotOpenedException;
import java.sql.SQLException;

public class ConnectionPoolMain {
    public static void main(String[] args) throws SQLException, ConnectionNotOpenedException, ConnectionNotClosedException {
        ConnectionPool cp = new ConnectionPool(2);
        /*for (int i = 0; i <cp.getAvailableConnsCnt() ; i++) {
            System.out.println(cp.getCondbw());
        }*/

        ConnectorDBWrapper con1 = cp.retrieve();
        /*cp.printAllAvailable();*/
        cp.printAllUsed();
        System.out.println(cp.getTotalConnectionsAmount());
        System.out.println(cp.getAvailableConns());
        ConnectorDBWrapper con2 = cp.retrieve();
        ConnectorDBWrapper con3 =cp.retrieve();
        System.out.println(cp.getTotalConnectionsAmount());

        cp.putback(con1);
        cp.putback(con2);
        cp.putback(con3);
        cp.printAllAvailable();

    }
}
