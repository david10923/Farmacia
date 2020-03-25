package Presentacion.Cliente;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;

import Presentacion.Vista.OperationsPanel;
import Presentacion.Vista.GUIFarmacia;
import Presentacion.Vista.MostrarTodos;
import Presentacion.Vista.MostrarUno;

public class GUICliente extends JPanel {
	
	private OperationsPanel OperationsPanel; 
	private JPanel MostrarTodos; 
	private JPanel MostrarUno;
	
	
	
	public GUICliente(){
		
		this.setVisible(true);
		OperationsPanel = new OperationsPanel(GUIFarmacia.TAB_CLIENTE);
		MostrarTodos = new MostrarTodos();
		MostrarUno = new MostrarUno();
		
		this.add(OperationsPanel, BorderLayout.NORTH);
		this.add(MostrarTodos, BorderLayout.EAST);
		this.add(MostrarUno,BorderLayout.WEST);
		
	
	}
	
	
	

}
