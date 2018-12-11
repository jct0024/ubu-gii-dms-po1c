import java.util.HashSet;
import java.util.Iterator;

public class ProductBacklog extends Backlog{
	private HashSet<Tarea> ProductTareas= new HashSet<Tarea>();
	@Override
	protected void actualizar() {
		Iterator<Tarea> it = at.DevolverTareas().iterator();
		while(it.hasNext()) {
			Tarea t = (Tarea)it.next();
			if (t.getEstado() == 0) {
				ProductTareas.add(t);
			} else {
				if(ProductTareas.contains(t)) {
					ProductTareas.remove(t);
				}
			}
		}
	}
	@Override
	public HashSet<Tarea> getBacklog() {
		return ProductTareas;
		
	}
}
