package com.mitrais.rms.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class UsersServlet
 */
@WebServlet("/users/*")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersDao usersDao = ImplUsers.getInstance(); // Get users instance
		if(request.getSession(false) != null){
			if("/list".equalsIgnoreCase(request.getPathInfo())) {
				List<Users> users = usersDao.findAll();
				request.setAttribute("USERS_DATA", users);
				RequestDispatcher rs = request.getRequestDispatcher("/views/users/table.jsp");
				rs.forward(request, response);
			}else if("/main".equalsIgnoreCase(request.getPathInfo())) {
				RequestDispatcher rs = request.getRequestDispatcher("/views/users/index.jsp");
				rs.forward(request, response);
			}else if("/read".equalsIgnoreCase(request.getPathInfo())) {
				int usersId = Integer.parseInt(request.getParameter("id"));
				Users users = usersDao.find(usersId);
				request.setAttribute("USERS_DATA", users);
				RequestDispatcher rs = request.getRequestDispatcher("/views/users/read.jsp");
				rs.forward(request, response);
			}else if("/update".equalsIgnoreCase(request.getPathInfo())) {
				int usersId = Integer.parseInt(request.getParameter("id"));
				Users users = usersDao.find(usersId);
				request.setAttribute("USERS_DATA", users);
				RequestDispatcher rs = request.getRequestDispatcher("/views/users/edit.jsp");
				rs.forward(request, response);
			} else if("/create".equalsIgnoreCase(request.getPathInfo())) {
				RequestDispatcher rs = request.getRequestDispatcher("/views/users/create.jsp");
				rs.forward(request, response);
			} 
		} else {
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			response.sendRedirect("/RmsServlet"); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if("/create".equalsIgnoreCase(request.getPathInfo())) {
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			if(password != null) {
				Users users = new Users(firstname, lastname, email, password, phone);
				UsersDao usersDao = ImplUsers.getInstance();
				usersDao.save(users);
			}
			response.sendRedirect("list");
			
		} else if("/update".equalsIgnoreCase(request.getPathInfo())) {
			int usersId = Integer.parseInt(request.getParameter("id"));
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			
			Users users = new Users(usersId,firstname, lastname, email, password, phone);
			UsersDao usersDao = ImplUsers.getInstance();
			usersDao.update(users);
			response.sendRedirect("list");
		} else if("/delete".equalsIgnoreCase(request.getPathInfo())) {
			int usersId = Integer.parseInt(request.getParameter("id"));
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			Users users = new Users(usersId,firstname, lastname, email, password, phone);
			UsersDao usersDao = ImplUsers.getInstance();
			usersDao.delete(users);
			response.sendRedirect("list");
		}		
	}

}
