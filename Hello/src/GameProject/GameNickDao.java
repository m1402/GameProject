package GameProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GameNickDao {

	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String user = "hr";
	private String password = "hr";
	
	private String insert_nick;
	private String update_nick;
	private String delete_nick;
	private String select_nick;
	private String selectall_nick;
	
	public GameNickDao(){
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
	public void insert(GAME_NICK nick) throws SQLException
	{
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement(insert_nick);
		pstmt.setString(1,nick.getNickid());
		pstmt.setString(2,nick.getUserid());
		pstmt.setString(3,nick.getSpecies());
		pstmt.setString(4,nick.getJobs());		
		pstmt.setInt(5,nick.getLevels());
				
		pstmt.executeUpdate();
		
		close(pstmt);
		close(con);
		
	}
	
	//USERID검색 수정
	public void update(GAME_NICK nick) throws SQLException
	{
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement(update_nick);
		pstmt.setString(1,nick.getSpecies());
		pstmt.setString(2,nick.getJobs());		
				
		pstmt.executeUpdate();		
		
		close(pstmt);
		close(con);		
	}
	
	//USERID검색 삭제
	public void delete(String str) throws SQLException
	{
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement(delete_nick);
		pstmt.setString(1,str);				
		pstmt.executeUpdate();
		
		close(pstmt);
		close(con);		
	}
	
	//USERID검색 출력
	public void select(String str) throws SQLException
	{
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement(select_nick);
		pstmt.setString(1,str);
		
		ResultSet rset = pstmt.executeQuery();
		
		rset.next();
		String nickid = rset.getString("NICKID");
		String userid = rset.getString("USERID");
		String species = rset.getString("SPECIES");
		String jobs = rset.getString("JOBS");		
		int levels = rset.getInt("LEVELS");
		
		GAME_NICK gamenick = new GAME_NICK
				(nickid,userid,species,jobs,levels);
		
		gamenick.toString();
		
		close(pstmt);
		close(con);			
		
	}
	
	//전체출력
	public void selectall() throws SQLException
	{
		ArrayList<GAME_NICK> list = new ArrayList<GAME_NICK>();
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectall_nick);
		ResultSet rset = pstmt.executeQuery();
		
		while(rset.next()){
				
			String nickid = rset.getString("NICKID");
			String userid = rset.getString("USERID");
			String species = rset.getString("SPECIES");
			String jobs = rset.getString("JOBS");		
			int levels = rset.getInt("LEVELS");
			
			GAME_NICK gamenick = new GAME_NICK
					(nickid,userid,species,jobs,levels);
			
			gamenick.toString();
			list.add(gamenick);
		}
		
		close(rset);
		close(pstmt);
		close(con);		
		
		//return list;
	}
}
