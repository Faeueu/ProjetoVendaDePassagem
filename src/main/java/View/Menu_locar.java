/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import DAO.DAOfactory;
import Model.Interface.InterfaceAssentoDAO;
import Model.Interface.InterfacePassagemDAO;
import Model.Interface.InterfaceViagemDAO;
import Model.entities.Cliente;
import Model.entities.Viagem;
import Model.services.GerarPassagemService;
import Model.services.LocarPassagemService;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Faeu
 */
public class Menu_locar extends javax.swing.JFrame {

    Integer numeroAssento;
    Integer idViagem;
    Cliente clienteLogado = new Cliente();
    /**
     * Creates new form Menu_Inicial
     */
    public Menu_locar() {
        initComponents();
    }
    public Menu_locar(Cliente cliente) {
        initComponents();
        clienteLogado = cliente;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator5 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jT_Destino = new javax.swing.JTextField();
        jT_HorarioSaida = new javax.swing.JTextField();
        jT_HorarioChegada = new javax.swing.JTextField();
        jButton_BuscarPassagem = new javax.swing.JButton();
        jT_Origem = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel_VoltarLogin = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jComboBox_Assentos = new javax.swing.JComboBox<>();
        jButton_LocarPassgem = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        jT_Destino.setBackground(new java.awt.Color(204, 204, 204));
        jT_Destino.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jT_Destino.setBorder(null);
        jT_Destino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_DestinoActionPerformed(evt);
            }
        });

        jT_HorarioSaida.setBackground(new java.awt.Color(204, 204, 204));
        jT_HorarioSaida.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jT_HorarioSaida.setBorder(null);
        jT_HorarioSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_HorarioSaidaActionPerformed(evt);
            }
        });

        jT_HorarioChegada.setBackground(new java.awt.Color(204, 204, 204));
        jT_HorarioChegada.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jT_HorarioChegada.setBorder(null);
        jT_HorarioChegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_HorarioChegadaActionPerformed(evt);
            }
        });

        jButton_BuscarPassagem.setBackground(new java.awt.Color(102, 102, 102));
        jButton_BuscarPassagem.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jButton_BuscarPassagem.setForeground(new java.awt.Color(255, 255, 255));
        jButton_BuscarPassagem.setText("Buscar");
        jButton_BuscarPassagem.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 0, 51), new java.awt.Color(255, 0, 0)));
        jButton_BuscarPassagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscarPassagemActionPerformed(evt);
            }
        });

        jT_Origem.setBackground(new java.awt.Color(204, 204, 204));
        jT_Origem.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jT_Origem.setBorder(null);
        jT_Origem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_OrigemActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel1.setText("Destino:");

        jLabel_VoltarLogin.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel_VoltarLogin.setForeground(new java.awt.Color(0, 51, 255));
        jLabel_VoltarLogin.setText("Voltar");
        jLabel_VoltarLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_VoltarLoginMouseClicked(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel3.setText("Horario de Chegada:");

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel4.setText("Horario de Saída:");

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel5.setText("Origem:");

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 38)); // NOI18N
        jLabel8.setText("Dados da Viagem");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jT_HorarioSaida, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                    .addComponent(jT_HorarioChegada)
                    .addComponent(jT_Origem)
                    .addComponent(jT_Destino)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton_BuscarPassagem, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jLabel_VoltarLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel8)
                .addGap(97, 97, 97)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jT_Origem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jT_HorarioSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jT_Destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jT_HorarioChegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_BuscarPassagem, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_VoltarLogin))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(new javax.swing.border.MatteBorder(null));

        jComboBox_Assentos.setBackground(new java.awt.Color(102, 102, 102));
        jComboBox_Assentos.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jComboBox_Assentos.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox_Assentos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Assentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT Condensed", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jComboBox_Assentos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_AssentosItemStateChanged(evt);
            }
        });
        jComboBox_Assentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_AssentosActionPerformed(evt);
            }
        });

        jButton_LocarPassgem.setBackground(new java.awt.Color(102, 102, 102));
        jButton_LocarPassgem.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jButton_LocarPassgem.setForeground(new java.awt.Color(255, 255, 255));
        jButton_LocarPassgem.setText("Locar");
        jButton_LocarPassgem.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 0, 0), new java.awt.Color(255, 0, 0)));
        jButton_LocarPassgem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton_LocarPassgemActionPerformed(evt);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        jLabel6.setText("Selecione seu assento !");

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        jLabel7.setText("Clique no botão abaixo para fazer a reserva");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_LocarPassgem, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jComboBox_Assentos, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel6)
                .addGap(51, 51, 51)
                .addComponent(jComboBox_Assentos, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jButton_LocarPassgem, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_LocarPassgemActionPerformed(java.awt.event.ActionEvent evt) throws FileNotFoundException {//GEN-FIRST:event_jButton_LocarPassgemActionPerformed

        LocarPassagemService locar = new LocarPassagemService();
        locar.locarPassagem(idViagem,numeroAssento,clienteLogado.getId_cliente());
        JOptionPane.showMessageDialog(null, "Passagem reservada com suscesso!");
        dispose();
        Tela_Intermediaria inter = new Tela_Intermediaria(clienteLogado);
        inter.setVisible(true);
    }//GEN-LAST:event_jButton_LocarPassgemActionPerformed

    private void jComboBox_AssentosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_AssentosItemStateChanged

        numeroAssento = (Integer) evt.getItem();


    }//GEN-LAST:event_jComboBox_AssentosItemStateChanged

    private void jComboBox_AssentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_AssentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_AssentosActionPerformed

    private void jLabel_VoltarLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_VoltarLoginMouseClicked

        dispose();
        Tela_Intermediaria inter = new Tela_Intermediaria(clienteLogado);
        inter.setVisible(true);

    }//GEN-LAST:event_jLabel_VoltarLoginMouseClicked

    private void jT_OrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_OrigemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_OrigemActionPerformed

    private void jButton_BuscarPassagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BuscarPassagemActionPerformed
        InterfaceViagemDAO IVD = DAOfactory.criarViagemDAO();
        String origem = jT_Origem.getText();
        String horaSaida = jT_HorarioSaida.getText();
        String destino = jT_Destino.getText();
        String horaChegada = jT_HorarioChegada.getText();
        Viagem viagem = IVD.buscarViagem(origem, horaSaida, destino, horaChegada);
        idViagem = viagem.getId_viagem();
        InterfaceAssentoDAO IAD = DAOfactory.criarAssentoDAO();
        ArrayList<Integer> assentos = IAD.buscarAssentos(viagem);
        for (Integer i : assentos) {
            jComboBox_Assentos.addItem(i);
        }
        JOptionPane.showMessageDialog(null, "Selecione seu assento");
    }//GEN-LAST:event_jButton_BuscarPassagemActionPerformed

    private void jT_HorarioChegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_HorarioChegadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_HorarioChegadaActionPerformed

    private void jT_HorarioSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_HorarioSaidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_HorarioSaidaActionPerformed

    private void jT_DestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_DestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_DestinoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_locar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_BuscarPassagem;
    private javax.swing.JButton jButton_LocarPassgem;
    private javax.swing.JComboBox<Integer> jComboBox_Assentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_VoltarLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField jT_Destino;
    private javax.swing.JTextField jT_HorarioChegada;
    private javax.swing.JTextField jT_HorarioSaida;
    private javax.swing.JTextField jT_Origem;
    // End of variables declaration//GEN-END:variables
}
