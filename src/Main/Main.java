package Main;

import javax.swing.SwingUtilities;

import Controller.Controller;

public class Main {
	public static String name = "FARMACIA";
	
	

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {		// se ejecuta el thread del swing a la vez que el main ??¿				
			public void run() {
				//new InfoDB();
				Controller.getInstance();
		}
		});

	}

}
