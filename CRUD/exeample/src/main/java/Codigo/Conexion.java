
package Codigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    String url = "jdbc:mysql://localhost:3306/listadeseos";
    String user = "root";
    String pass = "25012173";
    Connection c;
    
    
    public Connection conectar(){
        try {
            c = DriverManager.getConnection(url, user,pass);
            System.out.println("Conectado!!");
        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
        }
    return c;
 }
    
}
