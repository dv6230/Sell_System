 //匯入需要的各類套件
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;

public class pos_revenue_diliver {
	
	Connection connection;
    Statement statement;
	
	pos_revenue_diliver(){
		
	}	
	
    public void insert_into_revenue(String a,int b,int c){

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
               cmdData = "INSERT INTO revenue_detail(date,name,quantity,income)"+
                         "VALUES(?,?,?,?)";

               connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
               statement = connection.prepareStatement(cmdData);
               statement.setString(1,pos_mode_system.date_conbine());
               statement.setString(2,a);
               statement.setInt(3,b);
               statement.setInt(4,c);
               statement.executeUpdate();
               //JOptionPane.showMessageDialog(null,"在project_posdb資料庫中, 成功寫入一筆[營收]到revenue_detail資料表中!");
               statement.close();

        } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"在project_posdb資料庫中, 寫入一筆[營收]到revenue_detail資料表中發生錯誤!");
        }
       } // end: insert_into_revenue()
	//----------傳值去購買紀錄-----------------------
}
