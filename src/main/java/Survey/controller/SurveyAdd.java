package Survey.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Member.Service.MemberService;
import SurveyDTO.SurveyInfo;
import SurveyService.MngSurveyService;
import common.util.SurveyInfoValidator;
import exception.BadParameterException;

@WebServlet("/mng/survey/add")
public class SurveyAdd extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			
			String realPath = request.getServletContext().getRealPath("/images/survey");
			// DefaultFileRenamePolicy -> 똑같은 이름의 사진을 저장해도 저장이 되도록 ( 파일이름이 달라짐)
			MultipartRequest req = new MultipartRequest(request, realPath, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			
			request.setCharacterEncoding("UTF-8");
			
			String surveyTitle = req.getParameter("surveyTitle");
			String category = req.getParameter("category");
			String content = req.getParameter("content");
			int point = Integer.parseInt(req.getParameter("point"));
			String startDate = req.getParameter("startDate");
			String endDate = req.getParameter("endDate");
			
			// 서버에 저장한 파일의 정보 
			//File file = req.getFile("img");
			
			//서버에 저장된 실제 파일의 이름 / 파일 명 변경 정책 때문에 클라이언트가 보낸 이름과 실제 이름 다를수 있다 
			String img = req.getFilesystemName("img");
			
			// 클라이어늩가 보낸 파일의 이름 
			//String orginalFileName = req.getOriginalFileName("img");
			
			// 서버에 저장한 파일의 경로 및 이름 
			//String img = savedFileName;
			
			// 파라미터 검증 
			SurveyInfoValidator validator = new SurveyInfoValidator();
			
			if(!validator.surveyTitleValidator(surveyTitle)) 		throw new BadParameterException();
			else if(!validator.categoryValidator(category))			throw new BadParameterException();
			else if(!validator.pointValidator(point))				throw new BadParameterException();
			else if(!validator.startDateValidator(startDate))		throw new BadParameterException();
			else if(!validator.endDateValidator(endDate))			throw new BadParameterException();
			
			// 파라미터 검증 
			
			
			SurveyInfo newSurveyInfo = new SurveyInfo();
			newSurveyInfo.setSurveyTitle(surveyTitle);
			newSurveyInfo.setCategory(category);
			newSurveyInfo.setContent(content);
			newSurveyInfo.setPoint(point);
			newSurveyInfo.setStartDate(startDate);
			newSurveyInfo.setEndDate(endDate);
			newSurveyInfo.setWriteDate(LocalDateTime.now());
			newSurveyInfo.setImg(img);
		
			
			MngSurveyService service = new MngSurveyService();

			int surveyIdx = service.insert(newSurveyInfo);
				
				response.sendRedirect("http://localhost:8083/survey/operate/admin-survey-add.jsp?surveyIdx="+surveyIdx);
				
			
		}catch(BadParameterException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
	}

}
