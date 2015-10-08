package CapaDeInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.TextArea;
import java.awt.Panel;

import javax.swing.JList;

import CapadeNegocio.ControladorJuego;
import Clases.Pieza;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;

import java.awt.Scrollbar;
import java.util.ArrayList;

import javax.swing.JScrollPane;

public class Tablero extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tablero frame = new Tablero();
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
	public Tablero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(80, 73, 111, 20);
		contentPane.add(textPane);
		
		final TextArea textArea = new TextArea();
		textArea.setBounds(127, 113, 95, 229);
		contentPane.add(textArea);
		
		final TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(10, 113, 95, 229);
		contentPane.add(textArea_1);
		
		textField = new JTextField();
		textField.setBounds(80, 11, 111, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 42, 111, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
	
		
		JLabel lblJugador = new JLabel("Jugador 1");
		lblJugador.setBounds(10, 14, 64, 14);
		contentPane.add(lblJugador);
		
		JLabel lblJugador_1 = new JLabel("Jugador 2");
		lblJugador_1.setBounds(10, 45, 60, 14);
		contentPane.add(lblJugador_1);
		
		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setBounds(270, 133, 46, 14);
		contentPane.add(lblOrigen);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setBounds(270, 176, 46, 14);
		contentPane.add(lblDestino);
		
		textField_2 = new JTextField();
		textField_2.setBounds(325, 130, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(325, 173, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnMover = new JButton("Mover");
		btnMover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorJuego ctrl = new ControladorJuego();
				  
			       textPane.setText(ctrl.realizarMovimiento(textField_2.getText(), textField_3.getText(), textPane.getText()));
			       textArea_1.setText(ctrl.mostrarfichasNegras());
			        textArea.setText(ctrl.mostrarfichasBlancas());
			}
		});
		btnMover.setBounds(292, 216, 89, 23);
		contentPane.add(btnMover);
		
		JLabel lblTurno = new JLabel("Turno");
		lblTurno.setBounds(28, 79, 46, 14);
		contentPane.add(lblTurno);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorJuego ctrl = new ControladorJuego();
				if(ctrl.partidaPendiente(textField.getText(), textField_1.getText()))
					{
					
					ctrl.inicializatablero();
					ctrl.traerPosiciones(textField.getText(), textField_1.getText());
					  textArea_1.setText(ctrl.mostrarfichasNegras());
				        textArea.setText(ctrl.mostrarfichasBlancas());
				}
				else
				{
				ctrl.inicializatablero();
				textPane.setText("Blanco");
		        textArea_1.setText(ctrl.mostrarfichasNegras());
		        textArea.setText(ctrl.mostrarfichasBlancas());
		        ctrl.nuevoJuego(textField.getText(), textField_1.getText(), "Blanco");
		        ctrl.asignarPiezas(textField.getText(),textField_1.getText());
				}
				}
		});
		btnJugar.setBounds(322, 10, 89, 23);
		contentPane.add(btnJugar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorJuego ctrl = new ControladorJuego();
				ctrl.borrarPiezas(textField.getText(),textField_1.getText());
				ctrl.asignarPiezas(textField.getText(), textField_1.getText());
			}
		});
		btnGuardar.setBounds(322, 41, 89, 23);
		contentPane.add(btnGuardar);
		

		

		

		
	
	}
}
