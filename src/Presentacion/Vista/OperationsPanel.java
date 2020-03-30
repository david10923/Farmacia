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
	
	
	public OperationsPanel(String name) {
		super();
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

			
		caja1.add(Box.createHorizontalStrut(20));
		caja1.add(altaBoton);
		caja1.add(Box.createHorizontalStrut(20));
		caja1.add(bajaBoton);
		caja1.add(Box.createHorizontalStrut(20));
		caja1.add(modificarBoton);		


		this.add(caja1);
	
		altaBoton.setVisible(true);
		bajaBoton.setVisible(true);
		modificarBoton.setVisible(true);

		
	}
	


	public JButton getAltaBoton() {
		return altaBoton;
	}



	public JButton getBajaBoton() {
		return bajaBoton;
	}


	public JButton getModificarBoton() {
		return modificarBoton;
	}



	
}

