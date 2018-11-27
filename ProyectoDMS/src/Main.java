import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	/**
	 * El main tendr� el menu necesarios y los atributos globales, para modificar y navegar por las
	 * diferentes opciones como se ve en el ejemplo de a�adir y ver miembro.
	 * Adem�s queda pediente de crear todas las tareas para comprobar cada ejemplo.
	 * @param args
	 */
	public static void main(String[] args) {
		//Registro de tareas
		MiembroDeEquipo M = new MiembroDeEquipo();
		Requisito R = new Requisito();
		ProductBacklog bl = new ProductBacklog();
		Tarea a = new Tarea ("Desarrollar", 0,  20, 100,R, M,0);
		Tarea b = new Tarea ("Dise�ar", 1,  20, 100,R, M,1);
		Tarea c = new Tarea ("Procesar", 2,  20, 100,R, M,1);
		Tarea d = new Tarea ("Revisar fallos", 3,  20, 100,R, M,3);
		bl.addTarea(a);
		bl.addTarea(c);
		bl.addTarea(d);
		bl.addTarea(b);
		List<String> Estados = new ArrayList<String>();
		Estados.add("Pendiente");
		Estados.add("En Proceso");
		Estados.add("Validaci�n");
		Estados.add("Finalizado");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int flag=10000;
		/**
		 * Menu didactico para navegar por la aplicaci�n a rellenar
		 */
		while(flag!=0) {
			
			System.out.println("Elige una opci�n");
			System.out.println("1, Miembros");
			System.out.println("2, Tareas");
			System.out.println("0, Salir del programa");
			flag=sc.nextInt();
			int flag2 = -1;
			if (flag == 1) {
				while(flag2!=0){
					System.out.println("Elige una opci�n");
					System.out.println("1: A�adir Miembro");
					System.out.println("2: Lista de Miembros");
					System.out.println("3: Eliminar Miembro");
					System.out.println("0: Volver al menu principal");
					flag2=sc.nextInt();
					if(flag2==1) {
						System.out.println("A�adir DNI");
						int id =sc.nextInt();
						System.out.println("A�adirNombre");
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
					System.out.println("Elige una opci�n");
					System.out.println("1: A�adir Tarea");
					System.out.println("2: Lista de Tareas");
					System.out.println("3: Eliminar Tarea");
					System.out.println("0: Volver al menu principal");
					flag2=sc.nextInt();
					if(flag2==1) {
						/**
						 * A�adir Tarea, habr� que elegir,  que estado tiene.
						 * Hay que hacer una serie de scaners para coger todos atribuos que tiene una tarea
						 * y mas tarde instanciar un objeto tarea con ests atributos.
						 * Hay que tener en cuenta que tambien se deber�a poder a�adir una tarea para a�adir 
						 * los  atributos secundarios
						 */
						
					} else if(flag2 == 2) {	
						System.out.println("Que tareas deseas mostrar:");
						flag2=sc.nextInt();
						/**
						 * Aqui hay que hacer un menu entre: todas, las del sprintbacklog o las de productBacklog, 
						 * en el iterador hay que hacer un if, filtrando segu�n su estado.
						 */
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
