package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;

public class Programa {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Funcionario> funcionarios = new ArrayList<>();

		System.out.printf("Quantidade de funcionários: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Funcionario #" + i);
			System.out.printf("ID: ");
			int id = sc.nextInt();
			for (Funcionario funcionario : funcionarios) {
				while (id == funcionario.getId()) {					
					System.out.println("ID ja cadastrado");
					System.out.printf("Digite um diferente ID: ");
					id = sc.nextInt();
				}
			}  
			sc.nextLine();
			System.out.printf("Nome: ");
			String nome = sc.nextLine();
			System.out.printf("Salario: ");
			double salario = sc.nextDouble();
			Funcionario Objetofuncionario = new Funcionario(id, nome, salario);
			
			funcionarios.add(Objetofuncionario);
		}
		
		System.out.printf("Dgite o DI do funcionário que terá o salario aumentado: ");
		int idSelecionado = sc.nextInt();
		
		boolean encontrado = false;
		
		for (Funcionario funcionario : funcionarios) {
			if (idSelecionado == funcionario.getId()) {
				System.out.printf("Digite a porcentagem: ");
				double porcentagem = sc.nextDouble();
				funcionario.aumentarSalario(porcentagem);
				encontrado = true;
			}else {
				encontrado = false;
			}
		}
		
		if (!encontrado) {
			System.out.println("ID não encontrado");
		}

		System.out.println("Lista de Empregados:");
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}
	}
}
