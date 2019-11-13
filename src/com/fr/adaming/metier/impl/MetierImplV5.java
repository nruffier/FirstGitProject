package com.fr.adaming.metier.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.IDao;
import com.fr.adaming.metier.Imetier;


//Exemple d'injection par constructeur paramétré
@Service("metierConstructeur")
public class MetierImplV5 implements Imetier{
	
	private IDao dao;
	
	//l'annotation permet d'etre sur qu'on redifinie correctement les method de l'interface
	@Override
	public int calcul() {
		int nbr = dao.getValue();
		
		return nbr*4;
	}
//Annoté le constructeur
	@Autowired
	public MetierImplV5(
			//Annoté le prametre du constructeur par qualifier
			@Qualifier(value = "daoImplV2")
			IDao dao
			) {
		super();
		this.dao = dao;
	}



	
	

	
}