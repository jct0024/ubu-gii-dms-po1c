import java.util.HashSet;

public class ProductBacklog extends Backlog{

	
	@Override
	public void addTarea(Tarea t) {
		// TODO Auto-generated method stub
		t.setEstado(0);
		this.tarea.add(t);
	}

	@Override
	public HashSet<Tarea> getTarea() {
		return tarea;
	}

}
