package fachada;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import modelo.Pessoa;
import modelo.Mensagem;

import repositorio.Repositorio;

public class Fachada {
	private static Repositorio repositorio = new Repositorio();
	private static Pessoa logado;
	private static int idmsg=0;	//autoincremento

	///localiza a pessoa no repositorio, a torna pessoa logada e retorna esta pessoa
	public static Pessoa login(String email, String senha) throws  Exception {
		if(logado!=null)
			throw new Exception("ja existe um usuario logado:"+logado.getEmail());
		
		Pessoa usu = repositorio.localizarUsuario(email,senha);
		if(usu==null)
			throw new Exception("email ou senha invalida:");
		logado = usu;
		return usu;
	}
	
	//descarta a pessoa logada
	public static Pessoa logoff(String email, String senha) throws  Exception {
		if(logado==null)
			throw new Exception("nao existe um usuario logado:");
		
		Pessoa usu = repositorio.localizarUsuario(email,senha);
		if(usu==null)
			throw new Exception("email ou senha invalida:");
		if(usu!=logado)
			throw new Exception("este usuario nao esta logado:");
		
		logado = null; 
		return usu;
	}
	
	// retorna a pessoa a logada
	public static Pessoa getLogado() {
		return logado;
	}
	
	//cadastrar Pessoas
	public static Pessoa cadastrarPessoa(String email, String senha, String nome, BufferedImage iconimage) 
		///FALTA
		throws  Exception{
			Pessoa usu = repositorio.localizarUsuario(email,senha);
			if (usu!=null)	
				throw new Exception("cadastrar usuario - ja cadastrado:" + email);
			
			usu = new Pessoa(email,senha,nome,iconimage);
			repositorio.adicionar(usu);
			return usu;
	}
	
	///cadastrar Administrador
	/*public static Pessoa cadastrarAdministrador(String email, String senha, String nome, BufferedImage iconimage,String setor) {
		return "Falta";}*/
	
	public static ArrayList<Pessoa> listarPessoas(String termo) {
		return repositorio.getPessoas(termo);
		
	}
	
	//cria uma nova mensagem, considerando que o emitente é a pessoa logada
	public static Mensagem enviarMensagem(String destinatario, String texto) 
			throws Exception{
		//Pessoa usu = repositorio.setMensagem(mensagem);
		if(logado==null) {					
			throw new Exception("Precisa fazer login");
		};
		Mensagem m = repositorio.localizarMensagem(idmsg);// acho que nao e localizar usuario, e sim localizar mensagem
        	if (m!=null){
          	throw new Exception("Mensagem ja foi enviada:");
        	};
        	return m;
        	//falta terminar
		}
	
	//Listar Caixa de Entrada - arraylist
	// Retorna as mensagem recebidas pela pessoa logada
	public static ArrayList<Mensagem> listarCaixaEntrada(){
		return repositorio.getMensagens();
	}
	
	//Listar Caixa de Saída - arraylist
	// Retorna as mensagen enviadas pela pessoa logada
  public static ArrayList<Mensagem> listarCaixaSaida(){
    return repositorio.getMensagens();
  }
	
	//Apagar Mensagem
	// Exclui a mensagem da caixa de entrada e/ou saida da pessoa logada e retorna a mensagem excluida
	public static Mensagem apagarMensagem(int idmsg)
        throws Exception {
      if(logado==null){
        throw new Exception("Faça login");
      }
      Mensagem msg = repositorio.localizarMensagem(idmsg);
      if(msg==null){
        throw new Exception("Mensagem não encontrada");
      }
      repositorio.removermensagem(msg);
      return msg;
    }

	
	//Espionar Mensagem - arraylist
	//Retorna as mensagens cujo texto contem o termo fornecido
	
	
	//Relatorio 01 - arraylist
	//Retorna as pessoas que nao enviaram mensagem

	
	//Relatorio 02 - arraylist
	//Retorna as mensagens com emitente igual ao destinatario
	
	
	
	
	
	
	
}
