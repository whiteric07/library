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
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String jspPageToForward = "login.jsp";
		
		
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		HashMap<String, User> userdata = (HashMap<String, User>) context.getAttribute("userdata");
		
		AccountCheck ac = new AccountCheck();
		String AUTO_USER = "AUTO_USER";
		String AUTO_PASSWORD = "AUTO_PASSWORD";
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if (null != cookie.getName() && null != cookie.getValue()) {
					if(AUTO_USER.equals(cookie.getName())){
				    	String value1 = cookie.getValue();
				    	request.setAttribute("cookieuser", value1); 
			    	}   
			    }
			}
		}
		if(cookies != null) {
		    for(Cookie cookie : cookies) {
		    	if (null != cookie.getName() && null != cookie.getValue()) {
		    		if(AUTO_PASSWORD.equals(cookie.getName())){
				    	String value2 = cookie.getValue(); 
				    	request.setAttribute("cookiepassword", value2);  
			    	}
		    	}
			}
		}
		String cookieuser = (String)request.getAttribute("cookieuser");
		String cookiepassword = (String)request.getAttribute("cookiepassword");
		if(cookieuser != null && cookiepassword != null && ac.checkPassword(cookieuser, cookiepassword, userdata) == true) {
			jspPageToForward = "userInfo.jsp";
			
			
		} else {
			
				jspPageToForward = "login.jsp";
				String user = request.getParameter("user");
				String password = request.getParameter("password");
			
				if("".equals(user) && "".equals(password)) {
					jspPageToForward = "loginnodata.jsp";
					
				} else {
					session.setAttribute("user1", user);
					session.setAttribute("password1", password);
					
					String acuser = (String)session.getAttribute("user1");
					String acpassword = (String)session.getAttribute("password1");
					
					if(acuser != null) {
					if(ac.checkAccountNameExistence(acuser, userdata))
					{
						if(ac.checkPassword(acuser, acpassword, userdata))
						{
							jspPageToForward = "userInfo.jsp";
							String login = request.getParameter("login");
							
		   					if ("auto".equals(login)) {
		    					Cookie cookie1 = new Cookie(AUTO_USER, acuser);
		    					Cookie cookie2 = new Cookie(AUTO_PASSWORD, acpassword);
		    					cookie1.setMaxAge(7 * 24 * 60 * 60);
		    					cookie2.setMaxAge(7 * 24 * 60 * 60);
		    					response.addCookie(cookie1);
		    					response.addCookie(cookie2);
		   					}
		   					request.setAttribute("user", user);
							
						} else {
							jspPageToForward = "loginpassworderror.jsp";
						}
							
					} else {
						jspPageToForward = "loginaccounterror.jsp";
					}
				} else {
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
