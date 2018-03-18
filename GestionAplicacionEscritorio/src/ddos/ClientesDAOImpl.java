package ddos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Cliente;

public class ClientesDAOImpl implements ClientesDAO {

	
	private Connection con;
	
	
	public ClientesDAOImpl(Connection con) {
		this.con = con;
	}

	@Override
	public void registrarCliente(Cliente c) {
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(ConstantesSQL.sqlInsercionCliente);
			ps.setString(1, c.getDni());
			ps.setString(2, c.getNombre());
			ps.setString(3, c.getApellidos());
			ps.setString(4, c.getTelefono());
			ps.setString(5, c.getEmail());
			ps.setString(6, c.getSexo());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("error al registrar el cliente");
		}
		System.out.println("cliente añadido");
		
	}

	@Override
	public Boolean validarClienteExiste(String dni) {
		
		boolean encontrado = false;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(ConstantesSQL.sqlSeleccionCliente);
			ps.setString(1, dni);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){//si se encuentra al cliente true, y sino false
				ps.close();
				return true;
			}else{
				ps.close();
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Error al validad si el cliente existe");
			e.printStackTrace();
		}
		return encontrado;
	}
}