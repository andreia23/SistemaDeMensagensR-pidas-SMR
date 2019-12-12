package aplicacao_swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Pessoa;

public class CadastaUsu extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JLabel lblNome;
	private JLabel lblPreco;
	private JButton button;
	private JLabel lblmsg;
	private JPasswordField passwordField;
	private JTextField emailField;
	private JLabel lblFoto;
	private JTextField imageField;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					TelaCadastroProduto frame = new TelaCadastroProduto();
	//					frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	/**
	 * Create the frame.
	 */
	public CadastaUsu() {
		setTitle("Cadastrar Usuario");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 482, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		nomeField = new JTextField();
		nomeField.setBounds(72, 2, 273, 23);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(72, 37, 211, 23);
		contentPane.add(passwordField);

		lblNome = new JLabel("Nome");
		lblNome.setBounds(13, 8, 46, 14);
		contentPane.add(lblNome);

		lblPreco = new JLabel("Senha");
		lblPreco.setBounds(10, 40, 46, 14);
		contentPane.add(lblPreco);

		lblmsg = new JLabel("");
		lblmsg.setBounds(85, 185, 273, 14);
		contentPane.add(lblmsg);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 84, 46, 14);
		contentPane.add(lblEmail);

		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(72, 76, 273, 23);
		contentPane.add(emailField);

		button = new JButton("Cadastrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(nomeField.getText().isEmpty() )
						lblmsg.setText("campo vazio");
					else {
						String nome = nomeField.getText();
						String senha = new String( passwordField.getPassword());
						String email = emailField.getText();
						ImageIcon imagem = new ImageIcon(getClass().getResource(imageField.getText()));

						Pessoa usuario = Fachada.cadastrarPessoa(nome, senha, email, imagem);
						lblmsg.setText("cadastrou: "+usuario.getEmail());
						nomeField.setText("");
						passwordField.setText("");
						nomeField.requestFocus();
					}
				}
				catch(Exception erro){
					lblmsg.setText(erro.getMessage());
				}
			}
		});
		button.setBounds(171, 150, 115, 23);
		contentPane.add(button);
		
		lblFoto = new JLabel("Foto");
		lblFoto.setBounds(13, 118, 46, 14);
		contentPane.add(lblFoto);
		
		imageField = new JTextField();
		imageField.setColumns(10);
		imageField.setBounds(75, 110, 273, 23);
		contentPane.add(imageField);

	}
}
