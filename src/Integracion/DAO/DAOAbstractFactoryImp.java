package Integracion.DAO;

import Integracion.DAOCliente.DAOClienteImp;
import Integracion.DAOContiene.DAOContiene;
import Integracion.DAOContiene.DAOContieneImp;
import Integracion.DAOFactura.DAOFactura;
import Integracion.DAOFactura.DAOFacturaImp;
import Integracion.DAOLaboratorio.DAOLaboratorioImp;
import Integracion.DAOProducto.DAOProducto;
import Integracion.DAOProducto.DAOProductoImp;
import Integracion.DAOTrabajador.DAOTrabajador;
import Integracion.DAOTrabajador.DAOTrabajadorImp;

public class DAOAbstractFactoryImp extends DAOAbstractFactory{

	
	@Override
	public DAOClienteImp createDAOCliente() {

		return new DAOClienteImp();
	}

	@Override
	public DAOTrabajador createDAOTrabajador() {
		return new DAOTrabajadorImp();
	}

	
	public DAOLaboratorioImp createDAOLaboratorio() {

		return new DAOLaboratorioImp();
	}

	@Override
	public DAOProducto createDAOProducto() {
		return new DAOProductoImp();
	}

	@Override
	public DAOFactura createDAOFactura() {
		return new DAOFacturaImp();
	}
	
	public DAOContiene createDAOContiene() {
		return new DAOContieneImp();
	}
	
}
