package Presentacion.Cliente;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Controller.Controller;
import Controller.Evento;
import Tranfers.TCliente;

public class VentanaCrearCliente extends JDialog implements ActionListener {
	
	JLabel DNI_Label;
	JTextField DNI_Text;
	JLabel TARJETA_Label;
	JTextField TARJETA_Text;
	JLabel NOMBRE_Label;
	JTextField NOMBRE_Text;
	JButton botonAceptar;
	JButton botonCancelar;
	
	public VentanaCrearCliente(){
		
		this.setBounds(350, 100,300,400);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setLayout(null);

		
		NOMBRE_Label = new JLabel("NOMBRE: ");
		
		NOMBRE_Label.setBounds(10, 120, 165, 25);
		
		this.add(NOMBRE_Label);
		
		NOMBRE_Text = new JTextField();
		
		NOMBRE_Text.setBounds(100, 120, 165, 25);
		
		this.add(NOMBRE_Text);
		
		DNI_Label = new JLabel("DNI: ");
		
		DNI_Label.setBounds(10, 20, 80, 25);
		
		this.add(DNI_Label);
		
		DNI_Text = new JTextField();
		
		DNI_Text.setBounds(100, 20, 165, 25);
		
		this.add(DNI_Text);
		
		TARJETA_Label = new JLabel("TARJETA SANITARIA: ");
		
		TARJETA_Label.setBounds(10, 70, 80, 25);
		
		this.add(TARJETA_Label);
		
		TARJETA_Text = new JTextField();
		
		TARJETA_Text.setBounds(100, 70, 165, 25);
		
		this.add(TARJETA_Text);

		this.add(Box.createRigidArea(new Dimension(5,5)));
		
		botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(80, 160, 80, 25);
		botonAceptar.addActionListener(this);
		
		this.add(botonAceptar);
		
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(170, 160, 90, 25);
		botonCancelar.addActionListener(this);		
		
		
		this.add(botonCancelar);
		
		this.setVisible(true);
		//iniciarventana();
	}
	
	void iniciarventana(){
		
		
		
		this.setBounds(350, 200, 70,70);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//salta exception aqui
		this.setLayout(new BorderLayout());
		this.setTitle("Alta Cliente");
		
		iniciarComponentes();
		
	}
	
	void iniciarComponentes(){
		JTextField id = new JTextField();
		JLabel etiquetaID = new JLabel ();
		this.add(etiquetaID);
		this.add(id);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object botonPulsado = e.getSource();
		
		if (botonPulsado == botonAceptar) {
			TCliente aux = new TCliente(DNI_Text.getText(), TARJETA_Text.getText(), NOMBRE_Text.getText());
			
			Controller.getInstance().action(aux, Evento.ALTA_CLIENTE);
			
			removeBox();
		}else if (botonPulsado == botonCancelar) {
			
			setVisible(false);
			
			dispose();
			
		}
		
		
		
	}
	
	public void removeBox() {
		DNI_Text.setText(null);
		TARJETA_Text.setText(null);
		NOMBRE_Text.setText(null);
	}
	

}
