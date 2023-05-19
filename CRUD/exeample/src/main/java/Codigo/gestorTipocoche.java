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
public class gestorTipocoche {
    
    Statement consulta;
    Conexion c = new Conexion();
    
    
    public void altaTipocoche(Tipocoche m) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "insert into tipo_coche(tipo) values ('"+ m.getTipo() + "')";
        consulta.executeUpdate(cadena);
    }

    public Tipocoche consultarTipocoche(int codtipocoche) throws SQLException{
        Tipocoche tipocoche = new Tipocoche();
        ResultSet rs=null;
            consulta = c.conectar().createStatement();
            String cadena = "select * from tipo_coche WHERE id='" + codtipocoche +"'";
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    tipocoche.setId(rs.getInt("id"));
                    tipocoche.setTipo(rs.getString("tipo"));
                }
                return tipocoche;
    }
    
    public List<Tipocoche> listarTipocoches() throws SQLException {
        ResultSet rs = null;
        List<Tipocoche> tipocoches = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT * FROM tipo_coche";
            rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Tipocoche tipocoche = new Tipocoche();
                tipocoche.setId(rs.getInt("id"));
                tipocoche.setTipo(rs.getString("tipo"));
                tipocoches.add(tipocoche);
            }
        return tipocoches;
    }

private static int convertirANumero(String p) {
    try {
        return Integer.parseInt(p);
    } catch (NumberFormatException e) {
        return 0;
    }
}
    
    public List<Tipocoche> listarTipocochesFiltrados( String filtro) throws SQLException {
        ResultSet rs = null;
        List<Tipocoche> tipocoches = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT * FROM tipo_coche WHERE "+"id = "+convertirANumero(filtro)+" OR tipo like '%"+filtro+"%'";
            rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Tipocoche tipocoche = new Tipocoche();
                tipocoche.setId(rs.getInt("id"));
                tipocoche.setTipo(rs.getString("tipo"));
                tipocoches.add(tipocoche);
            }
        return tipocoches;
    }
    
    public void modificarTipocoche(Tipocoche tipocoche) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update tipo_coche set tipo='" + tipocoche.getTipo() + "' where id='" + tipocoche.getId() + "'";
        System.out.println(cadena);
        consulta.executeUpdate(cadena);
    }
        public void eliminarTipocoche(int id) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "delete from tipo_coche where id="+ id +";";
        consulta.executeUpdate(cadena);
    }
    
}
