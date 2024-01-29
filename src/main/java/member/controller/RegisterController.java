package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/member/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// URL로 회원가입 페이지 이동시 사용, WEB-INF 폴더 내 자원들은 직접접근이 불가능함.
		// RequestDispatcher 객체를 이용해서 페이지 이동을 할 수 있음.
		// 변수없이 RequestDispatcher 객체를 이용해서 페이지 이동을 해보면 다음과 같음
		// 메소드 채이닝 방식으로 forward를 호출해야 이동이 되며, 경로상 오타를 조심해야됨
		request.getRequestDispatcher("/WEB-INF/views/member/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입 페이지에서 가입하기 버튼 누르면 동작
		/*
		 * 회원가입은 페이지에서 입력한 값을 서버로 전달받아 Mybatis를 이용하여 수행할 것입니다.
		 * 입력받은 값을 서버에서는 객체 저장하도록 처리합니다. Member VO 클래스가 완성되어 있어야 합니다.
		 * 만들어진 쿼리스트링을 request 객체의 getParameter() 메소드를 이용해서 가져올 수 있습니다.
		 * getParameter() 메소드의 전달값은 register.jsp에서 input태그의 name의 속성값이여야 합니다. 이때 오타 주의해야합니다.
		 * 9개의 변수에 저장한 값은 하나의 변수로 다루기 위해 Member 인스턴스를 생성합니다. 매개변수 있는 생성자를 이용해서
		 * 초기화를 해주면서 객체 생성을 합니다. 이때 memberGender, memberAge는 String이지만 Member VO 멤버변수는 각각
		 * char, int로 되어 있기때문에 String -> char 변환, String -> int로 변환해줘야합니다. 0 인것들을 각각 변환해줘야함
		 * memberGender -> memberGender.charAt(0), memberAge -> Integer.parseInt(memberAge)로 적어주면 됩니다.
		 */
		request.setCharacterEncoding("UTF-8");// 한글 깨지지 않게 해줌
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		String memberName = request.getParameter("member-name");
		String memberGender = request.getParameter("member-gender");
		String memberAge = request.getParameter("member-age");
		String memberEmail = request.getParameter("member-email");
		String memberPhone = request.getParameter("member-phone");
		String memberAddress = request.getParameter("member-address");
		String memberHobby = request.getParameter("member-hobby");
		Member member = new Member(memberId, memberPw, memberName
					, memberGender.charAt(0), Integer.parseInt(memberAge), memberEmail, memberPhone, memberAddress, memberHobby);
		MemberService mService = new MemberService();
		int result = mService.insertMember(member);
		if(result > 0) {
			// 성공하면 메인페이지
			response.sendRedirect("/");
		}else {
			request.setAttribute("msg", "Service Failed!!");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp")
			.forward(request, response);
		}
	}

}
















