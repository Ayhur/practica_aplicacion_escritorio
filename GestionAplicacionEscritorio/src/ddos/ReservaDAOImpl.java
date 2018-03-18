package ddos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Reserva;

public class ReservaDAOImpl implements ReservaDAO {

	private Connection con;

	public ReservaDAOImpl(Connection con) {
		this.con = con;
	}

	@Override
	public void registrarReserva(Reserva r) {

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(ConstantesSQL.sqlInserccionReserva);
			ps.setString(1, r.getFech_Reserva());
			ps.setString(2, r.getFech_Entrada());
			ps.setString(3, r.getFech_Salida());
			ps.setInt(4, r.getTipoPago());
			ps.setInt(5, r.getNhabitacion());
			ps.setString(6, r.getDniCliente());

			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error al registrar LA RESERVA");
		}
		System.out.println("Reserva añadida");

	}

}
