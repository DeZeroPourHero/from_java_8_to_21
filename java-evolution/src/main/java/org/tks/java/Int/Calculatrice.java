package org.tks.java.Int;

public interface Calculatrice {
	
	abstract int additionner(int a, int b);
	
	default int multiplier(int a, int b) {
		return a*b;
	}
	
	static boolean estPair(int a) {
		return a%2 == 0;
	}

}
