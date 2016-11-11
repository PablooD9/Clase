package igu;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.SwingConstants;

import logica.*;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnJuego;
	private JMenu mnAyuda;
	private JMenuItem itnuevo;
	private JMenuItem itSalir;
	private JMenuItem itContenidos;
	private JMenuItem itAcercaDe;
	private JSeparator separator;
	private JSeparator separator_1;
	private JPanel pnLiebre;
	private JPanel pnTortuga;
	private JLabel lbTortuga;
	private JButton btDado;
	private JTextField txDado;
	private JLabel lbScore;
	private JLabel lbLiebrePequeña;
	private JLabel lbTortugaPequeña;
	private JTextField txPuntosLiebre;
	private JTextField txtPuntosTortuga;
	private Carrera carrera;
	private JLabel lbLiebre;
	private ProcesaBoton pB;
	private JMenuItem itNumArboles;
	private int numArboles;
	private JMenuItem itNumCasillas;
	private int numCasillas;
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal()
	{
		numCasillas= 11;
		carrera= new Carrera();
		pB= new ProcesaBoton();
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/liebre.JPG")));
		setTitle("La Liebre y la Tortuga");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 400);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPnLiebre(numCasillas));
		contentPane.add(getPnTortuga(numCasillas));
		contentPane.add(getLbLiebre());
		contentPane.add(getLbTortuga());
		contentPane.add(getBtDado());
		contentPane.add(getTxDado());
		contentPane.add(getLbScore());
		contentPane.add(getLabel_1());
		contentPane.add(getLabel_2());
		contentPane.add(getTxPuntosLiebre());
		contentPane.add(getTxtPuntosTortuga());
		setLocationRelativeTo(null);
		modificarPanel(pnLiebre, false);
		modificarPanel(pnTortuga, false);
		asociarEventosBotones(pnLiebre);
		asociarEventosBotones(pnTortuga);
		numArboles= carrera.getLiebre().getCalleAsignada().getTrees();
		creaBotonesPanel(pnLiebre);
		creaBotonesPanel(pnTortuga);
		pintarCorredores();
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnJuego());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}
	private JMenu getMnJuego() {
		if (mnJuego == null) {
			mnJuego = new JMenu("Juego");
			mnJuego.setMnemonic('J');
			mnJuego.add(getItnuevo());
			mnJuego.add(getItNumArboles());
			mnJuego.add(getItNumCasillas());
			mnJuego.add(getSeparator());
			mnJuego.add(getItSalir());
		}
		return mnJuego;
	}
	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.setMnemonic('A');
			mnAyuda.add(getItContenidos());
			mnAyuda.add(getSeparator_1());
			mnAyuda.add(getItAcercaDe());
		}
		return mnAyuda;
	}
	private JMenuItem getItnuevo() {
		if (itnuevo == null) {
			itnuevo = new JMenuItem("Nuevo");
			itnuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar(carrera.getLiebre().getCalleAsignada().getTrees(), carrera.getNumCasillas());
				}
			});
			itnuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
			itnuevo.setMnemonic('N');
		}
		return itnuevo;
	}
	private JMenuItem getItSalir() {
		if (itSalir == null) {
			itSalir = new JMenuItem("Salir");
			itSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
			itSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			itSalir.setMnemonic('S');
		}
		return itSalir;
	}
	private JMenuItem getItContenidos() {
		if (itContenidos == null) {
			itContenidos = new JMenuItem("Contenidos");
			itContenidos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Ayuda no disponible demomento", "Contenidos de la ayuda", 1);
				}
			});
			itContenidos.setMnemonic('C');
		}
		return itContenidos;
	}
	private JMenuItem getItAcercaDe() {
		if (itAcercaDe == null) {
			itAcercaDe = new JMenuItem("Acerca de");
			itAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarAcercaDe();
				}
			});
			itAcercaDe.setMnemonic('D');
		}
		return itAcercaDe;
	}
	
	private void mostrarAcercaDe()
	{
		JOptionPane.showMessageDialog(this, "Juego de la liebre y la tortuga V1.0 \n Comunicación Persona-Máquina \n E.I.Informática Oviedo",
				"Acerca del juego de la Liebre y la Tortuga", 1);
	}
	
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
	private JPanel getPnLiebre(int numBotones) {
		if (pnLiebre == null) {
			pnLiebre = new JPanel();
			pnLiebre.setBackground(Color.BLUE);
			pnLiebre.setBorder(new LineBorder(Color.BLUE, 10));
			pnLiebre.setBounds(95, 105, 775, 80);
			pnLiebre.setLayout(new GridLayout(1, numCasillas, 0, 0));
//			for(int i=0; i < numBotones; i++){
//				JButton bt = new JButton();
//				bt.setBackground(Color.BLACK);
//				bt.setActionCommand(String.valueOf(i));
//				bt.addActionListener(pB);
//				pnLiebre.add(bt);
//			}
		}
		return pnLiebre;
	}
	private JPanel getPnTortuga(int numBotones) {
		if (pnTortuga == null) {
			pnTortuga = new JPanel();
			pnTortuga.setBorder(new LineBorder(Color.BLUE, 10));
			pnTortuga.setBackground(Color.BLUE);
			pnTortuga.setBounds(95, 184, 775, 80);
			pnTortuga.setLayout(new GridLayout(1, numCasillas, 0, 0));
//			for(int i=0; i < numBotones; i++){
//				JButton bt = new JButton();
//				bt.setBackground(Color.BLACK);
//				bt.setActionCommand(String.valueOf(i));
//				bt.addActionListener(pB);
//				pnTortuga.add(bt);
//			}
		}
		return pnTortuga;
	}
	private JLabel getLbTortuga() {
		if (lbTortuga == null) {
			lbTortuga = new JLabel("");
			lbTortuga.setVisible(false);
			lbTortuga.setHorizontalAlignment(SwingConstants.CENTER);
			lbTortuga.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/flecha.png")));
			lbTortuga.setBounds(34, 201, 51, 33);
		}
		return lbTortuga;
	}
	private JButton getBtDado() {
		if (btDado == null) {
			btDado = new JButton("");
			btDado.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dado.JPG")));
			btDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
//					if(carrera.lanzarDado())
//					{
					carrera.lanzarDado();
						int numero= carrera.getNumeroDado();
						txDado.setText(String.valueOf(numero));
						habilitarPanelCorredorActivo(carrera.getCorredorActivo());
						habilitarFlechaCorredorActivo(carrera.getCorredorActivo());
						btDado.setEnabled(false);
//					}
//					else
//					{
//						txDado.setText(String.valueOf(carrera.getNumeroDado())); // Para ver que el número salido en
//																				// el dado es erróneo.
//						JOptionPane.showMessageDialog(null, "La jugada no es posible");
//						deshabilitarPaneles();
//						txDado.setText("");
//					}
				}
			});
			btDado.setToolTipText("Haga click para lanzar el dado");
			btDado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dado.JPG")));
			btDado.setContentAreaFilled(false);
			btDado.setBorderPainted(false);
			btDado.setBackground(Color.BLACK);
			btDado.setBounds(36, 11, 61, 89);
		}
		return btDado;
	}
	private JTextField getTxDado() {
		if (txDado == null) {
			txDado = new JTextField();
			txDado.setText("0");
			txDado.setBorder(null);
			txDado.setHorizontalAlignment(SwingConstants.CENTER);
			txDado.setFont(new Font("Sylfaen", Font.PLAIN, 60));
			txDado.setForeground(Color.GREEN);
			txDado.setBackground(Color.BLACK);
			txDado.setEditable(false);
			txDado.setBounds(135, 11, 138, 63);
			txDado.setColumns(10);
		}
		return txDado;
	}
	private JLabel getLbScore() {
		if (lbScore == null) {
			lbScore = new JLabel("Score");
			lbScore.setHorizontalAlignment(SwingConstants.CENTER);
			lbScore.setForeground(Color.YELLOW);
			lbScore.setFont(new Font("Jokerman", Font.PLAIN, 40));
			lbScore.setBounds(366, 4, 172, 74);
		}
		return lbScore;
	}
	private JLabel getLabel_1() {
		if (lbLiebrePequeña == null) {
			lbLiebrePequeña = new JLabel("");
			lbLiebrePequeña.setHorizontalAlignment(SwingConstants.CENTER);
			lbLiebrePequeña.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/liebre_peq.JPG")));
			lbLiebrePequeña.setBounds(561, 11, 57, 33);
		}
		return lbLiebrePequeña;
	}
	private JLabel getLabel_2() {
		if (lbTortugaPequeña == null) {
			lbTortugaPequeña = new JLabel("");
			lbTortugaPequeña.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/tortuga_peq.JPG")));
			lbTortugaPequeña.setHorizontalAlignment(SwingConstants.CENTER);
			lbTortugaPequeña.setBounds(566, 45, 45, 33);
		}
		return lbTortugaPequeña;
	}
	private JTextField getTxPuntosLiebre() {
		if (txPuntosLiebre == null) {
			txPuntosLiebre = new JTextField();
			txPuntosLiebre.setEditable(false);
			txPuntosLiebre.setHorizontalAlignment(SwingConstants.CENTER);
			txPuntosLiebre.setText("0");
			txPuntosLiebre.setFont(new Font("Arial", Font.PLAIN, 24));
			txPuntosLiebre.setForeground(Color.MAGENTA);
			txPuntosLiebre.setBackground(Color.BLACK);
			txPuntosLiebre.setBounds(612, 17, 147, 26);
			txPuntosLiebre.setColumns(10);
		}
		return txPuntosLiebre;
	}
	private JTextField getTxtPuntosTortuga() {
		if (txtPuntosTortuga == null) {
			txtPuntosTortuga = new JTextField();
			txtPuntosTortuga.setEditable(false);
			txtPuntosTortuga.setText("0");
			txtPuntosTortuga.setHorizontalAlignment(SwingConstants.CENTER);
			txtPuntosTortuga.setForeground(Color.MAGENTA);
			txtPuntosTortuga.setFont(new Font("Arial", Font.PLAIN, 24));
			txtPuntosTortuga.setColumns(10);
			txtPuntosTortuga.setBackground(Color.BLACK);
			txtPuntosTortuga.setBounds(612, 52, 147, 26);
		}
		return txtPuntosTortuga;
	}
	
	private void modificarPanel(JPanel panel, boolean habilitado)
	{
		Component[] botones= panel.getComponents(); //útil para evaluar muchos componentes dentro de un contenedor.
		for (int i=0; i< botones.length; i++)
		{
			JButton boton= (JButton) botones[i];
			boton.setEnabled(habilitado);
		}
	}
	
	private void habilitarPanelCorredorActivo(Corredor corredor)
	{
		if (corredor.getNombre().equals("liebre"))
		{
			modificarPanel(pnLiebre, true);
		}
		else if (corredor.getNombre().equals("tortuga"))
		{
			modificarPanel(pnTortuga, true);
		}
	}
	
	private void habilitarFlechaCorredorActivo(Corredor corredor)
	{
		if (corredor.getNombre().equals("liebre"))
		{
			lbLiebre.setVisible(true);
			lbTortuga.setVisible(false);
		}
		else if (corredor.getNombre().equals("tortuga"))
		{
			lbTortuga.setVisible(true);
			lbLiebre.setVisible(false);
		}
	}
	
	private void deshabilitarPaneles()
	{
		modificarPanel(pnLiebre, false);
		modificarPanel(pnTortuga, false);
	}
	
	private void jugar(int i)
	{
		if (carrera.resolverJugada(i))
		{
			representarEstadoJuego();
		}
	}
	
	private void representarEstadoJuego()
	{
		pintarPuntos();
		pintarCorredores();
		deshabilitarPaneles();
		
		if (carrera.isPartidaFinalizada())
		{
			String corredor= elegirGanador();
			JOptionPane.showMessageDialog(null, "Partida finalizada!\nEl ganador ha sido: " + corredor);
			inicializar(numArboles, numCasillas);
		}
			
		else
		{
			btDado.setEnabled(true);
		}
	}

	private String elegirGanador() {
		String corredor= "";
		if (carrera.getCorredorNoActivo().getCalleAsignada().getCasilla(carrera.getCorredorNoActivo().getPosicion()).hasBlackHole())
		{
			corredor= carrera.getCorredorActivo().getNombre();
		}
		
		else
		{
			corredor= carrera.getCorredorNoActivo().getNombre();
		}
		
		return corredor;
	}
	
	private void pintarPuntos()
	{
		txPuntosLiebre.setText(String.valueOf(carrera.getLiebre().getPuntuacion()));
		txtPuntosTortuga.setText(String.valueOf(carrera.getTortuga().getPuntuacion()));
	}
	
	private void pintarCalle(Corredor corredor,Component[] botones) {
//		ImageIcon imagen = new ImageIcon(getClass().getResource("/img/" + corredor.getFoto()));
//		ImageIcon imagen2 = new ImageIcon(getClass().getResource("/img/arbol.JPG"));
//		ImageIcon imagen3 = new ImageIcon(getClass().getResource("/img/liebre_durmiendo.jpg"));
//		ImageIcon imagen4 = new ImageIcon(getClass().getResource("/img/blackhole.png"));
		String imagen= "/img/" + corredor.getFoto();
		String imagen2= "/img/arbol.JPG";
		String imagen3= "/img/liebre_durmiendo.jpg";
		String imagen4= "/img/blackhole.png";
		
		for (int i=0; i<botones.length;i++)
		{
			  JButton boton = (JButton) botones[i];
			  if (i == corredor.getPosicion())
			  {
				  if (corredor.getIsSleeping())
				  {
//					  boton.setIcon(imagen3);
//					  boton.setDisabledIcon(imagen3);
					  setImagenAdaptada(boton, imagen3);
				  }
				  else
				  {
//					  boton.setIcon(imagen);
//					  boton.setDisabledIcon(imagen);
					  setImagenAdaptada(boton, imagen);
				  }
			  }
		      else
		      {
		    	  if (corredor.getCalleAsignada().getCasilla(i).hasTree())
		    	  {
//		    			boton.setIcon(imagen2);
//		    			boton.setDisabledIcon(imagen2);
		    		  	setImagenAdaptada(boton, imagen2);
		    	  }
		    	  
		    	  else if (corredor.getCalleAsignada().getCasilla(i).hasBlackHole())
		    	  {
//		    		  boton.setIcon(imagen4);
//		    		  boton.setDisabledIcon(imagen4);
		    		  setImagenAdaptada(boton, imagen4);
		    	  }
		    	  
		    	  else
		    	  {
		    		  boton.setIcon(null);
		    	  }
		      }
		}
	}
	
	private void pintarCorredores()
	{
		pintarCalle(carrera.getTortuga(), pnTortuga.getComponents());
		pintarCalle(carrera.getLiebre(), pnLiebre.getComponents());
	}
	
	private void inicializar(int numeroArboles, int numeroCasillas)
	{
		//parte lógica:
		carrera.inicializarJuego(numeroArboles, numeroCasillas);
		//parte interfaz:
		representarEstadoJuego();
		txDado.setText("0");
		lbLiebre.setVisible(false);
		lbTortuga.setVisible(false);
	}
	
	private JLabel getLbLiebre() {
		if (lbLiebre == null) {
			lbLiebre = new JLabel("");
			lbLiebre.setVisible(false);
			lbLiebre.setHorizontalAlignment(SwingConstants.CENTER);
			lbLiebre.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/flecha.png")));
			lbLiebre.setBounds(30, 132, 55, 33);
		}
		return lbLiebre;
	}
	
	class ProcesaBoton implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton bt= (JButton) e.getSource();
			jugar(Integer.parseInt(bt.getActionCommand()));
		}
	}
	
	private void asociarEventosBotones(JPanel panel)
	{
		for (int i=0; i< panel.getComponentCount(); i++)
		{
			JButton bt= (JButton) panel.getComponents()[i];
			bt.setActionCommand(String.valueOf(i));
			bt.addActionListener(pB);
		}
	}
	
	private JMenuItem getItNumArboles() {
		if (itNumArboles == null) {
			itNumArboles = new JMenuItem("N\u00FAmero de \u00E1rboles");
			itNumArboles.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					String arboles= numArboles();
					
					if (arboles != null)
					{
						numArboles= Integer.parseInt(arboles);
						if (numArboles >= 0)
						{
							inicializar(numArboles, numCasillas);
						}
					}
				}
			});
			itNumArboles.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		}
		return itNumArboles;
	}
	
	private String numArboles()
	{
		boolean isRight= false;
		String numArboles= "";
		int numArboles2= 0;
		
		while (!isRight)
		{
			try
			{
				numArboles= JOptionPane.showInputDialog(contentPane, "Elige el número de árboles");
				numArboles2= Integer.parseInt(numArboles);
			} catch (NumberFormatException nFE)
			{
				if (numArboles != null)
				{
					numArboles= "";
				}
			}
			
			if ((numArboles == null) || (numArboles2 >= 0 && numArboles2 <= carrera.getCorredorActivo().getCalleAsignada().numCasillas() - 2))
			{
				isRight= true;
			}
			
			else
			{
				JOptionPane.showMessageDialog(contentPane, "Error.\n Introduce un valor correcto");
			}
			
		}
		return numArboles;
	}
	
	//Quitar todos los botones de los paneles (en Design). En tiempo de ejecución, for i=0;i<numCasillas;i++)->
	//numCasillas será un atributo de la clase calle
	//-> creamos botón (setBackground...)
	//bt.setActionCommand(String.valueOf(i));
	//bt.addActionListener(pB);
	//(pnLiebre o pnTortuga).add(bt); <- habrá que llamar a este metodo 2 veces, una para cada animal.
	//se debe hacer despues otro metodo que sea removeAll, que borre todo el panel.
	
	private void creaBotonesPanel(JPanel panel)
	{
		panel.removeAll();
		for (int i=0;i<numCasillas;i++)
		{
			panel.add(nuevoboton(i));
		}
	}
	
	private JButton nuevoboton(Integer posicion)
	{
		JButton boton= new JButton("");
		boton.setBackground(Color.BLACK);
		boton.setActionCommand(posicion.toString());
		boton.addActionListener(pB);
		return boton;
	}
	
	private JMenuItem getItNumCasillas() {
		if (itNumCasillas == null) {
			itNumCasillas = new JMenuItem("N\u00FAmero de casillas");
			itNumCasillas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					String casillas= numCasillas();
					
					if (casillas != null)
					{
						numCasillas= Integer.parseInt(casillas);
						if (numCasillas >= 10)
						{
							creaBotonesPanel(pnLiebre);
							creaBotonesPanel(pnTortuga);
							inicializar(numArboles, numCasillas);
							
						}
					}
				}
			});
			itNumCasillas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		}
		return itNumCasillas;
	}
	
	private String numCasillas()
	{
		boolean isRight= false;
		String numCasillas= "";
		int numCasillas2= 0;
		
		while (!isRight)
		{
			try
			{
				numCasillas= JOptionPane.showInputDialog(contentPane, "Elige el número de casillas");
				numCasillas2= Integer.parseInt(numCasillas);
			} catch (NumberFormatException nFE)
			{
				if (numCasillas != null)
				{
					numCasillas= "";
				}
			}
			
			if ((numCasillas == null) || (numCasillas2 >= 10 && numCasillas2 <= 14))
			{
				isRight= true;
			}
			
			else
			{
				JOptionPane.showMessageDialog(contentPane, "Error.\n Introduce un valor correcto");
			}
			
		}
		return numCasillas;
	}
	
	private void setImagenAdaptada(JButton boton, String rutaImagen)
	{
		Image imgOriginal= new ImageIcon(getClass().getResource(rutaImagen)).getImage();
//		Image imgEscalada= imgOriginal.getScaledInstance((int) (boton.getWidth()), (int) (boton.getHeight()), Image.SCALE_FAST);
		boton.setIcon(new ImageIcon(imgOriginal));
		boton.setDisabledIcon(new ImageIcon(imgOriginal));
	}
}
