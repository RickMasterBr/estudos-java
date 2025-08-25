package crud0.tela;

import javax.swing.*;
import java.awt.*;

public class JframePrincipal {

    // 1. Declaração de todos os componentes e variáveis da classe
    private JFrame tela;
    private JLabel lblID, lblNome, lblLogin, lblSenha;
    private JTextField txtID, txtNome, txtLogin, txtSenha;
    private JButton btnNovo, btnSalvar, btnPesquisar, btnExcluir, btnAlterar;
    private GridBagConstraints grid;
    private int linha;

    // 2. Construtor chama os métodos de configuração em ordem
    public JframePrincipal() {
        tela = new JFrame("Cadastro");

        configurarTela();
        inicializarComponentes();
        configurarLayout();
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

        grid = new GridBagConstraints();
        grid.insets = new Insets(5, 5, 5, 5);
        grid.anchor = GridBagConstraints.WEST;
        linha = 0;
    }

    private void inicializarComponentes() {
        lblID = new JLabel("ID:");
        txtID = new JTextField(10);

        lblNome = new JLabel("Nome:");
        txtNome = new JTextField(20);

        lblLogin = new JLabel("Login:");
        txtLogin = new JTextField(15);

        lblSenha = new JLabel("Senha:");
        txtSenha = new JTextField(15);

        btnNovo = new JButton("Novo");
        btnSalvar = new JButton("Salvar");
        btnPesquisar = new JButton("Pesquisar");
        btnExcluir = new JButton("Excluir");
        btnAlterar = new JButton("Alterar");
    }

    private void configurarLayout() {
        // ID
        grid.gridx = 0;
        grid.gridy = linha;
        tela.add(lblID, grid);
        grid.gridx = 1;
        tela.add(txtID, grid);
        linha++;

        // Nome
        grid.gridx = 0;
        grid.gridy = linha;
        tela.add(lblNome, grid);
        grid.gridx = 1;
        tela.add(txtNome, grid);
        linha++;

        // Login
        grid.gridx = 0;
        grid.gridy = linha;
        tela.add(lblLogin, grid);
        grid.gridx = 1;
        tela.add(txtLogin, grid);
        linha++;

        // Senha
        grid.gridx = 0;
        grid.gridy = linha;
        tela.add(lblSenha, grid);
        grid.gridx = 1;
        tela.add(txtSenha, grid);
        linha++;

        // Painel de Botões
        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelBotoes.add(btnNovo);
        panelBotoes.add(btnSalvar);
        panelBotoes.add(btnPesquisar);
        panelBotoes.add(btnAlterar);
        panelBotoes.add(btnExcluir);
        

        grid.gridx = 0;
        grid.gridy = linha;
        grid.gridwidth = 2; // Ocupa duas colunas
        grid.anchor = GridBagConstraints.CENTER;
        tela.add(panelBotoes, grid);
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
    
    // 4. Métodos de apoio que já estavam bem organizados
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

    //Metodo Validar campos com REGEX e impede campos vazios ou caracteres especfíficos em determinados campos
    private boolean validarCampos() {

        if (txtNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(tela, "O campo Nome é obrigatório.");
            txtNome.requestFocus();
            return false;
        } else if (!txtNome.getText().matches("[a-zA-ZÀ-ÿ\\s]+")) {
            JOptionPane.showMessageDialog(tela, "O campo Nome aceita apenas letras e espaços.");
            txtNome.requestFocus();
            return false;
        }

        if (txtLogin.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(tela, "O campo Login é obrigatório.");
            txtLogin.requestFocus();
            return false;
        } else if(!txtLogin.getText().matches("[a-zA-Z0-9_]+")) {
            JOptionPane.showMessageDialog(tela, "O campo Login aceita apenas letras, números e underscores (_).");
            txtLogin.requestFocus();
            return false;
        }

        if (txtSenha.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(tela, "O campo Senha é obrigatório.");
            txtSenha.requestFocus();
            return false;
        } else if(txtSenha.getText().length() < 6) {
            JOptionPane.showMessageDialog(tela, "O campo Senha deve ter no mínimo 6 caracteres.");
            txtSenha.requestFocus();
            return false;
        }

        return true;
    }

    // 5. Método main para iniciar a aplicação
    public static void main(String[] args) {
        // Garante que a UI seja criada na thread de eventos do Swing
        SwingUtilities.invokeLater(() -> new JframePrincipal());
    }
}