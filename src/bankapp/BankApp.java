/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Dnz
 */
public class BankApp {
    Kur curr = new Kur(Curr.US_DOLLAR);
    Kur curr1 = new Kur(Curr.EURO);
    // JList e veritabanındaki kullanıcıları listelettik.
    public void listele(JList list,String query)throws SQLException{
       String usrname = "root";
       String pass = "11223344";
       Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/kur?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",usrname,pass);
       DefaultListModel model = new DefaultListModel();
       Statement statement = con.createStatement();
       ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) //go through each row that your query returns
    {
        String k_ad = resultSet.getString("k_ad");
        model.addElement(k_ad);
    }
    list.setModel(model);
    resultSet.close();
    statement.close();
    }
    // jlistten seçilen kullanıcının tüm bilgilerini aşağıdaki ekranda göstermesini sağlayan methodu yazdım.
    public void tum_bilgiler(JList jl,JLabel j1,JLabel j2,JLabel j3,JLabel j4) throws SQLException{
       String usrname = "root";
       String pass = "11223344";
       Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/kur?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",usrname,pass);
       Statement statement = con.createStatement();
       Statement statement1 = con.createStatement();
       String a=String.valueOf(jl.getSelectedValue());
       String query =("SELECT k_id from uyeler where k_ad like '%"+a+"%'");
       ResultSet resultSet = statement.executeQuery(query);
      while(resultSet.next()){
          String b = resultSet.getString("k_id");
          String q= "SELECT h_bakiye,h_bakiye_dolar,h_bakiye_euro from hesaplar INNER JOIN uyeler ON uyeler.k_id =  hesaplar.h_sahip AND k_id like '%"+b+"%'";
          ResultSet resultSet1 = statement1.executeQuery(q);
          while(resultSet1.next()){
              // result setten textleri çektik 
              j2.setText(resultSet1.getString("h_bakiye") + "TL");
              j3.setText(resultSet1.getString("h_bakiye_dolar")+"$");
              j4.setText(resultSet1.getString("h_bakiye_euro")+ "€");
          }
        j1.setText(a);
        j1.setVisible(true);
        j2.setVisible(true);
        j3.setVisible(true);
        j4.setVisible(true);
          }
    }
    // hesaba para yollama metodu
    public void ParaEkle(JList j1,JTextField jt) throws SQLException{
       String usrname = "root";
       String pass = "11223344";
       Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/kur?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",usrname,pass);
       Statement statement = con.createStatement();
       String q ="UPDATE hesaplar SET h_bakiye = h_bakiye+"+jt.getText()+" WHERE h_id = "+j1.getSelectedIndex()+"";
       statement.executeUpdate(q);
       jt.setText(null);
       JOptionPane.showMessageDialog(null, "Para başarıyla yollandı", "Denobank", JOptionPane.INFORMATION_MESSAGE);
    }
    // xml verilerini CurrFrame de jTable a yazdırdık.
    public void listCurr(JTable jt){
     DefaultTableModel model = new DefaultTableModel(new String[] { "Kur", "Alış", "Satış"},0);
     jt.setModel(model);
     model.addRow(new Object[]{ curr1.getCurrency().getName(),curr1.getCurrency().getBuyingPrice(), curr1.getCurrency().getSellingPrice()});
     model.addRow(new Object[]{ curr.getCurrency().getName(),curr.getCurrency().getBuyingPrice(), curr.getCurrency().getSellingPrice()}); 
 }
    }
    

