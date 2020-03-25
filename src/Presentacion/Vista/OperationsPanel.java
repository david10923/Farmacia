package Presentacion.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Presentacion.Cliente.VentanaCrearCliente;

public class OperationsPanel extends JPanel {

	private JButton altaBoton;
	private JButton bajaBoton;
	private JButton modificarBoton;
	private JComboBox <Object> seleccionarBox;
	
	
	private String nombreEntidad ;// hay que ver donde se dice que entidad es 
	
	
	public OperationsPanel(String name) {
		super();
		this.nombreEntidad = name.toUpperCase();
		initOperationPanel();
	}
	
	
	
	public void initOperationPanel() {	
			
		this.setLayout(new GridLayout());
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1), "Operations",
				TitledBorder.LEFT, TitledBorder.TOP));
		this.setPreferredSize(new Dimension(700, 250));
		
		
		this.setVisible(true);
		
		inicializarBotones();
	
	}
	
	
	public void inicializarBotones(){
		
		Box caja1 = Box.createHorizontalBox();	
		
		
		altaBoton      = new JButton("DAR DE ALTA");
		bajaBoton      = new JButton("DAR DE BAJA");
		modificarBoton = new JButton("MODIFICAR");
		seleccionarBox = new JComboBox<Object>();
		seleccionarBox.setMaximumSize(new Dimension(200,25));
		seleccionarBox.setMinimumSize(new Dimension(200,25));
	
			
		caja1.add(Box.createHorizontalStrut(20));
		caja1.add(altaBoton);
		caja1.add(Box.createHorizontalStrut(20));
		caja1.add(bajaBoton);
		caja1.add(Box.createHorizontalStrut(20));
		caja1.add(modificarBoton);		
		caja1.add(seleccionarBox);

		this.add(caja1);
	
		altaBoton.setVisible(true);
		bajaBoton.setVisible(true);
		modificarBoton.setVisible(true);
		
	
	
		
		
		
		
		
		
	}
	
	public void OperacionCrear(){
		this.altaBoton.addActionListener(new ActionListener(){ // si aqui ponemos el jDialog todos tienen que ser atributos de la clase 

			@Override
			public void actionPerformed(ActionEvent e) {
				switch(nombreEntidad){
				
					case "CLIENTE":{
						new VentanaCrearCliente();
						break;
						
					}
					case "PRODUCTO":{
						
					}
					case "TRABAJADOR":{
						
					}
					case "FACTURA":{
						
					}
					case "LABORATORIO":{
						
					}
				}
				
				
			}
			
		});
	}
	
	
	
	
}

