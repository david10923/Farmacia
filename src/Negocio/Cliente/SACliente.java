package Negocio.Cliente;

import java.sql.SQLException;
import java.util.Collection;

import Tranfers.TCliente;

public interface SACliente {

	public int create (TCliente tCliente);
	public TCliente read(String nif);
	public Collection<TCliente> readAll();
	public int update(TCliente tCliente);
	public int delete(String dni );

}
