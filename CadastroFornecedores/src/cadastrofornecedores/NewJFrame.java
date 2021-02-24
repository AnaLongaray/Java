package cadastrofornecedores;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Ana Paula
 */
public class NewJFrame extends javax.swing.JFrame {

    int tabela;
    ArrayList<Fornecedores> ListaFornecedores;
    String modo;

    public NewJFrame() {
        initComponents();
        setLocationRelativeTo(null);
        ListaFornecedores = new ArrayList();
        modo = "Navegar";
        ManipulacaoInterface();
    }

    public void ManipulacaoInterface() {
        switch (modo) {
            case "Navegar":
                btn_Salvar.setEnabled(false);
                btn_Cancelar.setEnabled(false);
                btn_Novo.setEnabled(true);
                btn_Editar.setEnabled(false);
                btn_Excluir.setEnabled(false);
                Campo_Nome.setEnabled(false);
                Campo_Cargo.setEnabled(false);
                Campo_Empresa.setEnabled(false);
                Campo_TipoDeEmpresa.setEnabled(false);
                Campo_Telefone.setEnabled(false);
                Campo_Email.setEnabled(false);
                Campo_Assunto.setEnabled(false);

                break;

            case "Novo":
                btn_Salvar.setEnabled(true);
                btn_Cancelar.setEnabled(true);
                btn_Novo.setEnabled(false);
                btn_Editar.setEnabled(false);
                btn_Excluir.setEnabled(false);
                Campo_Nome.setEnabled(true);
                Campo_Cargo.setEnabled(true);
                Campo_Empresa.setEnabled(true);
                Campo_TipoDeEmpresa.setEnabled(true);
                Campo_Telefone.setEnabled(true);
                Campo_Email.setEnabled(true);
                Campo_Assunto.setEnabled(true);

                break;

            case "Editar":
                btn_Salvar.setEnabled(true);
                btn_Cancelar.setEnabled(true);
                btn_Novo.setEnabled(true);
                btn_Editar.setEnabled(false);
                btn_Excluir.setEnabled(false);
                Campo_Nome.setEnabled(true);
                Campo_Cargo.setEnabled(true);
                Campo_Empresa.setEnabled(true);
                Campo_TipoDeEmpresa.setEnabled(true);
                Campo_Telefone.setEnabled(true);
                Campo_Email.setEnabled(true);
                Campo_Assunto.setEnabled(true);

                break;

            case "Excluir":
                btn_Salvar.setEnabled(false);
                btn_Cancelar.setEnabled(false);
                btn_Novo.setEnabled(true);
                btn_Editar.setEnabled(false);
                btn_Excluir.setEnabled(false);
                Campo_Nome.setEnabled(false);
                Campo_Cargo.setEnabled(false);
                Campo_Empresa.setEnabled(false);
                Campo_TipoDeEmpresa.setEnabled(false);
                Campo_Telefone.setEnabled(false);
                Campo_Email.setEnabled(false);
                Campo_Assunto.setEnabled(false);

                break;

            case "Selecao":
                btn_Salvar.setEnabled(false);
                btn_Cancelar.setEnabled(false);
                btn_Novo.setEnabled(true);
                btn_Editar.setEnabled(true);
                btn_Excluir.setEnabled(true);
                Campo_Nome.setEnabled(false);
                Campo_Cargo.setEnabled(false);
                Campo_Empresa.setEnabled(false);
                Campo_TipoDeEmpresa.setEnabled(false);
                Campo_Telefone.setEnabled(false);
                Campo_Email.setEnabled(false);
                Campo_Assunto.setEnabled(false);

                break;

            default:
                System.out.println("Modo Inválido");
        }

    }

