import java.util.HashSet;
import java.util.Iterator;

public class SprintBacklog extends Backlog{
	private HashSet<Tarea> SprintBacklog= new HashSet<Tarea>();
	@Override
	protected void actualizar() {
		Iterator<Tarea> it = at.DevolverTareas().iterator();
		while(it.hasNext()) {
			Tarea t = (Tarea)it.next();
			if (t.getEstado() != 0) {
				SprintBacklog.add(t);
			}
		}
	}
	@Override
	public HashSet<Tarea> getBacklog() {
		return SprintBacklog;
		
	}

}
