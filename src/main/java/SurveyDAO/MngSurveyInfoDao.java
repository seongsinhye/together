package SurveyDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import SurveyDTO.AnswerInfo;
import SurveyDTO.QuestionInfo;
import SurveyDTO.SurveyInfo;
import common.util.DBConn;

public class MngSurveyInfoDao {
	
	public boolean updateImg(int surveyIdx, String img) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConn.getConnection();
			String sql = "UPDATE survey_Info SET img = ? WHERE surveyIdx = ?";
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setString(1, img);
			pstmt.setInt(2, surveyIdx);
			
			pstmt.executeUpdate();
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			
			
		}finally {
			DBConn.close(conn, pstmt);
		}
		return false;
	}
	
	public boolean setImgNull(int surveyIdx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConn.getConnection();
			String sql = "UPDATE survey_Info SET img = null WHERE surveyIdx = ?";
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setInt(1, surveyIdx);
			
			pstmt.executeUpdate();
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			
			
		}finally {
			DBConn.close(conn, pstmt);
		}
		return false;
	}
	
	public SurveyInfo getSurveyIdxReturnSurInfo(int surveyIdx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		SurveyInfo surveyInfo = null;

		try {
			
			conn = DBConn.getConnection();
			
			String sql = "SELECT * FROM survey_Info WHERE surveyIdx = ?";
			
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setInt(1, surveyIdx);
			
			rs =  pstmt.executeQuery();
			
			rs.next();
			
			surveyInfo = new SurveyInfo();
			surveyInfo.setSurveyIdx(surveyIdx);
			surveyInfo.setSurveyTitle(rs.getString("surveyTitle"));
			surveyInfo.setCategory(rs.getString("category"));
			surveyInfo.setContent(rs.getString("content"));
			surveyInfo.setPoint(rs.getInt("point"));
			surveyInfo.setStartDate(rs.getString("startDate"));
			surveyInfo.setEndDate(rs.getString("endDate"));
			surveyInfo.setImg(rs.getString("img"));
			surveyInfo.setWriteDate(rs.getTimestamp("writeDate").toLocalDateTime());
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
		
		return surveyInfo;
			
		
		
		
	}
	
	public boolean answerDelete(int surveyIdx) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBConn.getConnection();
			
			String sql = "DELETE FROM survey_questionAndAnswer WHERE surveyIdx = ?";
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setInt(1, surveyIdx);
			
			pstmt.executeUpdate();
			
			
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		
		return false;
	}
	
