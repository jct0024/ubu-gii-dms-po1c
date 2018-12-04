
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class AdministradorDeTarea {
	/**
	 * Inicializaci�n de variables.
	 * Tarea = set donde se guardan todas las tareas que presenta el prorama.
	 * miAdministrador = unica instancia del objeto para poder ser.
	 */
	private HashSet<Tarea> tarea= new HashSet<Tarea>();
	private String[] estados = {"Pendiente","En_proceso","Validacion","Terminado"};
	private static AdministradorDeTarea miAdministrador;
	private Scanner sc = new Scanner(System.in);
	/**
	 * Constructor privado, solo se quiere una instancia de este
	 */
	 private AdministradorDeTarea() {
	
	}
	 /**
	  * M�todo unica instancia del Singlenton, si todavia no se ha instanciado se instancia, sino 
	  * se devuelve la instancia que ya esta creada para evitar crear otra.
	  * @return miAdministrador Objeto del tipo AdministradorDeTarea, que sirve para manejar de manera externa las tareas.
	  */
	 public static final AdministradorDeTarea getAdministrador() {
		 if (miAdministrador ==null) {
			 miAdministrador = new AdministradorDeTarea();
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
	  * A�ade la tarea que se le pasa como parametro a la lista de tareas-
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
	 * Comprueba a trav�s del identificador si la tarea buscada existe.
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
	 * Te muestra por pantalla la informaci�n basica de todas las tareas.
	 */
	public void getTarea() {
		Iterator<Tarea> it = tarea.iterator();
		while(it.hasNext()) {
			Tarea t = (Tarea)it.next();
				System.out.println("Titulo: " + t.getTitulo());
				System.out.println("Identificador: "+t.getId());
				System.out.println("Estado: "+estados[t.getEstado()]);
		}
	}
	/**
	 * Te muestra por pantalla la informaci�n basica de todas las tareas.
	 */
	public void getDatosTarea(Tarea t) {
		System.out.println("1.Titulo: " + t.getTitulo());
		System.out.println("2.Identificador: "+t.getId());
		System.out.println("3.Estado: "+estados[t.getEstado()]);
		System.out.println("4.Coste: " + t.getCoste());
		System.out.println("5.Beneficio: "+t.getBeneficio());
		System.out.println("6.Descripci�n: "+t.getDescripcion());
		System.out.println("7.Meimbro al cargo: "+t.getAsignadoA());
		System.out.println("8.Requisito: "+t.getRequisito());
	}
}
