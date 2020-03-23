package Controller;

import Presentacion.Vista.GUIFarmacia;
import Presentacion.Vista.IGUI;
import Tranfers.TCliente;

public class ControllerImp extends Controller{
	
	private IGUI igui;
	private GUIFarmacia farmacia;

	
	
	
	public ControllerImp(){
		
	}

	@Override
	public void action(Object data, Integer event) {
		switch(event){
		case Evento.ALTA_CLIENTE:{
			TCliente tCliente = (TCliente) data;
			
			
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
