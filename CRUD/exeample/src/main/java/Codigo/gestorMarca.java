/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samue
 */
public class gestorMarca {
    
    Statement consulta;
    Conexion c = new Conexion();
    
    
    public void altaMarca(Marca m) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "insert into marca(nombre) values ('"+ m.getNombre() + "')";
        consulta.executeUpdate(cadena);
    }

    public Marca consultarMarca(int codmarca) throws SQLException{
        Marca marca = new Marca();
        ResultSet rs=null;
            consulta = c.conectar().createStatement();
            String cadena = "select * from marca WHERE id='" + codmarca +"'";
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    marca.setId(rs.getInt("id"));
                    marca.setNombre(rs.getString("nombre"));
                }
                return marca;
    }
    
    public List<Marca> listarMarcas() throws SQLException {
        ResultSet rs = null;
        List<Marca> marcas = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT * FROM marca";
            rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Marca marca = new Marca();
                marca.setId(rs.getInt("id"));
                marca.setNombre(rs.getString("nombre"));
                marcas.add(marca);
            }
        return marcas;
    }

private static int convertirANumero(String p) {
    try {
        return Integer.parseInt(p);
    } catch (NumberFormatException e) {
        return 0;
    }
}
    
    public List<Marca> listarMarcasFiltrados( String filtro) throws SQLException {
        ResultSet rs = null;
        List<Marca> marcas = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT * FROM marca WHERE "+"id = "+convertirANumero(filtro)+" OR nombre like '%"+filtro+"%'";
            rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Marca marca = new Marca();
                marca.setId(rs.getInt("id"));
                marca.setNombre(rs.getString("nombre"));
                marcas.add(marca);
            }
        return marcas;
    }
    
    public void modificarMarca(Marca marca) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update marca set nombre='" + marca.getNombre() + "' where id='" + marca.getId() + "'";
        System.out.println(cadena);
        consulta.executeUpdate(cadena);
    }
        public void eliminarMarca(int id) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "delete from marca where id="+ id +";";
        consulta.executeUpdate(cadena);
    }

}
