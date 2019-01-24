

public class ventanaPrincipal extends Vista {
	int flag,flag2;
	Vista miembro=new ventanaMiembros();
	Vista tarea=new ventanaTareas();
	Vista requisito=new ventanaRequisitos();
	
	public int ventana(AdministradorDeTarea at,AdministradorDeMiembro am, AdministradorDeRequisito ar) {
		System.out.println("Elige la opcion deseada");
		System.out.println("1: Miembros");
		System.out.println("2: Tareas");
		System.out.println("3: Requisitos");
		System.out.println("0: Salir del programa");
		flag=sc.nextInt();
		int flag2 = -1;
		if (flag == 1) {
			while(flag2!=0){
				flag2=miembro.ventana(at,am,ar);
			}
		} else if(flag ==2){
			while(flag2!=0){
				flag2=tarea.ventana(at,am,ar);
			}
		}else if(flag==3) {
			while(flag2!=0){
				flag2=requisito.ventana(at,am,ar);
			}
		}
		return flag;
	}
}
