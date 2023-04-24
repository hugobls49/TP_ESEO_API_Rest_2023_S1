package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class MainController {

	@Autowired
	VilleBLO villeBLOService;


	@RequestMapping(value="/villes", method=RequestMethod.GET)
	@ResponseBody
	public List<Ville> get(@RequestParam(required = false, value="codePostal") String codePostal) {
	    return villeBLOService.getInfoVilles(); 
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
	    return villeBLOService.updateVille(id, ville);
	}
	
	@PostMapping("/create")
	public Ville create(@RequestBody Ville ville) {
	    return villeBLOService.createVille(ville);
	}
}
