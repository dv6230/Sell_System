
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
        
        //��Ʈw�e�m�@�~
        
        try{
              Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
              JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
        }

        //�bproject_posdb��Ʈw��, �M��stock_tea���e���
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
               JOptionPane.showMessageDialog(null,"��Ʀs������   Error: serach");
        } 
        if (num + b >= 0 ){
        	try{    //�bproject_posdb��Ʈw��, ���stock_tea���e���
            cmdData = "update stock_tea set quantity = ? where name  = ? " ;

            connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
            statement = connection.prepareStatement(cmdData);
            statement.setInt(1, num +b);
            statement.setString(2,a);
            statement.executeUpdate();
            statement.close();
            pos_administer_system.itempr1[c].setText("" + (num+b) );  //�ݭץ�
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"��Ʀs������    Error: update ");
        } 
        }
        else{
        	JOptionPane.showMessageDialog(null,
      	    		 "�Ѿl�ƶq���i���t��","��J���~",JOptionPane.INFORMATION_MESSAGE);
        }
        	
       } // end: item1
	
	
	
	public void insert_into_item2(String a,int b,int c){

        Connection connection;
        PreparedStatement statement;
        String cmdData;
        ResultSet result;
        
        int num = 0 ;            
        
        //��Ʈw�e�m�@�~
        
        try{
              Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
              JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
        }

        //�bproject_posdb��Ʈw��, �s�W�@�����J��ƨ��ƪ�:stock_tea
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
               JOptionPane.showMessageDialog(null,"��Ʀs������/n Error: serach");
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
            pos_administer_system.itempr2[c].setText("" + (num+b) );  //�ݭץ�
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"��Ʀs������    Error: update " + b +"/"+ a);
        } 
        }
        else {
        	JOptionPane.showMessageDialog(null,
      	    		 "�Ѿl�ƶq���i���t��","��J���~",JOptionPane.INFORMATION_MESSAGE);
        }
        
        		
       } // end: item1
	
	public void insert_into_item3(String a,int b,int c){

        Connection connection;
        PreparedStatement statement;
        String cmdData;
        ResultSet result;
        int num = 0 ;            
        
        //��Ʈw�e�m�@�~
        
        try{
              Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception e){
              JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
        }

        //�bproject_posdb��Ʈw��, �s�W�@�����J��ƨ��ƪ�:stock_tea
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
               JOptionPane.showMessageDialog(null,"��Ʀs������/n Error: serach");
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
                 pos_administer_system.itempr3[c].setText("" + (num+b) );  //�ݭץ�
            } catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"��Ʀs������    Error: update " + b +"/"+ a);
            } 
        }
        else{
        	JOptionPane.showMessageDialog(null,
   	    		 "�Ѿl�ƶq���i���t��","��J���~",JOptionPane.INFORMATION_MESSAGE);
        }

        		
       } // end: item1
	
	//-----------------------�w���إߤ��e��--------------------------------------------
	static public void insert_item_info1(){

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
               cmdData = "INSERT INTO  stock_tea(name,quantity)"+
                         "VALUES('����(�U)',0) ,('���(�U)',0),"
                         + "('�@��(�U)',0),('�ٯ�(�U)',0),('�Q�s(�U)',0),('���|(�U)',0)";

               connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
               statement = connection.prepareStatement(cmdData);
               statement.executeUpdate();
               //JOptionPane.showMessageDialog(null,"�bproject_posdb��Ʈw��, ���\�g�J��ƪ�!");
               statement.close();

        } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"�bproject_posdb��Ʈw��, �g�J��stock_tea��ƪ��o�Ϳ��~!");
        }
       } // end: item1
	static public void insert_item_info2(){

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
               cmdData = "INSERT INTO  stock_sugar(name,quantity)"+
                         "VALUES('�G�}(��)',0) ,('�¿}(�])',0),"
                         + "('�J�}(�])',0),('�ٯ�(�U)',0),('���e(��)',0)";

               connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
               statement = connection.prepareStatement(cmdData);
               statement.executeUpdate();
               //JOptionPane.showMessageDialog(null,"�bproject_posdb��Ʈw��, ���\�g�J��ƪ�!");
               statement.close();

        } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"�bproject_posdb��Ʈw��, �g�J��stock_sugar��ƪ��o�Ϳ��~!");
        }
       } // end: item1
	
	static public void insert_item_info3(){

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
               cmdData = "INSERT INTO  stock_others(name,quantity)"+
                         "VALUES('����(�])',0) ,('����(�])',0),('�ï](��)',0),"
                         + "('�@�Y�f�c(��)',0),('�P��(�])',0),('��G(�])',0),('�۶�(�])',0)";
    

               connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
               statement = connection.prepareStatement(cmdData);
               statement.executeUpdate();
               //JOptionPane.showMessageDialog(null,"�bproject_posdb��Ʈw��, ���\�g�J��ƪ�!");
               statement.close();

        } catch(SQLException e){
               JOptionPane.showMessageDialog(null,"�bproject_posdb��Ʈw��, �g�J��stock_other��ƪ��o�Ϳ��~!");
        }
       } // end: item1
	//-------------------------------------------------------------------------
}
