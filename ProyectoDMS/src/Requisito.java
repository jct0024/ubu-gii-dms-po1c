import java.util.HashSet;
import java.util.Scanner;

public abstract class Requisito {
	protected int idrequisito;
	protected String nombre;
	protected String descripcion;
	protected HashSet<Tarea> requisitos;
	protected int finalizado=0;
	@SuppressWarnings("resource")
	protected Scanner sc = new Scanner(System.in);
	
	
	public int getIdrequisito() {
		return idrequisito;
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

	public void addTarea(Tarea tarea) {
		requisitos.add(tarea);
	}

	public int getFinalizado() {
		return finalizado;
	}

	public void finalizar() {
		int finalizado=1;
		
	}
	
	public Requisito Reabrir() {
		if (finalizado==1) {
			//Introducir motivo del cambio
			System.out.println("¿Cual es el motivo de volver a abrir el requisito?");
			String motivo = sc.next();
			Requisito defecto = new Defecto(motivo);
			return defecto;
		}else {
		return null;
		}	
	}

}
