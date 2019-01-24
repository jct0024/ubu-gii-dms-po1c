import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public abstract class Requisito {
	protected int idrequisito;
	protected String nombre;
	protected String descripcion;
	protected HashSet<Tarea> requisitos;
	protected int finalizado=0;
	Requisito defecto;
	@SuppressWarnings("resource")
	protected Scanner sc = new Scanner(System.in);
	
	
	public int getIdrequisito() {
		return idrequisito;
	}
	
	public void setIdrequisito(int idrequisito) {
		this.idrequisito=idrequisito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public HashSet<Tarea> getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(HashSet<Tarea> requisito) {
		requisitos = requisito;
	}

	public void addTarea(Tarea tarea) {
		requisitos.add(tarea);
	}

	public int getFinalizado() {
		return finalizado;
	}

	public void finalizar() {
		this.finalizado=1;
		
	}
	
	public  boolean existeTarea(int id) {
		Iterator<Tarea> it = requisitos.iterator();
		while(it.hasNext()) {
			Tarea t = (Tarea)it.next();
			if (t.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	
	public Requisito Reabrir() {
		if (finalizado==1) {
			//Introducir motivo del cambio
			System.out.println("¿Cual es el motivo de volver a abrir el requisito?");
			String motivo = sc.next();
			this.defecto = new Defecto(motivo,nombre,descripcion,idrequisito,requisitos);
			return defecto;
		}else {
			System.out.println("No se puede abrir un requisito que esta abierto");
			return null;
		}	
	}

}
