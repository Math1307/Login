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
					System.out.println("Escolha uma op��o entre os seguintes programas: ");
					System.out.println("1 - Gerar um n�mero aleat�rio");
					System.out.println("2 - Tirar m�dia de 4 n�meros");
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
						System.out.println("Op��o inv�lida! Tente novamente...");
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
