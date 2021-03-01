package updatePatient;

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
 * Servlet implementation class PatientUpdate
 */
@WebServlet("/update")
public class PatientUpdate extends HttpServlet {
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
    public PatientUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String url = "/update.jsp";
		String status = request.getParameter("status");
		if(status.equals("view")) {
		int patientId = Integer.parseInt(request.getParameter("pid"));
		lb.setPatientId(patientId);
		HttpSession session = request.getSession();
		if(dao.checkPatientExists(lb)) {
			session.setAttribute("lb", lb);
			System.out.println(lb.getTypeOfBed());
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		else {
			 out.println("<html><body><b>Data not found."
                   + "</b></body></html>");
		}
		}
		else if(status.equals("update")) {
			System.out.println("id : "+lb.getPatientId());
	        String patientname = request.getParameter("name");
	        int age = Integer.parseInt(request.getParameter("age"));
	        String dateofadmission  = request.getParameter("date");
	        String typeofbed = request.getParameter("bedtype");
	        String address = request.getParameter("address");
	        String city = request.getParameter("city");
	        String state = request.getParameter("state");
	        lb.setPatientName(patientname);
	        lb.setAge(age);
	        lb.setDateOfAdmission(dateofadmission);
	        lb.setTypeOfBed(typeofbed);
	        lb.setAddress(address);
	        lb.setCity(city);
	        lb.setState(state);
	        int ret = dao.update(lb);
	        if(ret == 1) {
	        	getServletContext().getRequestDispatcher(url).forward(request, response);
	        }
	        else {
				response.setContentType("text/html");
				 out.println("<b>Something went wrong"+ "</b>"); 
	        }
		}
		else {
			response.setContentType("text/html");
			 out.println("<b>Something went wrong"+ "</b>"); 
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
