import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class pos_order_system{ 
	
	JFrame face = new JFrame();  //點餐系統的視窗介面命名 為 face
	
    pos_revenue_diliver p_dil = new pos_revenue_diliver();  //建立傳值用的物件
	
	ImageIcon icon2 = new ImageIcon("home.png"); 
	ImageIcon icon3 = new ImageIcon("sigin.png");	
	JButton managebtn = new JButton("管理",icon2);
	JButton logoutbtn = new JButton("登出",icon3);
	JButton[][] midbtn = new JButton[2][3];
	String midstring[][] = {{"內用","外帶","外送"},{"<html>"+"取消"+"<br>"+"此樣"+"</html>","<html>"+"清空"+"<br>"+"整頁"+"</html>","上一筆"}};
	
	JPanel p1 = new JPanel();
	
	JPanel part1 = new JPanel();        //飲料區
    JPanel part2 = new JPanel();
    JPanel part3 = new JPanel();
    JPanel part4 = new JPanel();

	JLabel count = new JLabel("總計");
	
	JScrollPane mySpane; //宣告滑動容器
	JTable myTable; //宣告表格
	String table_title[] = {"品名","數量","甜度","冰塊","單價","用餐類別","小計"};
	String[][] table_data = new String[13][7];   //製作   20 橫列*5直行 的表格    
	
    Font font1 = new Font("標楷體" , Font.BOLD, 20);		//自訂字形
    JButton[][] digitBtn = new JButton[4][3];           //數字按鈕物件陣列(4橫列x3直行)
    String[][]  digitBtnString = {{"1","2","3"},{"4","5","6"},{"7","8","9"},{"","0","C"}};   //數字按鈕對應的按鈕文字
	JPanel numarea = new JPanel();
	
	JButton[] coldhotbtn = new JButton[5];
	String[] coldhotstring = {"正常冰","少冰","去冰","溫","熱"};
	JButton[] sweetbtn = new JButton[5];
	String[] sweetstring = {"正常","七分糖","五分糖","三分糖","無糖"};

	JTextField sumTxtFd = new JTextField("");   //顯示總金額
    
	JButton paybtn = new JButton("結帳"); 
	JButton nextbtn = new JButton("下一筆");
	
    JTabbedPane tPane = new JTabbedPane();
    String tabTxt1 = "奶茶";      
    String tabTxt2 = "特調茶";     
    String tabTxt3 = "原味茶";      
    String tabTxt4 = "季節限定";
    
    JButton[][] tea1 = new JButton[3][5];
	String[][] tea1string = {{"蔗香奶茶","茉香奶茶","豆漿奶茶","觀音奶茶",""},
			{"波霸奶茶","冬瓜拿鐵","抹茶拿鐵","紅茶拿鐵",""},
			{"布丁奶茶","黑糖拿鐵","珍珠奶綠","焦糖拿鐵",""}};
	String[][] tea1pricestring = {{"40","40","45","45",""},
			{"55","45","45","40",""},
			{"45","40","40","45",""}};
	
    JButton[][] tea2 = new JButton[3][5];
	String[][] tea2string = {{"梅子綠茶","檸檬翡翠","冬瓜檸檬","鳳梨紅茶",""},
			{"百香綠茶","蜂蜜綠茶","檸檬紅茶","鮮水果茶",""},
			{"多多綠茶","寒天檸檬","蜜香紅茶","",""}};
	String[][] tea2pricestring = {{"30","30","35","35",""},
			{"30","30","30","30",""},
			{"45","40","45","45",""}};
	
    JButton[][] tea3 = new JButton[3][5];
	String[][] tea3string = {{"深焙烏龍","蔗香紅茶","茉莉綠茶","",""},
			{"高山烏龍","菊花普洱","","",""},{"吉嶺紅茶","錫蘭紅茶","","",""}};
	String[][] tea3pricestring = {{"35","35","35","",""},
			{"40","40","","",""},
			{"35","45","","",""}};
	
    JButton[][] tea4 = new JButton[3][5];
	String[][] tea4string = {{"原味薑茶","薑汁奶茶","","",""},
			{"堅果拿鐵","薑汁桂圓","","",""},{"堅果奶茶","","","",""}};
	String[][] tea4pricestring = {{"40","40","","",""},
			{"55","45","","",""},
			{"45","45","","",""}};
	
	static JLabel timeprint = new JLabel();
	
	JLabel dot = new JLabel("");
	
	ImageIcon icon1 = new ImageIcon("d1.png");
	
	static Calendar calendar = new GregorianCalendar();
	
	int rowindex = 0;  //紀錄目前輸入位置	
	
	//-------------------------------------
	int x ;  //總金額
	
	JFrame fpay = new JFrame();
    JPanel a = new JPanel();
    
	JTextField total = new JTextField("");
	JTextField input = new JTextField("");
	JTextField output = new JTextField("");
	
	JButton b1 = new JButton("返回");
	JButton b2 = new JButton("確定");
	JButton b3 = new JButton("收銀");
	
	JLabel a1 = new JLabel("總計");
	JLabel a2 = new JLabel("實收");
	JLabel a3 = new JLabel("找零");
	
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
	//個別設定偏好的寬度 
	columnName.setPreferredWidth(100); 
	columnnum.setPreferredWidth(70); 
	//columntep.setPreferredWidth(50);    
    myTable.getTableHeader().setFont(new Font("微軟正黑體",Font.PLAIN,16));
    myTable.getTableHeader().setBackground(new Color(255,255,255));
    //myTable.setGridColor(new Color(255,255,255));
	myTable.setRowHeight(35);
	myTable.setFont(new Font("微軟正黑體",Font.PLAIN,19));
	mySpane = new JScrollPane(myTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	mySpane.setBounds(10,10,595,485);
	mySpane.setVisible(true);
	p1.add(mySpane);


    tPane.setBounds(620,0,550,450);
    tPane.setFont(new Font("微軟正黑體",Font.PLAIN,24));
    p1.add(tPane);
    tPane.add(tabTxt1,part1);
    tPane.add(tabTxt2,part2);
    tPane.add(tabTxt3,part3);
    tPane.add(tabTxt4,part4);
    
    for(int i=0; i<tea1.length; i++){            //tea1  奶茶     
        for(int j=0; j<tea1[0].length; j++){         
               tea1[i][j] = new JButton(tea1string[i][j]);       //文字
               tea1[i][j].setBackground(new Color(179,211,255));                    
               tea1[i][j].setBounds(45+(i*155),15+(j*75),150,70);
               tea1[i][j].setFont(new Font("微軟正黑體",Font.BOLD,24)); 
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
               tea2[i][j].setFont(new Font("微軟正黑體",Font.BOLD,24)); 
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
               tea3[i][j].setFont(new Font("微軟正黑體",Font.BOLD,24)); 
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
               tea4[i][j].setFont(new Font("微軟正黑體",Font.BOLD,24)); 
               //midbtn[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
               tea4[i][j].addActionListener(ProcessTea4Btn);  
               part4.add(tea4[i][j]);
        }
    }

	for(int i=0; i<coldhotbtn.length;i++){
		coldhotbtn[i] = new JButton(coldhotstring[i]);
		coldhotbtn[i].setBounds(635+(i*105),460,100,50);
		coldhotbtn[i].setBackground(new Color(253,149,104));
		coldhotbtn[i].setFont(new Font("微軟正黑體",Font.BOLD,22));
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
		sweetbtn[i].setFont(new Font("微軟正黑體",Font.BOLD,22));
		//sweetbtn[i].setBorder(null);
		//sweetbtn[i].setForeground(new Color(255,255,255));		
		//sweetbtn[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		sweetbtn[i].addActionListener(ProcesssweetBtn);
		p1.add(sweetbtn[i]);
	}
	
    managebtn.setBounds(210,735,120,50);   //管理按鈕
    managebtn.setFont(new Font("微軟正黑體",Font.PLAIN,20));
    //managebtn.setBackground(new Color());
    //managebtn.setBorder(null);
    p1.add(managebtn);
    logoutbtn.setBounds(340,735,120,50);   //登出按鈕
    logoutbtn.setFont(new Font("微軟正黑體",Font.PLAIN,20));
    p1.add(logoutbtn);
    timeprint.setBounds(30,725,170,65);
    timeprint.setBorder(null);
    timeprint.setBackground(new Color(25,181,254));
    timeprint.setFont(new Font("微軟正黑體",Font.PLAIN,20));
    p1.add(timeprint);
    
   
	for(int i=0; i<digitBtn.length; i++){                //for外迴圈，i從 0 到 digitBtn.length (也就是3)，即:0,1,2
        for(int j=0; j<digitBtn[0].length; j++){         //for內迴圈，j從 0 到 digitBtn[0].length (也就是4)，即:0,1,2,3
               digitBtn[i][j] = new JButton(digitBtnString[i][j]);         //建立數字按鈕digitBtn[i][j]，其文字為digitBtnString[i][j]
               digitBtn[i][j].setBackground(new Color(179,211,255));                     //設定數字按鈕digitBtn[i][j]的顏色為myColor1
               digitBtn[i][j].setFont(new Font("微軟正黑體",Font.BOLD,25));    // 設定為粗體, 大小為25
               //digitBtn[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));   //設定突出立體邊框
               digitBtn[i][j].addActionListener(ProcessDigitBtn);
               numarea.add(digitBtn[i][j]);                   //在容器numarea中加入數字按鈕digitBtn[i][j](按照gridLayout(3,4,5,5)去排)
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
               midbtn[i][j].setFont(new Font("微軟正黑體",Font.BOLD,19)); 
               //midbtn[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
               midbtn[i][j].addActionListener(ProcesswayBtn);
               p1.add(midbtn[i][j]);
        }
    }
	
	count.setBounds(170,520,60,45);                        //總計欄位
	count.setFont(new Font("微軟正黑體",Font.BOLD,25));
	p1.add(count); 
	sumTxtFd.setBounds(240,520,160,45);                    //顯示金額
	sumTxtFd.setFont(new Font("微軟正黑體",Font.BOLD,25));
	//sumTxtFd.setHorizontalAlignment(SwingConstants.RIGHT);
	sumTxtFd.setEditable(false); 
	
	p1.add(sumTxtFd);
	
	paybtn.setBounds(1060,580,110,100);                    //結帳按鈕
	paybtn.setFont(new Font("微軟正黑體",Font.BOLD,25));
	paybtn.addActionListener(ProcessCashBtn);
	p1.add(paybtn);
	nextbtn.setBounds(1060,690,110,100);                  //下一個按鈕
	nextbtn.setFont(new Font("微軟正黑體",Font.BOLD,25));
	nextbtn.addActionListener(ProcessNextBtn);
	p1.add(nextbtn);
	
	dot.setBounds(0,35,9,35);              //指示 rowindex目前位置
	dot.setOpaque(true);
	dot.setBackground(new Color(0,255,64));
	p1.add(dot);
	
	
	
	//-------------------------------------
	//設定區塊
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
	
	face.setTitle("點餐作業");
	face.setLayout(null);
	face.setLocation(350,120);
	face.setSize(1200,850);		
	face.setVisible(false);                         //預設關閉
	face.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	
	//---------------------------------------------
	a.setBounds(0,0,700,500);
    a.setBackground(new Color(0,60,120));    
    a.setLayout(null);
    fpay.add(a);
    
    b1.setBounds(20,245,100,50);                    //返回按鈕
    b1.setFont(new Font("微軟正黑體",Font.PLAIN,24));
    b1.setBackground(new Color(68,68,68));
    b1.setForeground(new Color(255,255,255));
    b1.addActionListener(Processcash);
    a.add(b1);           
    b2.setBounds(130,245,100,50);                    //確定按鈕
    b2.setFont(new Font("微軟正黑體",Font.PLAIN,24));
    b2.setBackground(new Color(68,68,68));
    b2.setForeground(new Color(255,255,255));
    b2.addActionListener(Processcash);    
    a.add(b2);
    b3.setBounds(240,245,100,50);                    //收銀按鈕
    b3.setFont(new Font("微軟正黑體",Font.PLAIN,24));
    b3.setBackground(new Color(68,68,68));
    b3.setForeground(new Color(255,255,255));
    b3.addActionListener(Processcash);
    a.add(b3);
    
    a1.setBounds(15,30,70,50);     
    a1.setForeground(new Color(255,255,255));
    a1.setFont(new Font("微軟正黑體",Font.BOLD,30));
    a.add(a1);
    a2.setBounds(15,100,70,50);
    a2.setForeground(new Color(255,255,255));
    a2.setFont(new Font("微軟正黑體",Font.BOLD,30));
    a.add(a2);
    a3.setBounds(15,170,70,50);
    a3.setForeground(new Color(255,255,255));
    a3.setFont(new Font("微軟正黑體",Font.BOLD,30));
    a.add(a3);
    
	  total.setBounds(100,30,230,50);                           //總計欄位
	  total.setBackground(new Color(0,60,120));
	  total.setForeground(new Color(255,255,255));
	  total.setFont(new Font("微軟正黑體",Font.BOLD,30));
    // 數字轉換
	  total.setText(" " + x);
	  //------
	  total.setEditable(false);
    a.add(total);
    input.setBounds(100,100,230,50);                           //實收欄位
    input.setBackground(new Color(0,60,120));
    input.setForeground(new Color(255,255,255));
    input.setFont(new Font("微軟正黑體",Font.BOLD,30));
    input.setEditable(false);
    a.add(input);          
    output.setBounds(100,170,230,50);                       //找零欄位
    output.setBackground(new Color(0,60,120));
    output.setForeground(new Color(255,255,255));
    output.setFont(new Font("微軟正黑體",Font.BOLD,30));
    output.setEditable(false);
    a.add(output); 
    
	  for(int i=0;i<digbtn.length;i++){           //數字鍵
		  for(int j=0;j<digbtn[0].length;j++){
			  digbtn[i][j] = new JButton(digstr[i][j]);
			  digbtn[i][j].setBackground(new Color(0,60,120));
			  digbtn[i][j].setForeground(Color.white);
			  digbtn[i][j].setFont(new Font("微軟正黑體",Font.BOLD,30));
			  digbtn[i][j].setBounds(360 + i * 100 , 30 + j * 70 , 90 , 60);
			  digbtn[i][j].setBorder(BorderFactory.createLineBorder((new Color(255,255,255)),2));
			  digbtn[i][j].addActionListener(Processdigbtn);  
			  a.add(digbtn[i][j]);
		  }
	  }	

	digbtn[0][3].setIcon(icon1);          //插入圖片
	
	fpay.setTitle("收銀");        //對視窗f設定標題
    fpay.setLayout(null);               //對視窗f設定布局為空
    fpay.setLocation(570,320);            //對視窗f設定放置位置
    fpay.setSize(700,370);             //對視窗f設定大小
    fpay.setVisible(false);              //對視窗f設定顯示可見
    //fpay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //對視窗f設定關閉離開方式
    
}
	

	
	//-------------------------------------
	//設定按鈕活動
	public ActionListener ProcessTea1Btn = new ActionListener(){
       public void actionPerformed(ActionEvent e){
            for(int i=0; i<tea1.length; i++){
                  for(int j=0; j<tea1[0].length; j++){
                       if( e.getSource() == tea1[i][j] ){ 
                    	   if (tea1string[i][j] != "" ){
                               myTable.setValueAt(tea1string[i][j],rowindex,0);     //顯示[品項]
                               myTable.setValueAt("1",rowindex,1);                     //預設數量為1
                               myTable.setValueAt(tea1pricestring[i][j],rowindex,4);   //預設小計為[單價]x1
                               myTable.setValueAt(tea1pricestring[i][j],rowindex,6);
                               myTable.setValueAt("外帶",rowindex,5);
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
                                myTable.setValueAt(tea2string[i][j],rowindex,0);     //顯示[品項]
                                myTable.setValueAt("1",rowindex,1);                     //預設數量為1
                                myTable.setValueAt(tea2pricestring[i][j],rowindex,4);   //預設小計為[單價]x1
                                myTable.setValueAt(tea2pricestring[i][j],rowindex,6);
                                myTable.setValueAt("外帶",rowindex,5);
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
                                myTable.setValueAt(tea3string[i][j],rowindex,0);     //顯示[品項]
                                myTable.setValueAt("1",rowindex,1);                     //預設數量為1
                                myTable.setValueAt(tea3pricestring[i][j],rowindex,4);   //預設小計為[單價]x1
                                myTable.setValueAt(tea3pricestring[i][j],rowindex,6);
                                myTable.setValueAt("外帶",rowindex,5);
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
                                myTable.setValueAt(tea4string[i][j],rowindex,0);     //顯示[品項]
                                myTable.setValueAt("1",rowindex,1);                     //預設數量為1
                                myTable.setValueAt(tea4pricestring[i][j],rowindex,4);   //預設小計為[單價]x1
                                myTable.setValueAt(tea4pricestring[i][j],rowindex,6);
                                myTable.setValueAt("外帶",rowindex,5);
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
                                myTable.setValueAt(coldhotstring[i],rowindex,3);     //顯示 冷熱
                         }
                    
             }
         }    
      };
   	public ActionListener ProcesssweetBtn = new ActionListener(){
        public void actionPerformed(ActionEvent e){
             for(int i=0; i<sweetbtn.length; i++){
                        if( e.getSource() == sweetbtn[i] ){
                                myTable.setValueAt(sweetstring[i],rowindex,2);     //顯示 甜度
                         }                    
             }
         }    
     };
     public ActionListener ProcesswayBtn = new ActionListener(){     //用餐別
            public void actionPerformed(ActionEvent e){                 
                  if( e.getSource() == midbtn[0][0] ){
                        myTable.setValueAt("內用",rowindex,5);                         
                  }
                  if( e.getSource() == midbtn[0][1] ){
                      myTable.setValueAt("外帶",rowindex,5);       
                  }
                  if( e.getSource() == midbtn[0][2] ){
                      myTable.setValueAt("外送",rowindex,5);     
                  }
                  if( e.getSource() == midbtn[1][0]){     //清空此筆
                	  for (int i=0;i<table_title.length;i++){
                		  myTable.setValueAt("",rowindex,i);
                	  }
                	  n = 0;
                	  amt = 0 ;
                	  amf = 0;
                  }
                  if( e.getSource() == midbtn[1][1]){   //清空整頁
                	  int ans = JOptionPane.showConfirmDialog(null,"確定要全部清空點餐項目?","再確認",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                
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
                        	 myTable.setValueAt("" + amt ,rowindex,1);                    //顯示[數量]
                        	 n++;
                        	 }
                              if (myTable.getValueAt(rowindex,0) != "" && myTable.getValueAt(rowindex,0) != null){ 
                         
                                  int price = Integer.parseInt((String)myTable.getValueAt(rowindex,4));   //抓取[單價]字串，再轉為整數int
                                  //int amount = Integer.parseInt(digitBtnString[i][j]);                    //抓取[數量]字串，再轉為整數int
                                  myTable.setValueAt(String.valueOf(price*amt),rowindex,6);            //將(單價x數量)的整數值轉為字串並顯示     
                           	   
                                  }
                         }
                     }
              }
              }
          }    
    };
     
     public ActionListener ProcessCashBtn = new ActionListener(){
    	 public void actionPerformed(ActionEvent e){
    		// 結帳
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
           	  //-----防止 : 多輸入新增一筆資料卻無輸入資料-------------
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
                          //---  使用者按下結帳按紐時 ，  輸出金額歸  0 ，輸出欄位清空  ， 進位歸  0 
                          t = 0;                          
                          input.setText("");
                          amount = 0;
                          //---
                          n = 0 ;
                          amf = 0 ;
                          amt = 0;
           	        }
           	        else{   
           	        	JOptionPane.showMessageDialog(null,"輸入未完成!!","輸入錯誤",JOptionPane.INFORMATION_MESSAGE);  
           	        }       		     
        	 }
    	 }
     };
    
     public ActionListener ProcessNextBtn = new ActionListener(){   //下一筆
         public void actionPerformed(ActionEvent e){
        	 // 下一筆
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
        	    	  JOptionPane.showMessageDialog(null,"資料不能為空!!","錯誤",JOptionPane.INFORMATION_MESSAGE);
        	      }
        	    }
        	} 
          	else{
        		JOptionPane.showMessageDialog(null,"無法繼續增加!!","錯誤",JOptionPane.INFORMATION_MESSAGE);
        	}
          }
    };
    
  
    
    //----------------------------------
     static void setTime()  //設定系統時間
    {
        calendar.setTimeInMillis( System.currentTimeMillis() );
    }
    
    static public int getYear()  //取得年
    {
        return calendar.get(Calendar.YEAR);
    }
    
    static public int getMonth()  //取得月
    {
        return (calendar.get(Calendar.MONTH)+1);
    }
    
    static public int getDate()  //取得日
    {
        return calendar.get(Calendar.DATE);
    }
    
    static public int getHour()  //取得小時
    {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }
    
    static public int getMinute()  //取得分鐘
    {
        return calendar.get(Calendar.MINUTE);
    }
        
    static public int getSecond()  //取得秒數
    {
        return calendar.get(Calendar.SECOND);
    }
    
    static public void showCurrentTime()  //顯示目前時間
    {
        while(true)
        {
            setTime();            
            timeprint.setText("<html>"+getYear()+"年"+getMonth()+"月"+getDate()+"日"+"<br>"+getHour()+"時"+getMinute()+"分"+getSecond()+"秒"+"<html>");
        }
    }   
    //---------------------------------------------------------

    	 
        int t = 0;     //此變數用於限制使用者輸入過長的數字
    	int re = 0 ;	 //紀錄個位數
    	int amount = 0 ;  //付款金額
    		
        public ActionListener Processdigbtn = new ActionListener(){
            public void actionPerformed(ActionEvent e){
          	  
                for(int i=0;i<digbtn.length;i++){          //數字鍵
                	for(int j=0;j<digbtn[0].length;j++){
                		if (e.getSource() == digbtn[i][j]){
                			if (e.getSource() != digbtn[0][3] && e.getSource() != digbtn[2][3] ){
                				if (t < 8){    //限制8位數
                			       amount =  amount * 10 ;	
                        		   int re = Integer.parseInt(digstr[i][j]); 
                			       amount  = amount + re ;
                			       input.setText(" "+amount);
                			            if (amount > 0 ){
                				             t++ ;
                			            }                			
                				}
                			}      
                			if (e.getSource() == digbtn[0][3]){    //減一位數
                				amount = amount / 10 ;
                				if ( t > 0 ){
                				t = t - 1;
                				}
                				input.setText(" "+amount);
                			}
                		    if (e.getSource() == digbtn[2][3]){      //歸零鍵
                		    	input.setText("");
                		    	output.setText("");
                		    	re = 0;     
                		    	amount = 0;   
                		    	t = 0 ;   //總位數歸0
                		    }
                		}
                	}
                }
          	  }
        
        };
        
        static int cashdel = 0 ; //傳值用的變數       
        static String cth_nday = "";       //紀錄最後一筆資料的日期 
        int ntd = 0; // 顯示找零
        boolean tes_ntd = false ;   //防止未按收銀而結束頁面
        public ActionListener Processcash = new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		if (e.getSource() == b3 ){
        			ntd = amount - x ;
        			if (ntd >= 0){
        				output.setText(" " + ntd);
        				tes_ntd = true ;
        			}
        			else{
        				JOptionPane.showMessageDialog(null,"金額錯誤","結帳錯誤",JOptionPane.INFORMATION_MESSAGE);
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
        			    	//對資料庫傳入數值，呼叫pos_revenue_diliver的insert_into_revenue
        			    	p_dil.insert_into_revenue((String)myTable.getValueAt(0,0),
        			    			Integer.valueOf((String)myTable.getValueAt(0,1)),
        			    			Integer.valueOf((String)myTable.getValueAt(0,6)));
        			    	
        			    }
        			    if ( rowindex !=0 ){
        			    	//對資料庫傳入數值，呼叫pos_revenue_diliver的insert_into_revenue
        			    	for (int i=0;i<rowindex+1;i++){
        			    		p_dil.insert_into_revenue((String)myTable.getValueAt(i,0),
            			    			Integer.valueOf((String)myTable.getValueAt(i,1)),
            			    			Integer.valueOf((String)myTable.getValueAt(i,6)));
        			    	}        			    	
        			    }        			    
                        for(int i=0; i<table_data.length; i++)  //清空表格
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
                        	 JOptionPane.showMessageDialog(null,"權限 : c");
                        	 n_time = ch_time();
                        	 n2_time = n_time;
                        }
        				*/
        			    rowindex = 0;
        			    dot.setBounds(0,( (rowindex+1) * 35),9,35);
        			}
        			else{
        				JOptionPane.showMessageDialog(null,"請先按收銀按鈕後再確認","結帳錯誤",JOptionPane.INFORMATION_MESSAGE);
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
        
}  //pos_order_system 結束

