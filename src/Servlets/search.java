package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.MyFile;
import Beans.User;

public class search extends HttpServlet {
	
	
	public static String CONNECTER="/pages/examples/recherche-fichier.jsp";
	public static String NONCONNECTER="/pages/examples/recherche_ext.jsp";
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		HttpSession session=request.getSession(false);
		 if(session!=null){
			 User userC=(User) session.getAttribute("user");
			 if(userC!=null && userC.getEtat()==1){
			
				 this.getServletContext().getRequestDispatcher( CONNECTER).forward( request, response );
	
			 }else{
				 this.getServletContext().getRequestDispatcher( NONCONNECTER).forward( request, response );
				 }
			 
		 }else{
			 this.getServletContext().getRequestDispatcher( NONCONNECTER).forward( request, response );
			 }
		 }
			 


}
