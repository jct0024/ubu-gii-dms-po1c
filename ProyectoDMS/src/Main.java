import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	/**
	 * El main tendrá el menu necesarios y los atributos globales, para modificar y navegar por las
	 * diferentes opciones como se ve en el ejemplo de añadir y ver miembro.
	 * Además queda pediente de crear todas las tareas para comprobar cada ejemplo.
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//Registro de tareas
		MiembroDeEquipo M = new MiembroDeEquipo();
		Requisito R = new Requisito();
		ProductBacklog bl = new ProductBacklog();
		SprintBacklog sl = new SprintBacklog();
		Tarea a = new Tarea ("Desarrollar", 0,  20, 100,R, M,0);
		Tarea b = new Tarea ("Diseñar", 1,  20, 100,R, M,1);
		Tarea c = new Tarea ("Procesar", 2,  20, 100,R, M,1);
		Tarea d = new Tarea ("Revisar fallos", 3,  20, 100,R, M,3);
		bl.addTarea(a);
		sl.addTarea(c);
		sl.addTarea(d);
		sl.addTarea(b);
		List<String> Estados = new ArrayList<String>();
		Estados.add("Pendiente");
		Estados.add("En Proceso");
		Estados.add("Validación");
		Estados.add("Finalizado");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int flag=10000;
		/**
		 * Menu didactico para navegar por la aplicación a rellenar
		 */
		while(flag!=0) {
			
			System.out.println("Elige una opción");
			System.out.println("1, Miembros");
			System.out.println("2, Tareas");
			System.out.println("0, Salir del programa");
			flag=sc.nextInt();
			int flag2 = -1;
			if (flag == 1) {
				while(flag2!=0){
					System.out.println("Elige una opción");
					System.out.println("1: Añadir Miembro");
					System.out.println("2: Lista de Miembros");
					System.out.println("3: Eliminar Miembro");
					System.out.println("0: Volver al menu principal");
					flag2=sc.nextInt();
					if(flag2==1) {
						System.out.println("Añadir DNI");
						int id =sc.nextInt();
						System.out.println("AñadirNombre");
						String nom = sc.next();
						M.addMiembro(id, nom);
					} else if(flag2 == 2) {
						M.getmiembro();
					} else if (flag2 == 3) {
						System.out.println("Introduce el Id del miembro a eliminar");
						int id =sc.nextInt();
						M.eliminarMiembro(id);
					}
				}

			} else if(flag ==2){
				while(flag2!=0){
					System.out.println("Elige una opción");
					System.out.println("1: Añadir Tarea");
					System.out.println("2: Lista de Tareas");
					System.out.println("3: Eliminar Tarea");
					System.out.println("0: Volver al menu principal");
					flag2=sc.nextInt();
					if(flag2==1) {
						/**
						 * Añadir Tarea, habrá que elegir,  que estado tiene.
						 * Hay que hacer una serie de scaners para coger todos atribuos que tiene una tarea
						 * y mas tarde instanciar un objeto tarea con ests atributos.
						 * Hay que tener en cuenta que tambien se debería poder añadir una tarea para añadir 
						 * los  atributos secundarios
						 * Tarea (String titulo, int id,  int coste, int beneficio, Requisito requisito, MiembroDeEquipo asignadoA, int estado)
						 */

						System.out.println("Añadir Titulo");
						String nom = sc.next();
						System.out.println("Añadir Identificador de tarea");
						int id =sc.nextInt();
						System.out.println("Añadir Coste");
						int cost =sc.nextInt();
						System.out.println("Añadir Beneficio");
						int ben =sc.nextInt();
						System.out.println("Añadir Estado (NUMERO) "
								+ "0: Pendiente"
								+ "1: En proceso"
								+ "2: Validación"
								+ "3: Terminado");
						int est =sc.nextInt();
						if (est==0) {
							bl.addTarea(new Tarea(nom,id,cost,ben,R,M,est));
						} else {
							sl.addTarea(new Tarea(nom,id,cost,ben,R,M,est));
						}
					} else if(flag2 == 2) {	
						System.out.println("Que tareas deseas mostrar:");
						System.out.println("1: Tareas en Product Backlog");
						System.out.println("2: Tareas en SprintBacklog");
						System.out.println("3: Todas las tareas");
						System.out.println("0: Volver al menu principal");
						//Añadir while para que se repita todo el rato el menu
						int tipo=sc.nextInt();
						/**
						 * Aqui hay que hacer un menu entre: todas, las del sprintbacklog o las de productBacklog, 
						 * en el iterador hay que hacer un if, filtrando seguún su estado.
						 */ 
						switch (tipo){
							case 0:
								System.out.println("Aqui seria volver al menu anterior");
								break;
							case 1:
								bl.getTarea();
								break;
							case 2:
								sl.getTarea();
								break;
							case 3:
									Iterator<Tarea> it = sl.tarea.iterator();
									while(it.hasNext()) {
										Tarea t = (Tarea)it.next();
											System.out.println("Titulo: " + t.getTitulo());
											System.out.println("Identificador: "+t.getId());
										}
							}
							
						bl.getTarea();

					} else if (flag2 == 3) {
						System.out.println("Introduce el Id del miembro a eliminar");
						int id =sc.nextInt();
						M.eliminarMiembro(id);
					}
				}

			} 
			
		}

		System.out.println("Proeso Finalizado");	
		
	}
}
