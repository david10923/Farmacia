package Presentacion.Cliente;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class VentanaCrearCliente extends JDialog implements ActionListener {

	
	
	
	
	
	
	public VentanaCrearCliente(){
		
		
		
		JPanel panel = new JPanel();
		Box box = Box.createHorizontalBox();
		
		this.setBounds(350, 100,300,400);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		panel.setLayout(new BorderLayout());
		
		JLabel DNI_Label = new JLabel("DNI: ");
		
		DNI_Label.setBounds(10, 20, 80, 25);
		
		//panel.add(DNI_Label);
		
		JTextField DNI_Text = new JTextField();
		
		DNI_Text.setBounds(100, 20, 165, 25);
		
		//panel.add(DNI_Text);
		
		JLabel TELF_Label = new JLabel("TELEFONO: ");
		
		TELF_Label.setBounds(10, 70, 80, 25);
		
		//panel.add(TELF_Label);
		
		JTextField TELF_Text = new JTextField();
		
		TELF_Text.setBounds(100, 70, 165, 25);
		
		//panel.add(TELF_Text);
		
		JLabel NOMBRE_Label = new JLabel("NOMBRE: ");
		
		NOMBRE_Label.setBounds(10, 120, 80, 25);
		
		//panel.add(NOMBRE_Label);
		
		JTextField NOMBRE_Text = new JTextField();
		
		NOMBRE_Text.setBounds(100, 120, 165, 25);
		
	//	panel.add(NOMBRE_Text);
		
		box.add(Box.createHorizontalStrut(20));
		box.add(DNI_Label);
		box.add(Box.createHorizontalStrut(20));
		box.add(DNI_Text);
		
		this.add(box);
		
		this.setVisible(true);
		//iniciarventana();
	}
	
	void iniciarventana(){
		
		
		
		this.setBounds(350, 200, 70,70);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//salta exception aqui
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

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//se llamaria a accion del controller con su evento
		
	}
	
	
	

}
