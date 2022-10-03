package ExecuteService;

import Execute.DAO.ExecuteDao;
import Execute.DTO.ExecuteInfo;
import SurveyDTO.SurveyInfo;
import memberDTO.MemberInfo;

public class ExecuteService {
	
	
	public boolean getpoint(int memberIdx, int surveyIdx) {
		int point = 0;
		ExecuteDao dao = new ExecuteDao();
	
		point = dao.getPoint(surveyIdx);
		
		
		return dao.addPoint(point, memberIdx);
		
	}

	
	public boolean execute(int memberIdx, ExecuteInfo execeteInfo) {
		
		ExecuteDao dao = new ExecuteDao();
		
		return dao.execute(memberIdx, execeteInfo);
	}
	
}
