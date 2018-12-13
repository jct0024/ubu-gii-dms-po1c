
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class AdministradorDeTarea {
	/**
	 * Inicializaciï¿½n de variables.
	 * Tarea = set donde se guardan todas las tareas que presenta el prorama.
	 * miAdministrador = unica instancia del objeto para poder ser.
	 */
	private HashSet<Tarea> tarea= new HashSet<Tarea>();
	private String[] estados = {"Pendiente","En_proceso","Validacion","Terminado"};
	private static AdministradorDeTarea miAdministrador;
	private Scanner sc = new Scanner(System.in);
	private static Backlog sb;
	private static Backlog pb;
	/**
	 * Constructor privado, solo se quiere una instancia de este
	 */
	 private AdministradorDeTarea() {
	
	}
	 /**
	  * Mï¿½todo unica instancia del Singlenton, si todavia no se ha instanciado se instancia, sino 
	  * se devuelve la instancia que ya esta creada para evitar crear otra.
	  * @return miAdministrador Objeto del tipo AdministradorDeTarea, que sirve para manejar de manera externa las tareas.
	  */
	 public static final AdministradorDeTarea getAdministrador() {
		 if (miAdministrador == null) {
			 miAdministrador = new AdministradorDeTarea();
			 sb = new SprintBacklog();
			 pb = new ProductBacklog(); 
		 }
		return miAdministrador;
		 
	 }
	 /**
	  * Devuelve el vector de tareas, para poder ser usado en otras clases.
	  * @return tarea Devuelve todo el array.
	  */
	 public HashSet<Tarea> DevolverTareas(){
		return tarea;
		 
	 }
	 /**
	  * Aï¿½ade la tarea que se le pasa como parametro a la lista de tareas-
	  * @param t
	  */
	public void addTarea(Tarea t) {

		this.tarea.add(t);
	}
	/**
	 * Te busca una tarea en base a su identificaro, y te devuelve la tarea
	 * si existe, y sino devuelve null.
	 * @param id id es el identificador de tarea, que usaremos como busqueda.
	 * @return t  si existe devuelve la tarea, sino devuelve null.
	 */
	public Tarea BuscarTarea(int id) {
		Iterator<Tarea> it = tarea.iterator();
		while(it.hasNext()) {
			Tarea t = (Tarea)it.next();
			if (t.getId() == id) {
				return t;
				}
			}
		return null;
		}
	/**
	 * Elimina una tarea que le envias
	 * @param t
	 */
	public void RemoveTarea(Tarea t) {
				System.out.println("Seguro de que desea eliminar "+t.getTitulo() +"(S/N)");
				String resp = sc.next();
				if (resp != "N" || resp != "n") {
					this.tarea.remove(t);
				}
			} 
	/**
	 * Comprueba a travï¿½s del identificador si la tarea buscada existe.
	 * @param id
	 * @return boolean si existe devuelve verdadero, sino existe devuelve falso.
	 */
	public  boolean existeTarea(int id) {
		Iterator<Tarea> it = tarea.iterator();
		while(it.hasNext()) {
			Tarea t = (Tarea)it.next();
			if (t.getId() == id) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Te muestra por pantalla la informaciï¿½n basica de todas las tareas.
	 */
	public void getTarea() {
		Iterator<Tarea> it = tarea.iterator();
		while(it.hasNext()) {
			Tarea t = (Tarea)it.next();
				System.out.println("Titulo: " + t.getTitulo());
				System.out.println("Identificador: "+t.getId());
				System.out.println("Estado: "+estados[t.getEstado()]);
				System.out.println("----------------------------------");
		}
	}
	
	/**
	 * Imprime por pantalla las listas de tareas del sprintBacklog o el ProductBacklog segun el estado de las tareas.
	 * @param est (Estado de las tareas)
	 */
	public void getBacklog(int est) {
		if(est == 0) {
			Iterator it = pb.getBacklog().iterator();
			while(it.hasNext()) {
				Tarea t = (Tarea)it.next();
					System.out.println("Titulo: " + t.getTitulo());
					System.out.println("Identificador: "+t.getId());
					System.out.println("Estado: "+estados[t.getEstado()]);
					System.out.println("----------------------------------");
			}
		} else {
			Iterator it = sb.getBacklog().iterator();
			while(it.hasNext()) {
				Tarea t = (Tarea)it.next();
					System.out.println("Titulo: " + t.getTitulo());
					System.out.println("Identificador: "+t.getId());
					System.out.println("Estado: "+estados[t.getEstado()]);
					System.out.println("----------------------------------");
			}
			
		}
	}
	
	/**
	 * Devuelve el productBacklog del administrador de tareas.
	 * @return Pb (ProductBacklog)
	 */
	public Backlog getProductBacklog(){
		
		return pb;
	}
	
	/**
	 * Devuelve el SprintBacklog del administrador de tareas.
	 * @return Sb (SprintBacklog)
	 */
	public Backlog getSprintBacklog(){
		
		return sb;
	}
	
	/**
	 * Te muestra por pantalla la informaciï¿½n basica de todas las tareas.
	 */
	public void getDatosTarea(Tarea t) {
		System.out.println("1.Titulo: " + t.getTitulo());
		System.out.println("2.Identificador: "+t.getId());
		System.out.println("3.Estado: "+estados[t.getEstado()]);
		System.out.println("4.Coste: " + t.getCoste());
		System.out.println("5.Beneficio: "+t.getBeneficio());
		System.out.println("6.Descripciï¿½n: "+t.getDescripcion());
		System.out.println("7.Meimbro al cargo: "+t.getAsignadoA().nombre);
		System.out.println("8.Requisito: "+t.getRequisito());
	}
	public void modificarTarea() {
		System.out.println("Identificador de tarea a Modificar:");
		int id =sc.nextInt();
		System.out.println("Quieres modificar la tarea "+this.BuscarTarea(id).getTitulo()+" (S/N)");
		String est =sc.next();
		if (est.equals("S") || est.equals("s")) {
			this.getDatosTarea(this.BuscarTarea(id));
			System.out.println("Elija elemento a modificar");
			int opc =sc.nextInt();
			switch (opc) {
			case 0:
				break;
			case 1:
				System.out.println("Nuevo titulo: ");
				String tit =sc.next();
				this.BuscarTarea(id).setTitulo(tit);
				break;
			case 2:
				System.out.println("Nuevo identificador: ");
				Integer ide =sc.nextInt();
				this.BuscarTarea(id).setId(ide);
				break;
			case 3:
				System.out.println("Elige un estado estado");
				System.out.println("0 Pendiente");
				System.out.println("1 En_proceso");
				System.out.println("2 Validacion");
				System.out.println("3 Terminado");
				Integer esta = sc.nextInt();
				this.BuscarTarea(id).setEstado(esta);
				
				break;
			case 4:
				System.out.println("Nuevo Coste: ");
				Integer cost=sc.nextInt();
				this.BuscarTarea(id).setCoste(cost);
				break;
			case 5:
				System.out.println("Nuevo Beneficio: ");
				Integer bene =sc.nextInt();
				this.BuscarTarea(id).setBeneficio(bene);
				break;

			case 6:
				System.out.println("Nueva Descripción: ");
				String desc =sc.next();
				this.BuscarTarea(id).setDescripcion(desc);
				break;

			case 7:
				System.out.println("Nuevo miembro: ");
				break;
			case 8:
				System.out.println("Nuevo requisito: ");
				break;
			}
		}
	}
	public void asignarMiembro(MiembroDeEquipo m, int id) {
		System.out.println("Quieres modificar la tarea "+this.BuscarTarea(id).getTitulo()+" (S/N)");
		String est =sc.next();
		if (est.equals("S") || est.equals("s")) {
			this.BuscarTarea(id).setAsignadoA(m);
		}
	}
}
