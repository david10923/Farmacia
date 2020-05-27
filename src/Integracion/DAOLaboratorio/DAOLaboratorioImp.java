package Integracion.DAOLaboratorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Integracion.Conexion.Conexion;
import Negocio.Laboratorio.TLaboratorio;
import Negocio.Producto.TProducto;


public class DAOLaboratorioImp extends Conexion implements DAOLaboratorio {
	
	

	@Override
	public int create(TLaboratorio tLaboratorio) {
		Connection con = null;
		int id = -1;
		String query = "INSERT INTO laboratorio(NOMBRE, TELEFONO, DIRECCION, ESTADO) VALUES(?,?,?,?)";
		
		try {
			con = this.performConnection();	
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, tLaboratorio.getNombre());
			ps.setString(2, tLaboratorio.getTelefono());
			ps.setString(3, tLaboratorio.getDireccion());
			ps.setBoolean(4, true);
			ps.executeUpdate();
			ResultSet res = ps.getGeneratedKeys();
			
			if (res.next()) {
				id = res.getInt(1);
			}
			con.close();
			
		}catch (SQLException e) {
			System.out.println("No se ha podido crear");
		}
		
		return id;
	}

	@Override
	public List<TLaboratorio> readAll() {
		List<TLaboratorio> list = new ArrayList<TLaboratorio>();
		
		Connection con = null;
		try {
			con = this.performConnection();	
			PreparedStatement ps = con.prepareStatement("select * from laboratorio ", PreparedStatement.RETURN_GENERATED_KEYS);
			
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				TLaboratorio aux = new TLaboratorio();

				aux.setCodigo(res.getInt(1));
				aux.setNombre(res.getString(2));
				aux.setTelefono(res.getString(3));
				aux.setDireccion(res.getString(4));
				aux.setEstado(res.getBoolean(5));
				list.add(aux);
			}
			
		} catch (Exception e) {
			list.clear();
		}
		
		return list;
		
	}

	@Override
	public TLaboratorio readById(int id) {
		Connection con = null;
		TLaboratorio aux = null;
		
		String query = "SELECT * FROM laboratorio WHERE CODIGO_LABORATORIO=?";
		
		try {
			con = this.performConnection();	
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);
			
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				aux = new TLaboratorio();
				aux.setCodigo(res.getInt(1));
				aux.setNombre(res.getString(2));
				aux.setTelefono(res.getString(3));
				aux.setDireccion(res.getString(4));
				aux.setEstado(res.getBoolean(5));
			
			}
			con.close();
			
		}catch (Exception e) {
			System.out.println("");
		}
		
		return aux;
	}
	
	public TLaboratorio readByName(String name) {
		
		Connection con = null;
		TLaboratorio aux = null;
		
		String query = "SELECT * FROM laboratorio WHERE NOMBRE=?";
		
		try {
			con = this.performConnection();	
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, name);
			
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				aux = new TLaboratorio();
				aux.setCodigo(res.getInt(1));
				aux.setNombre(res.getString(2));
				aux.setTelefono(res.getString(3));
				aux.setDireccion(res.getString(4));
				aux.setEstado(res.getBoolean(5));
			
			}
			con.close();
			
		}catch (Exception e) {
			System.out.println("");
		}
		
		return aux;
	}
	

	@Override
	public int update(TLaboratorio tLaboratorio, boolean reactivar) {
		int id = -1,res;

		Connection con = null; 
		try {
			if(!reactivar){
				con = this.performConnection();
				PreparedStatement ps = con.prepareStatement("UPDATE laboratorio SET NOMBRE=?, TELEFONO=?, DIRECCION=? "
						+ " WHERE CODIGO_LABORATORIO=?", PreparedStatement.RETURN_GENERATED_KEYS);
				
				ps.setString(1, tLaboratorio.getNombre());
				ps.setString(2, tLaboratorio.getTelefono());
				ps.setString(3, tLaboratorio.getDireccion());
				ps.setInt(4, tLaboratorio.getCodigo());
				
				 res = ps.executeUpdate();
				
			}else{
				con = this.performConnection();
				PreparedStatement ps = con.prepareStatement("UPDATE laboratorio SET ESTADO=?"
						+ " WHERE CODIGO_LABORATORIO=?", PreparedStatement.RETURN_GENERATED_KEYS);				
				
				ps.setBoolean(1, true);
				ps.setInt(2, tLaboratorio.getCodigo());
				
				 res = ps.executeUpdate();
				
			}
			
		
			if(res > 0) {
				
				id = tLaboratorio.getCodigo();
			}
			con.close();
			
		} catch (SQLException e) {

		}
		return id;
		
	}

	@Override
	public int delete(int codigo) {
		int id = -1;
	
		Connection con = null; 
		try {
			
			con = this.performConnection();	
			PreparedStatement ps = con.prepareStatement("UPDATE laboratorio SET estado=(?) WHERE CODIGO_LABORATORIO=(?)", PreparedStatement.RETURN_GENERATED_KEYS);
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

	public List<TProducto> readProductosLaboratorio(int idLaboratorio){
		
		List<TProducto> list = new ArrayList<TProducto>();
		TProducto aux;
		
		Connection con = null;
		try {
			con = this.performConnection();	
			PreparedStatement ps = con.prepareStatement("select * from producto "
					+ "where (ESTADO=1 AND CODIGO_LABORATORIO=?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, idLaboratorio);
			
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				
				
				aux = new TProducto(res.getInt(1),res.getInt(2), res.getString(3),res.getInt(4)
						,res.getString(5),res.getDouble(6),res.getBoolean(7),res.getBoolean(8), res.getString(9));
				list.add(aux);
				
			}
			
		} catch (Exception e) {
			list.clear();
		}
		
		return list;
		
	}

	

}
