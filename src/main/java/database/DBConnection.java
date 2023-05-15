package database;

import aquality.selenium.core.logging.Logger;
import utils.JsonUtils;
import utils.PathUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection{
    private static String path = PathUtils.getAbsolutePath("jdbcConnection.json");

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null){
            try {
                connection = DriverManager.getConnection(
                        JsonUtils.getStringData(FieldInJsonJDBC.URL.getUrl(), path),
                        JsonUtils.getStringData(FieldInJsonJDBC.USER_NAME.getUrl(), path),
                        JsonUtils.getStringData(FieldInJsonJDBC.PASSWORD.getUrl(), path));
            }
            catch (SQLException e) {
                Logger.getInstance().error("SQLException: " + e);
            }
        }
        return connection;
    }


    public static void setPath(String path) {
        DBConnection.path = path;
    }
}
