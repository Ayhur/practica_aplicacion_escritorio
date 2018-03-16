package paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gestionHotel.Ventana;
import ventanas.VentanaPrincipal;


public class PanelCabeceraAplicacion extends JPanel implements ActionListener{
	
	private JPanel panelLogo, panelUsuario;
	private JLabel nom;
	private JButton logout,cerrar;
	private Image logo = null;
	
	public PanelCabeceraAplicacion(Connection con) {
		
		//propiedades PanelCAbecera
		this.setPreferredSize(new Dimension(1200, 150));
		this.setBackground(new java.awt.Color(238, 112, 30));
		this.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		
		//objetos
		
		//paneles
		panelLogo = new JPanel();
		panelUsuario = new JPanel();
		
		//propiedades de los paneles
		//panelo logo
		panelLogo.setBackground(new java.awt.Color(238, 112, 30));
		panelLogo.setPreferredSize(new Dimension(994, 150));
		panelLogo.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		//panel Usuario
		panelUsuario.setBackground(new java.awt.Color(238, 112, 30));
		panelUsuario.setPreferredSize(new Dimension(200, 150));
		panelUsuario.setLayout(new FlowLayout(FlowLayout.CENTER,40,10));
		
		//elementos agregados a panelLogo
		//logo = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
		try {
			logo = ImageIO.read(new File("imagenes/logo.png"));
		} catch (IOException e) {
			System.out.println("Error en la carga de la imagen logo");
		}
		
		//elementos agregados a panelUsuario
		nom = new JLabel ("aqui va usu");
		panelUsuario.add(nom);
		cerrar = new JButton("Cerrar session");		
		cerrar.addActionListener(this);
		panelUsuario.add(cerrar);
		
		this.add(panelLogo);
		this.add(panelUsuario);
		
		//this.getContentPane().add(panelSuperior);
		
		
		
		
		
		
		
		
	}//end constructor
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.green);
		g.drawImage(logo, 0, 0, 200, 150, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==cerrar){
			//x.dispose();
			VentanaPrincipal v = new VentanaPrincipal(connection);
			v.setVisible(true);
		}
		
	}

}
