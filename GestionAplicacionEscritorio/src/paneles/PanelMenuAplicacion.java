package paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ventanas.VentanaPrincipal;
import ventanasInternas.VentanaInternaReserva;

public class PanelMenuAplicacion extends JPanel implements ActionListener {

	private JButton reserva, disponibilidad, liberar, empleado, modificar, bajaEMpl;
	private Connection con;
	private PanelGestion pg;
	private VentanaPrincipal v;

	public PanelMenuAplicacion(Connection con, PanelGestion panelGestion, VentanaPrincipal v) {

		// global vars
		this.con = con;
		this.pg = panelGestion;
		this.v = v;

		// propiedades de panel menu
		propiedadesPanelMenu();

		// elementos(botones)
		crearBotonesMenu();

		// instanciacion las escuchas de los botones
		escuchasDeBotonesMenu();

		// propidades para los botones (estilos)
		estilosYPropiedadesDeLosBotones();

		// agregacion de los botones al panel
		this.add(reserva);
		this.add(disponibilidad);
		this.add(liberar);
		this.add(empleado);
		this.add(modificar);
		this.add(bajaEMpl);
	}

	public void estilosYPropiedadesDeLosBotones() {
		reserva.setBackground(java.awt.Color.yellow);
		reserva.setOpaque(false);
		reserva.setContentAreaFilled(false);
		reserva.setBorderPainted(false);
		reserva.setFocusPainted(false);
		disponibilidad.setBackground(java.awt.Color.yellow);
		disponibilidad.setBackground(java.awt.Color.yellow);
		disponibilidad.setOpaque(false);
		disponibilidad.setContentAreaFilled(false);
		disponibilidad.setBorderPainted(false);
		disponibilidad.setFocusPainted(false);
		liberar.setBackground(java.awt.Color.yellow);
		liberar.setBackground(java.awt.Color.yellow);
		liberar.setOpaque(false);
		liberar.setContentAreaFilled(false);
		liberar.setBorderPainted(false);
		liberar.setFocusPainted(false);
		empleado.setBackground(java.awt.Color.yellow);
		empleado.setBackground(java.awt.Color.yellow);
		empleado.setOpaque(false);
		empleado.setContentAreaFilled(false);
		empleado.setBorderPainted(false);
		empleado.setFocusPainted(false);
		modificar.setBackground(java.awt.Color.yellow);
		modificar.setBackground(java.awt.Color.yellow);
		modificar.setOpaque(false);
		modificar.setContentAreaFilled(false);
		modificar.setBorderPainted(false);
		modificar.setFocusPainted(false);
		bajaEMpl.setBackground(java.awt.Color.yellow);
		bajaEMpl.setOpaque(false);
		bajaEMpl.setContentAreaFilled(false);
		bajaEMpl.setBorderPainted(false);
		bajaEMpl.setFocusPainted(false);

		reserva.setForeground(Color.WHITE);
		disponibilidad.setForeground(Color.WHITE);
		liberar.setForeground(Color.WHITE);
		empleado.setForeground(Color.WHITE);
		modificar.setForeground(Color.WHITE);
		bajaEMpl.setForeground(Color.WHITE);
	}

	public void escuchasDeBotonesMenu() {
		empleado.addActionListener(this);
		reserva.addActionListener(this);
		disponibilidad.addActionListener(this);
		modificar.addActionListener(this);
		liberar.addActionListener(this);
		bajaEMpl.addActionListener(this);
	}

	public void propiedadesPanelMenu() {
		this.setBackground(new java.awt.Color(0, 0, 0));
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 50));
		this.setPreferredSize(new Dimension(180, 800));
	}

	public void crearBotonesMenu() {
		reserva = new JButton("RESERVA");
		disponibilidad = new JButton("DISPONIBILIDAD");
		liberar = new JButton("LIBERAR");
		empleado = new JButton("DAR DE ALTA EMPL.");
		modificar = new JButton("CANCELAR RESERVA");
		bajaEMpl = new JButton("DAR DE BAJA EMPL.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == reserva) {
			try {
				VentanaInternaReserva re = new VentanaInternaReserva(con, null);
				pg.getpMatriz().add(re);
				re.setVisible(true);
				
			} catch (SQLException e1) {
				System.out.println("Error en la escucha al cargar el modulo de RESERVA");
				e1.printStackTrace();
			}
		}
	}
}
