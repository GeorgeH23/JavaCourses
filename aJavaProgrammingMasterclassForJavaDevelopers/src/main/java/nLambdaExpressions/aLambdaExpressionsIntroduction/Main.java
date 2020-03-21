package nLambdaExpressions.aLambdaExpressionsIntroduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Classic way

        new Thread(new CodeToRun()).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing from another runnable.");
            }
        }).start();

        //Lambda way

        new Thread(() -> {System.out.println("Printing from the Lambda Runnable.");
                          System.out.println("Because we can!");
                          System.out.println("And we want to!!!");}).start();

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalke", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        //Usual way

        /*Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });*/

        //Lambda way

        Collections.sort(employees, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

        // OLD WAY
        System.out.println("Old way:");
        String sillyString = doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String str1, String str2) {
                return str1.toUpperCase() + "<->" + str2.toUpperCase();
            }
        }, employees.get(0).getName(),employees.get(1).getName());
        System.out.println(sillyString);

        //LAMBDA WAY
        //Assign lambda expression to variable and use it later "uc"
        System.out.println("Lambda way 1:");
        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + "<->" + s2.toUpperCase();
        String sillyString2 = doStringStuff(uc,employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString2);
        //Pass lambda expression directly to a method
        System.out.println("Lambda way 2:");
        String sillyString3 = doStringStuff(((s1,s2) -> s1.toUpperCase() + "<->" + s2.toUpperCase()), employees.get(2).getName(), employees.get(3).getName());
        System.out.println(sillyString3);
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Printing from the runnable.");
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat(String str1, String str2);
}
