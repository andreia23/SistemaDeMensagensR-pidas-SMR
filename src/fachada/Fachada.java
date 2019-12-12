package fachada;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import modelo.Administrador;
import modelo.Mensagem;
import modelo.Pessoa;
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
	public static void logoff() throws  Exception {
		if(logado==null){
			throw new Exception("nao existe um usuario logado:");
		}
		logado = null; 

	}

	// retorna a pessoa a logada
	public static Pessoa getLogado() {
		return logado;
	}

	//cadastrar Pessoas
	public static Pessoa cadastrarPessoa(String email, String senha, String nome, ImageIcon iconimage) 
	///FALTA
			throws  Exception{
		Pessoa usu = repositorio.localizarUsuario(email,senha);
		if (usu!=null)	
			throw new Exception("cadastrar usuario - ja cadastrado:" + email);

		usu = new Pessoa(email,senha,nome,iconimage);
		repositorio.adicionar(usu);
		return usu;
	}



	public static Pessoa cadastrarPessoa(
			String email,
			String senha,
			String nome)
					throws  Exception{

		Pessoa usuario = repositorio.localizarUsuario(email,senha);
		if ( usuario != null ) {
			throw new Exception("UsuÃ¡rio " + email + " jÃ¡ cadastrado");
		}

		usuario = new Pessoa(email, senha, nome);

		repositorio.adicionar(usuario);

		return usuario;
	}

	///cadastrar Administrador
	public static Administrador cadastrarAdministrador(String email, String senha, String nome,ImageIcon iconimage,String setor) 
			throws Exception {

		Pessoa administrador = repositorio.localizarUsuario(email,senha);
		if ( administrador != null ) {
			throw new Exception("UsuÃ¡rio " + email + " jÃ¡ cadastrado");
		}

		administrador = new Administrador(email, senha, nome, iconimage, setor);

		repositorio.adicionar(administrador);

		return (Administrador) administrador;
	}

	public static Administrador cadastrarAdministrador(
			String email,
			String senha,
			String nome,
			String setor)
					throws  Exception{

		Administrador admin = (Administrador) repositorio.localizarUsuario(email,senha);

		if ( admin != null ) {
			throw new Exception("UsuÃ¡rio " + email + " jÃ¡ cadastrado");
		}

		admin = new Administrador(email, senha, nome, setor);

		repositorio.adicionar(admin);


		return (Administrador) admin;
	}


	public static ArrayList<Pessoa> listarPessoas(String termoBusca) throws Exception {
		ArrayList<Pessoa> retorno = new ArrayList<Pessoa>();

		for (Pessoa pessoa : repositorio.getPessoas()) {
			if (pessoa.getNome().contains(termoBusca)) {
				retorno.add(pessoa);
			}
		}

		if (retorno.size()==0)
			throw new Exception("NÃ£o encontramos usuÃ¡rio com o seguinte termo de busca: "+termoBusca);

		return retorno;
	}

	public static ArrayList<Mensagem> espionarMensagens(String termoBusca) throws Exception {
		ArrayList<Mensagem> retorno = new ArrayList<>();

		for (Mensagem mensagem : repositorio.getMensagens()) {
			if (mensagem.getTexto().contains(termoBusca)) {
				retorno.add(mensagem);
			}
		}

		return retorno;
	}

	public static ArrayList<Pessoa> listarPessoas() {
		return repositorio.getPessoas();
	}




	//cria uma nova mensagem, considerando que o emitente ÃƒÂ© a pessoa logada
	public static Mensagem enviarMensagem(String email_desti, String texto) 
			throws Exception{
		if(logado==null) {					
			throw new Exception("Precisa fazer login");
		};

		//Mensagem m = repositorio.localizarMensagem(idmsg);
		Pessoa destinatario = repositorio.localizarUsuario(email_desti);

		if (destinatario==null) {
			throw new Exception("Usuario nao existe");
		};

		idmsg ++;
		LocalDateTime time;
		String data;
		time = LocalDateTime.now();
		///FORMATANDO A DATA
		data = time.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		if(texto.length()>200) {
			throw new Exception("Mensagem muito grande");
		}
		Mensagem m = new Mensagem(idmsg,getLogado(),destinatario,texto,data);
		repositorio.adicionarMensagem(m);
		destinatario.addCaixaEntrada(m);
		logado.addCaixaSaida(m);

		return m;


	}

	//Listar Caixa de Entrada - arraylist
	// Retorna as mensagem recebidas pela pessoa logada
	public static ArrayList<Mensagem> listarCaixaEntrada()
			throws Exception{
		if (logado == null)
			throw new Exception("Voce precisa estar logado para listar mensagens");

		return logado.getCaixaEntrada();
	}



	//Listar Caixa de SaÃƒÂ­da - arraylist
	// Retorna as mensagen enviadas pela pessoa logada
	public static ArrayList<Mensagem> listarCaixaSaida() 
			throws Exception{
		if (logado == null)
			throw new Exception("Voce precisa estar logado para listar mensagens");

		return logado.getCaixaSaida();
	}



	//Apagar Mensagem
	// Exclui a mensagem da caixa de entrada e/ou saida da pessoa logada e retorna a mensagem excluida
	public static Mensagem apagarMensa(int idmsg)
			throws Exception {
		if(logado==null){
			throw new Exception("Voce nao esta logado, precisa fazer login");
		}
		Mensagem mensagem = repositorio.localizarMensagem(idmsg);
		if(mensagem==null){
			throw new Exception("A Mensagem nÃ£o foi encontrada");
		}
		repositorio.removerMensagem(mensagem);
		return mensagem;
	}




	//Espionar Mensagem - arraylist
	//Retorna as mensagens cujo texto contem o termo fornecido


	//Relatorio 01 - arraylist
	//Retorna as pessoas que nao enviaram mensagem


	//Relatorio 02 - arraylist
	//Retorna as mensagens com emitente igual ao destinatario







}
