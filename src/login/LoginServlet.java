package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Bean;
import dao.Dao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Dao logindao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	logindao = new Dao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String uname = request.getParameter("userid");
		String passwd = request.getParameter("pwd");
		Bean lb = new Bean();
		lb.setUserName(uname);
		lb.setPassword(passwd);
		boolean valid = logindao.loginCheck(lb);
		if(valid) {
			HttpSession session = request.getSession();
			session.setAttribute("uname", uname);	
			String name = "";
			name = (String)session.getAttribute("uname");
			System.out.println(name);
			getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("loginFail.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
