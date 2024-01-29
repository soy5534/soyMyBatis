package notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;


@WebServlet("/notice/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService nService = new NoticeService();
		List<Notice> nList = nService.selectAllNotice();
//		if(nList != null) {}
		if(!nList.isEmpty()) {
			request.setAttribute("nList", nList);
			request.getRequestDispatcher("/WEB-INF/views/notice/list.jsp").forward(request, response);			
		}else {
			request.setAttribute("msg", "No Data Found");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
