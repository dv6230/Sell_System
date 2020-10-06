import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javafx.application.*;
import javafx.embed.swing.JFXPanel;
import javafx.scene.*;
import javafx.scene.control.Button;

class pos_login_system{

    //----------------------------------
    //�ŧi�ëإ�CLogin()���O���Ҧ�����

    JFrame f = new JFrame(); 
    
    JPanel b = new JPanel();
    JPanel c = new JPanel();
    
    JSeparator bline1 = new JSeparator();
    JSeparator bline2 = new JSeparator();
    
    JLabel titleLabel = new JLabel("�I�\��T�t��");
    JLabel acntLabel = new JLabel("�b��");
    JLabel pwdLabel = new JLabel("�K�X");

    JButton clearBtn = new JButton("�M��"); 
    JButton enterBtn = new JButton("����");    

    JTextField acntTxtFd = new JTextField("");
    JPasswordField pwdTxtFd = new JPasswordField("");

    Font font1 = new Font("�з���",Font.BOLD,24);
    Font font2 = new Font("�L�n������",Font.BOLD,19);
    
    ImageIcon icon1 = new ImageIcon("lock3.png");   //��ϧΪ���
    JLabel picLabel = new JLabel(icon1);           //�ϧμ���

    int state = 0;    //�n�����A�A�e�x�ϥΪ�=0, ��x�޲z��=1 
    
	int widframe , heiframe ;
	int wid , hei;
    
    //�H�U��CLogin()���O���غc�l

    pos_login_system(){
    	
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();	
		widframe = screen.width;
        heiframe = screen.height;
        wid = (int)(widframe * 0.28);
        hei = (int)(heiframe * 0.55);        
        
	      b.setBounds(0,0,(int)(widframe*0.28),(int)(heiframe*0.55));
	      b.setBackground(new Color(50,50,50));
	      b.setLayout(null);
	      f.add(b);
    	
              titleLabel.setBounds((int)(wid*0.15),(int)(hei*0.345),
            		  (int)(wid*0.7),(int)(hei*0.1));
              titleLabel.setFont(new Font("�L�n������",Font.BOLD,(int)(hei*0.06)));
              titleLabel.setForeground(new Color(255,255,255));
              titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
              b.add(titleLabel);

              acntLabel.setBounds((int)(wid*0.115),(int)(hei*0.4),
            		  (int)(wid*0.25),(int)(hei*0.2));   //�b����
              acntLabel.setFont(new Font("�L�n������",Font.BOLD,19));
              acntLabel.setForeground(new Color(140,140,140));
              acntLabel.setHorizontalAlignment(SwingConstants.CENTER);
              b.add(acntLabel);
              acntTxtFd.setBounds((int)(wid*0.21),(int)(hei*0.525),
            		  (int)(wid*0.55),(int)(hei*0.06));  
              acntTxtFd.setFont(font2);
              acntTxtFd.setForeground(new Color(255,255,255));
              acntTxtFd.setBackground(new Color(50,50,50));//50,50,50
              acntTxtFd.addMouseListener(new java.awt.event.MouseAdapter(){
          		public void mouseClicked(java.awt.event.MouseEvent evt){
          			mstxt1(evt);
          		}
          	  });
              acntTxtFd.setBorder(null);
              b.add(acntTxtFd);            
              bline1.setBounds((int)(wid*0.21),(int)(hei*0.59),
            		  (int)(wid*0.55),(int)(hei*0.01));
              bline1.setForeground(new Color(129,129,129));
              bline1.setBackground(new Color(129,129,129));
              b.add(bline1);

              pwdLabel.setBounds((int)(wid*0.115),(int)(hei*0.55),
            		  (int)(wid*0.25),(int)(hei*0.2));   //�K�X��
              pwdLabel.setFont(font2);
              pwdLabel.setForeground(new Color(129,129,129));
              pwdLabel.setHorizontalAlignment(SwingConstants.CENTER);
              b.add(pwdLabel);
              pwdTxtFd.setBounds((int)(wid*0.21),(int)(hei*0.675),
            		  (int)(wid*0.55),(int)(hei*0.06)); 
              pwdTxtFd.setFont(font2);
              pwdTxtFd.setForeground(new Color(255,255,255));
              pwdTxtFd.setBackground(new Color(50,50,50));  
              pwdTxtFd.setBorder(null);
	          pwdTxtFd.setEchoChar('*');
              pwdTxtFd.addMouseListener(new java.awt.event.MouseAdapter(){
          		public void mouseClicked(java.awt.event.MouseEvent evt){
          			mstxt1(evt);
          		}
          	  });
              b.add(pwdTxtFd);
              bline2.setBounds((int)(wid*0.21),(int)(hei*0.738),
            		  (int)(wid*0.55),(int)(hei*0.01)); 
              bline2.setBackground(new Color(129,129,129));
              bline2.setForeground(new Color(129,129,129));
              b.add(bline2);

              clearBtn.setBounds((int)(wid*0.2625),(int)(hei*0.81),
            		  (int)(wid*0.175),(int)(hei*0.07));
              clearBtn.addActionListener(ProcessClearBtn);
              clearBtn.setFont(new Font("�L�n������",Font.BOLD,22));
              clearBtn.setForeground(new Color(255,255,255));
              clearBtn.setBackground(new Color(50,50,50));
              clearBtn.setBorder(null);
              b.add(clearBtn);
              
              enterBtn.setBounds((int)(wid*0.5),(int)(hei*0.81),
            		  (int)(wid*0.175),(int)(hei*0.07));
              enterBtn.setFont(new Font("�L�n������",Font.BOLD,22));
              enterBtn.setForeground(new Color(255,255,255));
              enterBtn.setBackground(new Color(50,50,50));
              enterBtn.setBorder(BorderFactory.createLineBorder(new Color(255,255,0),1));
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
              
    	      picLabel.setBounds((int)(wid*0.25),(int)(hei*-0.05),
            		  (int)(wid*0.5),(int)(hei*0.5));
    	      b.add(picLabel);

    		f.setTitle("�n������");      
    		f.setLayout(null);             
    		f.setLocation((int)(widframe*0.35),(int)(heiframe*0.2));          
    		f.setSize((int)(widframe*0.28),(int)(heiframe*0.57));    //550,600        
    		f.setVisible(true);    		
    		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 
         }  //CLogin()���O���غc�l����

