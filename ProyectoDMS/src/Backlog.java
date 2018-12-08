import java.util.HashSet;

public abstract class Backlog {
	protected abstract void actualizar();
	protected abstract HashSet<Tarea> getBacklog();
	protected AdministradorDeTarea at = AdministradorDeTarea.getAdministrador();
}
