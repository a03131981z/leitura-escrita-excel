package arquivos;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.util.List;
import java.util.ArrayList;

public class ApachePoi2 {

	public static void main(String[] args) throws Exception{
		
		FileInputStream entrada = new FileInputStream(new File("C:\\Users\\linde\\Documents\\Linguagem Java\\MeuBootcamp\\src\\arquivos\\arquivo_excel.xls"));
		HSSFWorkbook hssFWorkbook = new HSSFWorkbook(entrada);/*Prepara a entrada do arquivo excel para ler*/
		HSSFSheet planilha = hssFWorkbook.getSheetAt(0);//Pega a primeira planilha do nosso arquivo excel
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		while(linhaIterator.hasNext()) { /*Enquanto tiver linha no arquivo excel*/
			Row linha = linhaIterator.next();/*Dados da pessoa na linha*/
			
			Iterator<Cell> celulas = linha.iterator();
			Pessoa pessoa = new Pessoa();
			while(celulas.hasNext()) { /*Percorrer as c�lulas*/
				Cell cell = celulas.next();
				
				switch(cell.getColumnIndex()) {
					case 0:
						pessoa.setNome(cell.getStringCellValue());
						break;
					
					case 1:
						pessoa.setEmail(cell.getStringCellValue());
						break;
						
					case 2:
						pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
						break;
				}
				
			} /*Fim das celulas da linha*/
			pessoas.add(pessoa);
		}
		entrada.close(); /*Terminou de ler o arquivo excel*/
		for(Pessoa pessoa: pessoas) { /*Poderia gravar no banco de dados*/
			System.out.println(pessoa);
		}
	}
}
