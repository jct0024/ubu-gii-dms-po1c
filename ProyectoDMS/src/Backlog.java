import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public abstract class Backlog {
	protected static String[] estados = {"Pendiente","En_proceso","Validacion","Terminado"};
	protected HashSet<Tarea> tarea= new HashSet<Tarea>();
	
	/**
	 *
	 * Aqui añadiriamos la tarea, pues en cuanto se crea una tarea va a ir a un 
	 * tipo de baclog, con eso crearimos los metodos y pasariamos los atributos de cada backlog
	 * @param id
	 */
	/*
	public abstract void addTarea(Tarea t);
	public abstract void getTarea() throws IOException;
	*/
}
