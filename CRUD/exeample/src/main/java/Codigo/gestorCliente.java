
package Codigo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class gestorCliente {
    Statement consulta;
    Conexion c = new Conexion();
    
    
    public void altaCliente(Cliente p) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "insert into cliente(nombre,apellido) values ('"+ p.getNombre() + "','"+p.getApellido()+ "')";
        consulta.executeUpdate(cadena);
    }

    public Cliente consultarUnCliente(int codcliente) throws SQLException{
        Cliente cliente = new Cliente();
        ResultSet rs=null;
            consulta = c.conectar().createStatement();
            String cadena = "select * from cliente WHERE id='" + codcliente +"'";
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    cliente.setId(rs.getInt("id"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setApellido(rs.getString("apellido"));
                    
                }
                return cliente;
    }
    
    public List<Cliente> listarClientes() throws SQLException {
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT * FROM cliente";
            rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                clientes.add(cliente);
            }
        return clientes;
    }

private static int convertirANumero(String p) {
    try {
        return Integer.parseInt(p);
    } catch (NumberFormatException e) {
        return 0;
    }
}
    
    public List<Cliente> listarClientesFiltrados( String filtro) throws SQLException {
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();
            consulta = c.conectar().createStatement();
            String cadena = "SELECT * FROM cliente WHERE "+"id = "+convertirANumero(filtro)+" OR nombre like '%"+filtro+"%'"+" OR "+"apellido like '%"+filtro+"%'";
            rs = consulta.executeQuery(cadena);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                clientes.add(cliente);
            }
        return clientes;
    }
    
    public void modificarCliente(Cliente cliente) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update cliente set nombre='"+cliente.getNombre()+"', apellido='"+cliente.getApellido()+"'"+" where id="+cliente.getId();
        System.out.println(cadena);
        consulta.executeUpdate(cadena);
    }
        public void eliminarCliente(int id) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "delete from cliente where id="+ id +";";
        consulta.executeUpdate(cadena);
    }
}
