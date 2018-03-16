package modelo;

import java.sql.Date;

public class Cliente {

	private String dni, nombre, apellidos, telefono, domicilio, email, pais, sexo;
	private Date fechaNacimiento;

	public Cliente() {

	}

	public Cliente(String dni, String nombre, String apellidos, String telefono, String domicilio, String email,
			String pais, String sexo, Date fechaNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.email = email;
		this.pais = pais;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
	}
	

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ ", domicilio=" + domicilio + ", email=" + email + ", pais=" + pais + ", sexo=" + sexo
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	

}
