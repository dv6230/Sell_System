
//�פJ�ݭn���U���M��
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import java.sql.*;

//pos_database_conver ���\�ର��Ʈw�P�{�������~�I

class pos_database_conver1 {                    

    private String name ;   //�W��    
    private int quantity ;   //�ƶq
    private int income ;
    private String date;
    int lng = 0;
    
    //�غc�l:���O pos_database_conver
    public pos_database_conver1 (){    	
        name = "";
        quantity = 0;
        income = 0 ;
        date = "";
    }
    
    //�]�w���
    public void setdate(String t){
    	date = t ;    	
    }
    
    //�]�w��������J
    public void setcash(int c){
    	income = c ;
    }
    
    //�]�w��������ƦW��
    public void setdrink(String c){
    	name = c ;
    }
    
    //�]�w��������Ƽƶq
    public void setdrink_n(int c){
    	quantity = c;
    }
    
    //��k:���o�W��
    public String getdrink(){
        return name;
    }
    
    //��k:���o�W��
    public int getdrink_n(){
        return quantity;
    }
    
    //��k:���o�W��
    public String getdate(){
        return( date );
    }

    //��k:���o�ƶq
    public int getcash(){
        return( income );
    }

} //end 

