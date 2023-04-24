package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO{

	@Autowired
	private VilleDAO villeDAO;
	
	public ArrayList<Ville> getInfoVilles(){
		
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		listVille = villeDAO.findAllVilles();
		
		return listVille;
	}

	@Override
	public Ville findVillebyCodePostal(String ville2) {
		
		Ville ville = villeDAO.findVillebyCodePostal(ville2);
		
		return ville;
	}

	@Override
	public String supprimer(Long id) {

		villeDAO.supprimer(id);
		return "Ville supprimée !";
		
	}

	@Override
	public Ville updateVille(Long id, Ville ville) {

		Ville updateVille = villeDAO.updateVille(id, ville);
		
		return updateVille;
	}

	@Override
	public Ville createVille(Ville ville) {

		Ville newVille = villeDAO.createVille(ville);
		
		return newVille;
	}

}
