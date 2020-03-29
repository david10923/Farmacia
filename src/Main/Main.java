package Main;

import java.sql.SQLException;

import javax.swing.SwingUtilities;

import Controller.Controller;
import Negocio.Cliente.SACliente;
import Negocio.Cliente.SAClienteImp;
import Tranfers.TCliente;

public class Main {
	public static String name = "FARMACIA";
	
	

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {		// se ejecuta el thread del swing a la vez que el main ??¿				
			public void run() {
				//new InfoDB();
				Controller.getInstance();
		}
		});

		
		/*
		SACliente test = new SAClienteImp();
		
		TCliente aux = new TCliente("432222222","0000dd00E","paco");
		
		try {
			test.create(aux);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("nada");
		}
		*/
	}

}
