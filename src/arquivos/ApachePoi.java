package arquivos;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {

	public static void main(String[] args) throws Exception{
		
		File file = new File("C:\\Users\\linde\\Documents\\Linguagem Java\\MeuBootcamp\\src\\arquivos\\arquivo_excel.xls");
		if(!file.exists()) {
			file.createNewFile();
		}
		
		Pessoa pessoa1 = new Pessoa();
        pessoa1.setEmail("pessoa1@gmail.com");
        pessoa1.setIdade(29);
        pessoa1.setNome("Selena");

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Emma");
        pessoa2.setEmail("pessoa2@gmail.com");
        pessoa2.setIdade(31);

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNome("Taylor");
        pessoa3.setEmail("pessoa3@gmail.com");
        pessoa3.setIdade(31);

        Pessoa pessoa4 = new Pessoa();
        pessoa4.setNome("Limadruga");
        pessoa4.setEmail("pessoa4@gmail.com");
        pessoa4.setIdade(26);

        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);
        
        HSSFWorkbook hssFWorkbook = new HSSFWorkbook();/*Vai ser usado para escrever a planilha*/
        HSSFSheet linhasPessoas = hssFWorkbook.createSheet("Planilha de pessoas JDev Treinamentos");/*Criar a planilha*/
        
        int numeroLinha = 0;
        for(Pessoa p: pessoas) {
        	Row linha = linhasPessoas.createRow(numeroLinha++);/*Criando a linha da planilha*/
        	int celula = 0;
        	
        	Cell celNome = linha.createCell(celula++);/*Célula 1*/
        	celNome.setCellValue(p.getNome());
        	
        	Cell celEmail = linha.createCell(celula++);/*Célula 2*/
        	celEmail.setCellValue(p.getEmail());
        	
        	Cell celIdade = linha.createCell(celula++);/*Célula 3*/
        	celIdade.setCellValue(p.getIdade());
        
        }/*Termino de montar a planilha*/
        FileOutputStream saida = new FileOutputStream(file);
        hssFWorkbook.write(saida);/*Escreve planilha em arquivo*/
        saida.flush();
        saida.close();
        System.out.println("Planilha foi criada");
	}
}
