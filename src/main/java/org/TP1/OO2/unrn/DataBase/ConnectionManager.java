package org.TP1.OO2.unrn.DataBase;

import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectionManager {
    private static String DRIVER = "com.mysql.jdbc.Driver"; //driver para mysql
    private static String URL_DB = "jdbc:mysql://localhost:3306/";// cadena de conexion
    protected static String DB = "tp2oo2";//nombre de la base de datos
    protected static String user = "root";
    protected static String pass = "";
    protected static Connection conn = null;// variable para conectarse
    protected static Properties propiedades = null;
    static String FALLO_OBTENCION_PROPIEDADES = "Ocurrio un error al obtener las propiedades";
    static String ERROR_AL_CONECTAR_DB = "Ocurrio un error al conectar con la base de datos";


    private static Properties getPropiedades() throws RuntimeException {

        Properties prop = new Properties();

        try {
            ResourceBundle infoDB = ResourceBundle.getBundle("database");

            prop.setProperty("Url", infoDB.getString("db.url"));
            prop.setProperty("DataBaseName", infoDB.getString("db.data_base"));
            prop.setProperty("Usuario", infoDB.getString("db.user"));
            prop.setProperty("Password", infoDB.getString("db.password"));

        }catch (RuntimeException e){

            throw new RuntimeException(FALLO_OBTENCION_PROPIEDADES);
        }

        return prop;
    }


    public static void connect() throws SQLException {
        try {

            propiedades = getPropiedades();// pasamos url, usuario y contraseña
            conn = DriverManager.getConnection(
                    propiedades.getProperty("Url") + propiedades.getProperty("DataBaseName"),
                    propiedades.getProperty("Usuario"),
                    propiedades.getProperty("Password")
            );

        } catch (SQLException sqlEx) {
            System.out.println("Error al cargar el driver");
            String mensajeError = "No se ha podido conectar a " + propiedades.getProperty("Url") + propiedades.getProperty("DataBaseName") + ". " + sqlEx.getMessage();
            throw new SQLException(ERROR_AL_CONECTAR_DB);

        }
    }

    public static void disconnect()throws SQLException {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                throw new SQLException(ERROR_AL_CONECTAR_DB);

            }
        }
    }

    public static void reconnect() throws SQLException {
        disconnect();
        connect();
    }

    public static Connection getConnection() throws SQLException {
        if (conn == null) {
            connect();
        }
        return conn;
    }
}
