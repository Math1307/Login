package com.login;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws IOException, InterruptedException {
		try {
			boolean bPrincipal = false;
			boolean bSucesso = false;

			String sLogin = "";
			int iOpcao = 0;

			Scanner sc = new Scanner(System.in);
			do {
				System.out.println("Olá, o que você deseja? ");
				System.out.println("1 - Registrar");
				System.out.println("2 - Logar");
				System.out.println("3 - Apagar sua Conta");
				System.out.println("4 - Cancelar");
				iOpcao = sc.nextInt();
				sc.nextLine();

				switch (iOpcao) {
				case 1:
					do {
						bSucesso = Login.registrar();
					} while (bSucesso);
					break;
				case 2:
					System.out.print("Digite seu login: ");
					sLogin = sc.nextLine();
					do {
						bSucesso = Login.login(sLogin);
					} while (bSucesso);
					break;
				case 3:
					System.out.print("Digite seu login: ");
					sLogin = sc.nextLine();
					do {
						bSucesso = Login.apagarConta(sLogin);
					} while (bSucesso);
				case 4: 
					System.out.println("Cancelando...");
					break;
				default:
					System.out.println("Opção inváldia!");
					bPrincipal = true;
					break;
				}
			} while (bPrincipal);
			sc.close();
		} catch(Exception e) {
			System.out.println("Ocorreu um erro! A opção não é um número!");
		}
	}
}