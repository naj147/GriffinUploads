package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Beans.User;

public class UserDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	private static final String id="id_user";
	private static final String nom="nom_ut" ;
	private static final String	prenom="prenom_ut";
	private static final String	email="email_ut";
	private static final String mdp="mdp_ut";
	private static final String etat="etat_ut";
	private static final String url="url_esp_ut";
	private static final String dateCreation="date_creation_ut";
	private static final String tailleMax="taille_max_ut";
	

	public void createUser(User user){
String query = "insert into user(nom_ut,prenom_ut,email_ut,mdp_ut,etat_ut,url_esp_ut,date_creation_ut,taille_max_ut) values(?,?,?,?,?,?,?,?)";	
		try{
			connection = ConnectionFactory.getConnection();
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,user.getNom());
			preparedStatement.setString(2,user.getPrenom());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4,user.getMdp());
			preparedStatement.setInt(5,user.getEtat());
			preparedStatement.setString(6,user.getUrl());
			preparedStatement.setDate(7,new java.sql.Date(user.getDateCreation().getTime()));
			preparedStatement.setInt(8,user.getTailleMax());
			preparedStatement.executeUpdate();
		}
		catch(SQLException e){

		}finally {
			if( connection != null){
				try {
					connection.close();
				}catch (SQLException ignore){}
			}	
		}	
	}
	
	public User getUserById(int userId) throws SQLException {
	    User user = new User();
		String query = "SELECT * FROM User where id_user=?";
		ResultSet rs = null;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt(id));
				user.setNom(rs.getString(nom));
				user.setPrenom(rs.getString(prenom));
				user.setEmail(rs.getString(email));
				user.setMdp(rs.getString(mdp));
				user.setUrl(rs.getString(url));
				user.setDateCreation(rs.getDate(dateCreation));
				user.setTailleMax(rs.getInt(tailleMax));
				user.setEtat(rs.getInt(etat));
			}		
		}
		catch (SQLException e) {
          e.printStackTrace();
      }
		finally {
			preparedStatement.close();
			rs.close();
		}
		return user;
	}
	

	public User getUserByEmail(String userEmail) throws SQLException {
		String query = "SELECT * FROM user where email_ut=?";
		ResultSet rs = null;
		User user = null;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userEmail);
			rs = preparedStatement.executeQuery();
			if ( rs!=null && rs.next()) {
				user=new User();
				user.setId(rs.getInt(id));
				user.setNom(rs.getString(nom));
				user.setPrenom(rs.getString(prenom));
				user.setEmail(rs.getString(email));
				user.setMdp(rs.getString(mdp));
				user.setUrl(rs.getString(url));
				user.setDateCreation(rs.getDate(dateCreation));
				user.setTailleMax(rs.getInt(tailleMax));
				user.setEtat(rs.getInt(etat));
			}
		}
			catch (SQLException e) {
		          e.printStackTrace();
		      }
		finally {
			preparedStatement.close();
			if(rs!=null)
			rs.close();
		}
		return user;
	}
	
	
	public void updateUser(User user){
		String query = "update User set nom_ut=?,prenom_ut=?,email_ut=?,mdp_ut=?,url_esp_ut=?,date_creation_ut=?,taille_max_ut=?,etat_ut=? where id_user=?";
		
		try{
			connection = ConnectionFactory.getConnection();
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,user.getNom());
			preparedStatement.setString(2,user.getPrenom());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4,user.getMdp());
			preparedStatement.setString(5,user.getUrl());
			preparedStatement.setDate(6, new java.sql.Date(user.getDateCreation().getTime()));
			preparedStatement.setInt(7,user.getTailleMax());
			preparedStatement.setInt(8, user.getEtat());
			preparedStatement.setInt(9, user.getId());
			preparedStatement.executeUpdate();
		}
		catch(SQLException e){

		}finally {
			if( connection != null){
				try {
					connection.close();
				}catch (SQLException ignore){}
			}	
		}
	}
	
	public void deleteUser(User user){
		String query="delete from User where id_user=?";
		try{
			connection = ConnectionFactory.getConnection();
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.executeUpdate();
		}
		catch(SQLException e){

		}finally {
			if( connection != null){
				try {
					connection.close();
				}catch (SQLException ignore){}
			}	
		}
		
		
		
	}
	
	
	
  public List<User> getAllUsers() {
  List<User> users = new ArrayList<User>();
  try {
	connection = ConnectionFactory.getConnection();
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery("select * from user");
      while (rs.next()) {
         User user = new User();
		user.setId(rs.getInt(id));
		user.setNom(rs.getString(nom));
		user.setPrenom(rs.getString(prenom));
		user.setEmail(rs.getString(email));
		user.setMdp(rs.getString(mdp));
		user.setUrl(rs.getString(url));
		user.setDateCreation(rs.getDate(dateCreation));
		user.setTailleMax(rs.getInt(tailleMax));
		user.setEtat(rs.getInt(etat));
        users.add(user);
      }
  } catch (SQLException e) {
      e.printStackTrace();
  }

  return users;
}

	
	
  public List<User> getAllUsersU() {
  List<User> users = new ArrayList<User>();
  try {
	connection = ConnectionFactory.getConnection();
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery("select * from user where etat_ut=1 or etat_ut=0");
      while (rs.next()) {
         User user = new User();
		user.setId(rs.getInt(id));
		user.setNom(rs.getString(nom));
		user.setPrenom(rs.getString(prenom));
		user.setEmail(rs.getString(email));
		user.setMdp(rs.getString(mdp));
		user.setUrl(rs.getString(url));
		user.setDateCreation(rs.getDate(dateCreation));
		user.setTailleMax(rs.getInt(tailleMax));
		user.setEtat(rs.getInt(etat));
        users.add(user);
      }
  } catch (SQLException e) {
      e.printStackTrace();
  }

  return users;
}


  public int taileCurrent(User user){
		int taille=0;
String query = "select SUM(taille_fich) as taille from file JOIN user on file."+id+"=user."+id +" where user."+id+"=?";
		
		try{
			connection = ConnectionFactory.getConnection();
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, user.getId());
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()){
				taille=rs.getInt(1);
			}
		}
		catch(SQLException e){

		}finally {
			if( connection != null){
				try {
					connection.close();
				}catch (SQLException ignore){}
			}	
		}
		return taille;
	}








}
