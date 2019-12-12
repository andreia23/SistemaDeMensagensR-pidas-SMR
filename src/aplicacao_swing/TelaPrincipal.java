package aplicacao_swing;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import aplicacao_console.TesteConsole;
import fachada.Fachada;
import modelo.Administrador;

public class TelaPrincipal {
    private JFrame frame;
    private JLabel label;       //imagem de fundo
    private JMenu mnPessoa;
    private JMenuItem itemLogin;
    private JMenuItem itemLogff;
    private JMenuItem itemCadastrar;
    private JMenuItem itemListarPessoa;
    private JMenuItem itemCadAdmin;
    private JMenu mnMensagem;
    private JMenuItem itemEnviar;
    private JMenuItem itemApagar;
    private JMenuItem itemListarEntrada;
    private JMenu mnRelatorio;
    private JMenuItem itemListarSaida;
    private JMenuItem itemEspionar;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	new TesteConsole().teste1();
                	
                	TelaPrincipal window = new TelaPrincipal();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public TelaPrincipal() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
    	
        frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("Sistema de Mensagens Rápidas");

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent arg0) {
                try{
                    //  pre-cadastro de objetos na Fachada
                    new TesteConsole();

                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Tchau");
            }
        });

        frame.setBounds(100, 100, 384, 271);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        
        label = new JLabel("");
        label.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        ImageIcon imagem = new ImageIcon(getClass().getResource("/imagens/bleep_1-300x300.jpg"));
        imagem = new ImageIcon(imagem.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(imagem);
        frame.getContentPane().add(label);
        frame.setResizable(true);

        //-------------BARRA DE MENU-----------------------------------
        JMenuBar menu = new JMenuBar();
        frame.setJMenuBar(menu);

        //-------------MENU-----------------------------------
        mnMensagem = new JMenu("_Mensagem_");
        menu.add(mnMensagem);

        itemEnviar = new JMenuItem("_Enviar_");
        itemEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(Fachada.getLogado()==null)
                    JOptionPane.showMessageDialog(frame, "voce precisa se logar");
                else {
                    EnviarMensa j = new EnviarMensa();
                    j.setVisible(true);
                }
            }
        });
        mnMensagem.add(itemEnviar);

        itemListarEntrada = new JMenuItem("CaixaEntrada");
        itemListarEntrada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(Fachada.getLogado()==null)
                    JOptionPane.showMessageDialog(frame, "voce precisa se logar");
                else {
                    Listagem j = new Listagem();
                    j.setVisible(true);
                }
            }
        });
        mnMensagem.add(itemListarEntrada);

        itemListarSaida = new JMenuItem("CaixaSaida");
        itemListarSaida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(Fachada.getLogado()==null)
                    JOptionPane.showMessageDialog(frame, "voce precisa se logar");
                else {
                    Listagem j = new Listagem();
                    j.setVisible(true);
                }
            }
        });
        mnMensagem.add(itemListarSaida);

        itemApagar = new JMenuItem("_Apagar Mensagem_");
        itemApagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(Fachada.getLogado()==null)
                    JOptionPane.showMessageDialog(frame, "voce precisa se logar");
                else {
                    ApagarMens j = new ApagarMens();
                    j.setVisible(true);
                }
            }
        });
        mnMensagem.add(itemApagar);

        itemEspionar = new JMenuItem("_Espionar_");
        itemEspionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(Fachada.getLogado()==null && Fachada.getLogado() instanceof Administrador)
                    JOptionPane.showMessageDialog(frame, "voce precisa se logar como administrador");
                else {
                    Espionar j = new Espionar();
                    j.setVisible(true);
                }
            }
        });
        mnMensagem.add(itemEspionar);


        //-------------MENU-----------------------------------
        mnPessoa = new JMenu("_Pessoa_");
        menu.add(mnPessoa);

        itemLogin = new JMenuItem("_Login_");
        itemLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Login j = new Login();
                j.setVisible(true);
            }
        });
        mnPessoa.add(itemLogin);

        itemLogff = new JMenuItem("_Logoff_");
        itemLogff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Fachada.logoff();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        mnPessoa.add(itemLogff);

        itemCadastrar = new JMenuItem("_Cadastrar_");
        itemCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CadastaUsu j = new CadastaUsu();
                j.setVisible(true);
            }
        });
        mnPessoa.add(itemCadastrar);

        itemCadAdmin = new JMenuItem("_Cadastrar Admin_");
        itemCadAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CadasAdimin j = new CadasAdimin();
                j.setVisible(true);
            }
        });
        mnPessoa.add(itemCadAdmin);

        itemListarPessoa = new JMenuItem("_Listar_");
        itemListarPessoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Listagem j = new Listagem();
                j.setVisible(true);
            }
        });
        mnPessoa.add(itemListarPessoa);

        //-------------MENU-----------------------------------
        mnRelatorio = new JMenu("_Relatorio_");
        menu.add(mnRelatorio);
        mnRelatorio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if(Fachada.getLogado()==null && Fachada.getLogado() instanceof Administrador)
                    JOptionPane.showMessageDialog(frame, "voce precisa se logar como administrador");
                else {
                    Consulta j = new Consulta();
                    j.setVisible(true);
                }
            }
        });

    }
}
