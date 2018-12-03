import java.util.HashSet;
import java.util.Iterator;

public class SprintBacklog extends Backlog{
	private HashSet<Tarea> SprintTareas= new HashSet<Tarea>();
	public void actualizar () {
		AdministradorDeTarea at = AdministradorDeTarea.getAdministrador();
	}
}
