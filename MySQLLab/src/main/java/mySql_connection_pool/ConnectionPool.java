package mySql_connection_pool;

import mySql_connector.ConnectionNotClosedException;
import mySql_connector.ConnectionNotOpenedException;

import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//SHOW ENGINE INNODB STATUS\G

/**
 * @author Anna Lubska
 * Class {@code ConnectionPool} creates pool of connections to the DB through getConnection() method {@code ConnectorDB}
 * static method getConnection invoked by static metod {@code DriverManager};
 **/
public class ConnectionPool {
    ConnectorDBWrapper condbw;
    int counter;
    List<ConnectorDBWrapper> availableConns = new ArrayList<>();
    List<ConnectorDBWrapper> usedConns = new ArrayList<>();

   /**constructor{@code ConnectionPool}
    * @returns pool of available coonnections limited by variable amount
    **/
    public ConnectionPool(int amount) {
        for (int i = 0; i <amount; i++)
        {
             availableConns.add(new ConnectorDBWrapper(i));
        }
        counter = amount;
    }

    /**synchronized method checks available connections list and creates new connection via {@code ConnectorDB}
     * if available connections list not empty - retrieve connection from list and reduce list on one item
     * @returns new Connection to DB
     * @exception SQLException
     * @exception ConnectionNotOpenedException
     **/
    public synchronized ConnectorDBWrapper retrieve() throws SQLException, ConnectionNotOpenedException {
        ConnectorDBWrapper newConn = null;
        if(availableConns.isEmpty()){
            newConn = new ConnectorDBWrapper(counter++);
        }else{
            newConn = availableConns.get(availableConns.size()-1);
            availableConns.remove(availableConns.size()-1);
        }
        usedConns.add(newConn);
        return newConn;
    }

    /**synchronized method checks whether Connection reference not null and if so - remove connection from used connection list
     *  and add it to available connections list
     * @exception NullPointerException
     **/
    public synchronized void putback(ConnectorDBWrapper condbw) throws NullPointerException, ConnectionNotClosedException, SQLException {
        if(condbw!= null) {
            if (usedConns.remove(condbw)) {
                ConnectorDBWrapper.closeConnection(condbw);
                availableConns.add(condbw);
            } else {
                throw new NullPointerException("This connection not in the used connections list");
            }
        }
    }

    public List<ConnectorDBWrapper> getAvailableConns() {
        return availableConns;
    }

    public List<ConnectorDBWrapper> getUsedConns() {
        return usedConns;
    }

    /**
     * static void display all Available connections
     **/
    public void printAllAvailable(){
        List<ConnectorDBWrapper> listForPrint;
        ConnectorDBWrapper item = null;
        listForPrint =  this.getAvailableConns();
        if(listForPrint.isEmpty()){
            System.out.println("No available connections in Connection Pool");
        }else{
            for (int i = 0; i < listForPrint.size(); i++) {
                item = listForPrint.get(i);
                System.out.println(item.toString());
            }
        }
    }

    /**
     * static void display all used connections
     **/
    public void printAllUsed(){
        List<ConnectorDBWrapper> listForPrint;
        ConnectorDBWrapper item = null;
        listForPrint =  this.getUsedConns();
        if(listForPrint.isEmpty()){
            System.out.println("No used connections in Connection Pool");
        } else{
        for (int i = 0; i < listForPrint.size(); i++) {
            item = listForPrint.get(i);
            System.out.println(item.toString());}
        }
    }

    /**
     * @return amount of available connections
     **/
    public int getAvailableConnsCnt() {
        return availableConns.size();
    }

    /**
     * @return total amount of created connections
     **/
    public int getTotalConnectionsAmount() {
        return counter;
    }

    @Override
    public String toString() {
        return "ConnectionPool{" +
                availableConns +
                '}';
    }
}
