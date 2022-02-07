package kr.co.loginDB;

import java.sql.Date;

public class MemberVO {
	
	private String id;
	private String pwd;
	private String name;
	private String tel;
	private Date regDate;
	
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberVO(String id, String pwd, String name, String tel) {
//		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.tel = tel;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
