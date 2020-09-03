package com.login;

import java.util.Random;
import java.util.Scanner;

public class RandomNum {

	public static boolean numeroRandom() {
		
		boolean novoNumero = false;
		String repete = "";
		@SuppressWarnings("resource")
		Scanner entradaValores = new Scanner(System.in);
		
		do {

			int numero;
			Random randomic = new Random();
			
			numero = randomic.nextInt(50) + 1;
			
			System.out.println("O número gerado foi: " + numero);			
			System.out.println("");
			System.out.println("Deseja gerar um novo número aleatório? S/N");
			
			String escolha = entradaValores.next();
			
			novoNumero = escolha.equalsIgnoreCase("S") ? true : false;
		} while(novoNumero);
		
		System.out.println("");
		System.out.println("Deseja executar outro programa? S/N");
		repete = entradaValores.next();
		if(repete.equalsIgnoreCase("N")) {
			System.out.println("Saindo...");
		}
		return repete.equalsIgnoreCase("S") ? true : false;
	}
}