    public void LoadTableFornecedores() {

        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Nome", "Cargo", "Empresa", "Tipo de Empresa", "Telefone", "Email", "Assunto"}, 0);

        Tabela_Fornecedores.setRowSorter(new TableRowSorter(modelo));

        for (int i = 0; i < ListaFornecedores.size(); i++) {
            Object linha[] = new Object[]{ListaFornecedores.get(i).getNome(), ListaFornecedores.get(i).getCargo(),
                ListaFornecedores.get(i).getEmpresa(), ListaFornecedores.get(i).getTipoDeEmpresa(),
                ListaFornecedores.get(i).getTelefone(), ListaFornecedores.get(i).getEmail(),
                ListaFornecedores.get(i).getAssunto()};
            modelo.addRow(linha);

        }

        Tabela_Fornecedores.setModel(modelo);
        Tabela_Fornecedores.getColumnModel().getColumn(0).setPreferredWidth(100);
        Tabela_Fornecedores.getColumnModel().getColumn(1).setPreferredWidth(100);
        Tabela_Fornecedores.getColumnModel().getColumn(2).setPreferredWidth(100);
        Tabela_Fornecedores.getColumnModel().getColumn(3).setPreferredWidth(100);
        Tabela_Fornecedores.getColumnModel().getColumn(4).setPreferredWidth(100);
        Tabela_Fornecedores.getColumnModel().getColumn(5).setPreferredWidth(100);
        Tabela_Fornecedores.getColumnModel().getColumn(6).setPreferredWidth(100);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_Novo = new javax.swing.JButton();
        btn_Editar = new javax.swing.JButton();
        btn_Excluir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Campo_Nome = new javax.swing.JTextField();
        Campo_Telefone = new javax.swing.JTextField();
        Campo_Cargo = new javax.swing.JTextField();
        Campo_Empresa = new javax.swing.JTextField();
        Campo_TipoDeEmpresa = new javax.swing.JTextField();
        Campo_Email = new javax.swing.JTextField();
        Campo_Assunto = new javax.swing.JTextField();
        btn_Cancelar = new javax.swing.JButton();
        btn_Salvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela_Fornecedores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fornecedores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Exotc350 DmBd BT", 0, 24), new java.awt.Color(102, 102, 255))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_Novo.setText("Novo");
        btn_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NovoActionPerformed(evt);
            }
        });

        btn_Editar.setText("Editar");
        btn_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditarActionPerformed(evt);
            }
        });

        btn_Excluir.setText("Excluir");
        btn_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Excluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Novo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Novo)
                .addGap(18, 18, 18)
                .addComponent(btn_Editar)
                .addGap(18, 18, 18)
                .addComponent(btn_Excluir)
                .addGap(27, 27, 27))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Nome");

        jLabel2.setText("Cargo");

        jLabel3.setText("Empresa");

        jLabel4.setText("Telefone");

        jLabel5.setText("E-mail");

        jLabel6.setText("Assunto");

        jLabel7.setText("Tipo de Empresa");

        btn_Cancelar.setText("Cancelar");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });

        btn_Salvar.setText("Salvar");
        btn_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Campo_Empresa)
                    .addComponent(Campo_Cargo)
                    .addComponent(Campo_TipoDeEmpresa)
                    .addComponent(Campo_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Campo_Assunto, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(Campo_Telefone)
                            .addComponent(Campo_Email)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(btn_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Cancelar)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(Campo_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Campo_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Campo_Cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Campo_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(Campo_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Campo_Assunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Campo_TipoDeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Cancelar)
                    .addComponent(btn_Salvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tabela_Fornecedores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Tabela_Fornecedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Cargo", "Empresa", "Tipo de Empresa", "Telefone", "E-mail", "Assunto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabela_Fornecedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabela_FornecedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabela_Fornecedores);
        if (Tabela_Fornecedores.getColumnModel().getColumnCount() > 0) {
            Tabela_Fornecedores.getColumnModel().getColumn(0).setPreferredWidth(100);
            Tabela_Fornecedores.getColumnModel().getColumn(1).setPreferredWidth(100);
            Tabela_Fornecedores.getColumnModel().getColumn(2).setPreferredWidth(100);
            Tabela_Fornecedores.getColumnModel().getColumn(3).setPreferredWidth(100);
            Tabela_Fornecedores.getColumnModel().getColumn(4).setPreferredWidth(100);
            Tabela_Fornecedores.getColumnModel().getColumn(5).setPreferredWidth(100);
            Tabela_Fornecedores.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NovoActionPerformed
        Campo_Nome.setText("");
        Campo_Cargo.setText("");
        Campo_Empresa.setText("");
        Campo_TipoDeEmpresa.setText("");
        Campo_Telefone.setText("");
        Campo_Email.setText("");
        Campo_Assunto.setText("");

        modo = "Novo";
        ManipulacaoInterface();
    }//GEN-LAST:event_btn_NovoActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        Campo_Nome.setText("");
        Campo_Cargo.setText("");
        Campo_Empresa.setText("");
        Campo_TipoDeEmpresa.setText("");
        Campo_Telefone.setText("");
        Campo_Email.setText("");
        Campo_Assunto.setText("");

        modo = "Navegar";
        ManipulacaoInterface();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalvarActionPerformed
        if (modo.equals("Novo")) {

            Fornecedores F = new Fornecedores(Campo_Nome.getText(), Campo_Cargo.getText(), Campo_Empresa.getText(),
                    Campo_TipoDeEmpresa.getText(), Campo_Telefone.getText(), Campo_Email.getText(), Campo_Assunto.getText());
            ListaFornecedores.add(F);
        } else if (modo.equals("Editar")) {
            int index = Tabela_Fornecedores.getSelectedRow();
            ListaFornecedores.get(index).setNome(Campo_Nome.getText());
            ListaFornecedores.get(index).setCargo(Campo_Cargo.getText());
            ListaFornecedores.get(index).setEmpresa(Campo_Empresa.getText());
            ListaFornecedores.get(index).setTipoDeEmpresa(Campo_TipoDeEmpresa.getText());
            ListaFornecedores.get(index).setTelefone(Campo_Telefone.getText());
            ListaFornecedores.get(index).setEmail(Campo_Email.getText());
            ListaFornecedores.get(index).setAssunto(Campo_Assunto.getText());
        }

        LoadTableFornecedores();
        modo = "Navegar";
        ManipulacaoInterface();
        Campo_Nome.setText("");
        Campo_Cargo.setText("");
        Campo_Empresa.setText("");
        Campo_TipoDeEmpresa.setText("");
        Campo_Telefone.setText("");
        Campo_Email.setText("");
        Campo_Assunto.setText("");

    }//GEN-LAST:event_btn_SalvarActionPerformed

    private void btn_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarActionPerformed
        modo = "Editar";
        ManipulacaoInterface();
    }//GEN-LAST:event_btn_EditarActionPerformed

    private void btn_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExcluirActionPerformed
        int index = Tabela_Fornecedores.getSelectedRow();
        if (index >= 0 && index < ListaFornecedores.size()) {
            ListaFornecedores.remove(index);

        }
        LoadTableFornecedores();

        modo = "Navegar";
        ManipulacaoInterface();
    }//GEN-LAST:event_btn_ExcluirActionPerformed

    private void Tabela_FornecedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabela_FornecedoresMouseClicked
        int index = Tabela_Fornecedores.getSelectedRow();

        if (index >= 0 && index < ListaFornecedores.size()) {
            Fornecedores F = ListaFornecedores.get(index);

            Campo_Nome.setText(String.valueOf(F.getNome()));
            Campo_Cargo.setText(String.valueOf(F.getCargo()));
            Campo_Empresa.setText(String.valueOf(F.getEmpresa()));
            Campo_TipoDeEmpresa.setText(String.valueOf(F.getTipoDeEmpresa()));
            Campo_Telefone.setText(String.valueOf(F.getTelefone()));
            Campo_Email.setText(String.valueOf(F.getEmail()));
            Campo_Assunto.setText(String.valueOf(F.getAssunto()));

            modo = "Selecao";
            ManipulacaoInterface();

        }
    }//GEN-LAST:event_Tabela_FornecedoresMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Campo_Assunto;
    private javax.swing.JTextField Campo_Cargo;
    private javax.swing.JTextField Campo_Email;
    private javax.swing.JTextField Campo_Empresa;
    private javax.swing.JTextField Campo_Nome;
    private javax.swing.JTextField Campo_Telefone;
    private javax.swing.JTextField Campo_TipoDeEmpresa;
    private javax.swing.JTable Tabela_Fornecedores;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Editar;
    private javax.swing.JButton btn_Excluir;
    private javax.swing.JButton btn_Novo;
    private javax.swing.JButton btn_Salvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