//public boolean questionDelete(int surveyIdx) {
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			
//			conn = DBConn.getConnection();
//			
//			String sql = "DELETE FROM question_Info WHERE surveyIdx = ?";
//			pstmt = DBConn.getPstmt(conn, sql);
//			pstmt.setInt(1, surveyIdx);
//			
//			pstmt.executeUpdate();
//			
//			
//			return true;
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			DBConn.close(conn, pstmt);
//		}
//		
//		
//		return false;
//	}
	
	
	public boolean surveyDelete(int surveyIdx) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBConn.getConnection();
			
			String sql = "DELETE FROM survey_Info WHERE surveyIdx = ?";
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setInt(1, surveyIdx);
			
			pstmt.executeUpdate();
			
			
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		
		return false;
	}
	
	public boolean update(SurveyInfo surveyInfo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConn.getConnection();
			
			String sql = "UPDATE survey_Info SET surveyTitle = ?, category = ?, content = ?, point = ?, img = ?, startDate = ?, endDate = ? WHERE surveyIdx = ?";
			
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setString(1, surveyInfo.getSurveyTitle());
			pstmt.setString(2, surveyInfo.getCategory());
			pstmt.setString(3, surveyInfo.getContent());
			pstmt.setInt(4,surveyInfo.getPoint());
			pstmt.setString(5, surveyInfo.getImg());
			pstmt.setString(6, surveyInfo.getStartDate());
			pstmt.setString(7, surveyInfo.getEndDate());
			pstmt.setInt(8, surveyInfo.getSurveyIdx());
			
			pstmt.executeUpdate();
			
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		return false;
		
	}
	
	
	
	public int getMemberIdx(int memberIdx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 검색하기 전이니깐 없다는 가정하로 
		

		try {
			
			conn = DBConn.getConnection();
			
			String sql = "SELECT * FROM member_Info WHERE memberIdx = ?";
			
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setInt(1, memberIdx);
			
			rs =  pstmt.executeQuery();
			
			rs.next();
			
			memberIdx = rs.getInt("memberIdx");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
		
		return memberIdx;
			
		
		
		
	}
	
	public int getQuestionIdx(int questionIdx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 검색하기 전이니깐 없다는 가정하로 
		

		try {
			
			conn = DBConn.getConnection();
			
			String sql = "SELECT * FROM question_Info WHERE questionIdx = ?";
			
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setInt(1, questionIdx);
			
			rs =  pstmt.executeQuery();
			
			rs.next();
			
			questionIdx = rs.getInt("questionIdx");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
		
		return questionIdx;
			
		
		
		
	}
	
	
	public int getSurveyIdx(int surveyIdx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 검색하기 전이니깐 없다는 가정하로 
		

		try {
			
			conn = DBConn.getConnection();
			
			String sql = "SELECT * FROM survey_Info WHERE surveyIdx = ?";
			
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setInt(1, surveyIdx);
			
			rs =  pstmt.executeQuery();
			
			rs.next();
			
			surveyIdx = rs.getInt("surveyIdx");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
		
		return surveyIdx;
			
		
		
		
	}
	
	public int insertAndSelectIdx(SurveyInfo surveyInfo) {
		
		Connection conn = null;
		PreparedStatement insertPstmt = null;
		PreparedStatement selectPstmt = null;
		ResultSet rs = null;
		
		int surveyIdx = 0;
		
		try {
			conn = DBConn.getConnection();
			
			String sql = "INSERT INTO survey_Info (surveyTitle, category, content, point, startDate, endDate, writeDate, img) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			
			insertPstmt = DBConn.getPstmt(conn, sql);
			
			insertPstmt.setString(1, surveyInfo.getSurveyTitle());
			insertPstmt.setString(2, surveyInfo.getCategory());
			insertPstmt.setString(3, surveyInfo.getContent());
			insertPstmt.setInt(4, surveyInfo.getPoint());
			insertPstmt.setString(5, surveyInfo.getStartDate());
			insertPstmt.setString(6, surveyInfo.getEndDate());
			insertPstmt.setString(7, surveyInfo.getWriteDate().toString());
			insertPstmt.setString(8, surveyInfo.getImg());
			
			int isInsert = insertPstmt.executeUpdate();
			
			if(isInsert == 1) {
				sql = "SELECT LAST_INSERT_ID() AS surveyIdx";
				
				selectPstmt = DBConn.getPstmt(conn, sql);
				rs = selectPstmt.executeQuery();
				
				rs.next();
				surveyIdx = rs.getInt("surveyIdx");
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			return surveyIdx;
		}finally {
			DBConn.close(conn, insertPstmt);
			DBConn.close(selectPstmt, rs);
		}
		
		return surveyIdx;
		
	}



		

public boolean questionAdd(int surveyIdx, QuestionInfo questionInfo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConn.getConnection();
			
			String sql = "INSERT INTO survey_questionAndAnswer (surveyIdx, question1, question2 ,question3)  VALUES(?, ?, ?, ?)";
			
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setInt(1, surveyIdx);
			pstmt.setString(2, questionInfo.getQuestion1());
			pstmt.setString(3, questionInfo.getQuestion2());
			pstmt.setString(4, questionInfo.getQuestion3());
			
			pstmt.executeUpdate();
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		
	}
public QuestionInfo getQuestionInfo(int surveyIdx) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	QuestionInfo questionInfo = null;

	try {
		
		conn = DBConn.getConnection();
		
		String sql = "SELECT * FROM survey_questionAndAnswer WHERE surveyIdx = ?";
		
		pstmt = DBConn.getPstmt(conn, sql);
		pstmt.setInt(1, surveyIdx);
		
		rs =  pstmt.executeQuery();
		
		rs.next();
		
		questionInfo = new QuestionInfo();
		questionInfo.setSurveyIdx(surveyIdx);
		questionInfo.setQuestion1(rs.getString("question1"));
		questionInfo.setQuestion2(rs.getString("question2"));
		questionInfo.setQuestion3(rs.getString("question3"));
		
	}catch(SQLException e) {
		e.printStackTrace();
	} finally {
		DBConn.close(conn, pstmt, rs);
	}
	
	return questionInfo;
		
	
	
	
}
//public boolean answerAdd(AnswerInfo answerInfo) {
//	
//	Connection conn = null;
//	PreparedStatement pstmt = null;
//	
//	try {
//		conn = DBConn.getConnection();
//		
//		String sql = "INSERT INTO answer_Info (questionIdx, surveyIdx, memberIdx, answerIdx, text) VALUES(?, ?, ?, ?, ?)";
//		
//		pstmt = DBConn.getPstmt(conn, sql);
//		pstmt.setInt(1, answerInfo.getQuestionIdx());
//		pstmt.setInt(2, answerInfo.getSurvetIdx());
//		pstmt.setInt(3, answerInfo.getMemberIdx());
//		pstmt.setInt(4, answerInfo.getAnswerIdx());
//		pstmt.setString(5, answerInfo.getText());
//		
//		pstmt.executeUpdate();
//		
//		return true;
//	}catch(SQLException e) {
//		e.printStackTrace();
//		return false;
//	}finally {
//		DBConn.close(conn, pstmt);
//	}
//	
//	
//}
}
