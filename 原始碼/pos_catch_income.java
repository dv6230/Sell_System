
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import javax.swing.border.*;
 import java.util.*;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.sql.*;

public class pos_catch_income {
	
     pos_catch_income(){    	 
    	 
     }
     
   //從資料庫抓取營收  (本日營收)
     public void catch_sell(String a){

             Connection connection;
             PreparedStatement statement;
             ResultSet result;
             String cmdData;          
             
             int day_earn = 0;        //接收營收
             
             //資料庫前置作業
             try{
                   Class.forName("com.mysql.jdbc.Driver");
             } catch(Exception e){
                   JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
             }             
             try{
                    cmdData = "select sum(income) from revenue_detail where date = ? ";
                    connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
                    statement = connection.prepareStatement(cmdData);
                    statement.setString(1,a);
                    result = statement.executeQuery();
                    while( result.next() ){
                          day_earn = result.getInt("sum(income)");                          
                     }
                     statement.close();
                     
              } catch(SQLException e){
                     JOptionPane.showMessageDialog(null,"存取銷售資料時發生錯誤!");
              }
             pos_administer_system.amount_td.setText("" + day_earn);
     }
     
     //從資料庫抓取營收  (月營收日營收) => sql語法用 string a 接收
     public void catch_sell_m(String a){
             Connection connection;
             PreparedStatement statement;
             ResultSet result;
             String cmdData;
             int month_earn = 0;        //接收營收             
             //資料庫前置作業
             try{
                   Class.forName("com.mysql.jdbc.Driver");
             } catch(Exception e){
                   JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
             }             
             try{
                    cmdData = a ;
                    connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
                    statement = connection.prepareStatement(cmdData);                    
                    result = statement.executeQuery();
                    while( result.next() ){
                          month_earn = result.getInt("sum(income)");                          
                     }
                     statement.close();
                     
              } catch(SQLException e){
                     JOptionPane.showMessageDialog(null,"存取銷售資料時發生錯誤!");
              }
             pos_administer_system.amount_tm.setText("" + month_earn);
     }
     
     
     
     //從資料庫抓取營收  (月營收日營收) => sql語法用 string a 接收
     // string a = 接收sql碼  ; string b = 執行方式種類
     public void catch_perday_income(String a,String b){
             Connection connection;
             PreparedStatement statement;
             ResultSet result;
             String cmdData;
             String[] prday = new String[15];
             int[] dayearn = new int[15];
             int i = 0 ;
             //資料庫前置作業
             try{
                   Class.forName("com.mysql.jdbc.Driver");
             } catch(Exception e){
                   JOptionPane.showMessageDialog(null,"MySQL驅動程式安裝失敗!"); 
             }             
             try{
                    cmdData = a ;
                    connection = DriverManager.getConnection("jdbc:mysql://localhost/project_posdb" + "?user=root&password=mysql");
                    statement = connection.prepareStatement(cmdData);                    
                    result = statement.executeQuery();
                    while( result.next() ){
                    	  prday[i] = result.getString("date");
                          dayearn[i] = result.getInt("sum(income)"); 
                          i++;
                     }
                     statement.close();
                     i = 0 ;
              } catch(SQLException e){
                     JOptionPane.showMessageDialog(null,"存取銷售資料時發生錯誤!");
              }
                          
             if (b=="a"){ //初始數值抓取
            	 for (int z=0;z<prday.length; z++){
            	     if (prday[z] != null ){ 
            	    	  pos_administer_system.shiftSeriesYValue(
            		 	  pos_administer_system.series_1,dayearn[z],true,prday[z]);   
            	    	  ct2 = z ; 
            	     }
                 }
            	 if(prday[ct2] != null){
            		catch_last_time = prday[ct2] ; 
            	 }
             }
             
            
             if (b=="b"){
            	 
            	 for (int z=0;z<prday.length; z++){
            	    if (prday[z] != null ){
            	    	ct = z;
            	    	catch_now_time = prday[ct];
            	    }
                 }
            	 
            	 if( catch_last_time.equals(catch_now_time) ){
            		 JOptionPane.showMessageDialog(null,"ERROR");
            		 pos_administer_system.shiftSeriesYValue(
             		 	      pos_administer_system.series_1,dayearn[ct],true,prday[ct]);
            		 pos_administer_system.shiftSeriesYValue(
                 		 	  pos_administer_system.series_1,dayearn[ct],false,prday[ct]);
            	 }
            	 else {
            		 pos_administer_system.shiftSeriesYValue(
              		 	      pos_administer_system.series_1,dayearn[ct],true,prday[ct]);
            		 catch_last_time = catch_now_time = prday[ct] ;
            	 }
             }
     }   
     
     //參數     
     int ct = 0;   
     int ct2 = 0;
     String catch_last_time = "";
     String catch_now_time = "";     
     
}
