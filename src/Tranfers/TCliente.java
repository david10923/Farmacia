package Tranfers;

public class TCliente {

	private Integer codigo; 
	private String dni;
	private String tarjetaSanitaria;
	private String nombre; 
	private boolean estado;
	
	
	
	public TCliente(String dni ,String tarjetaSanitaria, String nombre) {
		this.dni = dni; 
		this.tarjetaSanitaria = tarjetaSanitaria ; 
		this.nombre = nombre;
		
	}
	
	public TCliente(int codigo, String dni ,String tarjetaSanitaria, String nombre, boolean estado) {
		this.codigo =codigo;
		this.dni = dni; 
		this.tarjetaSanitaria = tarjetaSanitaria ; 
		this.nombre = nombre;
		this.estado = estado;
	}
	
	public TCliente() {
		
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
