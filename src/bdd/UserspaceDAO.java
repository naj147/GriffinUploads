package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.MyFile;
import Beans.Userspace;

public class UserspaceDAO {
/*	private Connection connection;
	private PreparedStatement preparedStatement;
	
	
	private static final String id="id_userspace";
	private static final String	shared="shared_esp_ut";
	private static final String	dateCreation="date_creation_esp_ut";
	private static final String	taille="taille_max_esp_ut";
	private static final String url="url_esp_ut";

	public void createFile(MyFile f){
		String query = "insert into File(?,?,?,?,?) values(?,?,?,?,?)";	
				try{
					connection = ConnectionFactory.getConnection();
					connection.setAutoCommit(false);
					preparedStatement=connection.prepareStatement(query);
				
					preparedStatement.setString(1,dateCreation);
					preparedStatement.setString(2,shared);
					preparedStatement.setString(3,url);
					preparedStatement.setString(4,taille);
					preparedStatement.setDate(5, f.getDateCreation());
					preparedStatement.setString(6,f.getShared());
					preparedStatement.setString(7,f.getUrl());
					preparedStatement.setFloat(8,f.getTaille());
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
	
	public Userspace getUsrspaceById(int UsrspcId) throws SQLException {
		String query = "SELECT * FROM File where ?=?";
		ResultSet rs = null;
		Userspace space = null;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setInt(2, UsrspcId);
			rs = preparedStatement.executeQuery();
			space=UserspaceHelper.getInstance(rs);
		}finally {
			preparedStatement.close();
			rs.close();
		}
		return space;
	}
	
	public void updateUsrspace(Userspace space){
		String query = "update User set ?=?,?=?,?=?,?=? where ?=?";
		
		try{
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			preparedStatement=connection.prepareStatement(query);
		
			preparedStatement.setString(1,dateCreation);
			preparedStatement.setString(2,shared);
			preparedStatement.setString(3,url);
			preparedStatement.setString(4,taille);
			preparedStatement.setDate(5, space.getDateCreation());
			preparedStatement.setString(6,space.getShared());
			preparedStatement.setString(7,space.getUrl());
			preparedStatement.setFloat(8,space.getTaille());
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

	public void deleteUsrspace(Userspace space){
		String query="delete from User where ?=?";
		try{
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setLong(2, space.getId());
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
	
	*/
	
}
