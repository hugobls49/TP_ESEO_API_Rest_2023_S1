package com.dao;

import java.util.List;

import com.dto.Ville;

public interface VilleDAO {

	public List<Ville> findAllVilles();
	
	public Ville findVillebyCodePostal(String ville);

	public void supprimer(Long id);
	
	public Ville updateVille(Long id, Ville ville);
	
	public Ville createVille(Ville ville);

	
}
