package Negocio.Cliente;


import java.util.List;
import Integracion.DAO.DAOAbstractFactory;

public class SAClienteImp implements SACliente{
	
	
	public SAClienteImp(){
		
	}
	
	@Override
	public int create(TCliente cliente) {
		int id = -1;  
		

		
		if(cliente!= null){
			
			TCliente aux =DAOAbstractFactory.getInstance().createDAOCliente().readByDNI(cliente.getDni());
			
			if (aux ==null) {
				id = DAOAbstractFactory.getInstance().createDAOCliente().create(cliente);
			}else if (aux !=null && !aux.isEstado()) {
				DAOAbstractFactory.getInstance().createDAOCliente().update(aux,true);
				id = 0;
				
			}
		}
		
		
		return id;
	}



	@Override
	public List<TCliente> readAll() {
		List<TCliente> aux = null;
		aux = DAOAbstractFactory.getInstance().createDAOCliente().readAll();
		return aux;
	}

	@Override
	public int update(TCliente tCliente) {
		int id = -1;

		TCliente aux = DAOAbstractFactory.getInstance().createDAOCliente().readByDNI(tCliente.getDni());
		if(aux != null) {
			if(tCliente.getDni().equals(aux.getDni())){ 
				tCliente.setCodigo(aux.getCodigo());
				id = DAOAbstractFactory.getInstance().createDAOCliente().update(tCliente,false);	
			}
		}
		return id;
	}

	@Override
	public int delete(String dni) {
		int id = -1;


		
		if(dni!= null){ 
			
			TCliente aux = DAOAbstractFactory.getInstance().createDAOCliente().readByDNI(dni);
			
			if (aux !=null) {
				
				
				id = DAOAbstractFactory.getInstance().createDAOCliente().delete(aux.getCodigo());

			}
			
		}
			
		return id;
		
	}

	@Override
	public TCliente readById(int id) {
		
		return DAOAbstractFactory.getInstance().createDAOCliente().readById(id);
	}
	

}
