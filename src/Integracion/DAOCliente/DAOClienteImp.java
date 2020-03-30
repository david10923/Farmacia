package Integracion.DAOCliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import Integracion.Conexion.Conexion;
import Tranfers.TCliente;

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
				aux.setNombre(res.getString(3));
				aux.setTarjetaSanitaria(res.getString(4));
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
	public Collection<TCliente> readAll() {
		
		return null;
	}

	@Override
	public int update(TCliente tUsuario) {
		
		
		int id = -1;

		Connection con = null; 
		try {
			
			con = this.performConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE cliente SET TARJETA_SANITARIA=?, NOMBRE=? "
					+ " WHERE DNI=?", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, tUsuario.getTarjetaSanitaria());
			ps.setString(2, tUsuario.getNombre());
			ps.setString(3, tUsuario.getDni());
			int res = ps.executeUpdate();
		
			if(res > 0) {
				id = res;
			}
			con.close();
			
		} catch (SQLException e) {

		}
		return id;
		

	}

	@Override
	public int delete(String dni) {
		
		int id = -1;
		

		Connection con = null; 
		try {
			
			con = this.performConnection();	
			PreparedStatement ps = con.prepareStatement("UPDATE cliente SET estado=(?) WHERE DNI=(?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setBoolean(1, false);
			ps.setString(2, dni);
			int res = ps.executeUpdate();
		
			if(res > 0) {
				id = res;
			}
			con.close();
			
		} catch (SQLException e) {

		}
		return id;

	}
	
	
	public List<TCliente> listar(){
	
		List<TCliente> list = null;
		
		Connection con = null;
		try {
			con = this.performConnection();	
			PreparedStatement ps = con.prepareStatement("select * from cliente");
			
			list = new ArrayList<TCliente>();
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				TCliente aux = new TCliente(rs.getInt("codigo"), rs.getString("dni"),
						rs.getString("tarjeta_sanitaria"), rs.getString("nombre"),rs.getBoolean("estado"));
				
				list.add(aux);
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
		
	}

}
