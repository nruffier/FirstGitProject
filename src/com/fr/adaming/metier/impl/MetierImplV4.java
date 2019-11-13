package com.fr.adaming.metier.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.IDao;
import com.fr.adaming.metier.Imetier;

//Exemple d'injection par accesseur
@Service("metierAccesseur")
public class MetierImplV4 implements Imetier{
	
	
	@Autowired
	@Qualifier("DaoImplV3")
	private IDao dao;
	
	//l'annotation permet d'etre sur qu'on redifinie correctement les method de l'interface
	@Override
	public int calcul() {
		//On aura besoin de la valeur enrefistrée dans le BD
		
		int nbr = dao.getValue();
		
		return nbr*4;
	}

	public MetierImplV4() {
	
	}

	public IDao getDao() {
		return dao;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}

	
	
	
}