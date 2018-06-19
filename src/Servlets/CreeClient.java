package Servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Client;


public class CreeClient extends HttpServlet {
	
	public static final String ATT_USER="client";
	public static final String ATT_ERROR="erreurClient";
	//public static final String ATT_SUCCES="resultatClient";
	private String Nom;
	private String Prenom;
	private String Adresse;
	private String Tel;
	private String Email;
	private static String getValeurChamp(HttpServletRequest request,String nomChamp)
	{
		String valeur = request.getParameter(nomChamp);
		if(valeur==null || valeur.trim().length()==0)
			return null;
		return valeur.trim();
	}
	private String erreurSaisie(){
		
		if(Nom==null||Adresse==null||Tel==null)
		return "<p> Erreur - Vous n'avez pas rempli tousl es champs obligatoire <a href=\"creeClient.jsp\">Cliquez ici</a> </p>";
		return "<p>Client Crée avec succès ! </p>";
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		
		
		Nom=getValeurChamp(request,"nomClient");
		Prenom=getValeurChamp(request,"prenomClient");
		Adresse=getValeurChamp(request,"adresseClient");
		Tel=getValeurChamp(request,"telephoneClient");
		Email=getValeurChamp(request,"emailClient");
		

		Client C = new Client(Nom,Prenom,Adresse,Tel,Email);		
		request.setAttribute(ATT_USER, C);
		request.setAttribute(ATT_ERROR,erreurSaisie());
		this.getServletContext().getRequestDispatcher( "/afficherClient.jsp" ).forward( request, response );
	}
	

}