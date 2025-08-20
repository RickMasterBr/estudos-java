package crud0.tela;

import java.awt.*;
import javax.swing.*;

public class JframePrincipal {

    private JTextField txtID, txtNome, txtLogin, txtSenha;
    private JButton btnNovo, btnSalvar, btnPesquisar, btnExcluir;
    private JLabel lblID, lblNome, lblLogin , lblSenha;
    private JFrame tela;

    public JframePrincipal() {

        tela = new JFrame("Cadastro");
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(500, 400);
        tela.setLayout(new GridBagLayout());
        tela.setResizable(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;

        int linha = 0;
        gbc.gridx = 0;
        gbc.gridy = linha;

        lblID = new JLabel("ID");
        tela.add(lblID, gbc);
        gbc.gridx = 1;
        txtID = new JTextField(10);
        tela.add(txtID, gbc);

        gbc.gridx = 0;
        linha++;
        gbc.gridy = linha;

        lblNome = new JLabel("Nome");
        tela.add(lblNome, gbc);
        gbc.gridx = 1;
        txtNome = new JTextField(20);
        tela.add(txtNome, gbc);

        gbc.gridx = 0;
        linha++;
        gbc.gridy = linha;

        lblLogin = new JLabel("Login");
        tela.add(lblLogin, gbc);
        gbc.gridx = 1;
        txtLogin = new JTextField(15);
        tela.add(txtLogin, gbc);

        gbc.gridx = 0;
        linha++;
        gbc.gridy = linha;

        lblSenha = new JLabel("Senha");
        tela.add(lblSenha, gbc);
        gbc.gridx = 1;
        txtSenha = new JTextField(15);
        tela.add(txtSenha, gbc);
        
        gbc.gridx = 0;
        linha++;
        gbc.gridy = linha;

        //botões
        btnNovo = new JButton("Novo");
        btnSalvar = new JButton("Salvar");
        btnPesquisar = new JButton("Pesquisar");;
        btnExcluir = new JButton("Excluir");

        gbc.anchor = GridBagConstraints.CENTER;
        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        panelBotoes.add(btnNovo);
        panelBotoes.add(btnSalvar);
        panelBotoes.add(btnPesquisar);
        panelBotoes.add(btnExcluir);

        gbc.gridwidth = 2;
        tela.add(panelBotoes, gbc);

        tela.setVisible(true);


    }

}
