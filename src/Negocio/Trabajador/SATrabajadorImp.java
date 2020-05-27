package Negocio.Trabajador;

import java.util.List;

import Integracion.DAO.DAOAbstractFactory;

public class SATrabajadorImp implements SATrabajador {

	@Override
	public int create(TTrabajador trabajador) {		
		int id = -1, ok = -1;
		
		if(trabajador!= null){				
			TTrabajador aux =DAOAbstractFactory.getInstance().createDAOTrabajador().readByDNI(trabajador.getDni());
			
			if (aux ==null) {
				id = DAOAbstractFactory.getInstance().createDAOTrabajador().create(trabajador);
				
			}else if (aux !=null && !aux.isEstado()) {
				ok = DAOAbstractFactory.getInstance().createDAOTrabajador().update(aux,true);
				if(ok >= 0) id = 0; 
			}
		}	
		
		return id;
	}

	@Override
	public TTrabajador read(String nif) {
		
		return null; 
	}

	@Override
	public List<TTrabajador> readAll() {
		List<TTrabajador> aux = null;
		aux = DAOAbstractFactory.getInstance().createDAOTrabajador().readAll();
		return aux;
	}

	@Override
	public int update(TTrabajador trabajador) {
		int id = -1;

		TTrabajador aux = DAOAbstractFactory.getInstance().createDAOTrabajador().readByDNI(trabajador.getDni());
		
		if(trabajador.getDni().equals(aux.getDni())){ 
			trabajador.setCodigo(aux.getCodigo());
			id = DAOAbstractFactory.getInstance().createDAOTrabajador().update(trabajador,false);	
			
		}
			
		return id;
	}

	@Override
	public int delete(String dni) {
		int id = -1;
		
		if(dni!= null){ 			
			TTrabajador aux = DAOAbstractFactory.getInstance().createDAOTrabajador().readByDNI(dni);
			
			if (aux !=null) 					
				id = DAOAbstractFactory.getInstance().createDAOTrabajador().delete(aux.getCodigo());
		
		}
			
		return id;
	}

	@Override
	public TTrabajador readById(int id) {
		return DAOAbstractFactory.getInstance().createDAOTrabajador().readById(id);
	}
	
	

}
