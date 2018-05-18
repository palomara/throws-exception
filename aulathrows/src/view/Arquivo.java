package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Arquivo {

	public void inserir(String texto) throws IOException {
		//Gravação 
		FileWriter arq = new FileWriter("d:\\teste.txt", true);
		PrintWriter gravarArq = new PrintWriter(arq);
		
		gravarArq.println(texto);
		
		arq.close();
	}
	
	public void leitura (String texto) throws IOException {
		//Leitura
		FileReader arqleitura = new FileReader ("d:\\teste.txt");
		BufferedReader lerArq = new BufferedReader(arqleitura);
		
		String linha = lerArq.readLine();
		
		int i = 0;
		
		while (linha != null) {
			i++;
			if(linha.contains(texto)) {
			System.out.println("linha: " + i + " conteúdo: " + linha);
			}
			linha = lerArq.readLine();
			}
		 arqleitura.close();
		}
	public void update (String texto, String novoTexto) throws IOException  {
		
		//Leitura
		FileReader arqLeitura = new FileReader("d:\\teste.txt");
		BufferedReader lerArq = new BufferedReader(arqLeitura);
		FileWriter arq = new FileWriter("d:\\teste.txt", true);
		PrintWriter gravarArq = new PrintWriter(arq);
		
		String linha = lerArq.readLine();
		int i = 0;
		String textOld = "";
		 while (linha != null) {
			 i++;
			 if (linha.contains(texto)) {
				 textOld += novoTexto + "\n";
				
			 }
			 else {
				 textOld += linha + "\n";
			 }
			 gravarArq.println(novoTexto);
			 linha = lerArq.readLine();
		 }
		 
		 System.out.println(textOld);
		 arqLeitura.close();
	}
		 

	public static void main (String args[]) throws Exception {
		Arquivo arq = new Arquivo();
		//arq.inserir("testando3...");
		//arq.leitura("testando2...");
		arq.update("testando...", "testando...2");
		
	}
}