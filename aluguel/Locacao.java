package aluguel;

import java.util.List;
import java.util.Scanner;

import veiculos.Veiculo;

public class Locacao implements Locavel{
	
	private Veiculo veiculo;
	private Cliente cliente;
	private int diaLocacao;
	
	public Locacao(Veiculo veiculo, Cliente cliente, int diaLocacao) {
		super();
		this.veiculo = veiculo;
		this.cliente = cliente;
		this.diaLocacao = diaLocacao;
	}
	
	
	@Override
	public String toString() {
		return "Locacao [veiculo=" + veiculo + ", cliente=" + cliente + ", diaLocacao=" + diaLocacao + "]";
	}


	public static void iniciarLocacao(List<Veiculo> frota, List<Locacao> locacoes, Cliente cliente, int diaLocacao, Scanner sc) {
		
		System.out.println("Selecione um veículo:");
		
		int i = 0;
		for(Veiculo n : frota) {
			if (	!n.isAlugado())
			System.out.println((i+1) + "° " + n.toString());
			i++;
		}
		int select = sc.nextInt() - 1;
		Veiculo veiculoSelecionado = null;
		
		int j = 0;
		for(Veiculo n : frota) {
			if(select == j) {
				n.setAlugado(true);
				veiculoSelecionado = n;
			}
			j++;
		}
		
		Locacao loc = new Locacao(veiculoSelecionado, cliente, diaLocacao);
		locacoes.add(loc);
	
	}

	public static void finalizarLocacao(List<Locacao> locacoes, Scanner sc) {
			
		System.out.println("Selecione por número uma locação para finalizar:");
		
		for (int i = 0; i < locacoes.size(); i++) {
	        System.out.println((i + 1) + "° " + locacoes.get(i));
	    }
		
		int select = sc.nextInt() - 1;
		
		if((select >= 0) && (select < locacoes.size())) {
			
			for(int j = 0 ; j < locacoes.size() ; j++) {
				if(select == j) {
					locacoes.remove(j);
				}
			}
		}
	}
}

