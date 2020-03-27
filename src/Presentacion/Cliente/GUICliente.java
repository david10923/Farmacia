package Presentacion.Cliente;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;

import Presentacion.Vista.OperationsPanel;
import Presentacion.Vista.GUIFarmacia;
import Presentacion.Vista.MostrarTodos;
import Presentacion.Vista.MostrarUno;

public class GUICliente extends JPanel implements ActionListener {
	
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
		
		OperationsPanel.getAltaBoton().addActionListener(this);
		OperationsPanel.getBajaBoton().addActionListener(this);
		OperationsPanel.getModificarBoton().addActionListener(this);
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		//this.setVisible(false);
		
		Object botonPulsado = e.getSource();
		
		if (botonPulsado == OperationsPanel.getAltaBoton()) {
			VentanaCrearCliente addClient = new VentanaCrearCliente();
		}else if (botonPulsado == OperationsPanel.getBajaBoton()) {
			VentanaBajaCliente bajaClient = new VentanaBajaCliente();
		}else if (botonPulsado == OperationsPanel.getModificarBoton()) {
			VentanaModificarCliente modCliente = new VentanaModificarCliente();
		}
		
		
		
		//System.out.println("eoeoeoeooeoe");
		
	}
	
	
	

}
