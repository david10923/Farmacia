package Presentacion.Cliente;



import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaCrearCliente extends JDialog {

	public VentanaCrearCliente(){
		iniciarventana();
	}
	
	void iniciarventana(){
		this.setBounds(350, 200, 70,70);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setTitle("Alta Cliente");
		
		iniciarComponentes();
		
	}
	
	void iniciarComponentes(){
		JTextField id = new JTextField();
		JLabel etiquetaID = new JLabel ();
		this.add(etiquetaID);
		this.add(id);
	}
	
	
	

}
