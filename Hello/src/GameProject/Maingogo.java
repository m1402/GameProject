package GameProject;

import java.sql.SQLException;

public class Maingogo {

	public static void main(String[] args) throws SQLException {
		GAMEUSER user = new GAMEUSER();
		GameUserDAO userdao = new GameUserDAO();
		GameUserManager u_manager = new GameUserManager();
		int choice;
		
		while(true)
		{
			MenuViewer.showMenu();
			choice=MenuViewer.keyboard.nextInt();
			MenuViewer.keyboard.nextLine();	
			
			switch(choice)
			{
			case 1:
				userdao.insert(u_manager.insert());
				break;
			case 2:
				userdao.select(u_manager.searchdata());
				break;
			case 3:
				userdao.delete(u_manager.deleteData());
				break;
			case 4:
				System.out.println("User 전체출력");
				userdao.selectall();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}

	}

}
