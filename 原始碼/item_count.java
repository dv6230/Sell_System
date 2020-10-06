import javax.swing.JSeparator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


// �w�s�[�����
class item_count {
	
	static JDialog face = new JDialog();
	JPanel b = new JPanel();	
	JButton increase = new JButton("�W�[");
	JButton decrease = new JButton("���");
	JButton enter = new JButton("�T�{");
	JTextField num = new JTextField();          //�s�W��֪��ƶq
	JLabel pa = new JLabel();
	JButton[][] digitBtn = new JButton[4][3];
    String[][] digitBtnString = {{"7","8","9"},{"4","5","6"},{"1","2","3"},{"","0","C"}};
    JSeparator line_a = new JSeparator();
    JLabel ext = new JLabel("X");
	
	boolean jug  = true ;	   //�P�_ �W�[ �� ��� ���s
	int amount = 0 ;
	static int cate ;    //�Ӥ��� 
	static int grp ;     //�D����
	
    item_count(){   
    	 
    	ext.setBounds(520,0,30,30);
    	ext.setOpaque(true);
    	ext.setBackground(Color.red);
    	ext.setFont(new Font("�L�n������",Font.PLAIN,20));
    	ext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    	ext.setForeground(Color.white);
    	ext.addMouseListener(new java.awt.event.MouseAdapter(){
    		public void mouseClicked(java.awt.event.MouseEvent evt){
    			msext(evt);
    		}
    	});    	
    	b.add(ext);
    	
    	b.setLayout(null);
    	b.setBounds(0,0,550,300);
    	b.setBackground(new Color(76,76,76));    
    	b.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
    	b.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mousePressed(java.awt.event.MouseEvent evt) {
                 headerMousePressed(evt);
             }
         });
    	face.add(b);
    	
    	pa.setBounds(80,120,90,50);
    	pa.setFont(new Font("�L�n������",Font.PLAIN,26));
    	pa.setForeground(Color.WHITE);
    	pa.setText("�W�[  "+"+");
    	b.add(pa);    	 	
    	
    	increase.setBounds(30,10,120,50);    //�W�[���s
    	increase.setFont(new Font("�L�n������",Font.BOLD,22));
    	increase.addActionListener(change);
    	//increase.setBorder(BorderFactory.createLineBorder(new Color(255,255,255),1));
    	increase.setBorder(null);
    	increase.setBackground(new Color(252,111,151));
    	increase.setForeground(Color.WHITE);
    	b.add(increase);
    	
    	decrease.setBounds(170,10,120,50);   //��֫��s
    	decrease.setFont(new Font("�L�n������",Font.BOLD,22));
    	decrease.addActionListener(change);
    	//decrease.setBorder(BorderFactory.createLineBorder(new Color(255,255,255),1));
    	decrease.setBorder(null);
    	decrease.setBackground(new Color(0,229,156));
    	decrease.setForeground(Color.WHITE);
    	b.add(decrease);
    	
    	enter.setBounds(100,230,120,50);
    	enter.setFont(new Font("�L�n������",Font.PLAIN,22));
    	enter.addActionListener(tran);
    	enter.setBackground(new Color(255,194,61));
    	enter.setForeground(new Color(1,1,1));
    	enter.setBorder(null);
    	b.add(enter);
    	
    	num.setBounds(163,127,90,40);
    	num.setEditable(false);
    	num.setBackground(null);
    	num.setBorder(null);
    	num.setForeground(Color.white);
    	num.setFont(new Font("�L�n������",Font.PLAIN,26));
    	num.setHorizontalAlignment(SwingConstants.RIGHT);    	
    	num.setText(""+amount);
    	b.add(num);
    	
    	line_a.setBounds(80,170,175,50);
    	line_a.setForeground(new Color(252,111,151));
    	line_a.setBackground(new Color(252,111,151));
    	line_a.setBorder(null);
    	b.add(line_a);
    	
		for (int i = 0; i < digitBtn.length; i++) {
			for (int j = 0; j < digitBtn[0].length; j++) {
				digitBtn[i][j] = new JButton(digitBtnString[i][j]);
				digitBtn[i][j].setBounds(320+(j*60),45+(i*55),55,50);
				digitBtn[i][j].setFont(new Font("�L�n������", Font.BOLD, 20));				
				digitBtn[i][j].setBackground(new Color(114,114,114));
				digitBtn[i][j].setForeground(Color.white);
				digitBtn[i][j].addActionListener(digbtnprcess);
				b.add(digitBtn[i][j]);
			}
		} 
		
    	face.setTitle("��ƺ޲z");	
    	face.setLayout(null);
    	face.setLocation(650,300);
    	face.setSize(550,300);	  
    	face.setVisible(false);
    	face.setUndecorated(true); 
    	//face.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);  
    	
    	
     }     
    
    private void msext(java.awt.event.MouseEvent evt)  //��������
    {
    	amount = 0 ;
		 num.setText(""+amount);
		 t = 0;		 
    	face.setVisible(false);
    }
    
    int xx;
    int xy;
    private void headerMousePressed(java.awt.event.MouseEvent evt)  //�������� ��k 1
    {
        xx = evt.getX();
        xy = evt.getY();
    }
    
    private void headerMouseDragged(java.awt.event.MouseEvent evt)  //�������� ��k2
    {        
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        face.setLocation(x-xx,y-xy);
    }
    
     byte t = 0;   //�P�_�ثe�Ʀr������
     public ActionListener digbtnprcess = new ActionListener(){
    	 public void actionPerformed(ActionEvent e){
    		 for (int i=0;i<digitBtn.length;i++){
    			 for (int j=0; j<digitBtn[0].length;j++){
    				 if (e.getSource()==digitBtn[i][j]){
    					 if (e.getSource() != digitBtn[3][0] && e.getSource() != digitBtn[3][2] ){
    						 if (t < 5){
    						 int vc = Integer.parseInt(digitBtnString[i][j]);  //�����ثe�ҫ��U���Ʀr
    					     amount = (amount*10) +  vc ;
    					     num.setText(""+amount);
    					     t++;
    						 }
    					 } 
    					 if (e.getSource() == digitBtn[3][2]){
    						 amount = 0 ;
    						 num.setText(""+amount);
    						 t = 0;
    					 }
    				 }
    			 }
    		 }
    		  
    	 }
     };
    
     public ActionListener change = new ActionListener(){  //�ܦ� �P �[��P�_
    	 public void actionPerformed(ActionEvent e){
    		 if (e.getSource()==increase){
    			 pa.setText("�W�[  "+"+");   
    			 line_a.setBackground(new Color(252,111,151));
    			 line_a.setForeground(new Color(252,111,151));
    			 jug = true;
    		 }
    		 if (e.getSource()==decrease){
    			 pa.setText("���  "+"-");
    			 line_a.setBackground(new Color(0,229,156));
    			 line_a.setForeground(new Color(0,229,156));
    			 jug = false;
    		 }
    	 }
     };
     
     public ActionListener tran = new ActionListener(){
    	 public void actionPerformed(ActionEvent e){
    		 if (e.getSource()==enter){
    			 if (jug == true){    //��ϥΪ̫��U�W�[���s
    				 t = 0;
    				 switch (grp){
    				     case 1 :
    				    	 pos_administer_system.s1(cate,amount);   //�Ĥ@�Ӷ� "�s��"  �ĤG�Ӷ�"�ƶq"
    	    				 face.setVisible(false);    				 
    	    			     amount = 0;
    	    			     num.setText(""+amount);    	    			     
    	    			     break;
    				     case 2 :
    				    	 pos_administer_system.s2(cate,amount);   //�Ĥ@�Ӷ� "�s��"  �ĤG�Ӷ�"�ƶq"
    	    				 face.setVisible(false);    				 
    	    			     amount = 0;
    	    			     num.setText(""+amount);	
    	    			     break;
    				     case 3 :
    				    	 pos_administer_system.s3(cate,amount);   //�Ĥ@�Ӷ� "�s��"  �ĤG�Ӷ�"�ƶq"
    	    				 face.setVisible(false);    				 
    	    			     amount = 0;
    	    			     num.setText(""+amount);
    	    			     break;
    				 }
    			 }
    			 if (jug == false){    				//��ϥΪ̫��U��֫��s 
    				 switch(grp){
    				     case 1 :    				    	 
    				    		 pos_administer_system.s1(cate,(amount*-1));
    				    	     face.setVisible(false);
    				     	     amount = 0;
    				    	     num.setText(""+amount);
    				    	     t = 0;
    				    	     break;    				    	     				    	 
    				     case 2 :
    				    		 pos_administer_system.s2(cate,(amount*-1));
    				    	     face.setVisible(false);
    				     	     amount = 0;
    				    	     num.setText(""+amount);
    				    	     t = 0;
    				    	     break;    				    	   				    	 
    				     case 3 :
    				    		 pos_administer_system.s3(cate,(amount*-1));
    				    	     face.setVisible(false);
    				     	     amount = 0;
    				    	     num.setText(""+amount);
    				    	     t = 0;
    				    	     break;		    	 
    				 }
    			 }
    		 }    		 
    	 }
     };
     
     static void cal(int i , int p){  
    	 cate = i ; 
    	 grp = p ;
    	 item_count.face.setVisible(true);    	    
     }
     
}