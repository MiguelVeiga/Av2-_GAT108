package br.com.av1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LeituraCsv {
	
		
		public LeituraCsv(){
		
		
		}
	
	
	public ArrayList <Double> leituraPalavras(String caminho) {
		double valorDouble = 0;
		ArrayList<Double> dados = new ArrayList<Double>();
		try {
			
			File arquivoCsv = new File (caminho);
			
			String linhas = new String();
			
			Scanner leitor = new Scanner(arquivoCsv);
			
			leitor.nextLine();
			
			while (leitor.hasNext()){
				
				linhas = leitor.nextLine();
				
				String[] valores = linhas.split(";"); 
				
				valorDouble = Double.parseDouble(valores[5]);
				
				dados.add(valorDouble);
				
				
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("erro");
		}
		return dados;
	}
		}

