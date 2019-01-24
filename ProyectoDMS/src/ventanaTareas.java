import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ventanaTareas extends Vista {
	int flag2;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	@Override
	public int ventana(AdministradorDeTarea at,AdministradorDeMiembro am, AdministradorDeRequisito ar) {
		System.out.println("Elige una opciï¿½n");
		System.out.println("1: Aï¿½adir Tarea");
		System.out.println("2: Lista de Tareas");
		System.out.println("3: Modificar tarea");
		System.out.println("4: Asignar Miembro a tarea");
		System.out.println("5: Eliminar Tarea");
		System.out.println("0: Volver al menu principal");
		flag2=sc.nextInt();
		if(flag2!=0 && flag2!=1 && flag2!=2 && flag2!=3 && flag2!=4 && flag2!=5) {
			System.out.println("Error, parametro invalido vuelve a intentarlo");
		}
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
			//System.out.println("Aï¿½adir Estado (NUMERO) "
			//		+ "0: Pendiente "
			//		+ "1: En proceso "
			///		+ "2: Validaciï¿½n "
			//		+ "3: Terminado ");
			//int est =sc.nextInt();
			//if (est==0) {
			at.addTarea(new Tarea(nom,id,cost,ben,0));
			at.getProductBacklog().actualizar();
			//}else {
			//	at.addTarea(new Tarea(nom,id,cost,ben,est));
			//	at.getSprintBacklog().actualizar();
			//}
		} else if(flag2 == 2) {	
			int pregunta=0;
			System.out.println("Que tareas deseas mostrar:");
			System.out.println("1: Tareas en Product Backlog");
			System.out.println("2: Tareas en SprintBacklog");
			System.out.println("3: Todas las tareas");
			System.out.println("0: Volver al menu principal");
			
			//Aï¿½adir while para que se repita todo el rato el menu
			int tipo=sc.nextInt();
			if(tipo!=0 && tipo!=1 && tipo!=2 && tipo!=3) {
				System.out.println("Error, parametro invalido vuelve a intentarlo");
			}
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
					for(Tarea pb: at.getProductBacklog().getBacklog()) {
						System.out.println("Nombre:"+pb.titulo);
						System.out.println("ID:"+pb.getId());
						System.out.println("Estado:"+pb.estado);
						System.out.println("----------------------------------------");
					}
					break;
				case 2:
					/**
					 * Ha modificar para que te muestre solo 
					 * los de estado != 0.
					 */
					for(Tarea sb: at.getSprintBacklog().getBacklog()) {
						System.out.println("Nombre:"+sb.titulo);
						System.out.println("ID:"+sb.getId());
						System.out.println("Estado:"+sb.estado);
						System.out.println("----------------------------------------");
					}
					break;
				case 3:
					at.getTarea();
					
					break;
				}
			System.out.println("¿Que desea hacer?");
			System.out.println("1/ Mostrar todos los datos de una tarea ");
			System.out.println("0/ Volver atras");
			pregunta=sc.nextInt();
			if(pregunta!=0 && pregunta!=1) {
				System.out.println("Error, parametro invalido vuelve a intentarlo");
			}
			if(pregunta==1) {
				boolean bandera = false;
				while(!bandera) {
					System.out.println("¿Que tarea desea mostrar?");
					int idt=sc.nextInt();
					if(at.existeTarea(idt)) {
						at.getDatosTarea(at.BuscarTarea(idt));
						try {
							@SuppressWarnings("unused")
							String sTexto1 = br.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						bandera=true;
					}else {
						System.out.println("Tarea inexistente, Pruebe otra vez");	
					}
				}
			}
		} else if (flag2 == 3) {
			/**
			 * Para modificar tarea podriamos usar un patron OBSERVADOR, debido a que si cambia el estado de la tarea, 
			 * tambien debería cambiar de ProductBacklog a SprintBacklog, estos tendras listas de como ellos funcionan,
			 * y deberan ser actualizadas cada vez que se cambie una tarea
			 */
			System.out.println("Lista de tareas:");
			at.getTarea();
			at.modificarTarea();
			at.getProductBacklog().actualizar();
			at.getSprintBacklog().actualizar();
		} else if (flag2==5) {


			System.out.println("Lista de las tareas existentes:");
			at.getTarea();
			System.out.println("Introduce el Id de la tarea a eliminar");
			int id =sc.nextInt();
			if(at.existeTarea(id)) {
				at.RemoveTarea(at.BuscarTarea(id));				
			} else {
				System.out.println("Esta tarea no existe");
			}
		}else if (flag2 == 4) {
			at.getTarea();
			System.out.println("Elige tarea a la que asignar miembro:");
			System.out.println("Identificador de tarea a la que asignar miembro:");
			int idTarea =sc.nextInt();
			am.getMiembro();
			System.out.println("Elige miembro de equipo a añadir a tarea:");
			System.out.println("Identificador de tarea a la que asignar miembro:");
			int idMiembro =sc.nextInt();
			MiembroDeEquipo Asig = am.BuscarMiembro(idMiembro);
			at.asignarMiembro(Asig,idTarea);
			
		}
		return flag2;
	}
	}

