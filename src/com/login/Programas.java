package com.login;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Programas {

	public static void programas() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		try {
			boolean programa = false;
			do {
				int iOpcao;
				boolean opcaoInvalida = false;

				Scanner sc = new Scanner(System.in);

				do {
					System.out.println("Escolha uma opção entre os seguintes programas: ");
					System.out.println("1 - Gerar um número aleatório");
					System.out.println("2 - Tirar média de 4 números");
					System.out.println("3 - Sair...");
					iOpcao = sc.nextInt();
					switch (iOpcao) {
					case 1:
						programa = RandomNum.numeroRandom();
						break;
					case 2:
						programa = MediaQuatroNumeros.media();
						break;
					case 3:
						System.out.println("Saindo...");
						break;
					default:
						System.out.println("Opção inválida! Tente novamente...");
						opcaoInvalida = true;
					}
				} while (opcaoInvalida);
				sc.close();
			} while (programa);
		} catch (Exception e) {
			System.out.println("Um erro ocorreu! Encerrando...");
		}
	}
}
