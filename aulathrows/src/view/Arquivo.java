package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Arquivo {
		
		int num_at = 0;
		final static String[] dados = new String[1000];

		public static void main(String args[]) throws Exception {
			int opcao = 0;

			while (opcao != 5) {

				opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
						"1 - INSERIR, 2 - ATUALIZAR, 3 - LISTAR, 4 - DELETAR E 5 - SAIR | Digite a opção desejada: "));

				if (opcao == 1) {
					// Gravação
					gravacao();
				} else if (opcao == 2) {
					// Atualizar
					int num_linha = Integer
							.parseInt(JOptionPane.showInputDialog(null, "Digite o número da linha para alteração: "));
					int novo_num = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o novo valor de i: "));
					atualizar(num_linha, novo_num);
				} else if (opcao == 3) {
					// Listar
					leitura();
				} else if (opcao == 4) {
					// Deletar
					int nlinha = Integer
							.parseInt(JOptionPane.showInputDialog(null, "Digite o número da linha para exclusão: "));
					deletar(nlinha);
				}
			}
		}

		public static void gravacao() throws IOException {
			FileWriter arq = new FileWriter("d:\\teste.txt");
			PrintWriter gravarArq = new PrintWriter(arq);

			for (int i = 0; i < 1000; i++) {
				gravarArq.println("valor de i: " + i);
			}
			arq.close();
		}

		public static void leitura() throws IOException {
			FileReader arqleitura = new FileReader("d:\\teste.txt");
			BufferedReader lerArq = new BufferedReader(arqleitura);

			String linha = lerArq.readLine();
			int i = 0;

			while (linha != null) {
				i++;
				if (linha.contains("valor de i")) {
					System.out.println("linha: " + i + " conteúdo: " + linha);
				}
				linha = lerArq.readLine();
			}

			arqleitura.close();
		}

		public static void atualizar(int num_linha, int novo_num) throws IOException {
			FileReader arqalt = new FileReader("d:\\teste.txt");
			BufferedReader lerArq = new BufferedReader(arqalt);

			String linha = lerArq.readLine();
			int i = 0;

			while (linha != null) {
				if (linha.contains("valor de i") && i + 1 == num_linha) {
					dados[i] = "valor de i: " + novo_num;
				} else {
					dados[i] = "" + linha;
				}

				i++;
				linha = lerArq.readLine();
			}

			FileWriter arq = new FileWriter("d:\\teste.txt");
			PrintWriter gravarArq = new PrintWriter(arq);

			for (int a = 0; a < 1000; a++) {
				gravarArq.println(dados[a]);
			}
			arq.close();
		}

		public static void deletar(int n_linha) throws IOException {
			String[] dados = new String[1000];

			FileReader arqdel = new FileReader("d:\\teste.txt");
			BufferedReader lerArq = new BufferedReader(arqdel);

			String linha = lerArq.readLine();
			int i = 0;

			while (linha != null) {
				if (linha.contains("valor de i") && i + 1 != n_linha) {
					dados[i] = "" + linha;
				} else {
					linha = lerArq.readLine();
					dados[i] = "" + linha;
				}

				i++;
				linha = lerArq.readLine();
			}

			FileWriter arq = new FileWriter("d:\\teste.txt");
			PrintWriter gravarArq = new PrintWriter(arq);

			for (int a = 0; a < 1000; a++) {
				gravarArq.println(dados[a]);
			}
			arq.close();
		}
	}
