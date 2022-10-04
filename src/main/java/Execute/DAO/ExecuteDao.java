package Execute.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Execute.DTO.ExecuteInfo;
import SurveyDTO.SurveyInfo;
import common.util.DBConn;
import memberDTO.MemberInfo;

public class ExecuteDao {
	
	// 포인트 추가 dao 
	public boolean addPoint(int point, int memberIdx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConn.getConnection();
			
			String sql = "UPDATE member_Info SET point = point + ? WHERE memberIdx = ?";
			
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setInt(1, point);
			pstmt.setInt(2, memberIdx);
			
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			return false;
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		return true;
		
	}
	
	
	// 포인트 가져오기 
	public int getPoint(int surveyIdx) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int point = 0;
		
		try {
			conn = DBConn.getConnection();
			
			String sql = "SELECT point FROM survey_Info WHERE surveyIdx = ?";
			
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setInt(1, surveyIdx);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				point = rs.getInt("point");
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}finally {
			DBConn.close(conn, pstmt, rs);
		}
		return point;
	}

	
	// 설문조사 실행시 내역에 추가하기 
	public boolean execute(int memberIdx, ExecuteInfo executeInfo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBConn.getConnection();
			
			String sql = "INSERT INTO survey_Join (memberIdx, surveyIdx, joinDate, answer1, answer2, answer3) VALUES(?, ?, ?, ?, ?, ?)";
			
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setInt(1, memberIdx);
			pstmt.setInt(2, executeInfo.getSurveyIdx());
			pstmt.setString(3, executeInfo.getJoinDate().toString());
			pstmt.setString(4, executeInfo.getAnswer1());
			pstmt.setString(5, executeInfo.getAnswer2());
			pstmt.setString(6, executeInfo.getAnswer3());
			
			
			pstmt.executeUpdate();
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			
			return false;
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		
	}
}
