package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaRegistro extends JFrame {

	private JPanel panelPrincipal;
	private JTextField txNombre;

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
		setTitle("Ventana de registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.RED);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lbNombre = new JLabel("Nombre:");
		lbNombre.setBounds(30, 57, 46, 14);
		panelPrincipal.add(lbNombre);
		
		txNombre = new JTextField();
		txNombre.setText("pepito");
		txNombre.setBounds(86, 43, 153, 40);
		panelPrincipal.add(txNombre);
		txNombre.setColumns(10);
	}
}
