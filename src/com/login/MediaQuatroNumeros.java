package com.login;

import java.util.Scanner;

public class MediaQuatroNumeros {

	public static boolean media() {
		int num1, num2, num3, num4, media;
		boolean bMedia = false;
		String repete, novaMedia;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("Digite o primeiro número: ");
			num1 = sc.nextInt();
			System.out.print("Digite o segundo número: ");
			num2 = sc.nextInt();
			System.out.print("Digite o terceiro número: ");
			num3 = sc.nextInt();
			System.out.print("Digite o quarto número: ");
			num4 = sc.nextInt();

			media = (num1 + num2 + num3 + num4) / 4;

			System.out.println("A média dos número é -> " + media);

			System.out.println("");
			System.out.println("Deseja tirar outra média? S/N");
			novaMedia = sc.next();

			bMedia = novaMedia.equalsIgnoreCase("S") ? true : false;
		} while (bMedia);

		System.out.println("");
		System.out.println("Deseja executar outro programa? S/N");
		repete = sc.next();
		if(repete.equalsIgnoreCase("N")) {
			System.out.println("Saindo...");
		}
		sc.close();
		return repete.equalsIgnoreCase("S") ? true : false;
	}
}
