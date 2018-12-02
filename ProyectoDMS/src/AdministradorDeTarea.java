
import java.util.HashSet;
import java.util.Iterator;

public class AdministradorDeTarea {
	private HashSet<Tarea> tarea= new HashSet<Tarea>();
	public void addTarea(Tarea t) {
		this.tarea.add(t);
	}
	public  boolean existeTarea(int id) {
		Iterator<Tarea> it = tarea.iterator();
		while(it.hasNext()) {
			Tarea t = (Tarea)it.next();
			if (t.getId() == id) {
				return true;
			}
		}
		return false;
	}
	public void getTarea() {
		Iterator<Tarea> it = tarea.iterator();
		while(it.hasNext()) {
			Tarea t = (Tarea)it.next();
				System.out.println("Titulo: " + t.getTitulo());
				System.out.println("Identificador: "+t.getId());
		}
	}
}
