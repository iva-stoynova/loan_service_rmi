/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Server.java
 *
 * Created on 2010-2-27, 14:56:33
 */

package m22763project4;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Date;

/**
 *
 * @author Iwa Stojnowa
 */
public class Server extends javax.swing.JFrame {

    // server on port 1099
    private static final int PORT = 1099;

    public Server()
    {

        super("Loan RMI Server");
        initComponents();

        try
        {
            LocateRegistry.createRegistry(PORT);
            this.jServerDisplay.append("Loading Loan Server...\n");
            LoanService server = new LoanServiceImpl(jServerDisplay);
            LocateRegistry.getRegistry().rebind("LoanService", server);
            Date now = new Date();
            this.jServerDisplay.append("Loan Server loaded at " + now.toString() + "\n");
        }
        catch (RemoteException ex)
        {
            jServerDisplay.append("Loading load server failed: " + ex.getMessage() + "\n");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        jServerDisplay = new javax.swing.JTextArea();
        jLabelTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOAN SERVER");
        setBackground(new java.awt.Color(0, 102, 102));
        setName("jFrame"); // NOI18N

        jServerDisplay.setColumns(20);
        jServerDisplay.setRows(5);
        jScrollPane.setViewportView(jServerDisplay);

        jLabelTitle.setText("LOAN RMI SERVER");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Server().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTextArea jServerDisplay;
    // End of variables declaration//GEN-END:variables
}
