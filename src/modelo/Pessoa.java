package modelo;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Pessoa {

	private String email;
	private String senha;
	private String nome;
    private ArrayList<Mensagem> caixaEntrada = new ArrayList<Mensagem>();
    private ArrayList<Mensagem> caixaSaida = new ArrayList<Mensagem>();
	private BufferedImage iconimage;
    
    //Construtor
	public Pessoa(String emal, String senha, String nome, BufferedImage iconimage) {
		super();
		this.email = emal;
		this.senha = senha;
		this.nome = nome;
		this.iconimage = iconimage;
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
	public BufferedImage getIconImage() {
		return iconimage;
	}
	public void setIconImage(BufferedImage iconimage) {
		this.iconimage = iconimage;
	}

	@Override
	public String toString() {
		return "Pessoa [email=" + email + ", senha=" + senha + ", nome=" + nome + "]";
	}
}
