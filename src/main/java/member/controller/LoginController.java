package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		Member member = new Member(memberId, memberPw);
		MemberService mService = new MemberService();
		member = mService.selectCheckLogin(member);
		if(member != null) {
			// 세션에 정보 저장하기 후
			HttpSession session = request.getSession();
			session.setAttribute("memberId", member.getMemberId());
			session.setAttribute("memberName", member.getMemberName());
			response.sendRedirect("/index.jsp");
			// 마이페이지로 이동해도 됨, 메인페이지로 이동해도 됨(둘 중 선택)
			
		}else {
			// 실패하면 실패페이지
			request.setAttribute("msg", "No Data Found!!!");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp")
			.forward(request, response);
		}
	}

}
