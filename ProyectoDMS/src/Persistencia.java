import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Persistencia {
	AdministradorDeTarea at = AdministradorDeTarea.getAdministrador();
	AdministradorDeMiembro am = AdministradorDeMiembro.getAdministrador();
	AdministradorDeRequisito ar = AdministradorDeRequisito.getAdministrador();
	public void cargaDeDatos(List<List<Object>> Musuarios,List<List<Object>> Mtareas, List<List<Object>> Mrequisitos) {
	/**
	 * Cargamos a la lista del administrador de miembros todos los miembros que tenemos
	*/
	for (List<Object> l: Musuarios) {
		am.addMiembro(new MiembroDeEquipo((int)l.get(0),(String)l.get(1)));
	}
	/**
	 * Cargamos a la lista de administrador de tareas todas las tareas que se encuentran en la base de datos, 
	 * si no tiene miembro se le pone  a null sino se le añade un miembro.
	 */
	for (List<Object> l: Mtareas) {
		at.addTarea(new Tarea((String)l.get(0),(int)l.get(1),(int)l.get(2),(int)l.get(3),(int)l.get(6)));
		//Si tiene un miembro asignado (cualquier id mayor que cero) le añade el miembro de equipo, sino null
		if(0 < (int)l.get(5)) {
			at.BuscarTarea((int)l.get(1)).setAsignadoA(am.BuscarMiembro((int) l.get(5)));
		}else {
			at.BuscarTarea((int)l.get(1)).setAsignadoA(null);
		}
		//Si tiene un requisito (cualquier id maor que cero) le añade el requisito, sino null
		if(0 < (int)l.get(4)) {
			at.BuscarTarea((int)l.get(1)).setRequisito(ar.BuscarRequisito((int) l.get(4)));
		}else {
			at.BuscarTarea((int)l.get(1)).setRequisito(null);
		}
		at.BuscarTarea((int)l.get(1)).setDescripcion((String)l.get(7));
	}
	/**
	 * Cargamos la lista del administrador de requisitos con todos los requisitos que tenemos,
	 *  si el requisito tiene 5 atributos, será un defecto, sino será una historia de usuario
	 */
	for (List<Object> l: Mrequisitos) {
		HashSet<Tarea> lista = new HashSet<Tarea>();
		//Buscamos todas las tareas que tengan este requisito, para tener una lista de las tareas que este tiene
		for(List<Object> t: Mtareas) {
			if(l.get(0)==t.get(4)) {
				lista.add(at.BuscarTarea((int)t.get(1)));
			}
		}
		//Creamos defecto o historiaDeUsuario, según sea el caso y lo añadimos a la lista generica de Requisitos.
		if(l.size()==5) {
			Defecto req = new Defecto((String)l.get(4),(String) l.get(0), (String)l.get(1),(int)l.get(2),lista);
			if((int)l.get(3)==1) {
			req.finalizar();
			}
			ar.addRequisito(req);
		}else {
			HistoriaDeUsuario req = new HistoriaDeUsuario((String) l.get(0), (String)l.get(1),(int)l.get(2));
			if(!lista.isEmpty()) {
				req.setHisdeus(lista);
			}
			if((int)l.get(3)==1) {
			req.finalizar();
			}
			ar.addRequisito(req);		
		}
	}
}
	/**
	 * Función que carga a modo de matriz todos los datos de las bases de datos, para despues procesarlos a objetos y poder trabajar con ellos
	 * @param excelFile fichero que pasamos como parametro donde se encuentran las bases de datos.
	 * @return fila Es la matriz, que al ser una lista de listas, fila es la lista de todas las columnas.
	 */
	public static List<List<Object>> readExcelFile(File excelFile){
        InputStream excelStream = null;
        try {
        	List<List<Object>> filas = new ArrayList<List<Object>>();
        	List<Object> columnas = new ArrayList<Object>();
            excelStream = new FileInputStream(excelFile);
            // Representación del más alto nivel de la hoja excel.
            Workbook workbook = WorkbookFactory.create(excelFile);
            // Elegimos la hoja que se pasa por parámetro.
            Sheet sheet = workbook.getSheetAt(0);
            // Objeto que nos permite leer un fila de la hoja excel, y de aquí extraer el contenido de las celdas.
            Row Row;
            // Inicializo el objeto que leerá el valor de la celda
            Cell cell;                        
            // Obtengo el número de filas ocupadas en la hoja
            int rows = sheet.getLastRowNum();
            // Obtengo el número de columnas ocupadas en la hoja
            int cols = 0;            
            // Cadena que usamos para almacenar la lectura de la celda
            Object cellValue;  
            Integer id;
            // Para este ejemplo vamos a recorrer las filas obteniendo los datos que queremos            
            for (int r = 0; r <= rows; r++) {
                Row = sheet.getRow(r);
                if (Row == null){
                    break;
                }else{
                    for (int c = 0; c < (cols = Row.getLastCellNum()); c++) {
                        cellValue = Row.getCell(c) == null?"":
                        	(Row.getCell(c).getCellType() == CellType.NUMERIC)?"" + Row.getCell(c).getNumericCellValue():
                                (Row.getCell(c).getCellType() == CellType.STRING)?Row.getCell(c).getStringCellValue():
                                (Row.getCell(c).getCellType() == CellType.BOOLEAN)?"" + Row.getCell(c).getBooleanCellValue():
                                (Row.getCell(c).getCellType() == CellType.BLANK)?"BLANK":
                                (Row.getCell(c).getCellType() == CellType.FORMULA)?"FORMULA":
                                (Row.getCell(c).getCellType() == CellType.ERROR)?"ERROR":"";
                        if(Row.getCell(c).getCellType() == CellType.NUMERIC) {
                        	id = (int) Row.getCell(c).getNumericCellValue();
                        	columnas.add(id);
                        }
                        else {
                        	columnas.add(cellValue);
                        }
                        
                    }
                    filas.add(columnas);
                    columnas = new ArrayList<Object>();
                }
            }
			workbook.close();
            return filas;
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file not exists (No se encontró el fichero): " + fileNotFoundException);
        } catch (IOException ex) {
            System.out.println("Error in file procesing (Error al procesar el fichero): " + ex);
        } finally {
            try {
                excelStream.close();
            } catch (IOException ex) {
                System.out.println("Error in file processing after close it (Error al procesar el fichero después de cerrarlo): " + ex);
            }
        }
    return null;
    }
	/**
	 * 
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	public static void GuardarEnExcel() throws IOException, InvalidFormatException {	
		AdministradorDeTarea at = AdministradorDeTarea.getAdministrador();
		AdministradorDeMiembro am = AdministradorDeMiembro.getAdministrador();
		AdministradorDeRequisito ar = AdministradorDeRequisito.getAdministrador();
		HashSet<MiembroDeEquipo> usuarios = am.DevolverTareas();
		HashSet<Tarea> tareas = at.DevolverTareas();
		HashSet<Requisito> requisitos = ar.DevolverRequisitos();
		String ruta = "C:\\Users\\Jesus\\eclipse-workspace\\ubu-gii-dms-po1c\\miembroDeEquipo.xls";
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("Hoja1");
		int fila=0;
		for(MiembroDeEquipo m : usuarios) {
			Row row = sheet.createRow(fila);
			Cell cell= row.createCell(0);
			cell.setCellValue(m.getId());
			cell= row.createCell(1);
			cell.setCellValue(m.getNombre());
			fila = fila+1;
		}
		File file;
		file=new File(ruta);
		try(FileOutputStream fileOut = new FileOutputStream(file)){
			if (file.exists()) {
				file.delete();
			}
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
			wb.close();
			System.out.println("Archivo Creado");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		fila=0;
		for(Tarea t : tareas) {
			Row row = sheet.createRow(fila);
			Cell cell= row.createCell(0);
			cell.setCellValue(t.getTitulo());
			
			cell= row.createCell(1);
			cell.setCellValue(t.getId());
			
			cell= row.createCell(2);
			cell.setCellValue(t.getCoste());
			
			cell= row.createCell(3);
			cell.setCellValue(t.getBeneficio());
			
			cell= row.createCell(4);			
			if (t.getRequisito()!= null) {
				cell.setCellValue(t.getRequisito().getIdrequisito());
			}else {
				cell.setCellValue(-1);
			}
			cell= row.createCell(5);
			if (t.getAsignadoA() != null) {
				cell.setCellValue(t.getAsignadoA().getId());
			}else {
				cell.setCellValue(-1);
			}
			cell= row.createCell(6);
			cell.setCellValue(t.getEstado());
			cell= row.createCell(7);
			cell.setCellValue(t.getDescripcion());
			fila = fila+1;
		}
		file=new File("C:\\Users\\Jesus\\eclipse-workspace\\ubu-gii-dms-po1c\\tareas.xls");
		try(FileOutputStream fileOut = new FileOutputStream(file)){
			if (file.exists()) {
				file.delete();
			}
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
			wb.close();
			System.out.println("Archivo Creado");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
      /**
       * Pasamos a la carga de datos de todos los requisitos
       * 
       * 
       */
		fila=0;
		for(Requisito r : requisitos) {
			Row row = sheet.createRow(fila);
			Cell cell= row.createCell(0);
			cell.setCellValue(r.getNombre());
			
			cell= row.createCell(1);
			cell.setCellValue(r.getDescripcion());
			
			cell= row.createCell(2);
			cell.setCellValue(r.getIdrequisito());
			
			cell= row.createCell(3);
			cell.setCellValue(r.getFinalizado());
			if(r instanceof Defecto) {
				cell= row.createCell(4);
				cell.setCellValue(((Defecto) r).getCambio());
			}
			

			fila = fila+1;
		}
		file=new File("C:\\Users\\Jesus\\eclipse-workspace\\ubu-gii-dms-po1c\\requisitos.xls");
		try(FileOutputStream fileOut = new FileOutputStream(file)){
			if (file.exists()) {
				file.delete();
			}
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
			wb.close();
			System.out.println("Archivo Creado");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
      
	}
	
}
