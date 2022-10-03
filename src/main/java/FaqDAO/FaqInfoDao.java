package FaqDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import faqDTO.FaqInfo;
import faqDTO.QuestionPersonInfo;
import common.util.DBConn;

public class FaqInfoDao {
	
	public FaqInfo getFaqInfo(int faqIdx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 검색하기 전이니깐 없다는 가정하로 
		FaqInfo faqInfo = null;
		
		try {
			
			conn = DBConn.getConnection();
			
			String sql = "SELECT * FROM faq WHERE faqIdx = ?";
			
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setInt(1, faqIdx);
			
			rs =  pstmt.executeQuery();
			
			rs.next();
			
			faqInfo = new FaqInfo();
			faqInfo.setFaqIdx(faqIdx);
			faqInfo.setTitle(rs.getString("title"));
			faqInfo.setContent(rs.getString("content"));
		
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
		
		return faqInfo;
		
	}
	
	
	public boolean faqDelete(int faqIdx) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBConn.getConnection();
			
			String sql = "DELETE FROM faq WHERE faqIdx = ?";
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setInt(1, faqIdx);
			
			pstmt.executeUpdate();
			
			
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, pstmt);
		}
		
		
		return false;
	}
	public boolean updateFaq(int faqIdx, FaqInfo faqInfo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBConn.getConnection();
			
			String sql = "UPDATE faq SET title = ?, content = ?  WHERE faqIdx = ?";
			
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setString(1, faqInfo.getTitle());
			pstmt.setString(2, faqInfo.getContent());
			pstmt.setInt(3, faqIdx);
			
			pstmt.executeUpdate();
		
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, pstmt);
		}
		return false;
		
	}
	
	public boolean answerQPerson(int questionPersonIdx, String answerStatus, String answerText) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBConn.getConnection();
			
			String sql = "UPDATE questionInPerson SET answerStatus = ?, answerText = ? WHERE questionPersonIdx = ?";
			
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setString(1, answerStatus);
			pstmt.setString(2, answerText);
			pstmt.setInt(3, questionPersonIdx);
			
			pstmt.executeUpdate();
		
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, pstmt);
		}
		return false;
		
	}
	
	
	public boolean addQPerson(QuestionPersonInfo qpi) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn =DBConn.getConnection();
			
			String sql = "INSERT INTO questionInPerson(memberIdx, questionText, answerStatus, questionDate) VALUES(?, ?, ?, ?)";
			
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setInt(1, qpi.getMemberIdx());
			pstmt.setString(2, qpi.getQuestionText());
			pstmt.setString(3, qpi.getAnswerStatus());
			pstmt.setString(4, qpi.getQuestionDate().toString());
			
			pstmt.executeUpdate();
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, pstmt);
		}
		return false;
	}

	
	public boolean addFaq(FaqInfo faqInfo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			
			conn = DBConn.getConnection();
			
			String sql = "INSERT INTO faq(title, content, writeDate) VALUES(?, ?, ?)";
			
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setString(1, faqInfo.getTitle());
			pstmt.setString(2, faqInfo.getContent());
			pstmt.setString(3, faqInfo.getWriteDate().toString());
			
			
			pstmt.executeUpdate();
			
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			
			return false;
		}finally {
			DBConn.close(conn, pstmt);
		}
	}
	
	public int getFaqAmount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int amount = 0;
		try {
			
			conn = DBConn.getConnection();
			String sql = "SELECT COUNT(*) AS amount FROM faq";
			pstmt = DBConn.getPstmt(conn, sql);
			
			
			rs = pstmt.executeQuery();
			// 전체 데이터 수 rs.next if , while 필요없다. 
			rs.next();
			
			amount = rs.getInt("amount");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return amount;
	}
	public List<FaqInfo> getFaqInfoList(int start){
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<FaqInfo> faqInfoList = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			
			String sql = "SELECT * FROM faq ORDER BY writeDate DESC LIMIT ?, 8";

			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setInt(1, start);
			
			rs = pstmt.executeQuery();
			// 여러개를 불러와야하니깐 
			while(rs.next()) {
				FaqInfo nth = new FaqInfo();
				nth.setFaqIdx(rs.getInt("faqIdx"));
				nth.setTitle(rs.getString("title"));
				nth.setContent(rs.getString("content"));
				nth.setWriteDate(rs.getTimestamp("writeDate").toLocalDateTime());
			
				faqInfoList.add(nth);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, pstmt, rs);
		}
		
		return faqInfoList;
	}
}
