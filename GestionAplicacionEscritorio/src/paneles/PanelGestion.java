package paneles;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ventanas.VentanaPrincipal;

public class PanelGestion extends JPanel {

	private PanelMatrizAplicacion pMatriz = new PanelMatrizAplicacion();

	public PanelGestion(Connection con, VentanaPrincipal v) {

		// configuracion de las propiedades del panel Matriz
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		// this.setBackground(Color.GREEN);

		// agregacion de los paneles al panel gestion
		this.add(new PanelCabeceraAplicacion(con, v));
		this.add(new PanelMenuAplicacion(con,this,v));
		//this.add(pMatriz);
		this.add(pMatriz);
		//this.add(new PanelMatrizAplicacion()); borrar
	}

	public PanelMatrizAplicacion getpMatriz() {
		return pMatriz;
	}

	public void setpMatriz(PanelMatrizAplicacion pMatriz) {
		this.pMatriz = pMatriz;
	}

}

// el gridbaglayout para trabajar en casa y ver como usarlo
/*
 * this.setLayout(new GridBagLayout()); GridBagConstraints gbc = new
 * GridBagConstraints();
 * 
 * gbc.weightx = 2; gbc.gridy = 0; gbc.gridx = 0; this.add(pCabecera,gbc);
 * //caja texto user gbc.weightx = 1; gbc.gridy = 1; gbc.gridx = 0;
 * this.add(pMenu,gbc); //caja texto user gbc.gridx = 1; this.add(pMatriz,gbc);
 * //caja texto user
 */
