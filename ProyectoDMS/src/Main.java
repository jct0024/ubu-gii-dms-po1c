import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	/**
	 * El main tendr� el menu necesarios y los atributos globales, para modificar y navegar por las
	 * diferentes opciones como se ve en el ejemplo de a�adir y ver miembro.
	 * Adem�s queda pediente de crear todas las tareas para comprobar cada ejemplo.
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//Variable que sirve para esperar, a que el usurio pulse enter para continuar con el programa.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//LLamamos al singlenton
		AdministradorDeTarea at = AdministradorDeTarea.getAdministrador();
		AdministradorDeMiembro am = AdministradorDeMiembro.getAdministrador();
		MiembroDeEquipo M1 = new MiembroDeEquipo(1,"JC");
		MiembroDeEquipo M2 = new MiembroDeEquipo(2,"Guille");
		MiembroDeEquipo M3 = new MiembroDeEquipo(3,"JA");
		MiembroDeEquipo M4 = new MiembroDeEquipo(4,"Pepa");
		am.addMiembro(M1);
		am.addMiembro(M2);
		am.addMiembro(M3);
		am.addMiembro(M4);
		Requisito R = new Requisito();
		Tarea a = new Tarea ("Desarrollar", 0,  20, 100,R, M1,3);
		Tarea b = new Tarea ("Dise�ar", 1,  20, 100,R, M2,2);
		Tarea c = new Tarea ("Procesar", 2,  20, 100,R, M3,1);
		Tarea d = new Tarea ("Revisar fallos", 3,  20, 100,R, M4,0);
		at.addTarea(a);
		at.addTarea(c);
		at.addTarea(d);
		at.addTarea(b);
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int flag=10000;
		at.getProductBacklog().actualizar();
		at.getSprintBacklog().actualizar();
		/**
		 * Menu didactico para navegar por la aplicaci�n a rellenar
		 */
		while(flag!=0) {
			
			System.out.println("Elige una opci�n");
			System.out.println("1: Miembros");
			System.out.println("2: Tareas");
			System.out.println("0: Salir del programa");
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
						while(am.existeMiembro(id)) {
							System.out.println("Miembro existente, Pruebe otro identificador:");
							id =sc.nextInt();
						}
						System.out.println("A�dir Nombre");
						String nom = sc.next();
						am.addMiembro(new MiembroDeEquipo(id, nom));
					} else if(flag2 == 2) {
						am.getMiembro();
					} else if (flag2 == 3) {
						System.out.println("Lista de los miembros existentes:");
						am.getMiembro();
						System.out.println("Introduce el Id deel miembro a eliminar");
						int id =sc.nextInt();
						if(am.existeMiembro(id)) {
							am.RemoveMiembro(am.BuscarMiembro(id));				
						} else {
							System.out.println("Este miembro no existe");
						}

					}
				}

			} else if(flag ==2){
				while(flag2!=0){
					System.out.println("Elige una opci�n");
					System.out.println("1: A�adir Tarea");
					System.out.println("2: Lista de Tareas");
					System.out.println("3: Modificar tarea");
					System.out.println("4: Eliminar Tarea");
					System.out.println("0: Volver al menu principal");
					flag2=sc.nextInt();
					if(flag2==1) {
						/**
						 * A�adir Tarea, habr� que elegir,  que estado tiene.
						 * Hay que hacer una serie de scaners para coger todos atribuos que tiene una tarea
						 * y mas tarde instanciar un objeto tarea con ests atributos.
						 * Hay que tener en cuenta que tambien se deber�a poder a�adir una tarea para a�adir 
						 * los  atributos secundarios
						 * Tarea (String titulo, int id,  int coste, int beneficio, Requisito requisito, MiembroDeEquipo asignadoA, int estado)
						 */

						System.out.println("A�adir Titulo");
						String nom = sc.next();
						System.out.println("A�adir Identificador de tarea");
						int id =sc.nextInt();
						while(at.existeTarea(id)) {
							System.out.println("Tarea existente, Pruebe otro identificador:");
							id =sc.nextInt();
						}
						System.out.println("A�adir Coste");
						int cost =sc.nextInt();
						System.out.println("A�adir Beneficio");
						int ben =sc.nextInt();
						System.out.println("A�adir Estado (NUMERO) "
								+ "0: Pendiente "
								+ "1: En proceso "
								+ "2: Validaci�n "
								+ "3: Terminado ");
						int est =sc.nextInt();
						if (est==0) {
							at.addTarea(new Tarea(nom,id,cost,ben,R,M1,est));
						}
					} else if(flag2 == 2) {	
						System.out.println("Que tareas deseas mostrar:");
						System.out.println("1: Tareas en Product Backlog");
						System.out.println("2: Tareas en SprintBacklog");
						System.out.println("3: Todas las tareas");
						System.out.println("0: Volver al menu principal");
						
						//A�adir while para que se repita todo el rato el menu
						int tipo=sc.nextInt();
						/**
						 * Aqui hay que hacer un menu entre: todas, las del sprintbacklog o las de productBacklog, 
						 * en el iterador hay que hacer un if, filtrando segu�n su estado.
						 */ 
						switch (tipo){
							case 0:
								break;
							case 1:
								/**
								 * Ha modificar para que te muestre solo
								 * los de estado = 0.
								 */
								@SuppressWarnings("unused")
								String sTexto4 = br.readLine();
								break;
							case 2:
								/**
								 * Ha modificar para que te muestre solo 
								 * los de estado != 0.
								 */
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
						 * tambien deber�a cambiar de ProductBacklog a SprintBacklog, estos tendras listas de como ellos funcionan,
						 * y deberan ser actualizadas cada vez que se cambie una tarea
						 */
						System.out.println("Lista de tareas:");
						at.getTarea();
						at.modificarTarea();
						at.getProductBacklog().actualizar();
						at.getSprintBacklog().actualizar();
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
