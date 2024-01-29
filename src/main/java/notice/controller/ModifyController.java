package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

@WebServlet("/notice/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ModifyController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/notice/modify.jsp").forward(request, response); // 수정페이지 경로를 적어주세요.
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		NoticeService nService = new NoticeService();
		Notice notice = nService.selectOneByNo(noticeNo);
		if(notice != null) {
			request.setAttribute("notice", notice);
			request.getRequestDispatcher("/WEB-INF/views/notice/modify.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // ★한글 깨짐 방지
//		int noticeNo = Integer.parseInt(request.getParameter("notice-no"));
		String noticeNo = request.getParameter("notice-no");
		String noticeSubject = request.getParameter("notice-subject");
		String noticeContent = request.getParameter("notice-content");
		Notice notice = new Notice(noticeNo, noticeSubject, noticeContent);
		NoticeService nService = new NoticeService();
		int result = nService.updateNotice(notice);
		if(result > 0) {
			response.sendRedirect("/notice/detail.do?noticeNo=" + noticeNo); // detail로 가는 url 적어주세요.
		}else {
			request.setAttribute("msg", "Service Failed");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response); // 오류페이지 경로를 적어주세요.
		}
	}

}
