package com.fr.adaming.presentation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fr.adaming.entity.Societe;
import com.fr.adaming.metier.Imetier;

public class PresentationSpring {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		
		//context.getBean(MetierImplV2.class); //par type de bean
		//context.getBean(Imetier.class); //par l'interface
		Imetier metier = context.getBean("metierBean", Imetier.class); //par id
		
		
		System.out.println("Le resultat est :"+metier.calcul());
		
		
		Societe adaming = context.getBean("groupeAdamingBean", Societe.class);
		System.out.println(adaming);
		
		
		context.close();
	}
}
