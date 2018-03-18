package ventanasInternas;

import javax.swing.JInternalFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.aeat.valida.Validador;

import ddos.ClientesDAOImpl;
import ddos.ExtraerDiasEntreDosFechas;
import ddos.RegistroDAOImpl;
import ddos.ReservaDAOImpl;
import modelo.Cliente;
import modelo.Registro;
import modelo.Reserva;

public class VentanaInternaReserva extends JInternalFrame implements ActionListener{
	
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
	private Connection con;

	public VentanaInternaReserva(Connection conexion, String hab) throws SQLException {
		
		//Globalizacion de variables
		this.con = conexion;		
		habitacionSobrecargada = hab;
		
		//Instanciacion de Arrays
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

		this.setPreferredSize(new Dimension(1020, 660));
		this.setResizable(false);
		this.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		this.setBorder(null);
		this.setBackground(new java.awt.Color(212, 248, 249));
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
	}
	
	public void panelDerecho(){
		
		//propiedades para el panel ubicado en la derecha (contiene los elementos fecha)
		panel4 = new JPanel();
		panel4.setBackground(new Color(44, 212, 249));
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER,115, 11));
		panel4.setPreferredSize(new Dimension(510, 470));
		panel4.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		//horario/fecha de entrada
		model = new UtilDateModel();
		model.setSelected(true);
		
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		
		//horario/fecha de salida
		model2 = new UtilDateModel();
		model2.setSelected(true);
		
		Properties p2 = new Properties();
		p2.put("text.today", "Today");
		p2.put("text.month", "Month");
		p2.put("text.year", "Year");
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
		
		//agregacion de los elementos al panel(derecho)
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
				Tarj = new JRadioButton("TARJETA");
				Tarj.setBackground(new Color(212, 248, 249, 0));				
				Tarj.setBackground(new java.awt.Color(212, 248, 249)); //revisar
			
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
	
	public void crearLabIzqu(int i){
		PanelesGridIzquierdo[i] = new JPanel();
		PanelesGridIzquierdo[i].setBackground(new Color(254, 254, 254, 0));
		PanelesGridIzquierdo[i].setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 25));
		lab[i] = new JLabel(labels[i]);
		PanelesGridIzquierdo[i].add(lab[i]);
		panel2.add(PanelesGridIzquierdo[i]);
	}

	public void panelNorte() throws SQLException {
		
		//propiedades para el panel ubicado arriba (norte)
		panel1 = new JPanel();
		panel1.setBackground(new Color(212, 248, 249));		
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		panel1.setPreferredSize(new Dimension(1020, 75));
		panel1.setBorder(new EmptyBorder(25, 20, 20, 20));
		
		//agregacion del texto "Encabezado" de la ventana Reserva
		Font fuente = new Font("Calibri", 2, 18);
		titulo = new JLabel("FORMULARIO PARA RESERVAR");
		titulo.setFont(fuente);
		
		panel1.add(titulo);

		this.getContentPane().add(panel1);
	}

	public void panelSur(Connection connection) {
		
		//propiedades del panel Ubicado abajo (sur)
		panel3 = new JPanel();
		panel3.setBackground(new Color(212, 248, 249));		
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		panel3.setPreferredSize(new Dimension(1020, 115));
		panel3.setBorder(new EmptyBorder(5, 20, 20, 20));
		
		//agregacion del boton para la creacion del registro reserva
		Crear = new JButton("Crear reserva");
		Crear.addActionListener(this);
		panel3.add(Crear);
		this.getContentPane().add(panel3);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == Crear){
			
			boolean enc = true;			
			String sex = null;
			
			if(H.isSelected()){
				sex = "H";
			}else if(M.isSelected()){
				sex = "M";
			}
			
			/** FALTA IMPLEMENTAR LA OCUPACION EN LA BASE DE DATOS */
			int ocupacion = -1;
			if(Reser.isSelected()){
				ocupacion = 3;
			}else if(Reser.isSelected()){
				ocupacion = 2;			
			}
			
			int tipo = hallarTipo();
			enc =validarCajasTextoReserva(enc);
			
			/*si el encuentro es verdadero
			 * busco si ya existia el cliente
			 * sino lo encuentro lo registro en la base de datos
			 * y agrego la reserva a su dni
			 */
			
			if(enc == true){
				
				Cliente c = new Cliente (
						CajasDerechaGrid[2].getText(), CajasDerechaGrid[3].getText(),
						CajasDerechaGrid[4].getText(), CajasDerechaGrid[5].getText(),
						CajasDerechaGrid[7].getText(), sex);
				
				ClientesDAOImpl Cli = new ClientesDAOImpl(con);
				boolean existenCliente = Cli.validarClienteExiste(c.getDni());
				
				try {
					
					if(existenCliente){//si no existe el cliente en nuestra base de datos lo registramos
						Cli.registrarCliente(c);
					}
					
					String Fentrada = model.getYear()+"-"+(model.getMonth()+1+"-"+model.getDay());
					String Fsalida = model2.getYear()+"-"+(model2.getMonth()+1+"-"+model2.getDay());

					//Creamos el formato de fecha requerido en la base de datos
					Calendar c1 = Calendar.getInstance();
					String st = Integer.toString(c1.get(Calendar.YEAR))+"-"+Integer.toString(c1.get(Calendar.MONTH))+"-"+Integer.toString(c1.get(Calendar.DATE));
					
					//registramos el "producto"
					Reserva reserva = new Reserva(st, Fentrada, Fsalida, c.getDni(), tipo, Integer.parseInt(CajasDerechaGrid[0].getText()));
					ReservaDAOImpl rsv = new ReservaDAOImpl(con);
					rsv.registrarReserva(reserva);
					
					//transformo las fechas
					SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
					Date fechaEn = null;
					Date fechaSa = null;
					fechaEn = formatoDelTexto.parse(Fentrada);
					fechaSa = formatoDelTexto.parse(Fsalida);

					ExtraerDiasEntreDosFechas ex = new ExtraerDiasEntreDosFechas(fechaEn, fechaSa);	
					ex.ejecucion();					
					List<Date> listaEntreFechas = ex.getListaEntreFechas();
					
					//recorremos la lista de fechas y las vamos agregando una a una a la base de datos
					for (Date date : listaEntreFechas) {						
						String str = formatoDelTexto.format(date);
						Registro registro = new Registro(Integer.parseInt(CajasDerechaGrid[0].getText()), str);
						RegistroDAOImpl regDAO = new RegistroDAOImpl(con);
						regDAO.crearRegistroDeTodosLosDiasEntreUnRango(registro);
				    }	
					
					JOptionPane.showMessageDialog(null, "RESERVA REALIZADA CON EXITO");
					limpiarCampos();
					
				} catch (ParseException e1) {
					System.out.println("Error en la transformacion de fechas");
					e1.printStackTrace();
				}
			}else{
				JOptionPane.showMessageDialog(null, "NO SE PUDO REALIZAR LA RESERVA, REVISE LOS CAMPOS");
			}
		
		}
	}
	
	/*metodo para limpiar todos los campos una vez realizada la reserva con exito*/
	private void limpiarCampos() {
		
		for(int i=0; i<CajasDerechaGrid.length; i++){
			
			if(i==0){
				CajasDerechaGrid[i].setText("");
				CajasDerechaGrid[i].setEnabled(true);
			}else if(i==1){
				Reser.setEnabled(true);
				Ocupa.setEnabled(true);
				Reser.setSelected(false);
				Ocupa.setSelected(false);
			}else if(i==6){
				H.setEnabled(true);
				M.setEnabled(true);
				H.setSelected(false);
				M.setSelected(false);
			}else if(i==8){
				Met.setEnabled(true);
				Tarj.setEnabled(true);
				Met.setSelected(false);
				Tarj.setSelected(false);
			}else{
				CajasDerechaGrid[i].setText("");
			}			
		}			
	}
	
	/*metodo que retorna el tipo de forma de pago seleccionada por el usuario*/
	public int hallarTipo() {
		int tipo = -1;
		if(Met.isSelected()){
			tipo = 0;
		}else if(Tarj.isSelected()){
			tipo = 1;			
		}
		return tipo;
	}
	
	/*metodo para comprobar que las cajas de texto estan rellenas*/
	public boolean validarCajasTextoReserva(boolean enc) {
		
		String input = CajasDerechaGrid[2].getText().toUpperCase();
		Validador validador = new Validador(); //introducir la libreria para la validacion de Nif del estado
		int e2 = validador.checkNif(input);  
		 
		try {
			Statement stmt = con.createStatement();
			int valor;
			if(CajasDerechaGrid[0].getText().length()==0){
				valor = 0;
			}else{
				valor = Integer.parseInt(CajasDerechaGrid[0].getText());
			}
			
			ResultSet rs = stmt.executeQuery("select * from habitacion where id_habitacion = "+valor+" ");
			
			if(!rs.next()){
				enc = false;
				lab[0].setForeground(Color.red);
			}else{
				lab[0].setForeground(Color.black);
			}
				
			if(!Reser.isSelected()&&!Ocupa.isSelected()){
				enc = false;
				lab[1].setForeground(Color.red);
			}else{
				lab[1].setForeground(Color.black);
			}			
			
			if(e2 < 0){
				enc = false;
				lab[2].setForeground(Color.red);
			}else{
				lab[2].setForeground(Color.black);
			}
				
			if(!CajasDerechaGrid[3].getText().matches("[A-Z,a-z].*")){
				lab[3].setForeground(Color.red);
				enc=false;
			}else{
				lab[3].setForeground(Color.black);
			}
				
			if(!CajasDerechaGrid[4].getText().matches("[A-Z,a-z].*")){
				lab[4].setForeground(Color.red);
				enc = false;
			}else{
				lab[4].setForeground(Color.black);
			}				
				
			if(!CajasDerechaGrid[5].getText().matches("^6[0-9]{8}$")&&!CajasDerechaGrid[5].getText().matches("^9[0-9]{8}$")){
				lab[5].setForeground(Color.red);
				enc = false;
			}else{
				lab[5].setForeground(Color.black);
			}
			
			if(!H.isSelected()&&!M.isSelected()){
				lab[6].setForeground(Color.red);
				enc = false;
			}else{
				lab[6].setForeground(Color.black);
			}
				
			/*if(CajasDerechaGrid[7].getText().length()==0||CajasDerechaGrid[7].getText().matches("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
				enc = false;
				lab[7].setForeground(Color.red);
			}else{
				lab[7].setForeground(Color.black);
			}*/
			
			if(!Met.isSelected()&&!Tarj.isSelected()){
				enc = false;
				lab[8].setForeground(Color.red);
			}else{
				lab[8].setForeground(Color.black);
			}				
			
		} catch (SQLException e1) {
			System.out.println("ERROR en el metodo de validacion de campos RESERVA");
			e1.printStackTrace();
		}
		
		panel2.repaint();
		return enc;
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
