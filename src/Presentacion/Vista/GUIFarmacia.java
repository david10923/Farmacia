package Presentacion.Vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Controller.Controller;
import Controller.Evento;
import Presentacion.Cliente.GUICliente;
import Presentacion.Factura.GUIFactura;
import Presentacion.Laboratorio.GUILaboratorio;
import Presentacion.Producto.GUIProducto;
import Presentacion.Trabajador.GUITrabajador;


public class GUIFarmacia extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static String TAB_PROVEEDOR = "Proveedor";
	public static String TAB_CLIENTE = "Cliente";
	public static String TAB_TRABAJADOR = "Trabajador";
	public static String TAB_FACTURA = "Factura";
	public static String TAB_LABORATORIO = "Laboratorio";
	public static String TAB_PRODUCTO = "Producto";

	private JTabbedPane tabs;

	public GUIFarmacia(String info) {
		super(info);
		initGui();

	}

	public void initGui() {

		this.setBounds(350, 100, 900, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());// comprobar

	}

	public IGUI getIGUI(int x) {
		return (IGUI) tabs.getComponent(x);
	}

	public void initTabs(List<Object> guis) {
		tabs = new JTabbedPane();
		tabs.setTabPlacement(JTabbedPane.LEFT);// para poner los tabs arriba , en la srs estan en la izquierda
		
		tabs.addTab("General", (VistaGeneral)guis.get(0));
		tabs.addTab(TAB_CLIENTE, null, (GUICliente)guis.get(1),"Cliente");
		tabs.addTab(TAB_TRABAJADOR, null , (GUITrabajador)guis.get(2),"Trabajador");
		tabs.addTab(TAB_LABORATORIO, null , (GUILaboratorio)guis.get(3),"Laboratorio");
		tabs.addTab(TAB_PRODUCTO, null, (GUIProducto)guis.get(4), "Producto");
		tabs.addTab(TAB_FACTURA,null,(GUIFactura)guis.get(5),"Factura");
		
		this.add(tabs, BorderLayout.CENTER);
		

		
		test();
		
	}

	public void test() {
		
		tabs.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				switch(tabs.getSelectedIndex()) {
				case 1:
					Controller.getInstance().action(null, Evento.MOSTRAR_TODOS_CLIENTES);
				break;
				case 2:
					Controller.getInstance().action(null, Evento.MOSTRAR_TODOS_TRABAJADORES);
					break;
				case 3:
					Controller.getInstance().action(null, Evento.MOSTRAR_TODOS_LABORATORIOS);
					break;
				case 4:
					Controller.getInstance().action(null, Evento.MOSTRAR_TODOS_PRODUCTOS);
					
					break;
				case 5:
					Controller.getInstance().action(null ,Evento.MOSTRAR_TODOS_FACTURAS);
					break;
				}
			}
					
		});

	}
	
}
