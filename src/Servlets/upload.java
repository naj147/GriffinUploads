package Servlets;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import Beans.MyFile;
import Beans.User;
import bdd.FileDAO;
import bdd.UserDAO;

public class upload extends HttpServlet{
		//public static final String ACTION="action";
		public static final String VUE = "/pages/examples/upload-fichier.jsp";
		public static final String VUE_ERROR="";
		public static final String CHAMP_EXT_ALLOWED="extensions";
		public static final String CHAMP_DESCRIPTION = "description";
		public static final String CHAMP_FICHIER     = "fichier";
		public static final String CHAMP_SHARED="shared";
		//CHEMIN FIXED IN SERVLET FOR TEST PURPOSES
		//public static final String CHEMIN        = "chemin";
		public static final String CONTAINER="container";
		public static final int TAILLE_TAMPON = 10240; // 10 ko
		//FOR TEST PURPOSES I FIXED A USER
	public static final FileDAO D=new FileDAO();
		/*public static User user=new User();*/
		
		public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
			/* Affichage de la page d'envoi de fichiers */
			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		}			
		public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		    /*
		     * Lecture du paramètre 'chemin' passé à la servlet via la déclaration
		     * dans le web.xml
		     */
			HttpSession session=request.getSession();
			User user=(User)session.getAttribute("user");
		/*	try {
				user=D.getUserById(5);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			int shared=0;
			System.out.println(request.getParameter(CHAMP_SHARED));
			if(request.getParameter(CHAMP_SHARED)!=null)
			 shared = (request.getParameter(CHAMP_SHARED).equals("1"))? 1:0;
			
			System.out.println("VOILA LE PARTAGE"+shared);
		//	String action = request.getParameter( ACTION );
		  //  String chemin = this.getServletConfig().getInitParameter( CHEMIN );
			/* Récupération du contenu du champ de description */
		    String description = request.getParameter( CHAMP_DESCRIPTION );
		    
		    
		    Integer idContainer =(D.getFolder(user).getId());//ICI L ID de la SESSION
		    
		    
		    if(request.getParameter(CONTAINER)!=null && !request.getParameter(CONTAINER).isEmpty() ){
		    idContainer = Integer.parseInt(request.getParameter(CONTAINER));
		    }
		   // System.out.println("VOILA LE CONTENEUR "+ idContainer);
		 //   request.setAttribute( CHAMP_DESCRIPTION, description );
		    String[] extensions=request.getParameterValues(CHAMP_EXT_ALLOWED);
		    /*
		     * Les données reçues sont multipart, on doit donc utiliser la méthode
		     * getPart() pour traiter le champ d'envoi de fichiers.
		     */
		    Part part = request.getPart( CHAMP_FICHIER );
		   
		    //WHAT I NEED IS THIS
		    
		    System.out.println(part.getContentType());
		    System.out.println(part.getSize());
		    /*
		     * Il faut déterminer s'il s'agit d'un champ classique 
		     * ou d'un champ de type fichier : on délègue cette opération 
		     * à la méthode utilitaire getNomFichier().
		     */
		 //   String nomFichier = MyFile.getNomFichier( part );
		    /*
		     * Si la méthode a renvoyé quelque chose, il s'agit donc d'un champ
		     * de type fichier (input type="file").
		     */
		    int err=MyFile.Upload(part,extensions,user,description ,shared,idContainer) ;
		    System.out.println(err);
		    if ( err==1) {
		        request.setAttribute( "info", "Success!" );
		    }
		    else if(err==2)
		    	request.setAttribute("errFichier", "Erreur de l'extension");
		    else if(err==3)
		    	request.setAttribute("errFichier","Vous avez depasser la taille de votre espace");
		    
		    this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		}
		/*
		 * Méthode utilitaire qui a pour but d'écrire le fichier passé en paramètre
		 * sur le disque, dans le répertoire donné et avec le nom donné.
		 */
		/*
		 * Méthode utilitaire qui a pour but d'écrire le fichier passé en paramètre
		 * sur le disque, dans le répertoire donné et avec le nom donné.
		 */


}
	

