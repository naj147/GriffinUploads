package Beans;
//INEED TO CREATE A DIRECTORY WHEN CREATING  ACCOUNT FOR THE FIRST TIME :)

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.Part;

import bdd.FileDAO;
import bdd.FileHelper;
import bdd.UserDAO;

public class MyFile {
	private int id;
	private String nom;
	private String type;
	private Date dateCreation;
	private String url;
	private int shared;
	private String mdp;
	private int taille;
	private String descrip;
	private int nbr_tel;
	private int id_user;
	private int id_container;
	
	@Override
	
	//FOR TEST PURPOSES
	public String toString() {
		return "MyFile [id=" + id + ", nom=" + nom + ", type=" + type + ", dateCreation=" + dateCreation + ", url="
				+ url + ", shared=" + shared + ", mdp=" + mdp + ", taille=" + taille + ", descrip=" + descrip
				+ ", nbr_tel=" + nbr_tel + ", id_user=" + id_user + ", id_container=" + id_container + "]";
	}
	

	
	public MyFile(int id, String nom, String type, Date dateCreation, String url, int shared, String mdp, int taille,
			String descrip, int id_user, int id_container, int nbr_tel) {
		super();
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.dateCreation = dateCreation;
		this.url = url;
		this.shared = shared;
		this.mdp = mdp;
		this.taille = taille;
		this.descrip = descrip;
		this.id_user = id_user;
		this.id_container = id_container;
		this.nbr_tel = nbr_tel;
	}
	
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getNbr_tel() {
		return nbr_tel;
	}
	public void setNbr_tel(int nbr_tel) {
		this.nbr_tel = nbr_tel;
	}


