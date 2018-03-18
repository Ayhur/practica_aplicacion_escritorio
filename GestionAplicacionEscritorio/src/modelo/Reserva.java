package modelo;

public class Reserva {

	private String fech_Reserva, fech_Entrada, fech_Salida, dniCliente;
	private int tipoPago, Nhabitacion;

	public Reserva(String fech_Reserva, String fech_Entrada, String fech_Salida, String dniCliente, int tipoPago,
			int nhabitacion) {
		super();
		this.fech_Reserva = fech_Reserva;
		this.fech_Entrada = fech_Entrada;
		this.fech_Salida = fech_Salida;
		this.dniCliente = dniCliente;
		this.tipoPago = tipoPago;
		Nhabitacion = nhabitacion;
	}

	@Override
	public String toString() {
		return "Reserva [fech_Reserva=" + fech_Reserva + ", fech_Entrada=" + fech_Entrada + ", fech_Salida="
				+ fech_Salida + ", dniCliente=" + dniCliente + ", tipoPago=" + tipoPago + ", Nhabitacion=" + Nhabitacion
				+ "]";
	}

	public String getFech_Reserva() {
		return fech_Reserva;
	}

	public void setFech_Reserva(String fech_Reserva) {
		this.fech_Reserva = fech_Reserva;
	}

	public String getFech_Entrada() {
		return fech_Entrada;
	}

	public void setFech_Entrada(String fech_Entrada) {
		this.fech_Entrada = fech_Entrada;
	}

	public String getFech_Salida() {
		return fech_Salida;
	}

	public void setFech_Salida(String fech_Salida) {
		this.fech_Salida = fech_Salida;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public int getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(int tipoPago) {
		this.tipoPago = tipoPago;
	}

	public int getNhabitacion() {
		return Nhabitacion;
	}

	public void setNhabitacion(int nhabitacion) {
		Nhabitacion = nhabitacion;
	}

}
