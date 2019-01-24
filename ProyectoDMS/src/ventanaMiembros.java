import java.util.Scanner;

public class ventanaMiembros extends Vista {
	//int opcion=0;
	int flag2;

	@Override
	public int ventana(AdministradorDeTarea at,AdministradorDeMiembro am, AdministradorDeRequisito ar) {
		
		// TODO Auto-generated method stub
		System.out.println("¿Que desea hacer?");
		System.out.println("1: Aï¿½adir Miembro");
		System.out.println("2: Mostrar Lista de Miembros");
		System.out.println("3: Eliminar Miembro");
		System.out.println("0: Volver al menu principal");
		flag2=sc.nextInt();
		if(flag2!=0 && flag2!=1 && flag2!=2 && flag2!=3) {
			System.out.println("Error, parametro invalido vuelve a intentarlo");
		}
		if(flag2==1) {
			System.out.println("Añadir DNI");
			int id =sc.nextInt();
			while(am.existeMiembro(id)) {
				System.out.println("Miembro existente, Pruebe otro identificador:");
				id =sc.nextInt();
			}
			System.out.println("Añdir Nombre");
			String nom = sc.next();
			am.addMiembro(new MiembroDeEquipo(id, nom));
		} else if(flag2 == 2) {
			am.getMiembro();
		} else if (flag2 == 3) {
			System.out.println("Lista de los miembros existentes:");
			am.getMiembro();
			System.out.println("Introduce el Id del miembro a eliminar");
			int id =sc.nextInt();
			if(am.existeMiembro(id)) {
				am.RemoveMiembro(am.BuscarMiembro(id));				
			} else {
				System.out.println("Este miembro no existe");
			}
				
		}
		return flag2;
	}
	
	//public void SetOpcion(int opcion) {
	//	this.opcion=opcion;
	//}

	
	
}
