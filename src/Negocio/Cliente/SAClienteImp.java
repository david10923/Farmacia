package Negocio.Cliente;

import java.util.Collection;

import Integracion.DaoCliente.DaoCliente;
import Tranfers.TCliente;

public class SAClienteImp implements SACliente{
	
	
	public SAClienteImp(){
		
	}

	@Override
	public int create(TCliente tCliente) {
		int id = -1; // nose si es esto o el evento 
		
		DaoCliente daoCliente;
		
		if(tCliente!= null){
		//	TCliente leido ; Hacer un readByNif en daoCliente
			
		}
		
		
		return 0;
	}

	@Override
	public TCliente read(int id) {
		
		return null;
	}

	@Override
	public Collection<TCliente> readAll() {
		

		return null;
	}

	@Override
	public int update(TCliente tCliente) {
		
		
		return 0;
	}

	@Override
	public int delete(int id) {
		
		
		return 0;
	}
	

}
