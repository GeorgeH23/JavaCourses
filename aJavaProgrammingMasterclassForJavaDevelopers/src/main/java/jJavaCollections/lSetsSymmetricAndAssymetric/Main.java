package jJavaCollections.lSetsSymmetricAndAssymetric;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 0; ++i <= 100; squares.add(i * i), cubes.add(i * i * i), System.out.println("ma pis in sus")) {
            System.out.println("ma pis in jos");
        }

        System.out.println("Squares size is: " + squares.size() + "\nCubes size is: " + cubes.size());
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union size is: " + union.size());

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersection contains " + intersection.size() + " elements.");
        for (int i : intersection) {
            System.out.println(i + " is a square of " + Math.sqrt(i) + " and a cube of " + Math.cbrt(i));
        }

        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));
        for (String s : words) {
            System.out.println(s);
        }

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();

        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "thee"};
        nature.addAll(Arrays.asList(natureWords));
        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("Asymmetric difference:");
        System.out.println("nature - divine:");
        Set<String> dif1 = new HashSet<>(nature);
        dif1.removeAll(divine);
        printSet(dif1);

        System.out.println("divine - nature:");
        Set<String> dif2 = new HashSet<>(divine);
        dif1.removeAll(nature);
        printSet(dif2);

        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);

        System.out.println("Symmetric difference:");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        if (nature.containsAll(divine)) {
            System.out.println("Divine is a subset of nature");
        }

        if (nature.containsAll(intersectionTest)) {
            System.out.println("intersection is a subset of nature");
        }

        if (divine.containsAll(intersectionTest)) {
            System.out.println("intersection is a subset of divine");
        }
    }

    private static void printSet(Set<String> set) {
        System.out.print("\t");
        for (String s : set) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}

