package arquivos;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

    public static void main(String[] args) throws IOException {

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

        /*Pode vir do banco de dados ou qualquer fonte de dados*/
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);

        File arquivo = new File("C:\\Users\\linde\\Documents\\Linguagem Java\\MeuBootcamp\\src\\arquivos\\arquivo.csv");
        if(!arquivo.exists()){
            arquivo.createNewFile();
        }

        FileWriter escreverNoArquivo = new FileWriter(arquivo);
        for(Pessoa p: pessoas){
            escreverNoArquivo.write(p.getNome()+"; "+p.getEmail()+"; "+p.getIdade()+"\n");
        }

        escreverNoArquivo.flush();
        escreverNoArquivo.close();
    }
}
