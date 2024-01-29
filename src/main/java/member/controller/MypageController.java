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
 * Servlet implementation class MypageController
 */
@WebServlet("/member/myPage.do")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿼리스트링 없이 로그인한 사용자의 아이디를 가져오는 방식으로 진행
		// 로그인한 사용자의 아이디는 세션에 저장되어 있으므로 세션에서
		// 가져오는 방식으로 진행할 것임.
		// 세션에서 아이디를 가져오세요 !!! ================================
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId"); // 강제형번환(String)
		// ================ ↑ 네 =======================================
		MemberService mService = new MemberService();
		Member member = mService.selectOneById(memberId);
		if(member != null) {
			request.setAttribute("member", member);
			request.getRequestDispatcher("/WEB-INF/views/member/myPage.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "No Data Found");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

}
