package nLambdaExpressions.cLambdaExpressionsNestedBlocks;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalke", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        for (Employee employee : employees) {
            System.out.println(employee.getName());
            new Thread(() -> System.out.println(employee.getAge())).start();
        }

        System.out.println("***************************");

        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        }

        System.out.println("****************************");

        for (Employee employee : employees) {
            System.out.println(employee.getName());
            new Thread(() -> System.out.println(employee.getAge())).start();
        }

        System.out.println("****************************");

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

    }

    public final static String doStringStuff(UpperConcat1 uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }

}

interface UpperConcat1 {
    public String upperAndConcat(String str1, String str2);
}

class AnotherClass {

    public String doSomething() {
        // 1

        /*System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(new UpperConcat1() {
            @Override
            public String upperAndConcat(String str1, String str2) {
                System.out.println("The anonymous class's name is: " + getClass().getSimpleName());
                return str1.toUpperCase() + "<->" + str2.toUpperCase();
            }
        }, "String1", "String2");*/

        // 2

        /*UpperConcat1 uc = (s1, s2) -> {
            System.out.println("The Lambda Expression's class name is: " + getClass().getSimpleName());
            String result = s1.toUpperCase() + "<->" + s2.toUpperCase();
            return result;
        };

        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(uc,"String1", "String2");*/

        // 3
        /*int i = 0;
        {
            UpperConcat1 uc1 = new UpperConcat1() {
                @Override
                public String upperAndConcat(String str1, String str2) {
                    // Won't work to print i unless declared final
                    // System.out.println(i);
                    return str1.toUpperCase() + "<->" + str2.toUpperCase();
                }
            };
            System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());

            i++;
            System.out.println("i = " + i);

            return Main.doStringStuff(uc1,"String1", "String2");
        }*/

        // 4
        int i = 0;
        // increment will not work unless i is declared final
        //i++;

        UpperConcat1 uc = (s1, s2) -> {
            System.out.println("The Lambda Expression's class name is: " + getClass().getSimpleName());
            System.out.println("i int the lambda expression = " + i);
            String result = s1.toUpperCase() + "<->" + s2.toUpperCase();
            return result;
        };

        //s1 = "hello";

        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(uc,"String1", "String2");
    }

    public void printValue() {
        int number = 25;

        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("The value is: " + number);
        };

        new Thread(r).start();
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
