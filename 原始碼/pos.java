import java.util.*;


public class pos {            //主程式
	public static void main(String[] args) {

		pos_mode_system myUsrInt1 = new pos_mode_system();
		
		myUsrInt1.database.createDB();   //建立資料庫
		myUsrInt1.database.createTB_state();   //建立庫存資料表
		myUsrInt1.database.createTB_profit();  //建立營收資料表   
		myUsrInt1.usermanage.cth_in.catch_perday_income(
				(String)myUsrInt1.usermanage.getdatacode2(),"a"); //抓取營收資料
		
		
		myUsrInt1.userorder.showCurrentTime();  //此項目應至末行
		
	}
}
