package modelo;

import java.sql.Date;

public class Registro {

	private int Nhabitacion;
	private String fecha;

	public Registro(int nhabitacion, String fecha) {
		super();
		Nhabitacion = nhabitacion;
		this.fecha = fecha;
	}

	public int getNhabitacion() {
		return Nhabitacion;
	}

	public void setNhabitacion(int nhabitacion) {
		Nhabitacion = nhabitacion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
