package com.fr.adaming.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PerformanceAspect {
//	on peut mettre * pour tout les types de retour, ou bien * a la place des packages. N'importe quelle type d'argument -> ..
//	Pour faire toute les method "* *.*.*(..)"
//  En vrai c'est "retour packages.Classe.method(Arguments)"
//	On peut aussi couvrir toute les ramification de packages par exemple en faisant "com.fr..metier.impl.*calcul()"
	@Pointcut(value = "execution(int com.fr.adaming.metier.impl.*.calcul(..))")
	public void pointCut1() {
	}
	// Method qui sert juste asoutenir l'annotation

	// Dans value c'est soit execution(int
	// com.fr.adaming.metier.impl.PetierImplV5.calcul(..)), soit le nom de la method
	// annoté.
//	@Before(value = "pointCut1()")
//	public void before(JoinPoint method) {
//		System.out.println("MON ASPECT BEFORE TOUT SIMPLEMENT" + method.getSignature());
//		System.out.println(method.);
//	}

	@Pointcut(value = "execution(* com.fr.adaming.presentation.PresentationSpringAnnotation.afficher(..))")
	public void pointCut2() {
	}

//	@After(value = "pointCut2()")
//	public void after() {
//		System.out.println("MON ASPECT AFTER TOUT SIMPLEMENT");
//	}

	@Around(value = "pointCut2()")
	public Object aroundMethod(ProceedingJoinPoint method) throws Throwable {
		long begin = System.nanoTime();
		Object returnedObject = method.proceed();
		long end = System.nanoTime();
		System.out.println("La méthode " + method.getSignature() + "à mis" + (end - begin)+"ns pour s'exécuter");
		return returnedObject; // method around doit retourner un objet, et retourner le reour de la method
								// qu'on proceed. Evidemment
	}

}
