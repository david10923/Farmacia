package Integracion.DAOCliente;
import org.junit.*;
import org.junit.Assert;

import Integracion.DAO.DAOAbstractFactory;
import Integracion.DAOCliente.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

import Negocio.Cliente.TCliente;
import Negocio.SA.SAAbstractFactory;



public class TestDAOCliente {
	private static TCliente tcliente1 = new TCliente("12345678P","12345L","Pedro");
	private static TCliente tcliente2 = new TCliente("98765432Q","98745P","Juan");

	@Test 
	public void create() throws Exception{
		DAOClienteImp dao = new DAOClienteImp();
		
		int out_id = dao.create(tcliente1); 
		assertNotEquals(-1,out_id);
		assertEquals(1,out_id);
		
		int out_id2 = dao.create(tcliente2); 
		assertNotEquals(-1,out_id2);
		assertNotEquals(1,out_id2);
		
		
	}
	
	@Test
	public void update() throws Exception{
		DAOClienteImp dao = new DAOClienteImp();
		
		int out_idCreado = dao.create(tcliente1);
		tcliente1.setNombre("Clara");
		
		int out_idUpdated = dao.update(tcliente1, false); 
		assertEquals(out_idCreado,out_idUpdated);
		
	}
	
	@Test
	public void delete(){
		DAOClienteImp dao = new DAOClienteImp();
		
		int id_out = dao.delete(tcliente1.getCodigo());
		int id = tcliente1.getCodigo();
		
		assertEquals(id_out,id);
		
		
	}
	
	@Test
	public void readAll(){
		DAOClienteImp dao = new DAOClienteImp();
		ArrayList<TCliente> out_list = new ArrayList<TCliente>();
		ArrayList<TCliente> in_list = new ArrayList<TCliente>();
		
		tcliente1.setEstado(true);
		tcliente2.setEstado(true);
		
		dao.create(tcliente1);
		dao.create(tcliente2); 
		
		out_list = (ArrayList<TCliente>)dao.readAll();
		in_list.add(tcliente1); 
		in_list.add(tcliente2);
		
		for(int i =0 ; i < in_list.size();i++){
			iguales(in_list.get(i), out_list.get(i));
		}		
		
		
	}
	
	public void iguales(TCliente first,  TCliente second){
		assertEquals(first.getNombre(),second.getNombre());
		assertEquals(first.getDni(),second.getDni());
		assertEquals(first.getTarjetaSanitaria(),second.getTarjetaSanitaria());
		assertEquals(first.getCodigo(),second.getCodigo());
	}

	
	
	
}
