package veiculos;

public class Carro extends Veiculo{

	public Carro(String placa, String modelo, boolean alugado) {
		super(placa, modelo, alugado);
		
	}
	public double calcularValorLocacao(int dias){
		double valor = 0;
		
		valor = 400 * dias;
		
		return valor;
	}

}
