package arquivos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;


public class ApachePoiEditando {
	
	public static void main(String[] args) throws Exception{
		
		File file = new File("C:\\Users\\linde\\Documents\\Linguagem Java\\MeuBootcamp\\src\\arquivos\\arquivo_excel.xls");
		FileInputStream entrada = new FileInputStream(file);
		HSSFWorkbook hssFWorkbook = new HSSFWorkbook(entrada); /*Prepara a entrada do arquivo xls excel*/
		HSSFSheet planilha = hssFWorkbook.getSheetAt(0); /*Pegando a planilha*/
		
		Iterator<Row> linhaIterator = planilha.iterator();
		while(linhaIterator.hasNext()) {
			Row linha = linhaIterator.next();
			int numeroCelulas = linha.getPhysicalNumberOfCells();
			Cell cell = linha.createCell(numeroCelulas);/*Cria nova celular na linha*/
			cell.setCellValue("5.487,20");
		}
		
		entrada.close();
		FileOutputStream saida = new FileOutputStream(file);
		hssFWorkbook.write(saida);
		saida.flush();
		saida.close();
		System.out.println("Planilha atualizada");
	}

}
