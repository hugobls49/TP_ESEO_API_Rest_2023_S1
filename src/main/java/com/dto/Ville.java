package com.dto;

public class Ville {
	
	private String codeCommune;
	private String libelle_acheminement;
	private String Ligne5;
	private String Latitude;
	private String Longitude;
	private String codePostal;
	private String nomCommune;
	
	public Ville() {
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	public String getNomCommune() {
		return this.nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public String getCodeCommune() {
		return codeCommune;
	}

	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}

	public String getLibelle_acheminement() {
		return libelle_acheminement;
	}

	public void setLibelle_acheminement(String libelle_acheminement) {
		this.libelle_acheminement = libelle_acheminement;
	}

	public String getLigne5() {
		return Ligne5;
	}

	public void setLigne5(String ligne5) {
		Ligne5 = ligne5;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}
	
}

