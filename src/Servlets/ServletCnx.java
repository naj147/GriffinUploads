package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.MyFile;
import Beans.User;
import bdd.UserDAO;

/**
 * Servlet implementation class ServletCnx
 */

public class ServletCnx extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   private static String LOGIN = "/pages/examples/login.jsp"; 
	   private static String ADD_USER = "/pages/examples/register.jsp"; 
	   private static int TAILLE=2009700;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCnx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action!=null){
			 if (action.equalsIgnoreCase("addUser")){
			        RequestDispatcher view = request.getRequestDispatcher(ADD_USER);
			        view.forward(request, response);
			 }
	        RequestDispatcher view = request.getRequestDispatcher(LOGIN);
	        view.forward(request, response);
		}
        RequestDispatcher view = request.getRequestDispatcher(LOGIN);
        view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("actionName").equals("login"))
		{
		String email=request.getParameter("email");
		String mdp=request.getParameter("mdp");
		UserDAO us=null;
		User user=null;
		try {
			us=new UserDAO();

			if(email!=null && !email.isEmpty()){
				user=us.getUserByEmail(email);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(user.getEmail()+ " "+ user.getMdp());
		if(user!=null && email!=null && mdp!=null){
		if( user.getEmail().equals(email) && user.getMdp().equals(mdp) && (user.getEtat()==1 || user.getEtat()==3) ){
			HttpSession session=request.getSession();
			 session.setAttribute("user", user);
			// request.getRequestDispatcher("/pages/examples/home.jsp").forward(request, response);
			if(user.getEtat()==1){
			 response.sendRedirect("user");
			 }
			else{
				response.sendRedirect("admin");
			}
		}
		else{
			request.setAttribute("loginResult","false");
			 request.getRequestDispatcher("/pages/examples/login.jsp").forward(request, response);
			
		}
		}
		else{
			request.setAttribute("loginResult","false");
			 request.getRequestDispatcher("/pages/examples/login.jsp").forward(request, response);
			
		}
		}	
		
		
		
		
		if(request.getParameter("actionName").equals("addUser"))
		{
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String email=request.getParameter("email");
		String mdp=request.getParameter("mdp");
		User user=new User();
		User usr=null;
		UserDAO us= new UserDAO();
		if(nom!=null && prenom!=null && email!=null && mdp!=null){
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setEmail(email);
		user.setMdp(mdp);
		user.setEtat(1);
		user.setTailleMax(TAILLE);
		user.setDateCreation(new Date());
		//user.setUrl(MyFile.decoding(MyFile.testCreateDirectory(MyFile.getUserDirectory(user), 0).toUri().getPath().substring(1)));
		System.out.println("rrrrrrrrr");
		try {
			usr=us.getUserByEmail(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("nom"+usr.getNom());
		if(usr==null ){
	
			us.createUser(user);
			try {
				user=us.getUserByEmail(user.getEmail());
				user.setUrl(MyFile.encoding(MyFile.testCreateDirectory(MyFile.getUserDirectory(user),0,user).toUri().getPath().substring(1)));
				us.updateUser(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		request.setAttribute("inscrit","true");
		request.getRequestDispatcher( "/pages/examples/login.jsp" ).forward( request, response );
		}
		else{
			System.out.println("deja");
			request.setAttribute("existdeja","false");
			request.getRequestDispatcher( "/pages/examples/register.jsp" ).forward( request, response );
		}
	
		}
		else{
			
			request.getRequestDispatcher( "/pages/examples/register.jsp" ).forward( request, response );
			
		}


	}
	}

}

