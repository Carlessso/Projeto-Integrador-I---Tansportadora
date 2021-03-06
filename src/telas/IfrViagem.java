/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import daos.Dao;
import daos.FreteDao;
import daos.FreteViagemDao;
import daos.ViagemDao;
import entidades.Frete;
import entidades.FreteViagem;
import entidades.ProdutosFrete;
import entidades.Programas;
import entidades.Unidade;
import entidades.Veiculo;
import entidades.Viagem;
import java.awt.Dimension;
import java.math.BigDecimal;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import permissao.Controle;
import transoft.TranSOFT;

/**
 *
 * @author ramon
 */
public class IfrViagem extends javax.swing.JInternalFrame {

    private Unidade origem;
    private Unidade destino;
    private Veiculo veiculo;
    private Viagem viagem;
    private Unidade origemBusca;
    private final Programas telaAtual = new Programas(0, "Viagem", "IfrViagem");

    /**
     * Creates new form IfrViagem
     */
    public IfrViagem() {
        initComponents();
        this.origem = TranSOFT.UNIDADE;
        this. origemBusca = TranSOFT.UNIDADE;
        tfdOrigem.setText(this.origem.getDescricao());
        tfdOrigemBusca.setText(this.origemBusca.getDescricao());
        viagem = new Viagem();
        ViagemDao.popularTabelaFiltro(tblViagem, origem, "");
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
        jLabel1 = new javax.swing.JLabel();
        tfdOrigem = new javax.swing.JTextField();
        btnOrigem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfdDestino = new javax.swing.JTextField();
        btnDestino = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfdVeiculo = new javax.swing.JTextField();
        btnVeiculo = new javax.swing.JButton();
        btnSalvarViagem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFreteDisponivel = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFreteViagem = new javax.swing.JTable();
        btnRemover = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfdCapacidade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfdDestinoFrete = new javax.swing.JTextField();
        btnFinalizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblViagem = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tfdOrigemBusca = new javax.swing.JTextField();
        btnOrigemBusca = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        chkFinalizada = new javax.swing.JCheckBox();
        btnFechar = new javax.swing.JButton();

        setTitle("Cadastro de Viagem");

        jLabel1.setText("<html>Unidade Origem:<font color = red>*</font></html>");

        tfdOrigem.setEnabled(false);

        btnOrigem.setText("Selecionar");
        btnOrigem.setEnabled(false);
        btnOrigem.setName("btnOrigem"); // NOI18N
        btnOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrigemActionPerformed(evt);
            }
        });

        jLabel2.setText("<html>Unidade Destino:<font color = red>*</font></html>");

        tfdDestino.setEnabled(false);

        btnDestino.setText("Selecionar");
        btnDestino.setEnabled(false);
        btnDestino.setName("btnDestino"); // NOI18N
        btnDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDestinoActionPerformed(evt);
            }
        });

        jLabel3.setText("<html>Veículo:<font color = red>*</font></html>");

        tfdVeiculo.setEnabled(false);

        btnVeiculo.setText("Selecionar");
        btnVeiculo.setEnabled(false);
        btnVeiculo.setName("btnVeiculo"); // NOI18N
        btnVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVeiculoActionPerformed(evt);
            }
        });

        btnSalvarViagem.setText("Salvar e Continuar");
        btnSalvarViagem.setEnabled(false);
        btnSalvarViagem.setName("btnSalvarViagem"); // NOI18N
        btnSalvarViagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarViagemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfdDestino)
                            .addComponent(tfdOrigem)
                            .addComponent(tfdVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOrigem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvarViagem)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrigem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDestino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVeiculo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
                .addComponent(btnSalvarViagem)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cadastro", jPanel1);

        jLabel4.setText("Fretes Disponíveis");

        tblFreteDisponivel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Remetente", "Destino", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFreteDisponivel);

        btnAdicionar.setText("Adicionar");
        btnAdicionar.setEnabled(false);
        btnAdicionar.setName("btnAdicionar"); // NOI18N
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jLabel5.setText("Fretes na Viagem");

        tblFreteViagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Remetente", "Destino", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblFreteViagem);

        btnRemover.setText("Remover");
        btnRemover.setEnabled(false);
        btnRemover.setName("btnRemover"); // NOI18N
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        jLabel6.setText("Capacidade Restante:");

        tfdCapacidade.setEnabled(false);

        jLabel7.setText("Destino");

        tfdDestinoFrete.setEnabled(false);

        btnFinalizar.setText("Finalizar");
        btnFinalizar.setName("btnFinalizar"); // NOI18N
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfdCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemover))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdDestinoFrete, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdicionar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnFinalizar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfdDestinoFrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemover))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(tfdCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnFinalizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Fretes", jPanel2);

        tblViagem.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblViagem);

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.setName("btnEditar"); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel8.setText("<html>Unidade Origem:<font color = red>*</font></html>");

        tfdOrigemBusca.setEnabled(false);

        btnOrigemBusca.setText("Selecionar");
        btnOrigemBusca.setEnabled(false);
        btnOrigemBusca.setName("btnOrigemBusca"); // NOI18N
        btnOrigemBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrigemBuscaActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.setEnabled(false);
        btnBuscar.setName("btnBuscar"); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel9.setText("Finalizada");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEditar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfdOrigemBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOrigemBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(chkFinalizada)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdOrigemBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOrigemBusca)
                            .addComponent(jLabel9))
                        .addComponent(chkFinalizada))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnBuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Busca", jPanel3);

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
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrigemActionPerformed
        JdgBuscaUnidade busca = new JdgBuscaUnidade();
        busca.setModal(true);
        busca.setVisible(true);
        Unidade u = busca.getUnidadeSelecionada();
        if (u != null) {
            this.origem = u;
            tfdOrigem.setText(u.getDescricao());
        }
    }//GEN-LAST:event_btnOrigemActionPerformed

    private void btnDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDestinoActionPerformed
        JdgBuscaUnidade busca = new JdgBuscaUnidade();
        busca.setModal(true);
        busca.setVisible(true);
        Unidade u = busca.getUnidadeSelecionada();
        if (u != null) {
            this.destino = u;
            tfdDestino.setText(u.getDescricao());
        }
    }//GEN-LAST:event_btnDestinoActionPerformed

    private void btnSalvarViagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarViagemActionPerformed
        String erro = validaDadosViagem();

        if (erro.isEmpty()) {
            viagem.setUnidadeByRefUnidadeOrigem(origem);
            viagem.setUnidadeByRefUnidadeDestino(destino);
            viagem.setVeiculo(veiculo);
            if (viagem.getId() == 0) {
                viagem.setQuilometragem(BigDecimal.ZERO);
            }
            if (ViagemDao.salvar(viagem).equals("Sucesso")) {
                preencheFrete();
                tfdDestinoFrete.setText(destino.getDescricao());
                JOptionPane.showMessageDialog(this, "Viagem salva com Sucesso!");
                jTabbedPane1.setSelectedIndex(1);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao salvar viagem.");
            }
        } else {
            JOptionPane.showMessageDialog(this, erro);
        }
    }//GEN-LAST:event_btnSalvarViagemActionPerformed

    private void btnVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVeiculoActionPerformed
        JdgBuscaVeiculo busca = new JdgBuscaVeiculo();
        busca.setModal(true);
        busca.setVisible(true);
        Veiculo v = busca.getVeiculoSelecionado();
        if (v != null) {
            this.veiculo = v;
            tfdVeiculo.setText(v.getDescricao() + ", " + v.getModelo() + ", " + v.getPlaca());
        }
    }//GEN-LAST:event_btnVeiculoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            this.resetaCampos();
            btnSalvarViagem.setEnabled(true);
            int idViagem = Integer.parseInt(String.valueOf(tblViagem.getValueAt(tblViagem.getSelectedRow(), 0)));
            viagem = ViagemDao.buscaId(idViagem);
            if (viagem.getDataFinal() == null) {
                origem = viagem.getUnidadeByRefUnidadeOrigem();
                tfdOrigem.setText(origem.getDescricao());
                destino = viagem.getUnidadeByRefUnidadeDestino();
                tfdDestino.setText(destino.getDescricao());
                veiculo = viagem.getVeiculo();
                tfdVeiculo.setText(veiculo.getDescricao() + ", " + veiculo.getModelo() + ", " + veiculo.getPlaca());
                tfdDestinoFrete.setText(destino.getDescricao());
                preencheFrete();
                jTabbedPane1.setSelectedIndex(0);
            } else {
                viagem = new Viagem();
                JOptionPane.showMessageDialog(this, "Viagens finalizadas não podem ser EDITADAS!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Selecione a Viagem a ser EDITADA!");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if (tblFreteDisponivel.getSelectedRow() >= 0) {
            FreteViagem fv = new FreteViagem();
            int idFrete = Integer.parseInt(String.valueOf(tblFreteDisponivel.getValueAt(tblFreteDisponivel.getSelectedRow(), 0)));
            Frete f = FreteDao.buscaId(idFrete);
            f.setUnidadeAtual(null);
            fv.setFrete(f);
            fv.setViagem(viagem);

            Double capacidade = Double.parseDouble(tfdCapacidade.getText());
            Iterator<ProdutosFrete> produtosAsIterator = f.getProdutosFretes().iterator();
            while (produtosAsIterator.hasNext()) {
                ProdutosFrete pf = produtosAsIterator.next();
                capacidade = capacidade - pf.getPeso().doubleValue();
            }

            if (capacidade < 0) {
                JOptionPane.showMessageDialog(null, "Peso da viagem extrapolado!");
            } else {
                if (FreteViagemDao.salvar(fv).equals("Sucesso") && FreteDao.salvar(f).equals("Sucesso")) {
                    adicionarRemoverTabela(tblFreteDisponivel, tblFreteViagem);
                    tfdCapacidade.setText(capacidade + "");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar frete na viagem!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor selecionar um produto para adicionar!");
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if (tblFreteViagem.getSelectedRow() >= 0) {

            int idFrete = Integer.parseInt(String.valueOf(tblFreteViagem.getValueAt(tblFreteViagem.getSelectedRow(), 0)));
            Frete f = FreteDao.buscaId(idFrete);
            f.setUnidadeAtual(viagem.getUnidadeByRefUnidadeOrigem());

            FreteViagem fv = FreteViagemDao.busca(f, viagem);

            Double capacidade = Double.parseDouble(tfdCapacidade.getText());
            Iterator<ProdutosFrete> produtosAsIterator = f.getProdutosFretes().iterator();
            while (produtosAsIterator.hasNext()) {
                ProdutosFrete pf = produtosAsIterator.next();
                capacidade = capacidade + pf.getPeso().doubleValue();
            }

            if (FreteViagemDao.deletar(fv).equals("Sucesso") && FreteDao.salvar(f).equals("Sucesso")) {
                adicionarRemoverTabela(tblFreteViagem, tblFreteDisponivel);
                tfdCapacidade.setText(capacidade + "");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao remover frete da viagem!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor selecionar um produto para remover!");
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        resetaCampos();
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnOrigemBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrigemBuscaActionPerformed
        JdgBuscaUnidade busca = new JdgBuscaUnidade();
        busca.setModal(true);
        busca.setVisible(true);
        Unidade u = busca.getUnidadeSelecionada();
        if (u != null) {
            this.origemBusca = u;
            tfdOrigemBusca.setText(u.getDescricao());
        }
    }//GEN-LAST:event_btnOrigemBuscaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String ativo;
        if(chkFinalizada.isSelected()){
            ativo = "false";
        } else {
            ativo = "true";
        }
        ViagemDao.popularTabelaFiltro(tblViagem, origemBusca, ativo);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private String validaDadosViagem() {
        String erro = "";

        if (this.origem == null) {
            erro = erro + "Escolha a origem.\n";
        }
        if (this.destino == null) {
            erro = erro + "Escolha o destino.\n";
        }
        if (erro.isEmpty()) {
            if (this.origem.getId() == this.destino.getId()) {
                erro = erro + "Origem e Destino não podem ser iguais.\n";
            }
        }
        if (this.veiculo == null) {
            erro = erro + "Escolha o veículo.";
        }
        return erro;
    }

    private void resetaCampos() {
        destino = null;
        veiculo = null;
        tfdDestino.setText("");
        tfdVeiculo.setText("");
        tfdDestinoFrete.setText("");
        tfdCapacidade.setText("");
        viagem = new Viagem();
        DefaultTableModel model = (DefaultTableModel) tblFreteDisponivel.getModel();
        model.setRowCount(0);
        tblFreteDisponivel.setModel(model);
        DefaultTableModel model2 = (DefaultTableModel) tblFreteViagem.getModel();
        model2.setRowCount(0);
        tblFreteViagem.setModel(model2);
        Controle.permissiona(jTabbedPane1, telaAtual);
    }

    private void preencheFrete() {
        FreteDao.populaFreteDisponivel(tblFreteDisponivel, origem);
        FreteDao.populaFreteViagem(tblFreteViagem, viagem);
        tfdCapacidade.setText(ViagemDao.capacidadeRestante(viagem) + "");
    }

    private void adicionarRemoverTabela(JTable remover, JTable adicionar) {
        DefaultTableModel modelRemover = (DefaultTableModel) remover.getModel();
        int linhaRemoção = remover.getSelectedRow();
        String id = String.valueOf(remover.getValueAt(linhaRemoção, 0));
        String remetente = String.valueOf(remover.getValueAt(linhaRemoção, 1));
        String destinoTabela = String.valueOf(remover.getValueAt(linhaRemoção, 2));
        String data = String.valueOf(remover.getValueAt(linhaRemoção, 3));
        modelRemover.removeRow(linhaRemoção);
        remover.setModel(modelRemover);

        DefaultTableModel modelAdicionar = (DefaultTableModel) adicionar.getModel();
        Object[] linha = {id, remetente, destinoTabela, data};
        modelAdicionar.addRow(linha);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDestino;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnOrigem;
    private javax.swing.JButton btnOrigemBusca;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvarViagem;
    private javax.swing.JButton btnVeiculo;
    private javax.swing.JCheckBox chkFinalizada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblFreteDisponivel;
    private javax.swing.JTable tblFreteViagem;
    private javax.swing.JTable tblViagem;
    private javax.swing.JTextField tfdCapacidade;
    private javax.swing.JTextField tfdDestino;
    private javax.swing.JTextField tfdDestinoFrete;
    private javax.swing.JTextField tfdOrigem;
    private javax.swing.JTextField tfdOrigemBusca;
    private javax.swing.JTextField tfdVeiculo;
    // End of variables declaration//GEN-END:variables
}
