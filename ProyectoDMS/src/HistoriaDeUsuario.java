import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class HistoriaDeUsuario extends Requisito{
	
	
	
	public HistoriaDeUsuario(String nombre, String descripcion,int idrequisito) {
		this.idrequisito=idrequisito;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.requisitos=new HashSet<Tarea>();
	}


	

}
