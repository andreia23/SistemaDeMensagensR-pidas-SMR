package modelo;

public class Administrador {
	private String setor;
	
	
	public Administrador(String setor) {
		super();
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
