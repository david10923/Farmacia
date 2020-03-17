package Tranfers;

public class TransferCliente {

	private Integer codigo; 
	private String dni;
	private String tarjetaSanitaria;
	private String nombre; 
	private boolean estado;
	
	
	public TransferCliente(String dni ,String tarjetaSanitaria, String nombre) {
		this.dni = dni; 
		this.tarjetaSanitaria = tarjetaSanitaria ; 
		this.nombre = nombre;
		
	}
	
	public TransferCliente() {
		
	}
	
	
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTarjetaSanitaria() {
		return tarjetaSanitaria;
	}
	public void setTarjetaSanitaria(String tarjetaSanitaria) {
		this.tarjetaSanitaria = tarjetaSanitaria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
