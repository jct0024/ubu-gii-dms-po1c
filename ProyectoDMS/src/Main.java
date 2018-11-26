import java.util.ArrayList;
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
		MiembroDeEquipo M = new MiembroDeEquipo();
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
			if (flag == 1) {
				int flag2 = -1;
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

			} else if(flag ==1){
				System.out.println("Hola");
			} 
			
		}

		System.out.println("Proeso Finalizado");	
		
	}
}
