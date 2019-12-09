package fachada;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import modelo.Pessoa;

import repositorio.Repositorio;

public class Fachada {
	private static Repositorio repositorio = new Repositorio();
	private static Pessoa logado;
	private static int idprateleira=0;	//autoincremento

	///localiza apessoa no repositório, a torna pessoa logada e retorna esta pessoa
	
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
	
	// torna a pesso a logada
	
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
			
			usu = new Pessoa(email,senha,nome);
			repositorio.adicionar(usu);
			return usu;
	}
	
	///cadastrar Administrador
	/*public static Pessoa cadastrarAdministrador(String email, String senha, String nome, BufferedImage iconimage,String setor) {
		return "Falta";}*/
	
	public static ArrayList<Pessoa> listarPessoas() {
		return repositorio.getPessoas();
		
	}
	
	/*public static ArrayList<Pessoa> listarPessoas(String termo) {
		if (termo =  )
		
		return repositorio.getPessoas();
		
	}*/
		
	
	
	
	
	
	
	
	
}
