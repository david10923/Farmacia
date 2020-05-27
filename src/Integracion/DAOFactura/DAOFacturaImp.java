package Integracion.DAOFactura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Integracion.Conexion.Conexion;
import Integracion.DAO.DAOAbstractFactory;
import Negocio.Factura.TCarrito;
import Negocio.Factura.TFactura;
import Negocio.Factura.TFacturaConProductos;

public class DAOFacturaImp extends Conexion implements DAOFactura {

	@Override
	public TCarrito create(TCarrito carrito) {
		Connection con = null;
		String query = "INSERT INTO factura(CODIGO_TRABAJADOR,CODIGO_CLIENTE) VALUES(?,?)";
		
		try {
			
			con = this.performConnection();	
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1,carrito.gettFactura().getCodigoTrabajador());
			ps.setInt(2, carrito.gettFactura().getCodigoCliente());
			
			ps.executeUpdate();
			ResultSet res = ps.getGeneratedKeys();
			
			if (res.next()) {
				carrito.setCodigoFactura(res.getInt(1));
			}
			con.close();
			
		}catch (SQLException e) {
			System.out.println("No se ha podido crear");
		}
		
		return carrito;
	}

	@Override
	public TCarrito read(int codigo) {
		Connection con = null;
		TCarrito aux = null;
		
		String query = "SELECT * FROM factura WHERE CODIGO_FACTURA=?";
		
		try {
			con = this.performConnection();	
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, codigo);
			
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				aux = new TCarrito();
				
				aux.gettFactura().setCodigo(res.getInt(1));
				aux.gettFactura().setCodigoTrabajador(res.getInt(2));
				aux.gettFactura().setCodigoCliente(res.getInt(3));
				aux.gettFactura().setFecha(res.getString(4));
				aux.gettFactura().setPrecioTotal(res.getDouble(5));
				aux.gettFactura().setEstado(res.getBoolean(6));			
			}
			con.close();
			
		}catch (Exception e) {
			System.out.println("");
		}
		
		return aux;
	
	}

	@Override
	public int delete(int codigo) {	
		int id = -1;
		
		Connection con = null; 
		try {
			
			con = this.performConnection();	
			PreparedStatement ps = con.prepareStatement("UPDATE factura SET estado=(?) WHERE CODIGO_FACTURA=(?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setBoolean(1, false);
			ps.setInt(2, codigo);
			int res = ps.executeUpdate();
		
			if(res > 0) {
				id = codigo;
			}
			con.close();
			
		} catch (SQLException e) {

		}
		return id;
		
		
	}

	@Override
	public int update(TFactura factura) {
		
		int id = -1;

		Connection con = null; 
		try {
			
			con = this.performConnection();
			
			PreparedStatement ps = con.prepareStatement("UPDATE factura SET FECHA=(SELECT SYSDATE()), PRECIO_TOTAL=?, ESTADO=? "
					+ " WHERE CODIGO_FACTURA=?", PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setDouble(1, factura.getPrecioTotal());	
			ps.setBoolean(2, true);
			ps.setInt(3, factura.getCodigo());
			int res = ps.executeUpdate();
		
			if(res > 0) {
				
				id = factura.getCodigo();
			}
			con.close();
			
		} catch (SQLException e) {

		}
		return id;
		
	}

	@Override
	public TFactura readByCodigo(int codigo) {
		
		Connection con = null;
		TFactura aux = null;
		
		String query = "SELECT * FROM factura WHERE CODIGO_FACTURA=?";
		
		try {
			con = this.performConnection();	
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, codigo);
			
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				aux = new TFactura();
				aux.setCodigo(res.getInt(1));
				aux.setCodigoTrabajador(res.getInt(2));
				aux.setCodigoCliente(res.getInt(3));
				aux.setFecha(res.getString(4));
				aux.setPrecioTotal(res.getDouble(5));
				aux.setEstado(res.getBoolean(6));			
			}
			con.close();
			
		}catch (Exception e) {
			System.out.println("");
		}
		
		return aux;
	
	}

	@Override
	public List<TFactura> readAll() {
		TFactura aux = null;
		List<TFactura> list = new ArrayList<TFactura>();
		
		Connection con = null;
		try {
			con = this.performConnection();	
			PreparedStatement ps = con.prepareStatement("select * from factura", PreparedStatement.RETURN_GENERATED_KEYS);
			
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				aux = new TFactura();
				aux.setCodigo(res.getInt(1));
				aux.setCodigoTrabajador(res.getInt(2));
				aux.setCodigoCliente(res.getInt(3));
				aux.setFecha(res.getString(4));
				aux.setPrecioTotal(res.getDouble(5));
				aux.setEstado(res.getBoolean(6));	
				list.add(aux);
			}
			
		} catch (Exception e) {
			list.clear();
			System.out.println("No lee todas las facturas");
		}
		
		return list;
		
	}

	@Override
	public TFacturaConProductos readFacturaConProductos(int codigo) {		
		
		TFacturaConProductos aux = new TFacturaConProductos();
		aux.settContiene(DAOAbstractFactory.getInstance().createDAOContiene().readById(codigo));
		
		
		return aux;
		
	}
	


	
	

}
