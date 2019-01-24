import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class HistoriaDeUsuario extends Requisito{
	
	private HashSet<Tarea> hisdeus= new HashSet<Tarea>();
	
	
	public HistoriaDeUsuario(String nombre, String descripcion,int idrequisito) {
		this.idrequisito=idrequisito;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.requisitos=new HashSet<Tarea>();
	}


	public HashSet<Tarea> getHisdeus() {
		return hisdeus;
	}


	public void setHisdeus(HashSet<Tarea> hisdeus) {
		this.hisdeus = hisdeus;
	}
	

}
