package main.java.vr.voter_reg.DTO;

import java.sql.Date;
import java.util.Random;

public class DTO {
	private String fName = null;
	private String lName = null;
	private String national = null;
	private String ghID = null;
	private String location = null;
	private String sex = null;
	private String pollno = null;
	private String physaddress = null;
	private String digiaddress = null;
	private String voterID = null;
	private String username = null;
	private String userID = null;
	private String password = null;
	private Date dateBirth = null;
	private Date dateReg = null;
	
	public DTO() {
	}

	public DTO(String f, String l, String n, String dob, String gh, String loc, String s, String p, String ph, String digi ){
		setfName(f);
		setlName(l);
		setNational(n);
		setDateBirth(java.sql.Date.valueOf(dob));
		setGhID(gh);
		setLocation(loc);
		setSex(s);
		setDateReg(new java.sql.Date(System.currentTimeMillis()));
		setPollno(p);
		setPhysaddress(ph);
		setDigiaddress(digi);
		setVoterID();
	}
	
	public DTO(String username, String userID, String password){
		setUsername(username);
		setUserID(userID);
		setPassword(password);
	}
	
	
	public DTO(String voterID) {
		this.voterID = voterID;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getNational() {
		return national;
	}

	public void setNational(String national) {
		this.national = national;
	}

	public String getGhID() {
		return ghID;
	}

	public void setGhID(String ghID) {
		this.ghID = ghID;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPollno() {
		return pollno;
	}

	public void setPollno(String pollno) {
		this.pollno = pollno;
	}

	public String getPhysaddress() {
		return physaddress;
	}

	public void setPhysaddress(String physaddress) {
		this.physaddress = physaddress;
	}

	public String getDigiaddress() {
		return digiaddress;
	}

	public void setDigiaddress(String digiaddress) {
		this.digiaddress = digiaddress;
	}

	public String getVoterID() {
		return voterID;
	}

	public void setVoterID() {
		Random random = new Random();
		int indirand;
		char[] holder = new char[16];
		
		for(int i = 0; i < 16; i++) {
			indirand = random.nextInt(10);
			holder[i] = Character.forDigit(indirand, 10);
		}
		
		this.voterID = new String(holder);
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Date getDateReg() {
		return dateReg;
	}

	public void setDateReg(Date dateReg) {
		this.dateReg = dateReg;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}