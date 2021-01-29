/*
 * Nama : Muhammad Fauzan Fadhlulbarr
 * Nim : 10119176
 * Kelas : IF10K
 */
package edu.muhammadfauzan.latihanmvcdjbc.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import edu.muhammadfauzan.latihanmvcdjbc.impl.PelangganDaoImpl;
import edu.muhammadfauzan.latihanmvcdjbc.service.PelangganDao;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Muhammad Fauzan FB
 */
public class KedaiOzanDatabase {
    
    private static Connection connection;
    private static PelangganDao pelangganDao;
    
    public static Connection getConnection() throws SQLException{
        if(connection==null){
            
            MysqlDataSource datasource = new MysqlDataSource();
            datasource.setURL("jdbc:mysql://localhost:3306/kedaiozan");
            datasource.setUser("root");
            datasource.setPassword("");
            connection = datasource.getConnection();
        }
        
        return connection;
    }
    
    public static PelangganDao getPelangganDao() throws SQLException{
        
        if (pelangganDao==null) {
            pelangganDao = new PelangganDaoImpl(getConnection());
        }
        return pelangganDao;
    }
    
}
