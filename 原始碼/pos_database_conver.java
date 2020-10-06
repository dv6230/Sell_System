
//匯入需要的各類套件
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import java.sql.*;

//pos_database_conver 此功能為資料庫與程式的中繼點

class pos_database_conver1 {                    

    private String name ;   //名稱    
    private int quantity ;   //數量
    private int income ;
    private String date;
    int lng = 0;
    
    //建構子:類別 pos_database_conver
    public pos_database_conver1 (){    	
        name = "";
        quantity = 0;
        income = 0 ;
        date = "";
    }
    
    //設定日期
    public void setdate(String t){
    	date = t ;    	
    }
    
    //設定本交易收入
    public void setcash(int c){
    	income = c ;
    }
    
    //設定本交易飲料名稱
    public void setdrink(String c){
    	name = c ;
    }
    
    //設定本交易飲料數量
    public void setdrink_n(int c){
    	quantity = c;
    }
    
    //方法:取得名稱
    public String getdrink(){
        return name;
    }
    
    //方法:取得名稱
    public int getdrink_n(){
        return quantity;
    }
    
    //方法:取得名稱
    public String getdate(){
        return( date );
    }

    //方法:取得數量
    public int getcash(){
        return( income );
    }

} //end 

