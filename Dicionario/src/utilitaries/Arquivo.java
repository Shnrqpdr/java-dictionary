package utilitaries;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
// import java.nio.file.Files;
import java.util.ArrayList;

import entity.Palavra;

public class Arquivo {
	
	public static boolean escreveArquivo(ArrayList<Palavra> words) {
		
		String path = "C:\\Users\\pedro\\Documents\\Projetos\\Teste\\java-dictionary\\Dicionario\\src"; //trocar o caminho aqui.
		
		File arquivo = new File(path);
		
		arquivo.delete(); //deleta o antigo arquivo, para recriá-lo a seguir e assim mantê-lo sempre atualizado com o banco.
		
		try {
			
			arquivo.createNewFile();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(arquivo.exists() && arquivo.isFile()) {
			
			try {
				
				FileWriter fw = new FileWriter(arquivo, true);
				BufferedWriter bw = new BufferedWriter(fw);
				
				for (Palavra palavra : words) {
					bw.append(palavra.toString(true));
				}
				
				bw.close();
				fw.close();
							
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		else {
			return false;
		}
		
		return true;
	}

}
