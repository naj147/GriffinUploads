package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Client;

public class error extends HttpServlet {
	
	
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
				this.getServletContext().getRequestDispatcher( "/pages/examples/erreur.jsp" ).forward( request, response );
	}

}
