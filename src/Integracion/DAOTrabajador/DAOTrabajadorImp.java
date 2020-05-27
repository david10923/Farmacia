package Integracion.DAOTrabajador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Integracion.Conexion.Conexion;
import Negocio.Trabajador.TTrabajador;

public class DAOTrabajadorImp extends Conexion implements DAOTrabajador {
	
	

	@Override
	public int create(TTrabajador tUsuario) {
		Connection con = null;
		int id = -1;
		String query = "INSERT INTO trabajador(DNI, TELEFONO, NOMBRE, ESTADO) VALUES(?,?,?,?)";
		
		try {
			con = this.performConnection();	
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, tUsuario.getDni());
			ps.setString(2, tUsuario.getTelefono());
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

	@Override
	public TTrabajador read(String nif) {
		return null;
	}

	@Override
	public List<TTrabajador> readAll() {
		List<TTrabajador> list = new ArrayList<TTrabajador>();
		
		Connection con = null;
		try {
			con = this.performConnection();	
			PreparedStatement ps = con.prepareStatement("select * from trabajador", PreparedStatement.RETURN_GENERATED_KEYS);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				TTrabajador aux = new TTrabajador();
				
				aux.setCodigo(rs.getInt(1));
				aux.setDni(rs.getString(2));
				aux.setTelefono(rs.getString(3));
				aux.setNombre(rs.getString(4));
				aux.setEstado(rs.getBoolean(5));
				list.add(aux);
			}
			
		} catch (Exception e) {
			list.clear();
		}
		
		return list;
		
	}

	@Override
	public TTrabajador readByDNI(String DNI) {
		Connection con = null;
		TTrabajador aux = null;
		
		String query = "SELECT * FROM trabajador WHERE DNI=?";
		
		try {
			con = this.performConnection();	
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, DNI);
			
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				aux = new TTrabajador();
				aux.setCodigo(res.getInt(1));
				aux.setDni(res.getString(2));
				aux.setTelefono(res.getString(3));
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
	public int update(TTrabajador tUsuario, boolean reactivar) {
		int id = -1, res;

		Connection con = null; 
		try {
			con = this.performConnection();
			if(!reactivar){
				PreparedStatement ps = con.prepareStatement("UPDATE trabajador SET TELEFONO=?, NOMBRE=? "
						+ " WHERE DNI=?", PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, tUsuario.getTelefono());
				ps.setString(2, tUsuario.getNombre());
				ps.setString(3, tUsuario.getDni());
				res = ps.executeUpdate();
			
			}else{
				PreparedStatement ps = con.prepareStatement("UPDATE trabajador SET ESTADO=?"
						+ " WHERE DNI=?", PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setBoolean(1, true);
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
			PreparedStatement ps = con.prepareStatement("UPDATE trabajador SET estado=(?) WHERE CODIGO_TRABAJADOR=(?)", PreparedStatement.RETURN_GENERATED_KEYS);
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
	public TTrabajador readById(int id) {
		Connection  con = null;
		TTrabajador aux = null;
		
		String query = "SELECT * FROM trabajador WHERE CODIGO_TRABAJADOR=?";
		
		try {
			con = this.performConnection();	
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);
			
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				aux = new TTrabajador();
				aux.setCodigo(res.getInt(1));
				aux.setDni(res.getString(2));
				aux.setTelefono(res.getString(3));
				aux.setNombre(res.getString(4));
				aux.setEstado(res.getBoolean(5));
			
			}
			con.close();
			
		}catch (Exception e) {
			System.out.println("");
		}
		
		return aux;
	}

}