    //--------------------------------
    //�ƥ��ť�{��: �B�z[�M��]���s

    public ActionListener ProcessClearBtn = new ActionListener(){
       public void actionPerformed(ActionEvent e){
    
            if( e.getSource() ==  clearBtn ){  
 
                  clearAcntPwd();    //�I�s��kclearAcntPwd�h����M�űb���K�X���

            }    

    }
   };

   private void mse1(java.awt.event.MouseEvent evt) { 
   	if (evt.getSource() == enterBtn ){
	       enterBtn.setBackground(new Color(255,255,0));
	       enterBtn.setForeground(new Color(50,50,50));
   	}
   	
   };   
   private void mso1(java.awt.event.MouseEvent evt) { 
   	if (evt.getSource() == enterBtn ){
	       enterBtn.setBackground(new Color(50,50,50)); 
	       enterBtn.setForeground(new Color(255,255,255));
   	}
   };
   
   private void mstxt1(java.awt.event.MouseEvent evt) { 
	   	if (evt.getSource() == acntTxtFd ){
	   		bline1.setForeground(new Color(255,255,0));
	   		acntLabel.setForeground(new Color(255,255,0));

	   		pwdLabel.setForeground(new Color(129,129,129));
	   		bline2.setForeground(new Color(129,129,129));
	   	}
	   	if (evt.getSource() == pwdTxtFd ){
	   		bline2.setForeground(new Color(255,255,0));
	   		pwdLabel.setForeground(new Color(255,255,0));

	   		bline1.setForeground(new Color(129,129,129));
	   		acntLabel.setForeground(new Color(129,129,129));
	   	}
   };
   
   void inter_clean(){
  		bline1.setForeground(new Color(129,129,129));
  		acntLabel.setForeground(new Color(129,129,129));
   		pwdLabel.setForeground(new Color(129,129,129));
   		bline2.setForeground(new Color(129,129,129));
   }
   
   //--------------------------------
   //��kclearAcntPwd: �M�űb���K�X���

   void clearAcntPwd(){
    
           acntTxtFd.setText("");
           pwdTxtFd.setText("");  
           inter_clean();
  
   }	
}  //pos_login_system ����