	public int getId_container() {
		return id_container;
	}
	public void setId_container(int id_container) {
		this.id_container = id_container;
	}

	
	public MyFile() {
		// TODO Auto-generated constructor stub
	}
	/* 
	 * Date date = new Date();  
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    String strDate= formatter.format(date);  
    System.out.println(strDate); 
    */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getShared() {
		return shared;
	}
	public void setShared(int shared) {
		this.shared = shared;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String s) {
		this.descrip = s;
	}
	
	
	public static final int TAILLE_TAMPON = 10240; // 10 ko
	
	
	public static String getNomFichier( Part part ) {
	    /* Boucle sur chacun des paramètres de l'en-tête "content-disposition". */
		System.out.println(part.getHeader("content-disposition"));
	    for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
	    	/* Recherche de l'éventuelle présence du paramètre "filename". */
	        if ( contentDisposition.trim().startsWith("filename")) {
	            /* Si "filename" est présent, alors renvoi de sa valeur, c'est-à-dire du nom de fichier. */
	            return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
	        }
	    }
	    /* Et pour terminer, si rien n'a été trouvé... */
	    return null;

}
	public static boolean MatchExtension(String fileName,String[] extensions){
		if(extensions!= null && extensions.length!=0){
		for( String extension : extensions){
			if(fileName.matches("(.*)$"+extension)){
					return true;
			}
		}
		}else 
			return true;		
		return false;	
	}
	

	@SuppressWarnings("finally")
	public static int Upload(Part part, String[] extensions, User user,String descrip, int shared,int idContainer){
		 String nomFichier = getNomFichier( part );	 
		 int b=0;
		    /*
		     * Si la méthode a renvoyé quelque chose, il s'agit donc d'un champ
		     * de type fichier (input type="file").
		     */
		 	UserDAO U=new UserDAO();
		 	System.out.println("utilisateur"+user.getNom());
		 	System.out.println("Taille Max :"+user.getTailleMax());
		 	System.out.println("Taille current :"+U.taileCurrent(user));
		 	if(user.getTailleMax()>(U.taileCurrent(user)+part.getSize())){
		    if ( nomFichier != null && !nomFichier.isEmpty() && MatchExtension(nomFichier,extensions) ) {
		        try {
		        	FileDAO D=new FileDAO();
		        	String containerUrl=Paths.get(D.getURL(idContainer).toUri().getPath().substring(1)).toUri().getPath().substring(1);
		        //	System.out.println(nomFichier);
		        //	System.out.println(chemin);
		        //	String userDirectory=HOST_DIRECTORY+getUserDirectory(user);
		        //	System.out.println(Paths.get(Paths.get(userDirectory).resolve(D.getURL(idContainer)).toString()+"/"+nomFichier));
					
		        	MyFile.ecrireFichier( part, nomFichier, containerUrl );
					MyFile f=FileHelper.loadPart(part,user,descrip,shared,idContainer,containerUrl);
					System.out.println("Mon fichier"+f);
					D.createFile(f);
					b=1;
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }else
		    {	b=2;//b=2 ERR MATCHEXTENSION ET NOM FICHIER
		    	
		    }	
		   //     String nomChamp = part.getName();
		   //     request.setAttribute( nomChamp, nomFichier );
		    }else {
		    	b=3;
		    	//GESTION ERREUR TAILLE 
		    }
		    
		    return b;
		 //   this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	//	}
	}
	
	public static void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
	    /* Prépare les flux. */
	    BufferedInputStream entree = null;
	    BufferedOutputStream sortie = null;
	    try {
	        /* Ouvre les flux. */
	        entree = new BufferedInputStream( part.getInputStream(), TAILLE_TAMPON );
	        sortie = new BufferedOutputStream( new FileOutputStream( new File( chemin+nomFichier)),TAILLE_TAMPON );
	        /*
	         * Lit le fichier reçu et écrit son contenu dans un fichier sur le
	         * disque.
	         */
	        byte[] tampon = new byte[TAILLE_TAMPON];
	        int longueur;
	        while ( ( longueur = entree.read( tampon ) ) > 0 ) {
	            sortie.write( tampon, 0, longueur );
	        }
	    } finally {
	        try {
	            sortie.close();
	        } catch ( IOException ignore ) {
	        }
	        try {
	            entree.close();
	        } catch ( IOException ignore ) {
	        }
	    }
	}

	//GESTION DES DIRECTORY ET HASHAGE 
			public static String HOST_DIRECTORY="A:/HOSTED/";
			//creation d'une folder
			public static String getUserDirectory(User user){
				return user.getId()+"-"+user.getEmail();
			}
			/*public static String rooting(int idContainer){
				String root="/";
				
				return root;
			}*/
			public static Path testCreateDirectory(String Directory,int idContainer,User user) throws IOException {
			FileDAO D=new FileDAO();
			Path file=null;
			//String userDirectory=HOST_DIRECTORY+getUserDirectory(user);
			String containerUrl=Paths.get(D.getURL(idContainer).toUri().getPath().substring(1)).toUri().getPath().substring(1);
			String monRepertoire=containerUrl+Directory;
		
				if(Files.notExists(Paths.get(monRepertoire))){
					file = Files.createDirectory(Paths.get(monRepertoire));
					MyFile f=new MyFile();
						f.setId_container(idContainer);
						f.setTaille(0);
						f.setType("inode/directory");
						monRepertoire=MyFile.encoding(getUserDirectory(user))+"/"+MyFile.encoding(monRepertoire);
						System.out.println("Mon repertoire "+monRepertoire);
						f.setUrl(monRepertoire);
						f.setId_user(user.getId());
						D.createFile(f);
			}
			return file;
			}

			public static String encoding(String string){
				Base64.Encoder enc= Base64.getUrlEncoder();
				string =enc.encodeToString(string.getBytes());
				return string;
			}
			public static String decoding(String string){
				Base64.Decoder dec= Base64.getUrlDecoder();
				 
				string = new String (dec.decode(string),StandardCharsets.UTF_8);
				return string;
			}
			public static ArrayList<Path> testDirectoryStream(Path thePath) throws IOException {
				//Path thePath = Paths.get(path);
				ArrayList<Path> p =new ArrayList<Path>();
				try (DirectoryStream<Path> stream = Files.newDirectoryStream(thePath)){
				Iterator<Path> iterator = stream.iterator();
				Path temp;
				ArrayList<Path> temps=new ArrayList<Path>();
				while(iterator.hasNext()) {
					temp=iterator.next();
					
					if(Files.isDirectory(temp)){
						temps=testDirectoryStream(temp);
						if(temps!=null && !temps.isEmpty())
							p.addAll(temps);
						else
							p.add(temp);
					}else
			p.add(temp );
				}
				stream.close();
				}catch (IOException | DirectoryIteratorException e) {
					e.printStackTrace();
				}
				return p;
				}
			public boolean equals(MyFile F){
				if(this.getId()==F.getId())
					return true;
				return false;
				}
			public static ArrayList<MyFile> recherche(String extensions[],String fileName){
				ArrayList<MyFile> F=new ArrayList<MyFile>() ;
				ArrayList<MyFile> tmp=null;
				FileDAO D=new FileDAO();
				
					tmp=D.getFileByNom(fileName);
				
				if(tmp!=null){
					if(extensions!= null && extensions.length!=0){
					for(String extension : extensions){
						Iterator<MyFile> TMP=tmp.iterator();
						while(TMP.hasNext()){
							MyFile t=TMP.next();
							if(extension.contains("application")){
								if(t.getType().contains("text"))
								{
									if(F!=null && !F.contains(t))
									{
										F.add(t);
									}
											
								}
							}
							if(t.getType().contains(extension))
							{
								if(F!=null && !F.contains(t))
								{
									F.add(t);
								}
										
							}
						}
					}
					}
					else
						return tmp;
						
				}
				return F;	
			}
