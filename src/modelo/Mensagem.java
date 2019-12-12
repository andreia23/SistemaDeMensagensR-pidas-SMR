package modelo;

import java.time.LocalDateTime;

public class Mensagem {
	
		private int id;
		private Pessoa eminente;
		private Pessoa destinatario;
		private String texto;
	    private String data;
	    
	    //Construtor
		public Mensagem(int id, Pessoa eminente, Pessoa destinatario, String texto, String data) {
			super();
			this.id = id;
			this.eminente = eminente;
			this.destinatario = destinatario;
			this.texto = texto;
			this.data = data;
		}
	    
		// MÃ©todos getters e setters
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Pessoa getEminente() {
			return eminente;
		}
		public void setEminente(Pessoa eminente) {
			this.eminente = eminente;
		}
		public Pessoa getDestinatario() {
			return destinatario;
		}
		public void setDestinatario(Pessoa destinatario) {
			this.destinatario = destinatario;
		}
		public String getTexto() {
			return texto;
		}
		public void setTexto(String texto) {
			this.texto = texto;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Mensagem [id=" + id + ", eminente=" + eminente + ", destinatario=" + destinatario + ", texto="
					+ texto + ", data=" + data + "]";
		}
	}


