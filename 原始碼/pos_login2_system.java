import javax.swing.*;

import javafx.embed.swing.JFXPanel;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.*;


class pos_login2_system{

    //----------------------------------
    //宣告並建立CLogin()類別的所有物件

    JFrame f2 = new JFrame(); 
    
    JPanel b = new JPanel();
    JPanel c = new JPanel();
    
    ImageIcon icon2 = new ImageIcon("user2.png");
    JLabel pic = new JLabel(icon2); 
    
    ImageIcon icon1 = new ImageIcon("leftside.png");	
	JButton backbtn = new JButton("返回",icon1);
    
    JSeparator bline1 = new JSeparator();
    JSeparator bline2 = new JSeparator();
    
    JLabel titleLabel = new JLabel("後台管理");
    JLabel acntLabel = new JLabel("帳號");
    JLabel pwdLabel = new JLabel("密碼");

    JButton clearBtn = new JButton("清空"); 
    JButton enterBtn = new JButton("提交"); 

    JTextField acntTxtFd = new JTextField("");
    JPasswordField pwdTxtFd = new JPasswordField("");

    Font font1 = new Font("標楷體",Font.BOLD,24);
    Font font2 = new Font("微軟正黑體",Font.BOLD,19);  
    
    ImageIcon icon_k = new ImageIcon("key.png");
    JLabel pic2 = new JLabel(icon_k);
    ImageIcon icon_s = new ImageIcon("shield.png");
    JLabel pic3 = new JLabel(icon_s);

    
    //以下為CLogin()類別的建構子

    pos_login2_system(){
    	  
	      b.setBounds(325,100,550,600);
	      b.setBackground(new Color(0,60,104));
	      b.setLayout(null);
	      c.add(b);
	      
	      c.setBounds(0,0,1200,850);
    	  c.setBackground(new Color(0,60,104));
    	  c.setLayout(null);
    	  f2.add(c);
    	  
    	  pic.setBounds(200,10,150,150);
    	  b.add(pic);
          
              titleLabel.setBounds(200,185,250,60);
              titleLabel.setFont(new Font("微軟正黑體",Font.BOLD,36));
              titleLabel.setForeground(new Color(255,255,255));
              b.add(titleLabel);

              acntLabel.setBounds(125,280,60,40);   //帳號區
              acntLabel.setFont(font2);
              acntLabel.setForeground(new Color(160,160,160));
              b.add(acntLabel);
              acntTxtFd.setBounds(125,310,300,40);  
              acntTxtFd.setFont(font2);
              acntTxtFd.setForeground(new Color(255,255,255));
              acntTxtFd.setBackground(new Color(0,60,104));
              acntTxtFd.setBorder(null);
              acntTxtFd.addMouseListener(new java.awt.event.MouseAdapter(){
          		public void mouseClicked(java.awt.event.MouseEvent evt){
          			mstxt1(evt);
          		}
          	  });
              b.add(acntTxtFd);            
              bline1.setBounds(125,350,300,40); 
              bline1.setBackground(new Color(160,160,160));
              b.add(bline1);
              pic3.setBounds(70,307,50,50);
              b.add(pic3);
              pic3.setVisible(false);

              pwdLabel.setBounds(125,360,60,40);   //密碼區
              pwdLabel.setFont(font2);
              pwdLabel.setForeground(new Color(160,160,160));
              b.add(pwdLabel);
              pwdTxtFd.setBounds(125,390,300,40); 
              pwdTxtFd.setFont(font2);
              pwdTxtFd.setEchoChar('*');
              pwdTxtFd.setForeground(new Color(255,255,255));
              pwdTxtFd.setBackground(new Color(0,60,104));
              pwdTxtFd.setBorder(null);
              pwdTxtFd.addMouseListener(new java.awt.event.MouseAdapter(){
          		public void mouseClicked(java.awt.event.MouseEvent evt){
          			mstxt1(evt);
          		}
          	  });
              b.add(pwdTxtFd);
              bline2.setBounds(125,430,300,40); 
              bline2.setBackground(new Color(160,160,160));
              b.add(bline2);
              pic2.setBounds(70,383,50,50);
              b.add(pic2);
              pic2.setVisible(false);
              
        	  backbtn.setBounds(30,30,100,45);
              backbtn.setBackground(new Color(0,60,104));   // 0,87,151
              backbtn.setForeground(new Color(255,255,255));
              backbtn.setFont(new Font("微軟正黑體",Font.PLAIN,28));
              backbtn.setBorder(null);
              backbtn.addMouseListener(new java.awt.event.MouseAdapter(){
          		public void mouseEntered(java.awt.event.MouseEvent evt){
          			mse1(evt);
          		}
          	  });
              backbtn.addMouseListener(new java.awt.event.MouseAdapter(){
          		public void mouseExited(java.awt.event.MouseEvent evt){
          			mso1(evt);
          		}
          	  });
              c.add(backbtn);

              clearBtn.setBounds(155,480,100,40);
              clearBtn.addActionListener(ProcessClearBtn);
              clearBtn.setFont(new Font("微軟正黑體",Font.BOLD,22));
              clearBtn.setForeground(new Color(255,255,255));
              clearBtn.setBackground(new Color(0,60,104));
              clearBtn.setBorder(null);
              b.add(clearBtn);              
              
              enterBtn.setBounds(295,480,100,40);
              enterBtn.setFont(new Font("微軟正黑體",Font.BOLD,22));
              enterBtn.setForeground(new Color(255,255,255));
              enterBtn.setBackground(new Color(0,191,255));
              enterBtn.setBorder(null);
              enterBtn.addMouseListener(new java.awt.event.MouseAdapter(){
          		public void mouseEntered(java.awt.event.MouseEvent evt){
          			mse1(evt);
          		}
          	  });
              enterBtn.addMouseListener(new java.awt.event.MouseAdapter(){
          		public void mouseExited(java.awt.event.MouseEvent evt){
          			mso1(evt);
          		}
          	  });
              b.add(enterBtn);
              


    		f2.setTitle("登錄介面");      
    		f2.setLayout(null);
    		f2.setLocation(350,120);          
    		f2.setSize(1200,850);          
    		f2.setVisible(false);    		   //預設關閉
    		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 
         }  //CLogin()類別的建構子結束

