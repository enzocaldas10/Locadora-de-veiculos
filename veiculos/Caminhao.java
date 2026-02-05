package veiculos;

public class Caminhao extends Veiculo{

	public Caminhao(String placa, String modelo, boolean alugado) {
		super(placa, modelo, alugado);
		
	}
	public void calcularValorLocacao(int dias){
		double valor = 0;
		
		valor = 800 * dias;
		
		System.out.println("O Custo da locacação foi: " + valor + "R$");
	}

}
