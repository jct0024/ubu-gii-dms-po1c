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
				System.out.println("Nº de tareas:" + r.getRequisitos().size());
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
	
	
	public void RemoveRequisito(Requisito r) {
		int flag=0;
		String resp=null;
		while(flag==0) {
			flag=1;
			System.out.println("Seguro de que desea eliminar el requisito "+r.getIdrequisito() +" (S/N)");
			resp = sc.next();
			if(resp.equals("s") && resp.equals("S") && resp.equals("n") &&  resp.equals("N")) {
				System.out.println("Error, parametro invalido vuelve a intentarlo");
				flag=0;
			}
		}
		if (resp.equals("S") || resp.equals("s")) {
			this.requisitos.remove(r);
		}
	}
	
	/**
	 * Te muestra por pantalla la informaciï¿½n basica de todas las tareas.
	 */
	public void getDatosRequisito(Requisito r) {
		System.out.println("1.Titulo: " + r.getNombre());
		System.out.println("2.Identificador: "+r.getIdrequisito());
		System.out.println("3.Descripcion: "+r.getDescripcion());
		System.out.println("4.Tareas: Nº Tareas "+r.getRequisitos().size());
		System.out.println("5.Finalizar Requisito "+ r.getNombre());
		System.out.println("6.Reabrir Requisito "+ r.getNombre());
	}

	public void modificarRequisito(AdministradorDeTarea at) {
		if(this.requisitos.size()>0) {
		boolean bandera = false;
		while(!bandera) {
			System.out.println("Identificador de Requisito a Modificar:");
			int id =sc.nextInt();
			if(this.existeRequisito(id)) {
					System.out.println("Quieres modificar la tarea "+this.BuscarRequisito(id).getNombre()+" (S/N)");
					String est =sc.next();
					if (est.equals("S") || est.equals("s")) {
						this.getDatosRequisito(this.BuscarRequisito(id));
						System.out.println("Elija elemento a modificar");
						int opc =sc.nextInt();
						switch (opc) {
						case 0:
							break;
						case 1:
							System.out.println("Nuevo nombre: ");
							String nom =sc.next();
							this.BuscarRequisito(id).setNombre(nom);
							break;
						case 2:
							System.out.println("Nuevo identificador: ");
							Integer ide =sc.nextInt();
							this.BuscarRequisito(id).setIdrequisito(ide);
							break;
						case 3:
							System.out.println("Nueva Descripcion: ");
							String desc =sc.next();
							this.BuscarRequisito(id).setDescripcion(desc);
							break;
						case 4:
							System.out.println("Quieres eliminar(1) o añadir alguna tarea(2):  ");
							int opcion =sc.nextInt();
								if (opcion==1) {
									int pasa = 1;
									while(pasa==1) {
										System.out.println("Introduce id de tarea a eliminar:  ");
										int id2 =sc.nextInt();
										if(this.BuscarRequisito(id).existeTarea(id2)) {
										this.BuscarRequisito(id).getRequisitos().remove(at.BuscarTarea(id2));
											System.out.println("Tarea Eliminada ");
										}else {
											System.out.println("Esa Tarea no se encuentra en este requisito ");
										}
										System.out.println("Quieres eliminar alguna otra tarea: 1) SI, 0) NO  ");
										pasa =sc.nextInt();
									}
									
								}else if(opcion==2) {
									int pasa = 1;
									while(pasa==1) {
										System.out.println("Introduce id de tarea que desea añadir:  ");
										int id2 =sc.nextInt();
										if(!this.BuscarRequisito(id).existeTarea(id2) && at.existeTarea(id2)) {
										this.BuscarRequisito(id).getRequisitos().add(at.BuscarTarea(id2));
											System.out.println("Tarea Añadida ");
										}else {
											System.out.println("Esa Tarea ya se encuentra en este requisito o no existe ");
										}
										System.out.println("Quieres añadir alguna otra tarea: 1) SI, 0) NO  ");
										pasa =sc.nextInt();
									}
								}
								break;
								
						case 5:
							System.out.println("Quieres finalizar el requisito " +this.BuscarRequisito(id).getNombre()+" (S/N)");
							String requi =sc.next();
							if (requi.equals("S") || requi.equals("s")) {
								this.BuscarRequisito(id).finalizar();
							}
						break;
							
						case 6:
							System.out.println("Quieres finalizar el requisito " +this.BuscarRequisito(id).getNombre()+" (S/N)");
							String req =sc.next();
							if (req.equals("S") || req.equals("s")) {
								if (this.BuscarRequisito(id).getFinalizado()==1) {
									this.addRequisito(this.BuscarRequisito(id).Reabrir());
								}
							}
						break;
							
						}	
						bandera = true;
					}
			}
		}
	
	}else {
		System.out.println("No existe ningun Requisito ");
	}
}
}
