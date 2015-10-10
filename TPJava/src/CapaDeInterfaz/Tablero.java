package CapaDeInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.TextArea;
import java.awt.Panel;

import javax.swing.JList;

import CapadeNegocio.ControladorJuego;
import Clases.Partida;
import Clases.Pieza;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;

import java.awt.Scrollbar;
import java.util.ArrayList;

import javax.swing.JScrollPane;

import java.awt.Label;

public class Tablero extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Partida p;
	private ImageIcon image;
	private JLabel labelI;

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
		

		
		
		
		
		final String LetrasValidas="abcdefgh";
		final String NumerosValidos="12345678";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(80, 73, 111, 20);
		contentPane.add(textPane);
		
		final TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setBounds(127, 113, 95, 286);
		contentPane.add(textArea);
		
		final TextArea textArea_1 = new TextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(10, 113, 95, 286);
		contentPane.add(textArea_1);
		
		textField = new JTextField();
		textField.setBounds(139, 11, 111, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(139, 42, 111, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
	
		
		JLabel lblJugador = new JLabel("Jugador Blancas");
		lblJugador.setBounds(10, 14, 111, 14);
		contentPane.add(lblJugador);
		
		JLabel lblJugador_1 = new JLabel("Jugador Negras");
		lblJugador_1.setBounds(10, 45, 95, 14);
		contentPane.add(lblJugador_1);
		
		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setBounds(312, 133, 46, 14);
		contentPane.add(lblOrigen);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setBounds(312, 176, 46, 14);
		contentPane.add(lblDestino);
		
		textField_2 = new JTextField();
		textField_2.setBounds(386, 130, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(386, 173, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnMover = new JButton("Mover");
		btnMover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_2.getText().equals("") | textField_3.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Las posicion origen o destino no deben ser vacias","Error de ingreso de posiciones",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				if(textField_2.getText().length()==2 & (LetrasValidas.contains(textField_2.getText().substring(0, 1)) & NumerosValidos.contains(textField_2.getText().substring(1)))  & (textField_3.getText().length()==2 &  LetrasValidas.contains(textField_3.getText().substring(0, 1)) & NumerosValidos.contains(textField_3.getText().substring(1))))
				{
					textField_2.setText(textField_2.getText().toLowerCase());
				textField_3.setText(textField_3.getText().toLowerCase());
				mover(textPane,textArea,textArea_1);
				}
				else
					JOptionPane.showMessageDialog(null, "Los datos ingresados no pertecen a posiciones del tablero","Error de ingreso de posiciones",JOptionPane.ERROR_MESSAGE);
				
				}
			}
		});
		btnMover.setBounds(359, 215, 89, 23);
		contentPane.add(btnMover);
		
		JLabel lblTurno = new JLabel("Turno");
		lblTurno.setBounds(28, 79, 46, 14);
		contentPane.add(lblTurno);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("") | textField_1.getText().equals("") | !textField.getText().matches("[0-9]+") | !textField_1.getText().matches("[0-9]+"))
					JOptionPane.showMessageDialog(null, "Uno o ambos dni's no pueden ser vacios o alfanumericos","Error de ingreso de dni",JOptionPane.ERROR_MESSAGE);
				else
				
					if(textField.getText().equals(textField_1.getText()))
						JOptionPane.showMessageDialog(null, "No se puede asignar un mismo jugador para ambos colores","Error de ingreso de dni",JOptionPane.ERROR_MESSAGE);
					else jugar(textPane,textArea,textArea_1);
				
			}
		});
		btnJugar.setBounds(383, 10, 89, 23);
		contentPane.add(btnJugar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    guardar(textPane,textArea,textArea_1);
			}

			
		});
		btnGuardar.setBounds(386, 41, 89, 23);
		contentPane.add(btnGuardar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Tablero.class.getResource("/Imagenes/board.png")));
		lblNewLabel.setBounds(270, 265, 258, 256);
		contentPane.add(lblNewLabel);
		

		

		

		
	
	}
	
	private void jugar(JTextComponent textPane, TextArea textArea,TextArea textArea_1)
	{
		ControladorJuego ctrl = new ControladorJuego();
		int i=0;
		
		if(ctrl.partidaPendiente(textField.getText(), textField_1.getText()))
			{
			if(i==JOptionPane.showConfirmDialog(null, "Existe una partida pendiente con los 2 DNI ingredos \n Presione Aceptar para seguir la partida \n Presionar cancelar para iniciar un nuevo juego", "Partida pendiente", JOptionPane.OK_CANCEL_OPTION))
			{
				ControladorJuego.setPiezas();
			ctrl.tablero();
			ctrl.traerPosiciones(textField.getText(), textField_1.getText());
			ctrl.eliminarFichasNulas();
			textPane.setText(ControladorJuego.getPartidaActual().getTurno());
			  textArea_1.setText(ctrl.mostrarfichasNegras());
		        textArea.setText(ctrl.mostrarfichasBlancas());}
		else 	
			{
			ctrl.terminarPartida(textField.getText(),textField_1.getText());
			nuevaPartida(textField,textField_1,textArea,textArea_1,textPane);
			
			}
		}
		else nuevaPartida(textField,textField_1,textArea,textArea_1,textPane);
		
	}
	
	private void nuevaPartida(JTextField textField2, JTextField textField_12, TextArea textArea, TextArea textArea_1,
			JTextComponent textPane) {
		ControladorJuego ctrl = new ControladorJuego();
		ControladorJuego.setPiezas();
		ctrl.inicializatablero();
		textPane.setText("Blanco");
        textArea_1.setText(ctrl.mostrarfichasNegras());
        textArea.setText(ctrl.mostrarfichasBlancas());
        ctrl.nuevoJuego(textField.getText(), textField_1.getText(), "Blanco");
        p=new Partida(textField.getText(),textField_1.getText(),"Blanco");
        ControladorJuego.setPartidaActual(p);
        ctrl.asignarPiezas(textField.getText(),textField_1.getText());
		
	}

	private void mover(JTextPane textPane, TextArea textArea, TextArea textArea_1)
	{
		ControladorJuego ctrl = new ControladorJuego();
		 Partida p = ControladorJuego.getPartidaActual();
		 try
		 {
	       textPane.setText(ctrl.realizarMovimiento(textField_2.getText(), textField_3.getText(), textPane.getText()));
	       ControladorJuego.getPartidaActual().setTurno(textPane.getText());
	       Pieza reyN = ctrl.estadoReyN();
			Pieza reyB = ctrl.estadoReyB();
	       textArea_1.setText(ctrl.mostrarfichasNegras());
	        textArea.setText(ctrl.mostrarfichasBlancas());
	        if(reyB==null)
	        {
	        	JOptionPane.showMessageDialog(null, "¡Ganador fichas negras!"+"\n"+"El ganador es: "+p.getDniNegro(),"Fin del juego",JOptionPane.ERROR_MESSAGE);
	           ctrl.terminarPartida(textField.getText(), textField_1.getText());
	           ControladorJuego.setPiezas();
	           textArea_1.setText("");
		        textArea.setText("");
		        textPane.setText("");
		        
	        }
	        else
	        {
	        	if(reyN==null)
	        	{
	        		JOptionPane.showMessageDialog(null, "¡Ganador fichas blancas!"+"El ganador es: "+p.getDniBlanco(),"Fin del juego",JOptionPane.ERROR_MESSAGE);
			         ctrl.terminarPartida(textField.getText(), textField_1.getText());
			         ControladorJuego.setPiezas();
			        textArea_1.setText("");
			        textArea.setText("");
			        textPane.setText("");
			        
			      
	        	}
	        }
		 }
		 catch(NullPointerException e)
		 {
			 JOptionPane.showMessageDialog(null, "No hay ninguna partida en juego","Error de partida",JOptionPane.ERROR_MESSAGE);
		 }
	        
	     
	    
	}

	private void guardar(JTextPane textPane, TextArea textArea,
			TextArea textArea_1) {
		// TODO Auto-generated method stub
		try{
		ControladorJuego ctrl = new ControladorJuego();
		Partida p = ControladorJuego.getPartidaActual();
		ctrl.terminarPartida(textField.getText(), textField_1.getText());
		ctrl.nuevoJuego(p.getDniBlanco(), p.getDniNegro(), p.getTurno());
		ctrl.asignarPiezas(textField.getText(), textField_1.getText());
		}
		catch(NullPointerException e)
		{
			JOptionPane.showMessageDialog(null, "No hay ninguna partida en juego","Error de ingreso de partida",JOptionPane.ERROR_MESSAGE);
		}
	}
}


