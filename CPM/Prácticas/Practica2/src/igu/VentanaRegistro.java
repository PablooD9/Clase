package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class VentanaRegistro extends JFrame {

	private JPanel panelPrincipal;
	private JLabel lbNombre;
	private JTextField txNombre;
	private JPanel panelSexo;
	private JRadioButton rbHombre;
	private JRadioButton rbMujer;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panelFecNac;
	private JComboBox <String> cbDias; //el <String> sirve para parametrizar el JComboBox, es decir, para
										//decirle que en el comboBox se le van a meter Strings.
	private JComboBox <String> cbMeses;
	private JComboBox <String> cbAños;
	private JPanel panelRegistro;
	private JLabel lbUsuario;
	private JLabel lbContraseña;
	private JLabel lbRepContraseña;
	private JTextField txUsuario;
	private JPasswordField psPassword;
	private JPasswordField psRepPassword;
	private JButton btCancelar;
	private JButton btSiguiente;
	private JLabel lbApellidos;
	private JTextField txApellidos;

	public final static String EMPTY= "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistro() {
		setTitle("Formulario de registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 429);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		panelPrincipal.add(getLbNombre());
		panelPrincipal.add(getTxNombre());
		panelPrincipal.add(getPanelSexo());
		panelPrincipal.add(getPanelFecNac());
		panelPrincipal.add(getPanelRegistro());
		panelPrincipal.add(getBtCancelar());
		panelPrincipal.add(getBtSiguiente());
		panelPrincipal.add(getLbApellidos());
		panelPrincipal.add(getTxApellidos());
	}

	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre:");
			lbNombre.setBounds(10, 32, 61, 14);
		}
		return lbNombre;
	}
	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setBounds(65, 29, 142, 20);
			txNombre.setColumns(10);
		}
		return txNombre;
	}
	private JPanel getPanelSexo() {
		if (panelSexo == null) {
			panelSexo = new JPanel();
			panelSexo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
			panelSexo.setBounds(27, 71, 177, 82);
			panelSexo.setLayout(null);
			panelSexo.add(getRbHombre());
			panelSexo.add(getRbMujer());
		}
		return panelSexo;
	}
	private JRadioButton getRbHombre() {
		if (rbHombre == null) {
			rbHombre = new JRadioButton("Hombre");
			rbHombre.setSelected(true);
			buttonGroup.add(rbHombre);
			rbHombre.setBounds(20, 19, 109, 23);
		}
		return rbHombre;
	}
	private JRadioButton getRbMujer() {
		if (rbMujer == null) {
			rbMujer = new JRadioButton("Mujer");
			buttonGroup.add(rbMujer);
			rbMujer.setBounds(20, 45, 109, 23);
		}
		return rbMujer;
	}
	private JPanel getPanelFecNac() {
		if (panelFecNac == null) {
			panelFecNac = new JPanel();
			panelFecNac.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Fecha de Nacimiento", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
			panelFecNac.setBounds(209, 71, 268, 82);
			panelFecNac.setLayout(null);
			panelFecNac.add(getCbDias());
			panelFecNac.add(getCbMeses());
			panelFecNac.add(getCbAños());
		}
		return panelFecNac;
	}
	private JComboBox<String> getCbDias() {
		if (cbDias == null) {
			cbDias = new JComboBox<String>();
			String[] cadena = new String[31];
			for (int i=0; i<31; i++){
				cadena[i]= (i+1)+"";
			}
			cbDias.setModel(new DefaultComboBoxModel(cadena));
			cbDias.setBounds(10, 35, 74, 20);
		}
		return cbDias;
	}
	private JComboBox<String> getCbMeses() {
		if (cbMeses == null) {
			cbMeses = new JComboBox<String>();
			cbMeses.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
			cbMeses.setBounds(94, 35, 74, 20);
		}
		return cbMeses;
	}
	private JComboBox<String> getCbAños() {
		if (cbAños == null) {
			cbAños = new JComboBox<String>();
			String[] cadena= new String[51];
			int m= 1950;
			for (int i=0; i<51; i++)
			{
				cadena[i]= m+"";
				m++;
			}
			cbAños.setModel(new DefaultComboBoxModel(cadena));
			cbAños.setBounds(178, 35, 80, 20);
		}
		return cbAños;
	}
	private JPanel getPanelRegistro() {
		if (panelRegistro == null) {
			panelRegistro = new JPanel();
			panelRegistro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de registro", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
			panelRegistro.setBounds(37, 163, 440, 157);
			panelRegistro.setLayout(null);
			panelRegistro.add(getLbUsuario());
			panelRegistro.add(getLbContraseña());
			panelRegistro.add(getLbRepContraseña());
			panelRegistro.add(getTxUsuario());
			panelRegistro.add(getPsPassword());
			panelRegistro.add(getPsRepPassword());
		}
		return panelRegistro;
	}
	private JLabel getLbUsuario() {
		if (lbUsuario == null) {
			lbUsuario = new JLabel("Usuario:");
			lbUsuario.setBounds(10, 30, 68, 14);
		}
		return lbUsuario;
	}
	private JLabel getLbContraseña() {
		if (lbContraseña == null) {
			lbContraseña = new JLabel("Contrase\u00F1a:");
			lbContraseña.setBounds(10, 72, 96, 14);
		}
		return lbContraseña;
	}
	private JLabel getLbRepContraseña() {
		if (lbRepContraseña == null) {
			lbRepContraseña = new JLabel("Repetir contrase\u00F1a:");
			lbRepContraseña.setBounds(10, 114, 112, 14);
		}
		return lbRepContraseña;
	}
	private JTextField getTxUsuario() {
		if (txUsuario == null) {
			txUsuario = new JTextField();
			txUsuario.setBounds(144, 30, 178, 20);
			txUsuario.setColumns(10);
		}
		return txUsuario;
	}
	private JPasswordField getPsPassword() {
		if (psPassword == null) {
			psPassword = new JPasswordField();
			psPassword.setBounds(144, 72, 178, 20);
		}
		return psPassword;
	}
	private JPasswordField getPsRepPassword()
	{
		if (psRepPassword == null)
		{
			psRepPassword = new JPasswordField();
			psRepPassword.setBounds(144, 114, 178, 20);
		}
		return psRepPassword;
	}
	private JButton getBtCancelar() 
	{
		if (btCancelar == null) 
		{
			btCancelar = new JButton("Cancelar");
			btCancelar.setMnemonic('L');
			btCancelar.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);
				}
			});
			btCancelar.setBounds(368, 345, 89, 23);
		}
		return btCancelar;
	}
	
	private JButton getBtSiguiente()
	{
		if (btSiguiente == null) 
		{
			btSiguiente = new JButton("Siguiente");
			btSiguiente.setMnemonic('T');
			btSiguiente.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					if (!checkTextField(getTxNombre()) || !checkTextField(getTxApellidos())
							|| !checkTextField(getTxUsuario()) 
								|| !checkPassField(getPsPassword())
									|| !checkPassField(getPsRepPassword()))
					{
						JOptionPane.showMessageDialog(null, "No deben de quedar campos de texto en blanco");
					}
					else if(!checkPasswords(getPsPassword(), getPsRepPassword()))
					{
						JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
					}
				}
			});
			btSiguiente.setBounds(234, 345, 89, 23);
		}
		return btSiguiente;
	}
	
	private boolean checkTextField(JTextField field)
	{
		String cadena;
		cadena= field.getText();
		if (cadena.isEmpty())
		{
			return false;
		}
		else
			return true;
	}
	
	private boolean checkPassField(JPasswordField field)
	{
		String cadena;
		cadena= String.valueOf(field.getPassword());
		if (cadena.isEmpty())
		{
			return false;
		}
		else
			return true;
	}
	
	private boolean checkPasswords(JPasswordField field1, JPasswordField field2)
	{
		String cadena1, cadena2;
		cadena1= String.valueOf(field1.getPassword());
		cadena2= String.valueOf(field2.getPassword());
		if (cadena1.equals(cadena2))
		{
			return true;
		}
		else return false;
	}
	
	private JLabel getLbApellidos() {
		if (lbApellidos == null) {
			lbApellidos = new JLabel("Apellidos:");
			lbApellidos.setBounds(214, 32, 79, 14);
		}
		return lbApellidos;
	}
	private JTextField getTxApellidos() {
		if (txApellidos == null) {
			txApellidos = new JTextField();
			txApellidos.setBounds(276, 29, 201, 20);
			txApellidos.setColumns(10);
		}
		return txApellidos;
	}
	
//	private void mostrarVentanaConfirmacion()
//	{
//		VentanaConfirmacion vCon= new VentanaConfirmacion(this);
//		vCon.setModal(true);
//		vCon.setLocationRelativeTo(this);
//		vCon.setVisible(true);
//	}
}
