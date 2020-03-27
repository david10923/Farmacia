package Integracion.DAOCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JOptionPane;

import Integracion.Conexion.Conexion;
import Tranfers.TCliente;

public class DAOClienteImp extends Conexion implements DAOCliente {

	@Override
	public int create(TCliente tUsuario) throws SQLException {
		Connection con = null;
		int id = -1;
		String query = "INSERT INTO cliente(DNI, TARJETA_SANITARIA, NOMBRE, ESTADO) VALUES(?,?,?,?)";
		
		try {
			con = this.performConnection();	
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, tUsuario.getDni());
			ps.setString(2, tUsuario.getTarjetaSanitaria());
			ps.setString(3, tUsuario.getDni());
			ps.setBoolean(4, true);
			
			ResultSet res = ps.getGeneratedKeys();
			
			if (res.next()) {
				id = res.getInt(1);
				JOptionPane.showMessageDialog(null, "Saved");
			}
			con.close();
			
		}catch (SQLException e) {
			System.out.println("tupu");
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
			// TODO: handle exception
		}
		
		return aux;
	}
	
	@Override
	public TCliente read(int id) {
		
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
	public int delete(int id) {
		
		return 0;
	}

}
