package SurveyDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SurveyDTO.SurveyInfo;
import SurveyDTO.SurveyJoinInfo;
import common.util.DBConn;
import faqDTO.FaqInfo;
import memberDTO.MemberInfo;

public class SurveyInfoDao {
	
	
	public int getPoint(int memberIdx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int point = 0;
		
		try {
			
			conn = DBConn.getConnection();
			
			String sql = "SELECT point FROM member_Info WHERE memberIdx = ? ";
			
			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setInt(1, memberIdx);
			
			rs =  pstmt.executeQuery();
			
			rs.next();
			
			MemberInfo memberInfo = new MemberInfo();
			memberInfo.setPoint(rs.getInt("point"));
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
		
		return point;
		
		
	}
	
	
	public SurveyInfo getSurveyInfo(int surveyIdx) {
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
	
	public int getAmount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int amount = 0;
		try {
			
			conn = DBConn.getConnection();
			String sql = "SELECT COUNT(*) AS amount FROM survey_Info";
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
	
	public int surveyJoinAmount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int amount = 0;
		try {
			
			conn = DBConn.getConnection();
			String sql = "SELECT COUNT(*) AS amount FROM survey_Join";
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
	
	

	
	public List<SurveyInfo> getSurveyInfoList(int start){
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<SurveyInfo> surveyInfoList = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			
			String sql = "SELECT * FROM survey_Info ORDER BY writeDate DESC LIMIT ?, 8";

			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setInt(1, start);
			
			rs = pstmt.executeQuery();
			// 여러개를 불러와야하니깐 
			while(rs.next()) {
				SurveyInfo nth = new SurveyInfo();
				nth.setSurveyIdx(rs.getInt("surveyIdx"));
				nth.setSurveyTitle(rs.getString("surveyTitle"));
				nth.setCategory(rs.getString("category"));
				nth.setContent(rs.getString("content"));
				nth.setPoint(rs.getInt("point"));
				nth.setStartDate(rs.getString("startDate"));
				nth.setEndDate(rs.getString("endDate")); 
				nth.setWriteDate(rs.getTimestamp("writeDate").toLocalDateTime());
				nth.setImg(rs.getString("img"));
			
				surveyInfoList.add(nth);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, pstmt, rs);
		}
		
		return surveyInfoList;
	}
	
		public List<SurveyJoinInfo> surveyJoinList(int start){
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<SurveyJoinInfo> surveyJoinInfoList = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			
			String sql = "SELECT * FROM survey_Join ORDER BY joinDate DESC LIMIT ?, 8";

			pstmt = DBConn.getPstmt(conn, sql);
			pstmt.setInt(1, start);
		
			
			rs = pstmt.executeQuery();
			// 여러개를 불러와야하니깐 
			while(rs.next()) {
				SurveyJoinInfo nth = new SurveyJoinInfo();
				nth.setSurveyIdx(rs.getInt("surveyIdx"));
				nth.setJoinDate(rs.getTimestamp("joinDate").toLocalDateTime());
				nth.setPoint(rs.getInt("point"));
				
			
				surveyJoinInfoList.add(nth);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, pstmt, rs);
		}
		
		return surveyJoinInfoList;
	}



}

