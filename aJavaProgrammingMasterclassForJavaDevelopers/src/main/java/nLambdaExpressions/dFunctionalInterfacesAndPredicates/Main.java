package nLambdaExpressions.dFunctionalInterfacesAndPredicates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalke", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red RidingHood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

        System.out.println("Employees over 30:");
        System.out.println("========Old Way=========");
        System.out.println("=======================");
        for (Employee employee : employees){
            if (employee.getAge() > 30) {
                System.out.println(employee.getName());
            }
        }

        System.out.println("========Lambda Way=========\n");
        System.out.println("=======================");

        employees.forEach(employee -> {
            if (employee.getAge() > 30) {
                System.out.println(employee.getName());
            }
        });
        System.out.println("=======================\n");

        System.out.println("Employees 30 or younger:");
        System.out.println("=======================");

        employees.forEach(employee -> {
            if (employee.getAge() >= 30) {
                System.out.println(employee.getName());
            }
        });
        System.out.println("=======================");

        System.out.println("\n*******USING PREDICATE**********\n");

        printEmployeesByAge(employees, "Employees over 30:", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "Employees 30 and under:",employee -> employee.getAge() <= 30);

    // The same result using new Predicate interface implementation
        printEmployeesByAge(employees, "Employees younger than 25: ", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

    // Tests if an int predicate is greater than 15
        IntPredicate greaterThan15 = i -> i > 15;
    // Prints true if the int to be tested is greater than 15
        System.out.println(greaterThan15.test(10 + 1));
        int a = 20;
        System.out.println(greaterThan15.test(20 - (Math.addExact(1, 3))));
    // Chaining predicates
        IntPredicate lessThan100 = i -> i < 100;
        System.out.println(greaterThan15.and(lessThan100).test(50));
        System.out.println(greaterThan15.and(lessThan100).test(15));

    // SUPPLIER Interface

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(10));
        }

        Supplier<Integer> randomSupplier = () -> random.nextInt(100);
        for (int i = 0; i < 10; i++) {
            System.out.println(randomSupplier.get());
        }

    }

    private static void printEmployeesByAge (List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("=======================");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
        System.out.println("=======================");
        System.out.println();
    }
}

