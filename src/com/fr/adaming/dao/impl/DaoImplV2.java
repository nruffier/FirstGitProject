package com.fr.adaming.dao.impl;

import org.springframework.stereotype.Repository;

import com.fr.adaming.dao.IDao;

@Repository("daoImplV2")
public class DaoImplV2 implements IDao{
	
	@Override
	public int getValue() {
		return 10;
	}
}
