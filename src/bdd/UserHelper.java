package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.User;


public class UserHelper {
	//LE NOM DES CHAMPS USER DANS LA BASE DONNEES AU CAS D'UN CHANGEMENT 
	//IMPREVUE DANS LA BDD IL SUFFIT DE MODIFIER C'EST VARIABLE
	/*private static final String nom="nom_ut" ;
	private static final String id="id_user";
	private static final String	prenom="prenom_ut";
	private static final String	dateNaissance="date_naissance_ut";
	private static final String	email="email_ut";
	private static final String mdp="mdp_ut";
	private static final String etat="etat_ut";
	private static final String pays="pays_ut";
	
	public static User getInstance(ResultSet rs) throws SQLException{
		User result = new User();
		result.setId(rs.getLong(id));
		result.setNom(rs.getString(nom));
		result.setPrenom(rs.getString(prenom));
		result.setDateNaissance(rs.getDate(dateNaissance));
		result.setMdp(rs.getString(mdp));
		result.setEmail(rs.getString(email));
		result.setEtat(rs.getShort(etat));
		result.setPays(rs.getString(pays));
		return result;
	}*/	
}