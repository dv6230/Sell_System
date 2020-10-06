import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.util.*;

class pos_mode_system{
	
	pos_login_system userlogin = new pos_login_system();
	pos_order_system userorder = new pos_order_system();
	pos_administer_system usermanage = new pos_administer_system();
	pos_login2_system userlogin2 = new pos_login2_system();		
	pos_database database = new pos_database();
	pos_database_conver1 dataconver = new pos_database_conver1();	
	pos_catch_income incomepr = new pos_catch_income();
	pos_sell_desc seldes = new pos_sell_desc();  //排序
	
	
	pos_mode_system(){
		
		 userlogin.f.setVisible(true);    //預設userlogin登錄模組的視窗f要顯示
         userorder.face.setVisible(false);     //預設userorder前台點餐模組的視窗f隱藏
         usermanage.face2.setVisible(false);
         userlogin2.f2.setVisible(false);
         
         userlogin.enterBtn.addActionListener(ProcessSwitchInterface);    //將myLogin登錄模組的[進入點餐]按鈕註冊到事件傾聽器程式
         usermanage.back_order_btn.addActionListener(ProcessSwitchInterface);
         userorder.managebtn.addActionListener(ProcessSwitchInterface);
         userorder.logoutbtn.addActionListener(ProcessSwitchInterface);
         userlogin2.enterBtn.addActionListener(ProcessSwitchInterface);
         userlogin2.backbtn.addActionListener(ProcessSwitchInterface);
         
	}
	
	//---------------------------------
	//事件傾聽器:處理切換畫面
	public ActionListener ProcessSwitchInterface = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//------登入介面----------------------------
			if (e.getSource() == userlogin.enterBtn){
				if(userlogin.state == 0 && userlogin.acntTxtFd.getText().trim().equals("1234") && userlogin.pwdTxtFd.getText().trim().equals("1234")){
					userlogin.inter_clean();					
					userlogin.f.setVisible(false);					
					usermanage.face2.setVisible(false);
					userlogin2.f2.setVisible(false);	
					userorder.face.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null,"帳號密碼錯誤，請重新操作?","帳號密碼檢查結果",JOptionPane.INFORMATION_MESSAGE);
				}
				userlogin.acntTxtFd.setText("");
				userlogin.pwdTxtFd.setText("");
				userlogin.inter_clean();
			}
			//-----------------------------------------
			//---------點餐轉到後台的身分驗證----------------
			if (e.getSource() == userlogin2.enterBtn){
				if(userlogin2.acntTxtFd.getText().trim().equals("1234") && userlogin2.pwdTxtFd.getText().trim().equals("1234")){
					userlogin.f.setVisible(false);
					userorder.face.setVisible(false);
					usermanage.face2.setVisible(true);
					userlogin2.f2.setVisible(false);
					userlogin2.re_clean();					
				}
				else{
					
					JOptionPane.showMessageDialog(null,"帳號密碼錯誤，請重新輸入?","錯誤",JOptionPane.INFORMATION_MESSAGE);
				}
				userlogin2.acntTxtFd.setText("");
				userlogin2.pwdTxtFd.setText("");
				userlogin2.re_clean();
			}
			//-----------------------------------------
			//---------後台的返回按鈕----------------------
			if (e.getSource() == usermanage.back_order_btn){
				userlogin.f.setVisible(false);
				userorder.face.setVisible(true);
				usermanage.face2.setVisible(false);
				userlogin2.f2.setVisible(false);				
			}
			//-----------------------------------------
			//-----------點餐頁的後台按鈕------------------
			if (e.getSource() == userorder.managebtn){
				userlogin.f.setVisible(false);				
				usermanage.face2.setVisible(false);
				userorder.face.setVisible(false);
				userlogin2.f2.setVisible(true);
				usermanage.cth_in.catch_sell((String)pos_mode_system.date_conbine());
				usermanage.cth_in.catch_sell_m(
						(String)usermanage.getdatacode(usermanage.time_conbine_month()));
				pos_sell_desc.catch_sell();//銷售排序				
			}
			//------------------------------------------
			//-----------點餐頁的登出按鈕-------------------
			if (e.getSource() == userorder.logoutbtn){	
				int ans = JOptionPane.showConfirmDialog(null,"確定要登出?","登出",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if (ans == JOptionPane.YES_OPTION){
				userlogin.f.setVisible(true);
				usermanage.face2.setVisible(false);
				userorder.face.setVisible(false);
				userlogin2.f2.setVisible(false);
				}							
			}
			//------------------------------------------
			//-----------第二登入介面返回按鈕----------------
			if (e.getSource() == userlogin2.backbtn){
				userlogin.f.setVisible(false);
				userorder.face.setVisible(true);
				usermanage.face2.setVisible(false);
				userlogin2.f2.setVisible(false);
				userlogin2.re_clean();
				userlogin2.acntTxtFd.setText("");
				userlogin2.pwdTxtFd.setText("");
			}

		}
	};

	public ActionListener cth_prft = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			incomepr.catch_sell((String)date_conbine());
		}
    };
	
 	static String date_conbine(){
 		String d1 = "";
 		String d2 = "";
 		String dm = "";
		if (pos_order_system.getMonth() < 10){
			d1 = "0" + Integer.toString(pos_order_system.getMonth());
		}
		else{
			d1 = Integer.toString(pos_order_system.getMonth());
		}
		if (pos_order_system.getDate() < 10){
			d2 = "0" + Integer.toString(pos_order_system.getDate());
		}
		else{
			d2 = Integer.toString(pos_order_system.getDate());
		}
		dm = Integer.toString(pos_order_system.getYear())+"/"+d1+"/"+d2;
		return (dm);
	} 	    
 	
}