package veiculos;

public class Moto extends Veiculo{

	public Moto(String placa, String modelo, boolean alugado) {
		super(placa, modelo, alugado);
		
	}
	public void calcularValorLocacao(int dias){
		double valor = 0;
		
		valor = 200 * dias;
		
		System.out.println("O Custo da locacação foi: " + valor + "R$");
	}
}
