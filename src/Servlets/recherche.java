package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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

public class recherche extends HttpServlet{
	private static String LOGIN = "/pages/examples/login.jsp";
	public static final String VUE = "/pages/examples/resultat_recherche.jsp";
	public static final String VISITOR="/pages/examples/resultat_ext.jsp";
	public static final String VUE_ERROR="";
	public static final String CHAMP_EXT_ALLOWED="extension";
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		/* Affichage de la page d'envoi de fichiers */
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		HttpSession session=request.getSession(false);
		 if(session!=null){
			 User userC=(User) session.getAttribute("user");
			 if(userC!=null && userC.getEtat()==1){
				 String[] extensions=request.getParameterValues(CHAMP_EXT_ALLOWED);
				 String fileName=request.getParameter("filename");
				 ArrayList<MyFile> files=MyFile.recherche(extensions,fileName);
				 Iterator<MyFile> file = files.iterator();
				 while(file.hasNext()){
					 MyFile f=file.next();
					 if(f.getId_user()!=userC.getId() && f.getShared()!=1){
						 System.out.println(userC.getId()+"is equal to"+f.getId_user());
						 file.remove();
					 }
				 }
		    		Map<Integer,Float> map_taille=new HashMap<Integer,Float>();
		    		 for(MyFile f:files){ 
		    			 map_taille.put(f.getId(),ServletUser.octetToMega(f.getTaille()));
		    			 }
		    		//users=.getAllUsersU();
		    		 request.setAttribute("map_taille", map_taille);
		    		request.setAttribute("files", files);
		            RequestDispatcher view = request.getRequestDispatcher(VUE);
		            view.forward(request, response);
			 }else{
				 String[] extensions=request.getParameterValues(CHAMP_EXT_ALLOWED);
				 String fileName=request.getParameter("filename");
				 ArrayList<MyFile> files=MyFile.recherche(extensions,fileName);
				 Iterator<MyFile> file = files.iterator();
				 while(file.hasNext()){
					 MyFile f=file.next();
					 if(f.getShared()!=1){
						 file.remove();
					 }
				 }
		    		Map<Integer,Float> map_taille=new HashMap<Integer,Float>();
		    		 for(MyFile f:files){ 
		    			 map_taille.put(f.getId(),ServletUser.octetToMega(f.getTaille()));
		    			 }
		    		//users=.getAllUsersU();
		    		 request.setAttribute("map_taille", map_taille);
		    		request.setAttribute("files", files);
		            RequestDispatcher view = request.getRequestDispatcher(VISITOR);
		            view.forward(request, response);
				 }
			 
		 }else
		 {
			 String[] extensions=request.getParameterValues(CHAMP_EXT_ALLOWED);
			 String fileName=request.getParameter("filename");
			 ArrayList<MyFile> files=MyFile.recherche(extensions,fileName);
			 Iterator<MyFile> file = files.iterator();
			 while(file.hasNext()){
				 MyFile f=file.next();
				 if(f.getShared()!=1){
					 file.remove();
				 }
			 }
	    		Map<Integer,Float> map_taille=new HashMap<Integer,Float>();
	    		 for(MyFile f:files){ 
	    			 map_taille.put(f.getId(),ServletUser.octetToMega(f.getTaille()));
	    			 }
	    		//users=.getAllUsersU();
	    		 request.setAttribute("map_taille", map_taille);
	    		request.setAttribute("files", files);
	            RequestDispatcher view = request.getRequestDispatcher(VISITOR);
	            view.forward(request, response);
		 }
	}
	
}
