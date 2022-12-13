package ru.levelup.lesson2;

import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

        System.out.println("-------task1---------");
        List<Employee> employees = Employee.fullEmployeeList(24, 30);
        System.out.println("fullEmployeeList: ");
        System.out.println(employees);
        int workAge = 25;
        System.out.println("Employees with workAge = " + workAge + ":");
        Employee.printEmployee(employees, workAge);

        Employee.deleteOddEmployees(employees);
        System.out.println("Result of removing odd positions:");
        System.out.println(employees);

        System.out.println("-------task2---------");

        System.out.println("EmployeeSet: ");
        System.out.println(Employee.getEmployeeSet(employees));

        System.out.println("-------task3---------");
        Set<Employee> employees1 = Set.copyOf(Employee.fullEmployeeList(28, 30));
        Set<Employee> employees2 = Set.copyOf(Employee.fullEmployeeList(28, 30));
        System.out.println("employees1: " + employees1);
        System.out.println("employees2: " + employees2);
        System.out.println("inionSet: " + Employee.unionSet(employees1, employees2));

        System.out.println("---------------------------");
        Set<Employee> employees3 = Set.copyOf(Employee.fullEmployeeList(28, 30));
        Set<Employee> employees4 = Set.copyOf(Employee.fullEmployeeList(28, 30));
        System.out.println("employees3: " + employees3);
        System.out.println("employees4: " + employees4);
        System.out.println("intersectSet: " + Employee.intersectSet(employees3, employees4));
    }
}