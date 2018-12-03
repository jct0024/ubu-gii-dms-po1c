import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	/**
	 * El main tendrï¿½ el menu necesarios y los atributos globales, para modificar y navegar por las
	 * diferentes opciones como se ve en el ejemplo de aï¿½adir y ver miembro.
	 * Ademï¿½s queda pediente de crear todas las tareas para comprobar cada ejemplo.
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//Variable que sirve para esperar, a que el usurio pulse enter para continuar con el programa.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//LLamamos al singlenton
		AdministradorDeTarea at = AdministradorDeTarea.getAdministrador();
		MiembroDeEquipo M = new MiembroDeEquipo();
		Requisito R = new Requisito();
		Tarea a = new Tarea ("Desarrollar", 0,  20, 100,R, M,3);
		Tarea b = new Tarea ("Diseñar", 1,  20, 100,R, M,2);
		Tarea c = new Tarea ("Procesar", 2,  20, 100,R, M,1);
		Tarea d = new Tarea ("Revisar fallos", 3,  20, 100,R, M,0);
		at.addTarea(a);
		at.addTarea(c);
		at.addTarea(d);
		at.addTarea(b);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int flag=10000;
		/**
		 * Menu didactico para navegar por la aplicaciï¿½n a rellenar
		 */
		while(flag!=0) {
			
			System.out.println("Elige una opciï¿½n");
			System.out.println("1: Miembros");
			System.out.println("2: Tareas");
			System.out.println("0: Salir del programa");
			flag=sc.nextInt();
			int flag2 = -1;
			if (flag == 1) {
				while(flag2!=0){
					System.out.println("Elige una opciï¿½n");
					System.out.println("1: Aï¿½adir Miembro");
					System.out.println("2: Lista de Miembros");
					System.out.println("3: Eliminar Miembro");
					System.out.println("0: Volver al menu principal");
					flag2=sc.nextInt();
					if(flag2==1) {
						System.out.println("Añadir DNI");
						int id =sc.nextInt();
						System.out.println("Añdir Nombre");
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
					System.out.println("Elige una opciï¿½n");
					System.out.println("1: Aï¿½adir Tarea");
					System.out.println("2: Lista de Tareas");
					System.out.println("3: Modificar tarea");
					System.out.println("4: Eliminar Tarea");
					System.out.println("0: Volver al menu principal");
					flag2=sc.nextInt();
					if(flag2==1) {
						/**
						 * Aï¿½adir Tarea, habrï¿½ que elegir,  que estado tiene.
						 * Hay que hacer una serie de scaners para coger todos atribuos que tiene una tarea
						 * y mas tarde instanciar un objeto tarea con ests atributos.
						 * Hay que tener en cuenta que tambien se deberï¿½a poder aï¿½adir una tarea para aï¿½adir 
						 * los  atributos secundarios
						 * Tarea (String titulo, int id,  int coste, int beneficio, Requisito requisito, MiembroDeEquipo asignadoA, int estado)
						 */

						System.out.println("Añadir Titulo");
						String nom = sc.next();
						System.out.println("Añadir Identificador de tarea");
						int id =sc.nextInt();
						while(at.existeTarea(id)) {
							System.out.println("Tarea existente, Pruebe otro identificador:");
							id =sc.nextInt();
						}
						System.out.println("Aï¿½adir Coste");
						int cost =sc.nextInt();
						System.out.println("Aï¿½adir Beneficio");
						int ben =sc.nextInt();
						System.out.println("Aï¿½adir Estado (NUMERO) "
								+ "0: Pendiente "
								+ "1: En proceso "
								+ "2: Validaciï¿½n "
								+ "3: Terminado ");
						int est =sc.nextInt();
						if (est==0) {
							at.addTarea(new Tarea(nom,id,cost,ben,R,M,est));
						}
					} else if(flag2 == 2) {	
						System.out.println("Que tareas deseas mostrar:");
						System.out.println("1: Tareas en Product Backlog");
						System.out.println("2: Tareas en SprintBacklog");
						System.out.println("3: Todas las tareas");
						System.out.println("0: Volver al menu principal");
						
						//Aï¿½adir while para que se repita todo el rato el menu
						int tipo=sc.nextInt();
						/**
						 * Aqui hay que hacer un menu entre: todas, las del sprintbacklog o las de productBacklog, 
						 * en el iterador hay que hacer un if, filtrando seguï¿½n su estado.
						 */ 
						switch (tipo){
							case 0:
								break;
							case 1:
								/**
								 * Ha modificar para que te muestre solo
								 * los de estado = 0.
								 */
								at.getTarea();
								@SuppressWarnings("unused")
								String sTexto4 = br.readLine();
								break;
							case 2:
								/**
								 * Ha modificar para que te muestre solo 
								 * los de estado != 0.
								 */
								at.getTarea();
								@SuppressWarnings("unused")
								String sTexto0 = br.readLine();
								break;
							case 3:
								at.getTarea();
								@SuppressWarnings("unused")
								String sTexto1 = br.readLine();
								break;
							}
					} else if (flag2 == 3) {
						/**
						 * Para modificar tarea podriamos usar un patron OBSERVADOR, debido a que si cambia el estado de la tarea, 
						 * tambien debería cambiar de ProductBacklog a SprintBacklog, estos tendras listas de como ellos funcionan,
						 * y deberan ser actualizadas cada vez que se cambie una tarea
						 */

						System.out.println("Lista de tareas:");
						at.getTarea();
						System.out.println("Identificador de tarea a Modificar:");
						int id =sc.nextInt();
						System.out.println("Quieres modificar la tarea "+at.BuscarTarea(id).getTitulo()+" (S/N)");
						String est =sc.next();
						if (est.equals("S") || est.equals("s")) {
							System.out.println("Lo modificamos");
						}
					} else if (flag2==4) {


						System.out.println("Lista de las tareas existentes:");
						at.getTarea();
						System.out.println("Introduce el Id de la tarea a eliminar");
						int id =sc.nextInt();
						if(at.existeTarea(id)) {
							at.RemoveTarea(at.BuscarTarea(id));				
						} else {
							System.out.println("Esta tarea no existe");
						}
					}
				}
			}
		} 

		System.out.println("Proceso Finalizado");	
	}
		
}
