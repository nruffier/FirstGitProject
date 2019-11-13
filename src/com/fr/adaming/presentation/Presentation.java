package com.fr.adaming.presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import com.fr.adaming.dao.IDao;
import com.fr.adaming.metier.Imetier;

public class Presentation {

	
	public static void main(String[] args) {
		
		//Injection par instanciation statique : (bien mais pas top, on doit quand meme modifier le code source meme si qu'a un endroit)
//		MetierImplV2 metier = new MetierImplV2();
//		metier.setDao(new DaoImplV2());
		
		
		//Instantiation dynamique des calsse et dépendance :
		Scanner sc;
		try {
			File f = new File("src/config.txt");
			System.out.println("DEBUG Chemin du config.txt ="+f.getAbsolutePath());
			sc = new Scanner(f);
		String daoClassName = sc.next();
		System.out.println("DEBUG daoClassName ="+daoClassName);
		String metierClassName = sc.next();
		System.out.println("DEBUG metierClassName ="+metierClassName);
		
		//On utlise la bibliotheque reflexion
		//preparer une référence d'objet de type la class saisie dans le fichier config
		//pour la couche DAO
		//Class.forName("com.fr.adaming.dao.impl.DaoImplV2"); == DaoImplV2 dao = new DaoImplV2()
		Class clazzDao = Class.forName(daoClassName);
		Class clazzMetier = Class.forName(metierClassName);

		//Pour instentier dynamiquement un objet de cette référence "clazzDao"
		IDao daoR = (IDao) clazzDao.getDeclaredConstructor().newInstance();
		Imetier metierR = (Imetier) clazzMetier.getDeclaredConstructor().newInstance();
		
		
		//On recupere la méthode set avec quel entrée pour cette méthode :
		Method methodSetDao = clazzMetier.getMethod("setDao", IDao.class);
		
		methodSetDao.invoke(metierR, daoR); //On veut fiare metierR.setDao(DaoR);
		
		System.out.println("le resultat est "+ metierR.calcul());
		
		
		sc.close();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
