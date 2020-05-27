package Presentacion.Cliente;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JOptionPane;
import javax.swing.JPanel;


import Controller.Evento;
import Negocio.SA.SAAbstractFactory;
import Presentacion.Vista.OperationsPanel;
import Presentacion.Vista.GUIFarmacia;
import Presentacion.Vista.IGUI;
import Presentacion.Vista.MostrarTodos;
import Presentacion.Vista.MostrarUno;

public class GUICliente extends JPanel implements ActionListener, IGUI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OperationsPanel OperationsPanel; 
	private MostrarTodos mostrarTodos; 
	private MostrarUno mostrarUno;
	
	
	
	public GUICliente(){
		
		this.setVisible(true);
		
		OperationsPanel = new OperationsPanel(GUIFarmacia.TAB_CLIENTE);
		mostrarTodos = new MostrarTodosClientes(GUIFarmacia.TAB_CLIENTE, null);
		mostrarUno = new MostrarUno(GUIFarmacia.TAB_CLIENTE);
		
		
		this.add(mostrarTodos, BorderLayout.NORTH);
		this.add(OperationsPanel, BorderLayout.EAST);
		this.add(mostrarUno,BorderLayout.WEST);
		
		OperationsPanel.getAltaBoton().addActionListener(this);
		OperationsPanel.getBajaBoton().addActionListener(this);
		OperationsPanel.getModificarBoton().addActionListener(this);
		

		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object botonPulsado = e.getSource();
		
		if (botonPulsado == OperationsPanel.getAltaBoton()) {
			new VentanaCrearCliente();
		}else if (botonPulsado == OperationsPanel.getBajaBoton()) {
			 new VentanaBajaCliente();
		}else if (botonPulsado == OperationsPanel.getModificarBoton()) {
			 new VentanaModificarCliente();
		}

		
	}
	
	@Override
	public void actualizar(Object data, Integer evento) {
		
		switch (evento) {
		
		case Evento.RES_ALTA_CLIENTE_OK:
			
			Integer idAlta = (Integer) data;
		
			JOptionPane.showMessageDialog(null,"Usuario creado con ID: " +idAlta.intValue());
			setVisible(true);
			mostrarUno.llenarCombo();
			
			mostrarTodos.update(SAAbstractFactory.getInstance().createSACliente().readAll());
			break;
			
		case Evento.RES_ALTA_CLIENTE_FAILED:
					
			JOptionPane.showMessageDialog(null,"No se ha podido crear al cliente ");
			setVisible(true);
			
			break;
			
			
		case Evento.RES_BAJA_CLIENTE_OK:
			
			Integer idBaja = (Integer) data;
			
			JOptionPane.showMessageDialog(null,"Usuario puesto a inactivo con ID: " + idBaja);
			setVisible(true);
			mostrarUno.llenarCombo();
			
			mostrarTodos.update(SAAbstractFactory.getInstance().createSACliente().readAll());
			break;
			
		case Evento.RES_BAJA_CLIENTE_FAILED:  
			
			JOptionPane.showMessageDialog(null,"No se ha podido poner a inactivo  al cliente ");
			setVisible(true);
			
			break;
			
		case Evento.RES_MODIFICAR_CLIENTE_OK:
			
			Integer idMod = (Integer) data;
			
			JOptionPane.showMessageDialog(null,"Modificado correctamente: " +idMod.intValue());
			setVisible(true);
			
			mostrarUno.llenarCombo();
			mostrarTodos.update(SAAbstractFactory.getInstance().createSACliente().readAll());
			
			break;
			
		case Evento.RES_MODIFICAR_CLIENTE_FAILED:
			
			
			JOptionPane.showMessageDialog(null,"No se ha podido modificar ");
			setVisible(true);
			
			break;
		case Evento.RES_MOSTRAR_CLIENTE_OK:
			
			mostrarUno.setInfo(data);
			
			break;
		case Evento.RES_MOSTRAR_CLIENTE_FAILED:

			JOptionPane.showMessageDialog(null,"No se ha podido mostrar al cliente ");
			setVisible(true);
			

			
			break;
		case Evento.RES_MOSTRAR_TODOS_CLIENTES_OK:
			
			mostrarTodos.update(data);
			
			break;
			
		case Evento.RES_MOSTRAR_TODOS_CLIENTES_FAILED:
			
			JOptionPane.showMessageDialog(null,"No se han podido mostrar todos los clientes ");
			setVisible(true);
			
			break;
		case Evento.RES_REACTIVAR_CLIENTE_OK:
			
			JOptionPane.showMessageDialog(null,"Cliente reactivado correctamente ");
			setVisible(true);
			mostrarUno.llenarCombo();
			
			mostrarTodos.update(SAAbstractFactory.getInstance().createSACliente().readAll());
			
			break;
			
		case Evento.DATOS_INCORRECTOS_CLIENTE: 
			String message = (String) data;			
			JOptionPane.showMessageDialog(null,message);
			setVisible(true);
			
			break;
		default:
			break;
		}
		
	}
	

}
