package Presentacion.Vista;

import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import Presentacion.Cliente.GUICliente;

public class GUIFarmacia extends JFrame{
	
	public static String TAB_PROVEEDOR = "Proveedor";
	public static String TAB_CLIENTE = "Cliente";
	public static String TAB_TRABAJADOR = "Trabajador";
	public static String TAB_FACTURA = "Factura";
	public static String TAB_LABORATORIO= "Laboratorio";
	public static String TAB_PRODUCTO = "Producto";
	
	private JTabbedPane tabs;
	
	public GUIFarmacia(String info){
		super(info);
		initGui();
	}



	public void initGui() {
		
		this.setBounds(450,450,400,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		
		
		
		
		
		
	}
	
	
	

	
	
}
