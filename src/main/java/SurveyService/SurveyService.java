package SurveyService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import SurveyDAO.SurveyInfoDao;
import SurveyDTO.SurveyInfo;
import SurveyDTO.SurveyJoinInfo;
import faqDTO.FaqInfo;

public class SurveyService {
	
	public int getPoint(int memberIdx) {
		
		SurveyInfoDao dao = new SurveyInfoDao();
		
		int point = dao.getPoint(memberIdx);
		
		return point;
		
	}
	
	
	
	public SurveyInfo surveyInfo(int surveyIdx) {
		
		SurveyInfoDao dao = new SurveyInfoDao();
		
		SurveyInfo surveyInfo = dao.getSurveyInfo(surveyIdx);
		
		
		return surveyInfo;
	}
	
	public int getAmount() {
		SurveyInfoDao dao = new SurveyInfoDao();
		
		// DAO를 통해서 등록된 설문조사 수를 가져옴 
		int amount = dao.getAmount();
		
		return amount;
	}
	
	public int surveyJoinAmount() {
		SurveyInfoDao dao = new SurveyInfoDao();
		
		// DAO를 통해서 등록된 설문조사 수를 가져옴 
		int amount = dao.surveyJoinAmount();
		
		return amount;
	}
	

 
	
	public List<SurveyInfo> getSurvetInfoList(int pageNumber) {
		pageNumber = (pageNumber - 1) * 8;
		
		SurveyInfoDao dao = new SurveyInfoDao();
		
		// DAO 통해서 페이지 번호에 맞는 설문조사를 가져옴 
		List<SurveyInfo> surveyInfoList = dao.getSurveyInfoList(pageNumber);
		
		return surveyInfoList;
		
	}
	
	public List<SurveyJoinInfo> surveyJoinList(int pageNumber) {
		pageNumber = (pageNumber - 1) * 8;
		
		SurveyInfoDao dao = new SurveyInfoDao();
		
		// DAO 통해서 페이지 번호에 맞는 설문조사를 가져옴 
		List<SurveyJoinInfo> surveyInfoList = dao.surveyJoinList(pageNumber);
		
		return surveyInfoList;
		
	}
	

}
