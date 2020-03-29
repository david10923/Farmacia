package Integracion.DAOCliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

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
		
		return 0;
	}

	@Override
	public boolean delete(String nif) {
		boolean ret = false;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Main.Main.database, Main.Main.user, Main.Main.password);
			PreparedStatement ps = con.prepareStatement("UPDATE empleado SET activo=(?) WHERE ID=(?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setBoolean(1, false);
			ps.setInt(2, te.get_id());
			int res = ps.executeUpdate();
		
			if(res > 0) {
				ret = true;
			}
			con.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			ret = false;
		}
		return ret;
	}

}
