package Integracion.DaoCliente;

import java.util.Collection;

import Tranfers.TCliente;

public interface DaoCliente {	
	
	public int create(TCliente tUsuario);
	public TCliente read(int id);
	public Collection<TCliente> readAll();
	public TCliente readByName(String nombre);
	public int update(TCliente tUsuario);
	public int delete (int id);

}
