import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class pos_order_system{ 
	
	JFrame face = new JFrame();  //�I�\�t�Ϊ����������R�W �� face
	
    pos_revenue_diliver p_dil = new pos_revenue_diliver();  //�إ߶ǭȥΪ�����
	
	ImageIcon icon2 = new ImageIcon("home.png"); 
	ImageIcon icon3 = new ImageIcon("sigin.png");	
	JButton managebtn = new JButton("�޲z",icon2);
	JButton logoutbtn = new JButton("�n�X",icon3);
	JButton[][] midbtn = new JButton[2][3];
	String midstring[][] = {{"����","�~�a","�~�e"},{"<html>"+"����"+"<br>"+"����"+"</html>","<html>"+"�M��"+"<br>"+"�㭶"+"</html>","�W�@��"}};
	
	JPanel p1 = new JPanel();
	
	JPanel part1 = new JPanel();        //���ư�
    JPanel part2 = new JPanel();
    JPanel part3 = new JPanel();
    JPanel part4 = new JPanel();

	JLabel count = new JLabel("�`�p");
	
	JScrollPane mySpane; //�ŧi�ưʮe��
	JTable myTable; //�ŧi���
	String table_title[] = {"�~�W","�ƶq","����","�B��","���","���\���O","�p�p"};
	String[][] table_data = new String[13][7];   //�s�@   20 ��C*5���� �����    
	
    Font font1 = new Font("�з���" , Font.BOLD, 20);		//�ۭq�r��
    JButton[][] digitBtn = new JButton[4][3];           //�Ʀr���s����}�C(4��Cx3����)
    String[][]  digitBtnString = {{"1","2","3"},{"4","5","6"},{"7","8","9"},{"","0","C"}};   //�Ʀr���s���������s��r
	JPanel numarea = new JPanel();
	
	JButton[] coldhotbtn = new JButton[5];
	String[] coldhotstring = {"���`�B","�֦B","�h�B","��","��"};
	JButton[] sweetbtn = new JButton[5];
	String[] sweetstring = {"���`","�C���}","�����}","�T���}","�L�}"};

	JTextField sumTxtFd = new JTextField("");   //����`���B
    
	JButton paybtn = new JButton("���b"); 
	JButton nextbtn = new JButton("�U�@��");
	
    JTabbedPane tPane = new JTabbedPane();
    String tabTxt1 = "����";      
    String tabTxt2 = "�S�կ�";     
    String tabTxt3 = "�����";      
    String tabTxt4 = "�u�`���w";
    
    JButton[][] tea1 = new JButton[3][5];
	String[][] tea1string = {{"��������","�[������","���ߥ���","�[������",""},
			{"�i�Q����","�V�ʮ��K","�ٯ����K","�������K",""},
			{"���B����","�¿}���K","�ï]����","�J�}���K",""}};
	String[][] tea1pricestring = {{"40","40","45","45",""},
			{"55","45","45","40",""},
			{"45","40","40","45",""}};
	
    JButton[][] tea2 = new JButton[3][5];
	String[][] tea2string = {{"���l���","�f�c�B�A","�V���f�c","�������",""},
			{"�ʭ����","���e���","�f�c����","�A���G��",""},
			{"�h�h���","�H���f�c","�e������","",""}};
	String[][] tea2pricestring = {{"30","30","35","35",""},
			{"30","30","30","30",""},
			{"45","40","45","45",""}};
	
    JButton[][] tea3 = new JButton[3][5];
	String[][] tea3string = {{"�`�H�Q�s","��������","�[�����","",""},
			{"���s�Q�s","��ᴶ�|","","",""},{"�N������","��������","","",""}};
	String[][] tea3pricestring = {{"35","35","35","",""},
			{"40","40","","",""},
			{"35","45","","",""}};
	
    JButton[][] tea4 = new JButton[3][5];
	String[][] tea4string = {{"�������","���ĥ���","","",""},
			{"��G���K","���Į۶�","","",""},{"��G����","","","",""}};
	String[][] tea4pricestring = {{"40","40","","",""},
			{"55","45","","",""},
			{"45","45","","",""}};
	
	static JLabel timeprint = new JLabel();
	
	JLabel dot = new JLabel("");
	
	ImageIcon icon1 = new ImageIcon("d1.png");
	
	static Calendar calendar = new GregorianCalendar();
	
	int rowindex = 0;  //�����ثe��J��m	
	
	//-------------------------------------
	int x ;  //�`���B
	
	JFrame fpay = new JFrame();
    JPanel a = new JPanel();
    
	JTextField total = new JTextField("");
	JTextField input = new JTextField("");
	JTextField output = new JTextField("");
	
	JButton b1 = new JButton("��^");
	JButton b2 = new JButton("�T�w");
	JButton b3 = new JButton("����");
	
	JLabel a1 = new JLabel("�`�p");
	JLabel a2 = new JLabel("�ꦬ");
	JLabel a3 = new JLabel("��s");
	
	JButton[][] digbtn = new JButton[3][4];
	String[][] digstr = {{"7","4","1",""},{"8","5","2","0"},{"9","6","3","C"}}; 
	//-------------------------------------
	
	
	pos_order_system(){	
		

	myTable = new JTable(table_data , table_title);
	myTable.setEnabled(false);
	TableColumnModel cModel = myTable.getColumnModel();
	TableColumn columnName = cModel.getColumn(0); 
	TableColumn columnnum = cModel.getColumn(1); 
	//TableColumn columntep = cModel.getColumn(2);
	//�ӧO�]�w���n���e�� 
	columnName.setPreferredWidth(100); 
	columnnum.setPreferredWidth(70); 
	//columntep.setPreferredWidth(50);    
    myTable.getTableHeader().setFont(new Font("�L�n������",Font.PLAIN,16));
    myTable.getTableHeader().setBackground(new Color(255,255,255));
    //myTable.setGridColor(new Color(255,255,255));
	myTable.setRowHeight(35);
	myTable.setFont(new Font("�L�n������",Font.PLAIN,19));
	mySpane = new JScrollPane(myTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	mySpane.setBounds(10,10,595,485);
	mySpane.setVisible(true);
	p1.add(mySpane);


    tPane.setBounds(620,0,550,450);
    tPane.setFont(new Font("�L�n������",Font.PLAIN,24));
    p1.add(tPane);
    tPane.add(tabTxt1,part1);
    tPane.add(tabTxt2,part2);
    tPane.add(tabTxt3,part3);
    tPane.add(tabTxt4,part4);
    
    for(int i=0; i<tea1.length; i++){            //tea1  ����     
        for(int j=0; j<tea1[0].length; j++){         
               tea1[i][j] = new JButton(tea1string[i][j]);       //��r
               tea1[i][j].setBackground(new Color(179,211,255));                    
               tea1[i][j].setBounds(45+(i*155),15+(j*75),150,70);
               tea1[i][j].setFont(new Font("�L�n������",Font.BOLD,24)); 
               //midbtn[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
               tea1[i][j].addActionListener(ProcessTea1Btn);
               part1.add(tea1[i][j]);
        }
    }
    
    for(int i=0; i<tea2.length; i++){            //tea2   
        for(int j=0; j<tea2[0].length; j++){         
               tea2[i][j] = new JButton(tea2string[i][j]);       
               tea2[i][j].setBackground(new Color(179,211,255));                    
               tea2[i][j].setBounds(45+(i*155),15+(j*75),150,70);
               tea2[i][j].setFont(new Font("�L�n������",Font.BOLD,24)); 
               //midbtn[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
               tea2[i][j].addActionListener(ProcessTea2Btn);
               part2.add(tea2[i][j]);
        }
    }
    
    for(int i=0; i<tea3.length; i++){            //tea3       
        for(int j=0; j<tea3[0].length; j++){         
               tea3[i][j] = new JButton(tea3string[i][j]);       
               tea3[i][j].setBackground(new Color(179,211,255));                    
               tea3[i][j].setBounds(45+(i*155),15+(j*75),150,70);
               tea3[i][j].setFont(new Font("�L�n������",Font.BOLD,24)); 
               //midbtn[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
               tea3[i][j].addActionListener(ProcessTea3Btn);
               part3.add(tea3[i][j]);
        }
    }
    
    for(int i=0; i<tea4.length; i++){            //tea4
        for(int j=0; j<tea4[0].length; j++){         
               tea4[i][j] = new JButton(tea4string[i][j]);       
               tea4[i][j].setBackground(new Color(179,211,255));                    
               tea4[i][j].setBounds(45+(i*155),15+(j*75),150,70);
               tea4[i][j].setFont(new Font("�L�n������",Font.BOLD,24)); 
               //midbtn[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
               tea4[i][j].addActionListener(ProcessTea4Btn);  
               part4.add(tea4[i][j]);
        }
    }

	for(int i=0; i<coldhotbtn.length;i++){
		coldhotbtn[i] = new JButton(coldhotstring[i]);
		coldhotbtn[i].setBounds(635+(i*105),460,100,50);
		coldhotbtn[i].setBackground(new Color(253,149,104));
		coldhotbtn[i].setFont(new Font("�L�n������",Font.BOLD,22));
		//coldhotbtn[i].setBorder(null);
		//coldhotbtn[i].setBackground(new Color(60,157,255));
		//coldhotbtn[i].setForeground(new Color(255,255,255));
		//coldhotbtn[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		coldhotbtn[i].addActionListener(ProcesshotcoolBtn);
		p1.add(coldhotbtn[i]);
	}
	for(int i=0; i<sweetbtn.length;i++){
		sweetbtn[i] = new JButton(sweetstring[i]);
		sweetbtn[i].setBounds(635+(i*105),515,100,50);
		sweetbtn[i].setBackground(new Color(250,247,133));
		sweetbtn[i].setFont(new Font("�L�n������",Font.BOLD,22));
		//sweetbtn[i].setBorder(null);
		//sweetbtn[i].setForeground(new Color(255,255,255));		
		//sweetbtn[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		sweetbtn[i].addActionListener(ProcesssweetBtn);
		p1.add(sweetbtn[i]);
	}
	
    managebtn.setBounds(210,735,120,50);   //�޲z���s
    managebtn.setFont(new Font("�L�n������",Font.PLAIN,20));
    //managebtn.setBackground(new Color());
    //managebtn.setBorder(null);
    p1.add(managebtn);
    logoutbtn.setBounds(340,735,120,50);   //�n�X���s
    logoutbtn.setFont(new Font("�L�n������",Font.PLAIN,20));
    p1.add(logoutbtn);
    timeprint.setBounds(30,725,170,65);
    timeprint.setBorder(null);
    timeprint.setBackground(new Color(25,181,254));
    timeprint.setFont(new Font("�L�n������",Font.PLAIN,20));
    p1.add(timeprint);
    
   
	for(int i=0; i<digitBtn.length; i++){                //for�~�j��Ai�q 0 �� digitBtn.length (�]�N�O3)�A�Y:0,1,2
        for(int j=0; j<digitBtn[0].length; j++){         //for���j��Aj�q 0 �� digitBtn[0].length (�]�N�O4)�A�Y:0,1,2,3
               digitBtn[i][j] = new JButton(digitBtnString[i][j]);         //�إ߼Ʀr���sdigitBtn[i][j]�A���r��digitBtnString[i][j]
               digitBtn[i][j].setBackground(new Color(179,211,255));                     //�]�w�Ʀr���sdigitBtn[i][j]���C�⬰myColor1
               digitBtn[i][j].setFont(new Font("�L�n������",Font.BOLD,25));    // �]�w������, �j�p��25
               //digitBtn[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));   //�]�w��X�������
               digitBtn[i][j].addActionListener(ProcessDigitBtn);
               numarea.add(digitBtn[i][j]);                   //�b�e��numarea���[�J�Ʀr���sdigitBtn[i][j](����gridLayout(3,4,5,5)�h��)
        }
    }
	
	
	numarea.setBounds(790,580,260,210);
	numarea.setBackground(Color.lightGray);
	numarea.setLayout(new GridLayout(4,3,2,2));    
	numarea.setBorder(BorderFactory.createLineBorder((new Color(125,223,225)),2));
	p1.add(numarea);
	
	for(int i=0; i<midbtn.length; i++){                
        for(int j=0; j<midbtn[0].length; j++){         
               midbtn[i][j] = new JButton(midstring[i][j]);       
               midbtn[i][j].setBackground(new Color(179,211,255));                    
               midbtn[i][j].setBounds(570+(i*105),580+(j*65),100,60);
               midbtn[i][j].setFont(new Font("�L�n������",Font.BOLD,19)); 
               //midbtn[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
               midbtn[i][j].addActionListener(ProcesswayBtn);
               p1.add(midbtn[i][j]);
        }
    }
	
	count.setBounds(170,520,60,45);                        //�`�p���
	count.setFont(new Font("�L�n������",Font.BOLD,25));
	p1.add(count); 
	sumTxtFd.setBounds(240,520,160,45);                    //��ܪ��B
	sumTxtFd.setFont(new Font("�L�n������",Font.BOLD,25));
	//sumTxtFd.setHorizontalAlignment(SwingConstants.RIGHT);
	sumTxtFd.setEditable(false); 
	
	p1.add(sumTxtFd);
	
	paybtn.setBounds(1060,580,110,100);                    //���b���s
	paybtn.setFont(new Font("�L�n������",Font.BOLD,25));
	paybtn.addActionListener(ProcessCashBtn);
	p1.add(paybtn);
	nextbtn.setBounds(1060,690,110,100);                  //�U�@�ӫ��s
	nextbtn.setFont(new Font("�L�n������",Font.BOLD,25));
	nextbtn.addActionListener(ProcessNextBtn);
	p1.add(nextbtn);
	
	dot.setBounds(0,35,9,35);              //���� rowindex�ثe��m
	dot.setOpaque(true);
	dot.setBackground(new Color(0,255,64));
	p1.add(dot);
	
	
	
	//-------------------------------------
	//�]�w�϶�
    part1.setBackground(new Color(107,250,118));       
    part1.setLayout(null); 
    part2.setBackground(new Color(107,250,118)); 
    part2.setLayout(null); 
    part3.setBackground(new Color(107,250,118));
    part3.setLayout(null);
    part4.setBackground(new Color(255,198,198));
    part4.setLayout(null);
	
	p1.setBounds(0,0,1200,850);
	p1.setBackground(new Color(25,181,254));
	p1.setLayout(null);
	face.add(p1);
	
	face.setTitle("�I�\�@�~");
	face.setLayout(null);
	face.setLocation(350,120);
	face.setSize(1200,850);		
	face.setVisible(false);                         //�w�]����
	face.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	
	//---------------------------------------------
	a.setBounds(0,0,700,500);
    a.setBackground(new Color(0,60,120));    
    a.setLayout(null);
    fpay.add(a);
    
    b1.setBounds(20,245,100,50);                    //��^���s
    b1.setFont(new Font("�L�n������",Font.PLAIN,24));
    b1.setBackground(new Color(68,68,68));
    b1.setForeground(new Color(255,255,255));
    b1.addActionListener(Processcash);
    a.add(b1);           
    b2.setBounds(130,245,100,50);                    //�T�w���s
    b2.setFont(new Font("�L�n������",Font.PLAIN,24));
    b2.setBackground(new Color(68,68,68));
    b2.setForeground(new Color(255,255,255));
    b2.addActionListener(Processcash);    
    a.add(b2);
    b3.setBounds(240,245,100,50);                    //���ȫ��s
    b3.setFont(new Font("�L�n������",Font.PLAIN,24));
    b3.setBackground(new Color(68,68,68));
    b3.setForeground(new Color(255,255,255));
    b3.addActionListener(Processcash);
    a.add(b3);
    
    a1.setBounds(15,30,70,50);     
    a1.setForeground(new Color(255,255,255));
    a1.setFont(new Font("�L�n������",Font.BOLD,30));
    a.add(a1);
    a2.setBounds(15,100,70,50);
    a2.setForeground(new Color(255,255,255));
    a2.setFont(new Font("�L�n������",Font.BOLD,30));
    a.add(a2);
    a3.setBounds(15,170,70,50);
    a3.setForeground(new Color(255,255,255));
    a3.setFont(new Font("�L�n������",Font.BOLD,30));
    a.add(a3);
    
	  total.setBounds(100,30,230,50);                           //�`�p���
	  total.setBackground(new Color(0,60,120));
	  total.setForeground(new Color(255,255,255));
	  total.setFont(new Font("�L�n������",Font.BOLD,30));
    // �Ʀr�ഫ
	  total.setText(" " + x);
	  //------
	  total.setEditable(false);
    a.add(total);
    input.setBounds(100,100,230,50);                           //�ꦬ���
    input.setBackground(new Color(0,60,120));
    input.setForeground(new Color(255,255,255));
    input.setFont(new Font("�L�n������",Font.BOLD,30));
    input.setEditable(false);
    a.add(input);          
    output.setBounds(100,170,230,50);                       //��s���
    output.setBackground(new Color(0,60,120));
    output.setForeground(new Color(255,255,255));
    output.setFont(new Font("�L�n������",Font.BOLD,30));
    output.setEditable(false);
    a.add(output); 
    
	  for(int i=0;i<digbtn.length;i++){           //�Ʀr��
		  for(int j=0;j<digbtn[0].length;j++){
			  digbtn[i][j] = new JButton(digstr[i][j]);
			  digbtn[i][j].setBackground(new Color(0,60,120));
			  digbtn[i][j].setForeground(Color.white);
			  digbtn[i][j].setFont(new Font("�L�n������",Font.BOLD,30));
			  digbtn[i][j].setBounds(360 + i * 100 , 30 + j * 70 , 90 , 60);
			  digbtn[i][j].setBorder(BorderFactory.createLineBorder((new Color(255,255,255)),2));
			  digbtn[i][j].addActionListener(Processdigbtn);  
			  a.add(digbtn[i][j]);
		  }
	  }	

	digbtn[0][3].setIcon(icon1);          //���J�Ϥ�
	
	fpay.setTitle("����");        //�����f�]�w���D
    fpay.setLayout(null);               //�����f�]�w��������
    fpay.setLocation(570,320);            //�����f�]�w��m��m
    fpay.setSize(700,370);             //�����f�]�w�j�p
    fpay.setVisible(false);              //�����f�]�w��ܥi��
    //fpay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //�����f�]�w�������}�覡
    
}
	

	
	//-------------------------------------
	//�]�w���s����
	public ActionListener ProcessTea1Btn = new ActionListener(){
       public void actionPerformed(ActionEvent e){
            for(int i=0; i<tea1.length; i++){
                  for(int j=0; j<tea1[0].length; j++){
                       if( e.getSource() == tea1[i][j] ){ 
                    	   if (tea1string[i][j] != "" ){
                               myTable.setValueAt(tea1string[i][j],rowindex,0);     //���[�~��]
                               myTable.setValueAt("1",rowindex,1);                     //�w�]�ƶq��1
                               myTable.setValueAt(tea1pricestring[i][j],rowindex,4);   //�w�]�p�p��[���]x1
                               myTable.setValueAt(tea1pricestring[i][j],rowindex,6);
                               myTable.setValueAt("�~�a",rowindex,5);
                               n = 0;
                               amt = 0;
                               amf = 0;
                    	   }
                        }
                   }
            }
        }    
     };	
     public ActionListener ProcessTea2Btn = new ActionListener(){
         public void actionPerformed(ActionEvent e){
             for(int i=0; i<tea2.length; i++){
                   for(int j=0; j<tea2[0].length; j++){
                        if( e.getSource() == tea2[i][j] ){ 
                     	   if (tea2string[i][j] != "" ){
                                myTable.setValueAt(tea2string[i][j],rowindex,0);     //���[�~��]
                                myTable.setValueAt("1",rowindex,1);                     //�w�]�ƶq��1
                                myTable.setValueAt(tea2pricestring[i][j],rowindex,4);   //�w�]�p�p��[���]x1
                                myTable.setValueAt(tea2pricestring[i][j],rowindex,6);
                                myTable.setValueAt("�~�a",rowindex,5);
                                n = 0;
                                amt = 0;
                                amf = 0;
                     	   }
                         }
                    }
             }
         }    
      };
  	public ActionListener ProcessTea3Btn = new ActionListener(){
        public void actionPerformed(ActionEvent e){
             for(int i=0; i<tea3.length; i++){
                   for(int j=0; j<tea3[0].length; j++){
                        if( e.getSource() == tea3[i][j] ){ 
                     	   if (tea3string[i][j] != "" ){
                                myTable.setValueAt(tea3string[i][j],rowindex,0);     //���[�~��]
                                myTable.setValueAt("1",rowindex,1);                     //�w�]�ƶq��1
                                myTable.setValueAt(tea3pricestring[i][j],rowindex,4);   //�w�]�p�p��[���]x1
                                myTable.setValueAt(tea3pricestring[i][j],rowindex,6);
                                myTable.setValueAt("�~�a",rowindex,5);
                                n = 0;
                                amt = 0;
                                amf = 0;
                     	   }
                         }
                    }
             }
         }    
      };
  	public ActionListener ProcessTea4Btn = new ActionListener(){
        public void actionPerformed(ActionEvent e){
             for(int i=0; i<tea4.length; i++){
                   for(int j=0; j<tea4[0].length; j++){
                        if( e.getSource() == tea4[i][j] ){ 
                     	   if (tea4string[i][j] != "" ){
                                myTable.setValueAt(tea4string[i][j],rowindex,0);     //���[�~��]
                                myTable.setValueAt("1",rowindex,1);                     //�w�]�ƶq��1
                                myTable.setValueAt(tea4pricestring[i][j],rowindex,4);   //�w�]�p�p��[���]x1
                                myTable.setValueAt(tea4pricestring[i][j],rowindex,6);
                                myTable.setValueAt("�~�a",rowindex,5);
                                n = 0;
                                amt = 0;
                                amf = 0;
                     	   }
                         }
                    }
             }
         }    
      };
     
 	public ActionListener ProcesshotcoolBtn = new ActionListener(){
        public void actionPerformed(ActionEvent e){
             for(int i=0; i<coldhotbtn.length; i++){                   
                        if( e.getSource() == coldhotbtn[i] ){
                                myTable.setValueAt(coldhotstring[i],rowindex,3);     //��� �N��
                         }
                    
             }
         }    
      };
   	public ActionListener ProcesssweetBtn = new ActionListener(){
        public void actionPerformed(ActionEvent e){
             for(int i=0; i<sweetbtn.length; i++){
                        if( e.getSource() == sweetbtn[i] ){
                                myTable.setValueAt(sweetstring[i],rowindex,2);     //��� ����
                         }                    
             }
         }    
     };
     public ActionListener ProcesswayBtn = new ActionListener(){     //���\�O
            public void actionPerformed(ActionEvent e){                 
                  if( e.getSource() == midbtn[0][0] ){
                        myTable.setValueAt("����",rowindex,5);                         
                  }
                  if( e.getSource() == midbtn[0][1] ){
                      myTable.setValueAt("�~�a",rowindex,5);       
                  }
                  if( e.getSource() == midbtn[0][2] ){
                      myTable.setValueAt("�~�e",rowindex,5);     
                  }
                  if( e.getSource() == midbtn[1][0]){     //�M�Ŧ���
                	  for (int i=0;i<table_title.length;i++){
                		  myTable.setValueAt("",rowindex,i);
                	  }
                	  n = 0;
                	  amt = 0 ;
                	  amf = 0;
                  }
                  if( e.getSource() == midbtn[1][1]){   //�M�ž㭶
                	  int ans = JOptionPane.showConfirmDialog(null,"�T�w�n�����M���I�\����?","�A�T�{",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                
                      if( ans == JOptionPane.YES_OPTION ){
                           rowindex = 0;
                           for(int i=0; i<table_data.length; i++)
                                 for(int j=0; j<table_data[0].length; j++)
                                        myTable.setValueAt("",i,j);    
                           n = 0;
                           amt = 0;
                           amf = 0;
                           dot.setBounds(0,( (rowindex+1) * 35),9,35);
                      }
                      sumTxtFd.setText("");
                  }
                  if(e.getSource() == midbtn[1][2]){
                	  if (rowindex > 0){
                	  rowindex = rowindex - 1 ; 
                	  n = 0 ;     
                	  amt = 0;
                	  amf = 0;
                	  dot.setBounds(0,( (rowindex+1) * 35),9,35);
                	  }
                  }
            }    
     };

     
     int amt = 0 ;
     int amf = 0 ;
     int n = 0 ;
	 public ActionListener ProcessDigitBtn = new ActionListener(){
         public void actionPerformed(ActionEvent e){
       	  if (e.getSource() == digitBtn[3][2]){
       		  myTable.setValueAt("",rowindex,1);
       		  myTable.setValueAt("",rowindex,6);
       		  amt = 0 ;
       		  amf = 0;
       		  n = 0;
       	  }
       	  if (e.getSource() != digitBtn[3][2]  && e.getSource() != digitBtn[3][0]){
              for(int i=0; i<digitBtn.length; i++){
                    for(int j=0; j<digitBtn[0].length; j++){
                         if( e.getSource() == digitBtn[i][j] ){
                        	 if (n < 2){
                             amt = amt * 10 ;
                             int amf = Integer.parseInt(digitBtnString[i][j]);
                             amt = amt + amf ;                             
                        	 myTable.setValueAt("" + amt ,rowindex,1);                    //���[�ƶq]
                        	 n++;
                        	 }
                              if (myTable.getValueAt(rowindex,0) != "" && myTable.getValueAt(rowindex,0) != null){ 
                         
                                  int price = Integer.parseInt((String)myTable.getValueAt(rowindex,4));   //���[���]�r��A�A�ର���int
                                  //int amount = Integer.parseInt(digitBtnString[i][j]);                    //���[�ƶq]�r��A�A�ର���int
                                  myTable.setValueAt(String.valueOf(price*amt),rowindex,6);            //�N(���x�ƶq)����ƭ��ର�r������     
                           	   
                                  }
                         }
                     }
              }
              }
          }    
    };
     
     public ActionListener ProcessCashBtn = new ActionListener(){
    	 public void actionPerformed(ActionEvent e){
    		// ���b
        	 if (e.getSource() == paybtn){
        	
        	 boolean b = false ;
           	  for (int i=0;i<table_title.length;i++){
                 if (myTable.getValueAt(rowindex,i) != null && myTable.getValueAt(rowindex,i) != ""){            	        
                      b = true;
                 }
                 else {                	 
                  	 b = false ;
                  	 break;
                 }
           	   }
           	  //-----���� : �h��J�s�W�@����ƫo�L��J���-------------
 	        	if (rowindex >= 1 ){
   	        		boolean em = false ;
   	        		for(int c=0 ; c < table_title.length ; c++){
   	        			if (myTable.getValueAt(rowindex,c) == null || myTable.getValueAt(rowindex,c) == ""){
   	        				em = true;           	        				
   	        			}
   	        			else{
   	        				em = false;
   	        				break;
   	        			}
   	        		}
   	        		if ( em == true ){
   	        			rowindex --;
   	        			b = true;
   	        		}
   	        	}
           	  //-----------------------------------------------
           	        if ( b == true ){
           		          int sum = 0;
           		          for (int i=0 ; i<=rowindex ; i++ ){
        			      int now =  Integer.parseInt((String)myTable.getValueAt(i,6));
        			      sum = sum + now;
        		          }
        		          String sumstr = String.valueOf(sum);
        		          sumTxtFd.setText(sumstr);        		          
                          fpay.setVisible(true);
                          total.setText(" " +sum);
                          cashdel = sum ;
                          x = sum ;
                          //---  �ϥΪ̫��U���b���î� �A  ��X���B�k  0 �A��X���M��  �A �i���k  0 
                          t = 0;                          
                          input.setText("");
                          amount = 0;
                          //---
                          n = 0 ;
                          amf = 0 ;
                          amt = 0;
           	        }
           	        else{   
           	        	JOptionPane.showMessageDialog(null,"��J������!!","��J���~",JOptionPane.INFORMATION_MESSAGE);  
           	        }       		     
        	 }
    	 }
     };
    
     public ActionListener ProcessNextBtn = new ActionListener(){   //�U�@��
         public void actionPerformed(ActionEvent e){
        	 // �U�@��
        	if (rowindex < 12 ){   //rember 2
        	    if (e.getSource() == nextbtn){
        	      boolean a = false ;
        	      for (int i=0;i<table_title.length; i ++){
                     if (myTable.getValueAt(rowindex,i) != null && myTable.getValueAt(rowindex,i) != ""){            	        
                          a = true;
                     }
                     else {                	 
                	      a = false ;
                	 break;
                     }
        	       }
        	      if ( a == true && rowindex < 13  ){
        		  rowindex = rowindex + 1 ;
        		  n = 0;
        		  amt = 0 ;
        		  amf = 0;
        		      if (rowindex < 13){
        		      dot.setBounds(0,( (rowindex+1) * 35),9,35);     
        		      }
        	      }
        	      if ( a == false){
        	    	  JOptionPane.showMessageDialog(null,"��Ƥ��ର��!!","���~",JOptionPane.INFORMATION_MESSAGE);
        	      }
        	    }
        	} 
          	else{
        		JOptionPane.showMessageDialog(null,"�L�k�~��W�[!!","���~",JOptionPane.INFORMATION_MESSAGE);
        	}
          }
    };
    
  
    
    //----------------------------------
     static void setTime()  //�]�w�t�ήɶ�
    {
        calendar.setTimeInMillis( System.currentTimeMillis() );
    }
    
    static public int getYear()  //���o�~
    {
        return calendar.get(Calendar.YEAR);
    }
    
    static public int getMonth()  //���o��
    {
        return (calendar.get(Calendar.MONTH)+1);
    }
    
    static public int getDate()  //���o��
    {
        return calendar.get(Calendar.DATE);
    }
    
    static public int getHour()  //���o�p��
    {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }
    
    static public int getMinute()  //���o����
    {
        return calendar.get(Calendar.MINUTE);
    }
        
    static public int getSecond()  //���o���
    {
        return calendar.get(Calendar.SECOND);
    }
    
    static public void showCurrentTime()  //��ܥثe�ɶ�
    {
        while(true)
        {
            setTime();            
            timeprint.setText("<html>"+getYear()+"�~"+getMonth()+"��"+getDate()+"��"+"<br>"+getHour()+"��"+getMinute()+"��"+getSecond()+"��"+"<html>");
        }
    }   
    //---------------------------------------------------------

    	 
        int t = 0;     //���ܼƥΩ󭭨�ϥΪ̿�J�L�����Ʀr
    	int re = 0 ;	 //�����Ӧ��
    	int amount = 0 ;  //�I�ڪ��B
    		
        public ActionListener Processdigbtn = new ActionListener(){
            public void actionPerformed(ActionEvent e){
          	  
                for(int i=0;i<digbtn.length;i++){          //�Ʀr��
                	for(int j=0;j<digbtn[0].length;j++){
                		if (e.getSource() == digbtn[i][j]){
                			if (e.getSource() != digbtn[0][3] && e.getSource() != digbtn[2][3] ){
                				if (t < 8){    //����8���
                			       amount =  amount * 10 ;	
                        		   int re = Integer.parseInt(digstr[i][j]); 
                			       amount  = amount + re ;
                			       input.setText(" "+amount);
                			            if (amount > 0 ){
                				             t++ ;
                			            }                			
                				}
                			}      
                			if (e.getSource() == digbtn[0][3]){    //��@���
                				amount = amount / 10 ;
                				if ( t > 0 ){
                				t = t - 1;
                				}
                				input.setText(" "+amount);
                			}
                		    if (e.getSource() == digbtn[2][3]){      //�k�s��
                		    	input.setText("");
                		    	output.setText("");
                		    	re = 0;     
                		    	amount = 0;   
                		    	t = 0 ;   //�`����k0
                		    }
                		}
                	}
                }
          	  }
        
        };
        
        static int cashdel = 0 ; //�ǭȥΪ��ܼ�       
        static String cth_nday = "";       //�����̫�@����ƪ���� 
        int ntd = 0; // ��ܧ�s
        boolean tes_ntd = false ;   //��������Ȧӵ�������
        public ActionListener Processcash = new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		if (e.getSource() == b3 ){
        			ntd = amount - x ;
        			if (ntd >= 0){
        				output.setText(" " + ntd);
        				tes_ntd = true ;
        			}
        			else{
        				JOptionPane.showMessageDialog(null,"���B���~","���b���~",JOptionPane.INFORMATION_MESSAGE);
        			    tes_ntd = false ;
        			}
        		}
        		if (e.getSource() == b2 ){        			
        			if (ntd >= 0 && amount != 0 && tes_ntd == true){
                        sumTxtFd.setText("");
        			    fpay.setVisible(false);
        			    total.setText("");
        			    input.setText("");
        			    output.setText("");        			   		    
        			    amount = 0;
        			    ntd = -1;
        			    n = 0 ;
        			    amt = 0;
        			    amf = 0;        			    
        			    t = 0;
        			    tes_ntd = false;
        			    
        			    if ( rowindex == 0 ){
        			    	//���Ʈw�ǤJ�ƭȡA�I�spos_revenue_diliver��insert_into_revenue
        			    	p_dil.insert_into_revenue((String)myTable.getValueAt(0,0),
        			    			Integer.valueOf((String)myTable.getValueAt(0,1)),
        			    			Integer.valueOf((String)myTable.getValueAt(0,6)));
        			    	
        			    }
        			    if ( rowindex !=0 ){
        			    	//���Ʈw�ǤJ�ƭȡA�I�spos_revenue_diliver��insert_into_revenue
        			    	for (int i=0;i<rowindex+1;i++){
        			    		p_dil.insert_into_revenue((String)myTable.getValueAt(i,0),
            			    			Integer.valueOf((String)myTable.getValueAt(i,1)),
            			    			Integer.valueOf((String)myTable.getValueAt(i,6)));
        			    	}        			    	
        			    }        			    
                        for(int i=0; i<table_data.length; i++)  //�M�Ū��
                        {
                            for(int j=0; j<table_data[0].length; j++){
                                    myTable.setValueAt("",i,j);
                            }
                        }
                        
                        
                        pos_administer_system.cth_in.catch_perday_income(
                   				 (String)pos_administer_system.getdatacode2(),"b");
                         
                        /*
                        else{
                        	 pos_administer_system.cth_in.catch_perday_income(
            				 (String)pos_administer_system.getdatacode2(),"c");
                        	 JOptionPane.showMessageDialog(null,"�v�� : c");
                        	 n_time = ch_time();
                        	 n2_time = n_time;
                        }
        				*/
        			    rowindex = 0;
        			    dot.setBounds(0,( (rowindex+1) * 35),9,35);
        			}
        			else{
        				JOptionPane.showMessageDialog(null,"�Х������ȫ��s��A�T�{","���b���~",JOptionPane.INFORMATION_MESSAGE);
        			}
        		}
        		if (e.getSource() == b1 ){
        			fpay.setVisible(false);
        			input.setText("");
        			output.setText("");
        			amount = 0 ;
        			ntd = 0 ;
        			t = 0  ; 
        			tes_ntd = false;
        			dot.setBounds(0,( (rowindex+1) * 35),9,35);
        		}
        	}
        };    
        
    //----------------------------------------------------
	
    String n_time = "" ; 
    String n2_time = "ex";    
    static String ch_time(){
    	String ck_t = String.valueOf(getYear()) +
    			String.valueOf(getMonth()) +
    			String.valueOf(getDate()) ;
    	return(ck_t);
    }
        
}  //pos_order_system ����

