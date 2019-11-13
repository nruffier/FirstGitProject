package com.fr.adaming;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fr.adaming.presentation.PresentationSpringAnnotation;

public class Application {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.fr.adaming");
		
		PresentationSpringAnnotation presentation = context.getBean("presentationSpringAnnotation", PresentationSpringAnnotation.class);
		
		presentation.afficher();
		
	}

}
