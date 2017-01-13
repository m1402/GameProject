package GameProject;

public class GAME_NICK {

	String nickid;
	String userid;
	String species;
	String jobs;
	int levels;
	
	public GAME_NICK() {
		super();
	}

	//Insert 할 때
	public GAME_NICK(String nickid, String userid, String species, String jobs, int levels) {
		super();
		this.nickid = nickid;
		this.userid = userid;
		this.species = species;
		this.jobs = jobs;
		this.levels = levels;
	}

	//Update 할 때 , 종족 직업 변경
	public GAME_NICK(String species, String jobs) {
		super();
		this.species = species;
		this.jobs = jobs;
	}

	public String getNickid() {
		return nickid;
	}

	public void setNickid(String nickid) {
		this.nickid = nickid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getJobs() {
		return jobs;
	}

	public void setJobs(String jobs) {
		this.jobs = jobs;
	}

	public int getLevels() {
		return levels;
	}

	public void setLevels(int levels) {
		this.levels = levels;
	}

	@Override
	public String toString() {
		return "GAME_NICK [nickid=" + nickid + ", userid=" + userid + ", species=" + species + ", jobs=" + jobs
				+ ", levels=" + levels + "]";
	}		
	
	
}
