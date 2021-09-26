package arquivos;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EscreveJSON {

	public static void main(String[] args) throws IOException{
		
		Usuario usuario1 = new Usuario();
		usuario1.setNome("Lindembergh");
		usuario1.setLogin("limadruga");
		usuario1.setSenha("12345");
		usuario1.setCpf("093847473");
		
		Usuario usuario2 = new Usuario();
		usuario2.setNome("Arthur");
		usuario2.setLogin("arthur.2011");
		usuario2.setSenha("3225644");
		usuario2.setCpf("9403204892");
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonUser = gson.toJson(usuarios);
		System.out.println(jsonUser);
		
		FileWriter fileWriter = new FileWriter("C:\\Users\\linde\\Documents\\Linguagem Java\\MeuBootcamp\\src\\arquivos\\fileJson.json");
		fileWriter.write(jsonUser);
		fileWriter.flush();
		fileWriter.close();
	}
}
