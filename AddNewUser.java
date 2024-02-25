package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddNewUser")
public class AddNewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String jspPageToForward = "userInfoPage.jsp";
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String t1 = "fvknlllkllllh";
		String status = (String)session.getAttribute(t1);
		ServletContext context = request.getServletContext();
		HashMap<String, User> userdata = (HashMap<String, User>) context.getAttribute("userdata");
		
		if(userdata == null) {
			userdata = new HashMap<String, User>();
			context.setAttribute("userdata", userdata);
		}

			String user = request.getParameter("user");
			String password = request.getParameter("password");
			
			if(user == null || password == null) {
				jspPageToForward = "addaccount.jsp";
			}
			else {
			
			AccountCheck ac = new AccountCheck();
					
			if(ac.checkAccountNameExistence(user, userdata))
			{
				session.setAttribute(t1, "p4");
				jspPageToForward = "addaccounterror.jsp";
			} else {
				ac.addNewUser(user, password);
				session.setAttribute("user", user);
				session.setAttribute("password", password);
				session.removeAttribute(t1);
			}
			}
		} 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(jspPageToForward);
		dispatcher.forward(request, response);		
	}	

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
