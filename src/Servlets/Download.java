package Servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.MyFile;
import Beans.User;
import bdd.FileHelper;

public class Download extends HttpServlet {
	private static String CHEMIN_ROOT="A:/";
	private static final int DEFAULT_BUFFER_SIZE = 10240; // 10 ko
	private static final User user=new User();//POUR LES TESTS EN ATTENDANT SESSIONS
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	
    	user.setId(5);
    	user.setEmail("ingenieur94@gmail.com");
    	
    	String fichierRequis = request.getPathInfo();
    	//fichierRequis=fichierRequis.substring(1);
    	//fichierRequis = URLDecoder.decode(fichierRequis, "UTF-8");
    	//fichierRequis=MyFile.decoding(fichierRequis);
    	fichierRequis=fichierRequis.substring(1);
    	String[] parts = fichierRequis.split("/",2);
		fichierRequis=parts[1];
		fichierRequis=MyFile.decoding(fichierRequis);
		//System.out.println(fichierRequis);
			
				/* Vérifie qu'un fichier a bien été fourni */
				if (fichierRequis == null || "/".equals(fichierRequis)) {
				//	System.out.println("THIS MEANS ERROR");
					/* Si non, alors on envoie une erreur 404, qui signifie que la ressource demandée n'existe pas */
					response.sendError(HttpServletResponse.SC_NOT_FOUND);
					return;
				}
				/* Lecture du paramètre 'chemin' passé à la servlet via la déclaration dans le web.xml */
				//String chemin = this.getServletConfig().getInitParameter("chemin");
				/* Décode le nom de fichier récupéré, susceptible de contenir des espaces et autres caractères spéciaux, et prépare l'objet File */
				Path monFichier = Paths.get(fichierRequis);
				if (Files.exists(monFichier) && Files.isReadable(monFichier)&&FileHelper.downloadFile(parts,user)) {
					//IS IT A DIRECTORY OR A FILE
					if (Files.isDirectory(monFichier)) {
						//	System.out.println(CHEMIN_ROOT + chemin + fichierRequis);
					//	System.out.println("FOLDER");
						//Creation d'un fichier zip contenant l'ensemble des fichiers de ce repertoire	
					} else if (Files.isRegularFile(monFichier)) {
						/* Initialise la réponse HTTP */
						//System.out.println("WTF");
						String type = Files.probeContentType(monFichier);
						/* Si le type de fichier est inconnu, alors on initialise un type par défaut */
						if (type == null) {
							type = "application/octet-stream";
						}
						response.reset();
						response.setBufferSize(DEFAULT_BUFFER_SIZE);
						response.setContentType(type);
						response.setHeader("Content-Length", String.valueOf(Files.size(monFichier)));
						response.setHeader("Content-Disposition",
								"attachment; filename=\"" + monFichier.getFileName() + "\"");
						BufferedInputStream entree = null;
						BufferedOutputStream sortie = null;
						try {
							entree = new BufferedInputStream(new FileInputStream(monFichier.toFile()),
									DEFAULT_BUFFER_SIZE);
							sortie = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);
							/* Lit le fichier et écrit son contenu dans la réponse HTTP */
							byte[] tampon = new byte[DEFAULT_BUFFER_SIZE];
							int longueur;
							while ((longueur = entree.read(tampon)) > 0) {
								sortie.write(tampon, 0, longueur);
							}
						} finally {
							try {
								sortie.close();
							} catch (IOException ignore) {
							}
							try {
								entree.close();
							} catch (IOException ignore) {
							}
						}
					} else {
						System.out.println("NOPE");
						//ERREUR DE FICHIER NOT REGULAR NOR DIRECTORY
						response.sendError(HttpServletResponse.SC_NOT_FOUND);
						return;

					}

				} else {
					//ERREUR DE FICHIER NON TROUVER DOIT ETRE GERER
				} 
			
		
    	//System.out.println(fichierRequis);
    	
	//	Path monFichier = Paths.get(fichierRequis);
    	/*System.out.println(fichierRequis);
    	String []parts=fichierRequis.split("/", 2);
    	//System.out.println(parts[0]);
    	String userInfo=parts[0];
    	fichierRequis=parts[1];
    	System.out.println(userInfo);
    	System.out.println(fichierRequis);*/
    	
    }
    
    
    
    
}