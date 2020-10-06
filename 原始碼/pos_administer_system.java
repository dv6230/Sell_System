import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.embed.swing.JFXPanel;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;



class pos_administer_system {
	
	public static void main(String[] args) {
		pos_administer_system a = new pos_administer_system();
		a.face2.setVisible(true);
	}
	
	JFrame face2 = new JFrame(); // 後台系統視窗介面命名為 face2

	static pos_item_diliver idv = new pos_item_diliver(); // 更動庫存時，上傳到資料庫
	static pos_catch_item cai = new pos_catch_item(); // 開啟檔案時，從資料庫抓取檔案
	item_count c = new item_count(); // 輸入庫存的視窗
	static pos_catch_income cth_in = new pos_catch_income();

	JPanel menu = new JPanel(); // 選單列
	JPanel p11 = new JPanel(); // 庫存管理
	JPanel p12 = new JPanel(); // 銷售統計
	JPanel p13 = new JPanel(); // 金額統計
	JPanel partmain = new JPanel(); // 底部

	JButton back_order_btn = new JButton("返回點餐");
	JButton stockbtn = new JButton("庫存管理");
	JButton sellbtn = new JButton("銷售統計");
	JButton cashbtn = new JButton("營收統計");

	// 預設庫存內容物
	static String[] part_a = { "紅茶(袋)", "綠茶(袋)", "咖啡(袋)", "抹茶(袋)", "烏龍(袋)", "普洱(袋)" };
	static String[] part_b = { "果糖(罐)", "黑糖(包)", "焦糖(包)", "蜂蜜(罐)" };
	static String[] part_c = { "生薑(包)", "奶精(包)", "珍珠(罐)", "濃縮檸檬(罐)", "仙草(包)", "堅果(包)", "桂圓(包)" };

	JLabel[] gpa1 = new JLabel[6];
	JLabel[] gpa2 = new JLabel[4];
	JLabel[] gpa3 = new JLabel[7];

	// a 字體設定
	Font a = new Font("微軟正黑體", Font.PLAIN, 36);

	// ----------p11內容物件--------------
	JLabel title1 = new JLabel("庫存管理");
	JLabel title1_1 = new JLabel(" ");

	JButton addbtn = new JButton("新增");
	JButton checkbtn = new JButton("管理");

	JPanel itemgroup1 = new JPanel();
	JPanel itemgroup2 = new JPanel();
	JPanel itemgroup3 = new JPanel();

	JLabel itemch1 = new JLabel("茶類");
	JLabel itemch2 = new JLabel("醣類");
	JLabel itemch3 = new JLabel("其他");

	JButton[] itemman1 = new JButton[6];
	JButton[] itemman2 = new JButton[4];
	JButton[] itemman3 = new JButton[7];

	JSeparator[] bline1 = new JSeparator[5];
	JSeparator[] bline2 = new JSeparator[3];
	JSeparator[] bline3 = new JSeparator[6];

	static JLabel[] itempr1 = new JLabel[6];
	static JLabel[] itempr2 = new JLabel[4];
	static JLabel[] itempr3 = new JLabel[7];

	JLabel[] item_h = new JLabel[7]; // "剩餘數量"的文字陣列

	static int[] item_1 = { 0, 0, 0, 0, 0, 0 }; // 用陣列暫存系統內的庫存
	static int[] item_2 = { 0, 0, 0, 0 };
	static int[] item_3 = { 0, 0, 0, 0, 0, 0, 0 };

	// ----------------------------------
	// ----------p12內容物件---------------
	JLabel title2 = new JLabel("銷售統計");
	JLabel sell_1 = new JLabel("本月銷售排行");
	JPanel bar1 = new JPanel();
	JLabel[] ctbar = new JLabel[10]; // 排行數
	static JLabel[] ctbarit = new JLabel[10]; // 排行:名稱
	static JLabel[] ctbarnu = new JLabel[10]; // 排行:數量
	static JPanel mb12 = new JPanel();

	// ----------------------------------
	// ----------p13內容物件---------------

