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

import ventanas.VentanaPrincipal;


public class PanelCabeceraAplicacion extends JPanel implements ActionListener{
	
	private JPanel panelLogo, panelUsuario;
	private JLabel nom;
	private JButton cerrar;
	private Image logo = null;
	private Connection con;
	private VentanaPrincipal v;
	
	public PanelCabeceraAplicacion(Connection con, VentanaPrincipal v) {
		
		//extraccion de Conexion y Ventana Principal para globalizar las variables
		this.con = con;
		this.v = v;
		
		//propiedades PanelCAbecera
		propiedadesPanelCabecera();
		
		//objetos
		
		//paneles instanciados (revisar)
		panelLogo = new JPanel();
		panelUsuario = new JPanel();
		
		//propiedades de los paneles
		//panelo logo
		panelLogoEmpresa();
		
		//elementos agregados a panelUsuario
		panelInfoUsuario();
		
		//agregacion de los paneles logo y usuario
		this.add(panelLogo);
		this.add(panelUsuario);
		
	}//end constructor

	public void panelInfoUsuario() {
		nom = new JLabel ("aqui va usu");
		panelUsuario.add(nom);
		cerrar = new JButton("Cerrar session");		
		cerrar.addActionListener(this);
		panelUsuario.add(cerrar);
	}

	public void panelLogoEmpresa() {
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
	}

	public void propiedadesPanelCabecera() {
		this.setPreferredSize(new Dimension(1200, 150));
		this.setBackground(new java.awt.Color(238, 112, 30));
		this.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.green);
		g.drawImage(logo, 0, 0, 200, 150, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==cerrar){
			v.dispose();
			VentanaPrincipal v = new VentanaPrincipal(con);
			v.setVisible(true);
		}
	}
}
