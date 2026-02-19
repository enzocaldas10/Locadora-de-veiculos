package aluguel;

import java.util.List;
import java.util.Scanner;
import java.time.Duration;
import java.time.LocalDate;
import veiculos.Veiculo;

public class Locacao implements Locavel{
	
	private Veiculo veiculo;
	private Cliente cliente;
	private LocalDate diaLocacao;
	
	
	public Locacao(Veiculo veiculo, Cliente cliente, LocalDate diaLocacao) {
		super();
		this.veiculo = veiculo;
		this.cliente = cliente;
		this.diaLocacao = diaLocacao;
	}
	
	@Override
	public String toString() {
		return "Dados da Locação : Veículo = " + veiculo + ", Cliente = " + cliente + ", Dia da locação = " + diaLocacao + ".";
	}


	public static void iniciarLocacao(List<Veiculo> frota, List<Locacao> locacoes, Cliente cliente, LocalDate diaLocacao, Scanner sc) {
		
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

	public static void finalizarLocacao(List<Locacao> locacoes, List<Veiculo> frota, Scanner sc) {
		
		System.out.println("Selecione por número uma locação para finalizar:");
		
		for (int i = 0; i < locacoes.size(); i++) {
	        System.out.println((i + 1) + "° " + locacoes.get(i));
	    }
		
		int select = sc.nextInt() - 1;
		
		System.out.println("Digite a data de devolução: yyyy-mm-dd");
		
		String devolucao = sc.next();
		sc.nextLine();
		LocalDate diaDevolucao = LocalDate.parse(devolucao);
		Duration duracaoEmp = null;
		
		
		if((select >= 0) && (select < locacoes.size())) {
			
			for(int j = 0 ; j < locacoes.size() ; j++) {
				if(select == j) {
					
					duracaoEmp = Duration.between(locacoes.get(j).getDiaLocacao().atStartOfDay(),diaDevolucao.atStartOfDay());
					locacoes.get(j).getVeiculo().calcularValorLocacao(duracaoEmp.toDays());
					
					for(Veiculo n : frota) {
						if(n == locacoes.get(j).getVeiculo()) {
							n.setAlugado(false);
						}
					}
					locacoes.remove(j);
				}
			}
		}
		
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}


	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public LocalDate getDiaLocacao() {
		return diaLocacao;
	}


	public void setDiaLocacao(LocalDate diaLocacao) {
		this.diaLocacao = diaLocacao;
	}

}