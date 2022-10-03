 package Survey.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import SurveyService.MngSurveyService;

@WebServlet("/mng/survey/img/add")
public class SurveyImgAdd extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String realPath = request.getServletContext().getRealPath("/images/survey/");
		
		MultipartRequest req = new MultipartRequest(request, realPath, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		
		int surveyIdx = Integer.parseInt(req.getParameter("surveyIdx"));
		String img = req.getFilesystemName("img");
		
		
		MngSurveyService service = new MngSurveyService();
		service.addImg(surveyIdx, img);
	
	}

}
