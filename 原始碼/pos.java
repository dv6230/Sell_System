import java.util.*;


public class pos {            //�D�{��
	public static void main(String[] args) {

		pos_mode_system myUsrInt1 = new pos_mode_system();
		
		myUsrInt1.database.createDB();   //�إ߸�Ʈw
		myUsrInt1.database.createTB_state();   //�إ߮w�s��ƪ�
		myUsrInt1.database.createTB_profit();  //�إ��禬��ƪ�   
		myUsrInt1.usermanage.cth_in.catch_perday_income(
				(String)myUsrInt1.usermanage.getdatacode2(),"a"); //����禬���
		
		
		myUsrInt1.userorder.showCurrentTime();  //���������ܥ���
		
	}
}
