package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class DetailController
 */
@WebServlet("/notice/detail.do")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// /notice/detail.do?noticeNo=445
		// SELECT * FROM NOTICE_TBL WHERE NOTICE_NO = ?		
		String noticeNo = req.getParameter("noticeNo");
		NoticeService nService = new NoticeService();
		Notice notice = nService.selectOneByNO(Integer.parseInt(noticeNo));
		if(notice != null) {
			req.setAttribute("notice", notice);
			req.getRequestDispatcher("/WEB-INF/views/notice/detail.jsp").forward(req, resp);
		}else {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
