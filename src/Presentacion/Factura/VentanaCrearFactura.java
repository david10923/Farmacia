package Presentacion.Factura;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Controller;
import Controller.Evento;
import Negocio.Factura.TFactura;

public class VentanaCrearFactura extends JDialog{
	
private static final long serialVersionUID = 1L;
	
	private JLabel CODIGOCLIENTE_Label;
	private JTextField CODIGOCLIENTE_Text;
	
	private JLabel CODIGOTRABAJADOR_Label;
	private JTextField CODIGOTRABAJADOR_Text;	
	
	
	private JButton botonAceptar;
	private JButton botonCancelar;
	JPanel mainPanel;
	
	public VentanaCrearFactura(){
		this.setTitle("Crear Factura");
		mainPanel = new JPanel();
		this.setContentPane(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.setBounds(550, 200,300,200);
		inicializaVentana();
		this.setVisible(true);
		
	}
	
	
	private void inicializaVentana(){
		
		JPanel clientePanel = new JPanel();
		clientePanel.setSize(300, 100);
		clientePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		CODIGOCLIENTE_Label    = new JLabel("Codigo Cliente: ");
		CODIGOCLIENTE_Text     = new JTextField(20);
		clientePanel.add(CODIGOCLIENTE_Label);
		clientePanel.add(CODIGOCLIENTE_Text);
		JPanel trabajadorPanel = new JPanel();
		trabajadorPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		CODIGOTRABAJADOR_Label = new JLabel("Codigo Trabajador: ");
		CODIGOTRABAJADOR_Text  = new JTextField(20);
		trabajadorPanel.add(CODIGOTRABAJADOR_Label);
		trabajadorPanel.add(CODIGOTRABAJADOR_Text);
		JPanel botonesPanel = new JPanel();
		botonesPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		botonAceptar  = new JButton("OK");
		botonAceptar.setSize(25,  15);
		botonCancelar = new JButton("CANCEL");
		botonCancelar.setSize(25, 15);
		botonesPanel.add(botonAceptar);
		botonesPanel.add(botonCancelar);
		
		mainPanel.add(clientePanel);
		mainPanel.add(trabajadorPanel);
		mainPanel.add(botonesPanel);
		
		botonAceptar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {			
				
				
				if(!CODIGOCLIENTE_Text.getText().equals("") && !CODIGOTRABAJADOR_Text.getText().equals("") ){
						TFactura aux = new TFactura(Integer.parseInt(CODIGOCLIENTE_Text.getText()), 
								Integer.parseInt(CODIGOTRABAJADOR_Text.getText()));
								
			
			
			
					Controller.getInstance().action(aux, Evento.CREAR_FACTURA);
					setVisible(false);
					removeBox();
	
					
				}else{
					Controller.getInstance().action("Debes introducir datos", Evento.DATOS_INCORRECTOS_FACTURA);
				}
				
				
			}
			
		});
		
		botonCancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				removeBox();
			}
			
		});
		
	}
	
	private void removeBox() {
		CODIGOCLIENTE_Text.setText(null);
		CODIGOTRABAJADOR_Text.setText(null);
	}

}
