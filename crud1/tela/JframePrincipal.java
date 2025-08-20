package crud1.tela;

import java.awt.*;
import javax.swing.*;

public class JframePrincipal {
    private JTextField txtSigla, txtDescricao;
    private JComboBox<String> statusComboBox;
    private JButton btnNovo, btnSalvar, btnCancelar;
    private JLabel lblTitulo, lblDescricao, lblSigla, lblStatus;
    private JFrame tela;

    public void limparCampos() {
        txtSigla.setText("");
        txtDescricao.setText("");
        statusComboBox.setSelectedIndex(0);
    };

    public void habilitarCampos(boolean estado) {
        txtSigla.setEnabled(estado);
        txtDescricao.setEnabled(estado);
        statusComboBox.setEnabled(estado);
    }

    public boolean validarCampos() {
        // Valida Sigla
        if (txtSigla.getText() == null || txtSigla.getText().length() == 0) {
            JOptionPane.showMessageDialog(tela, "Sigla é obrigatória!", "Erro", JOptionPane.ERROR_MESSAGE);
            txtSigla.requestFocus();
            return false;
        }

        // Valida Descrição
        if (txtDescricao.getText() == null || txtDescricao.getText().length() == 0) {
            JOptionPane.showMessageDialog(tela, "Descrição é obrigatória!", "Erro", JOptionPane.ERROR_MESSAGE);
            txtDescricao.requestFocus();
            return false;
        }

        // Valida Status
        if (statusComboBox.getSelectedItem() == null ||
                statusComboBox.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(tela, "Selecione um status válido!", "Erro", JOptionPane.ERROR_MESSAGE);
            statusComboBox.requestFocus();
            return false;
        }

        return true;
    }

    public JframePrincipal() {
        tela = new JFrame("Cadastro de Clientes");
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(500, 400);
        tela.setLayout(new GridBagLayout());
        tela.setResizable(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        int linha = 0;
        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.gridwidth = 2;
        lblTitulo = new JLabel("Cadastro de Clientes");
        lblTitulo.setFont(new Font("Calibri(título)", Font.BOLD, 20));
        tela.add(lblTitulo, gbc);

        linha++;
        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        lblSigla = new JLabel("Sigla");
        tela.add(lblSigla, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 1;
        txtSigla = new JTextField(10);
        tela.add(txtSigla, gbc);

        linha++;
        gbc.gridx = 0;
        gbc.gridy = linha;

        lblDescricao = new JLabel("Descrição");
        tela.add(lblDescricao, gbc);

        gbc.gridx = 1;

        txtDescricao = new JTextField(20);
        tela.add(txtDescricao, gbc);

        linha++;
        gbc.gridx = 0;
        gbc.gridy = linha;

        lblStatus = new JLabel("Status");
        tela.add(lblStatus, gbc);

        gbc.gridx = 1;

        String[] status = { "Selecione", "Ativo", "Inativo" };
        statusComboBox = new JComboBox<>(status);
        tela.add(statusComboBox, gbc);

        linha++;
        gbc.gridx = 0;
        gbc.gridy = linha;

        // Botões

        btnNovo = new JButton("Novo");
        // tela.add(btnNovo,gbc);

        btnSalvar = new JButton("Salvar");
        // tela.add(btnSalvar,gbc);
        btnSalvar.setEnabled(false);

        btnCancelar = new JButton("Cancelar");
        // tela.add(btnCancelar,gbc);
        btnCancelar.setEnabled(false);

        gbc.anchor = GridBagConstraints.CENTER;
        JPanel AlinharBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        AlinharBotoes.add(btnNovo);
        AlinharBotoes.add(btnSalvar);
        AlinharBotoes.add(btnCancelar);

        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.gridwidth = 2;
        tela.add(AlinharBotoes, gbc);

        // Botão novo
        btnNovo.addActionListener(e -> habilitarCampos(true));
        btnNovo.addActionListener(e -> btnSalvar.setEnabled(true));
        btnNovo.addActionListener(e -> btnNovo.setEnabled(false));
        btnNovo.addActionListener(e -> btnCancelar.setEnabled(true));

        // Botão Salvar
        btnSalvar.addActionListener(e -> {

            if (validarCampos() == true) {
                habilitarCampos(false);
                limparCampos();
                btnNovo.setEnabled(true);
                btnSalvar.setEnabled(false);
                btnCancelar.setEnabled(false);
                JOptionPane.showMessageDialog(tela, "Informações Salvas!", "Status", JOptionPane.INFORMATION_MESSAGE);
            }

        });

        // Botão Cancelar
        btnCancelar.addActionListener(e -> {
            btnSalvar.setEnabled(false);
            limparCampos();
            habilitarCampos(false);
            btnNovo.setEnabled(true);
            btnCancelar.setEnabled(false);
        });

        habilitarCampos(false);
        txtSigla.setEnabled(true);
        tela.setVisible(true);
    }

}