package GameProject;

import java.util.Scanner;

public class GameUserManager {

	Scanner sc = new Scanner(System.in);
	GAMEUSER user = new GAMEUSER();
	
	public GameUserManager(){
		
	}
			
	public GAMEUSER insert(){
		System.out.println("userid 입력: ");
		user.setUserid(sc.next());
		
		System.out.println("password 입력: ");
		user.setPassword(sc.next());
		
		System.out.println("server 입력: ");
		user.setServer(sc.next());
		
		System.out.println("hire_date 입력: ");
		user.setHire_date(sc.next());
		
		System.out.println("nickid 입력: ");
		user.setNickid(sc.next());
		
		System.out.println("cash 입력: ");
		user.setCash(sc.nextInt());
		
		return user;
	}
	
	public String searchdata()
	{
		System.out.println("데이터 검색을 시작합니다..");
		
		System.out.print("UserId: ");
		String name = MenuViewer.keyboard.nextLine();
		
		return name;
	}
	
	public String deleteData()
	{
		System.out.println("데이터 삭제를 시작합니다..");
		
		System.out.print("UserId: ");
		String name=MenuViewer.keyboard.nextLine();
				
		return name;
	}
	
	
	
}
