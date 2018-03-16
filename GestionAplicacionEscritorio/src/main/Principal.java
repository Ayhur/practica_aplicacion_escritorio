package main;

import conexiones.ConexionBD;
import ventanas.VentanaPrincipal;

public class Principal {
	
	 public static void main(String[] args) {
		
		 /*
		  * en la cual se gestionen informacion sobre clientes y el producto,
		  * el producto sera por del negocio a elegir
		  * deberá tener al menos 7 campos
		  * y deberá estar almacenado en una tabla de base de datos
		  * 
		  * 
		  * la gestion debera permitir:
		  * 	*gestionar
		  * 	*listar
		  * 	*editar
		  * 	*borrar
		  * 
		  * ...las informaciones
		  * 
		  * opcionales:
		  * 
		  * *usar 3 campos de entrada no enseñados en clase para el producto a elegir
		  * p. ej: checkbox, combobox, lista desplegable.
		  * 
		  * intentar realizar un listado de informaciones en los paneles de listado
		  * 
		  * 
		  * */
		 ConexionBD bd = new ConexionBD();
		 VentanaPrincipal v = new VentanaPrincipal(bd.getCon());
		 
		 /* 
		  * 
		  * 
		  * ****/
		 
	}

}
