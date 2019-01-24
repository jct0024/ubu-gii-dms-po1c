import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Main {
	/**

	 * El main tendr� el menu necesarios y los atributos globales, para modificar y navegar por las
	 * diferentes opciones como se ve en el ejemplo de a�adir y ver miembro.
	 * Adem�s queda pediente de crear todas las tareas para comprobar cada ejemplo.
	 * @param args
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException, InvalidFormatException {

		Persistencia persistencia = new Persistencia();
		@SuppressWarnings("static-access")
		List<List<Object>> Mtareas =persistencia.readExcelFile(new File("C:\\Users\\Jesus\\eclipse-workspace\\ubu-gii-dms-po1c\\tareas.xls"));
		List<List<Object>> Musuarios =persistencia.readExcelFile(new File("C:\\Users\\Jesus\\eclipse-workspace\\ubu-gii-dms-po1c\\miembroDeEquipo.xls"));
		List<List<Object>> Mrequisitos =persistencia.readExcelFile(new File("C:\\Users\\Jesus\\eclipse-workspace\\ubu-gii-dms-po1c\\requisitos.xls"));
		//Variable que sirve para esperar, a que el usurio pulse enter para continuar con el programa.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//LLamamos al singlenton
		AdministradorDeTarea at = AdministradorDeTarea.getAdministrador();
		AdministradorDeMiembro am = AdministradorDeMiembro.getAdministrador();
		AdministradorDeRequisito ar = AdministradorDeRequisito.getAdministrador();
		persistencia.cargaDeDatos(Musuarios, Mtareas,Mrequisitos);
		Vista vista=new ventanaPrincipal();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int flag=10000;
		at.getProductBacklog().actualizar();
		at.getSprintBacklog().actualizar();
		/**
		 * Menu didactico para navegar por la aplicaci�n a rellenar
		 */
		while(flag!=0) {
			flag=vista.ventana(at,am,ar);
			 
		}
		
		persistencia.GuardarEnExcel();
		System.out.println("Proceso Finalizado, Se ha guardado correctamente");
	}
	
		
}
