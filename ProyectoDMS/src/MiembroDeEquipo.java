import java.util.HashMap;
import java.util.Map;

public class MiembroDeEquipo {
	/**
	 * Clase ue se dedica a añadir miembros de equipo a la plantilla, para luego asignarles tareas
	 */
	Map<Integer,String> miembros = new HashMap<Integer, String>();
	int id;
	String nombre;
	/**
	 * constructor
	 */
	public MiembroDeEquipo() {
	}
	/**
	 * Metodo que elimina un miembro del equipo y acepta el identificador como tal
	 * @param id
	 */
	public void eliminarMiembro (int id) {
		miembros.remove(id);
	}
	/**
	 * Añadir miembro del equipo.
	 * @param id
	 * @param nombre
	 */
	public void addMiembro (int id,String nombre) {
		miembros.put(id, nombre);
	}
	/**
	 * Devolver la lista de los miembros de equipos.
	 */
	public void getmiembro () {
		System.out.println(miembros.values());
	}

}
