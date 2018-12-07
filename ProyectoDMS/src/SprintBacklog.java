import java.util.HashSet;
import java.util.Iterator;

public class SprintBacklog extends Backlog{
	private HashSet<Tarea> SprintBacklog= new HashSet<Tarea>();
	AdministradorDeTarea at = AdministradorDeTarea.getAdministrador();
	@Override
	protected void actualizar() {
		Iterator<Tarea> it = at.DevolverTareas().iterator();
		while(it.hasNext()) {
			Tarea t = (Tarea)it.next();
			if (t.getEstado() == 0) {
				SprintBacklog.add(t);
			}
		}
	}
	public HashSet<Tarea> getSprintBacklog() {
		return SprintBacklog;
		
	}

}
