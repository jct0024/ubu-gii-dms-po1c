import java.util.ArrayList;
import java.util.List;

public class Tarea {
	String titulo;
	int id;
	String descripcion;
	int coste;
	int beneficio;
	int estado;
	private Requisito requisito;
	private MiembroDeEquipo asignadoA;
	
	/**
	 * Tarea tendria en el constructor los datos necesarios para cuando se instancia una tarea,
	 * y ser guardado ese objeto en el backloh con el estado necesario para ver como esta.
	 * @param requisito
	 */
	
	public Tarea (String titulo, int id, String descripcion, int coste, int beneficio, Requisito requisito, MiembroDeEquipo asignadoA) {
		
		this.titulo = titulo;
		this.id = id;
		this.descripcion = descripcion;
		this.coste = coste;
		this.beneficio = beneficio;
		this.requisito = requisito;
		this.asignadoA = asignadoA;
	}
	
	public void asignarMiembro(MiembroDeEquipo MDE) {
		asignadoA = MDE;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	public void setTitulo(String titu) {
		titulo=titu;
	}
	public void setDescripcion(String des) {
		descripcion=des;
	}

	public int getCoste() {
		return coste;
	}

	public void setCoste(int coste) {
		this.coste = coste;
	}

	public int getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(int beneficio) {
		this.beneficio = beneficio;
	}

	public Requisito getRequisito() {
		return requisito;
	}

	public void setRequisito(Requisito requisito) {
		this.requisito = requisito;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public MiembroDeEquipo getAsignadoA() {
		return asignadoA;
	}

	public void setAsignadoA(MiembroDeEquipo asignadoA) {
		this.asignadoA = asignadoA;
	}
}