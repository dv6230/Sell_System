

 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;

public class pos_sell_desc {
	
	pos_sell_desc(){
		
	}
	
	//數量排序  (暢銷排行)
    public static void catch_sell(){

            Connection connection;
            PreparedStatement statement;
            ResultSet result;
            String cmdData;          
            
            int[] mr_num = new int[10];        //接收數量
            String[] mr_txt = new String[10];   //接收名稱
            int i = 0 ;
            
            //資料庫前置作業
            try{
                  Class.forName("com.mysql.jdbc.Driver");
            } catch(Exception e){
                  JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
            }             
            try{
                   cmdData = "SELECT name, quantity FROM revenue_detail order by quantity desc limit 10";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
                   statement = connection.prepareStatement(cmdData);                   
                   result = statement.executeQuery();
                   while( result.next() ){                         
                         mr_txt[i] = result.getString("name");   //名稱
                         mr_num[i] = result.getInt("quantity");  //數量
                         i++;
                    }
                    statement.close();
                    i = 0;
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"存取庫存資料表時發生錯誤!");
             }
            
            for (int j=0 ; j<mr_txt.length ; j++){
            	if ( mr_txt[j] != null){
            		pos_administer_system.ctbarit[j].setText("" + mr_txt[j]);   
            	    pos_administer_system.ctbarnu[j].setText("" + mr_num[j]);
            	}            	
            }            
    }
  
}
