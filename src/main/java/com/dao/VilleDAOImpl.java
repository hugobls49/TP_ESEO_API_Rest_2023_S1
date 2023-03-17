package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO{

	private FactoryDAO factoryDAO = FactoryDAO.getInstance();
	
	public ArrayList<Ville> findAllVilles(){
		
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
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
            	   ville.setLibelle_acheminement(resultSet.getString("Libelle_acheminement"));
            	   ville.setLigne5(resultSet.getString("Ligne_5"));
            	   ville.setLatitude(resultSet.getString("Latitude"));
            	   ville.setLongitude(resultSet.getString("Longitude"));
            	   listVille.add(ville);
               }
               
               statement.close();
               connection.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
		
		System.out.println("findAllVilles");
		return listVille;
	}
	
}
