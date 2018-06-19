package bdd;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.Part;

import Beans.MyFile;
import Beans.User;


public class FileHelper {

	private Connection connection;
	private PreparedStatement preparedStatement;
	
	private static final String nom="nom_fichier" ;
	private static final String id="id_file";
	private static final String	type="type_fich";
	private static final String	dateCreation="date_creation_fich";
	private static final String	shared="shared_fich";
	private static final String mdp="mdp_fich";
	private static final String url="url_fich";
	private static final String descrip="description_fich";
	private static final String  taille="taille_fich";
	private static final String  nbr_tel="nbr_tel_fich";
	private static final String id_container="id_file_1";
	private static final String id_user="id_user";
	
	public static ArrayList<MyFile> getInstance(ResultSet rs) throws SQLException{
		
		ArrayList<MyFile> listfile=new ArrayList<MyFile>();
		while(rs.next()){
			System.out.println("lol");
		listfile.add(getInstance1(rs));
		}
		return listfile;
	}	
	
public static MyFile getInstance1(ResultSet rs) throws SQLException{
		
		MyFile result = new MyFile();
		result.setId(rs.getInt(id));
		result.setNom(rs.getString(nom));
		result.setType(rs.getString(type));
		result.setDateCreation(rs.getDate(dateCreation));
		result.setMdp(rs.getString(mdp));
		result.setUrl(rs.getString(url));
		result.setDescrip(rs.getString(descrip));
		result.setShared(rs.getInt(shared));
		result.setTaille(rs.getInt(taille));
		result.setId_container(rs.getInt(id_container));
		result.setNbr_tel(rs.getInt(nbr_tel));
		result.setId_user(rs.getInt(id_user));
		System.out.println(result.getNom());
		return result;
	}
public static MyFile loadDirectory(String Directory,User user,String description,int shared,int idContainer){
	MyFile folder=new MyFile();
	
	return folder;
}
public static MyFile loadPart(Part part, User user,String description,int shared,int idContainer,String containerUrl){
	MyFile fichier=new MyFile();
	String nomFichier=MyFile.getNomFichier(part);
	fichier.setNom(nomFichier);
	fichier.setTaille((int)part.getSize());
	fichier.setType(part.getContentType());
	System.out.println(Paths.get(containerUrl).resolve(MyFile.getNomFichier(part)).toString());
	fichier.setUrl(new String(MyFile.encoding(user.getId()+"-"+user.getEmail())+"/"+MyFile.encoding(Paths.get(containerUrl).toUri().getPath().substring(1)+nomFichier)));
	fichier.setShared(shared);
	fichier.setDescrip(description);
	fichier.setId_user(user.getId());
	fichier.setId_container(idContainer);
	return fichier;
}

public static boolean downloadFile(String[] parts,User Session){
	FileDAO D=new FileDAO();
	User user=new User();
	int shared;
	int nbr_tel_fich;
	MyFile F;
	if(parts.length!=0){
		int id;
		String firstPart=MyFile.decoding(parts[0]);
		System.out.println("Ha lfirst d teb"+firstPart);
		if(firstPart!=null){
			id=Integer.parseInt(firstPart.split("-",2)[0]);
			System.out.println("ID d zeb "+id);
			user.setId(id);
			Iterator<MyFile> K=D.getFileByUser(user).iterator();
			while(K.hasNext())
				{F=K.next();
				if(F.getUrl().contains(parts[0]) && F.getUrl().contains(parts[1])){
					
					shared =F.getShared();
					nbr_tel_fich=F.getNbr_tel();
					if(shared==1 || Session.getId()==user.getId()){
						System.out.println("avant"+F.getNbr_tel());
						F.setNbr_tel(nbr_tel_fich+1);
						System.out.println("aprés"+F.getNbr_tel());
						D.updateFile(F);
						return true;
					}
				}
			}
		}
	}

	return false;
}
/*public static boolean sharedFile(String[] parts){
	
	return false;
}*/
public static void main(String[] args){
	FileDAO D=new FileDAO();
	System.out.println(5+"-"+"ingenieur94@gmail.com"+"/"+D.getURL(19).toUri().getPath().substring(1)+"tp1.pkt");
	System.out.println(MyFile.encoding(5+"-"+"ingenieur94@gmail.com")+"/"+MyFile.encoding(D.getURL(19).toUri().getPath().substring(1)+"tp1.pkt"));
	
}
}
