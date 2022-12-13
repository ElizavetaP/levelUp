package ru.levelup.lesson2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Data
@AllArgsConstructor
public class Employee {
    private String name;
    @NonNull
    private Integer workAge;

    public static void printEmployee(Collection<Employee> employees, int workAge) {
        employees.stream().filter(employee -> employee.getWorkAge() == workAge)
                .forEach(employee -> System.out.println(employee));

    }

    public static List<Employee> fullEmployeeList(Integer minWorkAge, Integer maxWorkAge) {
        List<String> names = List.of("Шершуков Виктор", "Битова Анастасия", "Кириллов Валентин",
                "Игнатьев Игорь", "Самохвалова Наталия", "Павлова Лариса", "Баршев Андрей", "Оверченков Захар",
                "Бодалян Оксана", "Герасимов Александр", "Леденева Софья", "Ватолкина Светлана", "Волик Борис",
                "Архипов Яков", "Гусева Екатерина");
        ArrayList<Employee> employees = new ArrayList<>();
        for (String s : names) {
            employees.add(new Employee(s, ThreadLocalRandom.current().nextInt(minWorkAge, maxWorkAge)));
        }
        return employees;
    }

    public static void deleteOddEmployees(List<Employee> employees) {
        ListIterator<Employee> iterator = employees.listIterator(employees.size());
        int i = 0;
        while (iterator.hasPrevious()) {
            i++;
            iterator.previous();
            if (i % 2 > 0) {
                iterator.remove();
            }
        }
    }

    public static TreeSet<Employee> getEmployeeSet(List<Employee> employees) {
        TreeSet<Employee> employeeSet = new TreeSet<>(Comparator.comparing(Employee::getWorkAge).reversed()
                .thenComparing(Employee::getName));
        employeeSet.addAll(employees);
        return employeeSet;
    }

    public static Set<Employee> unionSet(Set<Employee> employees1, Set<Employee> employees2) {
        Set<Employee> resultEmployees = new HashSet<>(employees1);
        resultEmployees.addAll(employees2);
        return resultEmployees;
    }

    public static Set<Employee> intersectSet(Set<Employee> employees1, Set<Employee> employees2) {
        Set<Employee> resultEmployees = new HashSet<>(employees1);
        resultEmployees.retainAll(employees2);
        return resultEmployees;
    }
}
