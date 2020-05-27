package Integracion.DAOCliente;


import java.util.List;

import Negocio.Cliente.TCliente;

public interface DAOCliente {	
	
	public int create(TCliente tUsuario);
	public TCliente read(String nif);
	public List<TCliente> readAll();
	public TCliente readByDNI(String nombre);
	public int update(TCliente tUsuario, boolean reactivar);
	public int delete (int codigo);
	public TCliente readById(int id);

}
