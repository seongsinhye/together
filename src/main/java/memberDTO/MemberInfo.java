package memberDTO;

import java.time.LocalDateTime;

public class MemberInfo {
	
	private int memberIdx;
	private String id;
	private String pw;
	private String pwChk;
	private String name;
	private String birthDay;
	private String gender;
	private String tel;
	private String addr;
	private String email;
	private LocalDateTime joinDate;
	private int point;
	
	
	public MemberInfo() {
		
	}
	
	
	




	public MemberInfo(int memberIdx, String id, String pw, String pwChk, String name, String birthDay, String gender,
			String tel, String addr, String email, LocalDateTime joinDate, int point) {
		this.memberIdx = memberIdx;
		this.id = id;
		this.pw = pw;
		this.pwChk = pwChk;
		this.name = name;
		this.birthDay = birthDay;
		this.gender = gender;
		this.tel = tel;
		this.addr = addr;
		this.email = email;
		this.joinDate = joinDate;
		this.point = point;
	}



	public MemberInfo(int memberIdx, String id, String pw, String pwChk, String name, String birthDay, String gender,
			String tel, String addr, String email, LocalDateTime joinDate) {
		this.memberIdx = memberIdx;
		this.id = id;
		this.pw = pw;
		this.pwChk = pwChk;
		this.name = name;
		this.birthDay = birthDay;
		this.gender = gender;
		this.tel = tel;
		this.addr = addr;
		this.email = email;
		this.joinDate = joinDate;
	}


	public MemberInfo( String id, String pw, String pwChk, String name, String birthDay,String gender, String tel,
			String addr, String email, LocalDateTime joinDate) {
		this.id = id;
		this.pw = pw;
		this.pwChk = pwChk;
		this.name = name;
		this.birthDay = birthDay;
		this.gender = gender;
		this.tel = tel;
		this.addr = addr;
		this.email = email;
		this.joinDate = joinDate;
	}
	
	
	public MemberInfo(int memberIdx, String id, String pw, String pwChk, String name, String birthDay, String tel,
			String addr, String email, LocalDateTime joinDate) {
		this.memberIdx = memberIdx;
		this.id = id;
		this.pw = pw;
		this.pwChk = pwChk;
		this.name = name;
		this.birthDay = birthDay;
		this.tel = tel;
		this.addr = addr;
		this.email = email;
		this.joinDate = joinDate;
	}
	
	
	public int getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPwChk() {
		return pwChk;
	}
	public void setPwChk(String pwChk) {
		this.pwChk = pwChk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getJoinDate() {
		return joinDate;
	}




	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}

	public int getPoint() {
		return point;
	}



	public void setPoint(int point) {
		this.point = point;
	}
	
	
	
}
