package bdd;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.MyFile;
import Beans.User;

public class FileDAO {
	
	public static void main (String [] args){
	/*	MyFile f=new MyFile();
		f.setDescrip("HAHA");
		f.setMdp("123456");
		f.setNom("loled");
		f.setTaille(1000);
		f.setType("applcation/text");
		f.setUrl("/hna");
		f.setId_user(5);
		f.setId_container(0);
		System.out.println(f);
		System.out.println("insert into File("+nom+","+type+","+shared+","+url+","+mdp+","+descrip+","+taille+","+id_user+","+id_container+")");
		FileDAO F=new FileDAO();
		F.createFile(f);*/
		//System.out.println("update File set "+nom+"=?,"+type+"=?,"+shared+"=?,"+url+"=?,"+mdp+"=?,"+descrip+"=?,"+taille+"=?,"+nbr_tel+"=? where "+id+"=?");
		FileDAO D=new FileDAO();
		
	

// [id=0, nom=Formulaire_Biometrique.pdf, type=application/pdf, dateCreation=null, 
			//url=MTUtbmFqX3R2NUBnbWFpbC5jb20=/QTovSE9TVEVELzE1LW5hal90djVAZ21haWwuY29tL0Zvcm11bGFpcmVfQmlvbWV0cmlxdWUucGRm, 
			//shared=1, mdp=null, taille=137086, descrip=loli, nbr_tel=0, id_user=15, id_container=44];
			//f.setShared(0);
			//D.updateFile(f);
			MyFile f=new MyFile();
			f.setDescrip("loli");
			f.setType("application/pdf");
			f.setShared(1);
			f.setNom("Formulaire_Biometrique.pdf");
			f.setTaille(137086);
			f.setId_user(15);
			f.setId_container(44);
			f.setUrl("MTUtbmFqX3R2NUBnbWFpbC5jb20=/QTovSE9TVEVELzE1LW5hal90djVAZ21haWwuY29tL0Zvcm11bGFpcmVfQmlvbWV0cmlxdWUucGRm");
			D.createFile(f);
		
		
		//f.setId(26);
		//D.deleteFile(f);
		//System.out.println(D.getURL(27).toString());
	}
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	private static final String id="id_file";
	private static final String	type="type_fich";
	private static final String taille="taille_fich";
	private static final String	dateCreation="date_creation_fich";
	private static final String	shared="shared_fich";
	private static final String url="url_fich";
	private static final String mdp="mdp_fich";
	private static final String nom="nom_fichier" ;
	private static final String descrip="description_fich";
	private static final String id_user="id_user";
	private static final String id_container="id_file_1";
	private static final String nbr_tel="nbr_tel_fich";

