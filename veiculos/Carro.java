package veiculos;

public class Carro extends Veiculo{

	public Carro(String placa, String modelo, boolean alugado) {
		super(placa, modelo, alugado);
		
	}
	public void calcularValorLocacao(int dias){
		double valor = 0;
		
		valor = 400 * dias;
		
		System.out.println("O Custo da locacação foi: " + valor + "R$");
	}

}
