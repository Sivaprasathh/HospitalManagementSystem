package searchPatient;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Bean;
import dao.Dao;

/**
 * Servlet implementation class PatientSearch
 */
@WebServlet("/search")
public class PatientSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Dao dao;
    private Bean lb;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		dao = new Dao();
		lb = new Bean();
	}
    public PatientSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter ou;
		 ou = response.getWriter(); 
		HttpSession session = request.getSession(false);
	    String url = "/search.jsp";
		String status = request.getParameter("status");
		if(status.equals("view")) {
		int patientid = Integer.parseInt(request.getParameter("pid"));
		lb.setPatientId(patientid);
		if(dao.checkPatientExists(lb)) {  
			session.setAttribute("lb", lb);
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		else {
			 ou.println("<html><body><b>Data not found."
                   + "</b></body></html>");
		}
	}
		else if(status.equals("search")) {
		int deleteDB = dao.delete(lb);
		if(deleteDB == 1) {
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		else {
			 ou.println("<html><body><b>Data not found."
                    + "</b></body></html>");
		}
		}
		else {
			ou.println("<html><body><b>Something went Wrong"
                   + "</b></body></html>");
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
