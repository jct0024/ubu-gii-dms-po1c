import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public abstract class Backlog {
	protected static String[] estados = {"Pendiente","En_proceso","Validacion","Terminado"};
	protected HashSet<Tarea> tarea= new HashSet<Tarea>();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
<<<<<<< Updated upstream
	/*
	public abstract void addTarea(Tarea t);
	public abstract void getTarea() throws IOException;
	*/
=======
	public  boolean existeTarea(int id) {
/*		Iterator<Tarea> it = tarea.iterator();
			while(it.hasNext()) {
				Tarea t = it.next();
				System.out.println("Este es el nombre:"+t.getTitulo());
				System.out.println("Este es el id:"+t.id);
				if (t.id == id) {
				return true;
			}
		}
		return false;
		*/
		for(Tarea t: tarea) {
			System.out.println("Este es el nombre:"+t.getTitulo());
			System.out.println("Este es el id:"+t.id);
			if(t.id == id) {

				return true;
			}
		}
		return false;
	}
>>>>>>> Stashed changes
}
