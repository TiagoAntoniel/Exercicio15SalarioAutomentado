package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();
        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + (i + 1 + ":"));
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            while (hasId(list, id)){
                System.out.println("Id already taken! Try again: ");
                id = sc.nextInt();
            }

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            Employee emp = new Employee(id, salary, name);
            list.add(emp);
        }
        System.out.print("Enter the employee Id that will have salary increase: ");
        int idsalary = sc.nextInt();

        Employee pos = list.stream().filter(x -> x.getId() == idsalary).findFirst().orElse(null);
        //Integer pos = position(list, idsalary);
        if (pos == null) {
            System.out.println("This id does not exist");
        } else {
            System.out.print("Enter the percentage of increase: ");
            double percentage = sc.nextDouble();
            pos.increaseSalary(percentage);
        }
        System.out.println();
        System.out.println("List of employees");
        for (Employee funcionario : list) {
            System.out.println(funcionario);
        }

        sc.close();
    }

    public static Integer position(List<Employee> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return i;
            }
        }
        return null;
    }
    public static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}
