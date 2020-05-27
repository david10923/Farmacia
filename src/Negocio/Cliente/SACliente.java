package Negocio.Cliente;


import java.util.List;

public interface SACliente {

	public int create (TCliente tCliente);
	public List<TCliente> readAll();
	public int update(TCliente tCliente);
	public int delete(String dni );
	public TCliente readById(int id);
}
