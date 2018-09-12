/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import daos.Dao;
import daos.EstadoVeiculoDao;
import daos.VeiculoDao;
import entidades.Programas;
import entidades.Veiculo;
import java.awt.Dimension;
import java.math.BigDecimal;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import permissao.Controle;
import util.FormataCampo;
import util.Validacao;

/**
 *
 * @author Matheus
 */
public class IfrVeiculo extends javax.swing.JInternalFrame {
    private int id = 0;
    /**
     * Creates new form IfrVeiculo
     */
    public IfrVeiculo() {
        initComponents();
        cmbEstado.removeAllItems();
        EstadoVeiculoDao.populaCombo(cmbEstado);
        VeiculoDao.popularTabelaFiltro(tblVeiculos, "", "modelo");
        btnSalvar.setName("btnSalvar");
        btnDeletar.setName("btnDeletar");
        btnBuscar.setName("btnBuscar");
        btnEditar.setName("btnEditar");
        Programas telaAtual = new Programas(0, "Veiculo", "IfrVeiculo");
        Controle.permissiona(jTabbedPane1, telaAtual);
    }
public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tfdDescricao = new javax.swing.JTextField();
        tfdModelo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfdAno = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfdCapacidade = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfdQuilometragem = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        tfdPlaca = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        btnDeletar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        tfdBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVeiculos = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();

        setTitle("Cadastro de Veículos");

        jLabel8.setText("<html>Descrição:<font color = red>*</font></html>");

        jLabel9.setText("<html>Modelo:<font color = red>*</font></html>");

        jLabel10.setText("<html>Ano:<font color = red>*</font></html>");

