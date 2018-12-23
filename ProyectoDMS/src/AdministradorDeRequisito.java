import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class AdministradorDeRequisito {
	/**
	 * Inicialización de variables.
	 * requisitos = set donde se guardan todas las tareas que presenta el prorama.
	 * miAdministrador = unica instancia del objeto para poder ser.
	 */
	private HashSet<Requisito> requisitos= new HashSet<Requisito>();
	private static AdministradorDeRequisito miAdministrador;
	private Scanner sc = new Scanner(System.in);
		
	
	public AdministradorDeRequisito(){
		
	}
	
	/**
	  * Método unica instancia del Singlenton, si todavia no se ha instanciado se instancia, sino 
	  * se devuelve la instancia que ya esta creada para evitar crear otra.
	  * @return miAdministrador Objeto del tipo AdministradorDeRequisito, que sirve para manejar de manera externa los requisitos.
	  */
	public static final AdministradorDeRequisito getAdministrador() {
		 if (miAdministrador ==null) {
			 miAdministrador = new AdministradorDeRequisito();
		 }
		return miAdministrador;
		 
	 }
	/**
	  * Devuelve el mapa de miembros, para poder ser usado en otras clases.
	  * @return requisitos, Devuelve el mapa con todos los requisitos.
	  */
	 public HashSet<Requisito> DevolverRequisitos(){
		return requisitos;	 
	 }
	 /**
	  * Añade el requisito que se le pasa como parametro al mapa de requisitos-
	  * @param r
	  */
	public void addRequisito(Requisito r) {
		this.requisitos.add(r);
	}
	/**
	 * Te busca un requisito en base a su identificaro, y te devuelve el  requisito
	 * si existe, y sino devuelve null.
	 * @param id id es el identificador de tarea, que usaremos como busqueda.
	 * @return t  si existe devuelve la tarea, sino devuelve null.
	 */
	public Requisito BuscarRequisito(int id) {
		Iterator<Requisito> it = requisitos.iterator();
		while(it.hasNext()) {
			Requisito r = (Requisito)it.next();
			if (r.getIdrequisito() ==id) {
				return r;
				}
			}
		return null;
		}
	
	/**
	 * Te muestra por pantalla la información de todos los miembros.
	 */
	public void getRequisitos() {
		Iterator<Requisito> it = requisitos.iterator();
		while(it.hasNext()) {
			Requisito r = (Requisito)it.next();
				System.out.println("Identificador: "+r.getIdrequisito());
				System.out.println("Nombre: " + r.getNombre());
				System.out.println("Descripcion: " + r.getDescripcion());
				System.out.println("Finalizado: " + r.getFinalizado());
				System.out.println("--------------------------");
		}
	}
	
	/**
	 * Comprueba a través del identificador si el miembro buscado existe.
	 * @param id
	 * @return boolean si existe devuelve verdadero, sino existe devuelve falso.
	 */
	public  boolean existeRequisito(int id) {
		Iterator<Requisito> it = requisitos.iterator();
		while(it.hasNext()) {
			Requisito r = (Requisito)it.next();
			if (r.getIdrequisito() == id) {
				return true;
			}
		}
		return false;
	}

	
	
}
