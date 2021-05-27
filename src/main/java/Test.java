


import connection.ConnectionI;
import connection.OracleConnectionImpl;

import java.io.IOException;
import java.sql.*;

public class Test {

    public static void main(String[] args) throws SQLException, IOException {
        ConnectionI connectionI=new OracleConnectionImpl();
        Connection conn=connectionI.createConnection();
        System.out.println(conn);


    }



}