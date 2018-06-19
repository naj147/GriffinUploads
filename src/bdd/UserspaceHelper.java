package bdd;

import java.sql.ResultSet;
import java.sql.SQLException;


import Beans.Userspace;

public class UserspaceHelper {
	
	
	private static final String id="id_userspace";
	private static final String	dateCreation="date_creation_esp_ut";
	private static final String	shared="shared_esp_ut";
	private static final String url="url_esp_ut";
	private static final String  taille="taille_max_esp_ut";
	
	public static Userspace getInstance(ResultSet rs) throws SQLException{
		Userspace result = new Userspace();
		result.setId(rs.getLong(id));
		result.setDateCreation(rs.getDate(dateCreation));
		result.setUrl(rs.getString(url));
		result.setShared(rs.getString(shared));
		result.setTaille(rs.getFloat(taille));
		return result;
	}	

}
