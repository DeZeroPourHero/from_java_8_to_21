package org.tks.java.model;

import org.tks.java.Int.Calculatrice;

public class CalculatriceSimple implements Calculatrice{

	@Override
	public int additionner(int a, int b) {
		// Renvoi l'addition de a et b 
		return a + b;
	}

}
