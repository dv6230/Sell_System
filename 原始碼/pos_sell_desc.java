

 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.sql.*;

public class pos_sell_desc {
	
	pos_sell_desc(){
		
	}
	
	//�ƶq�Ƨ�  (�Z�P�Ʀ�)
    public static void catch_sell(){

            Connection connection;
            PreparedStatement statement;
            ResultSet result;
            String cmdData;          
            
            int[] mr_num = new int[10];        //�����ƶq
            String[] mr_txt = new String[10];   //�����W��
            int i = 0 ;
            
            //��Ʈw�e�m�@�~
            try{
                  Class.forName("com.mysql.jdbc.Driver");
            } catch(Exception e){
                  JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
            }             
            try{
                   cmdData = "SELECT name, quantity FROM revenue_detail order by quantity desc limit 10";
                   connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
                   statement = connection.prepareStatement(cmdData);                   
                   result = statement.executeQuery();
                   while( result.next() ){                         
                         mr_txt[i] = result.getString("name");   //�W��
                         mr_num[i] = result.getInt("quantity");  //�ƶq
                         i++;
                    }
                    statement.close();
                    i = 0;
                    
             } catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"�s���w�s��ƪ�ɵo�Ϳ��~!");
             }
            
            for (int j=0 ; j<mr_txt.length ; j++){
            	if ( mr_txt[j] != null){
            		pos_administer_system.ctbarit[j].setText("" + mr_txt[j]);   
            	    pos_administer_system.ctbarnu[j].setText("" + mr_num[j]);
            	}            	
            }            
    }
  
}