    //--------------------------------
    //事件傾聽程式: 處理[清空]按鈕

    public ActionListener ProcessClearBtn = new ActionListener(){
       public void actionPerformed(ActionEvent e){
    
            if( e.getSource() ==  clearBtn ){  
 
                  clearAcntPwd();    //呼叫方法clearAcntPwd去執行清空帳號密碼欄位

            }    

    }
   };
   
   private void mstxt1(java.awt.event.MouseEvent evt) { 
	   	if (evt.getSource() == acntTxtFd ){
	   		pic2.setVisible(false);
	   		pic3.setVisible(true);
            acntLabel.setForeground(new Color(255,255,255));
            bline1.setBackground(new Color(255,255,255));
	   		pwdLabel.setForeground(new Color(160,160,160));
            bline2.setBackground(new Color(160,160,160));            
	   	}
	   	if (evt.getSource() == pwdTxtFd ){
	   		pic2.setVisible(true);
	   		pic3.setVisible(false);
	   		pwdLabel.setForeground(new Color(255,255,255));
            bline2.setBackground(new Color(255,255,255));
            acntLabel.setForeground(new Color(160,160,160));
            bline1.setBackground(new Color(160,160,160));
	   	}
  };
  
  void re_clean(){
	  pic2.setVisible(false);
 	  pic3.setVisible(false);
 	  pwdLabel.setForeground(new Color(160,160,160));
      bline2.setBackground(new Color(160,160,160));
      acntLabel.setForeground(new Color(160,160,160));
      bline1.setBackground(new Color(160,160,160));
  }

   private void mse1(java.awt.event.MouseEvent evt) { 

   	if (evt.getSource() == backbtn ){
   		backbtn.setBackground(new Color(0,87,151));
   	}
   	
   };
   private void mso1(java.awt.event.MouseEvent evt) { 

   	if (evt.getSource() == backbtn ){
   		backbtn.setBackground(new Color(0,60,104));
   	}
   };
   
   //--------------------------------
   //方法clearAcntPwd: 清空帳號密碼欄位

   void clearAcntPwd(){    
           acntTxtFd.setText("");
           pwdTxtFd.setText("");  
           re_clean();           
   }
}
