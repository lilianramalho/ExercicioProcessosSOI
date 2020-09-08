package view;

import java.util.Scanner;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		
		RedesController redesController = new RedesController();
		String sistemaOperacional;
		System.out.println(sistemaOperacional);
		int opc = 0;
		int pid;
		String nome;
		Scanner scanner = new Scanner(System.in);
		
		
		while (opc != 9) {
			System.out.println("Escolha uma opcao para iniciar: \n 1 - metodo identifica SO \n 2 - listar Processos \n 3 - matar processo por pid \n 4- matar processo por nome \n 9 - encerrar");
			opc = scanner.nextInt();
			switch (opc) {
			case 1:
				sistemaOperacional = redesController.indentificaSO();
			break;
			
			case 2:
				redesController.listarProcessos(sistemaOperacional);
			break;
			case 3:
				System.out.println("Digite o pid");
				pid = scanner.nextInt();
				redesController.matarProcessoPID(pid, sistemaOperacional);
			break;
			case 4:
				System.out.println("Digite o nome do processo");
				nome = scanner.next();
				redesController.matarProcessoNome(nome, sistemaOperacional);
			break;
			case 9:
				System.out.println("Finalizado!");
			break;
			default:
				System.out.println("Opcao invalida");
			break;
			}
			
		}
	}
}
		
		

	}