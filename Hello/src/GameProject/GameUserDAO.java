package GameProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GameUserDAO {
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String user = "hr";
	private String password = "hr";
	
	private String insert_user="insert into gameuser values(?,?,?,?,?,? )";			 
	private String update_user = "update gameuser set password= ?,"
								+" server = ?, cash = ? where userid = ?;";
	private String delete_user = "delete from gameuser where userid = ?";
	private String select_user = "select * from gameuser where userid = ?";
	private String selectall_user = "select * from gameuser";
	
	public GameUserDAO(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){
			System.out.println("파일이 없습니다.");
		}
	}
	
	public Connection getConnection() throws SQLException
	{
		Connection con = null;
		con = DriverManager.getConnection(url,user,password);
		
		return con;
	}
	
	public void close(Connection con)
	{
		if(con != null)
		{
			try
			{
				con.close();
			} 
			catch (SQLException e) 
			{		
				e.printStackTrace();
			}
		}
	}
	
	public void close(PreparedStatement pstmt)
	{
		if(pstmt != null)
		{
			try
			{
				pstmt.close();
			} 
			catch (SQLException e) 
			{		
				e.printStackTrace();
			}
		}
	}
	
	public void close(ResultSet rset)
	{
		if(rset != null)
		{
			try
			{
				rset.close();
			} 
			catch (SQLException e) 
			{		
				e.printStackTrace();
			}
		}
	}
	
	//입력
	public void insert(GAMEUSER user) throws SQLException
	{
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement(insert_user);
		pstmt.setString(1,user.getUserid());
		pstmt.setString(2,user.getPassword());
		pstmt.setString(3,user.getServer());
		pstmt.setString(4,user.getHire_date());
		pstmt.setString(5,user.getNickid());
		pstmt.setInt(6,user.getCash());
				
		pstmt.executeUpdate();
		
		close(pstmt);
		close(con);
		
	}
	
	//USERID검색 수정
	public void update(GAMEUSER user) throws SQLException
	{
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement(update_user);
		pstmt.setString(1,user.getPassword());
		pstmt.setString(2,user.getServer());		
		pstmt.setInt(3,user.getCash());
		pstmt.setString(4,user.getUserid());
				
		pstmt.executeUpdate();		
		
		close(pstmt);
		close(con);		
	}
	
	//USERID검색 삭제
	public void delete(String userid) throws SQLException
	{
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement(delete_user);
		pstmt.setString(1,userid);				
		pstmt.executeUpdate();
		
		close(pstmt);
		close(con);		
	}
	
	//USERID검색 출력
	public void select(String str) throws SQLException
	{
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement(select_user);
		pstmt.setString(1,str);
		
		ResultSet rset = pstmt.executeQuery();
		
		rset.next();
		String userid = rset.getString("USERID");
		String password = rset.getString("PASSWORD");
		String server = rset.getString("SERVER");
		String hire_date = rset.getString("HIRE_DATE");
		String nickid = rset.getString("NICKID");
		int cash = rset.getInt("CASH");
		
		GAMEUSER gameuser = new GAMEUSER
				(userid,password,server,hire_date,nickid,cash);
		
		//gameuser.toString();
		
		System.out.println("[userid=" + userid + ", password=" + password + ", server=" + server + ", hire_date="
				+ hire_date + ", nickid=" + nickid + ", cash=" + cash + "]");
		
		close(pstmt);
		close(con);			
		
	}
	
	//전체출력
	public void selectall() throws SQLException
	{
		ArrayList<GAMEUSER> list = new ArrayList<GAMEUSER>();
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectall_user);
		ResultSet rset = pstmt.executeQuery();
		
		while(rset.next()){			
			
			String userid = rset.getString("USERID");
			String password = rset.getString("PASSWORD");
			String server = rset.getString("SERVER");
			String hire_date = rset.getString("HIRE_DATE");
			String nickid = rset.getString("NICKID");
			int cash = rset.getInt("CASH");
			
			GAMEUSER gameuser = new GAMEUSER
					(userid,password,server,hire_date,nickid,cash);
			
			System.out.println("[userid=" + userid + ", password=" + password + ", server=" + server + ", hire_date="
				+ hire_date + ", nickid=" + nickid + ", cash=" + cash + "]");
			
			gameuser.toString();
			//list.add(gameuser);		
			
		}
		
		close(rset);
		close(pstmt);
		close(con);		
		
		//return list;
	}

}
