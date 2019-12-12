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
	
	public ArrayList<Pessoa> getPessoas() {
		return  
				new ArrayList<Pessoa> (Pessoas.values());	//TreeMap --> ArrayList
	}
	
	
	public Pessoa localizarUsuario(String email, String senha){
		return Pessoas.get(email+senha);
	}
	
	public Pessoa localizarUsuario(String email){
		String num = null;
		for (String m : Pessoas.keySet()) {
			if (m.contains(email))
				num = m;
				
		}
		return Pessoas.get(num);
	}

	
	public void remover(Pessoa u){
		Pessoas.remove(u.getEmail()+u.getSenha());
	}
	
	
	
	
	public void adicionarMensagem(Mensagem mensagem){
		Mensagens.add(mensagem);
	}
	

	public ArrayList<Mensagem> getMensagens() {
		return Mensagens;
	}
	
	
	public Mensagem localizarMensagem(int id){
		for(Mensagem m : Mensagens){
            if(m.getId()==id)
                return m;
        }
        return null;
	}
	
	public void removerMensagem(Mensagem mensagem){
		mensagem.getDestinatario().getCaixaEntrada().remove(mensagem);
		mensagem.getEminente().getCaixaSaida().remove(mensagem);
		//Mensagens.remove(mensagem);
	}
	
	
	public int todasMensagens(){
		return Mensagens.size();
	}

	
	public void setPessoa(TreeMap<String, Pessoa> pessoa) {
		Pessoas = pessoa;
	}
	
	public void setMensagem(ArrayList<Mensagem> mensagem) {
		Mensagens = mensagem;
	}
	

}
