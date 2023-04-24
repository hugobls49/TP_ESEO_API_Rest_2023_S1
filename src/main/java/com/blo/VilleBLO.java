package com.blo;

import java.util.List;

import com.dto.Ville;

public interface VilleBLO {

	public List<Ville> getInfoVilles();
	
	public Ville findVillebyCodePostal(String ville);

	public String supprimer(Long id);
	
	public Ville updateVille(Long id, Ville ville);
	
	public Ville createVille(Ville ville);
	
}
