package other;

import java.sql.*;
import java.util.Properties;

public class Draft {
    public static void main(String[] args) {
        //Draft#1
      /*  String url = "jdbc:mysql://localhost:3306/map?useSSL=false";
        Properties prop = new Properties();
        prop.put("user","root");
        prop.put("password","root");
        prop.put("autoReconnect","true");
        prop.put("characterEncoding","UTF-8");
        prop.put("useUnicode","true");
        Connection cn = null;
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        try {
            cn = DriverManager.getConnection(url,prop);
            Statement st = null;
            try{
                st = cn.createStatement();
                ResultSet rs = null;
                try{
                    rs = st.executeQuery("SELECT * FROM TEACHER");
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }*/
      //Draft#2
        /*/**
         * #1
         Loading class `com.mysql.jdbc.Driver'. This is deprecated.
         The new driver class is `com.mysql.cj.jdbc.Driver'.
         The driver is automatically registered via the SPI and
         manual loading of the driver class is generally unnecessary.
         Fri Apr 13 21:09:34 EEST 2018 WARN: Establishing SSL
         connection without server's identity verification is not recommended.
         According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements
         SSL connection must be established by default if explicit option isn't set.
         For compliance with existing applications not using SSL
         the verifyServerCertificate property is set to 'false'.
         You need either to explicitly disable SSL by setting useSSL=false,
         or set useSSL=true and provide truststore for server certificate verification.

         #2

         */
      /*  public class GetDBConnection {

            public static void main(String[] args) throws NoDriverClassLoadMySQLException {
                Connection connection;*/
                //old method of connection #1
       /* try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/map","root","root");
            System.out.println("ok");
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

                //old method of connection #2
       /* try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            throw new NoDriverClassLoadMySQLException();
        }
            }
        }*/

       //Draft#3
        /*public class LoadDriver {
            public static void main(String[] args) {
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/map?useSSL=false",
                            "root", "root");
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
        }*/


    }
}
