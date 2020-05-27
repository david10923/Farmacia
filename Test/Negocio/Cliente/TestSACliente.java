package Negocio.Cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import Negocio.SA.SAAbstractFactory;


public class TestSACliente {

	
	private SACliente sa = SAAbstractFactory.getInstance().createSACliente();
	
	
	@Test
	public void testCreateClienteOk(){
		TCliente c = new TCliente("12345679A", "aaa4" ,"David");
		assertEquals(8, sa.create(c)); // espero el 3 de la bd 
	}
	
	@Test
	public void testCreateClienteFail(){
		TCliente c = new TCliente();
		assertNotEquals(1, sa.create(c));
		
		c = new TCliente("","25695482P","657894523");
		assertNotEquals(1,sa.create(c));
		
		c = new TCliente("David",null,"657894523");
		assertNotEquals(1,sa.create(c));
		
		c = new TCliente("David","25695482P","6562321");
		assertNotEquals(1,sa.create(c));
		
		assertNotEquals(1, sa.create(c));
	}
	@Test
	public void testDeleteClienteOk(){
		//existe y esta activo 
		assertEquals(8,sa.delete("12345679A"));	
		
	}
	
	@Test
	public void testDeleteClienteFailed(){
		// si no existe 
		assertNotEquals(1,sa.delete("11111111A"));
		// existe y no esta activo 
		assertNotEquals(1,sa.delete("23456789B"));
		// le pasas mal los datos 
		assertNotEquals(1,sa.delete(null));
	}
	
	
	@Test
	public void testUpdateClienteOk(){
		//cliente existe y activo y validez 
		TCliente c = new TCliente("12345679A", "aaa34" ,"David");
		c.setEstado(true);
		assertEquals(8,sa.update(c));
		 c.setNombre("Davida");
		assertEquals(8,sa.update(c));
	}
	
	@Test
	public void testUpdateClienteFail(){
		TCliente c = new TCliente("12345679A", "David", "657894523");
		c.setEstado(false);
		c.setCodigo(20);
		 
		//cliente incorrecto 
		//assertEquals(1 ,sa.update(null));
		/// no es el cliente indicado 
		assertEquals(8,sa.update(c));
		
		//invalidez Sintactica
		c.setNombre("");
		assertEquals(8,sa.update(c));
		
		c.setNombre("JUANNNNN");
		assertEquals(8,sa.update(c));
	}
	
	@Test
	public void testReadClienteOk(){
		TCliente c = new TCliente("12345679A", "Davida" ,"aaa34");
		c.setCodigo(8);
		c.setEstado(true);
		assertEquals(c.toString() ,(sa.readById(c.getCodigo()).toString()));
	}
	
	public void testReadClienteFailed(){
		TCliente c = new TCliente("56932456P", "Ss", "657894523");
		c.setCodigo(3);
		c.setEstado(true);
		assertNotEquals(c ,(sa.readById(c.getCodigo())));
		assertNotEquals(c ,sa.readById(-1));
	}
	
}
