
 //�פJ�ݭn���U���M��
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;


 //��ƺ޲z�h���O
 //CDM_dbma: Class DatabaseManagement_database manipulation and acess (��Ʈw�ާ@�P�s�����O)

 class pos_database{                    

     Connection connection;
     Statement statement;
    
     //�غc�l:���OCdbma
     public pos_database(){
        
     }
    
     //-------------�إ߸�Ʈw�϶�-------------------------------

     //�إ߸�Ʈwposdb������ƪ�:�w�s
     public void createTB_state(){

            try{
                 connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb"+"?user=root&password=mysql");
                 statement = connection.createStatement();

                 String createTB  = "CREATE TABLE stock_tea("+
                                    "name  VARCHAR(15), "+    //�W��
                                    "quantity INT ," +        //�ƶq
                                    "primary key(name))";             
                 
                 String createTB2 = "CREATE TABLE stock_sugar("+
                                    "name  VARCHAR(15), "+    //�W��
                                    "quantity INT ," +        //�ƶq  
                                    "primary key(name))";             
                 
                 String createTB3 = "CREATE TABLE stock_others("+
                                    "name  VARCHAR(15), "+    //�W��
                                    "quantity INT ," +        //�ƶq
                                    "primary key(name))";             
                 
                 statement.executeUpdate(createTB);
                 statement.executeUpdate(createTB2);
                 statement.executeUpdate(createTB3);
                 //JOptionPane.showMessageDialog(null,"���~��ƪ�إߦ��\!");
                 pos_item_diliver.insert_item_info1();       //�w���إ߮w�s��ƪ����e
                 pos_item_diliver.insert_item_info2();
                 pos_item_diliver.insert_item_info3();                 
                 statement.close();
       
            } catch(SQLException e){
                 if(statement != null){ 
                	  //JOptionPane.showMessageDialog(null,"���~��ƪ�w�s�b,�i���`�ϥ�!"); 
                 }  
                 else{
                	 JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
                 }  
           } catch(Exception e){
              JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
           }  
            pos_administer_system.cth_du(); 
     } 
     
   //�إ߸�Ʈwposdb������ƪ�:�P����
     public void createTB_profit(){

            try{
                 connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb"+"?user=root&password=mysql");
                 statement = connection.createStatement();

                 String createTB  = "CREATE TABLE revenue_detail ("+
                                    "date   VARCHAR(15), "+    //���
                		            "name VARCHAR(15) , " +   //�W��
                                    "quantity  INT ," +    //�ƶq
                                    "income   INT )" ;   //���J
                                    
                 
                 statement.executeUpdate(createTB);
                 //JOptionPane.showMessageDialog(null,"�禬��ƪ�إߦ��\!");
                 statement.close();
       
            } catch(SQLException e){
                 if(statement != null) {
                	 //JOptionPane.showMessageDialog(null,"�禬��ƪ�w�s�b,�i���`�ϥ�!"); 
                 }
                       
                 else{
                	 JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
                 }                       
           } catch(Exception e){
              JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
           }  
     } // end for: createTB_profit()

     //��k:�إ߸�Ʈwproject_posdb
     public void createDB(){

         //�w��MySQL�X�ʵ{��, �P�إ߸�Ʈwproject_posdb
         try{
              Class.forName("com.mysql.jdbc.Driver");
         } catch(Exception e){
              JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
         }

         //�إ� project_posdb��Ʈw
         try{
              connection = DriverManager.getConnection("jdbc:mysql://localhost/"+
                                                       "?user=root&password=mysql");
              statement = connection.createStatement();
              String createDB = "CREATE DATABASE project_posdb";
              statement.executeUpdate(createDB);
              //JOptionPane.showMessageDialog(null,"��x��Ʈw�إߦ��\!");
              statement.close();
              
         } catch(SQLException e){
              if(statement != null) {
            	  //JOptionPane.showMessageDialog(null,"��x��Ʈw�w�s�b,�i���`�ϥ�!");
              }                  
              else{
            	  JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
              }
                  
         } catch(Exception e){
              JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
         }
       
     } //end for: public void createDB()
     
   

     
 } //end for: class CDM_dbma
