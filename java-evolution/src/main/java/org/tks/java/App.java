package org.tks.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
		// application d'une multiplication par deux pour tout les nombre passés en
		// parametre avec Function
		Function<Integer, Integer> doubleNombre = x -> x * 2;
		System.out.println("Le resultat de la multiplication de 4 par 2 est " + doubleNombre.apply(4));

		/*
		 * À partir d’une liste d’étudiants :
		 * 
		 * Séparer les étudiants en groupes d’âges : mineurs (<18) et majeurs (≥18)
		 * 
		 * Calculer la moyenne générale des majeurs
		 * 
		 * Lister les étudiants majeurs ayant une moyenne > moyenne des majeurs
		 * 
		 * Afficher la liste triée par nom (A → Z), formatée : Nom (âge) : moyenne
		 * 
		 * Lister les top 2 meilleurs étudiants toutes tranches d’âge confondues
		 */

		List<Student> students = Arrays.asList(new Student("Alice", 19, 14.5), new Student("Bob", 17, 13.0),
				new Student("Charlie", 20, 11.5), new Student("David", 21, 15.0), new Student("Eva", 18, 12.0),
				new Student("Frank", 22, 10.0), new Student("Grace", 16, 17.0));

		List<Student> studentsMineurs = students.stream().filter(s -> s.getAge() < 18).collect(Collectors.toList());
		List<Student> studentsMajeurs = students.stream().filter(s -> s.getAge() >= 18).collect(Collectors.toList());
		Double moyenneStudentMajeur = studentsMajeurs.stream().mapToDouble(s -> s.getAverage()).average().getAsDouble();
		List<Student> studentsAverageSuperieurAtAverage = studentsMajeurs.stream()
				.filter(s -> s.getAverage() > moyenneStudentMajeur).collect(Collectors.toList());
		System.out.println("la liste des étudiants mineurs est "+ studentsMineurs.stream().map(Student::getName).collect(Collectors.toList()));
		System.out.println("la liste des étudiants majeurs est "+ studentsMajeurs.stream().map(Student::getName).collect(Collectors.toList()));
		System.out.println("la moyenne générale des majeurs est: " + moyenneStudentMajeur);
		System.out.println("Liste des étudiants majeurs ayant une moyenne > moyenne des majeurs: "
				+ studentsAverageSuperieurAtAverage.stream().map(Student::getName).collect(Collectors.toList()));
		System.out.println("la liste triée par nom (A → Z), formatée : Nom (âge) : moyenne est: "
				+ studentsAverageSuperieurAtAverage.stream()
						.sorted(Comparator.comparing(Student::getName).thenComparingInt(Student::getAge)
								.thenComparingDouble(Student::getAverage))
						.map(Student::getName).collect(Collectors.toList()));
		System.out.println("Les top 2 meilleurs étudiants toutes tranches d’âge confondues: "
				+ students.stream().sorted(Comparator.comparing(Student::getAverage).reversed()).map(Student::getName)
						.limit(2).collect(Collectors.toList()));
	}
}
