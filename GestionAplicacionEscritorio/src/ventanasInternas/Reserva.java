package ventanasInternas;

import javax.swing.JInternalFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.UtilDateModel;

public class Reserva extends JInternalFrame{
	
	private JLabel titulo;//ent,sal; (meterlos directamente en el constructor del panel a agregar y quitarlos de aqui)
	private JTextField Nhabita;
	private JButton Crear;
	private JRadioButton H,M,Met,Tarj,Reser,Ocupa;
	private ButtonGroup grupo1,grupo2,grupo3;
	private JPanel panel1,panel2,panel3,panel4;
	private JPanel[] PanelesGridDerecho, PanelesGridIzquierdo;
	private JLabel[] lab;
	private String[] labels = { "Nº Habitación:", "Tipo de ocupacion", "DNI:", "Nombre:", "Apellidos:", "Telefono:", "Sexo:", "Email:","Tipo:"};
	private JTextField[] CajasDerechaGrid;
	private UtilDateModel model,model2;
	private String habitacionSobrecargada;

	public Reserva(Connection conexion, String hab) throws SQLException {
		
		habitacionSobrecargada = hab;
		
		PanelesGridIzquierdo = new JPanel[9];
		PanelesGridDerecho = new JPanel[9];
		CajasDerechaGrid = new JTextField[9];
		lab = new JLabel[9];		

		crearVentana();
		panelNorte();
		matriz(conexion);
		panelDerecho();
		panelSur(conexion);
	}
	
	public void crearVentana() {

		this.setPreferredSize(new Dimension(820, 560)); //(1020, 660)
		this.setResizable(false);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		this.setBorder(null);
		//this.setBackground(new java.awt.Color(212, 248, 249));
		this.setBackground(Color.yellow);//borrar
		((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);// anula

	}
	
	public void panelDerecho(){
		
		
		/*ent = new JLabel("FECHA DE ENTRADA");
		sal = new JLabel("FECHA DE SALIDA");	*/	
		
		panel4 = new JPanel();
		panel4.setBackground(new Color(44, 212, 249));
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER,115, 11));
		Dimension d1 = new Dimension(510, 470); //510
		panel4.setPreferredSize(d1);
		panel4.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		//horario de entrada
		model = new UtilDateModel();
		model.setSelected(true);
		
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		
		
		//horario de salida
		model2 = new UtilDateModel();
		model2.setSelected(true);
		
		Properties p2 = new Properties();
		p2.put("text.today", "Today");
		p2.put("text.month", "Month");
		p2.put("text.year", "Year");
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
		
		panel4.add(new JLabel("FECHA DE ENTRADA"));		
		panel4.add(datePanel);
		panel4.add(new JLabel("FECHA DE SALIDA"));
		panel4.add(datePanel2);
		
