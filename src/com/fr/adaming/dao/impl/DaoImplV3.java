package com.fr.adaming.dao.impl;

import org.springframework.stereotype.Repository;

import com.fr.adaming.dao.IDao;

//Si on met par de nom, ce sera le nom de la classe avec une minicsule au debut.
@Repository("daoImplV3")
public class DaoImplV3 implements IDao{
	
	@Override
	public int getValue() {
		return 30;
	}
}
