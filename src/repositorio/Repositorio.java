package repositorio;

import java.util.ArrayList;
import java.util.TreeMap;

import modelo.Pessoa;
import modelo.Mensagem;

public class Repositorio {
	private TreeMap<String,Pessoa> Pessoas = new TreeMap<>();
	private ArrayList<Mensagem> Mensagens = new ArrayList<>();
	
	
	public void adicionar(Pessoa u){
		Pessoas.put(u.getEmail()+u.getSenha(),  u); //chave concatenada
	}
	public void remover(Pessoa u){
		Pessoas.remove(u.getEmail()+u.getSenha());
	}
	public Pessoa localizarUsuario(String email, String senha){
		return Pessoas.get(email+senha);
	}
	
	
	
	
	
	
	public TreeMap<String, Pessoa> getPessoas() {
		return Pessoas;
	}
	public void setPessoa(TreeMap<String, Pessoa> pessoa) {
		Pessoas = pessoa;
	}
	public ArrayList<Mensagem> getMensagens() {
		return Mensagens;
	}
	public void setMensagem(ArrayList<Mensagem> mensagem) {
		Mensagens = mensagem;
	}
	
}
