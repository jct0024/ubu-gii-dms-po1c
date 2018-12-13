import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;

public class Tarea {
	String titulo;
	int id;
	String descripcion;
	int coste;
	int beneficio;
	int estado;
	private Requisito requisito;
	private MiembroDeEquipo asignadoA;
	protected HashSet<Tarea> tarea= new HashSet<Tarea>();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	protected static String[] estados = {"Pendiente","En_proceso","Validacion","Terminado"};
	private SprintBacklog sb = new SprintBacklog();
	private ProductBacklog pb = new ProductBacklog();
	
	/**
	 * Tarea tendria en el constructor los datos necesarios para cuando se instancia una tarea,
	 * y ser guardado ese objeto en el backloh con el estado necesario para ver como esta.
	 * @param requisito
	 */
	
	public Tarea (String titulo, int id,  int coste, int beneficio, int estado) {
		
		this.titulo = titulo;
		this.id = id;
		this.descripcion = "Sin descripción";
		this.coste = coste;
		this.beneficio = beneficio;
		this.requisito = requisito;
		this.asignadoA = asignadoA;
		this.estado = estado;
		pb.actualizar();
		sb.actualizar();
	}
	public void addTarea(Tarea t) {
		tarea.add(t);
	}
	public void getTarea() throws IOException {
		Iterator<Tarea> it = tarea.iterator();
		while(it.hasNext()) {
			Tarea t = (Tarea)it.next();
			if (t.getEstado() == 0) {
				System.out.println("Titulo: " + t.getTitulo());
				System.out.println("Identificador: "+t.getId());
				System.out.println("Estado: "+estados[t.getEstado()]);
				@SuppressWarnings("unused")
				String sTexto4 = br.readLine();
			}
		}
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
		if(estado == 0) {
			pb.actualizar();
		} else {
			sb.actualizar();
		}
		this.estado = estado;
	}

	public MiembroDeEquipo getAsignadoA() {
		return asignadoA;
	}

	public void setAsignadoA(MiembroDeEquipo asignadoA) {
		this.asignadoA = asignadoA;
	}
	public void imprimirBacklog(int est) {
		if(est==0) {
		Iterator<Tarea> it = pb.getBacklog().iterator();
		while(it.hasNext()) {
			Tarea t = (Tarea)it.next();
				System.out.println("Titulo: " + t.getTitulo());
				System.out.println("Identificador: "+t.getId());
		}
		}
	}

}