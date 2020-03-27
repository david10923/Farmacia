package Presentacion.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class VentanaBajaCliente extends JDialog implements ActionListener{

	
	
	public VentanaBajaCliente() {
		
		
		this.setBounds(350, 100,300,400);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
