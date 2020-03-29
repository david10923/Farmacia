package Controller;

import java.util.ArrayList;
import java.util.List;

import Main.Main;
import Negocio.Cliente.SACliente;
import Negocio.Cliente.SAClienteImp;
import Presentacion.Cliente.GUICliente;
import Presentacion.Vista.GUIFarmacia;
import Presentacion.Vista.IGUI;
import Tranfers.TCliente;

public class ControllerImp extends Controller{
	
	
	private SACliente saCliente;
	
	private IGUI gui;
	private GUIFarmacia farmacia;
	
	
	public ControllerImp(){
		farmacia = new GUIFarmacia(Main.name);
		List<Object> guis = new ArrayList<>();
		guis.add(new GUICliente());	
		saCliente = new SAClienteImp();
		farmacia.initTabs(guis);
		//Añadir el resto de guis 
		
		
		
	}

	@Override
	public void action(Object data, Integer event) {
		switch(event){
		case Evento.ALTA_CLIENTE:{
			
			TCliente tCliente = (TCliente) data;
			
			int res = saCliente.create(tCliente);
			
			if (res>0) {
				farmacia.actualizar(res, Evento.RES_ALTA_CLIENTE_OK);
			}else {
				farmacia.actualizar(null, Evento.RES_ALTA_CLIENTE_FAILED);
			}
			
			
			break; 
			
		}
		case Evento.BAJA_CLIENTE:{
			
			break;
			
		}
		case Evento.MODIFICAR_CLIENTE:{
			
			
			break;
			
		}
		case Evento.MOSTRAR_CLIENTE:{
			
			
			break;
		}
		case Evento.MOSTRAR_TODOS_CLIENTES:{
			
			break;
		}
		
		
		}
		
		
		
	}

}
