package insertPatient;

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
 * Servlet implementation class Servletinsert
 */
@WebServlet("/insert")
public class PatientInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao db ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		db = new Dao();
	}
    public PatientInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 *
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(false);
		String message = "";
        String url = "/create.jsp";
		try {
		int patientSsnId = Integer.parseInt(request.getParameter("ssnid"));
        String patientname = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String dateofadmission  = request.getParameter("date");
        String typeofbed = request.getParameter("bedtype");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        Bean lb = new Bean();
        lb.setPatientSsnId(patientSsnId);
        lb.setPatientName(patientname);
        lb.setAge(age);
        lb.setDateOfAdmission(dateofadmission);
        lb.setTypeOfBed(typeofbed);
        lb.setAddress(address);
        lb.setCity(city);
        lb.setState(state);
        int ret = db.insert(lb);
        if(ret == 1) {
			/*
			 * session.setAttribute("errorMessage", ""); message =
			 * "Patient creation initiated successfully.";
			 * session.setAttribute("successMessage", message);
			 */
        	getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else {
			/*
			 * session.setAttribute("successMessage", ""); message =
			 * "Patient creation initiation failed. Please try again.";
			 * session.setAttribute("errorMessage", message);
			 */
        	 getServletContext().getRequestDispatcher(url).forward(request, response);	 
        }
		}
		catch(Exception e) {
		 message = "Patient creation initiation failed. Please enter correct details.";
       	 session.setAttribute("errorMessage", message);
       	 getServletContext().getRequestDispatcher(url).forward(request, response);
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