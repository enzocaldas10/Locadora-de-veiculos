package aluguel;

public class Cliente {
	
	protected String nome;
	protected String cpf;
	protected int idade;
	
	public Cliente(String nome,String cpf, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}
	
	public String toString() {
		return  nome + " - " + cpf;
		
	}
	
}
