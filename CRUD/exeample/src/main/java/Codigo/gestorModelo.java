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
 * @author DAM & DAW
 */
public class gestorModelo {
    
    Statement consulta;
    Conexion c = new Conexion();
    
    
    public void altaModelo(Modelo m) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "insert into modelo(nombre,marca_id,tipo_coche_id,fuente_energia_id) values ('" + m.getNombre() + "', " + m.getMarcaId() + ", " + m.getTipoCocheId() + ", " + m.getFuenteEnergiaId() + ");";
        System.out.println(cadena);
        consulta.executeUpdate(cadena);
    }

    public Modelo consultarModelo(int codmodelo) throws SQLException{
        Modelo modelo = new Modelo();
        ResultSet rs=null;
            consulta = c.conectar().createStatement();
            String cadena = "select * from modelo WHERE id='" + codmodelo +"'";
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    modelo.setId(rs.getInt("id"));
                    modelo.setNombre(rs.getString("nombre"));
                }
                return modelo;
    }
    
    public List<Modelo> listarModelos() throws SQLException {
        ResultSet rs = null;
        List<Modelo> modelos = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT m.id, m.nombre AS modelo, mc.nombre AS marca, tc.tipo AS tipo_coche, fe.nombre AS fuente_energia, marca_id, tipo_coche_id, fuente_energia_id "
                    + "FROM modelo AS m JOIN marca AS mc ON m.marca_id = mc.id JOIN tipo_coche AS tc ON m.tipo_coche_id = tc.id "
                    + "JOIN fuente_energia AS fe ON m.fuente_energia_id = fe.id"
                    + "; ";
            rs = consulta.executeQuery(cadena);
            //System.out.println(cadena);
            while (rs.next()) {
                Modelo modelo = new Modelo();
                modelo.setId(rs.getInt("id"));
                modelo.setNombre(rs.getString("modelo"));
                modelo.setMarcaId(rs.getInt("marca_id"));
                modelo.setMarca(rs.getString("marca"));
                modelo.setTipoCocheId(rs.getInt("tipo_coche_id"));
                modelo.setTipoCoche(rs.getString("tipo_coche"));
                modelo.setFuenteEnergiaId(rs.getInt("fuente_energia_id"));
                modelo.setFuenteEnergia(rs.getString("fuente_energia"));
                modelos.add(modelo);
            }
        return modelos;
    }

private static int convertirANumero(String p) {
    try {
        return Integer.parseInt(p);
    } catch (NumberFormatException e) {
        return 0;
    }
}
    
    public List<Modelo> listarModelosFiltrados( String filtro) throws SQLException {
        ResultSet rs = null;
        List<Modelo> modelos = new ArrayList<>();
            consulta = c.conectar().createStatement();
            System.out.println("el filtro es : "+filtro);
            String cadena = "SELECT m.id, m.nombre AS modelo, mc.nombre AS marca, tc.tipo AS tipo_coche, fe.nombre AS fuente_energia, marca_id, tipo_coche_id, fuente_energia_id "
                    + "FROM modelo AS m JOIN marca AS mc ON m.marca_id = mc.id JOIN tipo_coche AS tc ON m.tipo_coche_id = tc.id "
                    + "JOIN fuente_energia AS fe ON m.fuente_energia_id = fe.id  "
                    + "WHERE "
                    + "(mc.nombre like '%"+filtro+"%'"
                    + "); ";
            System.out.println(cadena);
            rs = consulta.executeQuery(cadena);
            //System.out.println(cadena);
            while (rs.next()) {
                Modelo modelo = new Modelo();
                modelo.setId(rs.getInt("id"));
                modelo.setNombre(rs.getString("modelo"));
                modelo.setMarcaId(rs.getInt("marca_id"));
                modelo.setMarca(rs.getString("marca"));
                modelo.setTipoCocheId(rs.getInt("tipo_coche_id"));
                modelo.setTipoCoche(rs.getString("tipo_coche"));
                modelo.setFuenteEnergiaId(rs.getInt("fuente_energia_id"));
                modelo.setFuenteEnergia(rs.getString("fuente_energia"));
                modelos.add(modelo);
            }
        return modelos;
    }
    
    public void modificarModelo(Modelo modelo) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update modelo set nombre='" + modelo.getNombre() + "' where id='" + modelo.getId() + "'";
        System.out.println(cadena);
        consulta.executeUpdate(cadena);
    }
        public void eliminarModelo(int id) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "delete from modelo where id="+ id +";";
        consulta.executeUpdate(cadena);
    }
    
}
