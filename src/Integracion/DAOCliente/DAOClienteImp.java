package Integracion.DAOCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Integracion.Conexion.Conexion;
import Negocio.Cliente.TCliente;

public class DAOClienteImp extends Conexion implements DAOCliente {

	@Override
	public int create(TCliente tUsuario){
		Connection con = null;
		int id = -1;
		String query = "INSERT INTO cliente(DNI, TARJETA_SANITARIA, NOMBRE, ESTADO) VALUES(?,?,?,?)";
		
		try {
			con = this.performConnection();	
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, tUsuario.getDni());
			ps.setString(2, tUsuario.getTarjetaSanitaria());
			ps.setString(3, tUsuario.getNombre());
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

	
	public TCliente readByDNI(String DNI) {
		Connection con = null;
		TCliente aux = null;
		
		String query = "SELECT * FROM cliente WHERE DNI=?";
		
		try {
			con = this.performConnection();	
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, DNI);
			
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				aux = new TCliente();
				aux.setCodigo(res.getInt(1));
				aux.setDni(res.getString(2));
				aux.setTarjetaSanitaria(res.getString(3));
				aux.setNombre(res.getString(4));
				aux.setEstado(res.getBoolean(5));
			
			}
			con.close();
			
		}catch (Exception e) {
			System.out.println("");
		}
		
		return aux;
	}
	
	
	
	@Override
	public TCliente read(String nif) {
		
		return null;
	}


	@Override
	public int update(TCliente tUsuario,boolean reactivar) {
		
		
		int id = -1, res;

		Connection con = null; 
		try {
			
			con = this.performConnection();
			
			if(!reactivar){
				PreparedStatement ps = con.prepareStatement("UPDATE cliente SET TARJETA_SANITARIA=?, NOMBRE=?"
					+ " WHERE DNI=?", PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, tUsuario.getTarjetaSanitaria());
				ps.setString(2, tUsuario.getNombre());	
				ps.setString(3, tUsuario.getDni());
				res = ps.executeUpdate();
					
			}else{
				PreparedStatement ps = con.prepareStatement("UPDATE cliente SET ESTADO=? "
						+ " WHERE DNI=?", PreparedStatement.RETURN_GENERATED_KEYS);		
					ps.setBoolean(1,true);
					ps.setString(2, tUsuario.getDni());
					res = ps.executeUpdate();
			}
			
		
			if(res > 0) {
				
				id = tUsuario.getCodigo();
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
			PreparedStatement ps = con.prepareStatement("UPDATE cliente SET estado=(?) WHERE CODIGO_CLIENTE=(?)", PreparedStatement.RETURN_GENERATED_KEYS);
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
	
	
	public List<TCliente> readAll(){
	
		List<TCliente> list = new ArrayList<TCliente>();
		
		Connection con = null;
		try {
			con = this.performConnection();	
			PreparedStatement ps = con.prepareStatement("select * from cliente", PreparedStatement.RETURN_GENERATED_KEYS);
			
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				TCliente aux = new TCliente();
				
				aux.setCodigo(res.getInt(1));
				aux.setDni(res.getString(2));
				aux.setTarjetaSanitaria(res.getString(3));
				aux.setNombre(res.getString(4));
				aux.setEstado(res.getBoolean(5));
				
				list.add(aux);
				
				
			}
			
		} catch (Exception e) {
			list.clear();
		}
		
		return list;
		
	}


	@Override
	public TCliente readById(int id) {
		
		Connection con = null;
		TCliente aux = null;
		
		String query = "SELECT * FROM cliente WHERE CODIGO_CLIENTE=?";
		
		try {
			con = this.performConnection();	
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);
			
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				
				aux = new TCliente();
				aux.setCodigo(res.getInt(1));
				aux.setDni(res.getString(2));
				aux.setNombre(res.getString(4));
				aux.setTarjetaSanitaria(res.getString(3));
				aux.setEstado(res.getBoolean(5));
			
			}
			con.close();
			
		}catch (Exception e) {
			System.out.println("");
		}
		
		return aux;
	}

}
