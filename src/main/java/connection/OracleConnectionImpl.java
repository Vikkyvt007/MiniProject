package connection;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class OracleConnectionImpl  implements  ConnectionI{
    Connection connection;
    Logger logger = LogManager.getLogger(OracleConnectionImpl.class);
    FileReader reader= null;
    @Override
    public Connection createConnection() throws IOException {
        try {
            BasicConfigurator.configure();
           reader=new FileReader("src/db.properties");

            Properties p=new Properties();
            p.load(reader);

            String url =p.getProperty("ORACLE_URL");
            String user = p.getProperty("ORACLE_USER1");
            String pass= p.getProperty("ORACLE_USER1_PASS");

            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver()); //Registering// Oracle Driver
            System.out.println("driver loaded");
            logger.info("driver loaded");

           // connection = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:orcl", "sh", "sh");


                connection = DriverManager.getConnection(url, user , pass);
                if(connection!= null)
                    logger.info("database connected");


            } catch (SQLException | FileNotFoundException e) {
                   logger.warn(e.getStackTrace());
                System.out.println(e.getMessage());
            }

        return connection;
    }
}
// this code is implemented by vikrant on 16/04/2021