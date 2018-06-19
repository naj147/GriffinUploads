package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.MyFile;
import Beans.User;
import bdd.FileDAO;
import bdd.UserDAO;

/**
 * Servlet implementation class ServletUser
 */

public class ServletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static String LOGIN = "/pages/examples/login.jsp";
	    private static String VOIR_PROFIL = "/pages/examples/voir-profil.jsp";
	    private static String CHANGER_MDP = "/pages/examples/changer_mdp.jsp"; 
	    private static String CHANGER_PROFIL = "/pages/examples/modif-profil.jsp"; 	    
	    private static String HOME= "/pages/examples/home.jsp"; 

	    private UserDAO userDao;
	    private FileDAO fileDao;


	    public ServletUser() {
	        super();
	        this.userDao = new UserDAO();
	        this.fileDao= new FileDAO();
	    }
	    
	    
	    
	    public float octetToKoctet(int tailleOctet){
	    	return (float)tailleOctet/1024;
	    }
    

	    
	    public static float octetToMega(int tailleOctet){
	    	return (float)tailleOctet/1048576;
	    }
	    
	    
	    public int megaToOctet(int tailleMega){
	    	return tailleMega*1048576;
	    }
	    
	    public void showHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    	
	    	HttpSession session=request.getSession(false);
	    	User userC=(User) session.getAttribute("user");
	    	float taille_max=octetToMega(userC.getTailleMax());
	    	float taille_utilise=octetToMega(userDao.taileCurrent(userC));
    		
	    	int pourcentage=(int) ((float) 100*((float)taille_utilise/taille_max));
	    			
	    	request.setAttribute("pourcentage", pourcentage);
	    	request.setAttribute("taille_max", taille_max);
	    	request.setAttribute("taille_utilise", taille_utilise);
	    	
	    	List<MyFile> files;
    		FileDAO fileManager=new FileDAO();
    		files=fileManager.getFileByUser(userC);
    		Map<Integer,Float> map_taille=new HashMap<Integer,Float>();
    		 for(MyFile f:files){ 
    			 map_taille.put(f.getId(),this.octetToMega(f.getTaille()));
    			 }
    		//users=.getAllUsersU();
    		 request.setAttribute("map_taille", map_taille);
    		request.setAttribute("files", files);
            RequestDispatcher view = request.getRequestDispatcher(HOME);
            view.forward(request, response);

	    	
	    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		

		HttpSession session=request.getSession(false);
		 if(session!=null){
			 User userC=(User) session.getAttribute("user");
			 if(userC!=null && userC.getEtat()==1){
				 String forward="";
			        
			        String action = request.getParameter("action");
			        if(action!=null){
			
				        if (action.equalsIgnoreCase("home")){
				        	showHome(request, response);
				        }
				        else if(action.equalsIgnoreCase("voirProfil")){
				        	float taille=this.octetToMega(userC.getTailleMax());
				        	request.setAttribute("taille",taille);
				        	forward=VOIR_PROFIL;
				        	
				        }
				        else if(action.equalsIgnoreCase("changerProfil")){
				        	forward=CHANGER_PROFIL;
				        	
				        }
				        else if(action.equalsIgnoreCase("changerMdp")){
				        	forward=CHANGER_MDP;
				        } else if (action.equalsIgnoreCase("deconnecter")){    
				            session.invalidate(); 
				        	forward =LOGIN;
				        }else if(action.equalsIgnoreCase("delete")) {
				        	int fileId = Integer.parseInt(request.getParameter("fileId"));
							try {
								fileDao.deleteFile(fileDao.getFileById(fileId));
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							String info="Fichier supprimer!";
							request.setAttribute("info",info);
							this.showHome(request, response);
				        	
				        }else if(action.equalsIgnoreCase("shared")){
				        	int fileId = Integer.parseInt(request.getParameter("fileId"));
				            MyFile file=new MyFile();
							try {
								file=fileDao.getFileById(fileId);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							String info="";
							System.out.println("Before SHARING "+ file.getShared());
							switch(file.getShared()){
							case 0:
								file.setShared(1);
								info="file shared!";
								break;
							case 1:
								file.setShared(0);
								info="file unshared!";
								break;
							
							}
							System.out.println("AFTER SHARING "+ file.getShared());
							fileDao.updateFile(file);
							request.setAttribute("info",info);
							this.showHome(request, response);
							
				        }
				        else{
				        	showHome(request, response);
				        }
				        RequestDispatcher view = request.getRequestDispatcher(forward);
				        view.forward(request, response);
				      
			        }
			        else{
			        	showHome(request, response);
				        RequestDispatcher view = request.getRequestDispatcher(forward);
				        view.forward(request, response);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		 if(session!=null){
			 User userC=(User) session.getAttribute("user");
			 if(userC!=null && userC.getEtat()==1){

				if(request.getParameter("actionName").equals("modifUser")){

					
					String nom=request.getParameter("nom");
					String prenom=request.getParameter("prenom");
					String email=request.getParameter("email");
					User user1 = (User) session.getAttribute("user");
				
					user1.setNom(nom);
					user1.setPrenom(prenom);
					user1.setEmail(email);




					userDao.updateUser(user1);
					 session.setAttribute("user", user1);
						String info="Votre profil a été bien changé";
						request.setAttribute("info",info);
						float taille=this.octetToMega(userC.getTailleMax());
			        	request.setAttribute("taille",taille);
					request.getRequestDispatcher(VOIR_PROFIL ).forward( request, response );
				

			 }
				
				if(request.getParameter("actionName").equals("modifMdp")){
					
					
					
					String mdp=request.getParameter("mdp");
					String mdpA=request.getParameter("mdpA");
				  User user=(User)session.getAttribute("user");
				  if(user.getMdp().equals(mdpA)){
					  user.setMdp(mdp);
					  userDao.updateUser(user);
					  session.setAttribute("user", user);
						String info="Votre mot de passe a été bien changé";
						request.setAttribute("info",info);
			        	float taille=this.octetToMega(userC.getTailleMax());
			        	request.setAttribute("taille",taille);
			        	
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
