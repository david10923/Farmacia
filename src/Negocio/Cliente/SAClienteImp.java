package Negocio.Cliente;

import java.sql.SQLException;
import java.util.Collection;

import Integracion.DAOCliente.DAOCliente;
import Integracion.DAOCliente.DAOClienteImp;
import Tranfers.TCliente;

public class SAClienteImp implements SACliente{
	
	
	public SAClienteImp(){
		
	}
	
	@Override
	public int create(TCliente cliente) {
		int id = -1; // nose si es esto o el evento 
		
		DAOCliente daoCliente = new DAOClienteImp();
		
		if(cliente!= null){
		//	TCliente leido ; Hacer un readByNif en daoCliente
			
			TCliente aux = daoCliente.readByDNI(cliente.getDni());
			if (aux ==null) {
				id = daoCliente.create(cliente);
			}
		}
		
		
		return id;
	}

	@Override
	public TCliente read(String nif) {
		
		return null;
	}

	@Override
	public Collection<TCliente> readAll() {
		

		return null;
	}

	@Override
	public int update(TCliente tCliente) {
		int id = -1;

		
		DAOCliente daoCliente = new DAOClienteImp();
		TCliente aux = daoCliente.readByDNI(tCliente.getDni());
		
		if(tCliente.getDni().equals(aux.getDni())){ 

			id = daoCliente.update(tCliente);	
			
		}
			
		return id;
	}

	@Override
	public int delete(String dni) {
		int id = -1;

		
		DAOCliente daoCliente = new DAOClienteImp();
		
		if(dni!= null){ 
			
			TCliente aux = daoCliente.readByDNI(dni);
			
			if (aux !=null) {
				
				
				id = daoCliente.delete(dni);

			}
			
		}
			
		return id;
		
	}
	

}