public static void main(String[] args){
/*	User user=new User();
	user.setEmail("ingenieur94@gmail.com");
	user.setId(5);
	String userDirectory=HOST_DIRECTORY+getUserDirectory(user);
	String chemin1 =HOST_DIRECTORY+5+"-"+"ingenieur94@gmail.com"+"/t.txt";
	System.out.println("ha relativité d teb "+Paths.get(userDirectory).relativize(Paths.get(chemin1)));
	FileDAO D=new FileDAO();
	System.out.println(Paths.get(userDirectory).toUri().getPath().substring(1));
	System.out.println(D.getURL(0));
	System.out.println(Paths.get(D.getURL(19).toUri()).toUri().getPath().substring(1));*/
	/*try {
		testCreateDirectory("Tabonmok",0);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	/*String[] extensions ={"image"};
	ArrayList<MyFile> F=recherche(extensions,"Back");
	if(F!=null){
	Iterator<MyFile> f=F.iterator();
	while(f.hasNext()){
		System.out.println(f.next().getNom());
	}
	}*/
	/*
	try {
		MyFile.encoding(MyFile.testCreateDirectory(MyFile.getUserDirectory(user),0,user).toUri().getPath().substring(1));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	//Paths.get(userDirectory).toUri().getPath().substring(1)
	//System.out.println((D.getURL(19)).resolve(userDirectory+"/tremtk").toUri().getPath().substring(1));
	//System.out.println(MyFile.decoding("QTovSE9TVEVELzUtaW5nZW5pZXVyOTRAZ21haWwuY29t"));
	//System.out.println(MyFile.encoding(HOST_DIRECTORY));
	FileDAO D=new FileDAO();
	User user=new User();
	user.setNom("naj");
	user.setPrenom("prenom");
	user.setEmail("naj_tv5@gmail.com");
	user.setMdp("123456");
	user.setEtat(1);
	user.setDateCreation(new Date());
	user.setId(13);
	user.setUrl("QTovSE9TVEVELzEzLW5hal90djVAZ21haWwuY29tLw==");
	System.out.println(user.getUrl());
	
	System.out.println((D.getFolder(user).getId()));
	}	
}
