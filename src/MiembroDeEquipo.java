import java.util.HashMap;
import java.util.Map;

public class MiembroDeEquipo {
	Map<Integer,String> miembros = new HashMap<Integer, String>();
	
	public void a�adirMiembro (	int id, String nombre) {
		miembros.put(id, nombre);
	}
	public void eliminarMiembro (int id) {
		miembros.remove(id);
	}
}
