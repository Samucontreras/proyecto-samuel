package Codigo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class gestorEnergia {
    
    Statement consulta;
    Conexion c = new Conexion();
    
    
    public void altaEnergia(Energia e) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "insert into fuente_energia(nombre) values ('"+ e.getNombre() + "')";
        consulta.executeUpdate(cadena);
    }

    public Energia consultarEnergia(int codenergia) throws SQLException{
        Energia energia = new Energia();
        ResultSet rs=null;
            consulta = c.conectar().createStatement();
            String cadena = "select * from fuente_energia WHERE id='" + codenergia +"'";
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    energia.setId(rs.getInt("id"));
                    energia.setNombre(rs.getString("nombre"));
                }
                return energia;
    }
    
    public List<Energia> listarEnergias() throws SQLException {
        ResultSet rs = null;
        List<Energia> energias = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT * FROM fuente_energia";
            rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Energia energia = new Energia();
                energia.setId(rs.getInt("id"));
                energia.setNombre(rs.getString("nombre"));
                energias.add(energia);
            }
        return energias;
    }

private static int convertirANumero(String p) {
    try {
        return Integer.parseInt(p);
    } catch (NumberFormatException e) {
        return 0;
    }
}
    
    public List<Energia> listarEnergiasFiltrados( String filtro) throws SQLException {
        ResultSet rs = null;
        List<Energia> energias = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT * FROM fuente_energia WHERE "+"id = "+convertirANumero(filtro)+" OR nombre like '%"+filtro+"%'";
            rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Energia energia = new Energia();
                energia.setId(rs.getInt("id"));
                energia.setNombre(rs.getString("nombre"));
                energias.add(energia);
            }
        return energias;
    }
    
    public void modificarEnergia(Energia energia) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update fuente_energia set nombre='" + energia.getNombre() + "' where id='" + energia.getId() + "'";
        System.out.println(cadena);
        consulta.executeUpdate(cadena);
    }
        public void eliminarEnergia(int id) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "delete from fuente_energia where id="+ id +";";
        consulta.executeUpdate(cadena);
    }
    
}
