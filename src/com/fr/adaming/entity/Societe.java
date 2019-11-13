package com.fr.adaming.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Societe {

	private int id;

	private String nom;

	private List<Employee> developpeurBackEnd;

	private Set<Employee> developpeurFrontEnd;

	private Map<String, Employee> testeurs;

	

	public Societe() {
		super();
	}

	public Societe(int id, String nom, List<Employee> developpeurBackEnd, Set<Employee> developpeurFrontEnd,
			Map<String, Employee> testeurs) {
		super();
		this.id = id;
		this.nom = nom;
		this.developpeurBackEnd = developpeurBackEnd;
		this.developpeurFrontEnd = developpeurFrontEnd;
		this.testeurs = testeurs;
	}

	@Override
	public String toString() {
		return "Societe [id=" + id + ", nom=" + nom + ", developpeurBackEnd=" + developpeurBackEnd
				+ ", developpeurFrontEnd=" + developpeurFrontEnd + ", testeurs=" + testeurs + "]";
	}

}
