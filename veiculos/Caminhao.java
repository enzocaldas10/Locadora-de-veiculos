package veiculos;

public class Caminhao extends Veiculo{

	public Caminhao(String placa, String modelo, boolean alugado) {
		super(placa, modelo, alugado);
		
	}
	public double calcularValorLocacao(int dias){
		double valor = 0;
		
		valor = 800 * dias;
		
		return valor;
	}

}
