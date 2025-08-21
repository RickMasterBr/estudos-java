package crud0.tela;

import java.awt.*;
import javax.swing.*;

public class JframePrincipal {

    private JTextField txtID, txtNome, txtLogin, txtSenha;
    private JButton btnNovo, btnSalvar, btnPesquisar, btnExcluir, btnAlterar;
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
        btnAlterar = new JButton("Alterar");
        btnSalvar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);

        gbc.anchor = GridBagConstraints.CENTER;
        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        panelBotoes.add(btnNovo);
        panelBotoes.add(btnSalvar);
        panelBotoes.add(btnPesquisar);
        panelBotoes.add(btnExcluir);
        panelBotoes.add(btnAlterar);

        gbc.gridwidth = 2;
        tela.add(panelBotoes, gbc);

        //botão novo
        btnNovo.addActionListener(e -> habilitarCampos(true));
        btnNovo.addActionListener(e -> btnSalvar.setEnabled(true));
        btnNovo.addActionListener(e -> btnNovo.setEnabled(false));
        btnNovo.addActionListener(e -> btnExcluir.setEnabled(true));

        //botão salvar
        btnSalvar.addActionListener(e -> {
            if (validarCampos()) {
                JOptionPane.showMessageDialog(tela, "Dados salvos com sucesso!");
                limparCampos();
                habilitarCampos(false);
                btnSalvar.setEnabled(false);
                btnNovo.setEnabled(true);
                btnExcluir.setEnabled(false);
            }
        });

        //botão excluir
        btnExcluir.addActionListener(e -> {
            btnSalvar.setEnabled(false);
            limparCampos();
            habilitarCampos(false);
            btnNovo.setEnabled(true);
            btnExcluir.setEnabled(false);
            btnAlterar.setEnabled(false);
            txtLogin.setEnabled(true);
        });

        //botão pesquisar (Autocompleta com dados genericos somente se o campo Login não estiver vazio)
        btnPesquisar.addActionListener(e -> {
            if (!txtLogin.getText().isEmpty()) {
                txtID.setText("1");
                txtNome.setText("Usuário Exemplo");
                txtSenha.setText("senha123");
                habilitarCampos(false);
                btnSalvar.setEnabled(false);
                btnExcluir.setEnabled(true);
                btnAlterar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(tela, "O campo Login deve ser preenchido para pesquisar.");
            }
        });


        habilitarCampos(false);
        txtLogin.setEnabled(true);
        tela.setVisible(true);


    }

    public void limparCampos() {
        txtID.setText("");
        txtNome.setText("");
        txtLogin.setText("");
        txtSenha.setText("");
    }

    public void habilitarCampos(boolean status) {
        txtID.setEnabled(status);
        txtNome.setEnabled(status);
        txtLogin.setEnabled(status);
        txtSenha.setEnabled(status);
    }

    public boolean validarCampos() {
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(tela, "O campo Nome é obrigatório.");
            txtNome.requestFocus();
            return false;
        }
        if (txtLogin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(tela, "O campo Login é obrigatório.");
            txtLogin.requestFocus();
            return false;
        }
        if (txtSenha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(tela, "O campo Senha é obrigatório.");
            txtSenha.requestFocus();
            return false;
        }
        return true;
    }


}
