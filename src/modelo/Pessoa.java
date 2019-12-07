package modelo;

import java.util.ArrayList;

public class Pessoa {

	private String email;
	private String senha;
	private String nome;
	//private Bufferedlmage imagem;
    private ArrayList<Mensagem> caixaEntrada = new ArrayList<Mensagem>();
    private ArrayList<Mensagem> caixaSaida = new ArrayList<Mensagem>();
    
    //Construtor
	public Pessoa(String emal, String senha, String nome) {
		super();
		this.email = emal;
		this.senha = senha;
		this.nome = nome;
	}
	
	// Métodos getters e setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String emal) {
		this.email = emal;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Pessoa [email=" + email + ", senha=" + senha + ", nome=" + nome + "]";
	}
}
