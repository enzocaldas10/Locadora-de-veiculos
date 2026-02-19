package veiculos;

public abstract class Veiculo {
	
	protected int tipo;
	protected String placa;
	protected String modelo;
	protected boolean alugado;
	
	public Veiculo(String placa,String modelo, boolean alugado) {
		this.placa = placa;
		this.modelo = modelo;
		this.alugado = false;
	}
	public void calcularValorLocacao(long dias){
		double valor = 0;
		
		System.out.println(valor); 
	}
	
	@Override
	public String toString() {
		return modelo + " - " + placa +" ";
	}
	public boolean isAlugado() {
		return alugado;
	}
	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}

}
