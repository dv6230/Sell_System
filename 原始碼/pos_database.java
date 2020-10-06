
 //匯入需要的各類套件
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;


 //資料管理層類別
 //CDM_dbma: Class DatabaseManagement_database manipulation and acess (資料庫操作與存取類別)

 class pos_database{                    

     Connection connection;
     Statement statement;
    
     //建構子:類別Cdbma
     public pos_database(){
        
     }
    
     //-------------建立資料庫區塊-------------------------------

     //建立資料庫posdb中的資料表:庫存
     public void createTB_state(){

            try{
                 connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb"+"?user=root&password=mysql");
                 statement = connection.createStatement();

                 String createTB  = "CREATE TABLE stock_tea("+
                                    "name  VARCHAR(15), "+    //名稱
                                    "quantity INT ," +        //數量
                                    "primary key(name))";             
                 
                 String createTB2 = "CREATE TABLE stock_sugar("+
                                    "name  VARCHAR(15), "+    //名稱
                                    "quantity INT ," +        //數量  
                                    "primary key(name))";             
                 
                 String createTB3 = "CREATE TABLE stock_others("+
                                    "name  VARCHAR(15), "+    //名稱
                                    "quantity INT ," +        //數量
                                    "primary key(name))";             
                 
                 statement.executeUpdate(createTB);
                 statement.executeUpdate(createTB2);
                 statement.executeUpdate(createTB3);
                 //JOptionPane.showMessageDialog(null,"物品資料表建立成功!");
                 pos_item_diliver.insert_item_info1();       //預先建立庫存資料表的內容
                 pos_item_diliver.insert_item_info2();
                 pos_item_diliver.insert_item_info3();                 
                 statement.close();
       
            } catch(SQLException e){
                 if(statement != null){ 
                	  //JOptionPane.showMessageDialog(null,"物品資料表已存在,可正常使用!"); 
                 }  
                 else{
                	 JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
                 }  
           } catch(Exception e){
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
           }  
            pos_administer_system.cth_du(); 
     } 
     
   //建立資料庫posdb中的資料表:銷售資料
     public void createTB_profit(){

            try{
                 connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb"+"?user=root&password=mysql");
                 statement = connection.createStatement();

                 String createTB  = "CREATE TABLE revenue_detail ("+
                                    "date   VARCHAR(15), "+    //日期
                		            "name VARCHAR(15) , " +   //名稱
                                    "quantity  INT ," +    //數量
                                    "income   INT )" ;   //收入
                                    
                 
                 statement.executeUpdate(createTB);
                 //JOptionPane.showMessageDialog(null,"營收資料表建立成功!");
                 statement.close();
       
            } catch(SQLException e){
                 if(statement != null) {
                	 //JOptionPane.showMessageDialog(null,"營收資料表已存在,可正常使用!"); 
                 }
                       
                 else{
                	 JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
                 }                       
           } catch(Exception e){
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
           }  
     } // end for: createTB_profit()

     //方法:建立資料庫project_posdb
     public void createDB(){

         //安裝MySQL驅動程式, 與建立資料庫project_posdb
         try{
              Class.forName("com.mysql.jdbc.Driver");
         } catch(Exception e){
              JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
         }

         //建立 project_posdb資料庫
         try{
              connection = DriverManager.getConnection("jdbc:mysql://localhost/"+
                                                       "?user=root&password=mysql");
              statement = connection.createStatement();
              String createDB = "CREATE DATABASE project_posdb";
              statement.executeUpdate(createDB);
              //JOptionPane.showMessageDialog(null,"後台資料庫建立成功!");
              statement.close();
              
         } catch(SQLException e){
              if(statement != null) {
            	  //JOptionPane.showMessageDialog(null,"後台資料庫已存在,可正常使用!");
              }                  
              else{
            	  JOptionPane.showMessageDialog(null,"MySQL無法啟動!");
              }
                  
         } catch(Exception e){
              JOptionPane.showMessageDialog(null,"資料庫操作發生其他錯誤!");
         }
       
     } //end for: public void createDB()
     
   

     
 } //end for: class CDM_dbma
