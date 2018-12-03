
import java.util.HashSet;
import java.util.Iterator;

public class AdministradorDeTarea {
	/**
	 * Inicialización de variables.
	 * Tarea = set donde se guardan todas las tareas que presenta el prorama.
	 * miAdministrador = unica instancia del objeto para poder ser.
	 */
	private HashSet<Tarea> tarea= new HashSet<Tarea>();
	private String[] estados = {"Pendiente","En_proceso","Validacion","Terminado"};
	private static AdministradorDeTarea miAdministrador;
	/**
	 * Constructor privado, solo se quiere una instancia de este
	 */
	 private AdministradorDeTarea() {
	
	}
	 /**
	  * Método unica instancia del Singlenton, si todavia no se ha instanciado se instancia, sino 
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
	  * Añade la tarea que se le pasa como parametro a la lista de tareas-
	  * @param t
	  */
	public void addTarea(Tarea t) {
		this.tarea.add(t);
	}
	/**
	 * Comprueba a través del identificador si la tarea buscada existe.
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
	 * Te muestra por pantalla la información basica de todas las tareas.
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
}
