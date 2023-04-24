package com.blo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO{

	@Autowired
	private VilleDAO villeDAO;
	
	public List<Ville> getInfoVilles(){
		return villeDAO.findAllVilles();
	}

	@Override
	public Ville findVillebyCodePostal(String ville2) {
		return villeDAO.findVillebyCodePostal(ville2);
	}

	@Override
	public String supprimer(Long id) {

		villeDAO.supprimer(id);
		return "Ville supprimée !";
		
	}

	@Override
	public Ville updateVille(Long id, Ville ville) {		
		return villeDAO.updateVille(id, ville);
	}

	@Override
	public Ville createVille(Ville ville) {		
		return villeDAO.createVille(ville);
	}

}
