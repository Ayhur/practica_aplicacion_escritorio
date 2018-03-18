package ddos;

public class ConstantesSQL {

	final static String sqlInsercionCliente = "INSERT INTO personas (`dni`, `nombre`,"
			+ " `apellidos`, `telefono`, `email`, `sexo`) " + "VALUES (?,?,?,?,?,?)";
	final static String sqlSeleccionCliente = "Select * FROM personas where dni like (?)";
	final static String sqlBorradoCliente = "DELETE from clientes where id = ?";
	final static String sqlInserccionReserva = "INSERT INTO reservas (fechaReserva,"
			+ " fechaEntrada, `fechaSalida`, `tipoPago`, `Nhabitacion`, `cliente`) "
			+ "VALUES (?,?,?,?,?,?)";
	final static String sqlInsercionRegistro = "insert into registros (Nhabitacion, fecha)"
			+ " values (?,?)";

}
