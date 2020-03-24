package Presentacion.Vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.List;

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
		
		this.setBounds(350, 100,800,600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());//comprobar 
		
		
		
		
		
	}



	public void initTabs(List<Object> guis) {
		tabs = new JTabbedPane();
		tabs.setTabPlacement(JTabbedPane.LEFT);// para poner los tabs arriba , en la srs estan en la izquierda
		
		tabs.addTab(TAB_CLIENTE, null, (GUICliente)guis.get(0),"Cliente");
		
		this.add(tabs, BorderLayout.CENTER);
		
		
		
		
		
	}
	
	
	

	
	
}
