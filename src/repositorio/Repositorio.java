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
	
	
	/*public void adicionarAdim(Administrador	 p){
		Pessoas.put(p.getEmail()+p.getSenha(),  p); //chave concatenada
	}*/
	
	
	
	
	public ArrayList<Pessoa> getPessoas(String termo) {
		 if (termo == null) {
			 new ArrayList<Pessoa> (Pessoas.values());	//TreeMap --> ArrayList
		 } else {
			 
			 ArrayList<Pessoa> pessoas = new ArrayList<>();
			 for(Pessoa p : Pessoas.values()){
		            if(p.getNome().equals(termo))
		                pessoas.add(p);
		     return pessoas;
			 }
			
		}
		return null;
				
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
