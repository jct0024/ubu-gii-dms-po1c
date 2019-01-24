
public class ventanaRequisitos extends Vista {
	int flag2;
	
	@Override
	int ventana(AdministradorDeTarea at,AdministradorDeMiembro am, AdministradorDeRequisito ar) {
		System.out.println("Elige una opciï¿½n");
		System.out.println("1: Aï¿½adir Requisito");
		System.out.println("2: Lista de Requisitos");
		System.out.println("3: Modificar Requisito");
		System.out.println("4: Eliminar Requisito");
		System.out.println("0: Volver al menu principal");
		flag2=sc.nextInt();
		if(flag2!=0 && flag2!=1 && flag2!=2 && flag2!=3 && flag2!=4) {
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
			System.out.println("Añadir Nombre");
			String nom = sc.next();
			System.out.println("Añadir Identificador de requisito");
			int id =sc.nextInt();
			while(ar.existeRequisito(id)) {
				System.out.println("Requisito existente, Pruebe otro identificador:");
				id =sc.nextInt();
			}
			System.out.println("Aï¿½adir Descripcion");
			String descripcion =sc.next();
			ar.addRequisito(new HistoriaDeUsuario(nom,descripcion, id));
			int resp=1;
			while(resp!=0) {
				System.out.println("Introduce id de tarea que deas añadir");
				int tareid =sc.nextInt();
				if (at.existeTarea(tareid) && !ar.BuscarRequisito(id).existeTarea(tareid)) {
					ar.BuscarRequisito(id).addTarea(at.BuscarTarea(tareid));
				}else {
					if(ar.BuscarRequisito(id).getRequisitos().size()==0 && at.existeTarea(tareid)) {
						ar.BuscarRequisito(id).addTarea(at.BuscarTarea(tareid));
						
					}else {
						if(ar.BuscarRequisito(id).existeTarea(tareid)) {
							System.out.println("Esa Tarea ya se encuentra asignado al requisito ");
						}
						while(!ar.BuscarRequisito(id).existeTarea(tareid)) {
							if(at.existeTarea(tareid)) {
								ar.BuscarRequisito(id).addTarea(at.BuscarTarea(tareid));
							}else {
								System.out.println("Esa tarea no existe, introduce otro id ");
								tareid =sc.nextInt();
							}
						}
					}
				}
				System.out.println("¿Deseas introducir mas tareas?");
				System.out.println("1) Si");
				System.out.println("0) No");
				resp=sc.nextInt();
				if(resp!=0 && resp!=1) {
					System.out.println("Error, parametro invalido vuelve a intentarlo");
				}
			}
	
		} else if(flag2 == 2) {	
			ar.getRequisitos();
		} else if(flag2 == 3) {
			ar.modificarRequisito(at);
		} else if(flag2 == 4) {
			System.out.println("Introduce id del requisito que deseas eliminar");
			int reid =sc.nextInt();
			if (ar.existeRequisito(reid)) {
				ar.RemoveRequisito(ar.BuscarRequisito(reid));
			}else {
				int paso=0;
				while(paso==0) {
					System.out.println("Ese requisito no existe introduce otro id");
					reid =sc.nextInt();
					if (ar.existeRequisito(reid)) {
						ar.RemoveRequisito(ar.BuscarRequisito(reid));
						paso=1;
					}
				}
			}

		}
		return flag2;
	}
	
	
	
}