	public void createFile(MyFile f){
		String query = "insert into File("+nom+","+type+","+shared+","+url+","+mdp+","+descrip+","+taille+","+id_user+","+id_container+") values(?,?,?,?,?,?,?,?,?)";	
				try{
					connection = ConnectionFactory.getConnection();
					connection.setAutoCommit(false);
					preparedStatement=connection.prepareStatement(query);
					//Problem de prepared statement dans les champs
					
					/*preparedStatement.setString(1, nom);
					preparedStatement.setString(2,type);
					preparedStatement.setString(3,shared);
					preparedStatement.setString(4,url);
					preparedStatement.setString(5,mdp);
					preparedStatement.setString(6,descrip);
					preparedStatement.setString(7,taille);*/
					preparedStatement.setString(1,f.getNom());
					preparedStatement.setString(2,f.getType());
					preparedStatement.setInt(3,f.getShared());
					preparedStatement.setString(4,f.getUrl());
					preparedStatement.setString(5,f.getMdp());
					preparedStatement.setString(6,f.getDescrip());
					preparedStatement.setInt(7,f.getTaille());
					preparedStatement.setInt(8,f.getId_user());
					preparedStatement.setInt(9,f.getId_container());
					preparedStatement.executeUpdate();
					connection.commit();
				}
				catch(SQLException e){
					e.printStackTrace();
					try{
						connection.rollback();
					}catch(SQLException sqle ){
						sqle.printStackTrace();
					}
				}finally {
					if( connection != null){
						try {
							connection.close();
						}catch (SQLException ignore){ignore.printStackTrace();}
					}	
				}
			}
	
	
	public MyFile getFileByUrl(String _url){
		String query = "SELECT * FROM File where "+url+"=?";
		MyFile f = null;
		ResultSet rs = null;
		try {
			connection = ConnectionFactory.getConnection();
			try {
				preparedStatement = connection.prepareStatement(query);
				rs = preparedStatement.executeQuery();
				preparedStatement.setString(1, _url);
				if(rs.next())
						f=FileHelper.getInstance1(rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//preparedStatement.setString(1, id);
			
				
		}finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return f;
		
		
		
	}
	public MyFile getFolder(User user){
		String query = "SELECT * FROM File where "+type+"=\"inode/directory\" and id_user=? and id_file_1=0";
		MyFile f = null;
		ResultSet rs = null;
		try {
			connection = ConnectionFactory.getConnection();
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1,user.getId());
				rs = preparedStatement.executeQuery();
				
				if(rs.next())
						f=FileHelper.getInstance1(rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//preparedStatement.setString(1, id);
			
				
		}finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return f;
		
		
		
	}
	
	
	public Path getURL(int idContainer){
		String p = null;
		String query = "SELECT "+url+" FROM File where "+id+"=?";
		ResultSet rs = null;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(query);
			//preparedStatement.setString(1, id);
			preparedStatement.setInt(1,idContainer);
			rs = preparedStatement.executeQuery();
			while(rs.next()){
				p=new String(rs.getString(1));
				String s="";
				if(p.contains("/")){
					String[] parts=p.split("/",2);
					s=MyFile.decoding(parts[1]);
				}else
					s=MyFile.decoding(p);
				s=Paths.get(s).normalize().toUri().getPath().substring(1);
				p=s.toString();
				System.out.println(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Path path=Paths.get(p);
		return path;
	}
	
	
	
	
	
	public MyFile getFileById(int FileId) throws SQLException {
		String query = "SELECT * FROM File where "+id+"=?";
		ResultSet rs = null;
		MyFile f = null;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(query);
			//preparedStatement.setString(1, id);
			preparedStatement.setInt(1, FileId);
			rs = preparedStatement.executeQuery();
			System.out.println("fuck off");
			if(rs.next())
			f=FileHelper.getInstance1(rs);
		}finally {
			preparedStatement.close();
			rs.close();
		}
		return f;
	}
	
	
	
	
	
	public ArrayList<MyFile> getFileByNom(String nom_f)  {
		String query = "SELECT * FROM File where "+nom+" LIKE '%"+nom_f+"%'";
		ResultSet rs = null;
		ArrayList<MyFile> f = null;
		try {
			connection = ConnectionFactory.getConnection();
			try {
				preparedStatement = connection.prepareStatement(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//preparedStatement.setString(1, nom);
			/*try {
				preparedStatement.setString(1, nom_f);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			try {
				rs = preparedStatement.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				f=FileHelper.getInstance(rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return f;
	}
	
	
	
	
	
	public ArrayList<MyFile> getFileByUser(User user){
		String query = "SELECT * FROM File where "+id_user+"=?";
		ResultSet rs = null;
		ArrayList<MyFile> f = null;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(query);
			//preparedStatement.setString(1, id_userspace);
			preparedStatement.setInt(1, user.getId());
			rs = preparedStatement.executeQuery();
			f=FileHelper.getInstance(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				preparedStatement.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return f;
	}
	
	
	
	
	
	public void updateFile(MyFile f){
		String query = "update File set "+nom+"=?,"+type+"=?,"+shared+"=?,"+url+"=?,"+mdp+"=?,"+descrip+"=?,"+taille+"=?,"+nbr_tel+"=? where "+id+"=?";
		
		try{
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			preparedStatement=connection.prepareStatement(query);
		/*	preparedStatement.setString(1, nom);
			preparedStatement.setString(3,type);
			preparedStatement.setString(5,shared);
			preparedStatement.setString(7,url);
			preparedStatement.setString(9,mdp);
			preparedStatement.setString(11,descrip);
			preparedStatement.setString(13,taille);
			preparedStatement.setString(15,id);*/
			preparedStatement.setString(1,f.getNom());
			preparedStatement.setString(2,f.getType());
			preparedStatement.setInt(3,f.getShared());
			preparedStatement.setString(4,f.getUrl());
			preparedStatement.setString(5,f.getMdp());
			preparedStatement.setString(6,f.getDescrip());
			preparedStatement.setInt(7,f.getTaille());
			preparedStatement.setInt(8,f.getNbr_tel());
			preparedStatement.setInt(9,f.getId());
			preparedStatement.executeUpdate();
			connection.commit();
		}
		catch(SQLException e){
			try{
				connection.rollback();
			}catch(SQLException sqle ){
				sqle.printStackTrace();
			}
		}finally {
			if( connection != null){
				try {
					connection.close();
				}catch (SQLException ignore){}
			}	
		}
	}
	
	
	
	
	
	
	public void deleteFile(MyFile f){
		String query="delete from File where "+id+"=?";
		try{
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setLong(1, f.getId());
			preparedStatement.executeUpdate();
			Path path=null;
			try {
				path=Paths.get(f.decoding(f.getUrl().split("/",2)[1]));
				Files.delete(path);
				
				} catch (NoSuchFileException nsfe) {
				
				System.err.println("Fichier ou repertoire " + path + " n'existe pas");
				
				} catch (DirectoryNotEmptyException dnee) {
				
				System.err.println("Le repertoire " + path + " n'est pas vide");
				
				} catch (IOException ioe) {
				
				System.err.println("Impossible de supprimer " + path + " : " + ioe);
				
				}
			connection.commit();
		}
		catch(SQLException e){
			try{
				connection.rollback();
			}catch(SQLException sqle ){
				sqle.printStackTrace();
			}
		}finally {
			if( connection != null){
				try {
					connection.close();
				}catch (SQLException ignore){}
			}	
		}
	}
	
	
	
}
