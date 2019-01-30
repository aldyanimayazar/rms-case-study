package com.mitrais.rms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mitrais.rms.servlet.Models.ImplUsers;
import com.mitrais.rms.servlet.Models.Users;
import com.mitrais.rms.servlet.Models.UsersDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("username");
        String pass = request.getParameter("password");
		UsersDao usersDao = ImplUsers.getInstance();
		List<Users> users = usersDao.authentication(email, pass);
		
		if(users.isEmpty()) {
			response.sendRedirect("login.jsp"); 
		} else {
			HttpSession session = request.getSession(true);
			for (Users getSession : users) {
				session.setAttribute("id", getSession.getId());
				session.setAttribute("firstname", getSession.getFirstname());
				session.setAttribute("lastname", getSession.getLastname());
				session.setAttribute("email", getSession.getEmail());
				response.sendRedirect("users/main");
			}
		}
	}

}
