package modelo;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Pessoa {

	private String email;
	private String senha;
	private String nome;
    private ArrayList<Mensagem> caixaEntrada = new ArrayList<Mensagem>();
    private ArrayList<Mensagem> caixaSaida = new ArrayList<Mensagem>();
	private ImageIcon iconimage;
    
    //Construtor
	public Pessoa( String nome,String senha,String emal, ImageIcon iconimage) {
		super();
		this.email = emal;
		this.senha = senha;
		this.nome = nome;
		this.iconimage = iconimage;
	}
	
	public Pessoa(String emal, String senha, String nome) {
		super();
		this.email = emal;
		this.senha = senha;
		this.nome = nome;
		
	}
	
	
	
	
	// MÃ©todos getters e setters
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
	public ImageIcon getIconImage() {
		return iconimage;
	}
	public void setIconImage(ImageIcon iconimage) {
		this.iconimage = iconimage;
	}
	
	////////////
	
	public void addCaixaEntrada(Mensagem mensagem) {
		this.caixaEntrada.add(mensagem);
	}
	
	public void removerCaixaEntrada(Mensagem mensagem) {
		this.caixaEntrada.remove(mensagem);
	}
	
	public ArrayList<Mensagem> getCaixaEntrada() {
		return this.caixaEntrada;
	}
	
	
	///////
	
	
	public void addCaixaSaida(Mensagem mensagem) {
		this.caixaSaida.add(mensagem);
	}
	public void removerCaixaSaida(Mensagem mensagem){
		this.caixaSaida.remove(mensagem);
	}
	public ArrayList<Mensagem> getCaixaSaida() {
		return this.caixaSaida;
	}
	
	
	
	
	

	@Override
	public String toString() {
		return "Pessoa [email=" + email + ", senha=" + senha + ", nome=" + nome + "]";
	}
}
