package Servlets;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.sql.SQLException;

import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.User;

import bdd.UserDAO;


public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	    private static String EDIT_SPACE = "/pages/examples/modifier_taille_space.jsp";
	    private static String LIST_USER = "/pages/examples/list_user.jsp";	   
	    private static String ADD_ADMIN = "/pages/examples/add_admin.jsp";
	    private static String SHOW_SPACE = "/pages/examples/show_space.jsp";
	    private static String VOIR_PROFIL = "/pages/examples/voir_profil_admin.jsp";
	    private static String CHANGER_PROFIL = "/pages/examples/changer_profil_admin.jsp"; 
	    private static String CHANGER_MDP = "/pages/examples/changer_mdp_admin.jsp"; 
	   private static String LOGIN = "/pages/examples/login.jsp"; 

	    
	    
	    private UserDAO userDao;


	    public ServletAdmin() {
	        super();
	        this.userDao = new UserDAO();
	    }

       
	    public float octetToKoctet(int tailleOctet){
	    	return (float)tailleOctet/1024;
	    }
    

	    
	    public float octetToMega(int tailleOctet){
	    	return (float)tailleOctet/1048576;
	    }
	    
	    
	    public int megaToOctet(int tailleMega){
	    	return tailleMega*1048576;
	    }
	    
	    public void showListUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    		List<User> users;
    		UserDAO userManager=new UserDAO();
    		users=userManager.getAllUsersU();
    		Map<Integer,Float> map_max=new HashMap<Integer,Float>();
    		Map<Integer,Float> map_utilise=new HashMap<Integer,Float>();
    		 for(User u:users){ 
    			 map_max.put(u.getId(),this.octetToMega(u.getTailleMax()));
    			 System.out.println(userDao.taileCurrent(u));
    			 map_utilise.put(u.getId(),this.octetToKoctet(userDao.taileCurrent(u)));
    		 }
    		 

    	    request.setAttribute("map_max",map_max);
    	    request.setAttribute("map_utilise",map_utilise);
    		request.setAttribute("users",users);
    		
            RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
            view.forward(request, response);

	    	
	    }
	    
	    

	    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	

		HttpSession session=request.getSession(false);
		 if(session!=null ){
			 User userAdmin=(User) session.getAttribute("user");
			 if(userAdmin!=null && userAdmin.getEtat()==3){
		
				String forward="";
		        
		        String action = request.getParameter("action");
		        if(action!=null){
		
			        if (action.equalsIgnoreCase("voirSpace")){
			        	forward=SHOW_SPACE;
			            int userId = Integer.parseInt(request.getParameter("userId"));
			            User user=new User();
						try {
							user = userDao.getUserById(userId);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			            request.setAttribute("userShow", user);
			        } else if (action.equalsIgnoreCase("bloquer")){
			            int userId = Integer.parseInt(request.getParameter("userId"));
			            User user=new User();
						try {
							user = userDao.getUserById(userId);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						user.setEtat(0);
						userDao.updateUser(user);
						String info="l'utilisateur "+user.getNom()+" "+user.getPrenom()+"a été bloqué";
						request.setAttribute("info",info);
						this.showListUser(request, response);
		
			        } else if (action.equalsIgnoreCase("debloquer")){
			            int userId = Integer.parseInt(request.getParameter("userId"));
			            User user=new User();
						try {
							user = userDao.getUserById(userId);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						user.setEtat(1);
						userDao.updateUser(user);
						String info="l'utilisateur "+user.getNom()+" "+user.getPrenom()+"a été débloqué";
						request.setAttribute("info",info);
						this.showListUser(request, response);
			        	
			        } else if (action.equalsIgnoreCase("addAdmin")){   
			        	forward = ADD_ADMIN;
			        } else if (action.equalsIgnoreCase("voirProfil")){  
			        	forward =VOIR_PROFIL;
			        } else if (action.equalsIgnoreCase("changerProfil")){  
			        	forward =CHANGER_PROFIL;
			        } else if (action.equalsIgnoreCase("changerMdp")){  
			        	forward =CHANGER_MDP;
			        } else if (action.equalsIgnoreCase("deconnecter")){    
			            session.invalidate(); 
			        	forward =LOGIN;
			        } else if(action.equalsIgnoreCase("changeTaille")){
			            forward = EDIT_SPACE;
			            int userId = Integer.parseInt(request.getParameter("userId"));
			            User user=new User();
						try {
							user = userDao.getUserById(userId);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			            request.setAttribute("userE", user);
			            request.setAttribute("taille", (int	)octetToMega(user.getTailleMax()));
			        }else{
			        	this.showListUser(request, response);
			        	
			        }
			        RequestDispatcher view = request.getRequestDispatcher(forward);
			        view.forward(request, response);
		        }else{
		        	
		        	this.showListUser(request, response);
		        	
		        }
			 }else{
				 request.getRequestDispatcher(LOGIN).forward(request, response);
				 }
			 }
			 
		
		 else
		 {
			 request.getRequestDispatcher(LOGIN).forward(request, response);
		 }


	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session!=null){	
			User userAdmin=(User) session.getAttribute("user");
			 if(userAdmin!=null && userAdmin.getEtat()==3){
			if(request.getParameter("actionName").equals("addAdmin"))
			{
				String nom=request.getParameter("nom");
				String prenom=request.getParameter("prenom");
				String email=request.getParameter("email");
				String mdp=request.getParameter("mdp");
				User user=new User();
				user.setNom(nom);
				user.setPrenom(prenom);
				user.setEmail(email);
				user.setMdp(mdp);
				user.setEtat(3);
				user.setDateCreation(new Date());		
				userDao.createUser(user);
				String info="le nouveau admin a été bien ajoute";
				request.setAttribute("info",info);
		        RequestDispatcher view = request.getRequestDispatcher(ADD_ADMIN);
		        view.forward(request, response);
			}
			if(request.getParameter("actionName").equals("editUserSpace"))
			{
				int userId = Integer.parseInt(request.getParameter("userid"));
				int taille= Integer.parseInt(request.getParameter("taille"));
	            User user=new User();
				try {
					user = userDao.getUserById(userId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				user.setTailleMax(megaToOctet(taille));
				userDao.updateUser(user);
				String info="le taille Max d'espace d'utilisateur "+user.getNom()+" "+user.getPrenom()+"a été changé";
				request.setAttribute("info",info);
				this.showListUser(request, response);
				
			}
			if(request.getParameter("actionName").equals("changerProfil")){
				  User user=(User)session.getAttribute("user");
					String nom=request.getParameter("nom");
					String prenom=request.getParameter("prenom");
					String email=request.getParameter("email");
					user.setNom(nom);
					user.setPrenom(prenom);
					user.setEmail(email);
					userDao.updateUser(user);
					session.setAttribute("user", user);
					String info="Votre profil a été bien changé";
					request.setAttribute("info",info);
			        RequestDispatcher view = request.getRequestDispatcher(VOIR_PROFIL);
			        view.forward(request, response);
					
			}
			if(request.getParameter("actionName").equals("changerMdp")){
					String mdp=request.getParameter("mdp");
					String mdpA=request.getParameter("mdpA");
				  User user=(User)session.getAttribute("user");
				  if(user.getMdp().equals(mdpA)){
					  user.setMdp(mdp);
					  userDao.updateUser(user);
					  session.setAttribute("user", user);
						String info="Votre mot de passe a été bien changé";
						request.setAttribute("info",info);
				        RequestDispatcher view = request.getRequestDispatcher(VOIR_PROFIL);
				        view.forward(request, response);
				  }else{
					  String alert="false";
					  request.setAttribute("alert",alert); 
				        RequestDispatcher view = request.getRequestDispatcher(CHANGER_MDP);
				        view.forward(request, response);
				  }
				  
				
			}
		 }else{
			 request.getRequestDispatcher(LOGIN).forward(request, response);
			 }
		 }
		 
	
	 else
	 {
		 request.getRequestDispatcher(LOGIN).forward(request, response);
	 }
	}
		


}
