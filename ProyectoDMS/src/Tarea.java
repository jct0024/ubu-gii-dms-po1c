import java.util.ArrayList;
import java.util.List;

public class Tarea {
	String titulo;
	int id;
	String descripcion;
	int coste;
	int beneficio;
	private Requisito requisito;
	private MiembroDeEquipo aisgnadoA;
	
	/**
	 * Tarea tendria en el constructor los datos necesarios para cuando se instancia una tarea,
	 * y ser guardado ese objeto en el backloh con el estado necesario para ver como esta.
	 * @param requisito
	 */
	
	
	public Tarea (Requisito requisito) {
		this.requisito = requisito;
	}
	
	public void asignarMiembro(MiembroDeEquipo MDE) {
		aisgnadoA = MDE;
	}
}