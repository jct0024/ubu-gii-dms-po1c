import java.util.HashSet;

public class Defecto extends Requisito {
	private String cambio;
	private HashSet<Tarea> defecto= new HashSet<Tarea>();
	
	public Defecto(String cambio) {
		this.cambio=cambio;
	}
	
	public void Setcambio() {
		System.out.println("Indica el motivo del defecto");
		//acabar
		String motivo = sc.next();
		cambio=motivo;
	}
	
	public String GetCambio() {
		return cambio;
	}
}
