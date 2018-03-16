package paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import ventanas.VentanaPrincipal;

public class PanelLogin extends JPanel implements ActionListener{
	
	private JTextField user = new JTextField(15), pass = new JTextField(15);
	private JButton login = new JButton("Login"), salir = new JButton("Salir");
	private Connection con;
	private VentanaPrincipal v;
	

	public PanelLogin(VentanaPrincipal ventanaPrincipal, Connection connection) {
		
		//recuperamos conexion para usar como global en la clase
		v = ventanaPrincipal;
		con = connection;
		
		//creamos las escuchas de los botones
		login.addActionListener(this);
		salir.addActionListener(this);
		
		//damos distribucion al panel login
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		//primera fila de elementos (cada fila solo va a contener un elemento salvo la ultima que contendra dos
		gbc.gridwidth = 2; //le decimos que ocupe dos posiciones cada elemento
		gbc.gridy = 0;
		gbc.gridx = 0;
		this.add(new JLabel("Usuario: "),gbc); //label user
		gbc.gridy = 1;
		gbc.gridx = 0;
		this.add(user,gbc); //caja texto user
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(new JLabel("Contraseña"),gbc); // label pass
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(pass,gbc); // caja text pass
		gbc.gridy = 4;
		gbc.gridx = 0;
		gbc.gridwidth = 1; // le decimos que cada elemento ocupe 1 posicion
		this.add(login,gbc);// boton login
		gbc.gridx = 1;
		this.add(salir,gbc); // boton salir
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == login){  //entramos a comprobar que el usuario existe
			String sql = "SELECT * FROM empleados WHERE usuario like (?) and contraseña like (?)";
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, user.getText());
				ps.setString(2, pass.getText());
				ResultSet res = ps.executeQuery();  /*revienta aqui*/
				
				if(res.next()){
					PanelGestion pg = new PanelGestion(con,v);
					v.setContentPane(pg);
					v.setSize(1200,800);
					v.setLocationRelativeTo(null);
					SwingUtilities.updateComponentTreeUI(v);
					
				}else{
					JOptionPane.showMessageDialog(null, "Usuario o contraseña erroneo");
				}
				
				res.close();
				ps.close();
			} catch (SQLException e1) {
				System.out.println("error al preparar el statement");
			}
		}else if (e.getSource() == salir){
			System.exit(0);
		}
		
		
	}

}
