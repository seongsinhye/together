package MemberDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import common.util.DBConn;
import memberDTO.MemberInfo;

public class MemberInfoDao {
	
	
	public boolean delete(int memberIdx) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBConn.getConnection();
			
			String sql = "DELETE FROM member_Info WHERE memberIdx = ?";
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setInt(1, memberIdx);
			
			pstmt.executeUpdate();
			
			
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		
		return false;
	}
	
	
	public boolean update(MemberInfo memberInfo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBConn.getConnection();
			
			String sql = "UPDATE member_Info SET pw = ?, name = ?, tel = ?, addr = ?, email = ? WHERE memberIdx = ? ";
			
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setString(1, memberInfo.getPw());
			pstmt.setString(2, memberInfo.getName());
			pstmt.setString(3, memberInfo.getTel());
			pstmt.setString(4, memberInfo.getAddr());
			pstmt.setString(5, memberInfo.getEmail());
			pstmt.setInt(6, memberInfo.getMemberIdx());
			
			pstmt.executeUpdate();
					
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, pstmt);
		}
		return false;
		
		
	}
	
	
	
	public boolean insert(MemberInfo memberInfo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = DBConn.getConnection();
			
			String sql = "INSERT INTO member_Info(id, pw, name, birthDay, gender, tel, addr, email, joinDate) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setString(1, memberInfo.getId());
			pstmt.setString(2, memberInfo.getPw());
			pstmt.setString(3, memberInfo.getName());
			pstmt.setString(4, memberInfo.getBirthDay());
			pstmt.setString(5, memberInfo.getGender());
			pstmt.setString(6, memberInfo.getTel());
			pstmt.setString(7, memberInfo.getAddr());
			pstmt.setString(8, memberInfo.getEmail());
			pstmt.setString(9, memberInfo.getJoinDate().toString());
			
			pstmt.executeUpdate();
			
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			
			return false;
		}finally {
			DBConn.close(conn, pstmt);
		}
		
	}
public MemberInfo selectMemberIdx(int memberIdx) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberInfo memberInfo = null;
		
		try {
			conn = DBConn.getConnection();
			
			String sql = "SELECT * FROM member_Info WHERE memberIdx = ?";
			
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setInt(1, memberIdx);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String birthDay = rs.getString("birthDay");
				String gender = rs.getString("gender");
				String tel = rs.getString("tel");
				String addr = rs.getString("addr");
				String email = rs.getString("email");
				LocalDateTime joinDate = rs.getTimestamp("joinDate").toLocalDateTime();
				
				
				memberInfo = new MemberInfo();
				memberInfo.setMemberIdx(memberIdx);
				memberInfo.setId(id);
				memberInfo.setPw(pw);
				memberInfo.setName(name);
				memberInfo.setBirthDay(birthDay);
				memberInfo.setGender(gender);
				memberInfo.setTel(tel);
				memberInfo.setAddr(addr);
				memberInfo.setEmail(email);
				memberInfo.setJoinDate(joinDate);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, pstmt, rs);
		}
		return memberInfo;
	}
	
	public MemberInfo selectId(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberInfo memberInfo = null;
		
		try {
			conn = DBConn.getConnection();
			
			String sql = "SELECT * FROM member_Info WHERE id = ?";
			
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int memberIdx = rs.getInt("memberIdx");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String birthDay = rs.getString("birthDay");
				String gender = rs.getString("gender");
				String tel = rs.getString("tel");
				String addr = rs.getString("addr");
				String email = rs.getString("email");
				LocalDateTime joinDate = rs.getTimestamp("joinDate").toLocalDateTime();
				
				
				memberInfo = new MemberInfo();
				memberInfo.setMemberIdx(memberIdx);
				memberInfo.setId(id);
				memberInfo.setPw(pw);
				memberInfo.setName(name);
				memberInfo.setBirthDay(birthDay);
				memberInfo.setGender(gender);
				memberInfo.setTel(tel);
				memberInfo.setAddr(addr);
				memberInfo.setEmail(email);
				memberInfo.setJoinDate(joinDate);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, pstmt, rs);
		}
		return memberInfo;
	}
	
	
	public MemberInfo seletTel(String tel) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		MemberInfo memberInfo = null;
		
		try {
			
			conn = DBConn.getConnection();
			
			String sql ="SELECT * FROM member_Info WHERE tel = ?";
			
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setString(1, tel);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int memberIdx = rs.getInt("memberIdx");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String birthDay = rs.getString("birthDay");
				String gender = rs.getString("gender");
				String addr = rs.getString("addr");
				String email = rs.getString("email");
				LocalDateTime joinDate = rs.getTimestamp("joinDate").toLocalDateTime();
			
				memberInfo = new MemberInfo(memberIdx, id, pw, name,birthDay, gender, tel, addr, email, joinDate);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, pstmt, rs);
		}
		return memberInfo;
	}
	
	public MemberInfo selectEmail(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		MemberInfo memberInfo = null;
		
		try {
			
			conn = DBConn.getConnection();
			
			String sql ="SELECT * FROM member_Info WHERE email = ?";
			
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setString(1, email);
			
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int memberIdx = rs.getInt("memberIdx");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String birthDay = rs.getString("birthDay");
				String gender = rs.getString("gender");
				String tel = rs.getString("tel");
				String addr = rs.getString("addr");
				LocalDateTime joinDate = rs.getTimestamp("joinDate").toLocalDateTime();
			
				memberInfo = new MemberInfo(memberIdx, id, pw, name,birthDay, gender, tel, addr, email, joinDate);
			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, pstmt, rs);
		}
		return memberInfo;
	}
}
