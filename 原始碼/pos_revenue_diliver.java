 //�פJ�ݭn���U���M��
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

        //��Ʈw�e�m�@�~
        try{
              Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
              JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
        }

        //�bproject_posdb��Ʈw��, �s�W�@�����J��ƨ��ƪ�:revenue
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
               //JOptionPane.showMessageDialog(null,"�bproject_posdb��Ʈw��, ���\�g�J�@��[�禬]��revenue_detail��ƪ�!");
               statement.close();

        } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"�bproject_posdb��Ʈw��, �g�J�@��[�禬]��revenue_detail��ƪ��o�Ϳ��~!");
        }
       } // end: insert_into_revenue()
	//----------�ǭȥh�ʶR����-----------------------
}
