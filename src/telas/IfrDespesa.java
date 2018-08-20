/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import daos.Dao;
import daos.DespesaDao;
import daos.UsuarioDao;
import entidades.Despesa;
import entidades.Usuario;
import java.awt.Dimension;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import log4j.Log4J;
import util.Formatacao;
import util.Validacao;

/**
 *
 * @author Matheus
 */
public class IfrDespesa extends javax.swing.JInternalFrame {
    private int id = 0;
    private Usuario solicitante = null;
    Logger log = Logger.getLogger(Log4J.class.getName());
    /**
     * Creates new form IfrDespesa
     */
    public IfrDespesa() {
        initComponents();
        DespesaDao.popularTabelaFiltro(tblDespesas, tfdBuscarDespesa.getText(), "descricao");
        Validacao.formatarData(tfdData);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfdDescricao = new javax.swing.JTextField();
        tfdMotivo = new javax.swing.JTextField();
        tfdValor = new javax.swing.JTextField();
        tfdData = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tfdCriterio = new javax.swing.JTextField();
        cbFiltroConsulta = new javax.swing.JComboBox<>();
        btnConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDespesas = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbFiltroConsulta1 = new javax.swing.JComboBox<>();
        btnBuscarDespesa = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfdBuscarDespesa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setTitle("Gastos");

        jLabel1.setText("<html>Descrição:<font color = red>*</font></html>");

        jLabel2.setText("<html>Motivo:<font color = red>*</font></html>");

        jLabel3.setText("<html>Valor:<font color = red>*</font></html>");

        jLabel4.setText("<html>Data:<font color = red>*</font></html>");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfdDescricao)
                        .addComponent(tfdMotivo, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tfdData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                        .addComponent(tfdValor, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(139, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(btnSalvar))
        );

        jTabbedPane1.addTab("Inclusão", jPanel1);

        jLabel6.setText("Critério");

        cbFiltroConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Login", "Nome" }));

        btnConsultar.setText("Buscar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Login", "Nome Completo", "Ativo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUsuario);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfdCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFiltroConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsultar)
                        .addContainerGap(32, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfdCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFiltroConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Usuário", jPanel2);

        tblDespesas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblDespesas);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel7.setText("Critério");

        cbFiltroConsulta1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Login", "Nome" }));

        btnBuscarDespesa.setText("Buscar");
        btnBuscarDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDespesaActionPerformed(evt);
            }
        });

        jLabel5.setText("Descrição");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnEditar)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(tfdBuscarDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnBuscarDespesa)
                        .addGap(20, 20, 20))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel7)
                    .addGap(386, 386, 386)
                    .addComponent(cbFiltroConsulta1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(92, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarDespesa)
                    .addComponent(jLabel5)
                    .addComponent(tfdBuscarDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnEditar))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(147, 147, 147)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(cbFiltroConsulta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(149, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Consulta", jPanel3);

        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        UsuarioDao.popularTabelaFiltro(tblUsuario, tfdCriterio.getText(), cbFiltroConsulta.getSelectedItem().toString());
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        

        if(tfdDescricao.getText().length() < 4)
        {
            JOptionPane.showMessageDialog(this, "Preencha uma descrição válida!");
            return;
        }
        if(tfdMotivo.getText().length() < 4)
        {
            JOptionPane.showMessageDialog(this, "Preencha um motivo válido!");
            return;
        }
        
        if(tfdValor.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Preencha um valor válido!");
            return;
        }
        
        if (tfdData.getText().equals("  /  /    ") || tfdData.getText().contains(" ")) {
            JOptionPane.showMessageDialog(null, "Preencha uma data válida!");
            return;
        }
        
        if (!Validacao.validarDataFormatada(tfdData.getText())) {
            JOptionPane.showMessageDialog(null, "Preencha uma data válida!");
            return;
        }
        
        try {
            Date contrata = Formatacao.transformarParaData(tfdData.getText());
            if (contrata.after(new Date(System.currentTimeMillis()))) {
                JOptionPane.showMessageDialog(null, "Preencha uma data válida!");
                return;
            } 
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        tfdValor.setName("Valor");
             
        if (Validacao.ValidaDouble(tfdValor) != true){
            return;
        }

        if (tblUsuario.getSelectedRowCount() == 0 && this.solicitante == null)
        {
            JOptionPane.showMessageDialog(this, "Selecione um funcionário da lista!");
            return;
        }
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        Date dataFormatada = null;
        try {
            dataFormatada = formato.parse(tfdData.getText());
        } catch (ParseException ex) {
            Logger.getLogger(IfrDespesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Despesa despesa = new Despesa();
        
        if(id > 0)
        {
            despesa.setId(id);
        }
        
        if(this.solicitante == null)
        {
            Usuario usuario = UsuarioDao.buscaId((int) tblUsuario.getValueAt(tblUsuario.getSelectedRow(), 0));
            despesa.setUsuarioByRefFuncionario(usuario);
            despesa.setUsuarioByRefOperador(usuario);
        }
        else
        {
            despesa.setUsuarioByRefFuncionario(this.solicitante);
            despesa.setUsuarioByRefOperador(this.solicitante);
        }
        despesa.setDescricao(tfdDescricao.getText());
        despesa.setMotivo(tfdMotivo.getText());
        despesa.setValor(BigDecimal.valueOf(Double.parseDouble(tfdValor.getText())));
        despesa.setData(dataFormatada);
        
        if (Dao.salvar(despesa).equals("Sucesso")) {
            id = 0;
            this.solicitante = null;
            JOptionPane.showMessageDialog(this, "Despesa inserida com sucesso!");
            tfdDescricao.setText("");
            tfdMotivo.setText("");
            tfdData.setText("");
            tfdValor.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar despesa!");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            tfdDescricao.setText("");
            int idDespesa = Integer.parseInt(String.valueOf(tblDespesas.getValueAt(tblDespesas.getSelectedRow(), 0)));
            Despesa d;

            d = DespesaDao.buscaId(idDespesa);
            
            Date data = d.getData();
            SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(sfd.format(data));
            tfdDescricao.setText(d.getDescricao());
            tfdMotivo.setText(d.getMotivo());
            tfdValor.setText(d.getValor().toString());
            tfdData.setText(sfd.format(data));

            tblDespesas.clearSelection();
            jTabbedPane1.setSelectedIndex(0);

            this.solicitante = d.getUsuarioByRefFuncionario();

            id = d.getId();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Escolha a despesa a ser EDITADA!");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDespesaActionPerformed
        DespesaDao.popularTabelaFiltro(tblDespesas, tfdBuscarDespesa.getText(), "descricao");
    }//GEN-LAST:event_btnBuscarDespesaActionPerformed
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarDespesa;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbFiltroConsulta;
    private javax.swing.JComboBox<String> cbFiltroConsulta1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDespesas;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTextField tfdBuscarDespesa;
    private javax.swing.JTextField tfdCriterio;
    private javax.swing.JFormattedTextField tfdData;
    private javax.swing.JTextField tfdDescricao;
    private javax.swing.JTextField tfdMotivo;
    private javax.swing.JTextField tfdValor;
    // End of variables declaration//GEN-END:variables
}
