/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package client_page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import login_page.DataBaseConnector;
import java.util.Random;

/**
 *
 * @author Bolek
 */
public class Client_menu extends javax.swing.JFrame {

    DataBaseConnector client_data_connection = new DataBaseConnector();
    public int client_id;
    int selected_product = 0;
    int selected_deliverer = 0;
    int selected_payment = 0;
    ArrayList<String> workersList= new ArrayList<>();
   
    
    
    // Pobieranie danych z bazy danych mySQL
    public ArrayList<client_product> productList(){
        ArrayList<client_product> productList = new ArrayList<>();
         try{
            Class.forName(client_data_connection.getClassName());
            Connection con = DriverManager.getConnection(client_data_connection.getURL(), client_data_connection.getUser(), client_data_connection.getPassword());
             String query1="SELECT produkt.id, produkt.nazwa, magazyn_produkt.ilosc, produkt.cena, produkt.opis, magazyn_produkt.magazyn_id  FROM produkt Join magazyn_produkt ON produkt.id=magazyn_produkt.produkt_id";
             
             Statement st= con.createStatement();
             ResultSet rs= st.executeQuery(query1);
             client_product product;
             
             while(rs.next()){
                 product= new client_product(rs.getInt("id"), rs.getString("nazwa"), rs.getInt("ilosc"), rs.getFloat("cena"), rs.getString("opis"), rs.getInt("magazyn_id"));
                 productList.add(product);
                }
             } 
         catch(Exception e){
                        System.out.println(e.getMessage()); 
          }
         return productList;
    }
    
    // Wyświetlanie w tabeli
    public void show_product(){
    ArrayList<client_product> list = productList();
    DefaultTableModel model= (DefaultTableModel)clientTable.getModel();
    model.setRowCount(0);
    Object[] row= new Object[6];
  
    for(int i=0; i<list.size(); i++){
        row[0]= list.get(i).getId();
        row[1]= list.get(i).getnazwa();
        row[2]= list.get(i).getilosc();
        row[3]= list.get(i).getcena();
        row[4]= list.get(i).getopis();
        row[5]= list.get(i).getWarehouse_id();
        model.addRow(row);
        }
    list.clear();
    }
    
    public ArrayList<client_deliverer> delivererList(){
        ArrayList<client_deliverer> delivererList = new ArrayList<>();
         try{
             Class.forName(client_data_connection.getClassName());
             Connection con = DriverManager.getConnection(client_data_connection.getURL(), client_data_connection.getUser(), client_data_connection.getPassword());
             String query1="SELECT dostawca.id, dostawca.nazwa FROM dostawca";
             
             Statement st= con.createStatement();
             ResultSet rs= st.executeQuery(query1);
             client_deliverer deliverer;
             
             while(rs.next()){
                 deliverer= new client_deliverer(rs.getInt("id"), rs.getString("nazwa"));
                 delivererList.add(deliverer);
                }
             } 
         catch(Exception e){
                        System.out.println(e.getMessage()); 
          }
         return delivererList;
    }
    
    // Wyświetlanie w tabeli
    public void show_deliverer(){
    ArrayList<client_deliverer> list = delivererList();
    DefaultTableModel model= (DefaultTableModel)delivererTable.getModel();
    Object[] row= new Object[2];
    for(int i=0; i<list.size(); i++){
        row[0]= list.get(i).getId();
        row[1]= list.get(i).getName();
        model.addRow(row);
        }
    }
    
    public ArrayList<client_payment> paymentList(){
        ArrayList<client_payment> paymentList = new ArrayList<>();
         try{
             Class.forName(client_data_connection.getClassName());
             Connection con = DriverManager.getConnection(client_data_connection.getURL(), client_data_connection.getUser(), client_data_connection.getPassword());
             String query1="SELECT platnosc.id, platnosc.nazwa, platnosc.prowizja FROM platnosc";
             
             Statement st= con.createStatement();
             ResultSet rs= st.executeQuery(query1);
             client_payment payment;
             
             while(rs.next()){
                 payment= new client_payment(rs.getInt("id"), rs.getString("nazwa"), rs.getFloat("prowizja"));
                 paymentList.add(payment);
                }
             } 
         catch(Exception e){
                        System.out.println(e.getMessage()); 
          }
         return paymentList;
    }
    
    // Wyświetlanie w tabeli
    public void show_payment(){
    ArrayList<client_payment> list = paymentList();
    DefaultTableModel model= (DefaultTableModel)paymentTable.getModel();
    Object[] row= new Object[2];
    for(int i=0; i<list.size(); i++){
        row[0]= list.get(i).getId();
        row[1]= list.get(i).getName();
        model.addRow(row);
        }
    }

    public void show_id(){
         userIdEdt.setText(String.valueOf(client_id));
    }
    
