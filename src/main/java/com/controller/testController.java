package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RequestMapping
@RestController
public class testController {

	@Autowired
	VilleBLO villeBLOService;


	@RequestMapping(value="/villes", method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> get(@RequestParam(required = false, value="codePostal") String codePostal) {
	    ArrayList<Ville> ville = villeBLOService.getInfoVilles(); // Exemple de récupération de ville depuis un service BLO
	    return ville;
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
	    String isDeleted = villeBLOService.supprimer(id);
	    if (isDeleted != null) {
	        return "La ville avec l'ID " + id + " a été supprimée.)";
	    } else {
	        return "La ville avec l'ID " + id + " n'a pas été trouvée.";
	    }
	}
	
	@PutMapping("/update/{id}")
	public Ville update(@PathVariable Long id, @RequestBody Ville ville) {
	    Ville updateVille = villeBLOService.updateVille(id, ville);
	    return updateVille;
	}
	
	@PostMapping("/create")
	public Ville create(@RequestBody Ville ville) {
	    Ville createVille = villeBLOService.createVille(ville);
	    return createVille;
	}
}
