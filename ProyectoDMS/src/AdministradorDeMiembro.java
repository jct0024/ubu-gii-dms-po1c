import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class AdministradorDeMiembro {
	/**
	 * Inicialización de variables.
	 * Tarea = set donde se guardan todas las tareas que presenta el prorama.
	 * miAdministrador = unica instancia del objeto para poder ser.
	 */
	private HashSet<MiembroDeEquipo> miembros= new HashSet<MiembroDeEquipo>();
	private static AdministradorDeMiembro miAdministrador;
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * Constructor privado, solo se quiere una instancia de este
	 */
	 private AdministradorDeMiembro() {
	
	}
	 /**
	  * Método unica instancia del Singlenton, si todavia no se ha instanciado se instancia, sino 
	  * se devuelve la instancia que ya esta creada para evitar crear otra.
	  * @return miAdministrador Objeto del tipo AdministradorDeMiembro, que sirve para manejar de manera externa los miembros.
	  */
	 public static final AdministradorDeMiembro getAdministrador() {
		 if (miAdministrador ==null) {
			 miAdministrador = new AdministradorDeMiembro();
		 }
		return miAdministrador;
		 
	 }
	 /**
	  * Devuelve el mapa de meimbros, para poder ser usado en otras clases.
	  * @return miembros, Devuelve el mapa con todos los miembros.
	  */
	 public HashSet<MiembroDeEquipo> DevolverTareas(){
		return miembros;	 
	 }
	 /**
	  * Añade el miembro que se le pasa como parametro al mapa de miembros-
	  * @param m
	  */
	public void addMiembro(MiembroDeEquipo m) {
		this.miembros.add(m);
	}
	/**
	 * Te busca una tarea en base a su identificaro, y te devuelve la tarea
	 * si existe, y sino devuelve null.
	 * @param id id es el identificador de tarea, que usaremos como busqueda.
	 * @return t  si existe devuelve la tarea, sino devuelve null.
	 */
	public MiembroDeEquipo BuscarMiembro(int id) {
		Iterator<MiembroDeEquipo> it = miembros.iterator();
		while(it.hasNext()) {
			MiembroDeEquipo m = (MiembroDeEquipo)it.next();
			if (m.getId() == id) {
				return m;
				}
			}
		return null;
		}
	
	/**
	 * Elimina un miembro que le envias
	 * @param m
	 */
	//Id o nombre?¿
	public void RemoveMiembro(MiembroDeEquipo m) {
				System.out.println("Seguro de que desea eliminar "+m.getId() +"(S/N)");
				String resp = sc.next();
				if (resp != "N" || resp != "n") {
					this.miembros.remove(m);
				}
			}
	
	/**
	 * Comprueba a través del identificador si el miembro buscado existe.
	 * @param id
	 * @return boolean si existe devuelve verdadero, sino existe devuelve falso.
	 */
	public  boolean existeMiembro(int id) {
		Iterator<MiembroDeEquipo> it = miembros.iterator();
		while(it.hasNext()) {
			MiembroDeEquipo m = (MiembroDeEquipo)it.next();
			if (m.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Te muestra por pantalla la información de todas los miembros.
	 */
	public void getMiembro() {
		Iterator<MiembroDeEquipo> it = miembros.iterator();
		while(it.hasNext()) {
			MiembroDeEquipo m = (MiembroDeEquipo)it.next();
				System.out.println("Identificador: "+m.getId());
				System.out.println("Titulo: " + m.getNombre());
				System.out.println("--------------------------");
		}
	}
		
	}



