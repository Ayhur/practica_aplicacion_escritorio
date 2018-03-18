package ddos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

public class ExtraerDiasEntreDosFechas {

	private Date Fent;
	private Date Fsal;
	private java.util.List<Date> listaEntreFechas;

	public ExtraerDiasEntreDosFechas(Date fecha1, Date fecha2) {

		Fent = fecha1;
		Fsal = fecha2;

	}

	public void ejecucion() {
		// Instanciamos la clase Ejemplo
		ExtraerDiasEntreDosFechas ejm = new ExtraerDiasEntreDosFechas(Fent, Fsal);

		// Obtenemos la lista de fechas utilizando el método que está líneas más abajo
		listaEntreFechas = ejm.getListaEntreFechas(Fent, Fsal);
	}

	/**
	 * Método para obtener una lista con fechas en el intervalo indicado
	 * 
	 * @param fent2
	 *            Fecha inicial del intervalo
	 * @param fsal2
	 *            Fecha final del intervalo
	 * @return Fecha final
	 */
	public java.util.List<Date> getListaEntreFechas(Date fent2, Date fsal2) {
		// Convertimos la fecha a Calendar, mucho más cómodo para realizar
		// operaciones a las fechas

		Calendar c1 = Calendar.getInstance();
		c1.setTime(fent2);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(fsal2);

		// Lista donde se irán almacenando las fechas
		java.util.List<Date> listaFechas = new java.util.ArrayList<Date>();

		// Bucle para recorrer el intervalo, en cada paso se le suma un día.
		while (!c1.after(c2)) {
			listaFechas.add(c1.getTime());
			c1.add(Calendar.DAY_OF_MONTH, 1);
		}
		return listaFechas;
	}

	public Date getFent() {
		return Fent;
	}

	public void setFent(Date fent) {
		Fent = fent;
	}

	public Date getFsal() {
		return Fsal;
	}

	public void setFsal(Date fsal) {
		Fsal = fsal;
	}

	public java.util.List<Date> getListaEntreFechas() {
		return listaEntreFechas;
	}

	public void setListaEntreFechas(java.util.List<Date> listaEntreFechas) {
		this.listaEntreFechas = listaEntreFechas;
	}
}