	JLabel title3 = new JLabel("營收統計");
	JLabel m1 = new JLabel("今日營收");
	JLabel m2 = new JLabel("本月營收");
	static JTextField amount_td = new JTextField(); // 日營收
	static JTextField amount_tm = new JTextField(); // 月營收
	static JFXPanel mp = new JFXPanel(); // 折線圖表專用 panel
	static JPanel mb13 = new JPanel(); // 頁面底色

	pos_administer_system() {

		date_current();

		// -------------主選單地區p1-----------------
		back_order_btn.setBounds(0, 650, 250, 70);
		back_order_btn.setForeground(new Color(255, 255, 255));
		back_order_btn.setBackground(new Color(70, 70, 70));
		back_order_btn.setFont(new Font("微軟正黑體", Font.PLAIN, 26));
		back_order_btn.setBorder(null);
		back_order_btn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				mse(evt);
			}
		});
		back_order_btn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				mso(evt);
			}
		});
		menu.add(back_order_btn);

		stockbtn.setBounds(0, 200, 250, 70); // 庫存管理按鈕
		stockbtn.setFont(new Font("微軟正黑體", Font.PLAIN, 26));
		stockbtn.setForeground(new Color(255, 255, 255));
		stockbtn.setBackground(new Color(70, 70, 70));
		stockbtn.setBorder(null);
		stockbtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				mse(evt);
			}
		});
		stockbtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				mso(evt);
			}
		});
		stockbtn.addActionListener(changepage);
		menu.add(stockbtn);

		sellbtn.setBounds(0, 280, 250, 70); // 庫存管理按鈕
		sellbtn.setFont(new Font("微軟正黑體", Font.PLAIN, 26));
		sellbtn.setForeground(new Color(255, 255, 255));
		sellbtn.setBackground(new Color(70, 70, 70));
		sellbtn.setBorder(null);
		sellbtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				mse(evt);
			}
		});
		sellbtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				mso(evt);
			}
		});
		sellbtn.addActionListener(changepage);
		menu.add(sellbtn);

		cashbtn.setBounds(0, 360, 250, 70); // 庫存管理按鈕
		cashbtn.setFont(new Font("微軟正黑體", Font.PLAIN, 26));
		cashbtn.setForeground(new Color(255, 255, 255));
		cashbtn.setBackground(new Color(70, 70, 70));
		cashbtn.setBorder(null);
		cashbtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				mse(evt);
			}
		});
		cashbtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				mso(evt);
			}
		});
		cashbtn.addActionListener(changepage);
		menu.add(cashbtn);

		// ----------------------------------------
		// ----------P11 內容物
		title1.setBounds(50, 35, 150, 70);
		title1.setFont(a);
		title1.setForeground(Color.BLACK);
		p11.add(title1);

		// --茶包區
		itemgroup1.setBounds(0, 190, 980, 715);
		itemgroup1.setLayout(null);
		itemgroup1.setBackground(Color.white);
		p11.add(itemgroup1);

		for (int i = 0; i < part_a.length; i++) {
			gpa1[i] = new JLabel(part_a[i]);
			gpa1[i].setLayout(null);
			gpa1[i].setBounds(140, 50 + (i * 70), 250, 60);
			gpa1[i].setFont(new Font("微軟正黑體", Font.PLAIN, 22));
			gpa1[i].setBackground(Color.white);
			gpa1[i].setOpaque(true);
			itemgroup1.add(gpa1[i]);
		}

		for (int i = 0; i < itemman1.length; i++) {
			itemman1[i] = new JButton("管理");
			itemman1[i].setBounds(710, 55 + (i * 70), 95, 50);
			itemman1[i].setFont(new Font("微軟正黑體", Font.PLAIN, 20));
			itemman1[i].setBackground(new Color(73, 212, 255));
			itemman1[i].setBorder(null);
			itemman1[i].addActionListener(pm1);
			itemgroup1.add(itemman1[i]);
		}

		for (int i = 0; i < bline1.length; i++) {
			bline1[i] = new JSeparator();
			bline1[i].setBounds(140, 70 + 45 + (i * 70), 665, 50);
			itemgroup1.add(bline1[i]);
		}

		for (int i = 0; i < itempr1.length; i++) {
			itempr1[i] = new JLabel("");
			itempr1[i].setFont(new Font("微軟正黑體", Font.PLAIN, 20));
			itempr1[i].setText("" + item_1[i]);
			itempr1[i].setBounds(570, 50 + (i * 70), 70, 60);
			itempr1[i].setOpaque(false);
			itempr1[i].setBackground(Color.yellow);
			itempr1[i].setHorizontalAlignment(SwingConstants.RIGHT);
			itemgroup1.add(itempr1[i]);
		}

		for (int i = 0; i < itempr1.length; i++) {
			item_h[i] = new JLabel("剩餘數量");
			item_h[i].setFont(new Font("微軟正黑體", Font.PLAIN, 20));
			item_h[i].setBounds(450, 50 + (i * 70), 90, 60);
			itemgroup1.add(item_h[i]);
		}

		// --醣類區
		itemgroup2.setBounds(0, 190, 980, 715);
		itemgroup2.setLayout(null);
		itemgroup2.setBackground(Color.white);
		itemgroup2.setVisible(false);
		p11.add(itemgroup2);

		for (int i = 0; i < part_b.length; i++) {
			gpa2[i] = new JLabel(part_b[i]);
			gpa2[i].setLayout(null);
			gpa2[i].setBounds(140, 50 + (i * 70), 250, 60);
			gpa2[i].setFont(new Font("微軟正黑體", Font.PLAIN, 22));
			gpa2[i].setBackground(Color.white);
			gpa2[i].setOpaque(true);
			itemgroup2.add(gpa2[i]);
		}

		for (int i = 0; i < itemman2.length; i++) {
			itemman2[i] = new JButton("管理");
			itemman2[i].setBounds(710, 55 + (i * 70), 95, 50);
			itemman2[i].setFont(new Font("微軟正黑體", Font.PLAIN, 20));
			itemman2[i].setBackground(new Color(73, 212, 255));
			itemman2[i].setBorder(null);
			itemman2[i].addActionListener(pm2);
			itemgroup2.add(itemman2[i]);
		}

		for (int i = 0; i < bline2.length; i++) {
			bline2[i] = new JSeparator();
			bline2[i].setBounds(140, 70 + 45 + (i * 70), 665, 50);
			itemgroup2.add(bline2[i]);
		}

		for (int i = 0; i < itempr2.length; i++) {
			itempr2[i] = new JLabel("");
			itempr2[i].setFont(new Font("微軟正黑體", Font.PLAIN, 20));
			itempr2[i].setText("" + item_2[i]);
			itempr2[i].setBounds(570, 50 + (i * 70), 70, 60);
			itempr2[i].setBackground(Color.yellow);
			itempr2[i].setHorizontalAlignment(SwingConstants.RIGHT);
			itemgroup2.add(itempr2[i]);
		}

		for (int i = 0; i < itempr2.length; i++) {
			item_h[i] = new JLabel("剩餘數量");
			item_h[i].setFont(new Font("微軟正黑體", Font.PLAIN, 20));
			item_h[i].setBounds(450, 50 + (i * 70), 90, 60);
			itemgroup2.add(item_h[i]);
		}

		// --其他區
		itemgroup3.setBounds(0, 190, 980, 715);
		itemgroup3.setLayout(null);
		itemgroup3.setBackground(Color.white);
		itemgroup3.setVisible(false);
		p11.add(itemgroup3);

		for (int i = 0; i < part_c.length; i++) {
			gpa3[i] = new JLabel(part_c[i]);
			gpa3[i].setLayout(null);
			gpa3[i].setBounds(140, 50 + (i * 70), 250, 60);
			gpa3[i].setFont(new Font("微軟正黑體", Font.PLAIN, 22));
			gpa3[i].setBackground(Color.white);
			gpa3[i].setOpaque(true);
			itemgroup3.add(gpa3[i]);
		}

		for (int i = 0; i < itemman3.length; i++) {
			itemman3[i] = new JButton("管理");
			itemman3[i].setBounds(710, 55 + (i * 70), 95, 50);
			itemman3[i].setFont(new Font("微軟正黑體", Font.PLAIN, 20));
			itemman3[i].setBackground(new Color(73, 212, 255));
			itemman3[i].setBorder(null);
			itemman3[i].addActionListener(pm3);
			itemgroup3.add(itemman3[i]);
		}

		for (int i = 0; i < bline3.length; i++) {
			bline3[i] = new JSeparator();
			bline3[i].setBounds(140, 70 + 45 + (i * 70), 665, 50);
			itemgroup3.add(bline3[i]);
		}

		for (int i = 0; i < itempr3.length; i++) {
			itempr3[i] = new JLabel("");
			itempr3[i].setFont(new Font("微軟正黑體", Font.PLAIN, 20));
			itempr3[i].setText("" + item_3[i]);
			itempr3[i].setBounds(570, 50 + (i * 70), 70, 60);
			itempr3[i].setBackground(Color.yellow);
			itempr3[i].setHorizontalAlignment(SwingConstants.RIGHT);
			itemgroup3.add(itempr3[i]);
		}

		for (int i = 0; i < itempr3.length; i++) {
			item_h[i] = new JLabel("剩餘數量");
			item_h[i].setFont(new Font("微軟正黑體", Font.PLAIN, 20));
			item_h[i].setBounds(450, 50 + (i * 70), 90, 60);
			itemgroup3.add(item_h[i]);
		}

		itemch1.setBounds(180, 140, 180, 50);
		itemch1.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		// itemch1.setBorder(BorderFactory.createLineBorder(new Color(0,0,0),2));
		itemch1.setBackground(new Color(255, 229, 86));
		itemch1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		itemch1.setOpaque(true);
		itemch1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				mitem(evt);
			}
		});
		itemch1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				mse(evt);
			}
		});
		itemch1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				mso(evt);
			}
		});
		p11.add(itemch1);

		itemch2.setBounds(380, 140, 180, 50);
		itemch2.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		// itemch2.setBorder(BorderFactory.createLineBorder(new Color(0,0,0),2));
		itemch2.setBackground(new Color(255, 229, 86));
		itemch2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		itemch2.setOpaque(true);
		itemch2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				mitem(evt);
			}
		});
		itemch2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				mse(evt);
			}
		});
		itemch2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				mso(evt);
			}
		});
		p11.add(itemch2);

		itemch3.setBounds(580, 140, 180, 50);
		itemch3.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		// itemch3.setBorder(BorderFactory.createLineBorder(new Color(0,0,0),2));
		itemch3.setBackground(new Color(255, 229, 86));
		itemch3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		itemch3.setOpaque(true);
		itemch3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				mitem(evt);
			}
		});
		itemch3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				mse(evt);
			}
		});
		itemch3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent evt) {
				mso(evt);
			}
		});
		p11.add(itemch3);

		// ----------------------------------------
		// ----------P12 內容物 ----------------------
		title2.setBounds(50, 25, 150, 70);
		title2.setFont(a);
		title2.setForeground(Color.black);
		p12.add(title2);
		sell_1.setBounds(270 - (200 / 2) + 10, 10, 200, 70);
		sell_1.setFont(new Font("微軟正黑體", Font.PLAIN, 28));
		mb12.add(sell_1);
		bar1.setBounds(70, 70, 400, 500);
		bar1.setLayout(null);
		bar1.setBackground(new Color(255, 201, 14));
		mb12.add(bar1);

		for (int i = 0; i < ctbar.length; i++) {
			ctbar[i] = new JLabel(i + 1 + ".");
			ctbar[i].setFont(new Font("微軟正黑體", Font.PLAIN, 24));
			ctbar[i].setBounds(40, 20 + (i * 45), 40, 40);
			bar1.add(ctbar[i]);
		}
		for (int i = 0; i < ctbarit.length; i++) {
			ctbarit[i] = new JLabel("");
			ctbarit[i].setFont(new Font("微軟正黑體", Font.PLAIN, 24));
			ctbarit[i].setBounds(120, 20 + (i * 45), 120, 40);
			bar1.add(ctbarit[i]);
		}
		for (int i = 0; i < ctbarit.length; i++) {
			ctbarnu[i] = new JLabel("");
			ctbarnu[i].setFont(new Font("微軟正黑體", Font.PLAIN, 24));
			ctbarnu[i].setBounds(120 + 130, 20 + (i * 45), 70, 40);
			ctbarnu[i].setHorizontalAlignment(SwingConstants.RIGHT);
			bar1.add(ctbarnu[i]);
		}
		mb12.setBackground(Color.WHITE);
		mb12.add(bar1);
		mb12.setLayout(null);
		mb12.setBounds(0, 190, 980, (850 - 190));
		p12.add(mb12);

		// ----------------------------------------
		// ----------P13 內容物 ----------------------
		title3.setBounds(50, 35, 150, 70);
		title3.setFont(a);
		title3.setForeground(new Color(255, 255, 255));
		p13.add(title3);
		m1.setBounds(140, 10, 210, 70);
		m1.setFont(new Font("微軟正黑體", Font.PLAIN, 28));
		mb13.add(m1);
		amount_td.setBounds(140, 90, 200, 60);
		amount_td.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		amount_td.setHorizontalAlignment(SwingConstants.RIGHT);
		amount_td.setEditable(false);
		amount_td.setBorder(null);
		mb13.add(amount_td);
		m2.setBounds(140 + 250, 10, 210, 70);
		m2.setFont(new Font("微軟正黑體", Font.PLAIN, 28));
		mb13.add(m2);
		amount_tm.setBounds(140 + 250, 90, 200, 60);
		amount_tm.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		amount_tm.setHorizontalAlignment(SwingConstants.RIGHT);
		amount_tm.setEditable(false);
		amount_tm.setBorder(null);
		mb13.add(amount_tm);
		mb13.setLayout(null);
		mb13.setBackground(Color.white);
		mb13.setBounds(0, 190, 980, (850 - 190));
		p13.add(mb13);

		// ----------------------------------------

		menu.setBounds(0, 0, 250, 850);
		menu.setBackground(new Color(70, 70, 70));// 90,90,90
		menu.setLayout(null);
		face2.add(menu);

		p11.setBounds(250, 0, 980, 850); // 次要畫面大小與位置
		p11.setBackground(new Color(255, 161, 0));
		p11.setLayout(null);
		face2.add(p11);

		p12.setBounds(250, 0, 980, 850);
		p12.setBackground(new Color(46, 222, 234));
		p12.setLayout(null);
		face2.add(p12);
		p12.setVisible(false);

		p13.setBounds(250, 0, 980, 850);
		p13.setBackground(new Color(56, 127, 247));
		p13.setLayout(null);
		face2.add(p13);
		p13.setVisible(false);

		face2.setTitle("後台管理");
		face2.setLayout(null);
		face2.setLocation(350, 120);
		face2.setSize(1200, 850);
		face2.setVisible(false); // 預設關閉
		face2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		linech();

	}

	// ------------------折線圖-----------------------------

	static XYChart.Series<String, Number> series_1;
	static CategoryAxis xAxis = new CategoryAxis(); // static NumberAxis xAxis = new NumberAxis(); static
	static NumberAxis yAxis = new NumberAxis();
	static LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);

	static public void linech() {
		series_1 = new XYChart.Series<String, Number>();
		lineChart.setTitle("每日銷售概況");
		series_1.setName("銷售曲線");
		xAxis.setLabel("日期");
		yAxis.setLabel("金額");
		series_1.getData().add(new XYChart.Data("0", 0));
		series_1.getData().add(new XYChart.Data("1", 0));
		series_1.getData().add(new XYChart.Data("2", 0));
		series_1.getData().add(new XYChart.Data("3", 0));
		series_1.getData().add(new XYChart.Data("4", 0));
		series_1.getData().add(new XYChart.Data("5", 0));
		series_1.getData().add(new XYChart.Data("6", 0));
		series_1.getData().add(new XYChart.Data("7", 0));
		series_1.getData().add(new XYChart.Data("8", 0));
		series_1.getData().add(new XYChart.Data("9", 0));
		series_1.getData().add(new XYChart.Data("10", 0));
		series_1.getData().add(new XYChart.Data("11", 0));
		series_1.getData().add(new XYChart.Data("12", 0));
		series_1.getData().add(new XYChart.Data("13", 0));
		series_1.getData().add(new XYChart.Data("14", 0));
		series_1.getData().add(new XYChart.Data("15", 0));

		Scene scene = new Scene(lineChart);
		lineChart.getData().add(series_1);
		mp.setScene(scene);
		mp.setBounds(50, 200, 800, 350);
		mb13.add(mp);

	}

	// code 237

	public static void shiftSeriesYValue(XYChart.Series series, int newValue, boolean tf, String day) {
		if (tf == true) { // 新增
			int numOfPoint = series.getData().size();
			for (int i = 0; i < numOfPoint - 1; i++) {
				XYChart.Data<String, Number> ShiftDataUp = (XYChart.Data<String, Number>) series.getData().get(i + 1);
				Number shiftValue = ShiftDataUp.getYValue();
				String shiftstring = ShiftDataUp.getXValue();
				XYChart.Data<String, Number> ShiftDataDn = (XYChart.Data<String, Number>) series.getData().get(i);
				ShiftDataDn.setYValue(shiftValue);
				ShiftDataDn.setXValue(shiftstring);
			}
			XYChart.Data<String, Number> lastData = (XYChart.Data<String, Number>) series.getData().get(numOfPoint - 1);
			lastData.setYValue(newValue);
			lastData.setXValue(day);
		}
		if (tf == false) { // 更改當日數值
			int numOfPoint1 = series.getData().size();
			XYChart.Data<String, Number> lastData1 = (XYChart.Data<String, Number>) series.getData()
					.get(numOfPoint1 - 1);
			lastData1.setYValue(newValue);
			lastData1.setXValue(day);
		}
	}

	// -----------P11的按鈕----------------
	private void mitem(java.awt.event.MouseEvent evt) {
		// 偵測按鈕並切換葉面
		if (evt.getSource() == itemch1) {
			itemgroup1.setVisible(true);
			itemgroup2.setVisible(false);
			itemgroup3.setVisible(false);
		}
		if (evt.getSource() == itemch2) {
			itemgroup1.setVisible(false);
			itemgroup2.setVisible(true);
			itemgroup3.setVisible(false);
		}
		if (evt.getSource() == itemch3) {
			itemgroup1.setVisible(false);
			itemgroup2.setVisible(false);
			itemgroup3.setVisible(true);
		}
	}

	// ------group1的管理按鈕----------------
	public ActionListener pm1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < itemman1.length; i++) {
				if (e.getSource() == itemman1[i]) {
					if (item_count.face.isVisible() == false) {
						item_count.cal(i, 1);
					}
				}
			}
		}
	};
	// ------group2的管理按鈕----------------
	public ActionListener pm2 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < itemman2.length; i++) {
				if (e.getSource() == itemman2[i]) {
					if (item_count.face.isVisible() == false) {
						item_count.cal(i, 2);
					}
				}
			}
		}
	};
	// ------group3的管理按鈕----------------
	public ActionListener pm3 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < itemman3.length; i++) {
				if (e.getSource() == itemman3[i]) {
					if (item_count.face.isVisible() == false) {
						item_count.cal(i, 3);
					}
				}
			}
		}
	};

	// ----------按鈕特效-------------------
	private void mse(java.awt.event.MouseEvent evt) {
		if (evt.getSource() == stockbtn) {
			stockbtn.setBackground(new Color(145, 145, 145));
		}
		if (evt.getSource() == back_order_btn) {
			back_order_btn.setBackground(new Color(145, 145, 145));
		}
		if (evt.getSource() == sellbtn) {
			sellbtn.setBackground(new Color(145, 145, 145));
		}
		if (evt.getSource() == cashbtn) {
			cashbtn.setBackground(new Color(145, 145, 145));
		}
		if (evt.getSource() == itemch1) {
			itemch1.setBackground(new Color(255, 182, 56));
		}
		if (evt.getSource() == itemch2) {
			itemch2.setBackground(new Color(255, 182, 56));
		}
		if (evt.getSource() == itemch3) {
			itemch3.setBackground(new Color(255, 182, 56));
		}
	};

	private void mso(java.awt.event.MouseEvent evt) {
		if (evt.getSource() == stockbtn) {
			stockbtn.setBackground(new Color(70, 70, 70));
		}
		if (evt.getSource() == back_order_btn) {
			back_order_btn.setBackground(new Color(70, 70, 70));
		}
		if (evt.getSource() == sellbtn) {
			sellbtn.setBackground(new Color(70, 70, 70));
		}
		if (evt.getSource() == cashbtn) {
			cashbtn.setBackground(new Color(70, 70, 70));
		}

		if (evt.getSource() == itemch1) {
			itemch1.setBackground(new Color(255, 229, 86));
		}
		if (evt.getSource() == itemch2) {
			itemch2.setBackground(new Color(255, 229, 86));
		}
		if (evt.getSource() == itemch3) {
			itemch3.setBackground(new Color(255, 229, 86));
		}

	};

	public ActionListener changepage = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == stockbtn) {
				p11.setVisible(true);
				p12.setVisible(false);
				p13.setVisible(false);
			}
			if (e.getSource() == sellbtn) {
				p11.setVisible(false);
				p12.setVisible(true);
				p13.setVisible(false);
			}
			if (e.getSource() == cashbtn) {
				p11.setVisible(false);
				p12.setVisible(false);
				p13.setVisible(true);
			}
		}
	}; // 按鈕特效結束-------------------------------------------

	// 呼叫此方法可以回傳月營收的sql碼
	String getdatacode(String a) {
		String re_cth_m = "select sum(income) from revenue_detail where date like '";
		String re_date = a + "%'";
		return ("" + re_cth_m + re_date);
	}

	String time_conbine_month() {
		String d1 = "";
		if (pos_order_system.getMonth() < 10) {
			d1 = "0" + Integer.toString(pos_order_system.getMonth());
		} else {
			d1 = Integer.toString(pos_order_system.getMonth());
		}
		return (Integer.toString(pos_order_system.getYear()) + "/" + d1);
	}
	// 月營收sql碼 結束---------------------------------

	// 數據轉成折線圖的sql碼
	static String getdatacode2() {
		String re_cth_m = "SELECT DATE, SUM(income) FROM revenue_detail GROUP BY DATE LIMIT 15";
		return (re_cth_m);
	}
	// ---------------------------------------------

	// 接收數值
	public static void s1(int a, int b) { // a:物品編號 b:物品數量
		// item_1[a] = item_1[a] + b ;
		idv.insert_into_item1((String) part_a[a], Integer.valueOf(b), a);
	}

	public static void s2(int a, int b) {
		// item_2[a] = item_2[a] + b ;
		idv.insert_into_item2((String) part_b[a], Integer.valueOf(b), a);
	}

	public static void s3(int a, int b) {
		// item_3[a] = item_3[a] + b ;
		idv.insert_into_item3((String) part_c[a], Integer.valueOf(b), a);
	}

	static int dm, dd;

	static void date_current() {
		dm = pos_order_system.getMonth();
		dd = pos_order_system.getDate();
	}

	// ---------從資料庫抓取檔案-----------------
	static public void cth_du() {
		cai.catch_item1();
		cai.catch_item2();
		cai.catch_item3();
	}

	public static void cth_pr(int[] a, String pr) {
		if (pr == "a") {
			for (int i = 0; i < part_a.length; i++) {
				itempr1[i].setText("" + a[i]);
			}
		}
		if (pr == "b") {
			for (int i = 0; i < part_b.length; i++) {
				itempr2[i].setText("" + a[i]);
			}
		}
		if (pr == "c") {
			for (int i = 0; i < part_c.length; i++) {
				itempr3[i].setText("" + a[i]);
			}
		}
	} // end

} // pos_administer_system 結束
