import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class Backlog {
	private static String[] estados = {"Pendiente","En_proceso","Validacion","Terminado"};
	protected HashSet<Tarea> tarea= new HashSet<Tarea>();
	
	/**
	 *
	 * Aqui aņadiriamos la tarea, pues en cuanto se crea una tarea va a ir a un 
	 * tipo de baclog, con eso crearimos los metodos y pasariamos los atributos de cada backlog
	 * @param id
	 */
	public abstract void addTarea(Tarea t);
}
