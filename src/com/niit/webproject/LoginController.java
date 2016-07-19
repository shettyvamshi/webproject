package com.niit.webproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		
		LoginDAO logindao =new LoginDAO();
		
		RequestDispatcher dispatcher;
		
		if(logindao.isValidUser(userid,password)==true){
			dispatcher = request.getRequestDispatcher("home.html");
			dispatcher.forward(request, response);
		}
		else{
			dispatcher = request.getRequestDispatcher("login.html");
			PrintWriter w= response.getWriter();
			w.append("<h3> invalid credentials");
			dispatcher.include(request, response);
			
		}
	}

}
