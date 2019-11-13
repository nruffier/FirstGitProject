package com.fr.adaming.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

import com.fr.adaming.metier.Imetier;

@Component
public class PresentationSpringAnnotation {

	@Autowired
	@Qualifier("metierAccesseur")
	private Imetier metierAccesseur;
	
	@Autowired
	@Qualifier("metierConstructeur")
	private Imetier metierConstructeur;
	
	public void afficher() {
		System.out.println(metierAccesseur.calcul());
		System.out.println(metierConstructeur.calcul());
	}
		
	
}
