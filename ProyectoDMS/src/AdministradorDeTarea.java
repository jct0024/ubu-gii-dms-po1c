import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;

public class AdministradorDeTarea {
	private HashSet<Tarea> tarea= new HashSet<Tarea>();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	protected static String[] estados = {"Pendiente","En_proceso","Validacion","Terminado"};
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
	public void getTarea() throws IOException {
		Iterator<Tarea> it = tarea.iterator();
		while(it.hasNext()) {
			Tarea t = (Tarea)it.next();
				System.out.println("Titulo: " + t.getTitulo());
				System.out.println("Identificador: "+t.getId());
				System.out.println("Estado: "+estados[t.getEstado()]);
				@SuppressWarnings("unused")
				String sTexto4 = br.readLine();
		}
	}
}
