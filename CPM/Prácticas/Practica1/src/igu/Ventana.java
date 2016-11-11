package igu;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame {
	private JPanel panelPrincipal;
	private JButton botonAceptar;
	private JButton botonCancelar;
	private JLabel texto;
	private JTextField campo;
	
	public Ventana(){
		setTitle("Ejemplo de ventana"); //Título de la ventana
		setBounds(10,10,400,400); //Redimensiona y posiciona la ventana
		setLocationRelativeTo(null); //Se pone null para dejar claro que
		//la ventana que estamos creando, esté centrada en la del ordenador.
		
		panelPrincipal= new JPanel();
		setContentPane(panelPrincipal); //Se asocia el panel con Frame. El
		//contenedor (panelPrincipal) va dentro del Frame, y se usa para meter
		//elementos dentro del JFrame.
		panelPrincipal.setBackground(Color.RED);
		
		botonAceptar= new JButton();
		panelPrincipal.add(botonAceptar);
		botonAceptar.setText("Aceptar");
		panelPrincipal.setLayout(null);
		botonAceptar.setBounds(160, 280, 100, 45);
		botonAceptar.setForeground(Color.BLUE);
		
		
		//Crear botón cancelar; setForeground
		//Para crear etiquetas: JLabel. Propiedad: text
		botonCancelar= new JButton();
		panelPrincipal.add(botonCancelar);
		botonCancelar.setText("Cancelar");
		botonCancelar.setBounds(280, 280, 100, 45);
		panelPrincipal.setLayout(null);
		botonCancelar.setForeground(Color.BLUE);
		
		texto= new JLabel();
		panelPrincipal.add(texto);
		texto.setText("Introducir nombre: ");
		texto.setBounds(50, 100, 150, 100);
		texto.setForeground(Color.WHITE);
		
		campo= new JTextField();
		panelPrincipal.add(campo);
		campo.setBounds(170, 140, 200, 20);
	}

	public static void main(String[] args) {
		Ventana v= new Ventana();
		v.setVisible(true);
	}

}
