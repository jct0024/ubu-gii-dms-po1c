import java.util.HashSet;
import java.util.Scanner;

public class HistoriaDeUsuario extends Requisito{
	
	private HashSet<Tarea> hisdeus= new HashSet<Tarea>();
	
	
	public HistoriaDeUsuario(String nombre, String descripcion,int idrequisito) {
		this.idrequisito=idrequisito;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.requisitos=new HashSet<Tarea>();
	}
	
	
	private void Sethisdeus(Tarea tarea) {
		System.out.println("¿Desea: 1) introducir o 2) borrar una Tarea?");
		Integer opcion = sc.nextInt();
		if (opcion==1) {
			hisdeus.add(tarea);
		}else {
			if(opcion==2) {
				hisdeus.add(tarea);
			}else {
				System.out.println("Opcion incorreta");
			}
		}
	}
	
	private HashSet<Tarea> Gethisdeus(){
		return hisdeus;
	}
	
	
	
	
	
	

}
