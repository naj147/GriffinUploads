package Servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Client;
import Beans.Commande;

public class CreeCommande extends HttpServlet {
	public static final String ATT_1="Client";
	public static final String ATT_2="Commande";
	public static final String ATT_ERROR="erreurCommande";
//	public static final String ATT_SUCCES="resultatCommande";
	private String Date;
	private String Montant;
	private String ModePaiement;
	private String StatusPaiement;
	private String ModeLivraison;
	private String StatusLivraison;
	private String Nom;
	private String Prenom;
	private String Adresse;
	private String Tel;
	private String Email;
	
	/*
	 * SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	String dateStr = simpleDateFormat.format(new Date());
	System.out.println(dateStr);
	 * 
	 * 
	 * */
private String erreurSaisie(){
		
		if(Montant==null||ModePaiement==null||ModeLivraison==null||Nom==null||Adresse==null||Tel==null)
		return "<p> Erreur - Vous n'avez pas rempli tousl es champs obligatoire <a href=\"${pageContext.request.contextPath}/creeCommande.jsp\">Cliquez ici</a> </p>";
		return "<p>Commande Crée avec succès ! </p>";
	}
	private static String getValeurChamp(HttpServletRequest request,String nomChamp)
	{
		String valeur = request.getParameter(nomChamp);
		if(valeur==null || valeur.trim().length()==0)
			return null;
		return valeur.trim();
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
		Date = simpleDateFormat.format(new Date());
		Montant = getValeurChamp(request , "montantCommande");
		ModePaiement= getValeurChamp(request , "modePaiementCommande");
		StatusPaiement=getValeurChamp(request,"statutPaiementCommande");
		ModeLivraison=getValeurChamp(request,"modeLivraisonCommande");
		StatusLivraison=getValeurChamp(request,"statutLivraisonCommande");
		Commande Commande = new Commande (Date,Montant,ModePaiement,StatusPaiement,ModeLivraison,StatusLivraison);
		Nom=getValeurChamp(request,"nomClient");
		Prenom=getValeurChamp(request,"prenomClient");
		Adresse=getValeurChamp(request,"adresseClient");
		Tel=getValeurChamp(request,"telephoneClient");
		Email=getValeurChamp(request,"emailClient");
		Client C = new Client(Nom,Prenom,Adresse,Tel,Email);
		request.setAttribute(ATT_1, Commande);
		request.setAttribute(ATT_2, C);
		request.setAttribute(ATT_ERROR,erreurSaisie());
		this.getServletContext().getRequestDispatcher( "/WebContent/creeCommande.jsp" ).forward( request, response );
	}
	
}
