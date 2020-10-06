
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;

public class pos_item_diliver {
	
	pos_item_diliver(){		
		
	}
	
	public void insert_into_item1(String a,int b,int c){

        Connection connection;
        PreparedStatement statement;
        String cmdData;
        ResultSet result;
        
        int num = 0 ;            
        
        //資料庫前置作業
        
        try{
              Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
              JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
        }

        //在project_posdb資料庫中, 尋找stock_tea內容資料
        try{  
               cmdData = "select quantity from stock_tea where name = ? ";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
               statement = connection.prepareStatement(cmdData);
               statement.setString(1,a);               
               result = statement.executeQuery();               
               while(result.next()){
            	  num = result.getInt("quantity");
               }               
               
               statement.close();
        } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"資料存取失敗   Error: serach");
        } 
        if (num + b >= 0 ){
        	try{    //在project_posdb資料庫中, 更改stock_tea內容資料
            cmdData = "update stock_tea set quantity = ? where name  = ? " ;

            connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
            statement = connection.prepareStatement(cmdData);
            statement.setInt(1, num +b);
            statement.setString(2,a);
            statement.executeUpdate();
            statement.close();
            pos_administer_system.itempr1[c].setText("" + (num+b) );  //待修正
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"資料存取失敗    Error: update ");
        } 
        }
        else{
        	JOptionPane.showMessageDialog(null,
      	    		 "剩餘數量不可為負值","輸入錯誤",JOptionPane.INFORMATION_MESSAGE);
        }
        	
       } // end: item1
	
	
	
	public void insert_into_item2(String a,int b,int c){

        Connection connection;
        PreparedStatement statement;
        String cmdData;
        ResultSet result;
        
        int num = 0 ;            
        
        //資料庫前置作業
        
        try{
              Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
              JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
        }

        //在project_posdb資料庫中, 新增一筆收入資料到資料表:stock_tea
        try{  
               cmdData = "select quantity from stock_sugar where name = ? ";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
               statement = connection.prepareStatement(cmdData);
               statement.setString(1,a);
               result = statement.executeQuery();               
               while(result.next()){
            	  num = result.getInt("quantity");
               }
               statement.close();
        } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"資料存取失敗/n Error: serach");
        } 
        if ( num + b >= 0){
        	try{  
            cmdData = "update stock_sugar set quantity = ? where name  = ? " ;

            connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
            statement = connection.prepareStatement(cmdData);
            statement.setInt(1, num +b);
            statement.setString(2,a);
            statement.executeUpdate();
            statement.close();
            pos_administer_system.itempr2[c].setText("" + (num+b) );  //待修正
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"資料存取失敗    Error: update " + b +"/"+ a);
        } 
        }
        else {
        	JOptionPane.showMessageDialog(null,
      	    		 "剩餘數量不可為負值","輸入錯誤",JOptionPane.INFORMATION_MESSAGE);
        }
        
        		
       } // end: item1
	
	public void insert_into_item3(String a,int b,int c){

        Connection connection;
        PreparedStatement statement;
        String cmdData;
        ResultSet result;
        int num = 0 ;            
        
        //資料庫前置作業
        
        try{
              Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
              JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
        }

        //在project_posdb資料庫中, 新增一筆收入資料到資料表:stock_tea
        try{  
               cmdData = "select quantity from stock_others where name = ? ";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
               statement = connection.prepareStatement(cmdData);
               statement.setString(1,a);
               result = statement.executeQuery();               
               while(result.next()){
            	  num = result.getInt("quantity");
               }               
               statement.close();
        } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"資料存取失敗/n Error: serach");
        } 
        if ( num + b >= 0){        	
        	try{  
            cmdData = "update stock_others set quantity = ? where name  = ? " ;
                 connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
                 statement = connection.prepareStatement(cmdData);
                 statement.setInt(1, num +b);
                 statement.setString(2,a);
                 statement.executeUpdate();
                 statement.close();            
                 pos_administer_system.itempr3[c].setText("" + (num+b) );  //待修正
            } catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"資料存取失敗    Error: update " + b +"/"+ a);
            } 
        }
        else{
        	JOptionPane.showMessageDialog(null,
   	    		 "剩餘數量不可為負值","輸入錯誤",JOptionPane.INFORMATION_MESSAGE);
        }

        		
       } // end: item1
	
	//-----------------------預先建立內容物--------------------------------------------
	static public void insert_item_info1(){

        Connection connection;
        PreparedStatement statement;
        String cmdData;

        //資料庫前置作業
        try{
              Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
              JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
        }

        //在project_posdb資料庫中, 新增一筆收入資料到資料表:revenue
        try{  
               cmdData = "INSERT INTO  stock_tea(name,quantity)"+
                         "VALUES('紅茶(袋)',0) ,('綠茶(袋)',0),"
                         + "('咖啡(袋)',0),('抹茶(袋)',0),('烏龍(袋)',0),('普洱(袋)',0)";

               connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
               statement = connection.prepareStatement(cmdData);
               statement.executeUpdate();
               //JOptionPane.showMessageDialog(null,"在project_posdb資料庫中, 成功寫入資料表中!");
               statement.close();

        } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"在project_posdb資料庫中, 寫入至stock_tea資料表中發生錯誤!");
        }
       } // end: item1
	static public void insert_item_info2(){

        Connection connection;
        PreparedStatement statement;
        String cmdData;

        //資料庫前置作業
        try{
              Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
              JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
        }

        //在project_posdb資料庫中, 新增一筆收入資料到資料表:revenue
        try{  
               cmdData = "INSERT INTO  stock_sugar(name,quantity)"+
                         "VALUES('果糖(罐)',0) ,('黑糖(包)',0),"
                         + "('焦糖(包)',0),('抹茶(袋)',0),('蜂蜜(罐)',0)";

               connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
               statement = connection.prepareStatement(cmdData);
               statement.executeUpdate();
               //JOptionPane.showMessageDialog(null,"在project_posdb資料庫中, 成功寫入資料表中!");
               statement.close();

        } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"在project_posdb資料庫中, 寫入至stock_sugar資料表中發生錯誤!");
        }
       } // end: item1
	
	static public void insert_item_info3(){

        Connection connection;
        PreparedStatement statement;
        String cmdData;

        //資料庫前置作業
        try{
              Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
              JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
        }

        //在project_posdb資料庫中, 新增一筆收入資料到資料表:revenue
        try{  
               cmdData = "INSERT INTO  stock_others(name,quantity)"+
                         "VALUES('生薑(包)',0) ,('奶精(包)',0),('珍珠(罐)',0),"
                         + "('濃縮檸檬(罐)',0),('仙草(包)',0),('堅果(包)',0),('桂圓(包)',0)";
    

               connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
               statement = connection.prepareStatement(cmdData);
               statement.executeUpdate();
               //JOptionPane.showMessageDialog(null,"在project_posdb資料庫中, 成功寫入資料表中!");
               statement.close();

        } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"在project_posdb資料庫中, 寫入至stock_other資料表中發生錯誤!");
        }
       } // end: item1
	//-------------------------------------------------------------------------
}
