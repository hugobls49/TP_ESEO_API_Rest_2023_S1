package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO{

	private FactoryDAO factoryDAO = FactoryDAO.getInstance();
	
    private static final Logger LOGGER = LoggerFactory.getLogger(VilleDAOImpl.class);
    
    private static final String CONTEXT = "context";  // Compliant
	
	public List<Ville> findAllVilles(){
		
		List<Ville> listVille = new ArrayList<>();
		
        try (
        		Connection connection = factoryDAO.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                   "SELECT * FROM ville_france;");
                ResultSet resultSet = statement.executeQuery()) {
               while (resultSet.next()) {
            	   Ville ville = new Ville();
            	   ville.setCodeCommune(resultSet.getString("Code_commune_INSEE"));
            	   ville.setNomCommune(resultSet.getString("Nom_commune"));
            	   ville.setCodePostal(resultSet.getString("Code_postal"));
            	   ville.setLibelleAcheminement(resultSet.getString("Libelle_acheminement"));
            	   ville.setLigne5(resultSet.getString("Ligne_5"));
            	   ville.setLatitude(resultSet.getDouble("Latitude"));
            	   ville.setLongitude(resultSet.getDouble("Longitude"));
            	   listVille.add(ville);
               }
           } catch (Exception e) {
               LOGGER.error(CONTEXT, e);
           }
		return listVille;
	}

	@Override
	public Ville findVillebyCodePostal(String ville2) {
		
 	   Ville ville = new Ville();
		
        try (
        		Connection connection = factoryDAO.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                   "select * from ville_france where Code_commune_INSEE = " + ville2 + ";");
                ResultSet resultSet = statement.executeQuery()) {
               while (resultSet.next()) {
            	   ville.setCodeCommune(resultSet.getString("Code_commune_INSEE"));
            	   ville.setNomCommune(resultSet.getString("Nom_commune"));
            	   ville.setCodePostal(resultSet.getString("Code_postal"));
            	   ville.setLibelleAcheminement(resultSet.getString("Libelle_acheminement"));
            	   ville.setLigne5(resultSet.getString("Ligne_5"));
            	   ville.setLatitude(resultSet.getDouble("Latitude"));
            	   ville.setLongitude(resultSet.getDouble("Longitude"));
               }
           } catch (Exception e) {
               LOGGER.error(CONTEXT, e);
           }
		return ville;
	}

	@Override
	public void supprimer(Long id) {
	    try (
	        Connection connection = factoryDAO.getConnection();
	        PreparedStatement statement = connection.prepareStatement(
	            "DELETE FROM ville_france WHERE Code_commune_INSEE = ?;")
	    ) {
	        statement.setLong(1, id);
	        statement.executeUpdate();
	    } catch (Exception e) {
            LOGGER.error(CONTEXT, e);
        }
	}
	
	public Ville updateVille(Long id, Ville ville) {
	    Ville updatedVille = null;
	    try (
	        Connection connection = factoryDAO.getConnection();
	        PreparedStatement statement = connection.prepareStatement(
	            "UPDATE ville_france SET Code_commune_INSEE=?, Nom_commune=?, Code_postal=?, Libelle_acheminement=?, Ligne_5=?, Latitude=?, Longitude=? WHERE Code_commune_INSEE=?");
	    ) {
	        statement.setString(1, ville.getCodeCommune());
	        statement.setString(2, ville.getNomCommune());
	        statement.setString(3, ville.getCodePostal());
	        statement.setString(4, ville.getLibelleAcheminement());
	        statement.setString(5, ville.getLigne5());
	        statement.setDouble(6, ville.getLatitude());
	        statement.setDouble(7, ville.getLongitude());
	        statement.setLong(8, id);

	        int rowsUpdated = statement.executeUpdate();
	        if (rowsUpdated == 0) {
	            throw new SQLException("Failed to update Ville with ID: " + id);
	        }
	        updatedVille = ville;
	    } catch (Exception e) {
            LOGGER.error(CONTEXT, e);
        }
	    return updatedVille;
	}

	@Override
	public Ville createVille(Ville ville) {
		try (
			Connection connection = factoryDAO.getConnection();
			PreparedStatement statement = connection.prepareStatement(
				"INSERT INTO ville_france (Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement, Ligne_5, Latitude, Longitude) VALUES (?, ?, ?, ?, ?, ?, ?)");
		) {
			statement.setString(1, ville.getCodeCommune());
			statement.setString(2, ville.getNomCommune());
			statement.setString(3, ville.getCodePostal());
			statement.setString(4, ville.getLibelleAcheminement());
			statement.setString(5, ville.getLigne5());
			statement.setDouble(6, ville.getLatitude());
			statement.setDouble(7, ville.getLongitude());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted == 0) {
				throw new SQLException("Failed to insert Ville into database.");
			}
		} catch (Exception e) {
            LOGGER.error(CONTEXT, e);
        }
		return ville;
	}


}
