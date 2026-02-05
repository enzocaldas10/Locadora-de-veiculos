package aplicacao;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import aluguel.Cliente;
import aluguel.Locacao;
import veiculos.Caminhao;
import veiculos.Carro;
import veiculos.Moto;
import veiculos.Veiculo;

public class Aplicacao {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Locacao> locacoes = new ArrayList<>();
		List<Veiculo> frota = new ArrayList<>();
		
		int opt = 0;
		
		Caminhao t1 = new Caminhao("Accelo", "TFN7232", false);
		Caminhao t2 = new Caminhao("Axor", "DRI9252", false);
		Carro c1 = new Carro("Siena", "BTR4376", false);
		Carro c2 = new Carro("Mobi", "DSY8509", false);
		Moto m1 = new Moto("Bis", "RGB8765", false);
		Moto m2 = new Moto("CG", "HYF8233", false);
		
		frota.add(t1);
		frota.add(t2);
		frota.add(c1);
		frota.add(c2);
		frota.add(m1);
		frota.add(m2);
		
		while(opt != 5){
			
			System.out.println("Selecione uma das opções:");
			System.out.println("1. Iniciar locação");
			System.out.println("2. Finalizar locação");
			System.out.println("3. Listar locações");
			System.out.println("4. Listar Veículos Disponíveis");
			System.out.println("5. Fechar Programa");
			
			opt = sc.nextInt();
			
			switch(opt) {
				case 1:
					sc.nextLine();
					
					System.out.println("Digite o nome completo do cliente:");
					String nomeCliente = sc.nextLine();
					System.out.println("Digite a idade do cliente:");
					int idadeCliente = sc.nextInt();
					System.out.println("Digite o cpf do cliente:");
					String cpfCliente = sc.next();
					System.out.println("Digite o dia de locação do carro:");
					int diaLocacao = sc.nextInt();
					
					Cliente cliente = new Cliente(nomeCliente, cpfCliente, idadeCliente);
					
					Locacao.iniciarLocacao(frota, locacoes, cliente, diaLocacao, sc);
					break;
				case 2:
					Locacao.finalizarLocacao( locacoes, frota, sc);
					break;
				case 3:
					listarLocacoes(locacoes);
					break;
				case 4:
					listarFrota(frota);
					break;
				case 5:
					System.out.println("Fim do programa!");
					break;
				default:
					System.out.println("Opção inexistente!");
					break;
					
			}	
		}
	}

	private static void listarFrota(List<Veiculo> frota) {
		
		System.out.println("Veículos disponíveis:");
	
		int i = 0;
		for(Veiculo n : frota) {
			if (	!n.isAlugado()){
			System.out.println((i+1) + "° " + n.toString());
			}
			i++;
		}
	}

	private static void listarLocacoes(List<Locacao> locacoes) {
		
		System.out.println("Locações ativas: ");
		int i = 0;
		for(Locacao l : locacoes) {
			System.out.println((i+1) + "° " + l.toString());
			i++;
		}
	}
}
