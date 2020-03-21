package nLambdaExpressions.eFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;

public class Main {

    public static void main(String[] args) {

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
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

        employees.forEach(employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(" ") + 1);
            System.out.println("Last name is: " + lastName);
        });

        /*Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(" ") + 1);
        };*/
        Function<Employee, String> getLastName = (Employee employee) -> employee.getName().substring(employee.getName().indexOf(' ') + 1);

        String lastName = getLastName.apply(employees.get(1));
        System.out.println(lastName);

        Function<Employee, String> getFirstName = (Employee employee) -> employee.getName().substring(0, employee.getName().indexOf(' '));

        Random random = new Random();
        for (Employee employee : employees) {
            if (random.nextBoolean()) {
                System.out.println("Employees first name is: " + getAName(getFirstName,employee));
            } else {
                System.out.println("Employees last name is: " + getAName(getLastName, employee));
            }
        }

    // Chaining FUNCTIONS
        System.out.println("\n************* CHAINING FUNCTIONS ****************");

        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
        // Using .andThen() method the function calling the .andThen() method is executed first and the result
        // is passed as an argument to the argument function of the .andThen() method
        System.out.println("========Using .andThen() method==========");
        Function chainedFunction = upperCase.andThen(firstName);
        employees.forEach(employee -> System.out.println(chainedFunction.apply(employee)));
        System.out.println("========================================");
        // Using .compose() method the argument function of the .compose() method is executed first and the result
        // is passed to the function calling the .compose() method
        System.out.println("\n========Using .compose() method==========");
        Function chainedFunction2 = firstName.compose(upperCase);
        employees.forEach(employee -> System.out.println(chainedFunction2.apply(employee)));
        System.out.println("========================================");

        System.out.println("\n************* BiFunction FUNCTIONS ****************");
        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };
        employees.forEach(employee -> {
            String upperName = upperCase.apply(employee);
            System.out.println(concatAge.apply(upperName, employee));
        });

        System.out.println("\n************* UnaryOperators FUNCTIONS ****************");
        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));

        // Consumers don't return anything so the value of s.toUpperCase() is lost
        // each consumer in the chain is evaluated independently of the other so there is no benefit of
        // chaining consumers together.
        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello, World!");

    // Lambda implementation of MyFunction interface.
        MyFunction myFunction = (String a, int b, double c) -> {
            String returnString = "My name is " + a + " and I am " + b + " meter and " + c + " centimeters tall.";
            returnString = returnString.trim();
            return returnString;
        };
        System.out.println(myFunction.heightDisplay("Anna",1,69.5));
    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);

    }
}



