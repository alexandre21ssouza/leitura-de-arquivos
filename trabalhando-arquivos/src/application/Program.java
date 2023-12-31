package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Comentários são para fins didáticos.
 */

public class Program {

	public static void main(String[] args) {
		//Buscando arquivo local com arquivo no parâmetro.
		File file = new File("C:\\Users\\Alexandre\\Documents\\apresentação");

		Scanner sc = null;
		try {
		//Modo de leitura usando classe Scanner.
			sc = new Scanner(file);
		//Testa se há uma nova linha, caso exista, imprime a mesma.
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		//Exception de erro de entrada ou saída.
		} catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
			
		} finally {
		//Se "sc" for diferente de nulo, executa o fechamento do Scanner(sc.close()).
			if(sc != null) {
			sc.close();
			}
		}
		
		//inserindo aqrquivos de outra maneira:
		String path = "C:\\Users\\Alexandre\\Documents\\apresentação";
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			//Faz a leitura do arquivo.
			fr = new FileReader(path);
			
			//Recebe variável(fr) para deixar a leitura mais rápida.
			br = new BufferedReader(fr);
			
			/*Faz a leitura de uma linha do arquivo(br) e vai para o teste
			 * While, caso seja linha única, não lê mais nenhuma pois será
			 * valor null, caso tenha mais linhas após esta, será diferente 
			 * de null e entra no laço While atá ser null.
			 */
			String line = br.readLine();
			
			//Laço while
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			
		} catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
			
		} finally {
			try {
			if(br != null) {
				br.close();
			}
			if(fr != null) {
				fr.close();
			}
		} catch(IOException e) {
			//Mostra o erro caso tenha alguma exception.
			e.printStackTrace();
		}
			
	  }
		//Simplificando o modo acima
		String pathh = "C:\\Users\\Alexandre\\Documents\\apresentação";
		
		try(BufferedReader brr = new BufferedReader(new FileReader(path))) {

			String linee = brr.readLine();

			while(linee != null) {
				System.out.println(linee);
				linee = brr.readLine();
			}
			
		} catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
			
		}
		
		
		//Criando Arquivo no programa
		
		String[] lines = new String[] {"BOm dia", "Boa tarde", "Boa noite"};
		
		//Endereço de armazenamento do arquivo criado
		String pathhh = "c:\\temp\\out.txt";
		
		/*True indica que o arquivo não deve ser recriado
		 *  todas as vezes que rodar o programa, mas sim 
		 *  salvar no final. 
		 */
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathhh, true))) {

	
			for(String line : lines) {
				//Escreve o array
				bw.write(line);
				//Faz ir para a linha de baixo a cada item 
				bw.newLine();
			}
			
		} catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
			
		}
	}
}

