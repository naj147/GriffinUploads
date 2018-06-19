package Beans;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class Uploading {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*Path monFichier=Paths.get("A:/tmp/");
		boolean estLisible=Files.isReadable(monFichier);
		System.out.println("trouver :"+estLisible);
		System.out.println("peut etre executer :"+Files.isExecutable(monFichier));
		try{
		Uploading.testCreateDirectory();
		}catch(FileAlreadyExistsException e){
			System.out.println("wtv");
		}
		System.out.println("got rid of that shit");
		testAjouterZip(Paths.get("A:/tmp/wtv.zip"));*/
	/*	Path monFichier=Paths.get("A:/HOSTED/");
		for(Path path : testDirectoryStream(monFichier) )
			System.out.println(path);*/
		//Path monFichier=Paths.get("A:/tmp/upld.sql");
		//testAjouterZip(Paths.get("A:/tmp/wtv.zip"),monFichier);	
		String s=encoding("3-naj_tv5@hotmail.com");
		System.out.println(s);
		System.out.println(decoding(s));
	}
public static String HOST_DIRECTORY="A:/HOSTED/";
//creation d'une folder
public static void testCreateDirectory(String Directory,User user) throws IOException {

String userDirectory=user.getId()+"-"+user.getEmail();
Path monRepertoire = Paths.get(HOST_DIRECTORY+userDirectory+"/"+Directory);
Path file = Files.createDirectory(monRepertoire);
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




//Creations de beaucoup de folders
/*public static void testCreateDirectories(String Directory) throws IOException {
Path monRepertoire = Paths.get(Directory);
Path file = Files.createDirectories(monRepertoire);
}*/

//Parcourir les fichiers d'une directory
/*
 * 
 * DirectoryStream.Filter<Path> filtre = new DirectoryStream.Filter<Path>() {
public static final long HUIT_MEGABYTES = 8*1024*1024;
@Override
public boolean accept(Path element) throws IOException {
return Files.size(element) >= HUIT_MEGABYTES;
}
};
on utilise DirectoryStream<Path> stream = Files.newDirectoryStream(jdkPath, filtre); pour activer le filtre
*/

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
		System.out.println("fuck off");
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

//TEMPORARLY DEACTIVATED FOR A BUG PURPOSE

//Cree un fichier zip
private static FileSystem creerZipFileSystem(Path zipFile) throws IOException {
final URI uri = URI.create("jar:file:" + zipFile.toUri().getPath().replaceAll(" ", "%2520"));
final Map<String, String> env = new HashMap<>();
env.put("create", "true");
return FileSystems.newFileSystem(uri, env);
}


//Ajout de fichier dans zipfile
public static void testAjouterZip(Path zipFile,Path src) throws IOException {
final Path pathZip = zipFile;
Files.deleteIfExists(pathZip);
// important : invoquer la méthode close() du FS
try (FileSystem fs = creerZipFileSystem(pathZip)) {
	final Path root = fs.getPath("/");
//iterate over the files we need to add
/*	Path source = Paths.get("A:/tmp/mon_repertoire");
	Path dest = fs.getPath("/", "mon_repertoire");
	Files.copy(source, dest);
	final Path parent = dest.getParent();
	if(Files.notExists(parent)){
		System.out.printf("Creating directory %s\n", parent);
		Files.createDirectories(parent);
	}
	Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
	*/
	//if it's a file
	if(!Files.isDirectory(src)){
		final Path dest =fs.getPath(root.toString(), src.toString());
		final Path parent = dest.getParent();
		if(Files.notExists(parent)){
			Files.createDirectories(parent);
		}
		Files.copy(src, dest,StandardCopyOption.REPLACE_EXISTING);
	}
	else
		{//if it's a directory
		 Files.walkFileTree(src, new SimpleFileVisitor<Path>(){
	          @Override
	          public FileVisitResult visitFile(Path file,BasicFileAttributes attrs) throws IOException {
	            final Path dest = fs.getPath(root.toString(),file.toString());
	            Files.copy(file, dest, StandardCopyOption.REPLACE_EXISTING);
	            return FileVisitResult.CONTINUE;
	          }	 
	          @Override
	          public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
	            final Path dirToCreate = fs.getPath(root.toString(),dir.toString());
	            if(Files.notExists(dirToCreate)){
	              Files.createDirectories(dirToCreate);
	            }
	            return FileVisitResult.CONTINUE;
	          }
	        });
	}
		
		
	}
}
//http://fahdshariff.blogspot.com/2011/08/java-7-working-with-zip-files.html 7ta nrj3
}