package Negocio.Laboratorio;

import java.util.List;

import Controller.Controller;
import Controller.Evento;
import Integracion.DAO.DAOAbstractFactory;
import Negocio.Producto.TProducto;


public class SALaboratorioImp implements SALaboratorio {

	@Override
	public int create(TLaboratorio tLaboratorio) {		
		int id = -1, ok = 0; 
		
		if(tLaboratorio!= null){		
			
			TLaboratorio aux =DAOAbstractFactory.getInstance().createDAOLaboratorio().readByName(tLaboratorio.getNombre());
			
			if (aux ==null) {
				id = DAOAbstractFactory.getInstance().createDAOLaboratorio().create(tLaboratorio);
			}else if (aux !=null && !aux.isEstado()) {
				ok = DAOAbstractFactory.getInstance().createDAOLaboratorio().update(aux,true);
				if (ok > 0) {
					Controller.getInstance().action(aux.getCodigo(), Evento.REACTIVAR_PRODUCTOS_LABORATORIO);
					id = 0;
				}
				
			
			}
		}	
		
		return id;
	}


	@Override
	public List<TLaboratorio> readAll() {
		List<TLaboratorio> aux = null;
		aux = DAOAbstractFactory.getInstance().createDAOLaboratorio().readAll();
		return aux;
	}

	@Override
	public int update(TLaboratorio laboratorio) {
		int id = -1;

		TLaboratorio aux = DAOAbstractFactory.getInstance().createDAOLaboratorio().readById(laboratorio.getCodigo());
		
		if (aux != null && aux.isEstado()) {
			
			if(laboratorio.getCodigo() == aux.getCodigo()){ 

				laboratorio.setCodigo(aux.getCodigo());
				id = DAOAbstractFactory.getInstance().createDAOLaboratorio().update(laboratorio,false);	
				
			}
		}
		
			
		return id;
	}

	@Override
	public int delete(int tId) {
		int id = -1;
		
		if(tId!= 0){ 			
			TLaboratorio aux = DAOAbstractFactory.getInstance().createDAOLaboratorio().readById(tId);
			
			if (aux !=null) 					
				id = DAOAbstractFactory.getInstance().createDAOLaboratorio().delete(aux.getCodigo());
		
		}
			
		return id;
	}

	@Override
	public TLaboratorio readByName(String name) {
		return DAOAbstractFactory.getInstance().createDAOLaboratorio().readByName(name);
	}
	
	
	public String readProductosLaboratorio(int idLaboratorio){
		
		List<TProducto> aux = DAOAbstractFactory.getInstance().createDAOLaboratorio().readProductosLaboratorio(idLaboratorio);
		
		StringBuilder sb = new StringBuilder();
		
		for (TProducto nuevo : aux) {
			sb.append(nuevo.toAlterString());
		}
		
		return sb.toString();
		
	}


	@Override
	public TLaboratorio readById(int id) {

		return DAOAbstractFactory.getInstance().createDAOLaboratorio().readById(id);
	}	

}
