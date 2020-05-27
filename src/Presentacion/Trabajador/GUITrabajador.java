package Presentacion.Trabajador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controller.Evento;
import Negocio.Cliente.TCliente;
import Negocio.SA.SAAbstractFactory;
import Negocio.Trabajador.TTrabajador;
import Presentacion.Cliente.MostrarTodosClientes;
import Presentacion.Vista.GUIFarmacia;
import Presentacion.Vista.IGUI;
import Presentacion.Vista.MostrarTodos;
import Presentacion.Vista.MostrarUno;
import Presentacion.Vista.OperationsPanel;

public class GUITrabajador extends JPanel implements IGUI {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private OperationsPanel OperationsPanel; 
	private MostrarTodosTrabajadores mostrarTodos; 
	private MostrarUno mostrarUno;
	
	
	public GUITrabajador(){
		
		
		OperationsPanel = new OperationsPanel(GUIFarmacia.TAB_TRABAJADOR);
		mostrarTodos = new MostrarTodosTrabajadores(GUIFarmacia.TAB_TRABAJADOR, null);
		mostrarUno = new MostrarUno(GUIFarmacia.TAB_TRABAJADOR);
		
		this.add(mostrarTodos, BorderLayout.NORTH);
		this.add(OperationsPanel, BorderLayout.EAST);
		this.add(mostrarUno,BorderLayout.WEST);
		
		OperationsPanel.getAltaBoton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 new VentanaCrearTrabajador();
			}
			
		});
		OperationsPanel.getBajaBoton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaBajaTrabajador();
				
			}
			
		});
		OperationsPanel.getModificarBoton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaModificarTrabajador();				
			}
			
		});
		this.setVisible(true);
		
	}


	@Override
	public void actualizar(Object data, Integer evento) {
		
		switch (evento) {
		
		case Evento.RES_ALTA_TRABAJADOR_OK:
			
			Integer idAlta = (Integer) data;
		
			JOptionPane.showMessageDialog(null,"Usuario creado con ID: " +idAlta.intValue());
			setVisible(true);
			mostrarUno.llenarCombo();
			
			mostrarTodos.update(SAAbstractFactory.getInstance().createSATrabajador().readAll());
			break;
			
		case Evento.RES_ALTA_TRABAJADOR_FAILED:
					
			JOptionPane.showMessageDialog(null,"No se ha podido crear al trabajador ");
			setVisible(true);
			
			break;
			
			
		case Evento.RES_BAJA_TRABAJADOR_OK:
			
			Integer idBaja = (Integer) data;
			
			JOptionPane.showMessageDialog(null,"Usuario puesto a inactivo con ID: " + idBaja);
			setVisible(true);
			mostrarUno.llenarCombo();
			
			mostrarTodos.update(SAAbstractFactory.getInstance().createSATrabajador().readAll());
			break;
			
		case Evento.RES_BAJA_TRABAJADOR_FAILED: // revisar el mensaje // ver si hay que poner que ya estaba dado de baja 
			
			JOptionPane.showMessageDialog(null,"No se ha podido poner a inactivo  al trabajador ");
			setVisible(true);
			
			break;
			
		case Evento.RES_MODIFICAR_TRABAJADOR_OK:
			
			Integer idMod = (Integer) data;
			
			JOptionPane.showMessageDialog(null,"Modificado correctamente: " +idMod.intValue());
			setVisible(true);
			
			mostrarUno.llenarCombo();
			mostrarTodos.update(SAAbstractFactory.getInstance().createSATrabajador().readAll());
			
			break;
			
		case Evento.RES_MODIFICAR_TRABAJADOR_FAILED:
			
			
			JOptionPane.showMessageDialog(null,"No se ha podido modificar ");
			setVisible(true);
			
			break;
		case Evento.RES_MOSTRAR_TRABAJADOR_OK:
			
			mostrarUno.setInfo(data);
			
			break;
		case Evento.RES_MOSTRAR_TRABAJADOR_FAILED:
			
			JOptionPane.showMessageDialog(null,"No se ha podido mostrar el trabajador");
			
			
			break;
		case Evento.RES_MOSTRAR_TODOS_TRABAJADORES_OK:
			
			mostrarTodos.update(data);
			
			break;
			
		case Evento.RES_MOSTRAR_TODOS_TRABAJADORES_FAILED:
			
			JOptionPane.showMessageDialog(null,"No se han podido mostrar los trabajadores");
			
			break;
		case Evento.RES_REACTIVAR_TRABAJADOR_OK:
			
			JOptionPane.showMessageDialog(null,"Trabajador reactivado correctamente");
			setVisible(true);
			mostrarUno.llenarCombo();
			
			mostrarTodos.update(SAAbstractFactory.getInstance().createSATrabajador().readAll());
			
			break;
		case Evento.DATOS_INCORRECTOS_TRABAJADOR: 
			
			String message = (String) data;
			
			JOptionPane.showMessageDialog(null,message);
			setVisible(true);
			
			break;
		default:
			break;
		}
		
	}

}
