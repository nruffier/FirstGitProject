package com.fr.adaming.metier.impl;

import com.fr.adaming.dao.IDao;
import com.fr.adaming.metier.Imetier;

public class MetierImplV2 implements Imetier{
	//On va faire ca en dehors de la classe metier, on utilsie les getter et setter
	private IDao dao;
	//= new DaoImplV2();
	
	//l'annotation permet d'etre sur qu'on redifinie correctement les method de l'interface
	@Override
	public int calcul() {
		//On aura besoin de la valeur enrefistrée dans le BD
		
		int nbr = dao.getValue();
		
		return nbr*4;
	}

	public IDao getDao() {
		return dao;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}
	
	
}