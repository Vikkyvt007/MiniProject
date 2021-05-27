package connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;



import com.mchange.v2.c3p0.ComboPooledDataSource;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



    public class OraclePoolConnectionImpl implements  ConnectionI{
        Connection con = null ;
        ComboPooledDataSource comboPooledDataSource = null;
        Logger logger = LogManager.getLogger(OraclePoolConnectionImpl.class);
        FileReader reader = null;

        @Override
        public Connection createConnection() throws IOException {
            try {

                 reader=new FileReader("src/db.properties");
                Properties p=new Properties();
                p.load(reader);
                comboPooledDataSource = new ComboPooledDataSource();
                String url =p.getProperty("ORACLE_URL");
                String user = p.getProperty("ORACLE_USER1");
                String pass= p.getProperty("ORACLE_USER1_PASS");

                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver()); //Registering// Oracle Driver
           //     System.out.println("driver loaded");
                logger.info("driver loaded");
                comboPooledDataSource = new ComboPooledDataSource();

                comboPooledDataSource.setJdbcUrl(url);
                comboPooledDataSource.setUser(user);
                comboPooledDataSource.setPassword(pass);

                comboPooledDataSource.setMinPoolSize(3);
                comboPooledDataSource.setAcquireIncrement(3);
                comboPooledDataSource.setMaxPoolSize(30);

                con= comboPooledDataSource.getConnection();


            }
            catch(Exception e)
            {
                logger.warn(e.getStackTrace());
            }
            finally
            {
                if(reader != null)
                    reader.close();
            }
            return con;
        }
    }
// this code is implemented by Vikrant Tiwari on 16/04/2021
