package Integracion.DAOCliente;

import java.sql.SQLException;
import java.util.Collection;

import Tranfers.TCliente;

public interface DAOCliente {	
	
	public int create(TCliente tUsuario);
	public TCliente read(int id);
	public Collection<TCliente> readAll();
	public TCliente readByDNI(String nombre);
	public int update(TCliente tUsuario);
	public int delete (int id);

}
