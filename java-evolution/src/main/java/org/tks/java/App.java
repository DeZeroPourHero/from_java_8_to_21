package org.tks.java;

import org.tks.java.Int.Calculatrice;
import org.tks.java.model.CalculatriceSimple;

/**
 * Classe principale
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	CalculatriceSimple calculatriceSimple = new CalculatriceSimple();
    	System.out.println(calculatriceSimple.additionner(5, 3));
    	System.out.println(calculatriceSimple.multiplier(4, 2));
    	System.out.println(Calculatrice.estPair(10));
    }
}
