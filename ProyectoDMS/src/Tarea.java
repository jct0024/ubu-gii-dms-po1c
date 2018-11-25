
public class Tarea {
	String titulo;
	String descripcion;
	int coste;
	int beneficio;
	private Requisito requisito;
	private MiembroDeEquipo aisgnadoA;
	
	public Tarea (Requisito requisito) {
		this.requisito = requisito;
	}
	
	public void asignarMiembro(MiembroDeEquipo MDE) {
		aisgnadoA = MDE;
	}
}