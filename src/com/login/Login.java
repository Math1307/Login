package com.login;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Login {

	public static FileOutputStream arq;
	public static DataOutputStream registrar;
	public static FileInputStream arqLogin;
	public static DataInputStream login;
	public static File file;

	@SuppressWarnings("resource")
	public static boolean registrar() throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		String usuario;
		System.out.print("Digite um login: ");
		usuario = sc.nextLine();

		String arquivo = "Logins//" + "Login-" + usuario + ".dat";
		boolean pastaExiste = (new File("Logins").isDirectory());
		if (!pastaExiste) {
			try {
				System.out.println("Criando pasta de Logins... 1 Segundo");
				boolean pastaCriada = (new File("Logins").mkdir());
				if (!pastaCriada) {
					System.out.println("Erro!");
				}
			} finally {
				TimeUnit.SECONDS.sleep(1);
			}
		}
		boolean usuarioExistente = (new File(arquivo).exists());
		if (usuarioExistente) {
			System.out.println("Esse usuário já existe!");
			return true;
		} else {
			arq = new FileOutputStream(arquivo);
			registrar = new DataOutputStream(arq);

			String sSenha, sConfirmaSenha;

			System.out.print("Digite uma senha: ");
			sSenha = sc.next();
			System.out.print("Confirme sua senha: ");
			sConfirmaSenha = sc.next();

			if (sSenha.equals(sConfirmaSenha)) {
				registrar.writeUTF(usuario);
				registrar.writeUTF(sSenha);
				System.out.println("Registado com sucesso!");
				System.out.println("Login: " + usuario);
				System.out.println("Senha: " + sSenha);
				System.out.println("Bem-Vindo " + usuario);
				System.out.println("");
				Programas.programas();
				return false;
			} else {
				System.out.println("Senhas não coincidem!");
				registrar.close();
				arq.close();
				deletarLogin(usuario, arquivo);
				return true;
			}
		}
	}

	@SuppressWarnings("resource")
	public static boolean login(String usuario) throws IOException, InterruptedException {
		file = new File("Logins//" + "Login-" + usuario + ".dat");
		if (file.exists()) {
			arqLogin = new FileInputStream("Logins//" + "Login-" + usuario + ".dat");
			login = new DataInputStream(arqLogin);

			Scanner sc = new Scanner(System.in);

			if (usuario.equalsIgnoreCase(login.readUTF())) {
				System.out.print("Digite sua senha: ");
				String sSenha = sc.next();
				if (sSenha.equalsIgnoreCase(login.readUTF())) {
					System.out.println("Bem-Vindo novamente " + usuario);
					System.out.println("");
					Programas.programas();
					return false;
				} else {
					System.out.println("Senha inválida! Tente novamente");
					return true;
				}
			} else {
				System.out.println("Login não existe!");
				return false;
			}
		} else {
			System.out.println("Usuário inexsistente!");
			return false;
		}
	}

	@SuppressWarnings("resource")
	public static boolean apagarConta(String usuario) throws IOException {
		file = new File("Logins//" + "Login-" + usuario + ".dat");
		String arquivo = "Logins//" + "Login-" + usuario + ".dat";
		if (file.exists()) {
			arqLogin = new FileInputStream(arquivo);
			login = new DataInputStream(arqLogin);

			Scanner sc = new Scanner(System.in);

			if (usuario.equalsIgnoreCase(login.readUTF())) {
				System.out.print("Digite sua senha: ");
				String sSenha = sc.next();
				if (sSenha.equalsIgnoreCase(login.readUTF())) {
					System.out.print("Digite 'Confirmar' para apagar sua conta: ");
					String confirmacao = sc.next();
					if(confirmacao.equalsIgnoreCase("Confirmar")) {
						login.close();
						arqLogin.close();
						deletarLogin(usuario, arquivo);
						System.out.println("Conta apagada!");
					} else {
						System.out.println("Confirmação inválida!");
					}
					return false;
				} else {
					System.out.println("Senha inválida! Tente novamente");
					return true;
				}
			} else {
				System.out.println("Login não existe!");
				return false;
			}
		} else {
			System.out.println("Usuário inexsistente!");
			return false;
		}
	}

	public static void deletarLogin(String usuario, String login) {
		String arquivo = "" + login;
		file = new File(arquivo);
		file.delete();
	}
}
