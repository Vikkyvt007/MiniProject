package connection;

import java.io.IOException;
import java.sql.Connection;

public interface ConnectionI
{
    public Connection createConnection() throws IOException;

}
/* this code is edited by vikrant on 15/04/2021   */