package GameProject;

public class GAMEUSER {

	String userid;
	String password;
	String server;
	String hire_date;
	String nickid;
	int cash;
	
	public GAMEUSER() {
		super();
	}

	//Insert 할 때, 생성자
	public GAMEUSER(String userid, String password, String server, String hire_date, String nickid, int cash) {
		super();
		this.userid = userid;
		this.password = password;
		this.server = server;
		this.hire_date = hire_date;
		this.nickid = nickid;
		this.cash = cash;
	}

	//Update 할 때, 아이디(서치) 비밀번호 서버 캐시
	public GAMEUSER(String userid,String password, String server, int cash) {
		super();
		this.userid = userid;
		this.password = password;
		this.server = server;
		this.cash = cash;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	public String getNickid() {
		return nickid;
	}

	public void setNickid(String nickid) {
		this.nickid = nickid;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	@Override
	public String toString() {
		return "GAMEUSER [userid=" + userid + ", password=" + password + ", server=" + server + ", hire_date="
				+ hire_date + ", nickid=" + nickid + ", cash=" + cash + "]";
	}		
	
}
