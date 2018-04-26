package dao;

import mySql_connector.ConnectionNotClosedException;

import java.sql.SQLException;

public class ProductDAOConnectionPoolTest {
    public static void main(String[] args) throws TeacherNameChangeException {
        ProductDAOConnectionPool productDAO = new ProductDAOConnectionPool();
        try {
            productDAO.changeTeachersName("IVANENKO IVAN","IVANOV IVAN", "INTERN");
        } catch (ConnectionNotClosedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
