package ddos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Registro;

public class RegistroDAOImpl implements RegistroDAO {

	private Connection con;

	public RegistroDAOImpl(Connection con) {
		this.con = con;
	}

	@Override
	public void crearRegistroDeTodosLosDiasEntreUnRango(Registro r) {

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(ConstantesSQL.sqlInsercionRegistro);
			ps.setInt(1, r.getNhabitacion());
			ps.setString(2, r.getFecha());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error al introducir los datos de Registro en la base de datos");
			e.printStackTrace();
		}

	}

}
