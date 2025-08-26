package crud0.tela;

import javax.swing.*;
import java.awt.*;

public class JframePrincipal {

    // 1. Declaração de todos os componentes e variáveis da classe e inicializando-os
    private JFrame tela = new JFrame("Cadastro");

    private JTextField txtID = new JTextField(10);
    private JTextField txtNome = new JTextField(20);
    private JTextField txtLogin = new JTextField(15);
    private JTextField txtSenha = new JTextField(15);

    private final JButton btnNovo = new JButton("Novo");
    private final JButton btnSalvar = new JButton("Salvar");
    private final JButton btnPesquisar = new JButton("Pesquisar");
    private final JButton btnAlterar = new JButton("Alterar");
    private final JButton btnExcluir = new JButton("Excluir");

    private GridBagConstraints grid = new GridBagConstraints();
    private int linha = 0;


    // 2. Construtor chama os métodos de configuração em ordem
    public JframePrincipal() {

        configurarTela();
        adicionarCampos();
        adicionarBotoes();
        configurarBotoes();
        estadoInicial();

        tela.setVisible(true);
    }


    // 3. Métodos privados para cada responsabilidade
    private void configurarTela() {
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(500, 300); // Ajustado para melhor visualização
        tela.setLayout(new GridBagLayout());
        tela.setResizable(false);
        tela.setLocationRelativeTo(null); // Centraliza a tela

        grid.insets = new Insets(5, 5, 5, 5);
        grid.anchor = GridBagConstraints.WEST;
    }

    private void adicionarCampos(){
        addCampo("ID", txtID);
        addCampo("Nome", txtNome);
        addCampo("Login", txtLogin);
        addCampo("Senha", txtSenha);
    }

    private void adicionarBotoes(){
        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        botoes.add(btnNovo);
        botoes.add(btnSalvar);
        botoes.add(btnPesquisar);
        botoes.add(btnAlterar);
        botoes.add(btnExcluir);

        grid.gridx = 0; grid.gridy = linha;
        grid.gridwidth = 2;
        grid.anchor = GridBagConstraints.CENTER;
        tela.add(botoes, grid);
    }

    private void configurarBotoes() {
        // Botão Novo
        btnNovo.addActionListener(e -> {
            habilitarCampos(true);
            limparCampos();
            btnSalvar.setEnabled(true);
            btnExcluir.setEnabled(false);
            btnAlterar.setEnabled(false);
            btnNovo.setEnabled(false);
            txtNome.requestFocus();
        });

        // Botão Salvar
        btnSalvar.addActionListener(e -> {
            if (validarCampos()) {
                JOptionPane.showMessageDialog(tela, "Dados salvos com sucesso!");
                limparCampos();
                estadoInicial();
            }
        });

        // Botão Pesquisar
        btnPesquisar.addActionListener(e -> {
            if (!txtLogin.getText().isEmpty()) {
                txtID.setText("1");
                txtNome.setText("Usuário Exemplo");
                txtSenha.setText("senha123");

                habilitarCampos(false); // Desabilita campos após a pesquisa
                btnSalvar.setEnabled(false);
                btnExcluir.setEnabled(true);
                btnAlterar.setEnabled(true);
                btnNovo.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(tela, "O campo Login deve ser preenchido para pesquisar.");
            }
        });

        // Botão Alterar
        btnAlterar.addActionListener(e -> {
            habilitarCampos(true);
            txtID.setEnabled(false); // ID não deve ser alterado
            txtLogin.setEnabled(true);
            btnSalvar.setEnabled(true);
            btnAlterar.setEnabled(false);
            btnExcluir.setEnabled(false);
        });

        // Botão Excluir (agora age como um Cancelar/Limpar)
        btnExcluir.addActionListener(e -> {
            limparCampos();
            estadoInicial();
            JOptionPane.showMessageDialog(tela, "Usuario excluido com sucesso.");
        });
    }

    private void estadoInicial() {
        limparCampos();
        habilitarCampos(false);
        txtLogin.setEnabled(true); // Apenas login habilitado para pesquisa

        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);

        txtLogin.requestFocus();
    }


    // 4. Métodos de apoio
    private void limparCampos() {
        txtID.setText("");
        txtNome.setText("");
        txtLogin.setText("");
        txtSenha.setText("");
    }

    private void habilitarCampos(boolean status) {
        txtID.setEnabled(status);
        txtNome.setEnabled(status);
        txtLogin.setEnabled(status);
        txtSenha.setEnabled(status);
    }

    private boolean validarCampos() {
        // Metodo de validação dos campos com mensagens específicas
        if (txtNome.getText().trim().isEmpty() || !txtNome.getText().matches("[a-zA-ZÀ-ÿ\\s]+")) {
            JOptionPane.showMessageDialog(tela, "Nome inválido.");
            txtNome.requestFocus();
            return false;
        }
        if (txtLogin.getText().trim().isEmpty() || !txtLogin.getText().matches("[a-zA-Z0-9_]+")) {
            JOptionPane.showMessageDialog(tela, "Login inválido.");
            txtLogin.requestFocus();
            return false;
        }
        if (txtSenha.getText().length() < 6) {
            JOptionPane.showMessageDialog(tela, "Senha deve ter no mínimo 6 caracteres.");
            txtSenha.requestFocus();
            return false;
        }
        return true;
    }

    private void addCampo(String label, JComponent campo) {
         //Metodo auxiliar para adicionar os campos na tela
        grid.gridx = 0;
        grid.gridy = linha;
        tela.add(new JLabel(label), grid);
        grid.gridx = 1;
        tela.add(campo, grid);
        linha++;
    }

    
    // 5. Método main para iniciar a aplicação
    public static void main(String[] args) {

        new JframePrincipal();
    }
}