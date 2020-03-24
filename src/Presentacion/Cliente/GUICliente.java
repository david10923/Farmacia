package Presentacion.Cliente;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;

import Presentacion.Vista.OperationsPanel;

public class GUICliente extends JPanel {
	
	private OperationsPanel operationsPanel; 
	private JPanel showAll; 
	private JPanel show;
	
	
	
	public GUICliente(){
		
		this.setVisible(true);
		operationsPanel = new OperationsPanel();
		this.add(operationsPanel, BorderLayout.NORTH);
		
	
	}
	
	
	

}
