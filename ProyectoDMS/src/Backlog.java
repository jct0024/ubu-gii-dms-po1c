import java.util.HashSet;

public abstract class Backlog {
	protected HashSet<Tarea> tarea= new HashSet<Tarea>();
	/**
	 * Aqui añadiriamos la tarea, pues en cuanto se crea una tarea va a ir a un 
	 * tipo de baclog, con eso crearimos los metodos y pasariamos los atributos de cada backlog
	 * @param id
	 */
	public abstract void addTarea(int id);
}
