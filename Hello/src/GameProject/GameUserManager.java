package GameProject;

import java.util.Scanner;

public class GameUserManager {

	Scanner sc = new Scanner(System.in);
	GAMEUSER user = new GAMEUSER();
	
	public GameUserManager(){
		
	}
			
	public GAMEUSER insert(){
		System.out.println("userid �Է�: ");
		user.setUserid(sc.next());
		
		System.out.println("password �Է�: ");
		user.setPassword(sc.next());
		
		System.out.println("server �Է�: ");
		user.setServer(sc.next());
		
		System.out.println("hire_date �Է�: ");
		user.setHire_date(sc.next());
		
		System.out.println("nickid �Է�: ");
		user.setNickid(sc.next());
		
		System.out.println("cash �Է�: ");
		user.setCash(sc.nextInt());
		
		return user;
	}
	
	public String searchdata()
	{
		System.out.println("������ �˻��� �����մϴ�..");
		
		System.out.print("UserId: ");
		String name = MenuViewer.keyboard.nextLine();
		
		return name;
	}
	
	public String deleteData()
	{
		System.out.println("������ ������ �����մϴ�..");
		
		System.out.print("UserId: ");
		String name=MenuViewer.keyboard.nextLine();
				
		return name;
	}
	
	
	
}
