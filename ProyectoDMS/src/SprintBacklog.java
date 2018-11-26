import java.util.HashSet;

public class SprintBacklog extends Backlog{
	
	/**
	 * Se cambia el estado de la tarea a uno que no sea pendiente, 
	 * a aprtir de aqui modificariamos su estado con un indice, en base al
	 * array que hemos creado antes.
	 */
	@Override
	public void addTarea(Tarea t) {
		// TODO Auto-generated method stub
		t.setEstado(1);
		this.tarea.add(t);
	}

	@Override
	public HashSet<Tarea> getTarea() {
		return tarea;
	}
}
