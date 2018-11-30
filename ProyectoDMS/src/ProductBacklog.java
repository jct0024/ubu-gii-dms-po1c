import java.util.Iterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProductBacklog extends Backlog{

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Crea una tarea y es guardad en un array comun de todos los backlog, 
	 * en el cual se encuentran todas las tareas
	 */
	@Override
	public void addTarea(Tarea t) {
		t.setEstado(0);
		this.tarea.add(t);
	}

	@Override
	public void getTarea() throws IOException {
		Iterator<Tarea> it = tarea.iterator();
		while(it.hasNext()) {
			Tarea t = (Tarea)it.next();
			if (t.getEstado() == 0) {
				System.out.println("Titulo: " + t.getTitulo());
				System.out.println("Identificador: "+t.getId());
				System.out.println("Estado: "+estados[t.getEstado()]);
				@SuppressWarnings("unused")
				String sTexto4 = br.readLine();
			}
		}
	}

}
