import java.util.HashSet;
import java.util.Iterator;

public class ProductBacklog extends Backlog{

	
	@Override
	public void addTarea(Tarea t) {
		// TODO Auto-generated method stub
		t.setEstado(0);
		this.tarea.add(t);
	}

	@Override
	public void getTarea() {
		Iterator it = tarea.iterator();
		while(it.hasNext()) {
			Tarea t = (Tarea)it.next();

			System.out.println(t.getTitulo());
			System.out.println(t.getId());
		}
	}

}