    public void getWorkersID(){
        try{
            Class.forName(client_data_connection.getClassName());
            Connection con = DriverManager.getConnection(client_data_connection.getURL(), client_data_connection.getUser(), client_data_connection.getPassword());
             String query1="SELECT pracownik.id FROM pracownik";
             
             Statement st= con.createStatement();
             ResultSet rs= st.executeQuery(query1);
             String line;
             
             while(rs.next()){
                 line= rs.getString("id");
                 workersList.add(line);
                }
             } 
         catch(Exception e){
                        System.out.println(e.getMessage()); 
          }
    }
    
    public int setWorkerID(){
        Random number = new Random();
        int id, index;
        int size = workersList.size();
        //System.out.println(size);
        index = number.nextInt(size - 1);
        id = Integer.valueOf(workersList.get(index));
        return id;
    }
    
    /**
     * Creates new form Client_menu
     */
    public Client_menu() {
        initComponents();
        show_product();
        show_deliverer();
        show_payment();
        getWorkersID();
        numberEdt.setText(String.valueOf(0));
        //System.out.println(client_id);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        clientTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        idProduktuEdt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        numberEdt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        adresEdt = new javax.swing.JTextField();
        buyBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        delivererTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        paymentTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        userIdEdt = new javax.swing.JTextField();
        incNumBtn = new javax.swing.JButton();
        decNumbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        clientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nazwa", "Dostępna ilość", "Cena", "Opis produktu", "Magazyn_id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        clientTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(clientTable);
        if (clientTable.getColumnModel().getColumnCount() > 0) {
            clientTable.getColumnModel().getColumn(0).setMinWidth(5);
            clientTable.getColumnModel().getColumn(0).setPreferredWidth(28);
            clientTable.getColumnModel().getColumn(0).setMaxWidth(30);
            clientTable.getColumnModel().getColumn(1).setMinWidth(40);
            clientTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            clientTable.getColumnModel().getColumn(1).setMaxWidth(150);
            clientTable.getColumnModel().getColumn(2).setMinWidth(5);
            clientTable.getColumnModel().getColumn(2).setPreferredWidth(80);
            clientTable.getColumnModel().getColumn(2).setMaxWidth(120);
            clientTable.getColumnModel().getColumn(3).setMinWidth(40);
            clientTable.getColumnModel().getColumn(3).setPreferredWidth(50);
            clientTable.getColumnModel().getColumn(3).setMaxWidth(100);
            clientTable.getColumnModel().getColumn(4).setPreferredWidth(150);
            clientTable.getColumnModel().getColumn(5).setMinWidth(0);
            clientTable.getColumnModel().getColumn(5).setPreferredWidth(1);
            clientTable.getColumnModel().getColumn(5).setMaxWidth(2);
        }

        jLabel1.setText("Zalogowano jako klient");

        idProduktuEdt.setEditable(false);
        idProduktuEdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idProduktuEdtActionPerformed(evt);
            }
        });

        jLabel2.setText("Id produktu");

        jLabel3.setText("Ilość");

        numberEdt.setEditable(false);
        numberEdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberEdtActionPerformed(evt);
            }
        });

        jLabel4.setText("Adres (Polska , Byczyna , ul. Kaczorowski 25795)");

        jLabel5.setText("Dostawca (domyślnie 1.)");

        jLabel6.setText("Płatność (domyślnie 1.)");

        buyBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buyBtn.setText("Kup");
        buyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyBtnActionPerformed(evt);
            }
        });

        delivererTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Wybierz dostawcę:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        delivererTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delivererTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(delivererTable);
        if (delivererTable.getColumnModel().getColumnCount() > 0) {
            delivererTable.getColumnModel().getColumn(0).setMinWidth(0);
            delivererTable.getColumnModel().getColumn(0).setPreferredWidth(1);
            delivererTable.getColumnModel().getColumn(0).setMaxWidth(2);
            delivererTable.getColumnModel().getColumn(1).setResizable(false);
        }

        paymentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Wybierz płatność:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        paymentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paymentTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(paymentTable);
        if (paymentTable.getColumnModel().getColumnCount() > 0) {
            paymentTable.getColumnModel().getColumn(0).setMinWidth(0);
            paymentTable.getColumnModel().getColumn(0).setPreferredWidth(1);
            paymentTable.getColumnModel().getColumn(0).setMaxWidth(2);
            paymentTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Zatwierdź zamówienie:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("ID klienta: ");

        userIdEdt.setEditable(false);

        incNumBtn.setText("+");
        incNumBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incNumBtnActionPerformed(evt);
            }
        });

        decNumbtn.setText("-");
        decNumbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decNumbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(idProduktuEdt)
                                .addComponent(adresEdt))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(numberEdt, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(decNumbtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(incNumBtn)))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(userIdEdt, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(buyBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(34, 34, 34)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel6)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idProduktuEdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numberEdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(incNumBtn)
                            .addComponent(decNumbtn))
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(adresEdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(buyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(userIdEdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyBtnActionPerformed
        // TODO add your handling code here:
        if(idProduktuEdt.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Nie wybrałeś/aś produktu!");
                return;
            }
        if(Integer.valueOf(numberEdt.getText())==0){
                JOptionPane.showMessageDialog(null, "Ilosć równa 0!");
                return;
            }
        if(adresEdt.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Puste pole adres!");
                return;
            }
         try{
                        
            int dialogResult = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz kupić ten produkt?", "Uwaga", JOptionPane.YES_NO_OPTION);
            
            if(dialogResult == JOptionPane.YES_OPTION)
            {
                        Class.forName(client_data_connection.getClassName());
                        Connection con = DriverManager.getConnection(client_data_connection.getURL(), client_data_connection.getUser(), client_data_connection.getPassword());

                        String insert1 = "INSERT INTO zamowienie (klient_id , dostawca_id , magazyn_id , platnosc_id , pracownik_id , adres_dostawy ,status) VALUES (?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement pst = con.prepareStatement(insert1);
                        pst.setInt(1, client_id);
                        pst.setInt(2, (int)delivererTable.getValueAt(selected_deliverer, 0));
                        pst.setInt(3, (int)clientTable.getValueAt(selected_product, 5));
                        pst.setInt(4, (int)paymentTable.getValueAt(selected_payment, 0));
                        pst.setInt(5, setWorkerID());
                        pst.setString(6, adresEdt.getText());
                        pst.setString(7, "Nowy");
                        pst.executeUpdate();
                        
                        String insert2 = "INSERT INTO zamowienie_produkt (produkt_id, zamowienie_id, ilosc ) VALUES (?, ( SELECT LAST_INSERT_ID ()), ?)";
                        PreparedStatement pst2 = con.prepareStatement(insert2);
                        pst2.setInt(1, (int)clientTable.getValueAt(selected_product, 0));
                        pst2.setInt(2, Integer.valueOf(numberEdt.getText()));
                        pst2.executeUpdate();
                        
                        // Obliczanie pozostałej ilości produktu w magazynie
                        int leftNumber = (int)clientTable.getValueAt(selected_product, 2) - Integer.valueOf(numberEdt.getText());
                        
                        String insert3 = "UPDATE magazyn_produkt SET ilosc=? WHERE magazyn_id=? AND produkt_id=?";
                        PreparedStatement pst3 = con.prepareStatement(insert3);
                        pst3.setInt(1, leftNumber);
                        pst3.setInt(2, (int)clientTable.getValueAt(selected_product, 5));
                        pst3.setInt(3, (int)clientTable.getValueAt(selected_product, 0));
                        pst3.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Przedmiot kupiony!");
                        show_product();
            }
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage()); 
                        JOptionPane.showMessageDialog(null, "Błąd!");
                    }
        
        
    }//GEN-LAST:event_buyBtnActionPerformed

    private void idProduktuEdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idProduktuEdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idProduktuEdtActionPerformed

    private void clientTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientTableMouseClicked
        // TODO add your handling code here:
        selected_product = clientTable.getSelectedRow();
        idProduktuEdt.setText(clientTable.getValueAt(selected_product, 0).toString());
        
        int tmp;
        int available = (int) clientTable.getValueAt(selected_product, 2);
        tmp = Integer.valueOf(numberEdt.getText());
        if(tmp >= available)
            tmp = available;
        numberEdt.setText(String.valueOf(tmp));
    }//GEN-LAST:event_clientTableMouseClicked

    private void delivererTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delivererTableMouseClicked
        // TODO add your handling code here:
        selected_deliverer = delivererTable.getSelectedRow();
        System.out.println("Wybrany dostawca: " + selected_deliverer);
    }//GEN-LAST:event_delivererTableMouseClicked

    private void paymentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentTableMouseClicked
        // TODO add your handling code here:
        selected_payment = paymentTable.getSelectedRow();
        System.out.println("Wybrana płatność: " + selected_payment);
    }//GEN-LAST:event_paymentTableMouseClicked

    private void incNumBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incNumBtnActionPerformed
        // TODO add your handling code here:
        int tmp;
        int available = (int) clientTable.getValueAt(selected_product, 2);
        tmp = Integer.valueOf(numberEdt.getText());
        if(tmp >= available)
            tmp = available;
        else
            tmp++;
        numberEdt.setText(String.valueOf(tmp));
    }//GEN-LAST:event_incNumBtnActionPerformed

    private void numberEdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberEdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberEdtActionPerformed

    private void decNumbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decNumbtnActionPerformed
        // TODO add your handling code here:
        int tmp;
        tmp = Integer.valueOf(numberEdt.getText());
        if(tmp <= 0)
            tmp = 0;
        else
            tmp--;
        numberEdt.setText(String.valueOf(tmp));
    }//GEN-LAST:event_decNumbtnActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Client_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client_menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adresEdt;
    private javax.swing.JButton buyBtn;
    private javax.swing.JTable clientTable;
    private javax.swing.JButton decNumbtn;
    private javax.swing.JTable delivererTable;
    private javax.swing.JTextField idProduktuEdt;
    private javax.swing.JButton incNumBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField numberEdt;
    private javax.swing.JTable paymentTable;
    private javax.swing.JTextField userIdEdt;
    // End of variables declaration//GEN-END:variables
}
