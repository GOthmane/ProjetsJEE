package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import metier.Client;

public class Dao implements IDao {

	@Override
	public void ajouterClient(Client c) {
		// TODO Auto-generated method stub
		try {
			// 1-Charger le pilote et créer la connexion
			Connection conn = DaoConnexion.getConnection();
			// 3-Créer la requête
			// Le SQL recquiert des simples quotes ' => concaténation pour avoir le bon format
			//PreparedStatement ps = conn.prepareStatement("insert into Client(nom,prenom) VALUES('"+c.getNom()+"','"+c.getPrenom()+"')");
			PreparedStatement ps = conn.prepareStatement("insert into Client(nom,prenom,couleurYeux,age) VALUES(?, ?, ?, ?)");
			//setString transforme automatiquement une chaîne de caractères java en chaîne de caractères
			//au sens de sql (cad entre simple quotes)
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getCouleurYeux());
			ps.setInt(4, c.getAge());
			// 4-Exécuter la requête
			ps.executeUpdate();
			// 5-Présenter les résultats
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		finally {
			//code qui est exécuté dans tous les cas
			// 6- Fermer la connexion
			DaoConnexion.closeConnection();
		}

	}

	@Override
	public void modifierClient(int id, String nom, String prenom, String couleurYeux, int age) {
		// TODO Auto-generated method stub
		try {
			// 1-Charger le pilote et créer la connexion
			Connection conn = DaoConnexion.getConnection();
			// 3-Créer la requête
			// Requête paramétrée à l'aide des ? et des setType
			// l'ordre des numéros dans les setType correspond à celui des ?
			PreparedStatement ps = conn.prepareStatement("update Client set nom = ? , prenom = ?, couleurYeux = ?, age = ? where id = ?");
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setString(3, couleurYeux);
			ps.setInt(4, age);
			ps.setInt(5, id);
			// 4-Exécuter la requête
			ps.executeUpdate();
			// 5-Présenter les résultats
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		finally {
			//code qui est exécuté dans tous les cas
			// 6- Fermer la connexion
			DaoConnexion.closeConnection();
		}
	}

	@Override
	public void supprimerClient(int id) {
		// TODO Auto-generated method stub
		try {
			// 1-Charger le pilote et créer la connexion
			Connection conn = DaoConnexion.getConnection();
			// 3-Créer la requête
			PreparedStatement ps = conn.prepareStatement("delete from client where id="+id);
			// 4-Exécuter la requête
			ps.executeUpdate();
			// 5-Présenter les résultats
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			//code qui est exécuté dans tous les cas
			// 6- Fermer la connexion
			DaoConnexion.closeConnection();
		}

	}

	@Override
	public Collection<Client> listerClients() {
		// TODO Auto-generated method stub
		Collection<Client> cl = new ArrayList<Client>();
		try {
			// 1-Charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
			// 2-Créer la connexion
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients","root","");
			// 3-Créer la requête
			PreparedStatement ps = conn.prepareStatement("select * from client");
			// 4-Exécuter la requête
			ResultSet rs = ps.executeQuery();
			// 5-Présenter les résultats
			while(rs.next())
			{
				Client c = new Client();
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setCouleurYeux(rs.getString("couleurYeux"));
				c.setAge(rs.getInt("age"));
				cl.add(c);
			}
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//code qui est exécuté dans tous les cas
			// 6- Fermer la connexion
			DaoConnexion.closeConnection();
		}
		
		return cl;

	}

	@Override
	public Collection<Client> chercherParMC(String mc) {
		// TODO Auto-generated method stub
		Collection<Client> cl = new ArrayList<Client>();
		try {
			// 1-Charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
			// 2-Créer la connexion
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients","root","");
			// 3-Créer la requête
			// Problème de la casse (minuscule ou majuscule) à traiter dans la couche Presentation
			PreparedStatement ps = conn.prepareStatement("select * from client where nom like ?");
			ps.setString(1, "%"+mc+"%");
			// 4-Exécuter la requête
			ResultSet rs = ps.executeQuery();
			// 5-Présenter les résultats
			while(rs.next())
			{
				Client c = new Client();
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setCouleurYeux(rs.getString("couleurYeux"));
				c.setAge(rs.getInt("age"));
				cl.add(c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			//code qui est exécuté dans tous les cas
			// 6- Fermer la connexion
			DaoConnexion.closeConnection();
		}		
		return cl;
	}

	@Override
	public Client retrouverClient(int id) {
		// TODO Auto-generated method stub
		Client c = new Client();
		try {
			// 1-Charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
			// 2-Créer la connexion
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients","root","");
			// 3-Créer la requête
			PreparedStatement ps = conn.prepareStatement("select * from Client where id= ?");
			ps.setInt(1, id);		
			// 4-Exécuter la requête
			ResultSet rs = ps.executeQuery();
			// 5-Présenter les résultats
			rs.next();
			c.setId(rs.getInt("id"));
			c.setNom(rs.getString("nom"));
			c.setPrenom(rs.getString("prenom"));
			c.setCouleurYeux(rs.getString("couleurYeux"));
			c.setId(rs.getInt("age"));
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//code qui est exécuté dans tous les cas
			// 6- Fermer la connexion
			DaoConnexion.closeConnection();
		}		
		return c;
	}

}
