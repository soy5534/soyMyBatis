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
 * Servlet implementation class ModifyController
 */
@WebServlet("/member/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션에서 memberId 가져와주세요
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId"); // (String) 안 해주면 오류발생
		MemberService mService = new MemberService();
		if(memberId != null) {
			Member member = mService.selectOneById(memberId);
			request.setAttribute("member", member);
			request.getRequestDispatcher("/WEB-INF/views/member/modify.jsp").forward(request, response);			
		}else {
			request.setAttribute("msg", "로그인이 필요합니다");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		request.setCharacterEncoding("utf-8"); // 한글 깨지지 않게 해줌
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		String memberEmail = request.getParameter("member-email");
		String memberPhone = request.getParameter("member-phone");
		String memberAddress = request.getParameter("member-address");
		String memberHobby = request.getParameter("member-hobby");
		Member member = new Member(memberId, memberPw, memberEmail, memberPhone, memberAddress, memberHobby);
		MemberService mService = new MemberService();
		result = mService.updateMember(member);
		if(result > 0) {
			// 성공하면 마이페이지로 이동
			response.sendRedirect("/member/myPage.do?memberId="+memberId);
		}else {
			request.setAttribute("msg", "Service Failed!!");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp")
			.forward(request, response);
		}
	}

}
