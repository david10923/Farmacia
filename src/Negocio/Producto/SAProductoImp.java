package Negocio.Producto;

import java.util.List;

import Integracion.DAO.DAOAbstractFactory;
import Negocio.Laboratorio.TLaboratorio;

public class SAProductoImp implements SAProducto{

	@Override
	public int create(TProducto producto) {
		int codigo=-1;
		if(producto!=null) {
			
			TLaboratorio laboratorio=DAOAbstractFactory.getInstance().
					createDAOLaboratorio().readById(producto.getCodigoLaboratorio());
			if(laboratorio!=null && laboratorio.isEstado()) {
				
				TProducto productoAux=DAOAbstractFactory.getInstance().
						createDAOProducto().readByNombreYLaboratorio(producto.getNombre(), laboratorio.getCodigo());
				
				if(productoAux==null) {
					codigo=DAOAbstractFactory.getInstance().createDAOProducto().create(producto);
					producto.setCodigo(codigo);
					if(producto.isReceta()){
						DAOAbstractFactory.getInstance().createDAOProducto().createMedicamento((TMedicamento)producto);
					}
					else{
						DAOAbstractFactory.getInstance().createDAOProducto().createParafarmacia((TParafarmacia)producto);
					}
					
				}
				else if(productoAux!=null&&!productoAux.isEstado())	{
					producto.setCodigo(productoAux.getCodigo());
					int ok = DAOAbstractFactory.getInstance().createDAOProducto().update(producto, true);
					
					if(ok >= 0){
						if(producto.isReceta()){
							ok = DAOAbstractFactory.getInstance().createDAOProducto().createMedicamento(((TMedicamento)producto));
						}else{
							ok = DAOAbstractFactory.getInstance().createDAOProducto().createParafarmacia(((TParafarmacia)producto));
						}
					}
					if(ok >= 0){
						codigo = 0;
					}
					else{
						codigo = -1; 
					}

				}
				
			}
		}
			return codigo;
			
	}

	@Override
	public int delete(int tId) {
		int id = -1;
		
		if(tId!= 0){ 			
			TProducto aux = DAOAbstractFactory.getInstance().createDAOProducto().readById(tId);
			
			if (aux !=null) {
	
				id = DAOAbstractFactory.getInstance().createDAOProducto().delete(aux.getCodigo());
				
				if(id >= 0){
					if(aux.isReceta()) {
						DAOAbstractFactory.getInstance().createDAOProducto().deleteMedicamento(aux.getCodigo());
					}
					else {
						DAOAbstractFactory.getInstance().createDAOProducto().deleteParafarmacia(aux.getCodigo());
					}
				}	
			}
		}
			
		return id;
	}

	@Override
	public int update(TProducto producto) {
		int id = -1;
		
		
		TProducto aux = DAOAbstractFactory.getInstance().createDAOProducto().readById(producto.getCodigo());
		
		if (aux != null) {
			
			if(producto.getCodigo() == aux.getCodigo()){ 
				producto.setCodigo(aux.getCodigo());
				id = DAOAbstractFactory.getInstance().createDAOProducto().update(producto,false);	
			}
		}
		
		
			
		return id;
	}

	@Override
	public TProducto read(int id) {
		return DAOAbstractFactory.getInstance().createDAOProducto().readById(id);
	}

	@Override
	public List<TProducto> readAll() {
		return DAOAbstractFactory.getInstance().createDAOProducto().readAll();
	}
	
	public int bajaTodosProductosLaboratorio(int codigo) {
		return DAOAbstractFactory.getInstance().createDAOProducto().bajaTodosProductosLaboratorio(codigo);
		
	}

	@Override
	public int reactivarProductoslaboratorio(int codigo) {
		return DAOAbstractFactory.getInstance().createDAOProducto().reactivarProductoslaboratorio(codigo);
	}


}
