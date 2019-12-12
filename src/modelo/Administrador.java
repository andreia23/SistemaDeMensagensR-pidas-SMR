package modelo;

import javax.swing.ImageIcon;

public class Administrador extends Pessoa {
	private String setor;
	
	
	public Administrador(String email, String senha, String nome, ImageIcon iconimage,String setor) {
		super(email,senha,nome,iconimage);
		this.setor = setor;
	}
	
	public Administrador(String email, String senha, String nome,String setor) {
		super(email,senha,nome);
		this.setor = setor;
	}


	public String getSetor() {
		return setor;
	}


	public void setSetor(String setor) {
		this.setor = setor;
	}


	@Override
	public String toString() {
		return "Administrador [setor=" + setor + "]";
	}

	
}
