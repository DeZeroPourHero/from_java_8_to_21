package org.tks.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.tks.java.Int.Calculateur;

/**
 * Classe principale
 *
 */
public class App {
	public static String message = "Here we see the execution of abstract method";

	public static void main(String[] args) {
		Calculateur calAnonymous = new Calculateur() {

			@Override
			public int operation(int a, int b) {
				return a + b;
			}
		};

		System.out.println(calAnonymous.operation(2, 3) + " Here we have used a anonymous class");

		// Now let's use the lambda expression
		Calculateur calLambda = (a, b) -> a + b;
		System.out.println(calLambda.operation(2, 3) + " Here we have used the lambda expression");

		List<String> noms = Arrays.asList("Steve", "Cedric", "Franna", "Jean");

		Collections.sort(noms, (b, c) -> b.compareTo(c));

		System.out.println(noms);

		// Nombre impair avec predicate
		Predicate<Integer> nombreImpair = x -> x % 2 != 0;
		System.out.println(nombreImpair.test(3)); // true

		// Retourne le prenom de l'auteur supplier
		Supplier<String> prenomAuteur = () -> "Steve";
		System.out.println(prenomAuteur.get());

		// Recuperer l'age de l'auteur avec consumer
		Consumer<Integer> ageUser = x -> System.out.println("L'utilisateur a " + x + " ans");
		ageUser.accept(36);
		// application d'une multiplication par deux pour tout les nombre passés en parametre avec Function
		Function<Integer, Integer> doubleNombre = x -> x*2;
		System.out.println("Le resultat de la multiplication de 4 par 2 est "+doubleNombre.apply(4));
	}
}