        tfdAno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfdAnoKeyTyped(evt);
            }
        });

        jLabel11.setText("<html>Capacidade:<font color = red>*</font></html>");

        jLabel12.setText("<html>Quilometragem:<font color = red>*</font></html>");

        jLabel13.setText("<html>Placa:<font color = red>*</font></html>");

        jLabel14.setText("<html>Estado do veículo:<font color = red>*</font></html>");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        try {
            tfdPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("???-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdModelo))
                        .addGap(234, 234, 234))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfdAno, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdCapacidade, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdQuilometragem, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdQuilometragem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cadastro", jPanel1);

        btnDeletar.setText("Deletar");
        btnDeletar.setEnabled(false);
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.setEnabled(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Modelo:");

        tblVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblVeiculos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDeletar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar)
                                .addGap(80, 80, 80)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(tfdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletar)
                    .addComponent(btnEditar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta", jPanel2);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFechar)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        try {
            int idUnidade = Integer.parseInt(String.valueOf(tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 0)));
            Veiculo v;

            v = VeiculoDao.buscaId(idUnidade);
            
            int result = JOptionPane.showConfirmDialog(null,"Deseja Excluir ? ","Excluir",JOptionPane.YES_NO_CANCEL_OPTION);
        
            if(result ==JOptionPane.YES_OPTION)
            {
                Dao.deletar(v);
                VeiculoDao.popularTabelaFiltro(tblVeiculos, "", "modelo");
            }

            tblVeiculos.clearSelection();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Escolha a unidade a ser EDITADA!");
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        VeiculoDao.popularTabelaFiltro(tblVeiculos, tfdBuscar.getText(), "modelo");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(tfdDescricao.getText().length() < 4)
        {
            JOptionPane.showMessageDialog(this, "Preencha uma descrição válida!");
            return;
        }
        if(tfdModelo.getText().length() < 4)
        {
            JOptionPane.showMessageDialog(this, "Preencha um modelo válido!");
            return;
        }
        
        if(tfdAno.getText().length() < 4)
        {
            JOptionPane.showMessageDialog(this, "Preencha um ano válido!");
            return;
        }
        if(tfdQuilometragem.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Preencha uma quilometragem válida!");
            return;
        }
        if(tfdCapacidade.getText().length() < 3)
        {
            JOptionPane.showMessageDialog(this, "Preencha uma capacidade válida!");
            return;
        }
         
        tfdAno.setName("Ano");
        tfdCapacidade.setName("Capacidade");
        tfdQuilometragem.setName("Quilometragem");
             
        if (Validacao.ValidaDouble(tfdCapacidade) != true || Validacao.ValidaDouble(tfdQuilometragem) != true){
            return;
        }
        if (Validacao.ValidaNumero(tfdAno) != true){
            return;
        }
        
        if(Integer.parseInt(tfdAno.getText()) < 1970 || Integer.parseInt(tfdAno.getText()) > 2025 )
        {
            JOptionPane.showMessageDialog(this, "Digite um ano válido!");
            return;
        }
        
        if(cmbEstado.getSelectedIndex() == 0)
        {
            JOptionPane.showMessageDialog(this, "Escolha um estado inicial para o veículo!");
            return;
        }
        if(tfdPlaca.getText().trim().length() != 8)
        {
            JOptionPane.showMessageDialog(this, "Digite uma placa de carro válida!");
            return;
        }
        
        Veiculo veiculo = new Veiculo();
        
        if(id > 0)
        {
            veiculo.setId(id);
        }
        
        veiculo.setDescricao(tfdDescricao.getText());
        veiculo.setModelo(tfdModelo.getText());
        veiculo.setAno(tfdAno.getText());
        veiculo.setCapacidade(BigDecimal.valueOf(Double.parseDouble(tfdCapacidade.getText())));
        veiculo.setQuilometragem(BigDecimal.valueOf(Double.parseDouble(tfdQuilometragem.getText())));
        veiculo.setPlaca(tfdPlaca.getText());
        veiculo.setEstadoVeiculo(EstadoVeiculoDao.buscaId(cmbEstado.getSelectedIndex()));

        if (Dao.salvar(veiculo).equals("Sucesso")) {
            id = 0;
            JOptionPane.showMessageDialog(this, "Veículo cadastrado com sucesso!");
            this.resetaCampos();
            VeiculoDao.popularTabelaFiltro(tblVeiculos, "", "modelo");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar unidade!");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            tfdDescricao.setText("");
            int idVeiculo = Integer.parseInt(String.valueOf(tblVeiculos.getValueAt(tblVeiculos.getSelectedRow(), 0)));
            Veiculo v;

            v = VeiculoDao.buscaId(idVeiculo);

            tfdDescricao.setText(v.getDescricao());
            tfdModelo.setText(v.getModelo());
            tfdAno.setText(v.getAno());
            tfdCapacidade.setText(v.getCapacidade().toString());
            tfdQuilometragem.setText(v.getQuilometragem().toString());
            tfdPlaca.setText(v.getPlaca());
            cmbEstado.setSelectedIndex(v.getEstadoVeiculo().getId());

            tblVeiculos.clearSelection();
            jTabbedPane1.setSelectedIndex(0);
            id = v.getId();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Escolha o veículo a ser EDITADO!");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tfdAnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdAnoKeyTyped
        FormataCampo.somenteNumeros(evt);
    }//GEN-LAST:event_tfdAnoKeyTyped

    private void resetaCampos() {
        tfdDescricao.setText("");
        tfdModelo.setText("");
        tfdAno.setText("");
        tfdQuilometragem.setText("");
        tfdCapacidade.setText("");
        tfdPlaca.setText("");
        cmbEstado.setSelectedIndex(0);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblVeiculos;
    private javax.swing.JTextField tfdAno;
    private javax.swing.JTextField tfdBuscar;
    private javax.swing.JTextField tfdCapacidade;
    private javax.swing.JTextField tfdDescricao;
    private javax.swing.JTextField tfdModelo;
    private javax.swing.JFormattedTextField tfdPlaca;
    private javax.swing.JTextField tfdQuilometragem;
    // End of variables declaration//GEN-END:variables
}
