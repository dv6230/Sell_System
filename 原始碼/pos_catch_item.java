
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;

public class pos_catch_item {
	
	pos_catch_item(){
		
	}
	
	//開啟檔案時，從資料庫抓取庫存
    public void catch_item1(){

            Connection connection;
            PreparedStatement statement;
            ResultSet result;
            String cmdData;          
            
            int[] mre = new int[10];    //接收資料庫數值的陣列
            int i = 0 ;
            
            //資料庫前置作業
            try{
                  Class.forName("com.mysql.jdbc.Driver");
            } catch(Exception e){
                  JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
            }

            try{
                   cmdData = "select quantity from stock_tea ";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
                   statement = connection.prepareStatement(cmdData);                   
                   //statement.setString(1,ait);
                   result = statement.executeQuery();
                   while( result.next() ){
                         mre[i] = result.getInt("quantity");
                         i++;
                    }
                    statement.close();
                    i = 0;
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"存取庫存資料表時發生錯誤! stock_tea");
             }             
             pos_administer_system.cth_pr( mre , "a");            
    }
    
    public void catch_item2(){

        Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;          
        
        int[] mre = new int[10];    //接收資料庫數值的陣列
        int i = 0 ;
        
        //資料庫前置作業
        try{
              Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
              JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
        }

        try{
               cmdData = "select quantity from stock_sugar ";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
               statement = connection.prepareStatement(cmdData);
               result = statement.executeQuery();
               while( result.next() ){
                     mre[i] = result.getInt("quantity");
                     i++;
                }
                statement.close();
                i = 0;
                
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"存取庫存資料表時發生錯誤! stock_sugar");
         }             
         pos_administer_system.cth_pr( mre , "b" );            
    }
    
    public void catch_item3(){

        Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;          
        
        int[] mre = new int[10];    //接收資料庫數值的陣列
        int i = 0 ;
        
        //資料庫前置作業
        try{
              Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
              JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
        }

        try{
               cmdData = "select quantity from stock_others ";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
               statement = connection.prepareStatement(cmdData);
               result = statement.executeQuery();
               while( result.next() ){
                     mre[i] = result.getInt("quantity");
                     i++;
                }
                statement.close();
                i = 0;
                
         } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"存取庫存資料表時發生錯誤! stock_others");
         }             
         pos_administer_system.cth_pr( mre , "c" );            
         }

}
