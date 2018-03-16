package ventanas;

import java.awt.BorderLayout;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;

import paneles.PanelLogin;

public class VentanaPrincipal extends JFrame{
	
	public VentanaPrincipal(Connection connection) {
		
		//instancio objeto panelLogin
		PanelLogin panelLogin = new PanelLogin(this, connection);
		
		//propiedades de la ventana principal
		this.setSize(800,650);
		this.setTitle("Gestion del Hotel Everis");
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		//this.setLayout(new BorderLayout());   no hace falta 
		
		//agregando panelLogin
		this.setContentPane(panelLogin);
		
		this.setVisible(true);
		
	}
}