package igu;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowListener;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar barraMenu;
	private JToolBar barraHerramientas;
	private JButton btNuevo;
	private JButton btGuardar;
	private JButton btAbrir;
	private JButton btImprimir;
	private JPanel barraEstado;
	private JPanel pnTextos;
	private JScrollPane scOriginal;
	private JScrollPane scTraducido;
	private JTextArea arOriginal;
	private JTextArea arTraducido;
	private JButton btEspa�ol;
	private JButton btFrances;
	private JButton btIngles;
	private JLabel etDocOriginal;
	private JLabel etIdOriginal;
	private JLabel etDocTraducido;
	private JLabel etIdTraducido;
	private JMenu menuArchivo;
	private JMenu menuEditar;
	private JMenu menuTraducir;
	private JMenu menuHerramientas;
	private JMenu menuAyuda;
	private JMenuItem itGuardarComo;
	private JMenuItem itNuevo;
	private JMenuItem itSalir;
	private ProcesaElFoco procesaFoco;

	
	private JMenuBar getBarraMenu() {
		if (barraMenu == null) {
			barraMenu = new JMenuBar();
			barraMenu.add(getMenuArchivo());
			barraMenu.add(getMenuEditar());
			barraMenu.add(getMenuTraducir());
			barraMenu.add(getMenuHerramientas());
			barraMenu.add(getMenuAyuda());
		}
		return barraMenu;
	}

	private JToolBar getBarraHerramientas() {
		if (barraHerramientas == null) {
			barraHerramientas = new JToolBar();
			barraHerramientas.setBackground(new java.awt.Color(208,204,204));
			barraHerramientas.add(getBtNuevo());
			barraHerramientas.add(getBtAbrir());
			barraHerramientas.add(getBtGuardar());
			barraHerramientas.add(getBtImprimir());
			barraHerramientas.add(getBtIngles());
			barraHerramientas.add(getBtEspa�ol());
			barraHerramientas.add(getBtFrances());
		}
		return barraHerramientas;
	}

	private JButton getBtNuevo() {
		if (btNuevo == null) {
			btNuevo = new JButton();
			btNuevo.setIcon(new ImageIcon("img/Nuevo.png"));
			btNuevo.setBorderPainted(false);
			btNuevo.setContentAreaFilled(false);
			btNuevo.setFocusPainted(false);
			btNuevo.setPreferredSize(new java.awt.Dimension(24,24));
			btNuevo.setMaximumSize(new java.awt.Dimension(24,24));
			btNuevo.setMinimumSize(new java.awt.Dimension(24,24));
			btNuevo.setMargin(new java.awt.Insets(0,0,0,0));
		}
		return btNuevo;
	}

	private JButton getBtGuardar() {
		if (btGuardar == null) {
			btGuardar = new JButton();
			btGuardar.setIcon(new ImageIcon("img/Guardar.png"));
			btGuardar.setBorderPainted(false);
			btGuardar.setContentAreaFilled(false);
			btGuardar.setPreferredSize(new java.awt.Dimension(24,24));
			btGuardar.setMaximumSize(new java.awt.Dimension(24,24));
			btGuardar.setMinimumSize(new java.awt.Dimension(24,24));
			btGuardar.setMargin(new java.awt.Insets(0,0,0,0));
		}
		return btGuardar;
	}

	private JButton getBtAbrir() {
		if (btAbrir == null) {
			btAbrir = new JButton();
			btAbrir.setIcon(new ImageIcon("img/Abrir.png"));
			btAbrir.setBorderPainted(false);
			btAbrir.setContentAreaFilled(false);
			btAbrir.setMaximumSize(new java.awt.Dimension(24,24));
			btAbrir.setMinimumSize(new java.awt.Dimension(24,24));
			btAbrir.setPreferredSize(new java.awt.Dimension(24,24));
			btAbrir.setMargin(new java.awt.Insets(0,0,0,0));
		}
		return btAbrir;
	}

	private JButton getBtImprimir() {
		if (btImprimir == null) {
			btImprimir = new JButton();
			btImprimir.setIcon(new ImageIcon("img/Imprimir.png"));
			btImprimir.setBorderPainted(false);
			btImprimir.setContentAreaFilled(false);
			btImprimir.setMaximumSize(new java.awt.Dimension(24,24));
			btImprimir.setMinimumSize(new java.awt.Dimension(24,24));
			btImprimir.setMargin(new java.awt.Insets(0,0,0,0));
		}
		return btImprimir;
	}

	private JPanel getBarraEstado() {
		if (barraEstado == null) {
			barraEstado = new JPanel();
			barraEstado.setLayout(new GridLayout(1, 4, 0, 0));
			barraEstado.add(getEtDocOriginal());
			barraEstado.add(getEtIdOriginal());
			barraEstado.add(getEtDocTraducido());
			barraEstado.add(getEtIdTraducido());
		}
		return barraEstado;
	}

	private JLabel getEtDocOriginal() {
		if (etDocOriginal == null){
			etDocOriginal = new JLabel();
			etDocOriginal.setText("Documento Original");
			etDocOriginal.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			etDocOriginal.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		}
		return etDocOriginal;
	}

	private JLabel getEtIdOriginal() {
		if (etIdOriginal == null){
			etIdOriginal = new JLabel();
			etIdOriginal.setText("Espa�ol");
			etIdOriginal.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			etIdOriginal.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		}
		return etIdOriginal;
	}

	private JLabel getEtDocTraducido() {
		if (etDocTraducido == null){
			etDocTraducido = new JLabel();
			etDocTraducido.setText("Documento traducido");
			etDocTraducido.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			etDocTraducido.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		}
		return etDocTraducido;
	}

	private JLabel getEtIdTraducido() {
		if (etIdTraducido == null){
			etIdTraducido = new JLabel();
			etIdTraducido.setText("Ingl�s");
			etIdTraducido.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			etIdTraducido.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
		}
		return etIdTraducido;
	}

	private JPanel getPnTextos() {
		if (pnTextos == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(2);
			gridLayout.setColumns(1);
			pnTextos = new JPanel();
			pnTextos.setLayout(gridLayout);
			pnTextos.add(getScOriginal(), null);
			pnTextos.add(getScTraducido(), null);
		}
		return pnTextos;
	}

	private JScrollPane getScOriginal() {
		if (scOriginal == null) {
			scOriginal = new JScrollPane();
			scOriginal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Documento Original", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12), new java.awt.Color(51,51,51)));
			scOriginal.setViewportView(getArOriginal());
		}
		return scOriginal;
	}

	private JScrollPane getScTraducido() {
		if (scTraducido == null) {
			scTraducido = new JScrollPane();
			scTraducido.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Documento Traducido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12), new java.awt.Color(51,51,51)));
			scTraducido.setViewportView(getArTraducido());
		}
		return scTraducido;
	}

	private JTextArea getArOriginal() {
		if (arOriginal == null) {
			arOriginal = new JTextArea();
			arOriginal.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			arOriginal.setWrapStyleWord(true);
			arOriginal.setBackground(java.awt.Color.lightGray);
			arOriginal.setLineWrap(true);
			arOriginal.addFocusListener(procesaFoco);
		}
		return arOriginal;
	}

	private JTextArea getArTraducido() {
		if (arTraducido == null) {
			arTraducido = new JTextArea();
			arTraducido.setWrapStyleWord(true);
			arTraducido.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			arTraducido.setBackground(java.awt.Color.lightGray);
			arTraducido.setLineWrap(true);
			arTraducido.addFocusListener(procesaFoco);
		}
		return arTraducido;
	}

	private JButton getBtEspa�ol() {
		if (btEspa�ol == null) {
			btEspa�ol = new JButton();
			btEspa�ol.setText("ES");
			btEspa�ol.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 14));
			btEspa�ol.setBorderPainted(false);
			btEspa�ol.setPreferredSize(new java.awt.Dimension(24,24));
			btEspa�ol.setMargin(new java.awt.Insets(0,0,0,0));
			btEspa�ol.setMaximumSize(new java.awt.Dimension(24,24));
			btEspa�ol.setMinimumSize(new java.awt.Dimension(24,24));
			btEspa�ol.setContentAreaFilled(false);
			
		}
		return btEspa�ol;
	}

	private JButton getBtFrances() {
		if (btFrances == null) {
			btFrances = new JButton();
			btFrances.setBorderPainted(false);
			btFrances.setText("FR");
			btFrances.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 14));
			btFrances.setPreferredSize(new java.awt.Dimension(25,24));
			btFrances.setMargin(new java.awt.Insets(0,0,0,0));
			btFrances.setMaximumSize(new java.awt.Dimension(25,24));
			btFrances.setMinimumSize(new java.awt.Dimension(25,24));
			btFrances.setContentAreaFilled(false);
		}
		return btFrances;
	}

	private JButton getBtIngles() {
		if (btIngles == null) {
			btIngles = new JButton();
			btIngles.setBorderPainted(false);
			btIngles.setText("EN");
			btIngles.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 14));
			btIngles.setPreferredSize(new java.awt.Dimension(24,24));
			btIngles.setMargin(new java.awt.Insets(0,0,0,0));
			btIngles.setMaximumSize(new java.awt.Dimension(24,24));
			btIngles.setMinimumSize(new java.awt.Dimension(24,24));
			btIngles.setContentAreaFilled(false);
		}
		return btIngles;
	}

	private JMenu getMenuArchivo() {
		if (menuArchivo == null) {
			menuArchivo = new JMenu();
			menuArchivo.setText("Archivo");
			menuArchivo.add(getItNuevo());
			menuArchivo.addSeparator();
			menuArchivo.add(getItGuardarComo());
			menuArchivo.addSeparator();
			menuArchivo.add(getItSalir());
		}
		return menuArchivo;
	}

	private JMenu getMenuEditar() {
		if (menuEditar == null) {
			menuEditar = new JMenu();
			menuEditar.setText("Editar");
		}
		return menuEditar;
	}

	private JMenu getMenuTraducir() {
		if (menuTraducir == null) {
			menuTraducir = new JMenu();
			menuTraducir.setText("Traducir");
		}
		return menuTraducir;
	}

	private JMenu getMenuHerramientas() {
		if (menuHerramientas == null) {
			menuHerramientas = new JMenu();
			menuHerramientas.setText("Herramientas");
		}
		return menuHerramientas;
	}

	private JMenu getMenuAyuda() {
		if (menuAyuda == null) {
			menuAyuda = new JMenu();
			menuAyuda.setText("Ayuda");
		}
		return menuAyuda;
	}

	private JMenuItem getItGuardarComo() {
		if (itGuardarComo == null) {
			itGuardarComo = new JMenuItem();
			itGuardarComo.setText("Guardar como...");
		}
		return itGuardarComo;
	}

	private JMenuItem getItNuevo() {
		if (itNuevo == null) {
			itNuevo = new JMenuItem();
			itNuevo.setText("Nuevo");
		}
		return itNuevo;
	}

	private JMenuItem getItSalir() {
		if (itSalir == null) {
			itSalir = new JMenuItem();
			itSalir.setText("Salir");
		}
		return itSalir;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		procesaFoco= new ProcesaElFoco();
		setSize(981, 586);
		setJMenuBar(getBarraMenu());
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		setTitle("Traductor de Textos");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(getBarraHerramientas(), java.awt.BorderLayout.NORTH);
		contentPane.add(getBarraEstado(), java.awt.BorderLayout.SOUTH);
		contentPane.add(getPnTextos(), java.awt.BorderLayout.CENTER);
		setContentPane(contentPane);
		btIngles.grabFocus();
	}
	
	class ProcesaElFoco implements FocusListener
	{
		public void focusGained(FocusEvent e)
		{
			((JTextArea) e.getSource()).setBackground(Color.WHITE);
		}
		
		public void focusLost(FocusEvent e)
		{
			((JTextArea) e.getSource()).setBackground(Color.LIGHT_GRAY);
		}
	}
	
//	class ProcesaLaVentana implements WindowListener
//	{
//		public void WindowOpened(WindowOpened e)
//		{
//			
//		}
//	}
} 
