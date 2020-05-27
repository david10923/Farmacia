package Presentacion.Cliente;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.Controller;
import Controller.Evento;
import Negocio.Cliente.TCliente;

public class VentanaModificarCliente extends JDialog implements ActionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel DNI_Label; 
	private JTextField DNI_Text;
	private JLabel TARJETA_Label;
	private JTextField TARJETA_Text;
	private JLabel NOMBRE_Label;
	private JTextField NOMBRE_Text;
	private JButton botonAceptar;
	private JButton botonCancelar;
	
	public VentanaModificarCliente(){
		
		iniciarventana();
		
		
		/////NOMBRE //////		
		NOMBRE_Label = new JLabel("NOMBRE: ");		
		NOMBRE_Label.setBounds(10, 120, 165, 25);		
		this.add(NOMBRE_Label);		
		NOMBRE_Text = new JTextField();		
		NOMBRE_Text.setBounds(100, 120, 165, 25);		
		this.add(NOMBRE_Text);
		
		
		////////DNI////////
		DNI_Label = new JLabel("DNI: ");		
		DNI_Label.setBounds(10, 20, 80, 25);		
		this.add(DNI_Label);		
		DNI_Text = new JTextField();		
		DNI_Text.setBounds(100, 20, 165, 25);		
		this.add(DNI_Text);
		
		
		///////TARJETA SANITARIA////////		
		TARJETA_Label = new JLabel("TARJETA SANITARIA: ");		
		TARJETA_Label.setBounds(10, 70, 80, 25);		
		this.add(TARJETA_Label);		
		TARJETA_Text = new JTextField();		
		TARJETA_Text.setBounds(100, 70, 165, 25);		
		this.add(TARJETA_Text);
		this.add(Box.createRigidArea(new Dimension(5,5)));
		
		
		//////BOTON DE ACEPTAR/////
		botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(80, 160, 80, 25);
		botonAceptar.addActionListener(this);		
		this.add(botonAceptar);
		
		///////BOTON DE CANCELAR////////
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(170, 160, 90, 25);
		botonCancelar.addActionListener(this);			
		this.add(botonCancelar);
		
		
		
	}
	
	void iniciarventana(){
		
		this.setBounds(350, 100,300,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Modificar Cliente");
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object botonPulsado = e.getSource();
		
		if (botonPulsado == botonAceptar) {
			TCliente aux = null;
			if(!TARJETA_Text.getText().equals("") && !NOMBRE_Text.getText().equals("")) {
				aux = new TCliente(DNI_Text.getText(), TARJETA_Text.getText(), NOMBRE_Text.getText());
			}
			Controller.getInstance().action(aux, Evento.MODIFICAR_CLIENTE);
			
			removeBox();
			setVisible(false);
			
		}else if (botonPulsado == botonCancelar) {			
			setVisible(false);					
		}
		
		
		
	}
	
	public void removeBox() {
		DNI_Text.setText(null);
		TARJETA_Text.setText(null);
		NOMBRE_Text.setText(null);
	}
	

}
