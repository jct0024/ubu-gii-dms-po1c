import java.util.HashSet;

public class Defecto extends Requisito {
	private String cambio;
	private HashSet<Tarea> defecto= new HashSet<Tarea>();
	
	public Defecto(String cambio,String nombre, String descripcion,int idrequisito,HashSet<Tarea> requisitos) {
		this.cambio=cambio;
		this.idrequisito=idrequisito;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.requisitos=new HashSet<Tarea>();
	}
	
	public void setcambio() {
		System.out.println("Indica el motivo del defecto");
		//acabar
		String motivo = sc.next();
		cambio=motivo;
	}
	
	public String getCambio() {
		return cambio;
	}
}
