package veiculos;

public class Moto extends Veiculo{

	public Moto(String placa, String modelo, boolean alugado) {
		super(placa, modelo, alugado);
		
	}
	public double calcularValorLocacao(int dias){
		double valor = 0;
		
		valor = 200 * dias;
		
		return valor;
	}
}