		this.getContentPane().add(panel4);
		
	}
	
	public void matriz(Connection connection){		
		
		panel2 = new JPanel();
		panel2.setBackground(new Color(212, 248, 249));
		panel2.setLayout(new GridLayout(9, 2));
		Dimension d1 = new Dimension(510, 470);//510
		panel2.setPreferredSize(d1);
		panel2.setBorder(new EmptyBorder(0, 20, 20, 20));
		boolean enc = false;

		for (int i = 0; i < PanelesGridDerecho.length&&enc==false; i++) {
			
			crearLabIzqu(i);
			
			PanelesGridDerecho[i] = new JPanel();
			PanelesGridDerecho[i].setBackground(new Color(254, 254, 254, 0));
			PanelesGridDerecho[i].setLayout(new FlowLayout(FlowLayout.LEFT, 0, 25));
			
			if(i==0){
				if(habitacionSobrecargada!=null&&Integer.parseInt(habitacionSobrecargada)>0){
									
					CajasDerechaGrid[i] = new JTextField(14);
					CajasDerechaGrid[i].setText(""+habitacionSobrecargada);
					CajasDerechaGrid[i].setEnabled(false);
					PanelesGridDerecho[i].add(CajasDerechaGrid[i]);
					panel2.add(PanelesGridDerecho[i]);
				}else{
					CajasDerechaGrid[i] = new JTextField(14);
					PanelesGridDerecho[i].add(CajasDerechaGrid[i]);
					panel2.add(PanelesGridDerecho[i]);
				}
							
			}else if(i == 1){				
				
				Reser = new JRadioButton("RESERVAR");
				Reser.setBackground(new Color(212, 248, 249, 0));				
				Reser.setBackground(new java.awt.Color(212, 248, 249));	
				
				Ocupa = new JRadioButton("OCUPAR");
				Ocupa.setBackground(new Color(212, 248, 249, 0));				
				Ocupa.setBackground(new java.awt.Color(212, 248, 249));
				
				grupo3 = new ButtonGroup();
				grupo3.add(Reser);
				grupo3.add(Ocupa);
				PanelesGridDerecho[i].add(Reser);
				PanelesGridDerecho[i].add(Ocupa);
				panel2.add(PanelesGridDerecho[i]);
				
			}else if (i == 6) {

				H = new JRadioButton("Hombre");
				H.setBackground(new Color(212, 248, 249, 0));				
				H.setBackground(new java.awt.Color(212, 248, 249));				
				M = new JRadioButton("Mujer");
				M.setBackground(new Color(212, 248, 249, 0));				
				M.setBackground(new java.awt.Color(212, 248, 249)); 
				grupo1 = new ButtonGroup();
				grupo1.add(H);
				grupo1.add(M);
				PanelesGridDerecho[i].add(H);
				PanelesGridDerecho[i].add(M);
				panel2.add(PanelesGridDerecho[i]);
				
			} else if(i == 8){				
				
				Met = new JRadioButton("METALICO");
				Met.setBackground(new Color(212, 248, 249, 0));				
				Met.setBackground(new java.awt.Color(212, 248, 249));	
				//Met.addActionListener(new escuchaAltaReserva(this, connection));
				Tarj = new JRadioButton("TARJETA");
				Tarj.setBackground(new Color(212, 248, 249, 0));				
				Tarj.setBackground(new java.awt.Color(212, 248, 249));
				//Tarj.addActionListener(new escuchaAltaReserva(this, connection));
			
				grupo2 = new ButtonGroup();
				grupo2.add(Met);
				grupo2.add(Tarj);
				PanelesGridDerecho[i].add(Met);
				PanelesGridDerecho[i].add(Tarj);
				panel2.add(PanelesGridDerecho[i]);
			
			} else {

				CajasDerechaGrid[i] = new JTextField(14);
				PanelesGridDerecho[i].add(CajasDerechaGrid[i]);
				panel2.add(PanelesGridDerecho[i]);
			}
		}
		this.getContentPane().add(panel2);
	}

	
	/*public JPanel panelfecha()
	{*/
		//Date fecha1=new Date(2014, 5, 2);
		/*UtilDateModel model = new UtilDateModel();
		model.setSelected(true);
		
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		
		JPanel jp1=new JPanel(new FlowLayout());*/
		
		
	
		
		/*JButton jbfecha=new JButton("datepickerjbuton");
		
		jbfecha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				System.out.println("El datepickerx es "+model.getDay());
				System.out.println("El datepickerx es "+model.getMonth());
				System.out.println("El datepickerx es "+model.getYear());
			}
		});
		
		JPanel p1=new JPanel(new GridLayout(2,1,10,10));
		JPanel fecha=new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel agregar=new JPanel(new FlowLayout(FlowLayout.CENTER));
		fecha.add(datePanel);
		agregar.add(jbfecha);
		p1.add(fecha);
		p1.add(agregar);
		return p1;*/
	//}
	
	
	
	public void crearLabIzqu(int i){
		PanelesGridIzquierdo[i] = new JPanel();
		PanelesGridIzquierdo[i].setBackground(new Color(254, 254, 254, 0));
		PanelesGridIzquierdo[i].setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 25));
		lab[i] = new JLabel(labels[i]);
		PanelesGridIzquierdo[i].add(lab[i]);
		panel2.add(PanelesGridIzquierdo[i]);
	}

	public void panelNorte() throws SQLException {

		panel1 = new JPanel();
		panel1.setBackground(new Color(212, 248, 249));		
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		Dimension d1 = new Dimension(1020, 75);
		panel1.setPreferredSize(d1);
		panel1.setBorder(new EmptyBorder(25, 20, 20, 20));

		Font fuente = new Font("Calibri", 2, 18);
		titulo = new JLabel("FORMULARIO PARA RESERVAR");
		titulo.setFont(fuente);

		panel1.add(titulo);

		this.getContentPane().add(panel1);
	}

	public void panelSur(Connection connection) {

		panel3 = new JPanel();
		panel3.setBackground(new Color(212, 248, 249));		
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		Dimension d1 = new Dimension(1020, 115);
		panel3.setPreferredSize(d1);
		panel3.setBorder(new EmptyBorder(5, 20, 20, 20));

		Crear = new JButton("Crear reserva");
		//Crear.addActionListener(new escuchaAltaReserva(this, connection));
		panel3.add(Crear);
		this.getContentPane().add(panel3);

	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public JTextField getNhabita() {
		return Nhabita;
	}

	public void setNhabita(JTextField nhabita) {
		Nhabita = nhabita;
	}

	public JButton getCrear() {
		return Crear;
	}

	public void setCrear(JButton crear) {
		Crear = crear;
	}

	public JRadioButton getH() {
		return H;
	}

	public void setH(JRadioButton h) {
		H = h;
	}

	public JRadioButton getM() {
		return M;
	}

	public void setM(JRadioButton m) {
		M = m;
	}

	public JRadioButton getMet() {
		return Met;
	}

	public void setMet(JRadioButton met) {
		Met = met;
	}

	public JRadioButton getTarj() {
		return Tarj;
	}

	public void setTarj(JRadioButton tarj) {
		Tarj = tarj;
	}

	public ButtonGroup getGrupo1() {
		return grupo1;
	}

	public void setGrupo1(ButtonGroup grupo1) {
		this.grupo1 = grupo1;
	}	
	
	/*public JLabel getEnt() {
		return ent;
	}

	public void setEnt(JLabel ent) {
		this.ent = ent;
	}

	public JLabel getSal() {
		return sal;
	}

	public void setSal(JLabel sal) {
		this.sal = sal;
	}*/

	public UtilDateModel getModel2() {
		return model2;
	}

	public void setModel2(UtilDateModel model2) {
		this.model2 = model2;
	}

	public String getHabitacionSobrecargada() {
		return habitacionSobrecargada;
	}

	public void setHabitacionSobrecargada(String habitacionSobrecargada) {
		this.habitacionSobrecargada = habitacionSobrecargada;
	}

	public ButtonGroup getGrupo2() {
		return grupo2;
	}

	public void setGrupo2(ButtonGroup grupo2) {
		this.grupo2 = grupo2;
	}

	public JPanel getPanel1() {
		return panel1;
	}

	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}

	public JPanel getPanel2() {
		return panel2;
	}

	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}

	public JPanel getPanel3() {
		return panel3;
	}

	public void setPanel3(JPanel panel3) {
		this.panel3 = panel3;
	}

	public JPanel[] getPanelesGridDerecho() {
		return PanelesGridDerecho;
	}

	public void setPanelesGridDerecho(JPanel[] panelesGridDerecho) {
		PanelesGridDerecho = panelesGridDerecho;
	}

	public JPanel[] getPanelesGridIzquierdo() {
		return PanelesGridIzquierdo;
	}

	public void setPanelesGridIzquierdo(JPanel[] panelesGridIzquierdo) {
		PanelesGridIzquierdo = panelesGridIzquierdo;
	}

	public JLabel[] getLab() {
		return lab;
	}

	public void setLab(JLabel[] lab) {
		this.lab = lab;
	}

	public String[] getLabels() {
		return labels;
	}

	public void setLabels(String[] labels) {
		this.labels = labels;
	}

	public JTextField[] getCajasDerechaGrid() {
		return CajasDerechaGrid;
	}

	public void setCajasDerechaGrid(JTextField[] cajasDerechaGrid) {
		CajasDerechaGrid = cajasDerechaGrid;
	}

	public JRadioButton getReser() {
		return Reser;
	}

	public void setReser(JRadioButton reser) {
		Reser = reser;
	}

	public JRadioButton getOcupa() {
		return Ocupa;
	}

	public void setOcupa(JRadioButton ocupa) {
		Ocupa = ocupa;
	}

	public ButtonGroup getGrupo3() {
		return grupo3;
	}

	public void setGrupo3(ButtonGroup grupo3) {
		this.grupo3 = grupo3;
	}

	public JPanel getPanel4() {
		return panel4;
	}

	public void setPanel4(JPanel panel4) {
		this.panel4 = panel4;
	}

	public UtilDateModel getModel() {
		return model;
	}

	public void setModel(UtilDateModel model) {
		this.model = model;
	}
}
