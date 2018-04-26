package dao;

import mySql_connection_pool.ConnectionPool;
import mySql_connection_pool.ConnectorDBWrapper;
import mySql_connector.ConnectionNotClosedException;
import mySql_connector.ConnectionNotOpenedException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;


public class ProductDAOConnectionPool {
    private static final String sql1 = "DELETE FROM TEACHER WHERE T_NAME = ?";
    private static final String sql2 = "INSERT INTO TEACHER(T_NAME,STATUS) VALUES (?,?)";
    private static final String sql3 = "UPDATE DISCIPLINE SET T_NAME = ? WHERE T_NAME IS NULL";

    //2 connections needed
    ConnectionPool pool = new ConnectionPool(2);
    private final static Logger logger = Logger.getLogger(ProductDAOConnectionPool.class);

    public void changeTeachersName(String oldName, String newName, String status) throws ConnectionNotClosedException,
            SQLException, TeacherNameChangeException {
        PreparedStatement removepst = null;
        PreparedStatement addpst = null;
        PreparedStatement psd = null;

        ConnectorDBWrapper con1 = null;
        ConnectorDBWrapper con2 = null;

        try
        {
        con1 = pool.retrieve();
        con1.getConnection().setAutoCommit(false);
        logger.info("AutoCommit of connection 1 DISABLED");
        con1.getConnection().setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
        logger.info("connection 1 TL set to TRANSACTION_READ_UNCOMMITTED");

        con2 = pool.retrieve();
        con2.getConnection().setAutoCommit(false);
        logger.info("AutoCommit of connection 2 DISABLED");
        con2.getConnection().setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
        logger.info("connection 2 TL set to TRANSACTION_READ_UNCOMMITTED");
        }
        catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage() + "SQLState: " + e.getSQLState());
            logger.error(e);
        }
        catch (ConnectionNotOpenedException e) {
            e.printStackTrace();
            logger.error(e);
        }
        try
        {
            removepst = con1.getConnection().prepareStatement(sql1);
            removepst.setString(1,oldName);
            logger.info("Remove action Statement for TEACHER MAP Prepared");

            addpst = con1.getConnection().prepareStatement(sql2);
            addpst.setString(1,newName);
            addpst.setString(2,status);
            logger.info("Adding action Statement for TEACHER MAP Prepared");

            psd = con2.getConnection().prepareStatement(sql3);
            psd.setString(1,newName);
            logger.info("Statement for DISCIPLINE MAP Prepared");
            //before deleting Teacher
            Savepoint savepoint1 = con1.getConnection().setSavepoint("TEACHER DELETING");
            int changedLines1 = removepst.executeUpdate();
            logger.info("TEACHER MAP Remove action executed");

            //before adding Teacher
            Savepoint savepoint2 = con1.getConnection().setSavepoint("TEACHER ADDING");
            int changedLines2 = addpst.executeUpdate();
            logger.info("TEACHER MAP Adding action executed");
            con1.getConnection().commit();
            logger.info("TEACHER MAP update commited");
            System.out.println("Changed lines TEACHER: "+"\n"+"line 1: "+changedLines1+"line 2: "+changedLines2);
            if(changedLines1==0||changedLines2==2){
                throw new TeacherNameChangeException("Exception: can not change TEACHER NAME in TEACHER MAP");
        }
            //before updating discipline
            Savepoint savepoint3 = con2.getConnection().setSavepoint("DISCIPLINE UPDATING");
            int changedLines3 = psd.executeUpdate();
            logger.info("DISCIPLINE MAP Statement executed");
            con2.getConnection().commit();
            logger.info("DISCIPLINE MAP update commited");
            System.out.println("Changed lines DISCIPLINE:"+changedLines3);
            if(changedLines3==0){
                throw new TeacherNameChangeException("Exception: can not change TEACHER NAME in DISCIPLINE MAP");
            }
        }
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage() + "SQLState: " + ex.getSQLState());
            logger.error(ex);
            con1.getConnection().rollback();
            logger.info("TEACHER MAP update rollback");
            con2.getConnection().rollback();
            logger.info("DISCIPLINE MAP update rollback");
        }finally {
            if(removepst!=null){
                try
                {
                removepst.close();
                logger.info("TEACHER MAP remove Statement closed");
                } catch (SQLException ex){
                    ex.printStackTrace();
                    logger.error(ex);
                }
            }
            if(addpst!=null){
                try
                {
                addpst.close();
                logger.info("TEACHER MAP adding Statement closed");
                } catch (SQLException ex){
                    ex.printStackTrace();
                    logger.error(ex);
                }
            }
            if (psd!=null){
                try
                {
                psd.close();
                logger.info("DISCIPLINE MAP prepared Statement closed");
                } catch (SQLException ex){
                    ex.printStackTrace();
                    logger.error(ex);
                }
            }
            pool.putback(con1);
            logger.info("Connection 1 returned to Connection Pool");
            pool.putback(con2);
            logger.info("Connection 2 returned to Connection Pool");
        }
    }
}
