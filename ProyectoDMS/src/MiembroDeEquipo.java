import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MiembroDeEquipo {
	/**
	 * Clase ue se dedica a añadir miembros de equipo a la plantilla, para luego asignarles tareas
	 */
	int id;
	String nombre;
	/**
	 * constructor
	 */
	public MiembroDeEquipo(int d,String nombre) {
		this.id= d;
		this.nombre=nombre;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}
