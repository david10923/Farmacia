package Presentacion.Cliente;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.Controller;
import Controller.Evento;


public class VentanaBajaCliente extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel DNI_Label; 
	private JTextField DNI_Text;
	private JButton botonAceptar;
	private JButton botonCancelar;
	
	
	
	
	public VentanaBajaCliente() {
		

		iniciarventana();
		
		
		////////DNI////////
		DNI_Label = new JLabel("DNI: ");		
		DNI_Label.setBounds(10, 120, 165, 25);		
		this.add(DNI_Label);		
		DNI_Text = new JTextField();		
		DNI_Text.setBounds(100, 120, 165, 25);		
		this.add(DNI_Text);
		
		
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
		this.setTitle("Baja Cliente");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object botonPulsado = e.getSource();
		
		if (botonPulsado == botonAceptar) {
			
			String aux = DNI_Text.getText();
			
			Controller.getInstance().action(aux, Evento.BAJA_CLIENTE);			
			removeBox();
			setVisible(false);			
			
		}else if (botonPulsado == botonCancelar) {			
			setVisible(false);			
			
		}
		
		
	}
	
	public void removeBox() {
		DNI_Text.setText(null);
	}
	
}
